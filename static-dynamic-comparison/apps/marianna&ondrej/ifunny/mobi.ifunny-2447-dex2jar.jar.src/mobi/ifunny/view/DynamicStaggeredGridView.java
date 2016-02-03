package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ListAdapter;
import com.emilsjolander.components.StickyScrollViewItems.f;
import com.emilsjolander.components.StickyScrollViewItems.g;
import com.etsy.android.grid.StaggeredGridView;
import mobi.ifunny.j;

public class DynamicStaggeredGridView
        extends StaggeredGridView
        implements f {
    private h k;
    private View l;
    private a m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private g s;

    public DynamicStaggeredGridView(Context paramContext) {
        this(paramContext, null, 0);
    }

    public DynamicStaggeredGridView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public DynamicStaggeredGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (paramAttributeSet != null) {
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_DynamicStaggeredGridView, paramInt, 0);
            this.p = paramContext.getInteger(0, getColumnCount());
            paramContext.recycle();
        }
    }

    public void a() {
        setFirstVisiblePosition(0);
    }

    public void a(int paramInt) {
        c(paramInt);
    }

    public void a(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, int paramInt) {
        b(paramVelocityTracker, paramMotionEvent1, paramMotionEvent2, paramInt);
    }

    public boolean a(MotionEvent paramMotionEvent) {
        return onTouchEvent(paramMotionEvent);
    }

    public void b() {
        f();
    }

    public void d() {
        k();
    }

    public void e(View paramView) {
        if (this.l != null) {
            b(this.l);
        }
        this.l = paramView;
        if (paramView != null) {
            a(paramView);
        }
        this.k.a(false);
    }

    public a getListener() {
        return this.m;
    }

    public int getOptimalRequestCount() {
        return this.p;
    }

    public int getRequestAtLeastItemsAtEnd() {
        return this.o;
    }

    public void j(int paramInt) {
        super.j(paramInt);
        this.q = getFirstVisiblePosition();
        this.r = getFirstChildTop();
    }

    public void l(int paramInt) {
        e(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
    }

    public void m() {
        super.m();
        if (this.s != null) {
            if (getScrollState() != 2) {
                break label64;
            }
            i = getFirstVisiblePosition();
            j = getFirstChildTop();
            this.s.a(this, i, this.q, j, this.r, getCurrentVelocity());
            this.q = i;
            this.r = j;
        }
        label64:
        while (getScrollState() != 1) {
            return;
        }
        int i = getFirstVisiblePosition();
        int j = getFirstChildTop();
        this.s.a(this, i, this.q, j, this.r);
        this.q = i;
        this.r = j;
    }

    public void p() {
        if (this.l != null) {
            b(this.l);
        }
        this.k.a(true);
    }

    public boolean q() {
        return this.l != null;
    }

    public void r() {
        if (this.k != null) {
            this.k.b();
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (this.k != null) {
            this.k.a();
        }
        if (paramListAdapter != null) {
        }
        for (this.k = new h(this, paramListAdapter); ; this.k = null) {
            super.setAdapter(this.k);
            return;
        }
    }

    public void setAutomaticRequestAtEnd(boolean paramBoolean) {
        this.n = paramBoolean;
    }

    public void setDynamicAdapterViewListener(a parama) {
        this.m = parama;
    }

    public void setRequestAtLeastItemsAtEnd(int paramInt) {
        this.o = paramInt;
    }

    public void setStickyMainContentScrollListener(g paramg) {
        this.s = paramg;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/DynamicStaggeredGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */