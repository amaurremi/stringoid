package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Account$PhotoDeleteCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;

    private IFunnyRestRequest$Account$PhotoDeleteCallable(Retrofit.RestInterface paramRestInterface) {
        this.caller = paramRestInterface;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteAccountPhoto();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Account$PhotoDeleteCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */