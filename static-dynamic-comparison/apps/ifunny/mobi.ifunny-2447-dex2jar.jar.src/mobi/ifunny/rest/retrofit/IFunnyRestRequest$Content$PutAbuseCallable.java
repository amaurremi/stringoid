package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Content$PutAbuseCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String from;
    private final String id;

    public IFunnyRestRequest$Content$PutAbuseCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.from = paramString2;
    }

    public RestResponse<Void> call() {
        return this.caller.putAbuse(this.id, this.from);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$PutAbuseCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */