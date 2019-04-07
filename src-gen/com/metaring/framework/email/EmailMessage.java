package com.metaring.framework.email;

import com.metaring.framework.email.EmailContact;
import com.metaring.framework.email.EmailContactSeries;
import com.metaring.framework.email.EmailTypeEnumerator;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailMessage implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.emailMessage";

    private EmailContact from;
    private EmailContactSeries tos;
    private EmailContactSeries ccs;
    private EmailContactSeries bccs;
    private String subject;
    private EmailTypeEnumerator type;
    private String message;

    private EmailMessage(EmailContact from, EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, String subject, EmailTypeEnumerator type, String message) {
        this.from = from;
        this.tos = tos;
        this.ccs = ccs;
        this.bccs = bccs;
        this.subject = subject;
        this.type = type;
        this.message = message;
    }

    public EmailContact getFrom() {
        return this.from;
    }

    public EmailContactSeries getTos() {
        return this.tos;
    }

    public EmailContactSeries getCcs() {
        return this.ccs;
    }

    public EmailContactSeries getBccs() {
        return this.bccs;
    }

    public String getSubject() {
        return this.subject;
    }

    public EmailTypeEnumerator getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public static EmailMessage create(EmailContact from, EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, String subject, EmailTypeEnumerator type, String message) {
        return new EmailMessage(from, tos, ccs, bccs, subject, type, message);
    }

    public static EmailMessage fromJson(String jsonString) {

        if(jsonString == null) {
            return null;
        }

        jsonString = jsonString.trim();
        if(jsonString.isEmpty()) {
            return null;
        }

        if(jsonString.equalsIgnoreCase("null")) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromJson(jsonString);

        EmailContact from = null;
        if(dataRepresentation.hasProperty("from")) {
            try {
                from = dataRepresentation.get("from", EmailContact.class);
            } catch (Exception e) {
            }
        }

        EmailContactSeries tos = null;
        if(dataRepresentation.hasProperty("tos")) {
            try {
                tos = dataRepresentation.get("tos", EmailContactSeries.class);
            } catch (Exception e) {
            }
        }

        EmailContactSeries ccs = null;
        if(dataRepresentation.hasProperty("ccs")) {
            try {
                ccs = dataRepresentation.get("ccs", EmailContactSeries.class);
            } catch (Exception e) {
            }
        }

        EmailContactSeries bccs = null;
        if(dataRepresentation.hasProperty("bccs")) {
            try {
                bccs = dataRepresentation.get("bccs", EmailContactSeries.class);
            } catch (Exception e) {
            }
        }

        String subject = null;
        if(dataRepresentation.hasProperty("subject")) {
            try {
                subject = dataRepresentation.getText("subject");
            } catch (Exception e) {
            }
        }

        EmailTypeEnumerator type = null;
        if(dataRepresentation.hasProperty("type")) {
            try {
                type = dataRepresentation.get("type", EmailTypeEnumerator.class);
            } catch (Exception e) {
            }
        }

        String message = null;
        if(dataRepresentation.hasProperty("message")) {
            try {
                message = dataRepresentation.getText("message");
            } catch (Exception e) {
            }
        }

        EmailMessage emailMessage = create(from, tos, ccs, bccs, subject, type, message);
        return emailMessage;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (from != null) {
            dataRepresentation.add("from", from);
        }

        if (tos != null) {
            dataRepresentation.add("tos", tos.toArray());
        }

        if (ccs != null) {
            dataRepresentation.add("ccs", ccs.toArray());
        }

        if (bccs != null) {
            dataRepresentation.add("bccs", bccs.toArray());
        }

        if (subject != null) {
            dataRepresentation.add("subject", subject);
        }

        if (type != null) {
            dataRepresentation.add("type", type);
        }

        if (message != null) {
            dataRepresentation.add("message", message);
        }

        return dataRepresentation;
    }

    @Override
    public String toJson() {
        return toDataRepresentation().toJson();
    }

    @Override
    public String toString() {
        return this.toJson();
    }
}