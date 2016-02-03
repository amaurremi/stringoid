package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Users$AbuseCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String id;

    public IFunnyRestRequest$Users$AbuseCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.id = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.putUserAbuse(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$AbuseCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */