package mobi.ifunny.g;

import mobi.ifunny.rest.content.MyCommented.CommentedContent;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class d
        extends SimpleRestHttpHandler<Void, b> {
    private MyCommented.CommentedContent a;
    private int b;

    private d(MyCommented.CommentedContent paramCommentedContent, int paramInt) {
        this.a = paramCommentedContent;
        this.b = paramInt;
    }

    public void a(b paramb) {
        b.b(paramb, this.a);
    }

    public void a(b paramb, Throwable paramThrowable) {
        super.onExceptionCallback(paramb, paramThrowable);
        b.a(paramb, this.a, this.b);
    }

    public void a(b paramb, Void paramVoid) {
    }

    public void a(b paramb, RestError paramRestError) {
        super.onFailureCallback(paramb, paramRestError);
        b.a(paramb, this.a, this.b);
    }

    public void b(b paramb) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */