package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Content$DeleteContentCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String id;

    public IFunnyRestRequest$Content$DeleteContentCallable(Retrofit.RestInterface paramRestInterface, String paramString) {
        this.caller = paramRestInterface;
        this.id = paramString;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteContent(this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$DeleteContentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */