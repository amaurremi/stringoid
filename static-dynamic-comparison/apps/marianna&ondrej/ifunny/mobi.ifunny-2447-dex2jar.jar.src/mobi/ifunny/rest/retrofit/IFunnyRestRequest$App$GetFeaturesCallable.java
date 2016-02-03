package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.Features;

final class IFunnyRestRequest$App$GetFeaturesCallable
        extends RestCallable<Features> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$App$GetFeaturesCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<Features> call() {
        return this.caller.getFeatures();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$App$GetFeaturesCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */