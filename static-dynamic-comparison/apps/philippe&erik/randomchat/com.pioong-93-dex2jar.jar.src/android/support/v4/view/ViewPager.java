package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
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
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
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
  private long mFakeDragBeginTime;
  private boolean mFakeDragging;
  private boolean mFirstLayout = true;
  private float mFirstOffset = -3.4028235E38F;
  private int mFlingDistance;
  private int mGutterSize;
  private boolean mIgnoreGutter;
  private boolean mInLayout;
  private float mInitialMotionX;
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
  private int mSeenPositionMax;
  private int mSeenPositionMin;
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
    int i = getWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.mPageMargin / i;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i = paramItemInfo2.position;
      if (i < paramItemInfo1.position)
      {
        j = 0;
        f1 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f2;
        i += 1;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramItemInfo1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramItemInfo2 = (ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ItemInfo)this.mItems.get(j))
        {
          f3 = f1;
          k = i;
          if (i <= paramItemInfo2.position) {
            break;
          }
          f3 = f1;
          k = i;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramItemInfo2.position)
        {
          f3 += this.mAdapter.getPageWidth(k) + f2;
          k += 1;
        }
        paramItemInfo2.offset = f3;
        f1 = f3 + (paramItemInfo2.widthFactor + f2);
        i = k + 1;
      }
    }
    if (i > paramItemInfo1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramItemInfo2.offset;
      i -= 1;
      while ((i >= paramItemInfo1.position) && (j >= 0))
      {
        for (paramItemInfo2 = (ItemInfo)this.mItems.get(j);; paramItemInfo2 = (ItemInfo)this.mItems.get(j))
        {
          f3 = f1;
          k = i;
          if (i >= paramItemInfo2.position) {
            break;
          }
          f3 = f1;
          k = i;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramItemInfo2.position)
        {
          f3 -= this.mAdapter.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramItemInfo2.widthFactor + f2);
        paramItemInfo2.offset = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    i = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0)
    {
      f1 = paramItemInfo1.offset;
      this.mFirstOffset = f1;
      if (paramItemInfo1.position != m - 1) {
        break label550;
      }
      f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
      label475:
      this.mLastOffset = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramItemInfo2 = (ItemInfo)this.mItems.get(j);
      for (;;)
      {
        if (i > paramItemInfo2.position)
        {
          f1 -= this.mAdapter.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= paramItemInfo2.widthFactor + f2;
      paramItemInfo2.offset = f1;
      if (paramItemInfo2.position == 0) {
        this.mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    label603:
    float f1 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f2;
    i = paramItemInfo1.position + 1;
    int j = paramInt + 1;
    paramInt = i;
    i = j;
    while (i < k)
    {
      paramItemInfo1 = (ItemInfo)this.mItems.get(i);
      while (paramInt < paramItemInfo1.position)
      {
        f1 += this.mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.position == m - 1) {
        this.mLastOffset = (paramItemInfo1.widthFactor + f1 - 1.0F);
      }
      paramItemInfo1.offset = f1;
      f1 += paramItemInfo1.widthFactor + f2;
      i += 1;
      paramInt += 1;
    }
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (this.mScrollState == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
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
      while (i < this.mItems.size())
      {
        ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
        if (localItemInfo.scrolling)
        {
          j = 1;
          localItemInfo.scrolling = false;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      }
    }
    else {
      return;
    }
    this.mEndScrollRunnable.run();
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.mFlingDistance) && (Math.abs(paramInt2) > this.mMinimumVelocity)) {
      if (paramInt2 <= 0) {}
    }
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
      continue;
      if ((this.mSeenPositionMin >= 0) && (this.mSeenPositionMin < paramInt1) && (paramFloat < 0.5F)) {
        paramInt1 += 1;
      } else if ((this.mSeenPositionMax >= 0) && (this.mSeenPositionMax > paramInt1 + 1) && (paramFloat >= 0.5F)) {
        paramInt1 -= 1;
      } else {
        paramInt1 = (int)(paramInt1 + paramFloat + 0.5F);
      }
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        ViewCompat.setLayerType(getChildAt(i), j, null);
        i += 1;
        break;
      }
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
  
  private ItemInfo infoForCurrentScrollPosition()
  {
    float f2 = 0.0F;
    int i = getWidth();
    float f1;
    int k;
    float f3;
    float f4;
    int j;
    Object localObject2;
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
      localObject2 = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject3 = localObject2;
      int m;
      Object localObject1;
      if (i < this.mItems.size())
      {
        localObject3 = (ItemInfo)this.mItems.get(i);
        m = i;
        localObject1 = localObject3;
        if (j == 0)
        {
          m = i;
          localObject1 = localObject3;
          if (((ItemInfo)localObject3).position != k + 1)
          {
            localObject1 = this.mTempItem;
            ((ItemInfo)localObject1).offset = (f3 + f4 + f2);
            ((ItemInfo)localObject1).position = (k + 1);
            ((ItemInfo)localObject1).widthFactor = this.mAdapter.getPageWidth(((ItemInfo)localObject1).position);
            m = i - 1;
          }
        }
        f3 = ((ItemInfo)localObject1).offset;
        f4 = ((ItemInfo)localObject1).widthFactor;
        if (j == 0)
        {
          localObject3 = localObject2;
          if (f1 < f3) {}
        }
        else
        {
          if ((f1 >= f4 + f3 + f2) && (m != this.mItems.size() - 1)) {
            break label232;
          }
          localObject3 = localObject1;
        }
      }
      return (ItemInfo)localObject3;
      f1 = 0.0F;
      break;
      label232:
      j = 0;
      k = ((ItemInfo)localObject1).position;
      f4 = ((ItemInfo)localObject1).widthFactor;
      i = m + 1;
      localObject2 = localObject1;
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
      int j = getWidth();
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
    int k = getWidth();
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
      f = getScrollX() / (paramInt2 + paramInt4);
      paramInt2 = (int)((paramInt1 + paramInt3) * f);
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
      paramInt1 = (int)(paramInt1 * f);
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
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ItemInfo localItemInfo = infoForPosition(paramInt1);
    int i = 0;
    if (localItemInfo != null) {
      i = (int)(getWidth() * Math.max(this.mFirstOffset, Math.min(localItemInfo.offset, this.mLastOffset)));
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
  }
  
  private void setScrollState(int paramInt)
  {
    boolean bool = true;
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt == 1)
    {
      this.mSeenPositionMax = -1;
      this.mSeenPositionMin = -1;
    }
    if (this.mPageTransformer != null) {
      if (paramInt == 0) {
        break label65;
      }
    }
    for (;;)
    {
      enableLayers(bool);
      if (this.mOnPageChangeListener == null) {
        break;
      }
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
      return;
      label65:
      bool = false;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
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
    while (i < getChildCount())
    {
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
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    boolean bool = false;
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i;
    int j;
    if ((localView2 != null) && (localView2 != localView1)) {
      if (paramInt == 17)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView2).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, localView1).left;
        if ((localView1 != null) && (i >= j)) {
          bool = pageLeft();
        }
      }
    }
    for (;;)
    {
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
      bool = localView2.requestFocus();
      continue;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinates(this.mTempRect, localView2).left;
        j = getChildRectInPagerCoordinates(this.mTempRect, localView1).left;
        if ((localView1 != null) && (i <= j))
        {
          bool = pageRight();
        }
        else
        {
          bool = localView2.requestFocus();
          continue;
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
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
          return true;
        }
        i -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1));
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
    int i;
    int j;
    int k;
    int m;
    label47:
    Object localObject;
    int i3;
    int n;
    int i1;
    int i2;
    if ((this.mItems.size() < this.mOffscreenPageLimit * 2 + 1) && (this.mItems.size() < this.mAdapter.getCount()))
    {
      i = 1;
      j = this.mCurItem;
      k = 0;
      m = 0;
      if (m >= this.mItems.size()) {
        break label299;
      }
      localObject = (ItemInfo)this.mItems.get(m);
      i3 = this.mAdapter.getItemPosition(((ItemInfo)localObject).object);
      if (i3 != -1) {
        break label123;
      }
      n = j;
      i1 = k;
      i2 = m;
    }
    for (;;)
    {
      m = i2 + 1;
      k = i1;
      j = n;
      break label47;
      i = 0;
      break;
      label123:
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
          n = Math.max(0, Math.min(this.mCurItem, this.mAdapter.getCount() - 1));
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
    label299:
    if (k != 0) {
      this.mAdapter.finishUpdate(this);
    }
    Collections.sort(this.mItems, COMPARATOR);
    if (i != 0)
    {
      k = getChildCount();
      i = 0;
      while (i < k)
      {
        localObject = (LayoutParams)getChildAt(i).getLayoutParams();
        if (!((LayoutParams)localObject).isDecor) {
          ((LayoutParams)localObject).widthFactor = 0.0F;
        }
        i += 1;
      }
      setCurrentItemInternal(j, false, true);
      requestLayout();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
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
    return false;
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
    int j = getWidth();
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
    int i = getWidth();
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
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return infoForChild(paramView);
  }
  
  ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItems.get(i);
      if (localItemInfo.position == paramInt) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(localContext);
    this.mRightEdge = new EdgeEffectCompat(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
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
    float f1;
    int n;
    int i;
    int i1;
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
      i1 = ((ItemInfo)this.mItems.get(n - 1)).position;
    }
    for (;;)
    {
      float f2;
      if (i < i1)
      {
        while ((i > ((ItemInfo)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (ItemInfo)((ArrayList)localObject).get(j);
        }
        if (i != ((ItemInfo)localObject).position) {
          break label271;
        }
        f2 = (((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor) * m;
      }
      label271:
      float f4;
      for (f1 = ((ItemInfo)localObject).offset + ((ItemInfo)localObject).widthFactor + f3;; f1 += f4 + f3)
      {
        if (this.mPageMargin + f2 > k)
        {
          this.mMarginDrawable.setBounds((int)f2, this.mTopPageBounds, (int)(this.mPageMargin + f2 + 0.5F), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        }
        if (f2 <= k + m) {
          break;
        }
        return;
        f4 = this.mAdapter.getPageWidth(i);
        f2 = (f1 + f4) * m;
      }
      i += 1;
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
        float f3 = Math.abs(f1);
        float f4 = MotionEventCompat.getY(paramMotionEvent, i);
        float f5 = Math.abs(f4 - this.mLastMotionY);
        if ((f1 != 0.0F) && (!isGutterDrag(this.mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f4)))
        {
          this.mLastMotionX = f2;
          this.mInitialMotionX = f2;
          this.mLastMotionY = f4;
          this.mIsUnableToDrag = true;
          return false;
        }
        if ((f3 > this.mTouchSlop) && (f3 > f5))
        {
          this.mIsBeingDragged = true;
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.mInitialMotionX + this.mTouchSlop;
            label306:
            this.mLastMotionX = f1;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.mIsBeingDragged) && (performDrag(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.mInitialMotionX - this.mTouchSlop;
          break label306;
          if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mInitialMotionX = f1;
        this.mLastMotionX = f1;
        this.mLastMotionY = paramMotionEvent.getY();
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.mIsUnableToDrag = false;
        this.mScroller.computeScrollOffset();
        if ((this.mScrollState == 2) && (Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough))
        {
          this.mScroller.abortAnimation();
          this.mPopulatePending = false;
          populate();
          this.mIsBeingDragged = true;
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
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    int i3 = getChildCount();
    int i4 = paramInt3 - paramInt1;
    int i5 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    int j;
    LayoutParams localLayoutParams;
    if (m < i3)
    {
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
            label206:
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
        break label206;
        paramInt3 = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
        j = paramInt2;
        break label206;
        paramInt3 = i4 - i - localView.getMeasuredWidth();
        i += localView.getMeasuredWidth();
        j = paramInt2;
        break label206;
        paramInt2 = paramInt1;
        paramInt1 += localView.getMeasuredHeight();
        continue;
        paramInt2 = Math.max((i5 - localView.getMeasuredHeight()) / 2, paramInt1);
        continue;
        paramInt2 = i5 - paramInt4 - localView.getMeasuredHeight();
        paramInt4 += localView.getMeasuredHeight();
      }
    }
    paramInt3 = 0;
    while (paramInt3 < i3)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.isDecor)
        {
          ItemInfo localItemInfo = infoForChild(localView);
          if (localItemInfo != null)
          {
            j = paramInt2 + (int)(i4 * localItemInfo.offset);
            if (localLayoutParams.needsMeasure)
            {
              localLayoutParams.needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)((i4 - paramInt2 - i) * localLayoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(j, paramInt1, localView.getMeasuredWidth() + j, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = (i5 - paramInt4);
    this.mDecorChildCount = k;
    this.mFirstLayout = false;
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
    View localView;
    LayoutParams localLayoutParams;
    if (k < i5)
    {
      localView = getChildAt(k);
      i = paramInt2;
      int j = paramInt1;
      int m;
      int i1;
      label179:
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
            if ((m != 48) && (m != 80)) {
              break label350;
            }
            m = 1;
            if ((j != 3) && (j != 5)) {
              break label356;
            }
            n = 1;
            label194:
            if (m == 0) {
              break label362;
            }
            j = 1073741824;
            label204:
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
              break label382;
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
        label350:
        m = 0;
        break label179;
        label356:
        n = 0;
        break label194;
        label362:
        j = i1;
        if (n == 0) {
          break label204;
        }
        i = 1073741824;
        j = i1;
        break label204;
        label382:
        i = paramInt2;
        j = paramInt1;
        if (n != 0)
        {
          j = paramInt1 - localView.getMeasuredWidth();
          i = paramInt2;
        }
      }
    }
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    int i = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localView = getChildAt(paramInt2);
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
    int i;
    View localView;
    if (this.mDecorChildCount > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      int k = getPaddingRight();
      int i2 = getWidth();
      int i3 = getChildCount();
      int m = 0;
      while (m < i3)
      {
        localView = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int j;
        int n;
        if (!localLayoutParams.isDecor)
        {
          j = k;
          n = i;
          m += 1;
          i = n;
          k = j;
        }
        else
        {
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
        }
      }
    }
    if ((this.mSeenPositionMin < 0) || (paramInt1 < this.mSeenPositionMin)) {
      this.mSeenPositionMin = paramInt1;
    }
    if ((this.mSeenPositionMax < 0) || (FloatMath.ceil(paramInt1 + paramFloat) > this.mSeenPositionMax)) {
      this.mSeenPositionMax = (paramInt1 + 1);
    }
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
      if (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (((LayoutParams)localView.getLayoutParams()).isDecor) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / getWidth();
          this.mPageTransformer.transformPage(localView, paramFloat);
        }
      }
    }
    this.mCalledSuper = true;
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
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ItemInfo localItemInfo = infoForChild(localView);
        if ((localItemInfo != null) && (localItemInfo.position == this.mCurItem) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          k = -1;
          j = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
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
      this.mIsBeingDragged = true;
      setScrollState(1);
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = m;
      continue;
      if (!this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        f1 = MotionEventCompat.getX(paramMotionEvent, i);
        float f2 = Math.abs(f1 - this.mLastMotionX);
        float f3 = Math.abs(MotionEventCompat.getY(paramMotionEvent, i) - this.mLastMotionY);
        if ((f2 > this.mTouchSlop) && (f2 > f3))
        {
          this.mIsBeingDragged = true;
          if (f1 - this.mInitialMotionX <= 0.0F) {
            break label343;
          }
        }
      }
      label343:
      for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
      {
        this.mLastMotionX = f1;
        setScrollState(1);
        setScrollingCacheEnabled(true);
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
        Object localObject = this.mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
        int j = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.mActivePointerId);
        this.mPopulatePending = true;
        m = getWidth();
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
    if (this.mCurItem != paramInt)
    {
      localObject2 = infoForPosition(this.mCurItem);
      this.mCurItem = paramInt;
    }
    if (this.mAdapter == null) {
      break label33;
    }
    label33:
    label222:
    label314:
    label384:
    label410:
    label547:
    label560:
    label683:
    label691:
    label804:
    label810:
    label920:
    label931:
    label1048:
    label1054:
    label1059:
    label1182:
    label1188:
    for (;;)
    {
      return;
      if ((!this.mPopulatePending) && (getWindowToken() != null))
      {
        this.mAdapter.startUpdate(this);
        paramInt = this.mOffscreenPageLimit;
        int i2 = Math.max(0, this.mCurItem - paramInt);
        int n = this.mAdapter.getCount();
        int i1 = Math.min(n - 1, this.mCurItem + paramInt);
        Object localObject3 = null;
        paramInt = 0;
        Object localObject1 = localObject3;
        Object localObject4;
        if (paramInt < this.mItems.size())
        {
          localObject4 = (ItemInfo)this.mItems.get(paramInt);
          if (((ItemInfo)localObject4).position < this.mCurItem) {
            break label547;
          }
          localObject1 = localObject3;
          if (((ItemInfo)localObject4).position == this.mCurItem) {
            localObject1 = localObject4;
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject1;
          if (n > 0) {
            localObject3 = addNewItem(this.mCurItem, paramInt);
          }
        }
        float f2;
        int m;
        int k;
        int j;
        int i;
        if (localObject3 != null)
        {
          f2 = 0.0F;
          m = paramInt - 1;
          if (m >= 0)
          {
            localObject1 = (ItemInfo)this.mItems.get(m);
            float f3 = ((ItemInfo)localObject3).widthFactor;
            k = this.mCurItem - 1;
            localObject4 = localObject1;
            j = paramInt;
            if (k >= 0)
            {
              if ((f2 < 2.0F - f3) || (k >= i2)) {
                break label691;
              }
              if (localObject4 != null) {
                break label560;
              }
            }
            f2 = ((ItemInfo)localObject3).widthFactor;
            k = j + 1;
            if (f2 < 2.0F)
            {
              if (k >= this.mItems.size()) {
                break label804;
              }
              localObject1 = (ItemInfo)this.mItems.get(k);
              i = this.mCurItem + 1;
              localObject4 = localObject1;
              if (i < n)
              {
                if ((f2 < 2.0F) || (i <= i1)) {
                  break label931;
                }
                if (localObject4 != null) {
                  break label810;
                }
              }
            }
            calculatePageOffsets((ItemInfo)localObject3, j, (ItemInfo)localObject2);
          }
        }
        else
        {
          localObject2 = this.mAdapter;
          paramInt = this.mCurItem;
          if (localObject3 == null) {
            break label1048;
          }
          localObject1 = ((ItemInfo)localObject3).object;
          ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
          this.mAdapter.finishUpdate(this);
          if (this.mDrawingOrder == 0) {
            break label1054;
          }
          paramInt = 1;
          if (paramInt != 0)
          {
            if (this.mDrawingOrderedChildren != null) {
              break label1059;
            }
            this.mDrawingOrderedChildren = new ArrayList();
          }
        }
        for (;;)
        {
          j = getChildCount();
          i = 0;
          while (i < j)
          {
            localObject1 = getChildAt(i);
            localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
            ((LayoutParams)localObject2).childIndex = i;
            if ((!((LayoutParams)localObject2).isDecor) && (((LayoutParams)localObject2).widthFactor == 0.0F))
            {
              localObject3 = infoForChild((View)localObject1);
              if (localObject3 != null)
              {
                ((LayoutParams)localObject2).widthFactor = ((ItemInfo)localObject3).widthFactor;
                ((LayoutParams)localObject2).position = ((ItemInfo)localObject3).position;
              }
            }
            if (paramInt != 0) {
              this.mDrawingOrderedChildren.add(localObject1);
            }
            i += 1;
          }
          paramInt += 1;
          break;
          localObject1 = null;
          break label222;
          paramInt = j;
          float f1 = f2;
          localObject1 = localObject4;
          i = m;
          if (k == ((ItemInfo)localObject4).position)
          {
            paramInt = j;
            f1 = f2;
            localObject1 = localObject4;
            i = m;
            if (!((ItemInfo)localObject4).scrolling)
            {
              this.mItems.remove(m);
              this.mAdapter.destroyItem(this, k, ((ItemInfo)localObject4).object);
              i = m - 1;
              paramInt = j - 1;
              if (i < 0) {
                break label683;
              }
              localObject1 = (ItemInfo)this.mItems.get(i);
            }
          }
          for (f1 = f2;; f1 = f2)
          {
            k -= 1;
            j = paramInt;
            f2 = f1;
            localObject4 = localObject1;
            m = i;
            break;
            localObject1 = null;
          }
          if ((localObject4 != null) && (k == ((ItemInfo)localObject4).position))
          {
            f1 = f2 + ((ItemInfo)localObject4).widthFactor;
            i = m - 1;
            if (i >= 0) {}
            for (localObject1 = (ItemInfo)this.mItems.get(i);; localObject1 = null)
            {
              paramInt = j;
              break;
            }
          }
          f1 = f2 + addNewItem(k, m + 1).widthFactor;
          paramInt = j + 1;
          if (m >= 0) {}
          for (localObject1 = (ItemInfo)this.mItems.get(m);; localObject1 = null)
          {
            i = m;
            break;
          }
          localObject1 = null;
          break label314;
          f1 = f2;
          localObject1 = localObject4;
          paramInt = k;
          if (i == ((ItemInfo)localObject4).position)
          {
            f1 = f2;
            localObject1 = localObject4;
            paramInt = k;
            if (!((ItemInfo)localObject4).scrolling)
            {
              this.mItems.remove(k);
              this.mAdapter.destroyItem(this, i, ((ItemInfo)localObject4).object);
              if (k >= this.mItems.size()) {
                break label920;
              }
              localObject1 = (ItemInfo)this.mItems.get(k);
              paramInt = k;
              f1 = f2;
            }
          }
          for (;;)
          {
            i += 1;
            f2 = f1;
            localObject4 = localObject1;
            k = paramInt;
            break;
            localObject1 = null;
            f1 = f2;
            paramInt = k;
          }
          if ((localObject4 != null) && (i == ((ItemInfo)localObject4).position))
          {
            f1 = f2 + ((ItemInfo)localObject4).widthFactor;
            paramInt = k + 1;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null) {
              break;
            }
          }
          localObject1 = addNewItem(i, k);
          paramInt = k + 1;
          f1 = f2 + ((ItemInfo)localObject1).widthFactor;
          if (paramInt < this.mItems.size()) {}
          for (localObject1 = (ItemInfo)this.mItems.get(paramInt);; localObject1 = null) {
            break;
          }
          localObject1 = null;
          break label384;
          paramInt = 0;
          break label410;
          this.mDrawingOrderedChildren.clear();
        }
        if (paramInt != 0) {
          Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
        if (!hasFocus()) {
          break;
        }
        localObject1 = findFocus();
        if (localObject1 != null) {}
        for (localObject1 = infoForAnyChild((View)localObject1);; localObject1 = null)
        {
          if ((localObject1 != null) && (((ItemInfo)localObject1).position == this.mCurItem)) {
            break label1188;
          }
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= getChildCount()) {
              break label1182;
            }
            localObject1 = getChildAt(paramInt);
            localObject2 = infoForChild((View)localObject1);
            if ((localObject2 != null) && (((ItemInfo)localObject2).position == this.mCurItem) && (((View)localObject1).requestFocus(2))) {
              break;
            }
            paramInt += 1;
          }
          break label33;
        }
      }
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
      this.mAdapter.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (ItemInfo)this.mItems.get(i);
        this.mAdapter.destroyItem(this, ((ItemInfo)localObject).position, ((ItemInfo)localObject).object);
        i += 1;
      }
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new PagerObserver(null);
      }
      this.mAdapter.registerDataSetObserver(this.mObserver);
      this.mPopulatePending = false;
      this.mFirstLayout = true;
      if (this.mRestoredCurItem < 0) {
        break label233;
      }
      this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
      setCurrentItemInternal(this.mRestoredCurItem, false, true);
      this.mRestoredCurItem = -1;
      this.mRestoredAdapterState = null;
      this.mRestoredClassLoader = null;
    }
    for (;;)
    {
      if ((this.mAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
        this.mAdapterChangeListener.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label233:
      populate();
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if (this.mSetChildrenDrawingOrderEnabled == null) {}
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
    if (!this.mFirstLayout) {}
    for (boolean bool = true;; bool = false)
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
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.mOffscreenPageLimit;
      if ((i <= this.mCurItem + paramInt1) && (i >= this.mCurItem - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount()) {
        i = this.mAdapter.getCount() - 1;
      }
    }
    if (this.mCurItem != i) {}
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      populate(i);
      scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
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
    int j = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label75;
      }
      bool1 = true;
      if (this.mPageTransformer == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i = 1;
      label37:
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        j = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.mDrawingOrder = j;; this.mDrawingOrder = 0)
    {
      if (i != 0) {
        populate();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i = 0;
      break label37;
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
    paramInt1 = getWidth();
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
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      boolean bool = true;
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mAdapter.getCount() > 1)) {}
      for (;;)
      {
        paramAccessibilityNodeInfoCompat.setScrollable(bool);
        if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mCurItem >= 0) && (ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount() - 1)) {
          paramAccessibilityNodeInfoCompat.addAction(4096);
        }
        if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mCurItem > 0) && (ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount())) {
          paramAccessibilityNodeInfoCompat.addAction(8192);
        }
        return;
        bool = false;
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
        if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mCurItem >= 0) && (ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount() - 1))
        {
          ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
          return true;
        }
        return false;
      }
      if ((ViewPager.this.mAdapter != null) && (ViewPager.this.mCurItem > 0) && (ViewPager.this.mCurItem < ViewPager.this.mAdapter.getCount()))
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */