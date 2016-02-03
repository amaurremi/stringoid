package mobi.ifunny.comments;

import android.view.View;
import android.widget.AbsListView;
import mobi.ifunny.comments.views.CommentViews;
import mobi.ifunny.comments.views.FirstLevelCommentViews;
import mobi.ifunny.comments.views.b;
import mobi.ifunny.comments.views.c;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeedImpl;

class ag
        extends t<Comment, CommentsFeedImpl> {
    private c e;

    private ag(AbsListView paramAbsListView, c paramc, b paramb) {
        super(paramAbsListView, paramb);
        this.e = paramc;
    }

    protected CommentViews<Comment> a(int paramInt, h<Comment> paramh, View paramView) {
        return new FirstLevelCommentViews((Comment) paramh.a, paramView, this.e, c((Comment) paramh.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */