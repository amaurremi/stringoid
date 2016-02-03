package logo.quiz.commons.utils.slider;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PagerContainer
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  boolean change = true;
  private Point mCenter = new Point();
  private Point mInitialTouch = new Point();
  boolean mNeedsRedraw = false;
  private ViewPager mPager;
  PageChangedChangeListener pageChangedChangeListener;
  
  public PagerContainer(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PagerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PagerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setClipChildren(false);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  public ViewPager getViewPager()
  {
    return this.mPager;
  }
  
  protected void onFinishInflate()
  {
    try
    {
      this.mPager = ((ViewPager)getChildAt(0));
      this.mPager.setOnPageChangeListener(this);
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("The root child of PagerContainer must be a ViewPager");
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mNeedsRedraw = bool;
      return;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mNeedsRedraw) {
      invalidate();
    }
    if (this.pageChangedChangeListener != null)
    {
      if ((paramFloat > 0.5D) || (!this.change)) {
        break label50;
      }
      this.pageChangedChangeListener.onPageChange(paramInt1);
      this.change = false;
    }
    label50:
    while ((paramFloat <= 0.5D) || (this.change)) {
      return;
    }
    this.pageChangedChangeListener.onPageChange(paramInt1 + 1);
    this.change = true;
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.pageChangedChangeListener != null) {
      this.pageChangedChangeListener.onPageChange(paramInt);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mCenter.x = (paramInt1 / 2);
    this.mCenter.y = (paramInt2 / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramMotionEvent.offsetLocation(this.mCenter.x - this.mInitialTouch.x, this.mCenter.y - this.mInitialTouch.y);
      return this.mPager.dispatchTouchEvent(paramMotionEvent);
      this.mInitialTouch.x = ((int)paramMotionEvent.getX());
      this.mInitialTouch.y = ((int)paramMotionEvent.getY());
    }
  }
  
  public void setPageChangedChangeListener(PageChangedChangeListener paramPageChangedChangeListener)
  {
    this.pageChangedChangeListener = paramPageChangedChangeListener;
  }
  
  static abstract interface PageChangedChangeListener
  {
    public abstract void onPageChange(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/slider/PagerContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */