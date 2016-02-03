package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.SmilesCounter;

public class IFunnyRestRequest$Comments$SmileCommentCallable
        extends RestCallable<SmilesCounter> {
    private Retrofit.RestInterface caller;
    private String cid;
    private String id;

    public IFunnyRestRequest$Comments$SmileCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.cid = paramString1;
    }

    public RestResponse<SmilesCounter> call() {
        return this.caller.putSmileComment(this.cid, this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$SmileCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */