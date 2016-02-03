package mobi.ifunny.rest;

import mobi.ifunny.d.c;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class IFunnyRestHttpClient$Twitter {
    private static final String TWITTER_SHARE_COUNT_API = "http://urls.api.twitter.com/1/urls/count.json";

    public static <T extends e> void sharingCounter(T paramT, String paramString1, String paramString2, RestHttpHandler<String, T> paramRestHttpHandler) {
        c localc = new c();
        localc.a("url", paramString2);
        IFunnyRestHttpClient.get(paramT.getActivity(), paramT, paramString1, "http://urls.api.twitter.com/1/urls/count.json", localc, paramRestHttpHandler);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient$Twitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */