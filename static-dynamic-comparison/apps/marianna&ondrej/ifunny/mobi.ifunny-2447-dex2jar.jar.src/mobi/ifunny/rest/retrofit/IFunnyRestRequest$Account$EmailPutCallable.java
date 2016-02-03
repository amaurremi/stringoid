package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$EmailPutCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String email;

    public IFunnyRestRequest$Account$EmailPutCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.email = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.putAccountEmail(this.email);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$EmailPutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */