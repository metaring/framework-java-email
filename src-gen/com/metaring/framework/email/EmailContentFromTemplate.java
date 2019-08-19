package com.metaring.framework.email;

import com.metaring.framework.localization.LocaleEnumerator;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailContentFromTemplate implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.emailContentFromTemplate";

    private String subject;
    private String message;
    private LocaleEnumerator language;

    private EmailContentFromTemplate(String subject, String message, LocaleEnumerator language) {
        this.subject = subject;
        this.message = message;
        this.language = language;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getMessage() {
        return this.message;
    }

    public LocaleEnumerator getLanguage() {
        return this.language;
    }

    public static EmailContentFromTemplate create(String subject, String message, LocaleEnumerator language) {
        return new EmailContentFromTemplate(subject, message, language);
    }

    public static EmailContentFromTemplate fromJson(String jsonString) {

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

        String subject = null;
        if(dataRepresentation.hasProperty("subject")) {
            try {
                subject = dataRepresentation.getText("subject");
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

        LocaleEnumerator language = null;
        if(dataRepresentation.hasProperty("language")) {
            try {
                language = dataRepresentation.get("language", LocaleEnumerator.class);
            } catch (Exception e) {
            }
        }

        EmailContentFromTemplate emailContentFromTemplate = create(subject, message, language);
        return emailContentFromTemplate;
    }

    public static EmailContentFromTemplate fromObject(Object object) {

        if(object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);

        String subject = null;
        if(dataRepresentation.hasProperty("subject")) {
            try {
                subject = dataRepresentation.getText("subject");
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

        LocaleEnumerator language = null;
        if(dataRepresentation.hasProperty("language")) {
            try {
                language = dataRepresentation.get("language", LocaleEnumerator.class);
            } catch (Exception e) {
            }
        }

        EmailContentFromTemplate emailContentFromTemplate = create(subject, message, language);
        return emailContentFromTemplate;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (subject != null) {
            dataRepresentation.add("subject", subject);
        }

        if (message != null) {
            dataRepresentation.add("message", message);
        }

        if (language != null) {
            dataRepresentation.add("language", language);
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