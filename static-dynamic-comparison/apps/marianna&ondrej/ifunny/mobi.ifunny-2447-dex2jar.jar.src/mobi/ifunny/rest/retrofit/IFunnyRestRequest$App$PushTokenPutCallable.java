package mobi.ifunny.rest.retrofit;

final class IFunnyRestRequest$App$PushTokenPutCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String token;
    private final String type;

    private IFunnyRestRequest$App$PushTokenPutCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.type = paramString1;
        this.token = paramString2;
    }

    public RestResponse<Void> call() {
        return this.caller.putPushToken(this.type, this.token);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$App$PushTokenPutCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */