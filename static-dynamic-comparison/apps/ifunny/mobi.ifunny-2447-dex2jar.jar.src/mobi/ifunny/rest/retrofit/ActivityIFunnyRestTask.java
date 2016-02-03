package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.rest.content.RestError.RestErrorProxy;

public class ActivityIFunnyRestTask<Target extends a, Result>
        extends IFunnyRestTask<Target, Result> {
    public ActivityIFunnyRestTask(Target paramTarget, String paramString, RestCallable<Result> paramRestCallable, int paramInt, RestHttpHandler<Result, Target> paramRestHttpHandler, NotificationListener paramNotificationListener, Class<? extends RestError.RestErrorProxy> paramClass) {
        super(paramTarget, paramString, paramRestCallable, paramInt, paramRestHttpHandler, paramNotificationListener, paramClass);
    }

    public ActivityIFunnyRestTask(Target paramTarget, String paramString, RestCallable<Result> paramRestCallable, RestHttpHandler<Result, Target> paramRestHttpHandler, NotificationListener paramNotificationListener) {
        this(paramTarget, paramString, paramRestCallable, 3, paramRestHttpHandler, paramNotificationListener, RestErrorBody.class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/ActivityIFunnyRestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */