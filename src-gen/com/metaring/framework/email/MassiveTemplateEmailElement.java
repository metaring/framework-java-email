package com.metaring.framework.email;

import com.metaring.framework.localization.LocaleEnumerator;
import com.metaring.framework.email.MassiveEmailElementSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveTemplateEmailElement implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.massiveTemplateEmailElement";

    private LocaleEnumerator language;
    private MassiveEmailElementSeries recipients;

    private MassiveTemplateEmailElement(LocaleEnumerator language, MassiveEmailElementSeries recipients) {
        this.language = language;
        this.recipients = recipients;
    }

    public LocaleEnumerator getLanguage() {
        return this.language;
    }

    public MassiveEmailElementSeries getRecipients() {
        return this.recipients;
    }

    public static MassiveTemplateEmailElement create(LocaleEnumerator language, MassiveEmailElementSeries recipients) {
        return new MassiveTemplateEmailElement(language, recipients);
    }

    public static MassiveTemplateEmailElement fromJson(String jsonString) {

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

        LocaleEnumerator language = null;
        if(dataRepresentation.hasProperty("language")) {
            try {
                language = dataRepresentation.get("language", LocaleEnumerator.class);
            } catch (Exception e) {
            }
        }

        MassiveEmailElementSeries recipients = null;
        if(dataRepresentation.hasProperty("recipients")) {
            try {
                recipients = dataRepresentation.get("recipients", MassiveEmailElementSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveTemplateEmailElement massiveTemplateEmailElement = create(language, recipients);
        return massiveTemplateEmailElement;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (language != null) {
            dataRepresentation.add("language", language);
        }

        if (recipients != null) {
            dataRepresentation.add("recipients", recipients.toArray());
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