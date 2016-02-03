package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager
  extends ViewGroup
{
  private static final int CLOSE_ENOUGH = 2;
  private static final Comparator<ItemInfo> COMPARATOR = new Comparator()
  {
    public int compare(ViewPager.ItemInfo paramAnonymousItemInfo1, ViewPager.ItemInfo paramAnonymousItemInfo2)
    {
      return paramAnonymousItemInfo1.position - paramAnonymousItemInfo2.position;
    }
  };
  private static final boolean DEBUG = false;
  private static final int DEFAULT_GUTTER_SIZE = 16;
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  private static final int DRAW_ORDER_DEFAULT = 0;
  private static final int DRAW_ORDER_FORWARD = 1;
  private static final int DRAW_ORDER_REVERSE = 2;
  private static final int INVALID_POINTER = -1;
  private static final int[] LAYOUT_ATTRS = { 16842931 };
  private static final int MAX_SETTLE_DURATION = 600;
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  private static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String TAG = "ViewPager";
  private static final boolean USE_CACHE = false;
  private static final Interpolator sInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private OnAdapterChangeListener mAdapterChangeListener;
  private int mBottomPageBounds;
  private boolean mCalledSuper;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCloseEnough;
  private int mCurItem;
  private int mDecorChildCount;
  private int mDefaultGutterSize;
  private int mDrawingOrder;
  private ArrayList<View> mDrawingOrderedChildren;
  private final Runnable mEndScrollRunnable = new Runnable()
  {
    public void run()
    {
      ViewPager.this.setScrollState(0);
      ViewPager.this.populate();
    }
  };
  private int mExpectedAdapterCount;
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.4028235E38F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mIgnoreGutter;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private OnPageChangeListener mInternalPageChangeListener;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private float mLastOffset = Float.MAX_VALUE;
  private EdgeEffectCompat mLeftEdge;
  private Drawable mMarginDrawable;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  private boolean mNeedCalculatePageOffsets = false;
  private PagerObserver mObserver;
  private int mOffscreenPageLimit = 1;
  private OnPageChangeListener mOnPageChangeListener;
  private int mPageMargin;
  private PageTransformer mPageTransformer;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private EdgeEffectCompat mRightEdge;
  private int mScrollState = 0;
  private Scroller mScroller;
  private boolean mScrollingCacheEnabled;
  private Method mSetChildrenDrawingOrderEnabled;
  private final ItemInfo mTempItem = new ItemInfo();
  private final Rect mTempRect = new Rect();
  private int mTopPageBounds;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2)
  {
    int m = this.mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    int j;
    label94:
    int k;
    float f3;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramItemInfo2 != null)
      {
        i = paramItemInfo2.position;
        if (i >= paramItemInfo1.position) {
          break label369;
        }
        j = 0;
        f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
        i += 1;
        if ((i <= paramItemInfo1.position) && (j < this.mItems.size())) {
          break label233;
        }
      }
      k = this.mItems.size();
      f3 = paramItemInfo1.offset;
      i = paramItemInfo1.position - 1;
      if (paramItemInfo1.position != 0) {
        break label542;
      }
      f1 = paramItemInfo1.offset;
      label130:
      this.mFirstOffset = f1;
      if (paramItemInfo1.position != m - 1) {
        break label549;
      }
    }
    label233:
    label246:
    label321:
    label369:
    label401:
    label428:
    label494:
    label542:
    label549:
    for (float f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;; f1 = Float.MAX_VALUE)
    {
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
      if (j >= 0) {
        break label556;
      }
      f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
      i = paramItemInfo1.position + 1;
      j = paramInt + 1;
      paramInt = i;
      i = j;
      if (i < k) {
        break label650;
      }
      this.mNeedCalculatePageOffsets = false;
      return;
      f2 = 0.0F;
      break;
      paramItemInfo2 = (ItemInfo)this.mItems.get(j);
      f3 = f1;
      k = i;
      if (i > paramItemInfo2.position)
      {
        if (j < this.mItems.size() - 1) {
          break label321;
        }
        k = i;
        f3 = f1;
      }
      for (;;)
      {
        if (k >= paramItemInfo2.position)
        {
          paramItemInfo2.offset = f3;
          f1 = f3 + (paramItemInfo2.widthFactor + f2);
          i = k + 1;
          break;
          j += 1;
          paramItemInfo2 = (ItemInfo)this.mItems.get(j);
          break label246;
        }
        f3 += this.mAdapter.getPageWidth(k) + f2;
        k += 1;
      }
      if (i <= paramItemInfo1.position) {
        break label94;
      }
      j = this.mItems.size() - 1;
      f1 = paramItemInfo2.offset;
      i -= 1;
      if ((i >= paramItemInfo1.position) && (j >= 0))
      {
        paramItemInfo2 = (ItemInfo)this.mItems.get(j);
        f3 = f1;
        k = i;
        if (i < paramItemInfo2.position)
        {
          if (j > 0) {
            break label494;
          }
          k = i;
          f3 = f1;
        }
      }
      for (;;)
      {
        if (k <= paramItemInfo2.position)
        {
          f1 = f3 - (paramItemInfo2.widthFactor + f2);
          paramItemInfo2.offset = f1;
          i = k - 1;
          break label401;
          break;
          j -= 1;
          paramItemInfo2 = (ItemInfo)this.mItems.get(j);
          break label428;
        }
        f3 -= this.mAdapter.getPageWidth(k) + f2;
        k -= 1;
      }
      f1 = -3.4028235E38F;
      break label130;
    }
    label556:
    paramItemInfo2 = (ItemInfo)this.mItems.get(j);
    for (;;)
    {
      if (i <= paramItemInfo2.position)
      {
        f1 -= paramItemInfo2.widthFactor + f2;
        paramItemInfo2.offset = f1;
        if (paramItemInfo2.position == 0) {
          this.mFirstOffset = f1;
        }
        j -= 1;
        i -= 1;
        break;
      }
      f1 -= this.mAdapter.getPageWidth(i) + f2;
      i -= 1;
    }
    label650:
    paramItemInfo1 = (ItemInfo)this.mItems.get(i);
    for (;;)
    {
      if (paramInt >= paramItemInfo1.position)
      {
        if (paramItemInfo1.position == m - 1) {
          this.mLastOffset = (paramItemInfo1.widthFactor + f1 - 1.0F);
        }
        paramItemInfo1.offset = f1;
        f1 += paramItemInfo1.widthFactor + f2;
        i += 1;
        paramInt += 1;
        break;
      }
      f1 += this.mAdapter.getPageWidth(paramInt) + f2;
      paramInt += 1;
    }
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    int i;
    int j;
    if (this.mScrollState == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.mScroller.getCurrX();
        int n = this.mScroller.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.mPopulatePending = false;
      int k = 0;
      j = i;
      i = k;
    }
    for (;;)
    {
      if (i >= this.mItems.size())
      {
        if (j != 0)
        {
          if (!paramBoolean) {
            break label158;
          }
          ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
        }
        return;
        i = 0;
        break;
      }
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (localItemInfo.scrolling)
      {
        j = 1;
        localItemInfo.scrolling = false;
      }
      i += 1;
    }
    label158:
    this.mEndScrollRunnable.run();
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(0);
          ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localItemInfo1.position, Math.min(paramInt1, localItemInfo2.position));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.mCurItem) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 = (int)(paramInt1 + paramFloat + f);
      break;
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i >= k) {
      return;
    }
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      ViewCompat.setLayerType(getChildAt(i), j, null);
      i += 1;
      break;
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null) {
      localRect.set(0, 0, 0, 0);
    }
    for (;;)
    {
      return localRect;
      localRect.left = paramView.getLeft();
      localRect.right = paramView.getRight();
      localRect.top = paramView.getTop();
      localRect.bottom = paramView.getBottom();
      for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
      {
        paramRect = (ViewGroup)paramRect;
        localRect.left += paramRect.getLeft();
        localRect.right += paramRect.getRight();
        localRect.top += paramRect.getTop();
        localRect.bottom += paramRect.getBottom();
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    float f2 = 0.0F;
    int i = getClientWidth();
    float f1;
    int k;
    float f3;
    float f4;
    int j;
    Object localObject;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i > 0) {
        f2 = this.mPageMargin / i;
      }
      k = -1;
      f3 = 0.0F;
      f4 = 0.0F;
      j = 1;
      localObject = null;
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mItems.size()) {}
      int m;
      ItemInfo localItemInfo1;
      do
      {
        return (ItemInfo)localObject;
        f1 = 0.0F;
        break;
        ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(i);
        m = i;
        localItemInfo1 = localItemInfo2;
        if (j == 0)
        {
          m = i;
          localItemInfo1 = localItemInfo2;
          if (localItemInfo2.position != k + 1)
          {
            localItemInfo1 = this.mTempItem;
            localItemInfo1.offset = (f3 + f4 + f2);
            localItemInfo1.position = (k + 1);
            localItemInfo1.widthFactor = this.mAdapter.getPageWidth(localItemInfo1.position);
            m = i - 1;
          }
        }
        f3 = localItemInfo1.offset;
        f4 = localItemInfo1.widthFactor;
      } while ((j == 0) && (f1 < f3));
      if ((f1 < f4 + f3 + f2) || (m == this.mItems.size() - 1)) {
        return localItemInfo1;
      }
      j = 0;
      k = localItemInfo1.position;
      f4 = localItemInfo1.widthFactor;
      i = m + 1;
      localObject = localItemInfo1;
    }
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.mGutterSize) && (paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
    }
  }
  
  private boolean pageScrolled(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      ItemInfo localItemInfo = infoForCurrentScrollPosition();
      int j = getClientWidth();
      int k = this.mPageMargin;
      float f = this.mPageMargin / j;
      int i = localItemInfo.position;
      f = (paramInt / j - localItemInfo.offset) / (localItemInfo.widthFactor + f);
      paramInt = (int)((j + k) * f);
      this.mCalledSuper = false;
      onPageScrolled(i, f, paramInt);
      if (!this.mCalledSuper) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private boolean performDrag(float paramFloat)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.mFirstOffset;
    f1 = k * this.mLastOffset;
    int i = 1;
    int j = 1;
    ItemInfo localItemInfo1 = (ItemInfo)this.mItems.get(0);
    ItemInfo localItemInfo2 = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (localItemInfo1.position != 0)
    {
      i = 0;
      paramFloat = localItemInfo1.offset * k;
    }
    if (localItemInfo2.position != this.mAdapter.getCount() - 1)
    {
      j = 0;
      f1 = localItemInfo2.offset * k;
    }
    if (f2 < paramFloat) {
      if (i != 0) {
        bool1 = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / k);
      }
    }
    for (;;)
    {
      this.mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      return bool1;
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (j != 0) {
          bool1 = this.mRightEdge.onPull(Math.abs(f2 - f1) / k);
        }
        paramFloat = f1;
      }
    }
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.mScroller.isFinished())
      {
        paramInt3 = this.mScroller.getDuration();
        paramInt4 = this.mScroller.timePassed();
        localItemInfo = infoForPosition(this.mCurItem);
        this.mScroller.startScroll(paramInt2, 0, (int)(localItemInfo.offset * paramInt1), 0, paramInt3 - paramInt4);
      }
      return;
    }
    ItemInfo localItemInfo = infoForPosition(this.mCurItem);
    if (localItemInfo != null) {}
    for (float f = Math.min(localItemInfo.offset, this.mLastOffset);; f = 0.0F)
    {
      paramInt1 = (int)((paramInt1 - getPaddingLeft() - getPaddingRight()) * f);
      if (paramInt1 == getScrollX()) {
        break;
      }
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0;; i = j + 1)
    {
      if (i >= getChildCount()) {
        return;
      }
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    int i = 0;
    if (localItemInfo != null) {
      i = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)));
    }
    if (paramBoolean1)
    {
      smoothScrollTo(i, 0, paramInt2);
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(paramInt1);
      }
      return;
    }
    if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
      this.mOnPageChangeListener.onPageSelected(paramInt1);
    }
    if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
      this.mInternalPageChangeListener.onPageSelected(paramInt1);
    }
    completeScroll(false);
    scrollTo(i, 0);
    pageScrolled(i);
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      enableLayers(bool);
      if (this.mOnPageChangeListener == null) {
        break;
      }
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    int j;
    int i;
    if (this.mDrawingOrder != 0)
    {
      if (this.mDrawingOrderedChildren != null) {
        break label48;
      }
      this.mDrawingOrderedChildren = new ArrayList();
      j = getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        return;
        label48:
        this.mDrawingOrderedChildren.clear();
        break;
      }
      View localView = getChildAt(i);
      this.mDrawingOrderedChildren.add(localView);
      i += 1;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    int i;
    if (k != 393216)
    {
      i = 0;
      if (i < getChildCount()) {}
    }
    else
    {
      if (((k != 262144) || (j == paramArrayList.size())) && (isFocusable())) {
        break label115;
      }
    }
    label115:
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null))
    {
      return;
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
      i += 1;
      break;
    }
    paramArrayList.add(this);
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    localItemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i >= getChildCount()) {
        return;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    paramLayoutParams.isDecor |= paramView instanceof Decor;
    if (this.mInLayout)
    {
      if ((paramLayoutParams != null) && (paramLayoutParams.isDecor)) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      paramLayoutParams.needsMeasure = true;
      addViewInLayout(paramView, paramInt, localLayoutParams);
      return;
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    boolean bool;
    int i;
    int j;
    if (localView == this)
    {
      localObject = null;
      bool = false;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label341;
      }
      if (paramInt != 17) {
        break label278;
      }
      i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
      j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
      if ((localObject == null) || (i < j)) {
        break label268;
      }
      bool = pageLeft();
    }
    for (;;)
    {
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
      localObject = localView;
      if (localView == null) {
        break;
      }
      i = 0;
      localObject = localView.getParent();
      label126:
      label134:
      StringBuilder localStringBuilder;
      if (!(localObject instanceof ViewGroup))
      {
        localObject = localView;
        if (i != 0) {
          break;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
      }
      for (localObject = localView.getParent();; localObject = ((ViewParent)localObject).getParent())
      {
        if (!(localObject instanceof ViewGroup))
        {
          Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
          localObject = null;
          break;
          if (localObject == this)
          {
            i = 1;
            break label134;
          }
          localObject = ((ViewParent)localObject).getParent();
          break label126;
        }
        localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
      }
      label268:
      bool = localView.requestFocus();
      continue;
      label278:
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, (View)localObject).left;
        if ((localObject != null) && (i <= j))
        {
          bool = pageRight();
        }
        else
        {
          bool = localView.requestFocus();
          continue;
          label341:
          if ((paramInt == 17) || (paramInt == 1)) {
            bool = pageLeft();
          } else if ((paramInt == 66) || (paramInt == 2)) {
            bool = pageRight();
          }
        }
      }
    }
  }
  
  public boolean beginFakeDrag()
  {
    if (this.mIsBeingDragged) {
      return false;
    }
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.mVelocityTracker.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.mFakeDragBeginTime = l;
      return true;
      this.mVelocityTracker.clear();
    }
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup;
    int j;
    int k;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      j = paramView.getScrollX();
      k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        if ((!paramBoolean) || (!ViewCompat.canScrollHorizontally(paramView, -paramInt1))) {
          break;
        }
        return true;
      }
      View localView = localViewGroup.getChildAt(i);
      if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.mAdapter == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = getClientWidth();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.mFirstOffset));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.mLastOffset)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  void dataSetChanged()
  {
    int i4 = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i4;
    int i;
    int j;
    int k;
    int m;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < i4))
    {
      i = 1;
      j = this.mCurItem;
      k = 0;
      m = 0;
      if (m < this.mItems.size()) {
        break label124;
      }
      if (k != 0) {
        this.mAdapter.finishUpdate(this);
      }
      Collections.sort(this.mItems, COMPARATOR);
      if (i != 0)
      {
        k = getChildCount();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= k)
      {
        setCurrentItemInternal(j, false, true);
        requestLayout();
        return;
        i = 0;
        break;
        label124:
        localObject = (ItemInfo)this.mItems.get(m);
        int i3 = this.mAdapter.getItemPosition(((ItemInfo)localObject).object);
        int n;
        int i1;
        int i2;
        if (i3 == -1)
        {
          n = j;
          i1 = k;
          i2 = m;
        }
        for (;;)
        {
          m = i2 + 1;
          k = i1;
          j = n;
          break;
          if (i3 == -2)
          {
            this.mItems.remove(m);
            i3 = m - 1;
            m = k;
            if (k == 0)
            {
              this.mAdapter.startUpdate(this);
              m = 1;
            }
            this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
            i = 1;
            i2 = i3;
            i1 = m;
            n = j;
            if (this.mCurItem == ((ItemInfo)localObject).position)
            {
              n = Math.max(0, Math.min(this.mCurItem, i4 - 1));
              i = 1;
              i2 = i3;
              i1 = m;
            }
          }
          else
          {
            i2 = m;
            i1 = k;
            n = j;
            if (((ItemInfo)localObject).position != i3)
            {
              if (((ItemInfo)localObject).position == this.mCurItem) {
                j = i3;
              }
              ((ItemInfo)localObject).position = i3;
              i = 1;
              i2 = m;
              i1 = k;
              n = j;
            }
          }
        }
      }
      Object localObject = (LayoutParams)getChildAt(i).getLayoutParams();
      if (!((LayoutParams)localObject).isDecor) {
        ((LayoutParams)localObject).widthFactor = 0.0F;
      }
      i += 1;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mAdapter != null) && (this.mAdapter.getCount() > 1)))
    {
      int j;
      if (!this.mLeftEdge.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.mFirstOffset * m);
        this.mLeftEdge.setSize(i, m);
        j = false | this.mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.mRightEdge.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * k);
        this.mRightEdge.setSize(n - i1 - i2, k);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    Object localObject = this.mVelocityTracker;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
    int i = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
    this.mPopulatePending = true;
    int j = getClientWidth();
    int k = getScrollX();
    localObject = infoForCurrentScrollPosition();
    setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (k / j - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
    endDrag();
    this.mFakeDragging = false;
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return arrowScroll(17);
        return arrowScroll(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return arrowScroll(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.mFakeDragging) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.mLastMotionX += paramFloat;
    float f2 = getScrollX() - paramFloat;
    int i = getClientWidth();
    paramFloat = i * this.mFirstOffset;
    float f1 = i * this.mLastOffset;
    Object localObject = (ItemInfo)this.mItems.get(0);
    ItemInfo localItemInfo = (ItemInfo)this.mItems.get(this.mItems.size() - 1);
    if (((ItemInfo)localObject).position != 0) {
      paramFloat = ((ItemInfo)localObject).offset * i;
    }
    if (localItemInfo.position != this.mAdapter.getCount() - 1) {
      f1 = localItemInfo.offset * i;
    }
    if (f2 < paramFloat) {}
    for (;;)
    {
      this.mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      long l = SystemClock.uptimeMillis();
      localObject = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement((MotionEvent)localObject);
      ((MotionEvent)localObject).recycle();
      return;
      paramFloat = f2;
      if (f2 > f1) {
        paramFloat = f1;
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mDrawingOrder == 2) {}
    for (paramInt1 = paramInt1 - 1 - paramInt2;; paramInt1 = paramInt2) {
      return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(paramInt1)).getLayoutParams()).childIndex;
    }
  }
  
  public int getCurrentItem()
  {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        return infoForChild(paramView);
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
  }
  
  ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i >= this.mItems.size()) {
        localObject = null;
      }
      ItemInfo localItemInfo;
      do
      {
        return (ItemInfo)localObject;
        localItemInfo = (ItemInfo)this.mItems.get(i);
        localObject = localItemInfo;
      } while (this.mAdapter.isViewFromObject(paramView, localItemInfo.object));
      i += 1;
    }
  }
  
  ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i >= this.mItems.size()) {
        localObject = null;
      }
      ItemInfo localItemInfo;
      do
      {
        return (ItemInfo)localObject;
        localItemInfo = (ItemInfo)this.mItems.get(i);
        localObject = localItemInfo;
      } while (localItemInfo.position == paramInt);
      i += 1;
    }
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.mMinimumVelocity = ((int)(400.0F * f));
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(localContext);
    this.mRightEdge = new EdgeEffectCompat(localContext);
    this.mFlingDistance = ((int)(25.0F * f));
    this.mCloseEnough = ((int)(2.0F * f));
    this.mDefaultGutterSize = ((int)(16.0F * f));
    ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mEndScrollRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k;
    int m;
    float f3;
    int j;
    Object localObject;
    int n;
    int i;
    if ((this.mPageMargin > 0) && (this.mMarginDrawable != null) && (this.mItems.size() > 0) && (this.mAdapter != null))
    {
      k = getScrollX();
      m = getWidth();
      f3 = this.mPageMargin / m;
      j = 0;
      localObject = (ItemInfo)this.mItems.get(0);
      f1 = ((ItemInfo)localObject).offset;
      n = this.mItems.size();
      i = ((ItemInfo)localObject).position;
      int i1 = ((ItemInfo)this.mItems.get(n - 1)).position;
      if (i < i1) {}
    }
    else
    {
      label123:
      return;
    }
    while ((i > ((ItemInfo)localObject).position) && (j < n))
    {
      localObject = this.mItems;
      j += 1;
      localObject = (ItemInfo)((ArrayList)localObject).get(j);
    }
    float f2;
    if (i == ((ItemInfo)localObject).position) {
      f2 = (((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor) * m;
    }
    float f4;
    for (float f1 = ((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor + f3;; f1 += f4 + f3)
    {
      if (this.mPageMargin + f2 > k)
      {
        this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
        this.mMarginDrawable.draw(paramCanvas);
      }
      if (f2 > k + m) {
        break label123;
      }
      i += 1;
      break;
      f4 = this.mAdapter.getPageWidth(i);
      f2 = (f1 + f4) * m;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      return false;
    }
    if (i != 0)
    {
      if (this.mIsBeingDragged) {
        return true;
      }
      if (this.mIsUnableToDrag) {
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i);
        float f1 = f2 - this.mLastMotionX;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i);
        float f5 = Math.abs(f3 - this.mInitialMotionY);
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.mLastMotionX = f2;
          this.mLastMotionY = f3;
          this.mIsUnableToDrag = true;
          return false;
        }
        if ((f4 > this.mTouchSlop) && (0.5F * f4 > f5))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label310:
            this.mLastMotionX = f1;
            this.mLastMotionY = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label310;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        this.mInitialMotionY = f1;
        this.mLastMotionY = f1;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          this.mIsBeingDragged = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i5 = paramInt3 - paramInt1;
    int i4 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int m = 0;
    if (m >= i3)
    {
      i = i5 - paramInt2 - i;
      paramInt3 = 0;
    }
    for (;;)
    {
      int j;
      LayoutParams localLayoutParams;
      if (paramInt3 >= i3)
      {
        this.mTopPageBounds = paramInt1;
        this.mBottomPageBounds = (i4 - paramInt4);
        this.mDecorChildCount = k;
        if (this.mFirstLayout) {
          scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
        return;
        localView = getChildAt(m);
        int i2 = k;
        int i1 = paramInt4;
        j = paramInt2;
        int n = i;
        paramInt3 = paramInt1;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i2 = k;
          i1 = paramInt4;
          j = paramInt2;
          n = i;
          paramInt3 = paramInt1;
          if (localLayoutParams.isDecor)
          {
            paramInt3 = localLayoutParams.gravity;
            n = localLayoutParams.gravity;
            switch (paramInt3 & 0x7)
            {
            case 2: 
            case 4: 
            default: 
              paramInt3 = paramInt2;
              j = paramInt2;
              label254:
              switch (n & 0x70)
              {
              default: 
                paramInt2 = paramInt1;
              }
              break;
            }
          }
        }
        for (;;)
        {
          paramInt3 += i6;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, localView.getMeasuredHeight() + paramInt2);
          i2 = k + 1;
          paramInt3 = paramInt1;
          n = i;
          i1 = paramInt4;
          m += 1;
          k = i2;
          paramInt4 = i1;
          paramInt2 = j;
          i = n;
          paramInt1 = paramInt3;
          break;
          paramInt3 = paramInt2;
          j = paramInt2 + localView.getMeasuredWidth();
          break label254;
          paramInt3 = Math.max((i5 - localView.getMeasuredWidth()) / 2, paramInt2);
          j = paramInt2;
          break label254;
          paramInt3 = i5 - i - localView.getMeasuredWidth();
          i += localView.getMeasuredWidth();
          j = paramInt2;
          break label254;
          paramInt2 = paramInt1;
          paramInt1 += localView.getMeasuredHeight();
          continue;
          paramInt2 = Math.max((i4 - localView.getMeasuredHeight()) / 2, paramInt1);
          continue;
          paramInt2 = i4 - paramInt4 - localView.getMeasuredHeight();
          paramInt4 += localView.getMeasuredHeight();
        }
      }
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            j = paramInt2 + (int)(i * localItemInfo.offset);
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(i * localLayoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(j, paramInt1, localView.getMeasuredWidth() + j, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.mGutterSize = Math.min(paramInt1 / 10, this.mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i5 = getChildCount();
    int k = 0;
    int i;
    if (k >= i5)
    {
      this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      this.mInLayout = true;
      populate();
      this.mInLayout = false;
      i = getChildCount();
      paramInt2 = 0;
    }
    for (;;)
    {
      LayoutParams localLayoutParams;
      if (paramInt2 >= i)
      {
        return;
        localView = getChildAt(k);
        i = paramInt2;
        int j = paramInt1;
        int m;
        int i1;
        label228:
        int n;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i = paramInt2;
          j = paramInt1;
          if (localLayoutParams != null)
          {
            i = paramInt2;
            j = paramInt1;
            if (localLayoutParams.isDecor)
            {
              j = localLayoutParams.gravity & 0x7;
              m = localLayoutParams.gravity & 0x70;
              i1 = Integer.MIN_VALUE;
              i = Integer.MIN_VALUE;
              if ((m == 48) || (m == 80)) {
                break label399;
              }
              m = 0;
              if ((j == 3) || (j == 5)) {
                break label405;
              }
              n = 0;
              label243:
              if (m == 0) {
                break label411;
              }
              j = 1073741824;
              label253:
              int i3 = paramInt1;
              i1 = paramInt2;
              int i2 = i3;
              int i4;
              if (localLayoutParams.width != -2)
              {
                i4 = 1073741824;
                j = i4;
                i2 = i3;
                if (localLayoutParams.width != -1)
                {
                  i2 = localLayoutParams.width;
                  j = i4;
                }
              }
              i3 = i1;
              if (localLayoutParams.height != -2)
              {
                i4 = 1073741824;
                i = i4;
                i3 = i1;
                if (localLayoutParams.height != -1)
                {
                  i3 = localLayoutParams.height;
                  i = i4;
                }
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(i2, j), View.MeasureSpec.makeMeasureSpec(i3, i));
              if (m == 0) {
                break label431;
              }
              i = paramInt2 - localView.getMeasuredHeight();
              j = paramInt1;
            }
          }
        }
        for (;;)
        {
          k += 1;
          paramInt2 = i;
          paramInt1 = j;
          break;
          label399:
          m = 1;
          break label228;
          label405:
          n = 1;
          break label243;
          label411:
          j = i1;
          if (n == 0) {
            break label253;
          }
          i = 1073741824;
          j = i1;
          break label253;
          label431:
          i = paramInt2;
          j = paramInt1;
          if (n != 0)
          {
            j = paramInt1 - localView.getMeasuredWidth();
            i = paramInt2;
          }
        }
      }
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    int i;
    int k;
    int i2;
    int i3;
    int m;
    if (this.mDecorChildCount > 0)
    {
      i1 = getScrollX();
      i = getPaddingLeft();
      k = getPaddingRight();
      i2 = getWidth();
      i3 = getChildCount();
      m = 0;
    }
    LayoutParams localLayoutParams;
    int j;
    int n;
    for (;;)
    {
      if (m >= i3)
      {
        if (this.mOnPageChangeListener != null) {
          this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        if (this.mInternalPageChangeListener != null) {
          this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        if (this.mPageTransformer != null)
        {
          paramInt2 = getScrollX();
          i = getChildCount();
          paramInt1 = 0;
          if (paramInt1 < i) {
            break label323;
          }
        }
        this.mCalledSuper = true;
        return;
      }
      localView = getChildAt(m);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isDecor) {
        break;
      }
      j = k;
      n = i;
      m += 1;
      i = n;
      k = j;
    }
    switch (localLayoutParams.gravity & 0x7)
    {
    case 2: 
    case 4: 
    default: 
      j = i;
    }
    for (;;)
    {
      int i4 = j + i1 - localView.getLeft();
      n = i;
      j = k;
      if (i4 == 0) {
        break;
      }
      localView.offsetLeftAndRight(i4);
      n = i;
      j = k;
      break;
      j = i;
      i += localView.getWidth();
      continue;
      j = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
      continue;
      j = i2 - k - localView.getMeasuredWidth();
      k += localView.getMeasuredWidth();
    }
    label323:
    View localView = getChildAt(paramInt1);
    if (((LayoutParams)localView.getLayoutParams()).isDecor) {}
    for (;;)
    {
      paramInt1 += 1;
      break;
      paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
      this.mPageTransformer.transformPage(localView, paramFloat);
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = getChildCount();
    int i;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      i = 0;
      k = 1;
    }
    for (;;)
    {
      if (i == j)
      {
        return false;
        i = j - 1;
        k = -1;
        j = -1;
      }
      else
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
            return true;
          }
        }
        i += k;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    if (this.mAdapter != null) {
      localSavedState.adapterState = this.mAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mFakeDragging) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0)) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    int m = 0;
    int i = m;
    switch (n & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
      this.mScroller.abortAnimation();
      this.mPopulatePending = false;
      populate();
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = m;
      continue;
      float f2;
      if (!this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        f1 = MotionEventCompat.getX(paramMotionEvent, i);
        float f3 = Math.abs(f1 - this.mLastMotionX);
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        float f4 = Math.abs(f2 - this.mLastMotionY);
        if ((f3 > this.mTouchSlop) && (f3 > f4))
        {
          this.mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          if (f1 - this.mInitialMotionX <= 0.0F) {
            break label382;
          }
        }
      }
      Object localObject;
      label382:
      for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
      {
        this.mLastMotionX = f1;
        this.mLastMotionY = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i = m;
        if (!this.mIsBeingDragged) {
          break;
        }
        bool1 = false | performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)));
        break;
      }
      boolean bool1 = m;
      if (this.mIsBeingDragged)
      {
        localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int j = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        m = getClientWidth();
        n = getScrollX();
        localObject = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(((ItemInfo)localObject).position, (n / m - ((ItemInfo)localObject).offset) / ((ItemInfo)localObject).widthFactor, j, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, j);
        this.mActivePointerId = -1;
        endDrag();
        boolean bool2 = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
        continue;
        bool2 = m;
        if (this.mIsBeingDragged)
        {
          scrollToItem(this.mCurItem, true, 0, false);
          this.mActivePointerId = -1;
          endDrag();
          bool2 = this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
          continue;
          int k = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, k);
          this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, k);
          k = m;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
          this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
          k = m;
        }
      }
    }
  }
  
  boolean pageLeft()
  {
    if (this.mCurItem > 0)
    {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    }
    return false;
  }
  
  boolean pageRight()
  {
    if ((this.mAdapter != null) && (this.mCurItem < this.mAdapter.getCount() - 1))
    {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  void populate()
  {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt)
  {
    Object localObject2 = null;
    int j = 2;
    int i;
    if (this.mCurItem != paramInt)
    {
      if (this.mCurItem < paramInt)
      {
        i = 66;
        localObject2 = infoForPosition(this.mCurItem);
        this.mCurItem = paramInt;
        j = i;
      }
    }
    else
    {
      if (this.mAdapter != null) {
        break label64;
      }
      sortChildDrawingOrder();
    }
    label64:
    label252:
    label263:
    label324:
    label337:
    label357:
    label403:
    label410:
    label429:
    label462:
    label487:
    label597:
    label650:
    label656:
    label677:
    label823:
    label947:
    label953:
    label968:
    label1101:
    label1232:
    label1238:
    label1319:
    label1323:
    for (;;)
    {
      return;
      i = 17;
      break;
      if (this.mPopulatePending)
      {
        sortChildDrawingOrder();
        return;
      }
      if (getWindowToken() != null)
      {
        this.mAdapter.startUpdate(this);
        paramInt = this.mOffscreenPageLimit;
        int i3 = Math.max(0, this.mCurItem - paramInt);
        int i1 = this.mAdapter.getCount();
        int i2 = Math.min(i1 - 1, this.mCurItem + paramInt);
        if (i1 != this.mExpectedAdapterCount) {
          try
          {
            String str = getResources().getResourceName(getId());
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            for (;;)
            {
              localObject1 = Integer.toHexString(getId());
            }
          }
        }
        Object localObject1 = null;
        paramInt = 0;
        Object localObject3;
        float f3;
        int n;
        int i4;
        float f2;
        int m;
        Object localObject4;
        int k;
        if (paramInt >= this.mItems.size())
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (i1 > 0) {
              localObject3 = addNewItem(this.mCurItem, paramInt);
            }
          }
          if (localObject3 != null)
          {
            f3 = 0.0F;
            n = paramInt - 1;
            if (n < 0) {
              break label650;
            }
            localObject1 = (ItemInfo)this.mItems.get(n);
            i4 = getClientWidth();
            if (i4 > 0) {
              break label656;
            }
            f2 = 0.0F;
            m = this.mCurItem - 1;
            localObject4 = localObject1;
            k = paramInt;
            if (m >= 0) {
              break label677;
            }
            f3 = ((ItemInfo)localObject3).widthFactor;
            m = k + 1;
            if (f3 < 2.0F)
            {
              if (m >= this.mItems.size()) {
                break label947;
              }
              localObject1 = (ItemInfo)this.mItems.get(m);
              if (i4 > 0) {
                break label953;
              }
              f2 = 0.0F;
              i = this.mCurItem + 1;
              localObject4 = localObject1;
              if (i < i1) {
                break label968;
              }
            }
            calculatePageOffsets((ItemInfo)localObject3, k, (ItemInfo)localObject2);
          }
          localObject2 = this.mAdapter;
          paramInt = this.mCurItem;
          if (localObject3 == null) {
            break label1232;
          }
          localObject1 = ((ItemInfo)localObject3).object;
          ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
          this.mAdapter.finishUpdate(this);
          i = getChildCount();
          paramInt = 0;
          if (paramInt < i) {
            break label1238;
          }
          sortChildDrawingOrder();
          if (!hasFocus()) {
            continue;
          }
          localObject1 = findFocus();
          if (localObject1 == null) {
            break label1319;
          }
        }
        for (localObject1 = infoForAnyChild((View)localObject1);; localObject1 = null)
        {
          if ((localObject1 != null) && (((ItemInfo)localObject1).position == this.mCurItem)) {
            break label1323;
          }
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= getChildCount()) {
              break label597;
            }
            localObject1 = getChildAt(paramInt);
            localObject2 = infoForChild((View)localObject1);
            if ((localObject2 != null) && (((ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(j))) {
              break;
            }
            paramInt += 1;
          }
          break;
          localObject3 = (ItemInfo)this.mItems.get(paramInt);
          if (((ItemInfo)localObject3).position >= this.mCurItem)
          {
            if (((ItemInfo)localObject3).position != this.mCurItem) {
              break label263;
            }
            localObject1 = localObject3;
            break label263;
          }
          paramInt += 1;
          break label252;
          localObject1 = null;
          break label324;
          f2 = 2.0F - ((ItemInfo)localObject3).widthFactor + getPaddingLeft() / i4;
          break label337;
          if ((f3 >= f2) && (m < i3))
          {
            if (localObject4 == null) {
              break label357;
            }
            paramInt = k;
            f1 = f3;
            localObject1 = localObject4;
            i = n;
            if (m == ((ItemInfo)localObject4).position)
            {
              paramInt = k;
              f1 = f3;
              localObject1 = localObject4;
              i = n;
              if (!((ItemInfo)localObject4).scrolling)
              {
                this.mItems.remove(n);
                this.mAdapter.destroyItem(this, m, ((ItemInfo)localObject4).object);
                i = n - 1;
                paramInt = k - 1;
                if (i < 0) {
                  break label823;
                }
                localObject1 = (ItemInfo)this.mItems.get(i);
              }
            }
            for (f1 = f3;; f1 = f3)
            {
              m -= 1;
              k = paramInt;
              f3 = f1;
              localObject4 = localObject1;
              n = i;
              break;
              localObject1 = null;
            }
          }
          if ((localObject4 != null) && (m == ((ItemInfo)localObject4).position))
          {
            f1 = f3 + ((ItemInfo)localObject4).widthFactor;
            i = n - 1;
            if (i >= 0) {}
            for (localObject1 = (ItemInfo)this.mItems.get(i);; localObject1 = null)
            {
              paramInt = k;
              break;
            }
          }
          float f1 = f3 + addNewItem(m, n + 1).widthFactor;
          paramInt = k + 1;
          if (n >= 0) {}
          for (localObject1 = (ItemInfo)this.mItems.get(n);; localObject1 = null)
          {
            i = n;
            break;
          }
          localObject1 = null;
          break label403;
          f2 = getPaddingRight() / i4 + 2.0F;
          break label410;
          if ((f3 >= f2) && (i > i2))
          {
            if (localObject4 == null) {
              break label429;
            }
            f1 = f3;
            localObject1 = localObject4;
            paramInt = m;
            if (i == ((ItemInfo)localObject4).position)
            {
              f1 = f3;
              localObject1 = localObject4;
              paramInt = m;
              if (!((ItemInfo)localObject4).scrolling)
              {
                this.mItems.remove(m);
                this.mAdapter.destroyItem(this, i, ((ItemInfo)localObject4).object);
                if (m >= this.mItems.size()) {
                  break label1101;
                }
                localObject1 = (ItemInfo)this.mItems.get(m);
                paramInt = m;
                f1 = f3;
              }
            }
            for (;;)
            {
              i += 1;
              f3 = f1;
              localObject4 = localObject1;
              m = paramInt;
              break;
              localObject1 = null;
              f1 = f3;
              paramInt = m;
            }
          }
          if ((localObject4 != null) && (i == ((ItemInfo)localObject4).position))
          {
            f1 = f3 + ((ItemInfo)localObject4).widthFactor;
            paramInt = m + 1;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null) {
              break;
            }
          }
          localObject1 = addNewItem(i, m);
          paramInt = m + 1;
          f1 = f3 + ((ItemInfo)localObject1).widthFactor;
          if (paramInt < this.mItems.size()) {}
          for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null) {
            break;
          }
          localObject1 = null;
          break label462;
          localObject2 = getChildAt(paramInt);
          localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
          ((LayoutParams)localObject1).childIndex = paramInt;
          if ((!((LayoutParams)localObject1).isDecor) && (((LayoutParams)localObject1).widthFactor == 0.0F))
          {
            localObject2 = infoForChild((View)localObject2);
            if (localObject2 != null)
            {
              ((LayoutParams)localObject1).widthFactor = ((ItemInfo)localObject2).widthFactor;
              ((LayoutParams)localObject1).position = ((ItemInfo)localObject2).position;
            }
          }
          paramInt += 1;
          break label487;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    int i;
    Object localObject;
    boolean bool;
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      i = 0;
      if (i >= this.mItems.size())
      {
        this.mAdapter.finishUpdate(this);
        this.mItems.clear();
        removeNonDecorViews();
        this.mCurItem = 0;
        scrollTo(0, 0);
      }
    }
    else
    {
      localObject = this.mAdapter;
      this.mAdapter = paramPagerAdapter;
      this.mExpectedAdapterCount = 0;
      if (this.mAdapter != null)
      {
        if (this.mObserver == null) {
          this.mObserver = new PagerObserver(null);
        }
        this.mAdapter.registerDataSetObserver(this.mObserver);
        this.mPopulatePending = false;
        bool = this.mFirstLayout;
        this.mFirstLayout = true;
        this.mExpectedAdapterCount = this.mAdapter.getCount();
        if (this.mRestoredCurItem < 0) {
          break label260;
        }
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      }
    }
    for (;;)
    {
      if ((this.mAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
        this.mAdapterChangeListener.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      localObject = (ItemInfo)this.mItems.get(i);
      this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
      i += 1;
      break;
      label260:
      if (!bool) {
        populate();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.mSetChildrenDrawingOrderEnabled == null)) {}
    try
    {
      this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    if (this.mFirstLayout) {}
    for (boolean bool = false;; bool = true)
    {
      setCurrentItemInternal(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = true;
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.mCurItem == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0)
    {
      i = 0;
      paramInt1 = this.mOffscreenPageLimit;
      if ((i > this.mCurItem + paramInt1) || (i < this.mCurItem - paramInt1))
      {
        paramInt1 = 0;
        label90:
        if (paramInt1 < this.mItems.size()) {
          break label203;
        }
      }
      if (this.mCurItem == i) {
        break label225;
      }
    }
    label203:
    label225:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      if (!this.mFirstLayout) {
        break label230;
      }
      this.mCurItem = i;
      if ((paramBoolean2) && (this.mOnPageChangeListener != null)) {
        this.mOnPageChangeListener.onPageSelected(i);
      }
      if ((paramBoolean2) && (this.mInternalPageChangeListener != null)) {
        this.mInternalPageChangeListener.onPageSelected(i);
      }
      requestLayout();
      return;
      i = paramInt1;
      if (paramInt1 < this.mAdapter.getCount()) {
        break;
      }
      i = this.mAdapter.getCount() - 1;
      break;
      ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
      paramInt1 += 1;
      break label90;
    }
    label230:
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    OnPageChangeListener localOnPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i = 1;
    }
    if (i != this.mOffscreenPageLimit)
    {
      this.mOffscreenPageLimit = i;
      populate();
    }
  }
  
  void setOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer)
  {
    int i = 1;
    boolean bool2;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label68;
      }
      bool2 = true;
      if (this.mPageTransformer == null) {
        break label74;
      }
      bool1 = true;
      label27:
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool2);
      if (!bool2) {
        break label79;
      }
      if (paramBoolean) {
        i = 2;
      }
    }
    label68:
    label74:
    label79:
    for (this.mDrawingOrder = i;; this.mDrawingOrder = 0)
    {
      if ((bool2 ^ bool1)) {
        populate();
      }
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label27;
    }
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, 1.0F * Math.abs(k) / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f1 + f2 * f3) / paramInt3)) * 4;; paramInt1 = (int)((1.0F + Math.abs(k) / (this.mPageMargin + f1 * f2)) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mMarginDrawable);
  }
  
  static abstract interface Decor {}
  
  static class ItemInfo
  {
    Object object;
    float offset;
    int position;
    boolean scrolling;
    float widthFactor;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  class MyAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    MyAccessibilityDelegate() {}
    
    private boolean canScroll()
    {
      return (ViewPager.this.mAdapter != null) && (ViewPager.this.mAdapter.getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramView = AccessibilityRecordCompat.obtain();
      paramView.setScrollable(canScroll());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.this.mAdapter != null))
      {
        paramView.setItemCount(ViewPager.this.mAdapter.getCount());
        paramView.setFromIndex(ViewPager.this.mCurItem);
        paramView.setToIndex(ViewPager.this.mCurItem);
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (ViewPager.this.canScrollHorizontally(1))
        {
          ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
          return true;
        }
        return false;
      }
      if (ViewPager.this.canScrollHorizontally(-1))
      {
        ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface OnAdapterChangeListener
  {
    public abstract void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface OnPageChangeListener
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface PageTransformer
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  private class PagerObserver
    extends DataSetObserver
  {
    private PagerObserver() {}
    
    public void onChanged()
    {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated()
    {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public ViewPager.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new ViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public ViewPager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ViewPager.SavedState[paramAnonymousInt];
      }
    });
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.adapterState = paramParcel.readParcelable(localClassLoader);
      this.loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.adapterState, paramInt);
    }
  }
  
  public static class SimpleOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  static class ViewPositionComparator
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
      if (paramView1.isDecor != paramView2.isDecor)
      {
        if (paramView1.isDecor) {
          return 1;
        }
        return -1;
      }
      return paramView1.position - paramView2.position;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */