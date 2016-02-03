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
  implements View.OnTouchListener, GestureDetector.OnGestureListener
{
  public static final int CLICK_REMOVE = 0;
  public static final int FLING_REMOVE = 1;
  public static final int MISS = -1;
  public static final int ON_DOWN = 0;
  public static final int ON_DRAG = 1;
  public static final int ON_LONG_PRESS = 2;
  private boolean mCanDrag;
  private int mClickRemoveHitPos = -1;
  private int mClickRemoveId;
  private int mCurrX;
  private int mCurrY;
  private GestureDetector mDetector;
  private int mDragHandleId;
  private int mDragInitMode = 0;
  private boolean mDragging = false;
  private DragSortListView mDslv;
  private int mFlingHandleId;
  private int mFlingHitPos = -1;
  private GestureDetector mFlingRemoveDetector;
  private GestureDetector.OnGestureListener mFlingRemoveListener = new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int i;
      if ((DragSortController.this.mRemoveEnabled) && (DragSortController.this.mIsRemoving))
      {
        i = DragSortController.this.mDslv.getWidth() / 5;
        if (paramAnonymousFloat1 <= DragSortController.this.mFlingSpeed) {
          break label82;
        }
        if (DragSortController.this.mPositionX > -i) {
          DragSortController.this.mDslv.stopDragWithVelocity(true, paramAnonymousFloat1);
        }
      }
      for (;;)
      {
        DragSortController.this.mIsRemoving = false;
        return false;
        label82:
        if ((paramAnonymousFloat1 < -DragSortController.this.mFlingSpeed) && (DragSortController.this.mPositionX < i)) {
          DragSortController.this.mDslv.stopDragWithVelocity(true, paramAnonymousFloat1);
        }
      }
    }
  };
  private float mFlingSpeed = 500.0F;
  private int mHitPos = -1;
  private boolean mIsRemoving = false;
  private int mItemX;
  private int mItemY;
  private int mPositionX;
  private boolean mRemoveEnabled = false;
  private int mRemoveMode;
  private boolean mSortEnabled = true;
  private int[] mTempLoc = new int[2];
  private int mTouchSlop;
  
  public DragSortController(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.mDslv = paramDragSortListView;
    this.mDetector = new GestureDetector(paramDragSortListView.getContext(), this);
    this.mFlingRemoveDetector = new GestureDetector(paramDragSortListView.getContext(), this.mFlingRemoveListener);
    this.mFlingRemoveDetector.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.mDragHandleId = paramInt1;
    this.mClickRemoveId = paramInt4;
    this.mFlingHandleId = paramInt5;
    setRemoveMode(paramInt3);
    setDragInitMode(paramInt2);
  }
  
  public int dragHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mDragHandleId);
  }
  
  public int flingHandleHitPosition(MotionEvent paramMotionEvent)
  {
    return viewIdHitPosition(paramMotionEvent, this.mFlingHandleId);
  }
  
  public int getDragInitMode()
  {
    return this.mDragInitMode;
  }
  
  public int getRemoveMode()
  {
    return this.mRemoveMode;
  }
  
  public boolean isRemoveEnabled()
  {
    return this.mRemoveEnabled;
  }
  
  public boolean isSortEnabled()
  {
    return this.mSortEnabled;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0)) {
      this.mClickRemoveHitPos = viewIdHitPosition(paramMotionEvent, this.mClickRemoveId);
    }
    this.mHitPos = startDragPosition(paramMotionEvent);
    if ((this.mHitPos != -1) && (this.mDragInitMode == 0)) {
      startDrag(this.mHitPos, (int)paramMotionEvent.getX() - this.mItemX, (int)paramMotionEvent.getY() - this.mItemY);
    }
    this.mIsRemoving = false;
    this.mCanDrag = true;
    this.mPositionX = 0;
    this.mFlingHitPos = startFlingPosition(paramMotionEvent);
    return true;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
      this.mPositionX = paramPoint1.x;
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.mHitPos != -1) && (this.mDragInitMode == 2))
    {
      this.mDslv.performHapticFeedback(0);
      startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.mItemX;
    int i1 = m - this.mItemY;
    if ((this.mCanDrag) && (!this.mDragging) && ((this.mHitPos != -1) || (this.mFlingHitPos != -1)))
    {
      if (this.mHitPos == -1) {
        break label178;
      }
      if ((this.mDragInitMode != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.mSortEnabled)) {
        break label129;
      }
      startDrag(this.mHitPos, n, i1);
    }
    label129:
    label178:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mDragInitMode == 0) || (Math.abs(k - i) <= this.mTouchSlop) || (!this.mRemoveEnabled));
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      } while (this.mFlingHitPos == -1);
      if ((Math.abs(k - i) > this.mTouchSlop) && (this.mRemoveEnabled))
      {
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, n, i1);
        return false;
      }
    } while (Math.abs(m - j) <= this.mTouchSlop);
    this.mCanDrag = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveEnabled) && (this.mRemoveMode == 0) && (this.mClickRemoveHitPos != -1)) {
      this.mDslv.removeItem(this.mClickRemoveHitPos - this.mDslv.getHeaderViewsCount());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.mDslv.isDragEnabled()) || (this.mDslv.listViewIntercepted())) {
      return false;
    }
    this.mDetector.onTouchEvent(paramMotionEvent);
    if ((this.mRemoveEnabled) && (this.mDragging) && (this.mRemoveMode == 1)) {
      this.mFlingRemoveDetector.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.mCurrX = ((int)paramMotionEvent.getX());
      this.mCurrY = ((int)paramMotionEvent.getY());
      return false;
    case 1: 
      if ((this.mRemoveEnabled) && (this.mIsRemoving)) {
        if (this.mPositionX < 0) {
          break label183;
        }
      }
      break;
    }
    label183:
    for (int i = this.mPositionX;; i = -this.mPositionX)
    {
      if (i > this.mDslv.getWidth() / 2) {
        this.mDslv.stopDragWithVelocity(true, 0.0F);
      }
      this.mIsRemoving = false;
      this.mDragging = false;
      return false;
    }
  }
  
  public void setClickRemoveId(int paramInt)
  {
    this.mClickRemoveId = paramInt;
  }
  
  public void setDragHandleId(int paramInt)
  {
    this.mDragHandleId = paramInt;
  }
  
  public void setDragInitMode(int paramInt)
  {
    this.mDragInitMode = paramInt;
  }
  
  public void setFlingHandleId(int paramInt)
  {
    this.mFlingHandleId = paramInt;
  }
  
  public void setRemoveEnabled(boolean paramBoolean)
  {
    this.mRemoveEnabled = paramBoolean;
  }
  
  public void setRemoveMode(int paramInt)
  {
    this.mRemoveMode = paramInt;
  }
  
  public void setSortEnabled(boolean paramBoolean)
  {
    this.mSortEnabled = paramBoolean;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = j;
    if (this.mSortEnabled)
    {
      i = j;
      if (!this.mIsRemoving) {
        i = 0x0 | 0xC;
      }
    }
    j = i;
    if (this.mRemoveEnabled)
    {
      j = i;
      if (this.mIsRemoving) {
        j = i | 0x1 | 0x2;
      }
    }
    this.mDragging = this.mDslv.startDrag(paramInt1 - this.mDslv.getHeaderViewsCount(), j, paramInt2, paramInt3);
    return this.mDragging;
  }
  
  public int startDragPosition(MotionEvent paramMotionEvent)
  {
    return dragHandleHitPosition(paramMotionEvent);
  }
  
  public int startFlingPosition(MotionEvent paramMotionEvent)
  {
    if (this.mRemoveMode == 1) {
      return flingHandleHitPosition(paramMotionEvent);
    }
    return -1;
  }
  
  public int viewIdHitPosition(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.mDslv.pointToPosition(i, j);
    j = this.mDslv.getHeaderViewsCount();
    int k = this.mDslv.getFooterViewsCount();
    int m = this.mDslv.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.mDslv.getChildAt(i - this.mDslv.getFirstVisiblePosition());
      j = (int)paramMotionEvent.getRawX();
      k = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.mTempLoc);
        if ((j <= this.mTempLoc[0]) || (k <= this.mTempLoc[1]) || (j >= this.mTempLoc[0] + paramMotionEvent.getWidth()) || (k >= this.mTempLoc[1] + paramMotionEvent.getHeight())) {
          break;
        }
        this.mItemX = localView.getLeft();
        this.mItemY = localView.getTop();
        return i;
      }
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/mobeta/android/dslv/DragSortController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */