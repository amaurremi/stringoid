package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.Shares;

final class IFunnyRestRequest$App$GetCallable
        extends RestCallable<Shares> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$App$GetCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<Shares> call() {
        return this.caller.getShares();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$App$GetCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */