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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.metaring.framework.SysKB;
import com.metaring.framework.controller.AbstractBaseController;
import com.metaring.framework.exception.ManagedException;
import com.metaring.framework.functionality.UnmanagedException;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.type.Email;

class JavaMailController extends AbstractBaseController implements EmailController {
    private Session javaMailSession;
    private static final Long CUSTOM_INFO_LEVEL = 5l;
    private Long actualLevel;
    private boolean test;
    private InternetAddress[] testAddress;

    @Override
    public void send(EmailMessageSeries emailMessageSeries) throws ManagedException, UnmanagedException {
        new Thread(() -> {
            try {
                emailMessageSeries.forEach(this::send);
            }
            catch (Exception e) {
                this.severe(e, new String[0]);
            }
        }).start();
    }

    public void send(EmailMessage emailMessage) {
        new Thread(() -> {
            try {
                this.sendWork(emailMessage);
            }
            catch (Exception e) {
                this.severe(e, new String[0]);
            }
        }).start();
    }

    private final void sendWork(EmailMessage emailMessage) throws ManagedException, UnmanagedException {
        Address fromAddress;
        try {
            fromAddress = this.toJavaMailAddress(emailMessage.getFrom());
        }
        catch (AddressException e) {
            throw new MailExcetpion("Sender address conversion failed", (Throwable) e);
        }
        EmailContactSeries tos = emailMessage.getTos();
        if (!(tos != null || test || testAddress != null)) {
            throw new MailExcetpion("No recipient specified");
        }
        Address[] tosArray = null;
        try {
            tosArray = this.toJavaMailAddressArray(tos);
        }
        catch (AddressException e) {
            throw new MailExcetpion("Recipient addresses conversion failed", (Throwable) e);
        }
        EmailContactSeries ccs = emailMessage.getCcs();
        Address[] ccArray = null;
        if (ccs != null) {
            try {
                ccArray = this.toJavaMailAddressArray(ccs);
            }
            catch (AddressException e) {
                throw new MailExcetpion("CC addresses conversion failed", (Throwable) e);
            }
        }
        EmailContactSeries bccs = emailMessage.getBccs();
        Address[] bccArray = null;
        if (bccs != null) {
            try {
                bccArray = this.toJavaMailAddressArray(bccs);
            }
            catch (AddressException e) {
                throw new MailExcetpion("BCC addresses conversion failed", (Throwable) e);
            }
        }
        if (testAddress != null) {
            tosArray = testAddress;
            ccArray = null;
            bccArray = null;
        }
        try {
            MimeMessage message = new MimeMessage(this.javaMailSession);
            message.setSubject(emailMessage.getSubject());
            message.setRecipients(Message.RecipientType.TO, tosArray);
            if (ccArray != null) {
                message.setRecipients(Message.RecipientType.CC, ccArray);
            }
            if (bccArray != null) {
                message.setRecipients(Message.RecipientType.BCC, bccArray);
            }
            message.setFrom(fromAddress);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setHeader("Content-Type", emailMessage.getType().getTextualValue());
            messageBodyPart.setContent((Object) emailMessage.getMessage(), emailMessage.getType().getTextualValue());
            multipart.addBodyPart((BodyPart) messageBodyPart);
            message.setContent((Multipart) multipart);
            if (!test) {
                try {
                    Transport.send(message);
                }
                catch (MessagingException ex) {
                    this.severe(ex, new String[0]);
                }
            }
        }
        catch (Exception e) {
            throw new MailExcetpion("Mail initialization failed", e);
        }
    }

    protected void info(String description, Address[]... addresses) {
        if (this.actualLevel == null) {
            this.actualLevel = this.getLogger().getActualStackPosition();
        }
        ArrayList<String> messagesList = new ArrayList<String>();
        for (Object[] array : addresses) {
            if (array == null)
                continue;
            messagesList.add(Arrays.toString(array));
        }
        String[] messages = new String[messagesList.size()];
        messages = messagesList.toArray(messages);
        this.getLogger().setActualStackPosition(CUSTOM_INFO_LEVEL);
        super.info(description, messages);
        this.getLogger().setActualStackPosition(this.actualLevel);
    }

    protected Address toJavaMailAddress(EmailContact emailContact) throws AddressException {
        InternetAddress address = null;
        if (emailContact != null) {
            String name = "";
            if (emailContact.getName() != null) {
                name = name + emailContact.getName();
            }
            if (emailContact.getSurname() != null) {
                name = name + " " + emailContact.getSurname();
            }
            name = name.trim();
            String mail = null;
            try {
                mail = emailContact.getMail().toJson().replace("\"", "");
            }
            catch(Exception e) {}
            try {
                address = new InternetAddress(mail, name);
            }
            catch (UnsupportedEncodingException e) {
                throw new AddressException(e.getMessage());
            }
        }
        return address;
    }

    protected Address toJavaMailAddress(Email email) throws AddressException {
        InternetAddress address = null;
        if (email != null) {
            String mail = null;
            try {
                mail = email.toJson().replace("\"", "");
            }
            catch(Exception e) {}
            address = new InternetAddress(mail);
        }
        return address;
    }

    protected Address[] toJavaMailAddressArray(EmailContactSeries emailContactSeries) throws AddressException {
        ArrayList<Address> list = new ArrayList<Address>();
        int i = 0;
        while ((long) i < emailContactSeries.size()) {
            EmailContact emailContact = emailContactSeries.get(i);
            Address address = this.toJavaMailAddress(emailContact);
            list.add(address);
            ++i;
        }
        Address[] addressArray = new Address[list.size()];
        return list.toArray(addressArray);
    }

    @Override
    public void reinit(SysKB sysKB) {
        test = false;
        testAddress = null;
        if (!sysKB.hasProperty(CFG_EMAIL)) {
            return;
        }
        DataRepresentation emailConfiguration = sysKB.get(CFG_EMAIL);
        if (emailConfiguration.hasProperty(CFG_TEST)) {
            try {
                test = emailConfiguration.getTruth(CFG_TEST);
            }
            catch (Exception e) {
            }
        }
        if (emailConfiguration.hasProperty(CFG_TEST_ADDRESS)) {
            try {
                testAddress = new InternetAddress[] { new InternetAddress(emailConfiguration.getText(CFG_TEST_ADDRESS)) };
            }
            catch (Exception e) {
            }
        }
        Properties properties = new Properties();
        try {
            for(String propertyName : emailConfiguration.getProperties()) {
                properties.setProperty(propertyName, emailConfiguration.getText(propertyName));
            }
        }
        catch (Exception e) {
        }
        final String mailSmtpUser = properties.getProperty(EmailController.CFG_USERNAME);
        final String mailSmtpPassword = properties.getProperty(EmailController.CFG_PASSWORD);
        javaMailSession = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailSmtpUser, mailSmtpPassword);
            }
        });
    }
}
