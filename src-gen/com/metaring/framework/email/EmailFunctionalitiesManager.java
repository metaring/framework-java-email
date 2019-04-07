package com.metaring.framework.email;

import com.metaring.framework.functionality.FunctionalityInfo;
import com.metaring.framework.functionality.FunctionalitiesManager;
import com.metaring.framework.functionality.GeneratedFunctionalitiesManager;
import com.metaring.framework.functionality.Functionality;
import java.util.concurrent.CompletableFuture;
import com.metaring.framework.email.EmailMessage;
import com.metaring.framework.email.EmailMessageSeries;
import com.metaring.framework.email.MassiveLocalizedEmail;
import com.metaring.framework.email.MassiveTemplateEmail;
import com.metaring.framework.email.SingleEmail;

public class EmailFunctionalitiesManager extends FunctionalitiesManager implements GeneratedFunctionalitiesManager {

    public static final FunctionalityInfo REINIT = FunctionalityInfo.create("com.metaring.framework.email.reinit", true, false, false, null, null);

    public static final FunctionalityInfo SEND_EMAIL_MESSAGE = FunctionalityInfo.create("com.metaring.framework.email.sendEmailMessage", true, false, false, "com.metaring.framework.email.EmailMessage", null);

    public static final FunctionalityInfo SEND_EMAIL_MESSAGE_SERIES = FunctionalityInfo.create("com.metaring.framework.email.sendEmailMessageSeries", true, false, false, "com.metaring.framework.email.EmailMessageSeries", null);

    public static final FunctionalityInfo SEND_MASSIVE_LOCALIZED_EMAIL = FunctionalityInfo.create("com.metaring.framework.email.sendMassiveLocalizedEmail", true, false, false, "com.metaring.framework.email.MassiveLocalizedEmail", null);

    public static final FunctionalityInfo SEND_MASSIVE_TEMPLATE_EMAIL = FunctionalityInfo.create("com.metaring.framework.email.sendMassiveTemplateEmail", true, false, false, "com.metaring.framework.email.MassiveTemplateEmail", null);

    public static final FunctionalityInfo SEND_SINGLE_EMAIL = FunctionalityInfo.create("com.metaring.framework.email.sendSingleEmail", true, false, false, "com.metaring.framework.email.SingleEmail", null);

    public static final CompletableFuture<Void> reinit() {
        return call(REINIT, ReinitFunctionality.class, getCallingFunctionality(), null, null);
    }

    public static final CompletableFuture<Void> reinit(Functionality functionality) {
        return call(REINIT, ReinitFunctionality.class, functionality, null, null);
    }

    public static final CompletableFuture<Void> sendEmailMessage(EmailMessage emailMessage) {
        return call(SEND_EMAIL_MESSAGE, SendEmailMessageFunctionality.class, getCallingFunctionality(), emailMessage, null);
    }

