package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Users$ShareCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final String type;

    public IFunnyRestRequest$Users$ShareCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.type = paramString2;
    }

    public RestResponse<Void> call() {
        return this.caller.shareProfile(this.id, this.type);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Users$ShareCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */