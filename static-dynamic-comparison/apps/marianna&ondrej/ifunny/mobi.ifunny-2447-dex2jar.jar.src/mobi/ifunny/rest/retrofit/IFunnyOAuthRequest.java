package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.AccessToken;

public class IFunnyOAuthRequest {
    private static final String GRANT_TYPE_FACEBOOK = "urn:ifunny:oauth2:facebook";
    private static final String GRANT_TYPE_GPLUS = "urn:ifunny:oauth2:googleplus";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String GRANT_TYPE_TWITTER = "urn:ifunny:oauth2:twitter";

    public static <T extends mobi.ifunny.l.e> void getToken(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, RestHttpHandler<AccessToken, T> paramRestHttpHandler) {
        new RestErrorHandleTask(paramT, paramString1, new IFunnyOAuthRequest.GetTokenCallable(Retrofit.auth, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7), paramRestHttpHandler, RestErrorBody.class).execute(new Void[0]);
    }

    public static <T extends mobi.ifunny.l.e> void getTokenByFacebook(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<AccessToken, T> paramRestHttpHandler) {
        getToken(paramT, paramString1, "urn:ifunny:oauth2:facebook", paramString2, paramString3, null, null, null, paramRestHttpHandler);
    }

    public static <T extends mobi.ifunny.l.e> void getTokenByGPlus(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<AccessToken, T> paramRestHttpHandler) {
        getToken(paramT, paramString1, "urn:ifunny:oauth2:googleplus", paramString2, paramString3, null, null, null, paramRestHttpHandler);
    }

    public static <T extends mobi.ifunny.l.e> void getTokenByPassword(T paramT, String paramString1, String paramString2, String paramString3, RestHttpHandler<AccessToken, T> paramRestHttpHandler) {
        getToken(paramT, paramString1, "password", null, null, null, paramString2, paramString3, paramRestHttpHandler);
    }

    public static <T extends mobi.ifunny.l.e> void getTokenByTwitter(T paramT, String paramString1, String paramString2, String paramString3, String paramString4, RestHttpHandler<AccessToken, T> paramRestHttpHandler) {
        getToken(paramT, paramString1, "urn:ifunny:oauth2:twitter", paramString2, paramString3, paramString4, null, null, paramRestHttpHandler);
    }

    public static <T extends mobi.ifunny.l.e> void revokeToken(T paramT, String paramString1, String paramString2, RestHttpHandler<Object, T> paramRestHttpHandler) {
        new FragmentIFunnyRestTask(paramT, paramString1, new IFunnyOAuthRequest.RevokeTokenCallable(Retrofit.auth, paramString2), paramRestHttpHandler, mobi.ifunny.e.a).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyOAuthRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */