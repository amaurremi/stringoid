package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.NewsFeed;

final class IFunnyRestRequest$Users$GetMyNewsCallable
        extends RestCallable<NewsFeed> {
    private final Retrofit.RestInterface caller;
    private final int limit;
    private final String next;
    private final String prev;

    public IFunnyRestRequest$Users$GetMyNewsCallable(Retrofit.RestInterface paramRestInterface, int paramInt, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.limit = paramInt;
        this.prev = paramString1;
        this.next = paramString2;
    }

    public RestResponse<NewsFeed> call() {
        return this.caller.getMyNews(this.limit, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$GetMyNewsCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */