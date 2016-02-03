package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.CoverFeed;

final class IFunnyRestRequest$Account$CoverFeedCallable
        extends RestCallable<CoverFeed> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$Account$CoverFeedCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<CoverFeed> call() {
        return this.caller.getCovers();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$CoverFeedCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */