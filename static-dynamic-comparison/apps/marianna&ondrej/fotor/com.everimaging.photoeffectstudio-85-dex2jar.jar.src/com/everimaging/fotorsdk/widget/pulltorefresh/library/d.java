package com.everimaging.fotorsdk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.a;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.c;

public abstract class d<T extends AbsListView>
        extends PullToRefreshBase<T>
        implements AbsListView.OnScrollListener {
    private boolean b;
    private AbsListView.OnScrollListener c;
    private PullToRefreshBase.a d;
    private View e;
    private c f;
    private c g;
    private boolean h;
    private boolean i = true;

    public d(Context paramContext) {
        super(paramContext);
        ((AbsListView) this.a).setOnScrollListener(this);
    }

    public d(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        ((AbsListView) this.a).setOnScrollListener(this);
    }

    public d(Context paramContext, PullToRefreshBase.Mode paramMode) {
        super(paramContext, paramMode);
        ((AbsListView) this.a).setOnScrollListener(this);
    }

    public d(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
        super(paramContext, paramMode, paramAnimationStyle);
        ((AbsListView) this.a).setOnScrollListener(this);
    }

    private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
        FrameLayout.LayoutParams localLayoutParams = null;
        if (paramLayoutParams != null) {
            localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
            if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
                localLayoutParams.gravity = ((LinearLayout.LayoutParams) paramLayoutParams).gravity;
            }
        } else {
            return localLayoutParams;
        }
        localLayoutParams.gravity = 17;
        return localLayoutParams;
    }

    private boolean getShowIndicatorInternal() {
        return (this.h) && (g());
    }

    private void m() {
        Object localObject = getMode();
        FrameLayout localFrameLayout = getRefreshableViewWrapper();
        if ((((PullToRefreshBase.Mode) localObject).showHeaderLoadingLayout()) && (this.f == null)) {
            this.f = new c(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
            localLayoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.fotor_ptr_indicator_right_padding);
            localLayoutParams.gravity = 53;
            localFrameLayout.addView(this.f, localLayoutParams);
        }
        do {
            while ((((PullToRefreshBase.Mode) localObject).showFooterLoadingLayout()) && (this.g == null)) {
                this.g = new c(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
                localObject = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams) localObject).rightMargin = getResources().getDimensionPixelSize(R.dimen.fotor_ptr_indicator_right_padding);
                ((FrameLayout.LayoutParams) localObject).gravity = 85;
                localFrameLayout.addView(this.g, (ViewGroup.LayoutParams) localObject);
                return;
                if ((!((PullToRefreshBase.Mode) localObject).showHeaderLoadingLayout()) && (this.f != null)) {
                    localFrameLayout.removeView(this.f);
                    this.f = null;
                }
            }
        } while ((((PullToRefreshBase.Mode) localObject).showFooterLoadingLayout()) || (this.g == null));
        localFrameLayout.removeView(this.g);
        this.g = null;
    }

    private boolean n() {
        Object localObject = ((AbsListView) this.a).getAdapter();
        if ((localObject == null) || (((Adapter) localObject).isEmpty())) {
            return true;
        }
        if (((AbsListView) this.a).getFirstVisiblePosition() <= 1) {
            localObject = ((AbsListView) this.a).getChildAt(0);
            if (localObject != null) {
                return ((View) localObject).getTop() >= ((AbsListView) this.a).getTop();
            }
        }
        return false;
    }

    private boolean o() {
        Object localObject = ((AbsListView) this.a).getAdapter();
        if ((localObject == null) || (((Adapter) localObject).isEmpty())) {
            return true;
        }
        int k = ((AbsListView) this.a).getCount();
        int j = ((AbsListView) this.a).getLastVisiblePosition();
        if (j >= k - 1 - 1) {
            k = ((AbsListView) this.a).getFirstVisiblePosition();
            localObject = ((AbsListView) this.a).getChildAt(j - k);
            if (localObject != null) {
                return ((View) localObject).getBottom() <= ((AbsListView) this.a).getBottom();
            }
        }
        return false;
    }

    private void p() {
        if (this.f != null) {
            getRefreshableViewWrapper().removeView(this.f);
            this.f = null;
        }
        if (this.g != null) {
            getRefreshableViewWrapper().removeView(this.g);
            this.g = null;
        }
    }

    private void q() {
        if (this.f != null) {
            if ((i()) || (!d())) {
                break label77;
            }
            if (!this.f.a()) {
                this.f.c();
            }
        }
        label77:
        do {
            for (; ; ) {
                if (this.g != null) {
                    if ((i()) || (!e())) {
                        break;
                    }
                    if (!this.g.a()) {
                        this.g.c();
                    }
                }
                return;
                if (this.f.a()) {
                    this.f.b();
                }
            }
        } while (!this.g.a());
        this.g.b();
    }

    protected void a() {
        super.a();
        if (getShowIndicatorInternal()) {
        }
        switch (1. a[getCurrentMode().ordinal()])
        {
            default:
                return;
            case 1:
                this.g.e();
                return;
        }
        this.f.e();
    }

    protected void a(TypedArray paramTypedArray) {
        if (!h()) {
        }
        for (boolean bool = true; ; bool = false) {
            this.h = paramTypedArray.getBoolean(5, bool);
            return;
        }
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (getShowIndicatorInternal()) {
            q();
        }
    }

    protected void b() {
        super.b();
        if (getShowIndicatorInternal()) {
        }
        switch (1. a[getCurrentMode().ordinal()])
        {
            default:
                return;
            case 1:
                this.g.d();
                return;
        }
        this.f.d();
    }

    protected void c() {
        super.c();
        if (getShowIndicatorInternal()) {
            q();
        }
    }

    protected boolean d() {
        return n();
    }

    protected boolean e() {
        return o();
    }

    protected void f() {
        super.f();
        if (getShowIndicatorInternal()) {
            m();
            return;
        }
        p();
    }

    public boolean getShowIndicator() {
        return this.h;
    }

    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        if (this.d != null) {
            if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1)) {
                break label64;
            }
        }
        label64:
        for (boolean bool = true; ; bool = false) {
            this.b = bool;
            if (getShowIndicatorInternal()) {
                q();
            }
            if (this.c != null) {
                this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
            }
            return;
        }
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((this.e != null) && (!this.i)) {
            this.e.scrollTo(-paramInt1, -paramInt2);
        }
    }

    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
        if ((paramInt == 0) && (this.d != null) && (this.b)) {
            this.d.a();
        }
        if (this.c != null) {
            this.c.onScrollStateChanged(paramAbsListView, paramInt);
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        ((AdapterView) this.a).setAdapter(paramListAdapter);
    }

    public final void setEmptyView(View paramView) {
        FrameLayout localFrameLayout = getRefreshableViewWrapper();
        if (this.e != null) {
            localFrameLayout.removeView(this.e);
        }
        if (paramView != null) {
            paramView.setClickable(true);
            Object localObject = paramView.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
                ((ViewGroup) localObject).removeView(paramView);
            }
            localObject = a(paramView.getLayoutParams());
            if (localObject != null) {
                localFrameLayout.addView(paramView, (ViewGroup.LayoutParams) localObject);
            }
        } else {
            if (!(this.a instanceof a)) {
                break label108;
            }
            ((a) this.a).setEmptyViewInternal(paramView);
        }
        for (; ; ) {
            this.e = paramView;
            return;
            localFrameLayout.addView(paramView);
            break;
            label108:
            ((AbsListView) this.a).setEmptyView(paramView);
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
        ((AbsListView) this.a).setOnItemClickListener(paramOnItemClickListener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.a parama) {
        this.d = parama;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
        this.c = paramOnScrollListener;
    }

    public final void setScrollEmptyView(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void setShowIndicator(boolean paramBoolean) {
        this.h = paramBoolean;
        if (getShowIndicatorInternal()) {
            m();
            return;
        }
        p();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */