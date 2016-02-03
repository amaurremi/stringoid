package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.MemeSourcesFeed;

final class IFunnyRestRequest$Studio$MemeSearchCallable
        extends RestCallable<MemeSourcesFeed> {
    private final Retrofit.RestInterface caller;
    private final int limit;
    private final String next;
    private final String prev;
    private final String query;

    private IFunnyRestRequest$Studio$MemeSearchCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.query = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
    }

    public RestResponse<MemeSourcesFeed> call() {
        return this.caller.searchMemeSources(this.query, this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Studio$MemeSearchCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */