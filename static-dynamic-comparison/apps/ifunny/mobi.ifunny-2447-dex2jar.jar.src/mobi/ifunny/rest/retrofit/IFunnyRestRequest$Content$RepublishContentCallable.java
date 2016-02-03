package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RepublishedCounter;

public class IFunnyRestRequest$Content$RepublishContentCallable
        extends RestCallable<RepublishedCounter> {
    private final Retrofit.RestInterface caller;
    private final String from;
    private final String id;

    public IFunnyRestRequest$Content$RepublishContentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.from = paramString2;
    }

    public RestResponse<RepublishedCounter> call() {
        return this.caller.republishContent(this.id, this.from);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$RepublishContentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */