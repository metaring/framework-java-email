package com.metaring.framework.email;

import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailTemplateArgument implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.emailTemplateArgument";

    private String name;
    private String jsonValue;

    private EmailTemplateArgument(String name, String jsonValue) {
        this.name = name;
        this.jsonValue = jsonValue;
    }

    public String getName() {
        return this.name;
    }

    public String getJsonValue() {
        return this.jsonValue;
    }

    public static EmailTemplateArgument create(String name, String jsonValue) {
        return new EmailTemplateArgument(name, jsonValue);
    }

    public static EmailTemplateArgument fromJson(String jsonString) {

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

        String name = null;
        if(dataRepresentation.hasProperty("name")) {
            try {
                name = dataRepresentation.getText("name");
            } catch (Exception e) {
            }
        }

        String jsonValue = null;
        if(dataRepresentation.hasProperty("jsonValue")) {
            try {
                jsonValue = dataRepresentation.getText("jsonValue");
            } catch (Exception e) {
            }
        }

        EmailTemplateArgument emailTemplateArgument = create(name, jsonValue);
        return emailTemplateArgument;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (name != null) {
            dataRepresentation.add("name", name);
        }

        if (jsonValue != null) {
            dataRepresentation.add("jsonValue", jsonValue);
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