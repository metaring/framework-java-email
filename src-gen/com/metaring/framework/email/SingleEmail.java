package com.metaring.framework.email;

import com.metaring.framework.email.EmailContactSeries;
import com.metaring.framework.email.SingleEmailTemplate;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class SingleEmail implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.singleEmail";

    private EmailContactSeries tos;
    private EmailContactSeries ccs;
    private EmailContactSeries bccs;
    private SingleEmailTemplate template;

    private SingleEmail(EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, SingleEmailTemplate template) {
        this.tos = tos;
        this.ccs = ccs;
        this.bccs = bccs;
        this.template = template;
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

    public SingleEmailTemplate getTemplate() {
        return this.template;
    }

    public static SingleEmail create(EmailContactSeries tos, EmailContactSeries ccs, EmailContactSeries bccs, SingleEmailTemplate template) {
        return new SingleEmail(tos, ccs, bccs, template);
    }

    public static SingleEmail fromJson(String jsonString) {

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

        SingleEmailTemplate template = null;
        if(dataRepresentation.hasProperty("template")) {
            try {
                template = dataRepresentation.get("template", SingleEmailTemplate.class);
            } catch (Exception e) {
            }
        }

        SingleEmail singleEmail = create(tos, ccs, bccs, template);
        return singleEmail;
    }

    public static SingleEmail fromObject(Object object) {

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

        SingleEmailTemplate template = null;
        if(dataRepresentation.hasProperty("template")) {
            try {
                template = dataRepresentation.get("template", SingleEmailTemplate.class);
            } catch (Exception e) {
            }
        }

        SingleEmail singleEmail = create(tos, ccs, bccs, template);
        return singleEmail;
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

        if (template != null) {
            dataRepresentation.add("template", template);
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