    public static final CompletableFuture<Void> sendEmailMessage(Functionality functionality, EmailMessage emailMessage) {
        return call(SEND_EMAIL_MESSAGE, SendEmailMessageFunctionality.class, functionality, emailMessage, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageFromJson(String emailMessageJson) {
        return callFromJson(SEND_EMAIL_MESSAGE, SendEmailMessageFunctionality.class, getCallingFunctionality(), emailMessageJson, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageFromJson(Functionality callingFunctionality, String emailMessageJson) {
        return callFromJson(SEND_EMAIL_MESSAGE, SendEmailMessageFunctionality.class, callingFunctionality, emailMessageJson, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageSeries(EmailMessageSeries emailMessageSeries) {
        return call(SEND_EMAIL_MESSAGE_SERIES, SendEmailMessageSeriesFunctionality.class, getCallingFunctionality(), emailMessageSeries, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageSeries(Functionality functionality, EmailMessageSeries emailMessageSeries) {
        return call(SEND_EMAIL_MESSAGE_SERIES, SendEmailMessageSeriesFunctionality.class, functionality, emailMessageSeries, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageSeriesFromJson(String emailMessageSeriesJson) {
        return callFromJson(SEND_EMAIL_MESSAGE_SERIES, SendEmailMessageSeriesFunctionality.class, getCallingFunctionality(), emailMessageSeriesJson, null);
    }

    public static final CompletableFuture<Void> sendEmailMessageSeriesFromJson(Functionality callingFunctionality, String emailMessageSeriesJson) {
        return callFromJson(SEND_EMAIL_MESSAGE_SERIES, SendEmailMessageSeriesFunctionality.class, callingFunctionality, emailMessageSeriesJson, null);
    }

    public static final CompletableFuture<Void> sendMassiveLocalizedEmail(MassiveLocalizedEmail massiveLocalizedEmail) {
        return call(SEND_MASSIVE_LOCALIZED_EMAIL, SendMassiveLocalizedEmailFunctionality.class, getCallingFunctionality(), massiveLocalizedEmail, null);
    }

    public static final CompletableFuture<Void> sendMassiveLocalizedEmail(Functionality functionality, MassiveLocalizedEmail massiveLocalizedEmail) {
        return call(SEND_MASSIVE_LOCALIZED_EMAIL, SendMassiveLocalizedEmailFunctionality.class, functionality, massiveLocalizedEmail, null);
    }

    public static final CompletableFuture<Void> sendMassiveLocalizedEmailFromJson(String massiveLocalizedEmailJson) {
        return callFromJson(SEND_MASSIVE_LOCALIZED_EMAIL, SendMassiveLocalizedEmailFunctionality.class, getCallingFunctionality(), massiveLocalizedEmailJson, null);
    }

    public static final CompletableFuture<Void> sendMassiveLocalizedEmailFromJson(Functionality callingFunctionality, String massiveLocalizedEmailJson) {
        return callFromJson(SEND_MASSIVE_LOCALIZED_EMAIL, SendMassiveLocalizedEmailFunctionality.class, callingFunctionality, massiveLocalizedEmailJson, null);
    }

    public static final CompletableFuture<Void> sendMassiveTemplateEmail(MassiveTemplateEmail massiveTemplateEmail) {
        return call(SEND_MASSIVE_TEMPLATE_EMAIL, SendMassiveTemplateEmailFunctionality.class, getCallingFunctionality(), massiveTemplateEmail, null);
    }

    public static final CompletableFuture<Void> sendMassiveTemplateEmail(Functionality functionality, MassiveTemplateEmail massiveTemplateEmail) {
        return call(SEND_MASSIVE_TEMPLATE_EMAIL, SendMassiveTemplateEmailFunctionality.class, functionality, massiveTemplateEmail, null);
    }

    public static final CompletableFuture<Void> sendMassiveTemplateEmailFromJson(String massiveTemplateEmailJson) {
        return callFromJson(SEND_MASSIVE_TEMPLATE_EMAIL, SendMassiveTemplateEmailFunctionality.class, getCallingFunctionality(), massiveTemplateEmailJson, null);
    }

    public static final CompletableFuture<Void> sendMassiveTemplateEmailFromJson(Functionality callingFunctionality, String massiveTemplateEmailJson) {
        return callFromJson(SEND_MASSIVE_TEMPLATE_EMAIL, SendMassiveTemplateEmailFunctionality.class, callingFunctionality, massiveTemplateEmailJson, null);
    }

    public static final CompletableFuture<Void> sendSingleEmail(SingleEmail singleEmail) {
        return call(SEND_SINGLE_EMAIL, SendSingleEmailFunctionality.class, getCallingFunctionality(), singleEmail, null);
    }

    public static final CompletableFuture<Void> sendSingleEmail(Functionality functionality, SingleEmail singleEmail) {
        return call(SEND_SINGLE_EMAIL, SendSingleEmailFunctionality.class, functionality, singleEmail, null);
    }

    public static final CompletableFuture<Void> sendSingleEmailFromJson(String singleEmailJson) {
        return callFromJson(SEND_SINGLE_EMAIL, SendSingleEmailFunctionality.class, getCallingFunctionality(), singleEmailJson, null);
    }

    public static final CompletableFuture<Void> sendSingleEmailFromJson(Functionality callingFunctionality, String singleEmailJson) {
        return callFromJson(SEND_SINGLE_EMAIL, SendSingleEmailFunctionality.class, callingFunctionality, singleEmailJson, null);
    }

}
