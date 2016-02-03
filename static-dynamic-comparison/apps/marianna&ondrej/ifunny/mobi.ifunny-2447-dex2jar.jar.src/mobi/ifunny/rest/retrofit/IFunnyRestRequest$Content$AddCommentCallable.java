package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.Comment;

public final class IFunnyRestRequest$Content$AddCommentCallable
        extends RestCallable<Comment> {
    private final Retrofit.RestInterface caller;
    private final String id;
    private final String text;

    public IFunnyRestRequest$Content$AddCommentCallable(Retrofit.RestInterface paramRestInterface, String paramString1, String paramString2) {
        this.caller = paramRestInterface;
        this.id = paramString1;
        this.text = paramString2;
    }

    public RestResponse<Comment> call() {
        return this.caller.addComment(this.id, this.text);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyRestRequest$Content$AddCommentCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */