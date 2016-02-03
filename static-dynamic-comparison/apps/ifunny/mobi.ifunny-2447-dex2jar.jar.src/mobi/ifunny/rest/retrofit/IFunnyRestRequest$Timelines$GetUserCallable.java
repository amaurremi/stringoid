package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.IFunnyFeed;

final class IFunnyRestRequest$Timelines$GetUserCallable
        extends RestCallable<IFunnyFeed> {
    private final Retrofit.RestInterface caller;
    private final int limit;
    private final String next;
    private final String prev;
    private final String uid;

    private IFunnyRestRequest$Timelines$GetUserCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.uid = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
    }

    public RestResponse<IFunnyFeed> call() {
        return this.caller.getTimelineForUser(this.uid, this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Timelines$GetUserCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */