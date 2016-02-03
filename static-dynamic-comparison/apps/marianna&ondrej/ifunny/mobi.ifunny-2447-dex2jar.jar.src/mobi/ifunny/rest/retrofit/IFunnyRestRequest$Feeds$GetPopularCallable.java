package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.IFunnyFeed;

public class IFunnyRestRequest$Feeds$GetPopularCallable
        extends RestCallable<IFunnyFeed> {
    private Retrofit.RestInterface caller;
    private int limit;
    private String next;
    private String prev;

    public IFunnyRestRequest$Feeds$GetPopularCallable(Retrofit.RestInterface paramRestInterface, int paramInt, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.limit = paramInt;
        this.prev = paramString1;
        this.next = paramString2;
    }

    public RestResponse<IFunnyFeed> call() {
        return this.caller.getPopular(this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Feeds$GetPopularCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */