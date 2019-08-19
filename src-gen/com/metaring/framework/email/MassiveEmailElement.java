package com.metaring.framework.email;

import com.metaring.framework.email.EmailContactSeries;
import com.metaring.framework.email.EmailTemplateArgumentSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveEmailElement implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.massiveEmailElement";

    private EmailContactSeries tos;
    private EmailContactSeries ccs;
    private EmailContactSeries bccs;
    private EmailTemplateArgumentSeries arguments;

    private MassiveEmailElement(EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, EmailTemplateArgumentSeries arguments) {
        this.tos = tos;
        this.ccs = ccs;
        this.bccs = bccs;
        this.arguments = arguments;
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

    public EmailTemplateArgumentSeries getArguments() {
        return this.arguments;
    }

    public static MassiveEmailElement create(EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, EmailTemplateArgumentSeries arguments) {
        return new MassiveEmailElement(tos, ccs, bccs, arguments);
    }

    public static MassiveEmailElement fromJson(String jsonString) {

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

        EmailTemplateArgumentSeries arguments = null;
        if(dataRepresentation.hasProperty("arguments")) {
            try {
                arguments = dataRepresentation.get("arguments", EmailTemplateArgumentSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveEmailElement massiveEmailElement = create(tos, ccs, bccs, arguments);
        return massiveEmailElement;
    }

    public static MassiveEmailElement fromObject(Object object) {

        if(object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);

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

        EmailTemplateArgumentSeries arguments = null;
        if(dataRepresentation.hasProperty("arguments")) {
            try {
                arguments = dataRepresentation.get("arguments", EmailTemplateArgumentSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveEmailElement massiveEmailElement = create(tos, ccs, bccs, arguments);
        return massiveEmailElement;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (tos != null) {
            dataRepresentation.add("tos", tos.toArray());
        }

        if (ccs != null) {
            dataRepresentation.add("ccs", ccs.toArray());
        }

        if (bccs != null) {
            dataRepresentation.add("bccs", bccs.toArray());
        }

        if (arguments != null) {
            dataRepresentation.add("arguments", arguments.toArray());
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