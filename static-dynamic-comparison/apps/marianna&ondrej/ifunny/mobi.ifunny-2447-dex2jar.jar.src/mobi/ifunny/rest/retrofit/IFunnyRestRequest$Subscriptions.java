package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.SubscriptionsUserFeed;

public final class IFunnyRestRequest$Subscriptions {
    public static <T extends e> void getSubscribers(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<SubscriptionsUserFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Subscriptions.GetSubscribersCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getSubscriptions(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<SubscriptionsUserFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Subscriptions.GetSubscriptionsCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void subscribeUser(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Subscriptions.SubscribeUserCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void unsubscribeUser(T paramT, String paramString1, String paramString2, RestHttpHandler<Void, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Subscriptions.UnsubscribeUserCallable(Retrofit.rest, paramString2), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Subscriptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */