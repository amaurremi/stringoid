package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.MemeSourcesFeed;

final class IFunnyRestRequest$Studio$MemeSourcesCallable
        extends RestCallable<MemeSourcesFeed> {
    private final Retrofit.RestInterface caller;
    private final String category;
    private final int limit;
    private final String next;
    private final String prev;

    private IFunnyRestRequest$Studio$MemeSourcesCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.category = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
    }

    public RestResponse<MemeSourcesFeed> call() {
        return this.caller.getMemeSources(this.category, this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Studio$MemeSourcesCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */