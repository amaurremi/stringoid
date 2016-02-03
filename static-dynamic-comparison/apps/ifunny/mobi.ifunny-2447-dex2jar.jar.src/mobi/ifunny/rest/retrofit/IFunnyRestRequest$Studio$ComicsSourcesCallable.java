package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RageMetaWrapper;

final class IFunnyRestRequest$Studio$ComicsSourcesCallable
        extends RestCallable<RageMetaWrapper> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$Studio$ComicsSourcesCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<RageMetaWrapper> call() {
        return this.caller.getComicsSources();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Studio$ComicsSourcesCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */