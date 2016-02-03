package mobi.ifunny.comments;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.comments.views.CommentViews;
import mobi.ifunny.comments.views.b;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.Feed;

public abstract class t<C extends Comment, F extends Feed<C>>
        extends j<C, F> {
    private ArrayList<C> e = new ArrayList();

    public t(AbsListView paramAbsListView, b paramb) {
        super(null, paramAbsListView, paramb, null);
    }

    protected int a(int paramInt) {
        if ((paramInt == 1) || (paramInt == 0)) {
            return 2130903094;
        }
        return 0;
    }

    protected View a(int paramInt1, h<C> paramh, View paramView, ViewGroup paramViewGroup, int paramInt2) {
        Comment localComment = (Comment) paramh.a;
        int i = getItemViewType(paramInt1);
        CommentViews localCommentViews;
        if (paramView == null) {
            paramView = this.a.inflate(paramInt2, paramViewGroup, false);
            localCommentViews = a(paramInt1, paramh, paramView);
            paramView.setTag(localCommentViews);
        }
        for (; ; ) {
            if (i == 1) {
                paramView.setTag(localCommentViews);
            }
            localCommentViews.a(paramViewGroup.getContext(), this.b);
            a(new g(localCommentViews.imageView, localCommentViews.imageViewBackground, localCommentViews.c(), localComment.user), paramView);
            a(paramh, paramView, this.e.contains(localComment));
            return paramView;
            localCommentViews = (CommentViews) paramView.getTag();
            localCommentViews.b = localComment;
        }
    }

    public void a(List<C> paramList) {
        this.e.addAll(paramList);
    }

    public void a(h<C> paramh, View paramView, boolean paramBoolean) {
        paramh = ((CommentViews) paramView.getTag()).commentLayout.getBackground();
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            paramh.setLevel(i);
            return;
        }
    }

    public void b() {
        this.e.clear();
    }

    public void b(int paramInt) {
        this.e.remove(paramInt);
    }

    public List<C> c() {
        return this.e;
    }

    public int d() {
        return this.e.size();
    }

    public void d(C paramC) {
        this.e.add(paramC);
    }

    public int e(C paramC) {
        return this.e.indexOf(paramC);
    }

    public void e() {
        b();
        super.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */