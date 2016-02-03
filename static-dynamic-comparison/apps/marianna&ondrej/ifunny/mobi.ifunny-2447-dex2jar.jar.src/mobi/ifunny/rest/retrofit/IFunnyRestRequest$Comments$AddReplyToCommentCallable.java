package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.Comment;

public final class IFunnyRestRequest$Comments$AddReplyToCommentCallable
        extends RestCallable<Comment> {
    private final Retrofit.RestInterface caller;
    private final String cid;
    private final String id;
    private final String text;

    public IFunnyRestRequest$Comments$AddReplyToCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2, String paramString3) {
        this.caller = paramRestInterface;
        this.cid = paramString1;
        this.id = paramString2;
        this.text = paramString3;
    }

    public RestResponse<Comment> call() {
        return this.caller.addReplyToComment(this.cid, this.id, this.text);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Comments$AddReplyToCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */