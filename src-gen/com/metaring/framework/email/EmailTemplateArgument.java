package com.metaring.framework.email;

import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailTemplateArgument implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.emailTemplateArgument";

    private String name;
    private DataRepresentation value;

    private EmailTemplateArgument(String name, DataRepresentation value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public DataRepresentation getValue() {
        return this.value;
    }

    public static EmailTemplateArgument create(String name, DataRepresentation value) {
        return new EmailTemplateArgument(name, value);
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

        DataRepresentation value = null;
        if(dataRepresentation.hasProperty("value")) {
            try {
                value = dataRepresentation.get("value");
            } catch (Exception e) {
            }
        }

        EmailTemplateArgument emailTemplateArgument = create(name, value);
        return emailTemplateArgument;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (name != null) {
            dataRepresentation.add("name", name);
        }

        if (value != null) {
            dataRepresentation.add("value", value);
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