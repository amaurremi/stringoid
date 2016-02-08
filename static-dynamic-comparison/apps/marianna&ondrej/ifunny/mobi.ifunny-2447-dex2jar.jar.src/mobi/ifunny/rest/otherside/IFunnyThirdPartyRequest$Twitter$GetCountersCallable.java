package mobi.ifunny.rest.otherside;

import java.util.concurrent.Callable;

public class IFunnyThirdPartyRequest$Twitter$GetCountersCallable
        implements Callable<TwitterShareCounters> {
    private OthersRetrofit$TwitterInterface twitterInterface;
    private String url;

    public IFunnyThirdPartyRequest$Twitter$GetCountersCallable(OthersRetrofit$TwitterInterface paramTwitterInterface, String paramString) {
        this.twitterInterface = paramTwitterInterface;
        this.url = paramString;
    }

    public TwitterShareCounters call() {
        return this.twitterInterface.getCounters(this.url);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/IFunnyThirdPartyRequest$Twitter$GetCountersCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */