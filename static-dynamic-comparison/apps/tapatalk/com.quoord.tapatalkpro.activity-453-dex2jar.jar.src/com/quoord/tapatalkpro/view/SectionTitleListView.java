package com.quoord.tapatalkpro.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.ui.ButtomProgress;

public class SectionTitleListView
        extends ExpandableListView
        implements AbsListView.OnScrollListener, ExpandableListView.OnGroupClickListener {
    private static final int MAX_ALPHA = 255;
    private Context context;
    private LinearLayout footLayout;
    private boolean isFeedSettings;
    private IphoneTreeHeaderAdapter mAdapter;
    private float mDownX;
    private float mDownY;
    private View mHeaderView;
    private int mHeaderViewHeight;
    private boolean mHeaderViewVisible;
    private int mHeaderViewWidth;
    private int mOldState = -1;
    private OnScrollListenerForOtherUse onScrollListenerForOther;

    public SectionTitleListView(Context paramContext) {
        super(paramContext);
        this.context = paramContext;
        this.footLayout = ButtomProgress.get((Activity) paramContext);
        registerListener();
    }

    public SectionTitleListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.context = paramContext;
        this.footLayout = ButtomProgress.get((Activity) paramContext);
        registerListener();
    }

    public SectionTitleListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.context = paramContext;
        this.footLayout = ButtomProgress.get((Activity) paramContext);
        registerListener();
    }

    private void headerViewClick() {
    }

    private void registerListener() {
        setOnScrollListener(this);
        setOnGroupClickListener(this);
        setGroupIndicator(null);
        setSelector(2131165212);
    }

    public void configureHeaderView(int paramInt1, int paramInt2) {
        if ((this.mHeaderView == null) || (this.mAdapter == null) || (((ExpandableListAdapter) this.mAdapter).getGroupCount() == 0)) {
            return;
        }
        switch (this.mAdapter.getTreeHeaderState(paramInt1, paramInt2)) {
            default:
                return;
            case 0:
                this.mHeaderViewVisible = false;
                return;
            case 1:
                this.mAdapter.configureTreeHeader(this.mHeaderView, paramInt1, paramInt2, 255);
                if (this.mHeaderView.getTop() != 0) {
                    this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
                }
                this.mHeaderViewVisible = true;
                return;
        }
        int j = getChildAt(0).getBottom();
        int i = this.mHeaderView.getHeight();
        if (j < i) {
            j -= i;
        }
        for (i = (i + j) * 255 / i; ; i = 255) {
            this.mAdapter.configureTreeHeader(this.mHeaderView, paramInt1, paramInt2, i);
            if (this.mHeaderView.getTop() != j) {
                this.mHeaderView.layout(0, j, this.mHeaderViewWidth, this.mHeaderViewHeight + j);
            }
            this.mHeaderViewVisible = true;
            return;
            j = 0;
        }
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if (this.mHeaderViewVisible) {
            drawChild(paramCanvas, this.mHeaderView, getDrawingTime());
            this.mHeaderView.invalidate();
        }
    }

    public boolean isFeedSettings() {
        return this.isFeedSettings;
    }

    public boolean ismHeaderViewVisible() {
        return this.mHeaderViewVisible;
    }

    public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong) {
        return true;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        try {
            super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
            long l = getExpandableListPosition(getFirstVisiblePosition());
            paramInt1 = ExpandableListView.getPackedPositionGroup(l);
            paramInt2 = ExpandableListView.getPackedPositionChild(l);
            if (this.mAdapter != null) {
                paramInt3 = this.mAdapter.getTreeHeaderState(paramInt1, paramInt2);
                if ((this.mHeaderView != null) && (this.mAdapter != null)) {
                    this.mOldState = paramInt3;
                    this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
                }
            }
            configureHeaderView(paramInt1, paramInt2);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
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

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        long l = getExpandableListPosition(paramInt1);
        configureHeaderView(ExpandableListView.getPackedPositionGroup(l), ExpandableListView.getPackedPositionChild(l));
        if (this.onScrollListenerForOther != null) {
            this.onScrollListenerForOther.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
        if (this.onScrollListenerForOther != null) {
            this.onScrollListenerForOther.onScrollStateChanged(paramAbsListView, paramInt);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool = true;
        if (this.mHeaderViewVisible) {
        }
        switch (paramMotionEvent.getAction()) {
            default:
                bool = super.onTouchEvent(paramMotionEvent);
        }
        do {
            return bool;
            this.mDownX = paramMotionEvent.getX();
            this.mDownY = paramMotionEvent.getY();
            if ((this.mDownX > this.mHeaderViewWidth) || (this.mDownY > this.mHeaderViewHeight)) {
                break;
            }
            return true;
            float f1 = paramMotionEvent.getX();
            float f2 = paramMotionEvent.getY();
            float f3 = Math.abs(f1 - this.mDownX);
            float f4 = Math.abs(f2 - this.mDownY);
            if ((f1 > this.mHeaderViewWidth) || (f2 > this.mHeaderViewHeight) || (f3 > this.mHeaderViewWidth) || (f4 > this.mHeaderViewHeight)) {
                break;
            }
        } while (this.mHeaderView == null);
        headerViewClick();
        return true;
    }

    public void setAdapter(ExpandableListAdapter paramExpandableListAdapter) {
        super.setAdapter(paramExpandableListAdapter);
        this.mAdapter = ((IphoneTreeHeaderAdapter) paramExpandableListAdapter);
    }

    public void setFeedSettings(boolean paramBoolean) {
        this.isFeedSettings = paramBoolean;
    }

    public void setHeaderView(View paramView) {
        this.mHeaderView = paramView;
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        if (this.mHeaderView != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (getFooterViewsCount() == 0)) {
            addFooterView(this.footLayout);
        }
        while ((paramBoolean) || (getFooterViewsCount() <= 0)) {
            return;
        }
        removeFooterView(this.footLayout);
    }

    public void setOnScrollListenerForOther(OnScrollListenerForOtherUse paramOnScrollListenerForOtherUse) {
        this.onScrollListenerForOther = paramOnScrollListenerForOtherUse;
    }

    public boolean setSelectedChild(int paramInt1, int paramInt2, boolean paramBoolean) {
        return super.setSelectedChild(paramInt1, paramInt2, paramBoolean);
    }

    public void setmHeaderViewVisible(boolean paramBoolean) {
        this.mHeaderViewVisible = paramBoolean;
    }

    public static abstract interface IphoneTreeHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        public abstract void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3);

        public abstract int getHeadViewClickStatus(int paramInt);

        public abstract int getTreeHeaderState(int paramInt1, int paramInt2);

        public abstract void onHeadViewClick(int paramInt1, int paramInt2);
    }

    public static abstract interface OnScrollListenerForOtherUse {
        public abstract void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);

        public abstract void onScrollStateChanged(AbsListView paramAbsListView, int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/SectionTitleListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */