package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Users$RegisterCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String client_id;
    private final String client_token;
    private final String client_token_secret;
    private final String email;
    private final String nick;
    private final String password;
    private final String reg_type;

    public IFunnyRestRequest$Users$RegisterCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this.caller = paramRestInterface;
        this.nick = paramString2;
        this.reg_type = paramString1;
        this.email = paramString3;
        this.client_id = paramString4;
        this.client_token = paramString5;
        this.client_token_secret = paramString6;
        this.password = paramString7;
    }

    public RestResponse<Void> call() {
        return this.caller.register(this.reg_type, this.nick, this.email, this.client_id, this.client_token, this.client_token_secret, this.password);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$RegisterCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */