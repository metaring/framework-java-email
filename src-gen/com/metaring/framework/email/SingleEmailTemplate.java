package com.metaring.framework.email;

import com.metaring.framework.localization.LocaleEnumerator;
import com.metaring.framework.email.EmailTemplateArgumentSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class SingleEmailTemplate implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.singleEmailTemplate";

    private String templateName;
    private LocaleEnumerator language;
    private EmailTemplateArgumentSeries arguments;

    private SingleEmailTemplate(String templateName, LocaleEnumerator language, EmailTemplateArgumentSeries arguments) {
        this.templateName = templateName;
        this.language = language;
        this.arguments = arguments;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public LocaleEnumerator getLanguage() {
        return this.language;
    }

    public EmailTemplateArgumentSeries getArguments() {
        return this.arguments;
    }

    public static SingleEmailTemplate create(String templateName, LocaleEnumerator language, EmailTemplateArgumentSeries arguments) {
        return new SingleEmailTemplate(templateName, language, arguments);
    }

    public static SingleEmailTemplate fromJson(String jsonString) {

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

        LocaleEnumerator language = null;
        if(dataRepresentation.hasProperty("language")) {
            try {
                language = dataRepresentation.get("language", LocaleEnumerator.class);
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

        SingleEmailTemplate singleEmailTemplate = create(templateName, language, arguments);
        return singleEmailTemplate;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (templateName != null) {
            dataRepresentation.add("templateName", templateName);
        }

        if (language != null) {
            dataRepresentation.add("language", language);
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