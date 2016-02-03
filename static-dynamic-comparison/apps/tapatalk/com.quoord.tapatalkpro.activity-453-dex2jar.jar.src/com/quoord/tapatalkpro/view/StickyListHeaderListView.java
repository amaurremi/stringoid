package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class StickyListHeaderListView
        extends ListView {
    private View mHeaderView;
    private int mHeaderViewHeight = 0;
    private int mHeaderViewWidth = 0;

    public StickyListHeaderListView(Context paramContext) {
        super(paramContext);
    }

    public StickyListHeaderListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public StickyListHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if (this.mHeaderView != null) {
            drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
            this.mHeaderView.invalidate();
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.mHeaderView != null) {
            this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.mHeaderView != null) {
            measureChild(this.mHeaderView, paramInt1, paramInt2);
            this.mHeaderViewWidth = this.mHeaderView.getMeasuredWidth();
            this.mHeaderViewHeight = this.mHeaderView.getMeasuredHeight();
        }
    }

    public void setHeaderView(View paramView) {
        this.mHeaderView = paramView;
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        if (this.mHeaderView != null) {
            setFadingEdgeLength(0);
        }
        if (SettingsFragment.isLightTheme(getContext())) {
            this.mHeaderView.setBackgroundColor(Color.rgb(232, 232, 232));
        }
        for (; ; ) {
            requestLayout();
            return;
            this.mHeaderView.setBackgroundColor(getContext().getResources().getColor(2131165214));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/StickyListHeaderListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */