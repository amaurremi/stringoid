package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.WebImageFeed;

final class IFunnyRestRequest$Studio$WebSearchCallable
        extends RestCallable<WebImageFeed> {
    private final Retrofit.RestInterface impl;
    private final String next;
    private final String prev;
    private final String query;
    private final String type;

    private IFunnyRestRequest$Studio$WebSearchCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3, String paramString4) {
        this.impl = paramRestInterface;
        this.query = paramString1;
        this.type = paramString2;
        this.prev = paramString3;
        this.next = paramString4;
    }

    public RestResponse<WebImageFeed> call() {
        return this.impl.searchWebImages(this.query, this.type, this.prev, this.next);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Studio$WebSearchCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */