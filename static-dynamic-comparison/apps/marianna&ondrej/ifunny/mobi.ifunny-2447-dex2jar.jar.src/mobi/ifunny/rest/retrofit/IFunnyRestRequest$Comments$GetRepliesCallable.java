package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RepliesFeed;

public final class IFunnyRestRequest$Comments$GetRepliesCallable
        extends RestCallable<RepliesFeed> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;
    private final int limit;
    private final String next;
    private final String prev;
    private final String showId;

    public IFunnyRestRequest$Comments$GetRepliesCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5) {
        this.caller = paramRestInterface;
        this.cid = paramString1;
        this.id = paramString2;
        this.limit = paramInt;
        this.showId = paramString3;
        this.prev = paramString4;
        this.next = paramString5;
    }

    public RestResponse<RepliesFeed> call() {
        return this.caller.getReplies(this.cid, this.id, this.limit, this.showId, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$GetRepliesCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */