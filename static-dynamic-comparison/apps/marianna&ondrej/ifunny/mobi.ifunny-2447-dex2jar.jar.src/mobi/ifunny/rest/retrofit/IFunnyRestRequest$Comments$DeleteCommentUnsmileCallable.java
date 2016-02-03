package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.SmilesCounter;

public final class IFunnyRestRequest$Comments$DeleteCommentUnsmileCallable
        extends RestCallable<SmilesCounter> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;

    public IFunnyRestRequest$Comments$DeleteCommentUnsmileCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.cid = paramString1;
    }

    public RestResponse<SmilesCounter> call() {
        return this.caller.deleteUnsmileComment(this.cid, this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$DeleteCommentUnsmileCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */