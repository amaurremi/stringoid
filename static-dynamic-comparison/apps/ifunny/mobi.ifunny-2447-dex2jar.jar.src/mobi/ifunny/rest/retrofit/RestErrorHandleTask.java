package mobi.ifunny.rest.retrofit;

import java.util.concurrent.Callable;

import mobi.ifunny.l.h;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.RestError.RestErrorProxy;
import retrofit.RetrofitError;

public class RestErrorHandleTask<Target extends h, Result>
        extends RestTask<Target, Result> {
    private final Class<? extends RestError.RestErrorProxy> restErrorProxyClass;

    public RestErrorHandleTask(Target paramTarget, String paramString, Callable<Result> paramCallable, RestHttpHandler<Result, Target> paramRestHttpHandler, int paramInt, Class<? extends RestError.RestErrorProxy> paramClass) {
        super(paramTarget, paramString, paramCallable, paramInt, paramRestHttpHandler);
        this.restErrorProxyClass = paramClass;
    }

    public RestErrorHandleTask(Target paramTarget, String paramString, Callable<Result> paramCallable, RestHttpHandler<Result, Target> paramRestHttpHandler, Class<? extends RestError.RestErrorProxy> paramClass) {
        this(paramTarget, paramString, paramCallable, paramRestHttpHandler, 3, paramClass);
    }

    protected RestError handleFail(Throwable paramThrowable) {
        if ((paramThrowable instanceof RetrofitError)) {
            return RestError.retrofitError(this.restErrorProxyClass, (RetrofitError) paramThrowable);
        }
        return RestError.unexpectedError(paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestErrorHandleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */