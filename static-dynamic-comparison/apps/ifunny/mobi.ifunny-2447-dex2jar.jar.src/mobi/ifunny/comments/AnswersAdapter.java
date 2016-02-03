package mobi.ifunny.comments;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import mobi.ifunny.comments.views.AnswersCommentViews;
import mobi.ifunny.comments.views.CommentViews;
import mobi.ifunny.comments.views.b;
import mobi.ifunny.comments.views.e;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.RepliesFeed;

public class AnswersAdapter
        extends t<Comment, RepliesFeed> {
    private Comment e;
    private e<Comment> f;

    public AnswersAdapter(AbsListView paramAbsListView, e<Comment> parame, b paramb, Comment paramComment) {
        super(paramAbsListView, paramb);
        this.f = parame;
        this.e = paramComment;
    }

    protected int a(int paramInt) {
        return 2130903066;
    }

    public View a(int paramInt, h<Comment> paramh, View paramView, ViewGroup paramViewGroup) {
        if (paramh.b == 3) {
            return b(paramInt, paramh, paramView, paramViewGroup);
        }
        return super.a(paramInt, paramh, paramView, paramViewGroup);
    }

    protected CommentViews<Comment> a(int paramInt, h<Comment> paramh, View paramView) {
        if (paramh.b == 2) {
            return new AnswersCommentViews((Comment) paramh.a, this.e, paramView, true, this.f, c((Comment) paramh.a));
        }
        return new AnswersCommentViews((Comment) paramh.a, this.e, paramView, false, this.f, c((Comment) paramh.a));
    }

    public void a(h<Comment> paramh, View paramView, boolean paramBoolean) {
        if (paramh.b == 2) {
            paramh = ((CommentViews) paramView.getTag()).commentLayout.getBackground();
            if (paramBoolean) {
            }
            for (int i = 1; ; i = 2) {
                paramh.setLevel(i);
                return;
            }
        }
        super.a(paramh, paramView, paramBoolean);
    }

    public void a(Comment paramComment) {
        a(new h(paramComment, 2), 0);
    }

    protected int b(Comment paramComment) {
        if (TextUtils.equals(paramComment.id, this.e.id)) {
            return 2;
        }
        if (paramComment.isDeleted()) {
            return 3;
        }
        return super.b(paramComment);
    }

    protected View b(int paramInt, h<Comment> paramh, View paramView, ViewGroup paramViewGroup) {
        paramh = (Comment) paramh.a;
        if (paramView == null) {
            paramView = this.a.inflate(2130903093, paramViewGroup, false);
            paramView.setTag(new AnswersAdapter.DeletedViewHolder(paramh, paramView));
            return paramView;
        }
        ((AnswersAdapter.DeletedViewHolder) paramView.getTag()).b = paramh;
        return paramView;
    }

    public int getViewTypeCount() {
        return 4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/AnswersAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */