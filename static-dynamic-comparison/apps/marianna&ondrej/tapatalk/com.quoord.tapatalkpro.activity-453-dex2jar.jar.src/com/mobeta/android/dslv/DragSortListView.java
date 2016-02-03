package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.R.styleable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView
        extends ListView {
    private static final int DRAGGING = 4;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    private static final int DROPPING = 2;
    private static final int IDLE = 0;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    private static final int REMOVING = 1;
    private static final int STOPPED = 3;
    private static final int sCacheSize = 3;
    private AdapterWrapper mAdapterWrapper;
    private boolean mAnimate = false;
    private boolean mBlockLayoutRequests = false;
    private MotionEvent mCancelEvent;
    private int mCancelMethod = 0;
    private HeightCache mChildHeightCache = new HeightCache(3);
    private float mCurrFloatAlpha = 1.0F;
    private int mDownScrollStartY;
    private float mDownScrollStartYF;
    private int mDragDeltaX;
    private int mDragDeltaY;
    private float mDragDownScrollHeight;
    private float mDragDownScrollStartFrac = 0.33333334F;
    private boolean mDragEnabled = true;
    private int mDragFlags = 0;
    private DragListener mDragListener;
    private DragScroller mDragScroller;
    private DragSortTracker mDragSortTracker;
    private int mDragStartY;
    private int mDragState = 0;
    private float mDragUpScrollHeight;
    private float mDragUpScrollStartFrac = 0.33333334F;
    private DropAnimator mDropAnimator;
    private DropListener mDropListener;
    private int mFirstExpPos;
    private float mFloatAlpha = 1.0F;
    private Point mFloatLoc = new Point();
    private int mFloatPos;
    private View mFloatView;
    private int mFloatViewHeight;
    private int mFloatViewHeightHalf;
    private boolean mFloatViewInvalidated = false;
    private FloatViewManager mFloatViewManager = null;
    private int mFloatViewMid;
    private boolean mFloatViewOnMeasured = false;
    private boolean mIgnoreTouchEvent = false;
    private boolean mInTouchEvent = false;
    private int mItemHeightCollapsed = 1;
    private boolean mLastCallWasIntercept = false;
    private int mLastX;
    private int mLastY;
    private LiftAnimator mLiftAnimator;
    private float mMaxScrollSpeed = 0.5F;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private RemoveAnimator mRemoveAnimator;
    private RemoveListener mRemoveListener;
    private View[] mSampleViewTypes = new View[1];
    private DragScrollProfile mScrollProfile = new DragScrollProfile() {
        public float getSpeed(float paramAnonymousFloat, long paramAnonymousLong) {
            return DragSortListView.this.mMaxScrollSpeed * paramAnonymousFloat;
        }
    };
    private int mSecondExpPos;
    private float mSlideFrac = 0.0F;
    private float mSlideRegionFrac = 0.25F;
    private int mSrcPos;
    private Point mTouchLoc = new Point();
    private boolean mTrackDragSort = false;
    private int mUpScrollStartY;
    private float mUpScrollStartYF;
    private int mWidthMeasureSpec = 0;
    private int mX;
    private int mY;

    public DragSortListView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        int m = 150;
        int k = 150;
        int j = k;
        int i = m;
        if (paramAttributeSet != null) {
            paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
            this.mItemHeightCollapsed = Math.max(1, paramContext.getDimensionPixelSize(0, 1));
            this.mTrackDragSort = paramContext.getBoolean(5, false);
            if (this.mTrackDragSort) {
                this.mDragSortTracker = new DragSortTracker();
            }
            this.mFloatAlpha = paramContext.getFloat(6, this.mFloatAlpha);
            this.mCurrFloatAlpha = this.mFloatAlpha;
            this.mDragEnabled = paramContext.getBoolean(10, this.mDragEnabled);
            this.mSlideRegionFrac = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(7, 0.75F)));
            if (this.mSlideRegionFrac <= 0.0F) {
                break label574;
            }
        }
        label574:
        for (boolean bool1 = true; ; bool1 = false) {
            this.mAnimate = bool1;
            setDragScrollStart(paramContext.getFloat(1, this.mDragUpScrollStartFrac));
            this.mMaxScrollSpeed = paramContext.getFloat(2, this.mMaxScrollSpeed);
            i = paramContext.getInt(8, m);
            j = paramContext.getInt(9, k);
            if (paramContext.getBoolean(16, true)) {
                bool1 = paramContext.getBoolean(12, false);
                k = paramContext.getInt(4, 1);
                boolean bool2 = paramContext.getBoolean(11, true);
                m = paramContext.getInt(13, 0);
                int n = paramContext.getResourceId(14, 0);
                int i1 = paramContext.getResourceId(15, 0);
                paramContext.getColor(3, -16777216);
                paramAttributeSet = new DragSortController(this, n, m, k, i1);
                paramAttributeSet.setRemoveEnabled(bool1);
                paramAttributeSet.setSortEnabled(bool2);
                this.mFloatViewManager = paramAttributeSet;
                setOnTouchListener(paramAttributeSet);
            }
            paramContext.recycle();
            this.mDragScroller = new DragScroller();
            if (i > 0) {
                this.mRemoveAnimator = new RemoveAnimator(0.5F, i);
            }
            if (j > 0) {
                this.mDropAnimator = new DropAnimator(0.5F, j);
            }
            this.mCancelEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
            this.mObserver = new DataSetObserver() {
                private void cancel() {
                    if (DragSortListView.this.mDragState == 4) {
                        DragSortListView.this.cancelDrag();
                    }
                }

                public void onChanged() {
                    cancel();
                }

                public void onInvalidated() {
                    cancel();
                }
            };
            return;
        }
    }

    private void adjustAllItems() {
        int j = getFirstVisiblePosition();
        int k = getLastVisiblePosition();
        int i = Math.max(0, getHeaderViewsCount() - j);
        k = Math.min(k - j, getCount() - 1 - getFooterViewsCount() - j);
        for (; ; ) {
            if (i > k) {
                return;
            }
            View localView = getChildAt(i);
            if (localView != null) {
                adjustItem(j + i, localView, false);
            }
            i += 1;
        }
    }

    private void adjustItem(int paramInt) {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        if (localView != null) {
            adjustItem(paramInt, localView, false);
        }
    }

    private void adjustItem(int paramInt, View paramView, boolean paramBoolean) {
        int i = calcItemHeight(paramInt, paramView, paramBoolean);
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if (i != localLayoutParams.height) {
            localLayoutParams.height = i;
            paramView.setLayoutParams(localLayoutParams);
        }
        if ((paramInt == this.mFirstExpPos) || (paramInt == this.mSecondExpPos)) {
            if (paramInt >= this.mSrcPos) {
                break label120;
            }
            ((DragSortItemView) paramView).setGravity(80);
        }
        for (; ; ) {
            int k = paramView.getVisibility();
            int j = 0;
            i = j;
            if (paramInt == this.mSrcPos) {
                i = j;
                if (this.mFloatView != null) {
                    i = 4;
                }
            }
            if (i != k) {
                paramView.setVisibility(i);
            }
            return;
            label120:
            if (paramInt > this.mSrcPos) {
                ((DragSortItemView) paramView).setGravity(48);
            }
        }
    }

    private void adjustOnReorder() {
        int j = getFirstVisiblePosition();
        if (this.mSrcPos < j) {
            View localView = getChildAt(0);
            int i = 0;
            if (localView != null) {
                i = localView.getTop();
            }
            setSelectionFromTop(j - 1, i - getPaddingTop());
        }
    }

    private int adjustScroll(int paramInt1, View paramView, int paramInt2, int paramInt3) {
        int n = 0;
        int i3 = getChildHeight(paramInt1);
        int i1 = paramView.getHeight();
        int i2 = calcItemHeight(paramInt1, i3);
        int m = i1;
        int k = i2;
        int i = k;
        int j = m;
        if (paramInt1 != this.mSrcPos) {
            j = m - i3;
            i = k - i3;
        }
        m = this.mFloatViewHeight;
        k = m;
        if (this.mSrcPos != this.mFirstExpPos) {
            k = m;
            if (this.mSrcPos != this.mSecondExpPos) {
                k = m - this.mItemHeightCollapsed;
            }
        }
        if (paramInt1 <= paramInt2) {
            paramInt2 = n;
            if (paramInt1 > this.mFirstExpPos) {
                paramInt2 = 0 + (k - i);
            }
        }
        do {
            return paramInt2;
            if (paramInt1 == paramInt3) {
                if (paramInt1 <= this.mFirstExpPos) {
                    return 0 + (j - k);
                }
                if (paramInt1 == this.mSecondExpPos) {
                    return 0 + (i1 - i2);
                }
                return 0 + j;
            }
            if (paramInt1 <= this.mFirstExpPos) {
                return 0 - k;
            }
            paramInt2 = n;
        } while (paramInt1 != this.mSecondExpPos);
        return 0 - i;
    }

    private int calcItemHeight(int paramInt1, int paramInt2) {
        getDividerHeight();
        if ((this.mAnimate) && (this.mFirstExpPos != this.mSecondExpPos)) {
        }
        int j;
        int k;
        for (int i = 1; ; i = 0) {
            j = this.mFloatViewHeight - this.mItemHeightCollapsed;
            k = (int) (this.mSlideFrac * j);
            if (paramInt1 != this.mSrcPos) {
                break label112;
            }
            if (this.mSrcPos != this.mFirstExpPos) {
                break label88;
            }
            if (i == 0) {
                break;
            }
            return k + this.mItemHeightCollapsed;
        }
        return this.mFloatViewHeight;
        label88:
        if (this.mSrcPos == this.mSecondExpPos) {
            return this.mFloatViewHeight - k;
        }
        return this.mItemHeightCollapsed;
        label112:
        if (paramInt1 == this.mFirstExpPos) {
            if (i != 0) {
                return paramInt2 + k;
            }
            return paramInt2 + j;
        }
        if (paramInt1 == this.mSecondExpPos) {
            return paramInt2 + j - k;
        }
        return paramInt2;
    }

    private int calcItemHeight(int paramInt, View paramView, boolean paramBoolean) {
        return calcItemHeight(paramInt, getChildHeight(paramInt, paramView, paramBoolean));
    }

    private void clearPositions() {
        this.mSrcPos = -1;
        this.mFirstExpPos = -1;
        this.mSecondExpPos = -1;
        this.mFloatPos = -1;
    }

    private void continueDrag(int paramInt1, int paramInt2) {
        this.mFloatLoc.x = (paramInt1 - this.mDragDeltaX);
        this.mFloatLoc.y = (paramInt2 - this.mDragDeltaY);
        doDragFloatView(true);
        paramInt1 = Math.min(paramInt2, this.mFloatViewMid + this.mFloatViewHeightHalf);
        paramInt2 = Math.max(paramInt2, this.mFloatViewMid - this.mFloatViewHeightHalf);
        int i = this.mDragScroller.getScrollDir();
        if ((paramInt1 > this.mLastY) && (paramInt1 > this.mDownScrollStartY) && (i != 1)) {
            if (i != -1) {
                this.mDragScroller.stopScrolling(true);
            }
            this.mDragScroller.startScrolling(1);
        }
        do {
            return;
            if ((paramInt2 < this.mLastY) && (paramInt2 < this.mUpScrollStartY) && (i != 0)) {
                if (i != -1) {
                    this.mDragScroller.stopScrolling(true);
                }
                this.mDragScroller.startScrolling(0);
                return;
            }
        }
        while ((paramInt2 < this.mUpScrollStartY) || (paramInt1 > this.mDownScrollStartY) || (!this.mDragScroller.isScrolling()));
        this.mDragScroller.stopScrolling(true);
    }

    private void destroyFloatView() {
        if (this.mFloatView != null) {
            this.mFloatView.setVisibility(8);
            if (this.mFloatViewManager != null) {
                this.mFloatViewManager.onDestroyFloatView(this.mFloatView);
            }
            this.mFloatView = null;
            invalidate();
        }
    }

    private void doActionUpOrCancel() {
        this.mCancelMethod = 0;
        this.mInTouchEvent = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.mCurrFloatAlpha = this.mFloatAlpha;
        this.mChildHeightCache.clear();
    }

    private void doDragFloatView(int paramInt, View paramView, boolean paramBoolean) {
        this.mBlockLayoutRequests = true;
        updateFloatView();
        int i = this.mFirstExpPos;
        int j = this.mSecondExpPos;
        boolean bool = updatePositions();
        if (bool) {
            adjustAllItems();
            i = adjustScroll(paramInt, paramView, i, j);
            setSelectionFromTop(paramInt, paramView.getTop() + i - getPaddingTop());
            layoutChildren();
        }
        if ((bool) || (paramBoolean)) {
            invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void doDragFloatView(boolean paramBoolean) {
        int i = getFirstVisiblePosition();
        int j = getChildCount() / 2;
        View localView = getChildAt(getChildCount() / 2);
        if (localView == null) {
            return;
        }
        doDragFloatView(i + j, localView, paramBoolean);
    }

    private void doRemoveItem() {
        doRemoveItem(this.mSrcPos - getHeaderViewsCount());
    }

    private void doRemoveItem(int paramInt) {
        this.mDragState = 1;
        if (this.mRemoveListener != null) {
            this.mRemoveListener.remove(paramInt);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        if (this.mInTouchEvent) {
            this.mDragState = 3;
            return;
        }
        this.mDragState = 0;
    }

    private void drawDivider(int paramInt, Canvas paramCanvas) {
        Drawable localDrawable = getDivider();
        int n = getDividerHeight();
        ViewGroup localViewGroup;
        int j;
        int k;
        int m;
        int i;
        if ((localDrawable != null) && (n != 0)) {
            localViewGroup = (ViewGroup) getChildAt(paramInt - getFirstVisiblePosition());
            if (localViewGroup != null) {
                j = getPaddingLeft();
                k = getWidth();
                m = getPaddingRight();
                i = localViewGroup.getChildAt(0).getHeight();
                if (paramInt <= this.mSrcPos) {
                    break label112;
                }
                i = localViewGroup.getTop() + i;
                paramInt = i + n;
            }
        }
        for (; ; ) {
            localDrawable.setBounds(j, i, k - m, paramInt);
            localDrawable.draw(paramCanvas);
            return;
            label112:
            paramInt = localViewGroup.getBottom() - i;
            i = paramInt - n;
        }
    }

    private void dropFloatView() {
        this.mDragState = 2;
        if ((this.mDropListener != null) && (this.mFloatPos >= 0) && (this.mFloatPos < getCount())) {
            int i = getHeaderViewsCount();
            this.mDropListener.drop(this.mSrcPos - i, this.mFloatPos - i);
        }
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        adjustAllItems();
        if (this.mInTouchEvent) {
            this.mDragState = 3;
            return;
        }
        this.mDragState = 0;
    }

    private int getChildHeight(int paramInt) {
        int i = 0;
        if (paramInt == this.mSrcPos) {
        }
        do {
            return i;
            localObject = getChildAt(paramInt - getFirstVisiblePosition());
            if (localObject != null) {
                return getChildHeight(paramInt, (View) localObject, false);
            }
            j = this.mChildHeightCache.get(paramInt);
            i = j;
        } while (j != -1);
        Object localObject = getAdapter();
        i = ((ListAdapter) localObject).getItemViewType(paramInt);
        int j = ((ListAdapter) localObject).getViewTypeCount();
        if (j != this.mSampleViewTypes.length) {
            this.mSampleViewTypes = new View[j];
        }
        if (i >= 0) {
            if (this.mSampleViewTypes[i] == null) {
                localObject = ((ListAdapter) localObject).getView(paramInt, null, this);
                this.mSampleViewTypes[i] = localObject;
            }
        }
        for (; ; ) {
            i = getChildHeight(paramInt, (View) localObject, true);
            this.mChildHeightCache.add(paramInt, i);
            return i;
            localObject = ((ListAdapter) localObject).getView(paramInt, this.mSampleViewTypes[i], this);
            continue;
            localObject = ((ListAdapter) localObject).getView(paramInt, null, this);
        }
    }

    private int getChildHeight(int paramInt, View paramView, boolean paramBoolean) {
        int i = 0;
        if (paramInt == this.mSrcPos) {
            paramInt = i;
        }
        do {
            return paramInt;
            if ((paramInt < getHeaderViewsCount()) || (paramInt >= getCount() - getFooterViewsCount())) {
            }
            for (; ; ) {
                ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
                if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
                    break;
                }
                return localLayoutParams.height;
                paramView = ((ViewGroup) paramView).getChildAt(0);
            }
            paramInt = paramView.getHeight();
        } while ((paramInt != 0) && (!paramBoolean));
        measureItem(paramView);
        return paramView.getMeasuredHeight();
    }

    private int getItemHeight(int paramInt) {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        if (localView != null) {
            return localView.getHeight();
        }
        return calcItemHeight(paramInt, getChildHeight(paramInt));
    }

    private int getShuffleEdge(int paramInt1, int paramInt2) {
        int i = getHeaderViewsCount();
        int j = getFooterViewsCount();
        if ((paramInt1 <= i) || (paramInt1 >= getCount() - j)) {
            return paramInt2;
        }
        int k = getDividerHeight();
        int n = this.mFloatViewHeight - this.mItemHeightCollapsed;
        int m = getChildHeight(paramInt1);
        int i1 = getItemHeight(paramInt1);
        j = paramInt2;
        if (this.mSecondExpPos <= this.mSrcPos) {
            if ((paramInt1 == this.mSecondExpPos) && (this.mFirstExpPos != this.mSecondExpPos)) {
                if (paramInt1 == this.mSrcPos) {
                    i = paramInt2 + i1 - this.mFloatViewHeight;
                }
            }
        }
        while (paramInt1 <= this.mSrcPos) {
            return i + (this.mFloatViewHeight - k - getChildHeight(paramInt1 - 1)) / 2;
            i = paramInt2 + (i1 - m) - n;
            continue;
            i = j;
            if (paramInt1 > this.mSecondExpPos) {
                i = j;
                if (paramInt1 <= this.mSrcPos) {
                    i = paramInt2 - n;
                    continue;
                    if ((paramInt1 > this.mSrcPos) && (paramInt1 <= this.mFirstExpPos)) {
                        i = paramInt2 + n;
                    } else {
                        i = j;
                        if (paramInt1 == this.mSecondExpPos) {
                            i = j;
                            if (this.mFirstExpPos != this.mSecondExpPos) {
                                i = paramInt2 + (i1 - m);
                            }
                        }
                    }
                }
            }
        }
        return i + (m - k - this.mFloatViewHeight) / 2;
    }

    private void invalidateFloatView() {
        this.mFloatViewInvalidated = true;
    }

    private void measureFloatView() {
        if (this.mFloatView != null) {
            measureItem(this.mFloatView);
            this.mFloatViewHeight = this.mFloatView.getMeasuredHeight();
            this.mFloatViewHeightHalf = (this.mFloatViewHeight / 2);
        }
    }

    private void measureItem(View paramView) {
        ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
            localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
        }
        int j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), localLayoutParams1.width);
        if (localLayoutParams1.height > 0) {
        }
        for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.height, 1073741824); ; i = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            paramView.measure(j, i);
            return;
        }
    }

    private void printPosData() {
        Log.d("mobeta", "mSrcPos=" + this.mSrcPos + " mFirstExpPos=" + this.mFirstExpPos + " mSecondExpPos=" + this.mSecondExpPos);
    }

    private void saveTouchCoords(MotionEvent paramMotionEvent) {
        int i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
            this.mLastX = this.mX;
            this.mLastY = this.mY;
        }
        this.mX = ((int) paramMotionEvent.getX());
        this.mY = ((int) paramMotionEvent.getY());
        if (i == 0) {
            this.mLastX = this.mX;
            this.mLastY = this.mY;
        }
        this.mOffsetX = ((int) paramMotionEvent.getRawX() - this.mX);
        this.mOffsetY = ((int) paramMotionEvent.getRawY() - this.mY);
    }

    private void updateFloatView() {
        if (this.mFloatViewManager != null) {
            this.mTouchLoc.set(this.mX, this.mY);
            this.mFloatViewManager.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
        }
        int i = this.mFloatLoc.x;
        int m = this.mFloatLoc.y;
        int j = getPaddingLeft();
        int k;
        if (((this.mDragFlags & 0x1) == 0) && (i > j)) {
            this.mFloatLoc.x = j;
            j = getHeaderViewsCount();
            k = getFooterViewsCount();
            int n = getFirstVisiblePosition();
            int i1 = getLastVisiblePosition();
            i = getPaddingTop();
            if (n < j) {
                i = getChildAt(j - n - 1).getBottom();
            }
            j = i;
            if ((this.mDragFlags & 0x8) == 0) {
                j = i;
                if (n <= this.mSrcPos) {
                    j = Math.max(getChildAt(this.mSrcPos - n).getTop(), i);
                }
            }
            i = getHeight() - getPaddingBottom();
            if (i1 >= getCount() - k - 1) {
                i = getChildAt(getCount() - k - 1 - n).getBottom();
            }
            k = i;
            if ((this.mDragFlags & 0x4) == 0) {
                k = i;
                if (i1 >= this.mSrcPos) {
                    k = Math.min(getChildAt(this.mSrcPos - n).getBottom(), i);
                }
            }
            if (m >= j) {
                break label315;
            }
            this.mFloatLoc.y = j;
        }
        for (; ; ) {
            this.mFloatViewMid = (this.mFloatLoc.y + this.mFloatViewHeightHalf);
            return;
            if (((this.mDragFlags & 0x2) != 0) || (i >= j)) {
                break;
            }
            this.mFloatLoc.x = j;
            break;
            label315:
            if (this.mFloatViewHeight + m > k) {
                this.mFloatLoc.y = (k - this.mFloatViewHeight);
            }
        }
    }

    private boolean updatePositions() {
        int i = getFirstVisiblePosition();
        int n = this.mFirstExpPos;
        View localView2 = getChildAt(n - i);
        View localView1 = localView2;
        if (localView2 == null) {
            n = i + getChildCount() / 2;
            localView1 = getChildAt(n - i);
        }
        int j = localView1.getTop();
        int i1 = localView1.getHeight();
        i = getShuffleEdge(n, j);
        int k = i;
        int i4 = getDividerHeight();
        int m;
        label103:
        int i3;
        boolean bool;
        int i2;
        float f1;
        label159:
        float f2;
        if (this.mFloatViewMid < i) {
            m = j;
            j = n;
            if (j < 0) {
                n = getHeaderViewsCount();
                i3 = getFooterViewsCount();
                bool = false;
                i1 = this.mFirstExpPos;
                i2 = this.mSecondExpPos;
                f1 = this.mSlideFrac;
                if (!this.mAnimate) {
                    break label618;
                }
                i4 = Math.abs(i - k);
                if (this.mFloatViewMid >= i) {
                    break label544;
                }
                m = (int) (0.5F * this.mSlideRegionFrac * i4);
                f2 = m;
                k += m;
                if (this.mFloatViewMid >= k) {
                    break label557;
                }
                this.mFirstExpPos = (j - 1);
                this.mSecondExpPos = j;
                this.mSlideFrac = (0.5F * (k - this.mFloatViewMid) / f2);
                label224:
                if (this.mFirstExpPos >= n) {
                    break label633;
                }
                j = n;
                this.mFirstExpPos = j;
                this.mSecondExpPos = j;
            }
        }
        for (; ; ) {
            if ((this.mFirstExpPos != i1) || (this.mSecondExpPos != i2) || (this.mSlideFrac != f1)) {
                bool = true;
            }
            if (j != this.mFloatPos) {
                if (this.mDragListener != null) {
                    this.mDragListener.drag(this.mFloatPos - n, j - n);
                }
                this.mFloatPos = j;
                bool = true;
            }
            return bool;
            n = j - 1;
            i = getItemHeight(n);
            if (n == 0) {
                i = m - i4 - i;
                j = n;
                break label103;
            }
            i1 = m - (i + i4);
            m = getShuffleEdge(n, i1);
            i = m;
            j = n;
            if (this.mFloatViewMid >= m) {
                break label103;
            }
            k = m;
            i = m;
            j = n;
            m = i1;
            break;
            int i5 = getCount();
            m = k;
            i2 = j;
            for (; ; ) {
                j = n;
                k = m;
                if (n >= i5) {
                    break;
                }
                if (n == i5 - 1) {
                    i = i2 + i4 + i1;
                    j = n;
                    k = m;
                    break;
                }
                i2 += i4 + i1;
                i3 = getItemHeight(n + 1);
                i1 = getShuffleEdge(n + 1, i2);
                i = i1;
                j = n;
                k = m;
                if (this.mFloatViewMid < i1) {
                    break;
                }
                m = i1;
                n += 1;
                i = i1;
                i1 = i3;
            }
            label544:
            m = i;
            i = k;
            k = m;
            break label159;
            label557:
            if (this.mFloatViewMid < i - m) {
                this.mFirstExpPos = j;
                this.mSecondExpPos = j;
                break label224;
            }
            this.mFirstExpPos = j;
            this.mSecondExpPos = (j + 1);
            this.mSlideFrac = (0.5F * (1.0F + (i - this.mFloatViewMid) / f2));
            break label224;
            label618:
            this.mFirstExpPos = j;
            this.mSecondExpPos = j;
            break label224;
            label633:
            if (this.mSecondExpPos >= getCount() - i3) {
                j = getCount() - i3 - 1;
                this.mFirstExpPos = j;
                this.mSecondExpPos = j;
            }
        }
    }

    private void updateScrollStarts() {
        int i = getPaddingTop();
        int j = getHeight() - i - getPaddingBottom();
        float f = j;
        this.mUpScrollStartYF = (i + this.mDragUpScrollStartFrac * f);
        this.mDownScrollStartYF = (i + (1.0F - this.mDragDownScrollStartFrac) * f);
        this.mUpScrollStartY = ((int) this.mUpScrollStartYF);
        this.mDownScrollStartY = ((int) this.mDownScrollStartYF);
        this.mDragUpScrollHeight = (this.mUpScrollStartYF - i);
        this.mDragDownScrollHeight = (i + j - this.mDownScrollStartYF);
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.mDragScroller.stopScrolling(true);
            destroyFloatView();
            clearPositions();
            adjustAllItems();
            if (this.mInTouchEvent) {
                this.mDragState = 3;
            }
        } else {
            return;
        }
        this.mDragState = 0;
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
        if (this.mDragState != 0) {
            if (this.mFirstExpPos != this.mSrcPos) {
                drawDivider(this.mFirstExpPos, paramCanvas);
            }
            if ((this.mSecondExpPos != this.mFirstExpPos) && (this.mSecondExpPos != this.mSrcPos)) {
                drawDivider(this.mSecondExpPos, paramCanvas);
            }
        }
        if (this.mFloatView != null) {
            int i = this.mFloatView.getWidth();
            int j = this.mFloatView.getHeight();
            int k = (int) (255.0F * this.mCurrFloatAlpha);
            paramCanvas.save();
            paramCanvas.translate(this.mFloatLoc.x, this.mFloatLoc.y);
            paramCanvas.clipRect(0, 0, i, j);
            paramCanvas.saveLayerAlpha(0.0F, 0.0F, i, j, k, 31);
            this.mFloatView.draw(paramCanvas);
            paramCanvas.restore();
            paramCanvas.restore();
        }
    }

    public float getFloatAlpha() {
        return this.mCurrFloatAlpha;
    }

    public ListAdapter getInputAdapter() {
        if (this.mAdapterWrapper == null) {
            return null;
        }
        return this.mAdapterWrapper.getAdapter();
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.mFloatView != null) {
            if ((this.mFloatView.isLayoutRequested()) && (!this.mFloatViewOnMeasured)) {
                measureFloatView();
            }
            this.mFloatView.layout(0, 0, this.mFloatView.getMeasuredWidth(), this.mFloatView.getMeasuredHeight());
            this.mFloatViewOnMeasured = false;
        }
    }

    public void moveItem(int paramInt1, int paramInt2) {
        if (this.mDropListener != null) {
            int i = getInputAdapter().getCount();
            if ((paramInt1 >= 0) && (paramInt1 < i) && (paramInt2 >= 0) && (paramInt2 < i)) {
                this.mDropListener.drop(paramInt1, paramInt2);
            }
        }
    }

    protected boolean onDragTouchEvent(MotionEvent paramMotionEvent) {
        paramMotionEvent.getAction();
        switch (paramMotionEvent.getAction() & 0xFF) {
        }
        for (; ; ) {
            return true;
            if (this.mDragState == 4) {
                cancelDrag();
            }
            doActionUpOrCancel();
            continue;
            if (this.mDragState == 4) {
                stopDrag(false);
            }
            doActionUpOrCancel();
            continue;
            continueDrag((int) paramMotionEvent.getX(), (int) paramMotionEvent.getY());
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.mTrackDragSort) {
            this.mDragSortTracker.appendState();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2;
        if (!this.mDragEnabled) {
            bool2 = super.onInterceptTouchEvent(paramMotionEvent);
            return bool2;
        }
        saveTouchCoords(paramMotionEvent);
        this.mLastCallWasIntercept = true;
        int i = paramMotionEvent.getAction() & 0xFF;
        if (i == 0) {
            if (this.mDragState != 0) {
                this.mIgnoreTouchEvent = true;
                return true;
            }
            this.mInTouchEvent = true;
        }
        boolean bool1 = false;
        if (this.mFloatView != null) {
            bool1 = true;
        }
        for (; ; ) {
            if (i != 1) {
                bool2 = bool1;
                if (i != 3) {
                    break;
                }
            }
            this.mInTouchEvent = false;
            return bool1;
            if (super.onInterceptTouchEvent(paramMotionEvent)) {
                bool1 = true;
            }
            switch (i) {
                case 2:
                default:
                    if (bool1) {
                        this.mCancelMethod = 1;
                    }
                    break;
                case 1:
                case 3:
                    doActionUpOrCancel();
                    continue;
                    this.mCancelMethod = 2;
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (this.mFloatView != null) {
            if (this.mFloatView.isLayoutRequested()) {
                measureFloatView();
            }
            this.mFloatViewOnMeasured = true;
        }
        this.mWidthMeasureSpec = paramInt1;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        updateScrollStarts();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2;
        if (this.mIgnoreTouchEvent) {
            this.mIgnoreTouchEvent = false;
            bool2 = false;
        }
        boolean bool1;
        do {
            return bool2;
            if (!this.mDragEnabled) {
                return super.onTouchEvent(paramMotionEvent);
            }
            bool2 = false;
            bool1 = this.mLastCallWasIntercept;
            this.mLastCallWasIntercept = false;
            if (!bool1) {
                saveTouchCoords(paramMotionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(paramMotionEvent);
                return true;
            }
            bool1 = bool2;
            if (this.mDragState == 0) {
                bool1 = bool2;
                if (super.onTouchEvent(paramMotionEvent)) {
                    bool1 = true;
                }
            }
            switch (paramMotionEvent.getAction() & 0xFF) {
                case 2:
                default:
                    bool2 = bool1;
            }
        } while (!bool1);
        this.mCancelMethod = 1;
        return bool1;
        doActionUpOrCancel();
        return bool1;
    }

    public void removeItem(int paramInt) {
        if ((this.mDragState == 0) || (this.mDragState == 4)) {
            if (this.mDragState == 0) {
                this.mSrcPos = (getHeaderViewsCount() + paramInt);
                this.mFirstExpPos = this.mSrcPos;
                this.mSecondExpPos = this.mSrcPos;
                this.mFloatPos = this.mSrcPos;
                View localView = getChildAt(this.mSrcPos - getFirstVisiblePosition());
                if (localView != null) {
                    localView.setVisibility(4);
                }
            }
            if (this.mInTouchEvent) {
                switch (this.mCancelMethod) {
                }
            }
        }
        while (this.mRemoveAnimator != null) {
            this.mRemoveAnimator.start();
            return;
            super.onTouchEvent(this.mCancelEvent);
            continue;
            super.onInterceptTouchEvent(this.mCancelEvent);
        }
        doRemoveItem(paramInt);
    }

    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        this.mAdapterWrapper = new AdapterWrapper((BaseAdapter) paramListAdapter);
        if (paramListAdapter != null) {
            paramListAdapter.registerDataSetObserver(this.mObserver);
            if ((paramListAdapter instanceof DropListener)) {
                setDropListener((DropListener) paramListAdapter);
            }
            if ((paramListAdapter instanceof DragListener)) {
                setDragListener((DragListener) paramListAdapter);
            }
            if ((paramListAdapter instanceof RemoveListener)) {
                setRemoveListener((RemoveListener) paramListAdapter);
            }
        }
        super.setAdapter(this.mAdapterWrapper);
    }

    public void setDragEnabled(boolean paramBoolean) {
        this.mDragEnabled = paramBoolean;
    }

    public void setDragListener(DragListener paramDragListener) {
        this.mDragListener = paramDragListener;
    }

    public void setDragScrollProfile(DragScrollProfile paramDragScrollProfile) {
        if (paramDragScrollProfile != null) {
            this.mScrollProfile = paramDragScrollProfile;
        }
    }

    public void setDragScrollStart(float paramFloat) {
        setDragScrollStarts(paramFloat, paramFloat);
    }

    public void setDragScrollStarts(float paramFloat1, float paramFloat2) {
        if (paramFloat2 > 0.5F) {
            this.mDragDownScrollStartFrac = 0.5F;
            if (paramFloat1 <= 0.5F) {
                break label46;
            }
        }
        label46:
        for (this.mDragUpScrollStartFrac = 0.5F; ; this.mDragUpScrollStartFrac = paramFloat1) {
            if (getHeight() != 0) {
                updateScrollStarts();
            }
            return;
            this.mDragDownScrollStartFrac = paramFloat2;
            break;
        }
    }

    public void setDragSortListener(DragSortListener paramDragSortListener) {
        setDropListener(paramDragSortListener);
        setDragListener(paramDragSortListener);
        setRemoveListener(paramDragSortListener);
    }

    public void setDropListener(DropListener paramDropListener) {
        this.mDropListener = paramDropListener;
    }

    public void setFloatAlpha(float paramFloat) {
        this.mCurrFloatAlpha = paramFloat;
    }

    public void setFloatViewManager(FloatViewManager paramFloatViewManager) {
        this.mFloatViewManager = paramFloatViewManager;
    }

    public void setMaxScrollSpeed(float paramFloat) {
        this.mMaxScrollSpeed = paramFloat;
    }

    public void setRemoveListener(RemoveListener paramRemoveListener) {
        this.mRemoveListener = paramRemoveListener;
    }

    public boolean startDrag(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((!this.mInTouchEvent) || (this.mFloatViewManager == null)) {
        }
        View localView;
        do {
            return false;
            localView = this.mFloatViewManager.onCreateFloatView(paramInt1);
        } while (localView == null);
        return startDrag(paramInt1, localView, paramInt2, paramInt3, paramInt4);
    }

    public boolean startDrag(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4) {
        boolean bool = true;
        if ((this.mDragState != 0) || (!this.mInTouchEvent) || (this.mFloatView != null) || (paramView == null)) {
            bool = false;
            return bool;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        paramInt1 += getHeaderViewsCount();
        this.mFirstExpPos = paramInt1;
        this.mSecondExpPos = paramInt1;
        this.mSrcPos = paramInt1;
        this.mFloatPos = paramInt1;
        this.mDragState = 4;
        this.mDragFlags = 0;
        this.mDragFlags |= paramInt2;
        this.mFloatView = paramView;
        measureFloatView();
        this.mDragDeltaX = paramInt3;
        this.mDragDeltaY = paramInt4;
        this.mDragStartY = this.mY;
        this.mFloatLoc.x = (this.mX - this.mDragDeltaX);
        this.mFloatLoc.y = (this.mY - this.mDragDeltaY);
        paramView = getChildAt(this.mSrcPos - getFirstVisiblePosition());
        if (paramView != null) {
            paramView.setVisibility(4);
        }
        if (this.mTrackDragSort) {
            this.mDragSortTracker.startTracking();
        }
        switch (this.mCancelMethod) {
        }
        for (; ; ) {
            requestLayout();
            if (this.mLiftAnimator == null) {
                break;
            }
            this.mLiftAnimator.start();
            return true;
            super.onTouchEvent(this.mCancelEvent);
            continue;
            super.onInterceptTouchEvent(this.mCancelEvent);
        }
    }

    public boolean stopDrag(boolean paramBoolean) {
        if (this.mFloatView != null) {
            this.mDragScroller.stopScrolling(true);
            if (paramBoolean) {
                removeItem(this.mSrcPos - getHeaderViewsCount());
            }
            for (; ; ) {
                if (this.mTrackDragSort) {
                    this.mDragSortTracker.stopTracking();
                }
                return true;
                if (this.mDropAnimator != null) {
                    this.mDropAnimator.start();
                } else {
                    dropFloatView();
                }
            }
        }
        return false;
    }

    private class AdapterWrapper
            extends HeaderViewListAdapter {
        private BaseAdapter mAdapter;

        public AdapterWrapper(BaseAdapter paramBaseAdapter) {
            super(null, paramBaseAdapter);
            this.mAdapter = paramBaseAdapter;
        }

        public BaseAdapter getAdapter() {
            return this.mAdapter;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            if (paramView != null) {
                paramViewGroup = (DragSortItemView) paramView;
                View localView1 = paramViewGroup.getChildAt(0);
                View localView2 = this.mAdapter.getView(paramInt, localView1, paramViewGroup);
                paramView = paramViewGroup;
                if (localView2 != localView1) {
                    paramViewGroup.removeViewAt(0);
                    paramViewGroup.addView(localView2);
                    paramView = paramViewGroup;
                }
            }
            for (; ; ) {
                DragSortListView.this.adjustItem(DragSortListView.this.getHeaderViewsCount() + paramInt, paramView, true);
                return paramView;
                paramView = new DragSortItemView(DragSortListView.this.getContext());
                paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                paramView.addView(this.mAdapter.getView(paramInt, null, paramView));
            }
        }
    }

    public static abstract interface DragListener {
        public abstract void drag(int paramInt1, int paramInt2);
    }

    public static abstract interface DragScrollProfile {
        public abstract float getSpeed(float paramFloat, long paramLong);
    }

    private class DragScroller
            implements Runnable {
        public static final int DOWN = 1;
        public static final int STOP = -1;
        public static final int UP = 0;
        private float dt;
        private int dy;
        private boolean mAbort;
        private long mCurrTime;
        private int mFirstFooter;
        private int mLastHeader;
        private long mPrevTime;
        private float mScrollSpeed;
        private boolean mScrolling = false;
        private int scrollDir;
        private long tStart;

        public DragScroller() {
        }

        public int getScrollDir() {
            if (this.mScrolling) {
                return this.scrollDir;
            }
            return -1;
        }

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public void run() {
            if (this.mAbort) {
                this.mScrolling = false;
                return;
            }
            int j = DragSortListView.this.getFirstVisiblePosition();
            int i = DragSortListView.this.getLastVisiblePosition();
            int m = DragSortListView.this.getCount();
            int k = DragSortListView.this.getPaddingTop();
            int n = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
            int i1 = Math.min(DragSortListView.this.mY, DragSortListView.this.mFloatViewMid + DragSortListView.this.mFloatViewHeightHalf);
            int i2 = Math.max(DragSortListView.this.mY, DragSortListView.this.mFloatViewMid - DragSortListView.this.mFloatViewHeightHalf);
            View localView;
            if (this.scrollDir == 0) {
                localView = DragSortListView.this.getChildAt(0);
                if (localView == null) {
                    this.mScrolling = false;
                    return;
                }
                if ((j == 0) && (localView.getTop() == k)) {
                    this.mScrolling = false;
                    return;
                }
                this.mScrollSpeed = DragSortListView.this.mScrollProfile.getSpeed((DragSortListView.this.mUpScrollStartYF - i2) / DragSortListView.this.mDragUpScrollHeight, this.mPrevTime);
                this.mCurrTime = SystemClock.uptimeMillis();
                this.dt = ((float) (this.mCurrTime - this.mPrevTime));
                this.dy = Math.round(this.mScrollSpeed * this.dt);
                if (this.dy < 0) {
                    break label468;
                }
                this.dy = Math.min(n, this.dy);
                i = j;
            }
            for (; ; ) {
                localView = DragSortListView.this.getChildAt(i - j);
                m = localView.getTop() + this.dy;
                j = m;
                if (i == 0) {
                    j = m;
                    if (m > k) {
                        j = k;
                    }
                }
                DragSortListView.this.mBlockLayoutRequests = true;
                DragSortListView.this.setSelectionFromTop(i, j - k);
                DragSortListView.this.layoutChildren();
                DragSortListView.this.invalidate();
                DragSortListView.this.mBlockLayoutRequests = false;
                DragSortListView.this.doDragFloatView(i, localView, false);
                this.mPrevTime = this.mCurrTime;
                DragSortListView.this.post(this);
                return;
                localView = DragSortListView.this.getChildAt(i - j);
                if (localView == null) {
                    this.mScrolling = false;
                    return;
                }
                if ((i == m - 1) && (localView.getBottom() <= n + k)) {
                    this.mScrolling = false;
                    return;
                }
                this.mScrollSpeed = (-DragSortListView.this.mScrollProfile.getSpeed((i1 - DragSortListView.this.mDownScrollStartYF) / DragSortListView.this.mDragDownScrollHeight, this.mPrevTime));
                break;
                label468:
                this.dy = Math.max(-n, this.dy);
            }
        }

        public void startScrolling(int paramInt) {
            if (!this.mScrolling) {
                this.mAbort = false;
                this.mScrolling = true;
                this.tStart = SystemClock.uptimeMillis();
                this.mPrevTime = this.tStart;
                this.scrollDir = paramInt;
                DragSortListView.this.post(this);
            }
        }

        public void stopScrolling(boolean paramBoolean) {
            if (paramBoolean) {
                DragSortListView.this.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.mAbort = true;
        }
    }

    public static abstract interface DragSortListener
            extends DragSortListView.DropListener, DragSortListView.DragListener, DragSortListView.RemoveListener {
    }

    private class DragSortTracker {
        StringBuilder mBuilder = new StringBuilder();
        File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        private int mNumFlushes = 0;
        private int mNumInBuffer = 0;
        private boolean mTracking = false;

        public DragSortTracker() {
            if (!this.mFile.exists()) {
            }
            try {
                this.mFile.createNewFile();
                Log.d("mobeta", "file created");
                return;
            } catch (IOException this$1) {
                Log.w("mobeta", "Could not create dslv_state.txt");
                Log.d("mobeta", DragSortListView.this.getMessage());
            }
        }

        public void appendState() {
            if (!this.mTracking) {
                return;
            }
            this.mBuilder.append("<DSLVState>\n");
            int j = DragSortListView.this.getChildCount();
            int k = DragSortListView.this.getFirstVisiblePosition();
            this.mBuilder.append("    <Positions>");
            int i = 0;
            label46:
            if (i >= j) {
                this.mBuilder.append("</Positions>\n");
                this.mBuilder.append("    <Tops>");
                i = 0;
                label73:
                if (i < j) {
                    break label482;
                }
                this.mBuilder.append("</Tops>\n");
                this.mBuilder.append("    <Bottoms>");
                i = 0;
                label100:
                if (i < j) {
                    break label513;
                }
                this.mBuilder.append("</Bottoms>\n");
                this.mBuilder.append("    <FirstExpPos>").append(DragSortListView.this.mFirstExpPos).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.this.getItemHeight(DragSortListView.this.mFirstExpPos) - DragSortListView.this.getChildHeight(DragSortListView.this.mFirstExpPos)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(DragSortListView.this.mSecondExpPos).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.this.getItemHeight(DragSortListView.this.mSecondExpPos) - DragSortListView.this.getChildHeight(DragSortListView.this.mSecondExpPos)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(DragSortListView.this.mSrcPos).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(DragSortListView.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(DragSortListView.this.mFloatViewMid).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                i = 0;
            }
            for (; ; ) {
                if (i >= j) {
                    this.mBuilder.append("</ShuffleEdges>\n");
                    this.mBuilder.append("</DSLVState>\n");
                    this.mNumInBuffer += 1;
                    if (this.mNumInBuffer <= 1000) {
                        break;
                    }
                    flush();
                    this.mNumInBuffer = 0;
                    return;
                    this.mBuilder.append(k + i).append(",");
                    i += 1;
                    break label46;
                    label482:
                    this.mBuilder.append(DragSortListView.this.getChildAt(i).getTop()).append(",");
                    i += 1;
                    break label73;
                    label513:
                    this.mBuilder.append(DragSortListView.this.getChildAt(i).getBottom()).append(",");
                    i += 1;
                    break label100;
                }
                this.mBuilder.append(DragSortListView.this.getShuffleEdge(k + i, DragSortListView.this.getChildAt(i).getTop())).append(",");
                i += 1;
            }
        }

        public void flush() {
            if (!this.mTracking) {
                return;
            }
            boolean bool = true;
            try {
                if (this.mNumFlushes == 0) {
                    bool = false;
                }
                FileWriter localFileWriter = new FileWriter(this.mFile, bool);
                localFileWriter.write(this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
                localFileWriter.flush();
                localFileWriter.close();
                this.mNumFlushes += 1;
                return;
            } catch (IOException localIOException) {
            }
        }

        public void startTracking() {
            this.mBuilder.append("<DSLVStates>\n");
            this.mNumFlushes = 0;
            this.mTracking = true;
        }

        public void stopTracking() {
            if (this.mTracking) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.mTracking = false;
            }
        }
    }

    private class DropAnimator
            extends DragSortListView.SmoothAnimator {
        private int mDropPos;
        private float mInitDeltaX;
        private float mInitDeltaY;
        private int srcPos;

        public DropAnimator(float paramFloat, int paramInt) {
            super(paramFloat, paramInt);
        }

        private int getTargetY() {
            int i = DragSortListView.this.getFirstVisiblePosition();
            int j = (DragSortListView.this.mItemHeightCollapsed + DragSortListView.this.getDividerHeight()) / 2;
            View localView = DragSortListView.this.getChildAt(this.mDropPos - i);
            if (localView != null) {
                if (this.mDropPos == this.srcPos) {
                    return localView.getTop();
                }
                if (this.mDropPos < this.srcPos) {
                    return localView.getTop() - j;
                }
                return localView.getBottom() + j - DragSortListView.this.mFloatViewHeight;
            }
            cancel();
            return -1;
        }

        public void onStart() {
            this.mDropPos = DragSortListView.this.mFloatPos;
            this.srcPos = DragSortListView.this.mSrcPos;
            DragSortListView.this.mDragState = 2;
            this.mInitDeltaY = (DragSortListView.this.mFloatLoc.y - getTargetY());
            this.mInitDeltaX = (DragSortListView.this.mFloatLoc.x - DragSortListView.this.getPaddingLeft());
        }

        public void onStop() {
            DragSortListView.this.dropFloatView();
        }

        public void onUpdate(float paramFloat1, float paramFloat2) {
            int i = getTargetY();
            paramFloat1 = DragSortListView.this.mFloatLoc.y - i;
            paramFloat2 = 1.0F - paramFloat2;
            if (paramFloat2 < Math.abs(paramFloat1 / this.mInitDeltaY)) {
                DragSortListView.this.mFloatLoc.y = ((int) (this.mInitDeltaY * paramFloat2) + i);
                DragSortListView.this.mFloatLoc.x = (DragSortListView.this.getPaddingLeft() + (int) (this.mInitDeltaX * paramFloat2));
                DragSortListView.this.doDragFloatView(true);
            }
        }
    }

    public static abstract interface DropListener {
        public abstract void drop(int paramInt1, int paramInt2);
    }

    public static abstract interface FloatViewManager {
        public abstract View onCreateFloatView(int paramInt);

        public abstract void onDestroyFloatView(View paramView);

        public abstract void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2);
    }

    private class HeightCache {
        private SparseIntArray mMap;
        private int mMaxSize;
        private ArrayList<Integer> mOrder;

        public HeightCache(int paramInt) {
            this.mMap = new SparseIntArray(paramInt);
            this.mOrder = new ArrayList(paramInt);
            this.mMaxSize = paramInt;
        }

        public void add(int paramInt1, int paramInt2) {
            int i = this.mMap.get(paramInt1, -1);
            if (i != paramInt2) {
                if (i != -1) {
                    break label77;
                }
                if (this.mMap.size() == this.mMaxSize) {
                    this.mMap.delete(((Integer) this.mOrder.remove(0)).intValue());
                }
            }
            for (; ; ) {
                this.mMap.put(paramInt1, paramInt2);
                this.mOrder.add(Integer.valueOf(paramInt1));
                return;
                label77:
                this.mOrder.remove(Integer.valueOf(paramInt1));
            }
        }

        public void clear() {
            this.mMap.clear();
            this.mOrder.clear();
        }

        public int get(int paramInt) {
            return this.mMap.get(paramInt, -1);
        }
    }

    private class LiftAnimator
            extends DragSortListView.SmoothAnimator {
        private float mFinalDragDeltaY;
        private float mInitDragDeltaY;

        public LiftAnimator(float paramFloat, int paramInt) {
            super(paramFloat, paramInt);
        }

        public void onStart() {
            this.mInitDragDeltaY = DragSortListView.this.mDragDeltaY;
            this.mFinalDragDeltaY = DragSortListView.this.mFloatViewHeightHalf;
        }

        public void onUpdate(float paramFloat1, float paramFloat2) {
            if (DragSortListView.this.mDragState != 4) {
                cancel();
                return;
            }
            DragSortListView.this.mDragDeltaY = ((int) (this.mFinalDragDeltaY * paramFloat2 + (1.0F - paramFloat2) * this.mInitDragDeltaY));
            DragSortListView.this.mFloatLoc.y = (DragSortListView.this.mY - DragSortListView.this.mDragDeltaY);
            DragSortListView.this.doDragFloatView(true);
        }
    }

    private class RemoveAnimator
            extends DragSortListView.SmoothAnimator {
        private int mFirstChildHeight = -1;
        private int mFirstPos;
        private float mFirstStartBlank;
        private int mSecondChildHeight = -1;
        private int mSecondPos;
        private float mSecondStartBlank;
        private int srcPos;

        public RemoveAnimator(float paramFloat, int paramInt) {
            super(paramFloat, paramInt);
        }

        public void onStart() {
            this.mFirstChildHeight = -1;
            this.mSecondChildHeight = -1;
            this.mFirstPos = DragSortListView.this.mFirstExpPos;
            this.mSecondPos = DragSortListView.this.mSecondExpPos;
            this.srcPos = DragSortListView.this.mSrcPos;
            DragSortListView.this.mDragState = 1;
            DragSortListView.this.destroyFloatView();
        }

        public void onStop() {
            DragSortListView.this.doRemoveItem();
        }

        public void onUpdate(float paramFloat1, float paramFloat2) {
            paramFloat1 = 1.0F - paramFloat2;
            int i = DragSortListView.this.getFirstVisiblePosition();
            View localView = DragSortListView.this.getChildAt(this.mFirstPos - i);
            ViewGroup.LayoutParams localLayoutParams;
            if (localView != null) {
                if (this.mFirstChildHeight == -1) {
                    this.mFirstChildHeight = DragSortListView.this.getChildHeight(this.mFirstPos, localView, false);
                    this.mFirstStartBlank = (localView.getHeight() - this.mFirstChildHeight);
                }
                int j = Math.max((int) (this.mFirstStartBlank * paramFloat1), 1);
                localLayoutParams = localView.getLayoutParams();
                localLayoutParams.height = (this.mFirstChildHeight + j);
                localView.setLayoutParams(localLayoutParams);
            }
            if (this.mSecondPos != this.mFirstPos) {
                localView = DragSortListView.this.getChildAt(this.mSecondPos - i);
                if (localView != null) {
                    if (this.mSecondChildHeight == -1) {
                        this.mSecondChildHeight = DragSortListView.this.getChildHeight(this.mSecondPos, localView, false);
                        this.mSecondStartBlank = (localView.getHeight() - this.mSecondChildHeight);
                    }
                    i = Math.max((int) (this.mSecondStartBlank * paramFloat1), 1);
                    localLayoutParams = localView.getLayoutParams();
                    localLayoutParams.height = (this.mSecondChildHeight + i);
                    localView.setLayoutParams(localLayoutParams);
                }
            }
        }
    }

    public static abstract interface RemoveListener {
        public abstract void remove(int paramInt);
    }

    private class SmoothAnimator
            implements Runnable {
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        private float mDurationF;
        private long mStartTime;

        public SmoothAnimator(float paramFloat, int paramInt) {
            this.mAlpha = paramFloat;
            this.mDurationF = paramInt;
            paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
            this.mD = paramFloat;
            this.mA = paramFloat;
            this.mB = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
            this.mC = (1.0F / (1.0F - this.mAlpha));
        }

        public void cancel() {
            this.mCanceled = true;
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void onUpdate(float paramFloat1, float paramFloat2) {
        }

        public void run() {
            if (this.mCanceled) {
                return;
            }
            float f = (float) (SystemClock.uptimeMillis() - this.mStartTime) / this.mDurationF;
            if (f >= 1.0F) {
                onUpdate(1.0F, 1.0F);
                onStop();
                return;
            }
            onUpdate(f, transform(f));
            DragSortListView.this.post(this);
        }

        public void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mCanceled = false;
            onStart();
            DragSortListView.this.post(this);
        }

        public float transform(float paramFloat) {
            if (paramFloat < this.mAlpha) {
                return this.mA * paramFloat * paramFloat;
            }
            if (paramFloat < 1.0F - this.mAlpha) {
                return this.mB + this.mC * paramFloat;
            }
            return 1.0F - this.mD * (paramFloat - 1.0F) * (paramFloat - 1.0F);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/mobeta/android/dslv/DragSortListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */