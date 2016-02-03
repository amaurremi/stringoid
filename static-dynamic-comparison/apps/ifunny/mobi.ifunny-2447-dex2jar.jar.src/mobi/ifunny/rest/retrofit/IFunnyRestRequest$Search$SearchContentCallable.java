package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.SearchResponse;

final class IFunnyRestRequest$Search$SearchContentCallable
        extends RestCallable<SearchResponse> {
    private final Retrofit.RestInterface caller;
    private final String counters;
    private final int limit;
    private final String next;
    private final String prev;
    private final String query;

    public IFunnyRestRequest$Search$SearchContentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
        this.caller = paramRestInterface;
        this.query = paramString1;
        this.limit = paramInt;
        this.prev = paramString2;
        this.next = paramString3;
        this.counters = paramString4;
    }

    public RestResponse<SearchResponse> call() {
        return this.caller.searchContent(this.query, this.limit, this.prev, this.next, this.counters);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Search$SearchContentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */