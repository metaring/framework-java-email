package com.metaring.framework.email;

import com.metaring.framework.email.MassiveTemplateEmailElementSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveTemplateEmail implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.massiveTemplateEmail";

    private String templateName;
    private MassiveTemplateEmailElementSeries elements;

    private MassiveTemplateEmail(String templateName, MassiveTemplateEmailElementSeries elements) {
        this.templateName = templateName;
        this.elements = elements;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public MassiveTemplateEmailElementSeries getElements() {
        return this.elements;
    }

    public static MassiveTemplateEmail create(String templateName, MassiveTemplateEmailElementSeries elements) {
        return new MassiveTemplateEmail(templateName, elements);
    }

    public static MassiveTemplateEmail fromJson(String jsonString) {

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

        MassiveTemplateEmailElementSeries elements = null;
        if(dataRepresentation.hasProperty("elements")) {
            try {
                elements = dataRepresentation.get("elements", MassiveTemplateEmailElementSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveTemplateEmail massiveTemplateEmail = create(templateName, elements);
        return massiveTemplateEmail;
    }

    public static MassiveTemplateEmail fromObject(Object object) {

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

        MassiveTemplateEmailElementSeries elements = null;
        if(dataRepresentation.hasProperty("elements")) {
            try {
                elements = dataRepresentation.get("elements", MassiveTemplateEmailElementSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveTemplateEmail massiveTemplateEmail = create(templateName, elements);
        return massiveTemplateEmail;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (templateName != null) {
            dataRepresentation.add("templateName", templateName);
        }

        if (elements != null) {
            dataRepresentation.add("elements", elements.toArray());
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