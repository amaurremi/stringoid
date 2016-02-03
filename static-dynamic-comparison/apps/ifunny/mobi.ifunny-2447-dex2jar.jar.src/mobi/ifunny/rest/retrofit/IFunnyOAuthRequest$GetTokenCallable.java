package mobi.ifunny.rest.retrofit;

import java.util.concurrent.Callable;

import mobi.ifunny.rest.content.AccessToken;

public class IFunnyOAuthRequest$GetTokenCallable
        implements Callable<AccessToken> {
    private final Retrofit.AuthInterface caller;
    private final String clientId;
    private final String clientToken;
    private final String clientTokenSecret;
    private final String grantType;
    private final String password;
    private final String username;

    public IFunnyOAuthRequest$GetTokenCallable(Retrofit.AuthInterface paramAuthInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        this.caller = paramAuthInterface;
        this.grantType = paramString1;
        this.clientId = paramString2;
        this.clientToken = paramString3;
        this.clientTokenSecret = paramString4;
        this.username = paramString5;
        this.password = paramString6;
    }

    public AccessToken call() {
        return this.caller.getToken(this.grantType, this.clientId, this.clientToken, this.clientTokenSecret, this.username, this.password);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyOAuthRequest$GetTokenCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */