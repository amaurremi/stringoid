package mobi.ifunny.rest.retrofit;

import mobi.ifunny.l.a;
import mobi.ifunny.l.e;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.Shares;

public final class IFunnyRestRequest$App {
    public static final String PUSH_TOKEN_TYPE_ADM = "token_adm";
    public static final String PUSH_TOKEN_TYPE_GCM = "token_gcm";
    public static final String SHARE_FACEBOOK = "fb";
    public static final String SHARE_GOOGLE_PLAY = "gp";
    public static final String SHARE_GPLUS = "gplus";
    public static final String SHARE_TWITTER = "tw";

    public static <T extends a> void get(T paramT, String paramString, RestHttpHandler<Shares, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.App.GetCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void get(T paramT, String paramString, RestHttpHandler<Shares, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.App.GetCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends a> void getFeatures(T paramT, String paramString, RestHttpHandler<Features, T> paramRestHttpHandler) {
        new ActivityIFunnyRestTask(paramT, paramString, new IFunnyRestRequest.App.GetFeaturesCallable(Retrofit.rest, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static <T extends e> void post(T paramT, String paramString1, RestHttpHandler<Shares, T> paramRestHttpHandler, String paramString2) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyRestRequest.App.PostCallable(Retrofit.rest, paramString2, null), paramRestHttpHandler, IFunnyRestRequest.access$000()).execute(new Void[0]);
    }

    public static RestResponse<Void> pushTokenPut(String paramString1, String paramString2) {
        return (RestResponse) CommonRestTask.callWithRetries(new IFunnyRestRequest.App.PushTokenPutCallable(Retrofit.rest, paramString1, paramString2, null), 1).result;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$App.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */