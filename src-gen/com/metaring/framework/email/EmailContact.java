package com.metaring.framework.email;

import com.metaring.framework.type.Email;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class EmailContact implements GeneratedCoreType {

    public static final String FULLY_QUALIFIED_NAME = "com.metaring.framework.email.emailContact";

    private String name;
    private String surname;
    private Email mail;

    private EmailContact(String name, String surname, Email mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Email getMail() {
        return this.mail;
    }

    public static EmailContact create(String name, String surname, Email mail) {
        return new EmailContact(name, surname, mail);
    }

    public static EmailContact fromJson(String jsonString) {

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

        String surname = null;
        if(dataRepresentation.hasProperty("surname")) {
            try {
                surname = dataRepresentation.getText("surname");
            } catch (Exception e) {
            }
        }

        Email mail = null;
        if(dataRepresentation.hasProperty("mail")) {
            try {
                mail = dataRepresentation.getEmail("mail");
            } catch (Exception e) {
            }
        }

        EmailContact emailContact = create(name, surname, mail);
        return emailContact;
    }

    public DataRepresentation toDataRepresentation() {
        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.create();
        if (name != null) {
            dataRepresentation.add("name", name);
        }

        if (surname != null) {
            dataRepresentation.add("surname", surname);
        }

        if (mail != null) {
            dataRepresentation.add("mail", mail);
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