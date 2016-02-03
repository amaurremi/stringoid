package mobi.ifunny.comments;

import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class s<C extends Comment, F extends CommentsFeed<C>>
        extends SimpleRestHttpHandler<C, CommentsFragment<C, F>> {
    private C a;

    private s(C paramC) {
        this.a = paramC;
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment) {
        paramCommentsFragment.F_();
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, C paramC) {
        if (paramC != null) {
            this.a.id = paramC.id;
            paramCommentsFragment.d(this.a);
        }
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, RestError paramRestError) {
        if (!paramCommentsFragment.a(this.a, paramRestError)) {
            super.onFailureCallback(paramCommentsFragment, paramRestError);
        }
    }

    public void b(CommentsFragment paramCommentsFragment) {
        paramCommentsFragment.y();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */