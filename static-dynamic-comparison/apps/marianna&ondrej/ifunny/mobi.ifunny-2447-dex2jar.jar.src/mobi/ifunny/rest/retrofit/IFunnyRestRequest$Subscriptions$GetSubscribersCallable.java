package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.SubscriptionsUserFeed;

public class IFunnyRestRequest$Subscriptions$GetSubscribersCallable
        extends RestCallable<SubscriptionsUserFeed> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final int limit;
    private final String next;
    private final String prev;

    public IFunnyRestRequest$Subscriptions$GetSubscribersCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
    }

    public RestResponse<SubscriptionsUserFeed> call() {
        return this.caller.getSubscribers(this.id, this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Subscriptions$GetSubscribersCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */