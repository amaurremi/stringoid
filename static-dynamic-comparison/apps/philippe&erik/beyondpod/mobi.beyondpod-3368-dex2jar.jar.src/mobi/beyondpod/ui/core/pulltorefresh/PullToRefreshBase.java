package mobi.beyondpod.ui.core.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import mobi.beyondpod.R.styleable;
import mobi.beyondpod.ui.core.pulltorefresh.internal.LoadingLayout;

public abstract class PullToRefreshBase<T extends View>
  extends LinearLayout
{
  static final float FRICTION = 2.0F;
  static final int MANUAL_REFRESHING = 3;
  public static final int MODE_BOTH = 3;
  public static final int MODE_DISABLE_REFRESH = 0;
  public static final int MODE_PULL_DOWN_TO_REFRESH = 1;
  public static final int MODE_PULL_UP_TO_REFRESH = 2;
  static final int PULL_TO_REFRESH = 0;
  static final int REFRESHING = 2;
  static final int RELEASE_TO_REFRESH = 1;
  private int currentMode;
  private PullToRefreshBase<T>.SmoothScrollRunnable currentSmoothScrollRunnable;
  private boolean disableScrollingWhileRefreshing = true;
  private LoadingLayout footerLayout;
  private final Handler handler = new Handler();
  private int headerHeight;
  private LoadingLayout headerLayout;
  private float initialMotionY;
  private boolean isBeingDragged = false;
  private boolean isPullToRefreshEnabled = true;
  private float lastMotionX;
  private float lastMotionY;
  private int mode = 1;
  private OnRefreshListener onRefreshListener;
  T refreshableView;
  private int state = 0;
  private int touchSlop;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mode = paramInt;
    init(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(1);
    this.touchSlop = ViewConfiguration.getTouchSlop();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
    if (localTypedArray.hasValue(3)) {
      this.mode = localTypedArray.getInteger(3, 1);
    }
    this.refreshableView = createRefreshableView(paramContext, paramAttributeSet);
    addRefreshableView(paramContext, this.refreshableView);
    paramAttributeSet = paramContext.getString(2131297148);
    String str1 = paramContext.getString(2131297150);
    String str2 = paramContext.getString(2131297149);
    if ((this.mode == 1) || (this.mode == 3))
    {
      this.headerLayout = new LoadingLayout(paramContext, 1, str2, paramAttributeSet, str1);
      addView(this.headerLayout, 0, new LinearLayout.LayoutParams(-1, -2));
      measureView(this.headerLayout);
      this.headerHeight = this.headerLayout.getMeasuredHeight();
    }
    if ((this.mode == 2) || (this.mode == 3))
    {
      this.footerLayout = new LoadingLayout(paramContext, 2, str2, paramAttributeSet, str1);
      addView(this.footerLayout, new LinearLayout.LayoutParams(-1, -2));
      measureView(this.footerLayout);
      this.headerHeight = this.footerLayout.getMeasuredHeight();
    }
    if (localTypedArray.hasValue(2))
    {
      int i = localTypedArray.getColor(2, -16777216);
      if (this.headerLayout != null) {
        this.headerLayout.setTextColor(i);
      }
      if (this.footerLayout != null) {
        this.footerLayout.setTextColor(i);
      }
    }
    if (localTypedArray.hasValue(1)) {
      setBackgroundResource(localTypedArray.getResourceId(1, -1));
    }
    if (localTypedArray.hasValue(0)) {
      this.refreshableView.setBackgroundResource(localTypedArray.getResourceId(0, -1));
    }
    localTypedArray.recycle();
    switch (this.mode)
    {
    default: 
      setPadding(0, -this.headerHeight, 0, 0);
    }
    for (;;)
    {
      if (this.mode != 3) {
        this.currentMode = this.mode;
      }
      return;
      setPadding(0, -this.headerHeight, 0, -this.headerHeight);
      continue;
      setPadding(0, 0, 0, -this.headerHeight);
    }
  }
  
  private boolean isReadyForPull()
  {
    switch (this.mode)
    {
    }
    do
    {
      return false;
      return isReadyForPullDown();
      return isReadyForPullUp();
    } while ((!isReadyForPullUp()) && (!isReadyForPullDown()));
    return true;
  }
  
  private void measureView(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {}
    for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
  }
  
  private boolean pullEvent()
  {
    int j = getScrollY();
    int i;
    switch (this.currentMode)
    {
    default: 
      i = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0F) / 2.0F);
      setHeaderScroll(i);
      if (i != 0) {
        if ((this.state == 0) && (this.headerHeight < Math.abs(i)))
        {
          this.state = 1;
          switch (this.currentMode)
          {
          }
        }
      }
      break;
    }
    while (j != i)
    {
      return true;
      i = Math.round(Math.max(this.initialMotionY - this.lastMotionY, 0.0F) / 2.0F);
      break;
      this.footerLayout.releaseToRefresh();
      return true;
      this.headerLayout.releaseToRefresh();
      return true;
      if ((this.state == 1) && (this.headerHeight >= Math.abs(i)))
      {
        this.state = 0;
        switch (this.currentMode)
        {
        default: 
          return true;
        case 1: 
          this.headerLayout.pullToRefresh();
          return true;
        }
        this.footerLayout.pullToRefresh();
        return true;
      }
    }
    return false;
  }
  
  protected void addRefreshableView(Context paramContext, T paramT)
  {
    addView(paramT, new LinearLayout.LayoutParams(-1, 0, 1.0F));
  }
  
  protected abstract T createRefreshableView(Context paramContext, AttributeSet paramAttributeSet);
  
  public final T getAdapterView()
  {
    return this.refreshableView;
  }
  
  protected final int getCurrentMode()
  {
    return this.currentMode;
  }
  
  protected final LoadingLayout getFooterLayout()
  {
    return this.footerLayout;
  }
  
  protected final int getHeaderHeight()
  {
    return this.headerHeight;
  }
  
  protected final LoadingLayout getHeaderLayout()
  {
    return this.headerLayout;
  }
  
  protected final int getMode()
  {
    return this.mode;
  }
  
  public final T getRefreshableView()
  {
    return this.refreshableView;
  }
  
  public final boolean hasPullFromTop()
  {
    return this.currentMode != 2;
  }
  
  public final boolean isDisableScrollingWhileRefreshing()
  {
    return this.disableScrollingWhileRefreshing;
  }
  
  public final boolean isPullToRefreshEnabled()
  {
    return this.isPullToRefreshEnabled;
  }
  
  protected abstract boolean isReadyForPullDown();
  
  protected abstract boolean isReadyForPullUp();
  
  public final boolean isRefreshing()
  {
    return (this.state == 2) || (this.state == 3);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isPullToRefreshEnabled) {
      return false;
    }
    if ((isRefreshing()) && (this.disableScrollingWhileRefreshing)) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      this.isBeingDragged = false;
      return false;
    }
    if ((i != 0) && (this.isBeingDragged)) {
      return true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.isBeingDragged;
      if (isReadyForPull())
      {
        float f1 = paramMotionEvent.getY();
        float f2 = f1 - this.lastMotionY;
        float f3 = Math.abs(f2);
        float f4 = Math.abs(paramMotionEvent.getX() - this.lastMotionX);
        if ((f3 > this.touchSlop) && (f3 > f4)) {
          if (((this.mode == 1) || (this.mode == 3)) && (f2 >= 1.0E-4F) && (isReadyForPullDown()))
          {
            this.lastMotionY = f1;
            this.isBeingDragged = true;
            if (this.mode == 3) {
              this.currentMode = 1;
            }
          }
          else if (((this.mode == 2) || (this.mode == 3)) && (f2 <= 1.0E-4F) && (isReadyForPullUp()))
          {
            this.lastMotionY = f1;
            this.isBeingDragged = true;
            if (this.mode == 3)
            {
              this.currentMode = 2;
              continue;
              if (isReadyForPull())
              {
                f1 = paramMotionEvent.getY();
                this.initialMotionY = f1;
                this.lastMotionY = f1;
                this.lastMotionX = paramMotionEvent.getX();
                this.isBeingDragged = false;
              }
            }
          }
        }
      }
    }
  }
  
  public final void onRefreshComplete()
  {
    if (this.state != 0) {
      resetHeader();
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.isPullToRefreshEnabled) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((isRefreshing()) && (this.disableScrollingWhileRefreshing)) {
              return true;
            }
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!isReadyForPull());
        float f = paramMotionEvent.getY();
        this.initialMotionY = f;
        this.lastMotionY = f;
        return true;
      } while (!this.isBeingDragged);
      this.lastMotionY = paramMotionEvent.getY();
      pullEvent();
      return true;
    } while (!this.isBeingDragged);
    this.isBeingDragged = false;
    if ((this.state == 1) && (this.onRefreshListener != null))
    {
      setRefreshingInternal(true);
      this.onRefreshListener.onRefresh();
    }
    for (;;)
    {
      return true;
      smoothScrollTo(0);
    }
  }
  
  protected void resetHeader()
  {
    this.state = 0;
    this.isBeingDragged = false;
    if (this.headerLayout != null) {
      this.headerLayout.reset();
    }
    if (this.footerLayout != null) {
      this.footerLayout.reset();
    }
    smoothScrollTo(0);
  }
  
  public final void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    this.disableScrollingWhileRefreshing = paramBoolean;
  }
  
  protected final void setHeaderScroll(int paramInt)
  {
    scrollTo(0, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  protected final void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public final void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.onRefreshListener = paramOnRefreshListener;
  }
  
  public void setPullLabel(String paramString)
  {
    if (this.headerLayout != null) {
      this.headerLayout.setPullLabel(paramString);
    }
    if (this.footerLayout != null) {
      this.footerLayout.setPullLabel(paramString);
    }
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    this.isPullToRefreshEnabled = paramBoolean;
  }
  
  public final void setRefreshing()
  {
    setRefreshing(true);
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!isRefreshing())
    {
      setRefreshingInternal(paramBoolean);
      this.state = 3;
    }
  }
  
  protected void setRefreshingInternal(boolean paramBoolean)
  {
    this.state = 2;
    if (this.headerLayout != null) {
      this.headerLayout.refreshing();
    }
    if (this.footerLayout != null) {
      this.footerLayout.refreshing();
    }
    if (paramBoolean) {
      if (this.currentMode != 1) {
        break label57;
      }
    }
    label57:
    for (int i = -this.headerHeight;; i = this.headerHeight)
    {
      smoothScrollTo(i);
      return;
    }
  }
  
  public void setRefreshingLabel(String paramString)
  {
    if (this.headerLayout != null) {
      this.headerLayout.setRefreshingLabel(paramString);
    }
    if (this.footerLayout != null) {
      this.footerLayout.setRefreshingLabel(paramString);
    }
  }
  
  public void setReleaseLabel(String paramString)
  {
    if (this.headerLayout != null) {
      this.headerLayout.setReleaseLabel(paramString);
    }
    if (this.footerLayout != null) {
      this.footerLayout.setReleaseLabel(paramString);
    }
  }
  
  protected final void smoothScrollTo(int paramInt)
  {
    if (this.currentSmoothScrollRunnable != null) {
      this.currentSmoothScrollRunnable.stop();
    }
    if (getScrollY() != paramInt)
    {
      this.currentSmoothScrollRunnable = new SmoothScrollRunnable(this.handler, getScrollY(), paramInt);
      this.handler.post(this.currentSmoothScrollRunnable);
    }
  }
  
  public static abstract interface OnLastItemVisibleListener
  {
    public abstract void onLastItemVisible();
  }
  
  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh();
  }
  
  final class SmoothScrollRunnable
    implements Runnable
  {
    static final int ANIMATION_DURATION_MS = 190;
    static final int ANIMATION_FPS = 16;
    private boolean continueRunning = true;
    private int currentY = -1;
    private final Handler handler;
    private final Interpolator interpolator;
    private final int scrollFromY;
    private final int scrollToY;
    private long startTime = -1L;
    
    public SmoothScrollRunnable(Handler paramHandler, int paramInt1, int paramInt2)
    {
      this.handler = paramHandler;
      this.scrollFromY = paramInt1;
      this.scrollToY = paramInt2;
      this.interpolator = new AccelerateDecelerateInterpolator();
    }
    
    public void run()
    {
      if (this.startTime == -1L) {
        this.startTime = System.currentTimeMillis();
      }
      for (;;)
      {
        if ((this.continueRunning) && (this.scrollToY != this.currentY)) {
          this.handler.postDelayed(this, 16L);
        }
        return;
        long l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / 190L, 1000L), 0L);
        int i = Math.round((this.scrollFromY - this.scrollToY) * this.interpolator.getInterpolation((float)l / 1000.0F));
        this.currentY = (this.scrollFromY - i);
        PullToRefreshBase.this.setHeaderScroll(this.currentY);
      }
    }
    
    public void stop()
    {
      this.continueRunning = false;
      this.handler.removeCallbacks(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/pulltorefresh/PullToRefreshBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */