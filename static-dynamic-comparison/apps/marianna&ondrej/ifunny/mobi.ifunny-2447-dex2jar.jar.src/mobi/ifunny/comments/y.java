package mobi.ifunny.comments;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.DeleteResponcesList;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class y<C extends Comment, F extends CommentsFeed<C>>
        extends SimpleRestHttpHandler<DeleteResponcesList, CommentsFragment<C, F>> {
    private List<C> a;

    private y(List<C> paramList) {
        this.a = new ArrayList(paramList);
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment) {
        paramCommentsFragment.F_();
    }

    public void a(CommentsFragment<C, F> paramCommentsFragment, DeleteResponcesList paramDeleteResponcesList) {
        paramCommentsFragment.a(this.a, paramDeleteResponcesList);
    }

    public void b(CommentsFragment<C, F> paramCommentsFragment) {
        paramCommentsFragment.y();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */