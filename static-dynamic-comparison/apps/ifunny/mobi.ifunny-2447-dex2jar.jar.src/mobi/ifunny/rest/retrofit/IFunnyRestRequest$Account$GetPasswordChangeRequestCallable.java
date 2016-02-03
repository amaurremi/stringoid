package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$GetPasswordChangeRequestCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String email;

    public IFunnyRestRequest$Account$GetPasswordChangeRequestCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.email = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.passwordChange(this.email);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$GetPasswordChangeRequestCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */