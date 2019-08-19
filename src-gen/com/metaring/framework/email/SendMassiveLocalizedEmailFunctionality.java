package com.metaring.framework.email;

import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;
import com.metaring.framework.functionality.FunctionalityInfo;
import com.metaring.framework.email.MassiveLocalizedEmail;

abstract class SendMassiveLocalizedEmailFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    static final FunctionalityInfo INFO = FunctionalityInfo.create("com.metaring.framework.email.sendMassiveLocalizedEmail", true, false, false, "com.metaring.framework.email.MassiveLocalizedEmail", null);

    static final SendMassiveLocalizedEmailFunctionality INSTANCE = new SendMassiveLocalizedEmailFunctionalityImpl();

    protected SendMassiveLocalizedEmailFunctionality() {
        super(INFO, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck(MassiveLocalizedEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call((MassiveLocalizedEmail) input);
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

    protected abstract CompletableFuture<Void> call(MassiveLocalizedEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck(MassiveLocalizedEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck(input == null ? null : (MassiveLocalizedEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck(MassiveLocalizedEmail input) throws Exception {
        return end;
    }

    @Override
    protected final Object getInputFromJsonWork(String inputJson) {
        return MassiveLocalizedEmail.fromJson(inputJson);
    }
}