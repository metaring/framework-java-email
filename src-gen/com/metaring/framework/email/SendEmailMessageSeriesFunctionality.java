package com.metaring.framework.email;

import com.metaring.framework.SysKB;
import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;
import com.metaring.framework.email.EmailMessageSeries;

public abstract class SendEmailMessageSeriesFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    protected SendEmailMessageSeriesFunctionality(SysKB sysKB) {
        super(sysKB, EmailFunctionalitiesManager.SEND_EMAIL_MESSAGE_SERIES, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck(EmailMessageSeries input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call((EmailMessageSeries) input);
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

    protected abstract CompletableFuture<Void> call(EmailMessageSeries input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck(EmailMessageSeries input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck(input == null ? null : (EmailMessageSeries) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck(EmailMessageSeries input) throws Exception {
        return end;
    }

    @Override
    protected final Object getInputFromJsonWork(String inputJson) {
        return EmailMessageSeries.fromJson(inputJson);
    }

    protected static final SendEmailMessageSeriesFunctionality create(SysKB sysKB) {
        return new SendEmailMessageSeriesFunctionalityImpl(sysKB);
    }
}