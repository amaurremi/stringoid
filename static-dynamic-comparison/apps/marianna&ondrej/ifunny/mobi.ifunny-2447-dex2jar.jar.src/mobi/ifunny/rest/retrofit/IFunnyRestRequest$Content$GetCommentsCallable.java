package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.CommentsFeedImpl;

public final class IFunnyRestRequest$Content$GetCommentsCallable
        extends RestCallable<CommentsFeedImpl> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final int limit;
    private final String next;
    private final String prev;
    private final String showId;

    public IFunnyRestRequest$Content$GetCommentsCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.limit = paramInt;
        this.showId = paramString2;
        this.prev = paramString3;
        this.next = paramString4;
    }

    public RestResponse<CommentsFeedImpl> call() {
        return this.caller.getComments(this.id, this.limit, this.showId, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$GetCommentsCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */