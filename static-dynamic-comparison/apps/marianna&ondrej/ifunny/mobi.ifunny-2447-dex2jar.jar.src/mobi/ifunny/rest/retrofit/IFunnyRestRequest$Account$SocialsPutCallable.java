package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$SocialsPutCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String client_id;
    private final String client_token;
    private final String client_token_secret;
    private final boolean hidden;
    private final String network;

    private IFunnyRestRequest$Account$SocialsPutCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
        this.caller = paramRestInterface;
        this.network = paramString1;
        this.client_id = paramString2;
        this.client_token = paramString3;
        this.client_token_secret = paramString4;
        this.hidden = paramBoolean;
    }

    public RestResponse<Void> call() {
        Retrofit.RestInterface localRestInterface = this.caller;
        String str1 = this.network;
        String str2 = this.client_id;
        String str3 = this.client_token;
        String str4 = this.client_token_secret;
        if (this.hidden) {
        }
        for (int i = 1; ; i = 0) {
            return localRestInterface.putAccountSocials(str1, str2, str3, str4, i);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$SocialsPutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */