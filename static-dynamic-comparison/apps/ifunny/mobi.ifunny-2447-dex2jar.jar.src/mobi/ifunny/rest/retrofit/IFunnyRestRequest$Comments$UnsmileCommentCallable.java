package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.SmilesCounter;

public final class IFunnyRestRequest$Comments$UnsmileCommentCallable
        extends RestCallable<SmilesCounter> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;

    public IFunnyRestRequest$Comments$UnsmileCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.cid = paramString1;
    }

    public RestResponse<SmilesCounter> call() {
        return this.caller.putUnsmileComment(this.cid, this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$UnsmileCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */