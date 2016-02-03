package mobi.ifunny.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import mobi.ifunny.comments.g;
import mobi.ifunny.comments.views.MyCommentViews;
import mobi.ifunny.comments.views.MyHiddenCommentViews;
import mobi.ifunny.comments.views.b;
import mobi.ifunny.comments.views.d;
import mobi.ifunny.gallery.a.e;
import mobi.ifunny.gallery.h;
import mobi.ifunny.k.c;
import mobi.ifunny.k.z;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.MyCommented;
import mobi.ifunny.rest.content.MyCommented.CommentedContent;
import mobi.ifunny.util.ah;

public class a
        extends mobi.ifunny.comments.j<MyCommented.CommentedContent, MyCommented> {
    private LayoutInflater e;
    private String f;
    private String g;
    private b h;
    private mobi.ifunny.k.a i;
    private d j;

    public a(MyCommented paramMyCommented, AbsListView paramAbsListView, String paramString1, String paramString2, d paramd, b paramb) {
        super(paramMyCommented, paramAbsListView, paramb, null);
        this.f = paramString1;
        this.g = paramString2;
        this.h = paramb;
        this.j = paramd;
        this.e = LayoutInflater.from(paramAbsListView.getContext());
        this.i = new mobi.ifunny.k.a(new e(paramAbsListView.getContext()), new c(), 3, 6000);
    }

    protected int a(int paramInt) {
        if ((paramInt == 2) || (paramInt == 3)) {
            return 2130903122;
        }
        return 2130903135;
    }

    protected int a(MyCommented.CommentedContent paramCommentedContent) {
        if (paramCommentedContent.isAbused()) {
            return 2;
        }
        if (paramCommentedContent.isDeleted()) {
            return 3;
        }
        return 0;
    }

    public View a(int paramInt1, h<MyCommented.CommentedContent> paramh, View paramView, ViewGroup paramViewGroup, int paramInt2) {
        MyCommented.CommentedContent localCommentedContent = (MyCommented.CommentedContent) paramh.a;
        if (paramView == null) {
            paramView = this.e.inflate(paramInt2, paramViewGroup, false);
            paramh = b(paramInt1, paramh, paramView);
            paramView.setTag(paramh);
            paramh.thumbLayout.setTag(paramh);
        }
        for (; ; ) {
            paramh.a(paramViewGroup.getContext(), this.h);
            a(new g(paramh.imageView, paramh.imageViewBackground, paramh.c(), localCommentedContent.user), paramView);
            paramh = new z(paramh.e.g, paramh.e.f, ((MyCommented.CommentedContent) paramh.b).content.getThumbUrl(ah.c(paramViewGroup.getContext())), paramh.e);
            this.i.a(paramh, paramView);
            return paramView;
            paramh = (MyCommentViews) paramView.getTag();
            paramh.b = localCommentedContent;
        }
    }

    protected MyCommentViews b(int paramInt, h<MyCommented.CommentedContent> paramh, View paramView) {
        if ((paramh.b == 2) || (paramh.b == 3)) {
            return new MyHiddenCommentViews((MyCommented.CommentedContent) paramh.a, this.f, this.g, paramView, this.j, c((Comment) paramh.a));
        }
        return new MyCommentViews((MyCommented.CommentedContent) paramh.a, this.f, this.g, paramView, this.j, c((Comment) paramh.a));
    }

    public void g() {
        super.g();
        this.i.b();
    }

    public int getViewTypeCount() {
        return 4;
    }

    public void h() {
        super.h();
        this.i.c();
    }

    public boolean isEmpty() {
        return false;
    }

    public void onMovedToScrapHeap(View paramView) {
        super.onMovedToScrapHeap(paramView);
        this.i.a(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */