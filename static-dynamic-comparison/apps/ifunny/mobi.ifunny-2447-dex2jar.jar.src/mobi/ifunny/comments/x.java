package mobi.ifunny.comments;

import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class x<C extends Comment, F extends CommentsFeed<C>>
        extends SimpleRestHttpHandler<Void, CommentsFragment<C, F>> {
    private C a;
    private int b;
    private String c;

    private x(C paramC, int paramInt) {
        this.a = paramC;
        this.b = paramInt;
        this.c = paramC.getState();
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment) {
        paramCommentsFragment.a(this.a);
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, Throwable paramThrowable) {
        super.onExceptionCallback(paramCommentsFragment, paramThrowable);
        paramCommentsFragment.a(this.a, this.c, this.b);
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, Void paramVoid) {
        paramCommentsFragment.b(this.a);
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, RestError paramRestError) {
        super.onFailureCallback(paramCommentsFragment, paramRestError);
        paramCommentsFragment.a(this.a, this.c, this.b);
    }

    public void b(CommentsFragment<C, F> paramCommentsFragment) {
        super.onFinishCallback(paramCommentsFragment);
        paramCommentsFragment.c(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */