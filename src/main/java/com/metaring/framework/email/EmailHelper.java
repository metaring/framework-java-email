/**
 *    Copyright 2019 MetaRing s.r.l.
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.metaring.framework.email;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.metaring.framework.Core;
import com.metaring.framework.SysKB;
import com.metaring.framework.exception.ManagedException;
import com.metaring.framework.functionality.UnmanagedException;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.util.CryptoUtil;

class EmailHelper {

    private static final String CFG_CONTROLLER = "controller";
    private static final String CFG_TEMPLATES_FOLDER = "templatesFolder";


    private static final String EMAIL_TEMPLATES_MODULE_INFO_CLASS_NAME = "com.metaring.framework.email.EmailTemplatesModuleInfo";
    protected static final String TEMPLATE_TYPE_SUBJECT = "_subject";
    protected static final String TEMPLATE_TYPE_MESSAGE = "_message";
    private static final String TEMPLATES_EXTENSION = ".stg";
    protected static EmailContact DEFAULT_EMAIL_SENDER;
    protected static final Map<String, STGroup> EMAIL_TEMPLATES = new HashMap<String, STGroup>();
    private static boolean MAIL_TEST;
    private static EmailController EMAIL_CONTROLLER;

    static {
        reinit();
    }

    public static void reinit() {
        if(EMAIL_CONTROLLER != null) {
            EMAIL_CONTROLLER.shutdown();
        }
        EMAIL_CONTROLLER = null;
        DEFAULT_EMAIL_SENDER = null;
        EMAIL_TEMPLATES.clear();
        MAIL_TEST = false;
        setParameters();
    }

    private static void setParameters() {
        SysKB sysKB = Core.SYSKB;
        if(!sysKB.hasProperty(EmailController.CFG_EMAIL)){
            return;
        }
        DataRepresentation email = sysKB.get(EmailController.CFG_EMAIL);

        loadEmailTemplates();
        MAIL_TEST = false;
        try {
            MAIL_TEST = email.getTruth(EmailController.CFG_TEST);
        }
        catch(Exception e) {
        }
        if(!email.hasProperty(EmailController.CFG_SENDER)) {
            return;
        }
        DEFAULT_EMAIL_SENDER = email.get(EmailController.CFG_SENDER, EmailContact.class);
        initController(sysKB);
    }

    @SuppressWarnings("unchecked")
    private static void initController(SysKB sysKB) {
        if(!sysKB.hasProperty(EmailController.CFG_EMAIL)) {
            return;
        }
        DataRepresentation emailConfiguration = sysKB.get(EmailController.CFG_EMAIL);
        String className = JavaMailController.class.getName();
        if(emailConfiguration.hasProperty(CFG_CONTROLLER)) {
            className = emailConfiguration.getText(CFG_CONTROLLER);
        }
        Class<? extends EmailController> clazz = null;
        try {
            clazz = (Class<? extends EmailController>) Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("An error occurred while creating class " + className, e);
        }
        try {
            EMAIL_CONTROLLER = clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            throw new IllegalArgumentException("An error occurred while trying to access to init " + className, e);
        }
        if(EMAIL_CONTROLLER != null) {
            EMAIL_CONTROLLER.reinit(sysKB);
        }
    }

    private static final void loadEmailTemplates() {

        Class<?> templatesModuleClass = null;
        try {
            templatesModuleClass = Class.forName(EMAIL_TEMPLATES_MODULE_INFO_CLASS_NAME);
        }
        catch(Exception e) {
        }

        if(templatesModuleClass == null) {
            return;
        }

        try {
            File templatesFolder = new File(Core.SYSKB.get(EmailController.CFG_EMAIL).getText(CFG_TEMPLATES_FOLDER));
            File[] templates = templatesFolder.listFiles((path, name) -> name.toLowerCase().endsWith(TEMPLATES_EXTENSION));
            String charset = CryptoUtil.CHARSET_UTF_8.toString();
            for (File template : templates) {
                String key = template.getName();
                key = key.substring(0, key.lastIndexOf(46));
                EMAIL_TEMPLATES.put(key, new STGroupFile(template.getAbsolutePath(), charset));
            }
        } catch (Exception e) {
        }
    }

    public static EmailContentFromTemplate getEmailContentFromTemplate(SingleEmailTemplate singleEmailTemplate) {
        STGroup templateGroup = EMAIL_TEMPLATES.get(singleEmailTemplate.getLanguage().getTextualValue());
        String subject = getFilledByTemplate(templateGroup, singleEmailTemplate, TEMPLATE_TYPE_SUBJECT);
        String message = getFilledByTemplate(templateGroup, singleEmailTemplate, TEMPLATE_TYPE_MESSAGE);
        EmailContentFromTemplate mailContentFromTemplate = EmailContentFromTemplate.create(subject, message, singleEmailTemplate.getLanguage());
        return mailContentFromTemplate;
    }

    public static String getFilledByTemplate(STGroup emailTemplateGroup, SingleEmailTemplate singleEmailTemplate, String emailTemplateType) {
        ST template = getTemplateByName(emailTemplateGroup, singleEmailTemplate.getTemplateName(), emailTemplateType);
        return getFilledByTemplate(emailTemplateGroup, template, singleEmailTemplate.getArguments());
    }

    public static String getFilledByTemplate(STGroup emailTemplateGroup, ST template, EmailTemplateArgumentSeries emailTemplateArgumentSeries) {
        String filledTemplateAsString = getFilledTemplateAsString(template, emailTemplateArgumentSeries);
        String filledTemplate = filledTemplateAsString;
        return filledTemplate;
    }

    public static String getFilledTemplateAsString(ST template, EmailTemplateArgumentSeries emailTemplateArgumentSeries) {
        if (emailTemplateArgumentSeries != null && emailTemplateArgumentSeries.size() > 0) {
            for (EmailTemplateArgument mailTemplateArgument : emailTemplateArgumentSeries) {
                try {
                    final DataRepresentation value = mailTemplateArgument.getValue();
                    String names = new StringJoiner(".").add(mailTemplateArgument.getName()).add(new StringJoiner(",", "{", "}").add(String.join(",", value.getProperties())).toString()).toString();
                    Object[] values = value.getProperties().stream().map(current -> value.getText(current)).toArray();
                    template.addAggr(names, values);
                } catch (Exception e) {
                }
            }
        }
        String filledTemplateAsString = template.render();
        return filledTemplateAsString;
    }

    public static ST getTemplateByName(STGroup emailTemplateGroup, String emailTemplate, String emailTemplateType) {
        String completeEmailTemplateName = emailTemplate + emailTemplateType;
        completeEmailTemplateName = completeEmailTemplateName.toLowerCase();
        return emailTemplateGroup.getInstanceOf(completeEmailTemplateName);
    }

    public static void send(EmailMessage emailMessage) throws ManagedException, UnmanagedException {
        send(EmailMessageSeries.create(emailMessage));
    }

    public static void sendSingleEmail(SingleEmail singleEmail) throws ManagedException, UnmanagedException {
        EmailContentFromTemplate mailContentFromTemplate = getEmailContentFromTemplate(singleEmail.getTemplate());
        EmailMessage emailMessage = EmailMessage.create(DEFAULT_EMAIL_SENDER, singleEmail.getTos(), singleEmail.getCcs(), singleEmail.getBccs(), mailContentFromTemplate.getSubject(), EmailTypeEnumerator.HTML, mailContentFromTemplate.getMessage());
        send(emailMessage);
    }

    public static void send(EmailMessageSeries emailMessageSeries) throws ManagedException, UnmanagedException {
        if (MAIL_TEST) {
            System.out.println(emailMessageSeries.toJson());
        }
        EMAIL_CONTROLLER.send(emailMessageSeries);
    }
}