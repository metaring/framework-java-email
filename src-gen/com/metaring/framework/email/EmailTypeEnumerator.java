package com.metaring.framework.email;

import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailTypeEnumerator implements GeneratedCoreType {

    public static final EmailTypeEnumerator TEXT = new EmailTypeEnumerator("TEXT", 0l, "text/plain");
    public static final EmailTypeEnumerator HTML = new EmailTypeEnumerator("HTML", 1l, "text/html");

    private String name;
    private Long numericValue;
    private String textualValue;

    private EmailTypeEnumerator(String name, Long numericValue, String textualValue) {
        this.name = name;
        this.numericValue = numericValue;
        this.textualValue = textualValue;
    }

    public String getName() {
        return this.name;
    }

    public Long getNumericValue() {
        return this.numericValue;
    }

    public String getTextualValue() {
        return this.textualValue;
    }

    public static final EmailTypeEnumeratorSeries listAll() {
        return EmailTypeEnumeratorSeries.create(TEXT, HTML);
    }

    public static EmailTypeEnumerator getByNumericValue(Long numericValue) {
        if(numericValue == null) {
            return null;
        }
        switch(numericValue.intValue()) {

            case 0 : return TEXT;

            case 1 : return HTML;

            default: return null;
        }
    }

    public static EmailTypeEnumerator getByTextualValue(String textualValue) {
        if(textualValue == null) {
            return null;
        }
        switch(textualValue) {

            case "text/plain" : return TEXT;

            case "text/html" : return HTML;

            default: return null;
        }
    }

    public static EmailTypeEnumerator getByName(String emailTypeEnumeratorName) {
        if(emailTypeEnumeratorName == null) {
            return null;
        }
        switch(emailTypeEnumeratorName) {

            case "TEXT" : return TEXT;

            case "HTML" : return HTML;

            default: return null;
        }
    }

    public static EmailTypeEnumerator fromJson(String json) {
        if(json == null) {
            return null;
        }
        if(json.startsWith("\"")) {
            json = json.substring(1);
        }
        if(json.endsWith("\"")) {
            json = json.substring(0, json.length() - 1);
        }
        try {
            return getByNumericValue(Long.parseLong(json));
        } catch(Exception e) {
        }
        EmailTypeEnumerator result = getByTextualValue(json);
        return result != null ? result : getByName(json);
    }

    @Override
    public String toJson() {
        return "\"" + this.name + "\"";
    }

    public DataRepresentation toDataRepresentation() {
        return Tools.FACTORY_DATA_REPRESENTATION.fromJson(toJson());
    }

    @Override
    public String toString() {
        return toJson();
    }
}