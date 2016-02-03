package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.IFunny;

public class IFunnyRestRequest$Content$GetContentCallable
        extends RestCallable<IFunny> {
    private final Retrofit.RestInterface caller;
    private final String id;

    public IFunnyRestRequest$Content$GetContentCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.id = paramString;
    }

    public RestResponse<IFunny> call() {
        return this.caller.getContent(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$GetContentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */