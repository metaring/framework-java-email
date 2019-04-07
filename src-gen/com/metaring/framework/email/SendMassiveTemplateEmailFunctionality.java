package com.metaring.framework.email;

import com.metaring.framework.SysKB;
import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;
import com.metaring.framework.email.MassiveTemplateEmail;

public abstract class SendMassiveTemplateEmailFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    protected SendMassiveTemplateEmailFunctionality(SysKB sysKB) {
        super(sysKB, EmailFunctionalitiesManager.SEND_MASSIVE_TEMPLATE_EMAIL, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck(MassiveTemplateEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call((MassiveTemplateEmail) input);
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

    protected abstract CompletableFuture<Void> call(MassiveTemplateEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck(MassiveTemplateEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck(input == null ? null : (MassiveTemplateEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck(MassiveTemplateEmail input) throws Exception {
        return end;
    }

    @Override
    protected final Object getInputFromJsonWork(String inputJson) {
        return MassiveTemplateEmail.fromJson(inputJson);
    }

    protected static final SendMassiveTemplateEmailFunctionality create(SysKB sysKB) {
        return new SendMassiveTemplateEmailFunctionalityImpl(sysKB);
    }
}