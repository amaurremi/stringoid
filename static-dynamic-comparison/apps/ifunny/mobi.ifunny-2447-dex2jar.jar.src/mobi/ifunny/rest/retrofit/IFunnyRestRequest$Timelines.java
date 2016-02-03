package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.IFunnyFeed;

public final class IFunnyRestRequest$Timelines {
    public static <T extends e> void getSubscriptions(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Timelines.GetSubscriptionsCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getUser(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Timelines.GetUserCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Timelines.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */