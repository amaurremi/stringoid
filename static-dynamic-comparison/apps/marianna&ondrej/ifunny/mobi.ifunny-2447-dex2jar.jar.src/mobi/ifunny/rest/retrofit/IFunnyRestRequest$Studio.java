package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.MemeSourcesFeed;
import mobi.ifunny.rest.content.RageMetaWrapper;
import mobi.ifunny.rest.content.WebImageFeed;

public final class IFunnyRestRequest$Studio {
    private static final String WEB_SEARCH_TYPE_GIF = "gif";
    private static final String WEB_SEARCH_TYPE_IMAGES = "pic";

    public static <T extends a> void getComicsSources(T paramT, String paramString, RestHttpHandler<RageMetaWrapper, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Studio.ComicsSourcesCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getMemeSources(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<MemeSourcesFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Studio.MemeSourcesCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void searchMemeSources(T paramT, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, RestHttpHandler<MemeSourcesFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Studio.MemeSearchCallable(Retrofit.rest, paramString2, paramInt, paramString3, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void searchWebGifs(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, RestHttpHandler<WebImageFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Studio.WebSearchCallable(Retrofit.rest, paramString2, "gif", paramString3, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void searchWebImages(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, RestHttpHandler<WebImageFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Studio.WebSearchCallable(Retrofit.rest, paramString2, "pic", paramString3, paramString4, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Studio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */