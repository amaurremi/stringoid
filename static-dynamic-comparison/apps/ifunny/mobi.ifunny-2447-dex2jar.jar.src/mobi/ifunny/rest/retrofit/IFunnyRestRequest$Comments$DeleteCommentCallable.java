package mobi.ifunny.rest.retrofit;

public class IFunnyRestRequest$Comments$DeleteCommentCallable
        extends RestCallable<Void> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;

    public IFunnyRestRequest$Comments$DeleteCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.cid = paramString1;
    }

    public RestResponse<Void> call() {
        return this.caller.deleteComment(this.cid, this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$DeleteCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */