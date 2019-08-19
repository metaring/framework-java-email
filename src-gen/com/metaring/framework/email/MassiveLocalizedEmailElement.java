package com.metaring.framework.email;

import com.metaring.framework.email.MassiveEmailElementSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveLocalizedEmailElement implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.massiveLocalizedEmailElement";

    private String templateName;
    private MassiveEmailElementSeries recipients;

    private MassiveLocalizedEmailElement(String templateName, MassiveEmailElementSeries recipients) {
        this.templateName = templateName;
        this.recipients = recipients;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public MassiveEmailElementSeries getRecipients() {
        return this.recipients;
    }

    public static MassiveLocalizedEmailElement create(String templateName, MassiveEmailElementSeries recipients) {
        return new MassiveLocalizedEmailElement(templateName, recipients);
    }

    public static MassiveLocalizedEmailElement fromJson(String jsonString) {

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

        String templateName = null;
        if(dataRepresentation.hasProperty("templateName")) {
            try {
                templateName = dataRepresentation.getText("templateName");
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

        MassiveLocalizedEmailElement massiveLocalizedEmailElement = create(templateName, recipients);
        return massiveLocalizedEmailElement;
    }

    public static MassiveLocalizedEmailElement fromObject(Object object) {

        if(object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);

        String templateName = null;
        if(dataRepresentation.hasProperty("templateName")) {
            try {
                templateName = dataRepresentation.getText("templateName");
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

        MassiveLocalizedEmailElement massiveLocalizedEmailElement = create(templateName, recipients);
        return massiveLocalizedEmailElement;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (templateName != null) {
            dataRepresentation.add("templateName", templateName);
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