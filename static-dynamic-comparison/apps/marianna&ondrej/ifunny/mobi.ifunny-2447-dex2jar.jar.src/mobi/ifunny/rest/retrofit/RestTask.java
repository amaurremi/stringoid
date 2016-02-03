package mobi.ifunny.rest.retrofit;

import java.util.concurrent.Callable;

import mobi.ifunny.l.h;
import mobi.ifunny.rest.content.RestError;
import retrofit.RetrofitError;
import retrofit.RetrofitError.Kind;

public class RestTask<Target extends h, Result>
        extends CommonRestTask<Target, Result> {
    protected final RestHttpHandler<Result, Target> restHandler;

    public RestTask(Target paramTarget, String paramString, Callable<Result> paramCallable, int paramInt, RestHttpHandler<Result, Target> paramRestHttpHandler) {
        super(paramTarget, paramString, paramCallable, paramInt);
        this.restHandler = paramRestHttpHandler;
    }

    protected RestError handleFail(Throwable paramThrowable) {
        if ((paramThrowable instanceof RetrofitError)) {
            return RestError.retrofitError(null, (RetrofitError) paramThrowable);
        }
        return RestError.unexpectedError(paramThrowable);
    }

    protected void onCancel(Target paramTarget) {
        super.onCancel(paramTarget);
        if (this.restHandler != null) {
            this.restHandler.onCancelCallback(paramTarget);
        }
    }

    protected void onFail(Target paramTarget, Throwable paramThrowable) {
        if (this.restHandler != null) {
            paramThrowable = handleFail(paramThrowable);
            if (paramThrowable.getErrorKind() != RetrofitError.Kind.HTTP) {
                this.restHandler.onExceptionCallback(paramTarget, paramThrowable.getCause());
            }
        } else {
            return;
        }
        this.restHandler.onFailureCallback(paramTarget, paramThrowable);
    }

    protected void onFinished(Target paramTarget) {
        super.onFinished(paramTarget);
        if (this.restHandler != null) {
            this.restHandler.onFinishCallback(paramTarget);
        }
    }

    protected void onProgressUpdate(Target paramTarget, Integer... paramVarArgs) {
        super.onProgressUpdate(paramTarget, paramVarArgs);
        if (this.restHandler != null) {
            this.restHandler.onProgressCallback(paramTarget, paramVarArgs[0].intValue());
        }
    }

    protected void onStarted(Target paramTarget) {
        super.onStarted(paramTarget);
        if (this.restHandler != null) {
            this.restHandler.onStartCallback(paramTarget);
        }
    }

    protected void onSuccess(Target paramTarget, Result paramResult) {
        if (this.restHandler != null) {
            this.restHandler.onSuccessCallback(paramTarget, paramResult);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */