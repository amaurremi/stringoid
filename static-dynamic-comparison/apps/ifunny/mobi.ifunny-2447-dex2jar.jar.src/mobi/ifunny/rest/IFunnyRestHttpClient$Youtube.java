package mobi.ifunny.rest;

import mobi.ifunny.d.c;
import mobi.ifunny.l.a;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class IFunnyRestHttpClient$Youtube {
    private static final String YOUTUBE_FEEDS_API_VIDEOS = "http://gdata.youtube.com/feeds/api/videos";

    public static <T extends a> void info(T paramT, String paramString1, String paramString2, RestHttpHandler<String, T> paramRestHttpHandler) {
        c localc = youtubeParams();
        IFunnyRestHttpClient.get(paramT, paramT, paramString1, "http://gdata.youtube.com/feeds/api/videos/" + paramString2, localc, paramRestHttpHandler);
    }

    public static <T extends a> void search(T paramT, String paramString1, String paramString2, int paramInt1, int paramInt2, RestHttpHandler<String, T> paramRestHttpHandler) {
        c localc = youtubeParams();
        localc.a("q", paramString2);
        localc.a("start-index", Integer.toString(paramInt1));
        localc.a("max-results", Integer.toString(paramInt2));
        localc.a("orderby", "relevance");
        IFunnyRestHttpClient.get(paramT, paramT, paramString1, "http://gdata.youtube.com/feeds/api/videos", localc, paramRestHttpHandler);
    }

    private static c youtubeParams() {
        c localc = new c();
        localc.a("v", "2");
        localc.a("alt", "jsonc");
        localc.a("format", "6");
        localc.a("mobile", "1");
        return localc;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient$Youtube.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */