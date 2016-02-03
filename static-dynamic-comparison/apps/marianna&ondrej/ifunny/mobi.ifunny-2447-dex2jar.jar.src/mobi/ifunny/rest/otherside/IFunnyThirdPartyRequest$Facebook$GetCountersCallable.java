package mobi.ifunny.rest.otherside;

import java.util.concurrent.Callable;

public class IFunnyThirdPartyRequest$Facebook$GetCountersCallable
        implements Callable<FacebookShareCounters> {
    private OthersRetrofit.FacebookInterface facebookInterface;
    private String url;

    public IFunnyThirdPartyRequest$Facebook$GetCountersCallable(OthersRetrofit.FacebookInterface paramFacebookInterface, String paramString) {
        this.facebookInterface = paramFacebookInterface;
        this.url = paramString;
    }

    public FacebookShareCounters call() {
        return this.facebookInterface.getCounters(this.url);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/IFunnyThirdPartyRequest$Facebook$GetCountersCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */