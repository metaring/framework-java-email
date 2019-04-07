package com.metaring.framework.email;

import com.metaring.framework.localization.LocaleEnumerator;
import com.metaring.framework.email.MassiveLocalizedEmailElementSeries;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveLocalizedEmail implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.massiveLocalizedEmail";

    private LocaleEnumerator language;
    private MassiveLocalizedEmailElementSeries elements;

    private MassiveLocalizedEmail(LocaleEnumerator language, MassiveLocalizedEmailElementSeries elements) {
        this.language = language;
        this.elements = elements;
    }

    public LocaleEnumerator getLanguage() {
        return this.language;
    }

    public MassiveLocalizedEmailElementSeries getElements() {
        return this.elements;
    }

    public static MassiveLocalizedEmail create(LocaleEnumerator language, MassiveLocalizedEmailElementSeries elements) {
        return new MassiveLocalizedEmail(language, elements);
    }

    public static MassiveLocalizedEmail fromJson(String jsonString) {

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

        MassiveLocalizedEmailElementSeries elements = null;
        if(dataRepresentation.hasProperty("elements")) {
            try {
                elements = dataRepresentation.get("elements", MassiveLocalizedEmailElementSeries.class);
            } catch (Exception e) {
            }
        }

        MassiveLocalizedEmail massiveLocalizedEmail = create(language, elements);
        return massiveLocalizedEmail;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (language != null) {
            dataRepresentation.add("language", language);
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