package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$CoverDeleteCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$Account$CoverDeleteCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteAccountCover();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$CoverDeleteCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */