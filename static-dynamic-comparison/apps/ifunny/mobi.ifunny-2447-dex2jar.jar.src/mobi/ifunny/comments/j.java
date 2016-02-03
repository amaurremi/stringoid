package mobi.ifunny.comments;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import mobi.ifunny.comments.views.CommentViews;
import mobi.ifunny.comments.views.b;
import mobi.ifunny.gallery.h;
import mobi.ifunny.k.a;
import mobi.ifunny.k.g;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.c;
import mobi.ifunny.view.FrameLayoutEx;

public abstract class j<C extends Comment, F extends Feed<C>>
        extends mobi.ifunny.gallery.a.f<C, F> {
    protected LayoutInflater a;
    protected b b;
    protected String c;
    private boolean e;

    public j(F paramF, AbsListView paramAbsListView, b paramb, String paramString) {
        super(paramF, paramAbsListView, 3, 6000);
        a(paramString);
        this.b = paramb;
        this.a = LayoutInflater.from(paramAbsListView.getContext());
    }

    protected abstract int a(int paramInt);

    public View a(int paramInt, h<C> paramh, View paramView, ViewGroup paramViewGroup) {
        if (paramh.b == 1) {
            if (paramView == null) {
                paramView = c(paramInt, paramh, paramView, paramViewGroup);
                paramh = paramView.getTag();
                paramView = a(paramView);
                paramView.setTag(paramh);
            }
            for (; ; ) {
                if (a()) {
                    b(paramView);
                }
                return paramView;
                c(paramInt, paramh, paramView, paramViewGroup);
            }
        }
        return a(paramInt, paramh, paramView, paramViewGroup, a(paramh.b));
    }

    protected abstract View a(int paramInt1, h<C> paramh, View paramView, ViewGroup paramViewGroup, int paramInt2);

    protected View a(View paramView) {
        FrameLayoutEx localFrameLayoutEx = new FrameLayoutEx(paramView.getContext());
        localFrameLayoutEx.setPressAllChild(true);
        localFrameLayoutEx.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        localFrameLayoutEx.addView(paramView);
        ((FrameLayout.LayoutParams) paramView.getLayoutParams()).gravity = 17;
        this.a.inflate(2130903163, localFrameLayoutEx, true);
        localFrameLayoutEx.requestLayout();
        return localFrameLayoutEx;
    }

    protected abstract CommentViews<C> a(int paramInt, h<C> paramh, View paramView);

    protected a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        Context localContext = paramAbsListView.getContext();
        return new a(new f(paramAbsListView.getContext(), new c(localContext)), new g(), paramInt1, paramInt2);
    }

    public void a(String paramString) {
        this.c = paramString;
        if (!TextUtils.isEmpty(paramString)) {
            this.e = true;
        }
    }

    protected boolean a() {
        return this.e;
    }

    protected int b(C paramC) {
        if (TextUtils.equals(paramC.getId(), this.c)) {
            return 1;
        }
        return 0;
    }

    protected void b(View paramView) {
        if (!a()) {
            return;
        }
        this.e = false;
        paramView = paramView.findViewById(2131493302);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[]{0.0F});
        localObjectAnimator.setDuration(1000L);
        localObjectAnimator.addListener(new k(this, paramView));
        localObjectAnimator.start();
    }

    public View c(int paramInt, h<C> paramh, View paramView, ViewGroup paramViewGroup) {
        return a(paramInt, paramh, paramView, paramViewGroup, a(paramh.b));
    }

    protected boolean c(C paramC) {
        if ((paramC == null) || (paramC.user == null)) {
            return false;
        }
        l locall = l.a();
        return TextUtils.equals(paramC.user.id, locall.d());
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean hasStableIds() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */