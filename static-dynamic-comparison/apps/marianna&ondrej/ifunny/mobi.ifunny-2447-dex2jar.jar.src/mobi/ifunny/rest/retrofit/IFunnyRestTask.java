package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.h;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.RestError.RestErrorProxy;
import retrofit.RetrofitError;
import retrofit.RetrofitError.Kind;

public class IFunnyRestTask<Target extends h, Result>
        extends CommonRestTask<Target, RestResponse<Result>> {
    private final NotificationListener notificationListener;
    private final Class<? extends RestError.RestErrorProxy> restErrorProxyClass;
    protected final RestHttpHandler<Result, Target> restHandler;

    public IFunnyRestTask(Target paramTarget, String paramString, RestCallable<Result> paramRestCallable, int paramInt, RestHttpHandler<Result, Target> paramRestHttpHandler, NotificationListener paramNotificationListener, Class<? extends RestError.RestErrorProxy> paramClass) {
        super(paramTarget, paramString, paramRestCallable, paramInt);
        this.restHandler = paramRestHttpHandler;
        this.restErrorProxyClass = paramClass;
        this.notificationListener = paramNotificationListener;
    }

    public IFunnyRestTask(Target paramTarget, String paramString, RestCallable<Result> paramRestCallable, RestHttpHandler<Result, Target> paramRestHttpHandler, NotificationListener paramNotificationListener) {
        this(paramTarget, paramString, paramRestCallable, 3, paramRestHttpHandler, paramNotificationListener, RestErrorBody.class);
    }

    protected void onCancel(Target paramTarget) {
        super.onCancel(paramTarget);
        if (this.restHandler != null) {
            this.restHandler.onCancelCallback(paramTarget);
        }
    }

    protected void onFail(Target paramTarget, Throwable paramThrowable) {
        if (this.restHandler != null) {
            if (!(paramThrowable instanceof RetrofitError)) {
                break label51;
            }
        }
        label51:
        for (paramThrowable = RestError.retrofitError(this.restErrorProxyClass, (RetrofitError) paramThrowable); paramThrowable.getErrorKind() != RetrofitError.Kind.HTTP; paramThrowable = RestError.unexpectedError(paramThrowable)) {
            this.restHandler.onExceptionCallback(paramTarget, paramThrowable.getCause());
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

    protected void onSuccess(Target paramTarget, RestResponse<Result> paramRestResponse) {
        if (this.restHandler != null) {
            if (paramRestResponse == null) {
                this.restHandler.onSuccessCallback(paramTarget, null);
            }
        } else {
            return;
        }
        if ((this.notificationListener != null) && (paramRestResponse.notifications != null)) {
            this.notificationListener.onNotification(paramRestResponse.notifications);
        }
        this.restHandler.onSuccessCallback(paramTarget, paramRestResponse.data);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */