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

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.metaring.framework.SysKB;

class SendMassiveLocalizedEmailFunctionalityImpl extends SendMassiveLocalizedEmailFunctionality {

    protected SendMassiveLocalizedEmailFunctionalityImpl(SysKB sysKB) {
        super(sysKB);
    }

    @Override
    protected CompletableFuture<Void> preConditionCheck(MassiveLocalizedEmail massiveLocalizedEmail) throws Exception {
        return end;
    }

    @Override
    protected CompletableFuture<Void> call(MassiveLocalizedEmail massiveLocalizedEmail) throws Exception {
        CompletableFuture<Void> call = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            try {
                STGroup templateGroup = EmailHelper.EMAIL_TEMPLATES.get(massiveLocalizedEmail.getLanguage().getTextualValue());
                MassiveLocalizedEmailElementSeries massiveLocalizedEmailElementSeries = massiveLocalizedEmail.getElements();
                ArrayList<EmailMessage> emailMessageList = new ArrayList<EmailMessage>();
                for (int i = 0; i < massiveLocalizedEmailElementSeries.size(); ++i) {
                    MassiveLocalizedEmailElement massiveLocalizedEmailElement = massiveLocalizedEmailElementSeries.get(i);
                    String templateName = massiveLocalizedEmailElement.getTemplateName();
                    ST subjectTemplate = EmailHelper.getTemplateByName(templateGroup, templateName, EmailHelper.TEMPLATE_TYPE_SUBJECT);
                    ST messageTemplate = EmailHelper.getTemplateByName(templateGroup, templateName, EmailHelper.TEMPLATE_TYPE_MESSAGE);
                    MassiveEmailElementSeries massiveEmailElementSeries = massiveLocalizedEmailElement.getRecipients();
                    for (int j = 0; j < massiveEmailElementSeries.size(); ++j) {
                        MassiveEmailElement massiveEmailElement = massiveEmailElementSeries.get(j);
                        String subject = EmailHelper.getFilledByTemplate(templateGroup, subjectTemplate, massiveEmailElement.getArguments());
                        String message = EmailHelper.getFilledByTemplate(templateGroup, messageTemplate, massiveEmailElement.getArguments());
                        EmailMessage emailMessage = EmailMessage.create(EmailHelper.DEFAULT_EMAIL_SENDER, massiveEmailElement.getTos(), massiveEmailElement.getCcs(), massiveEmailElement.getBccs(), subject, EmailTypeEnumerator.HTML, message);
                        emailMessageList.add(emailMessage);
                    }
                }
                EmailMessage[] emailMessages = new EmailMessage[emailMessageList.size()];
                emailMessages = emailMessageList.toArray(emailMessages);
                EmailMessageSeries emailMessageSeries = EmailMessageSeries.create(emailMessages);
                EmailHelper.send(emailMessageSeries);
                call.complete(null);
            }
            catch(Exception e) {
                call.completeExceptionally(e);
            }
        }, EXECUTOR);
        return call;
    }

    @Override
    protected CompletableFuture<Void> postConditionCheck(MassiveLocalizedEmail massiveLocalizedEmail) throws Exception {
        return end;
    }
}
