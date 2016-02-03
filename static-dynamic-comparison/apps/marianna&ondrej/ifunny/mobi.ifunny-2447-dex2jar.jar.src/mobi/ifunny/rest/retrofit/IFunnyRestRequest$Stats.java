package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.h;

public final class IFunnyRestRequest$Stats {
    public static <T extends h> void collectStats(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new IFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Stats.CollectStatsCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */