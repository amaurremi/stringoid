package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.IFunnyMeanwhileFeed;

public class IFunnyRestRequest$Feeds$GetMeanwhileCallable
        extends RestCallable<IFunnyMeanwhileFeed> {
    private final Retrofit.RestInterface caller;
    private final int limit;

    public IFunnyRestRequest$Feeds$GetMeanwhileCallable(Retrofit.RestInterface paramRestInterface, int paramInt) {
        this.caller = paramRestInterface;
        this.limit = paramInt;
    }

    public RestResponse<IFunnyMeanwhileFeed> call() {
        return this.caller.getMeanwhile(this.limit);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Feeds$GetMeanwhileCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */