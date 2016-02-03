package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;

public final class IFunnyRestRequest$Counters {
    public static <T extends a> void getCounters(T paramT, String paramString, RestHttpHandler<RestNotification.Counters, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Counters.GetCountersCallable(Retrofit.rest), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Counters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */