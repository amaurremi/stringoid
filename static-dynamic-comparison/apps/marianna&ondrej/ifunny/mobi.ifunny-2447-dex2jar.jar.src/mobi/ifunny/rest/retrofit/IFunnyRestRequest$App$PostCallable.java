package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.Shares;

final class IFunnyRestRequest$App$PostCallable
        extends RestCallable<Shares> {
    private final Retrofit.RestInterface caller;
    private final String type;

    private IFunnyRestRequest$App$PostCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.type = paramString;
    }

    public RestResponse<Shares> call() {
        return this.caller.post(this.type);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$App$PostCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */