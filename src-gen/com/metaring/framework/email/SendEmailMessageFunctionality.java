package com.metaring.framework.email;

import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;
import com.metaring.framework.functionality.FunctionalityInfo;
import com.metaring.framework.email.EmailMessage;

abstract class SendEmailMessageFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    static final FunctionalityInfo INFO = FunctionalityInfo.create("com.metaring.framework.email.sendEmailMessage", true, false, false, "com.metaring.framework.email.EmailMessage", null);

    static final SendEmailMessageFunctionality INSTANCE = new SendEmailMessageFunctionalityImpl();

    protected SendEmailMessageFunctionality() {
        super(INFO, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck(EmailMessage input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call((EmailMessage) input);
        if(call == null) {
            return end(null);
        }
        final CompletableFuture<Object> response = new CompletableFuture<>();
        call.whenCompleteAsync((result, error) -> {
            if(error != null) {
                response.completeExceptionally(error);
                return;
            }
            response.complete(result);
        }, EXECUTOR);
        return response;
    }

    protected abstract CompletableFuture<Void> call(EmailMessage input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck(EmailMessage input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck(input == null ? null : (EmailMessage) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck(EmailMessage input) throws Exception {
        return end;
    }

    @Override
    protected final Object getInputFromJsonWork(String inputJson) {
        return EmailMessage.fromJson(inputJson);
    }
}