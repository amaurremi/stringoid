package mobi.ifunny.rest.otherside;

import mobi.ifunny.l.e;
import mobi.ifunny.rest.retrofit.RestErrorHandleTask;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public final class IFunnyThirdPartyRequest$Twitter {
    public static <T extends e> void getCounters(T paramT, String paramString1, String paramString2, RestHttpHandler<TwitterShareCounters, T> paramRestHttpHandler) {
        new RestErrorHandleTask(paramT, paramString1, new IFunnyThirdPartyRequest.Twitter.GetCountersCallable(OthersRetrofit.twitter, paramString2), paramRestHttpHandler, TwitterRestError.class).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/IFunnyThirdPartyRequest$Twitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */