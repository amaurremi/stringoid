package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$Subscriptions$UnsubscribeUserCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String uid;

    public IFunnyRestRequest$Subscriptions$UnsubscribeUserCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.uid = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteUserFromSubscribers(this.uid);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Subscriptions$UnsubscribeUserCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */