package retrofit;

import java.util.concurrent.Executor;

abstract class CallbackRunnable<T>
        implements Runnable {
    private final Callback<T> callback;
    private final Executor callbackExecutor;
    private final ErrorHandler errorHandler;

    CallbackRunnable(Callback<T> paramCallback, Executor paramExecutor, ErrorHandler paramErrorHandler) {
        this.callback = paramCallback;
        this.callbackExecutor = paramExecutor;
        this.errorHandler = paramErrorHandler;
    }

    public abstract ResponseWrapper obtainResponse();

    public final void run() {
        Throwable localThrowable;
        try {
            ResponseWrapper localResponseWrapper = obtainResponse();
            this.callbackExecutor.execute(new CallbackRunnable .1 (this, localResponseWrapper));
            return;
        } catch (RetrofitError localRetrofitError1) {
            localThrowable = this.errorHandler.handleError(localRetrofitError1);
            if (localThrowable != localRetrofitError1) {
            }
        }
        for (; ; ) {
            this.callbackExecutor.execute(new CallbackRunnable .2 (this, localRetrofitError1));
            return;
            RetrofitError localRetrofitError2 = RetrofitError.unexpectedError(localRetrofitError1.getUrl(), localThrowable);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/CallbackRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */