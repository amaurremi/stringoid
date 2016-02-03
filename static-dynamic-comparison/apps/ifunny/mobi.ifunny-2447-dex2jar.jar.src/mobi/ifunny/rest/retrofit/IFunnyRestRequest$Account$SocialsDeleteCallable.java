package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$SocialsDeleteCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String network;

    private IFunnyRestRequest$Account$SocialsDeleteCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.network = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteAccountSocials(this.network);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$SocialsDeleteCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */