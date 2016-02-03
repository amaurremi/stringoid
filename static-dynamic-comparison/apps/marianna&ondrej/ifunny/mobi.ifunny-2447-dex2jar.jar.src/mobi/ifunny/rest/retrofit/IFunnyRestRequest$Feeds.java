package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.e;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.IFunnyMeanwhileFeed;

public final class IFunnyRestRequest$Feeds {
    public static <T extends e> void getCollective(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Feeds.GetCollectiveCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getFeatured(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Feeds.GetFeaturedCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getMeanwhile(T paramT, String paramString, int paramInt, RestHttpHandler<IFunnyMeanwhileFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.Feeds.GetMeanwhileCallable(Retrofit.rest, paramInt), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void getPopular(T paramT, String paramString1, int paramInt, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.Feeds.GetPopularCallable(Retrofit.rest, paramInt, paramString2, paramString3), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Feeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */