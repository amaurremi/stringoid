package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Content$ContentStatCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final String op;
    private final String shareType;

    public IFunnyRestRequest$Content$ContentStatCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.op = paramString2;
        this.shareType = paramString3;
    }

    public RestResponse<Void> call() {
        return this.caller.contentStat(this.id, this.op, this.shareType);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$ContentStatCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */