package com.metaring.framework.email;

import com.metaring.framework.SysKB;
import java.util.concurrent.CompletableFuture;
import com.metaring.framework.functionality.AbstractFunctionality;
import com.metaring.framework.functionality.GeneratedFunctionality;

public abstract class ReinitFunctionality extends AbstractFunctionality implements GeneratedFunctionality {

    protected ReinitFunctionality(SysKB sysKB) {
        super(sysKB, EmailFunctionalitiesManager.REINIT, null);
    }

    @Override
    protected final CompletableFuture<Void> beforePreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = beforePreConditionCheck();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePreConditionCheck() throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> preConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = preConditionCheck();
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> preConditionCheck() throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPreConditionCheck(Object input) throws Exception {
        CompletableFuture<Void> response = afterPreConditionCheck();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPreConditionCheck() throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforeCall(Object input) throws Exception {
        CompletableFuture<Void> response = beforeCall();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforeCall() throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Object> call(Object input) throws Exception {
        CompletableFuture<Void> call = call();
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

    protected abstract CompletableFuture<Void> call() throws Exception;

    @Override
    protected final CompletableFuture<Void> afterCall(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterCall();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterCall() throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> beforePostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = beforePostConditionCheck();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> beforePostConditionCheck() throws Exception {
        return end;
    }

    @Override
    protected final CompletableFuture<Void> postConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = postConditionCheck();
        return response == null ? end : response;
    }

    protected abstract CompletableFuture<Void> postConditionCheck() throws Exception;

    @Override
    protected final CompletableFuture<Void> afterPostConditionCheck(Object input, Object output) throws Exception {
        CompletableFuture<Void> response = afterPostConditionCheck();
        return response == null ? end : response;
    }

    protected CompletableFuture<Void> afterPostConditionCheck() throws Exception {
        return end;
    }

    protected static final ReinitFunctionality create(SysKB sysKB) {
        return new ReinitFunctionalityImpl(sysKB);
    }
}