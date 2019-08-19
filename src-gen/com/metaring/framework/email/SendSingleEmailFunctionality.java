package com.metaring.framework.email;

import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;
import com.metaring.framework.functionality.FunctionalityInfo;
import com.metaring.framework.email.SingleEmail;

abstract class SendSingleEmailFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    static final FunctionalityInfo INFO = FunctionalityInfo.create("com.metaring.framework.email.sendSingleEmail", true, false, false, "com.metaring.framework.email.SingleEmail", null);

    static final SendSingleEmailFunctionality INSTANCE = new SendSingleEmailFunctionalityImpl();

    protected SendSingleEmailFunctionality() {
        super(INFO, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck(SingleEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call((SingleEmail) input);
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

    protected abstract CompletableFuture<Void> call(SingleEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck(SingleEmail input) throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck(input == null ? null : (SingleEmail) input);
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck(SingleEmail input) throws Exception {
        return end;
    }

    @Override
    protected final Object getInputFromJsonWork(String inputJson) {
        return SingleEmail.fromJson(inputJson);
    }
}