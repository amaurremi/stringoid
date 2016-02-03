package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.DeleteResponcesList;

final class IFunnyRestRequest$Comments$DeleteCommentsCallable
        extends RestCallable<DeleteResponcesList> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;

    public IFunnyRestRequest$Comments$DeleteCommentsCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.cid = paramString1;
    }

    public RestResponse<DeleteResponcesList> call() {
        return this.caller.deleteComments(this.cid, "DELETE", this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$DeleteCommentsCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */