package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Subscriptions$SubscribeUserCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String uid;

    public IFunnyRestRequest$Subscriptions$SubscribeUserCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.uid = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.putUserToSubscribers(this.uid);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Subscriptions$SubscribeUserCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */