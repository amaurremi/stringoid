package mobi.ifunny.rest.retrofit;

public class IFunnyOAuthRequest$RevokeTokenCallable
        extends RestCallable<Object> {
    private final Retrofit.AuthInterface caller;
    private final String token;

    public IFunnyOAuthRequest$RevokeTokenCallable(Retrofit.AuthInterface paramAuthInterface, String paramString) {
        this.caller = paramAuthInterface;
        this.token = paramString;
    }

    public RestResponse<Object> call() {
        return this.caller.revokeToken(this.token);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyOAuthRequest$RevokeTokenCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */