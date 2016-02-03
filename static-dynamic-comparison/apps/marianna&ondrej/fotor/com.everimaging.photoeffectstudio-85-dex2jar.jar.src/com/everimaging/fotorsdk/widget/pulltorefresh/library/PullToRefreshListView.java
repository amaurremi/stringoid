package com.everimaging.fotorsdk.widget.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.a;

public class PullToRefreshListView
        extends d<ListView> {
    private com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d b;
    private com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d c;
    private FrameLayout d;
    private boolean e;

    public PullToRefreshListView(Context paramContext) {
        super(paramContext);
    }

    public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode) {
        super(paramContext, paramMode);
    }

    public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
        super(paramContext, paramMode, paramAnimationStyle);
    }

    protected void a(TypedArray paramTypedArray) {
        super.a(paramTypedArray);
        this.e = paramTypedArray.getBoolean(14, true);
        if (this.e) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout localFrameLayout = new FrameLayout(getContext());
            this.b = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, paramTypedArray);
            this.b.setVisibility(8);
            localFrameLayout.addView(this.b, localLayoutParams);
            ((ListView) this.a).addHeaderView(localFrameLayout, null, false);
            this.d = new FrameLayout(getContext());
            this.c = a(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, paramTypedArray);
            this.c.setVisibility(8);
            this.d.addView(this.c, localLayoutParams);
            if (!paramTypedArray.hasValue(13)) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    protected void a(boolean paramBoolean) {
        Object localObject = ((ListView) this.a).getAdapter();
        if ((!this.e) || (!getShowViewWhileRefreshing()) || (localObject == null) || (((ListAdapter) localObject).isEmpty())) {
            super.a(paramBoolean);
            return;
        }
        super.a(false);
        com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d locald1;
        com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d locald2;
        int i;
        int j;
        switch (1. a[getCurrentMode().ordinal()])
        {
            default:
                localObject = getHeaderLayout();
                locald1 = this.b;
                locald2 = this.c;
                i = getScrollY() + getHeaderSize();
                j = 0;
        }
        for (; ; ) {
            ((com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d) localObject).i();
            ((com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d) localObject).e();
            locald2.setVisibility(8);
            locald1.setVisibility(0);
            locald1.g();
            if (!paramBoolean) {
                break;
            }
            k();
            setHeaderScroll(i);
            ((ListView) this.a).setSelection(j);
            a(0);
            return;
            localObject = getFooterLayout();
            locald1 = this.c;
            locald2 = this.b;
            j = ((ListView) this.a).getCount() - 1;
            i = getScrollY() - getFooterSize();
        }
    }

    protected ListView b(Context paramContext, AttributeSet paramAttributeSet) {
        if (Build.VERSION.SDK_INT >= 9) {
            return new b(paramContext, paramAttributeSet);
        }
        return new a(paramContext, paramAttributeSet);
    }

    protected b b(boolean paramBoolean1, boolean paramBoolean2) {
        b localb = super.b(paramBoolean1, paramBoolean2);
        if (this.e) {
            PullToRefreshBase.Mode localMode = getMode();
            if ((paramBoolean1) && (localMode.showHeaderLoadingLayout())) {
                localb.a(this.b);
            }
            if ((paramBoolean2) && (localMode.showFooterLoadingLayout())) {
                localb.a(this.c);
            }
        }
        return localb;
    }

    protected ListView c(Context paramContext, AttributeSet paramAttributeSet) {
        paramContext = b(paramContext, paramAttributeSet);
        paramContext.setId(16908298);
        return paramContext;
    }

    protected void c() {
        int j = 0;
        int i = 1;
        if (!this.e) {
            super.c();
            return;
        }
        com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d locald2;
        com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d locald1;
        int k;
        switch (1. a[getCurrentMode().ordinal()])
        {
            default:
                locald2 = getHeaderLayout();
                locald1 = this.b;
                k = -getHeaderSize();
                if (Math.abs(((ListView) this.a).getFirstVisiblePosition() - 0) > 1) {
                    break;
                }
        }
        for (; ; ) {
            if (locald1.getVisibility() == 0) {
                locald2.j();
                locald1.setVisibility(8);
                if ((i != 0) && (getState() != PullToRefreshBase.State.MANUAL_REFRESHING)) {
                    ((ListView) this.a).setSelection(j);
                    setHeaderScroll(k);
                }
            }
            super.c();
            return;
            locald2 = getFooterLayout();
            locald1 = this.c;
            j = ((ListView) this.a).getCount() - 1;
            k = getFooterSize();
            if (Math.abs(((ListView) this.a).getLastVisiblePosition() - j) <= 1) {
            }
            for (i = 1; ; i = 0) {
                break;
            }
            i = 0;
        }
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    protected class a
            extends ListView
            implements a {
        private boolean b = false;

        public a(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
        }

        protected void dispatchDraw(Canvas paramCanvas) {
            try {
                super.dispatchDraw(paramCanvas);
                return;
            } catch (IndexOutOfBoundsException paramCanvas) {
                paramCanvas.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
            try {
                boolean bool = super.dispatchTouchEvent(paramMotionEvent);
                return bool;
            } catch (IndexOutOfBoundsException paramMotionEvent) {
                paramMotionEvent.printStackTrace();
            }
            return false;
        }

        public void setAdapter(ListAdapter paramListAdapter) {
            if ((PullToRefreshListView.a(PullToRefreshListView.this) != null) && (!this.b)) {
                addFooterView(PullToRefreshListView.a(PullToRefreshListView.this), null, false);
                this.b = true;
            }
            super.setAdapter(paramListAdapter);
        }

        public void setEmptyView(View paramView) {
            PullToRefreshListView.this.setEmptyView(paramView);
        }

        public void setEmptyViewInternal(View paramView) {
            super.setEmptyView(paramView);
        }
    }

    @TargetApi(9)
    final class b
            extends PullToRefreshListView.a {
        public b(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramContext, paramAttributeSet);
        }

        protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean) {
            boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
            c.a(PullToRefreshListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */