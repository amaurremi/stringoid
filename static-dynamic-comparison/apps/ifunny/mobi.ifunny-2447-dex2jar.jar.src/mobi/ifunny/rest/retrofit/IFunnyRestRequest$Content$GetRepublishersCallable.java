package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RepublishersFeed;

public class IFunnyRestRequest$Content$GetRepublishersCallable
        extends RestCallable<RepublishersFeed> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final int limit;
    private final String next;
    private final String prev;

    public IFunnyRestRequest$Content$GetRepublishersCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.cid = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
    }

    public RestResponse<RepublishersFeed> call() {
        return this.caller.getRepublishers(this.cid, this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$GetRepublishersCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */