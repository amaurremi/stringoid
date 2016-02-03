package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.GetComment;

public final class IFunnyRestRequest$Content$GetCommentCallable
        extends RestCallable<GetComment> {
    private final Retrofit.RestInterface caller;
    private final String contentId;
    private final String id;

    public IFunnyRestRequest$Content$GetCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString2;
        this.contentId = paramString1;
    }

    public RestResponse<GetComment> call() {
        return this.caller.getComment(this.contentId, this.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$GetCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */