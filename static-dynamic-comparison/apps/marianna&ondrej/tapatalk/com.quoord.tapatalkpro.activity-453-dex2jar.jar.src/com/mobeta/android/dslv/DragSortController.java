package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class DragSortController
        extends SimpleFloatViewManager
        implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final int CLICK_REMOVE = 0;
    public static final int FLING_LEFT_REMOVE = 2;
    public static final int FLING_RIGHT_REMOVE = 1;
    public static final int MISS = -1;
    public static final int ON_DOWN = 0;
    public static final int ON_DRAG = 1;
    public static final int ON_LONG_PRESS = 2;
    public static final int SLIDE_LEFT_REMOVE = 4;
    public static final int SLIDE_RIGHT_REMOVE = 3;
    private int mClickRemoveHitPos = -1;
    private int mClickRemoveId;
    private int mCurrX;
    private int mCurrY;
    private GestureDetector mDetector;
    private int mDragHandleId;
    private int mDragInitMode = 0;
    private boolean mDragging = false;
    private DragSortListView mDslv;
    private GestureDetector mFlingRemoveDetector;
    private GestureDetector.OnGestureListener mFlingRemoveListener = new GestureDetector.SimpleOnGestureListener() {
        public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2) {
            if (DragSortController.this.mRemoveEnabled) {
                switch (DragSortController.this.mRemoveMode) {
                }
            }
            for (; ; ) {
                return false;
                if (paramAnonymousFloat1 > DragSortController.this.mFlingSpeed) {
                    DragSortController.this.mDslv.stopDrag(true);
                    continue;
                    if (paramAnonymousFloat1 < -DragSortController.this.mFlingSpeed) {
                        DragSortController.this.mDslv.stopDrag(true);
                    }
                }
            }
        }
    };
    private float mFlingSpeed = 500.0F;
    private int mHitPos = -1;
    private int mItemX;
    private int mItemY;
    private float mOrigFloatAlpha = 1.0F;
    private boolean mRemoveEnabled = false;
    private int mRemoveMode;
    private boolean mSortEnabled = true;
    private int[] mTempLoc = new int[2];
    private int mTouchSlop;

    public DragSortController(DragSortListView paramDragSortListView) {
        this(paramDragSortListView, 0, 0, 1);
    }

    public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3) {
        this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
    }

    public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super(paramDragSortListView);
        this.mDslv = paramDragSortListView;
        this.mDetector = new GestureDetector(paramDragSortListView.getContext(), this);
        this.mFlingRemoveDetector = new GestureDetector(paramDragSortListView.getContext(), this.mFlingRemoveListener);
        this.mFlingRemoveDetector.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
        this.mDragHandleId = paramInt1;
        this.mClickRemoveId = paramInt4;
        setRemoveMode(paramInt3);
        setDragInitMode(paramInt2);
        this.mOrigFloatAlpha = paramDragSortListView.getFloatAlpha();
    }

    public int dragHandleHitPosition(MotionEvent paramMotionEvent) {
        return viewIdHitPosition(paramMotionEvent, this.mDragHandleId);
    }

    public int getDragInitMode() {
        return this.mDragInitMode;
    }

    public int getRemoveMode() {
        return this.mRemoveMode;
    }

    public boolean isRemoveEnabled() {
        return this.mRemoveEnabled;
    }

    public boolean isSortEnabled() {
        return this.mSortEnabled;
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        if ((this.mRemoveEnabled) && (this.mRemoveMode == 0)) {
            this.mClickRemoveHitPos = viewIdHitPosition(paramMotionEvent, this.mClickRemoveId);
        }
        this.mHitPos = startDragPosition(paramMotionEvent);
        if ((this.mHitPos != -1) && (this.mDragInitMode == 0)) {
            startDrag(this.mHitPos, (int) paramMotionEvent.getX() - this.mItemX, (int) paramMotionEvent.getY() - this.mItemY);
        }
        return true;
    }

    public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2) {
        int i;
        float f;
        if (this.mRemoveEnabled) {
            i = paramPoint2.x;
            j = paramPoint2.y;
            if (this.mRemoveMode != 3) {
                break label101;
            }
            j = this.mDslv.getWidth();
            k = j / 3;
            if (i >= k) {
                break label67;
            }
            f = 1.0F;
            this.mDslv.setFloatAlpha(this.mOrigFloatAlpha * f);
        }
        label67:
        label101:
        while (this.mRemoveMode != 4) {
            for (; ; ) {
                return;
                if (i < j - k) {
                    f = (j - k - i) / k;
                } else {
                    f = 0.0F;
                }
            }
        }
        int j = this.mDslv.getWidth();
        int k = j / 3;
        if (i < k) {
            f = 0.0F;
        }
        for (; ; ) {
            this.mDslv.setFloatAlpha(this.mOrigFloatAlpha * f);
            return;
            if (i < j - k) {
                f = (i - k) / k;
            } else {
                f = 1.0F;
            }
        }
    }

    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        return false;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
        if ((this.mHitPos != -1) && (this.mDragInitMode == 2)) {
            this.mDslv.performHapticFeedback(0);
            startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
        }
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        int n;
        int m;
        int j;
        int k;
        if ((this.mHitPos != -1) && (this.mDragInitMode == 1) && (!this.mDragging)) {
            n = (int) paramMotionEvent1.getX();
            m = (int) paramMotionEvent1.getY();
            j = (int) paramMotionEvent2.getX();
            k = (int) paramMotionEvent2.getY();
            i = 0;
            if ((!this.mRemoveEnabled) || (!this.mSortEnabled)) {
                break label101;
            }
            i = 1;
        }
        label101:
        do {
            if (i != 0) {
                startDrag(this.mHitPos, j - this.mItemX, k - this.mItemY);
            }
            return false;
            if (this.mRemoveEnabled) {
                if (Math.abs(j - n) > this.mTouchSlop) {
                }
                for (i = 1; ; i = 0) {
                    break;
                }
            }
        } while (!this.mSortEnabled);
        if (Math.abs(k - m) > this.mTouchSlop) {
        }
        for (int i = 1; ; i = 0) {
            break;
        }
    }

    public void onShowPress(MotionEvent paramMotionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
        if ((this.mRemoveEnabled) && (this.mRemoveMode == 0) && (this.mClickRemoveHitPos != -1)) {
            this.mDslv.removeItem(this.mClickRemoveHitPos - this.mDslv.getHeaderViewsCount());
        }
        return true;
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        this.mDetector.onTouchEvent(paramMotionEvent);
        if ((this.mRemoveEnabled) && (this.mDragging) && ((this.mRemoveMode == 1) || (this.mRemoveMode == 2))) {
            this.mFlingRemoveDetector.onTouchEvent(paramMotionEvent);
        }
        switch (paramMotionEvent.getAction() & 0xFF) {
            case 2:
            default:
                return false;
            case 0:
                this.mCurrX = ((int) paramMotionEvent.getX());
                this.mCurrY = ((int) paramMotionEvent.getY());
                return false;
            case 1:
                if (this.mRemoveEnabled) {
                    int i = (int) paramMotionEvent.getX();
                    int j = this.mDslv.getWidth() / 3;
                    int k = this.mDslv.getWidth();
                    if (((this.mRemoveMode == 3) && (i > k - j)) || ((this.mRemoveMode == 4) && (i < j))) {
                        this.mDslv.stopDrag(true);
                    }
                }
                break;
        }
        this.mDragging = false;
        return false;
    }

    public void setClickRemoveId(int paramInt) {
        this.mClickRemoveId = paramInt;
    }

    public void setDragHandleId(int paramInt) {
        this.mDragHandleId = paramInt;
    }

    public void setDragInitMode(int paramInt) {
        this.mDragInitMode = paramInt;
    }

    public void setRemoveEnabled(boolean paramBoolean) {
        this.mRemoveEnabled = paramBoolean;
    }

    public void setRemoveMode(int paramInt) {
        this.mRemoveMode = paramInt;
    }

    public void setSortEnabled(boolean paramBoolean) {
        this.mSortEnabled = paramBoolean;
    }

    public boolean startDrag(int paramInt1, int paramInt2, int paramInt3) {
        int i = 0;
        if (this.mSortEnabled) {
            i = 0x0 | 0xC;
        }
        int j = i;
        if (this.mRemoveEnabled) {
            if (this.mRemoveMode != 1) {
                break label70;
            }
            j = i | 0x1;
        }
        for (; ; ) {
            this.mDragging = this.mDslv.startDrag(paramInt1 - this.mDslv.getHeaderViewsCount(), j, paramInt2, paramInt3);
            return this.mDragging;
            label70:
            j = i;
            if (this.mRemoveMode == 2) {
                j = i | 0x2;
            }
        }
    }

    public int startDragPosition(MotionEvent paramMotionEvent) {
        return dragHandleHitPosition(paramMotionEvent);
    }

    public int viewIdHitPosition(MotionEvent paramMotionEvent, int paramInt) {
        int i = (int) paramMotionEvent.getX();
        int j = (int) paramMotionEvent.getY();
        i = this.mDslv.pointToPosition(i, j);
        j = this.mDslv.getHeaderViewsCount();
        int k = this.mDslv.getFooterViewsCount();
        int m = this.mDslv.getCount();
        if ((i != -1) && (i >= j) && (i < m - k)) {
            View localView = this.mDslv.getChildAt(i - this.mDslv.getFirstVisiblePosition());
            j = (int) paramMotionEvent.getRawX();
            k = (int) paramMotionEvent.getRawY();
            paramMotionEvent = localView.findViewById(paramInt);
            if (paramMotionEvent != null) {
                paramMotionEvent.getLocationOnScreen(this.mTempLoc);
                if ((j > this.mTempLoc[0]) && (k > this.mTempLoc[1]) && (j < this.mTempLoc[0] + paramMotionEvent.getWidth()) && (k < this.mTempLoc[1] + paramMotionEvent.getHeight())) {
                    this.mItemX = localView.getLeft();
                    this.mItemY = localView.getTop();
                    return i;
                }
            }
        }
        return -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/mobeta/android/dslv/DragSortController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */