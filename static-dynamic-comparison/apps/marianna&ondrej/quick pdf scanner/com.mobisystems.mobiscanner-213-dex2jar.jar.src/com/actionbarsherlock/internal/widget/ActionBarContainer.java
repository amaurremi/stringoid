package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;

public class ActionBarContainer
  extends NineFrameLayout
{
  private ActionBarView mActionBarView;
  private Drawable mBackground;
  private boolean mIsSplit;
  private boolean mIsStacked;
  private boolean mIsTransitioning;
  private Drawable mSplitBackground;
  private Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionBar);
    this.mBackground = paramContext.getDrawable(2);
    this.mStackedBackground = paramContext.getDrawable(12);
    if (((this.mStackedBackground instanceof ColorDrawable)) && (Build.VERSION.SDK_INT < 11)) {
      this.mStackedBackground = new IcsColorDrawable((ColorDrawable)this.mStackedBackground);
    }
    if (getId() == R.id.abs__split_action_bar)
    {
      this.mIsSplit = true;
      this.mSplitBackground = paramContext.getDrawable(3);
    }
    paramContext.recycle();
    boolean bool;
    if (this.mIsSplit) {
      if (this.mSplitBackground == null) {
        bool = true;
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.mBackground == null) && (this.mStackedBackground == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public View getTabContainer()
  {
    return this.mTabContainer;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (getHeight() == 0)) {}
    do
    {
      do
      {
        return;
        if (!this.mIsSplit) {
          break;
        }
      } while (this.mSplitBackground == null);
      this.mSplitBackground.draw(paramCanvas);
      return;
      if (this.mBackground != null) {
        this.mBackground.draw(paramCanvas);
      }
    } while ((this.mStackedBackground == null) || (!this.mIsStacked));
    this.mStackedBackground.draw(paramCanvas);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = ((ActionBarView)findViewById(R.id.abs__action_bar));
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    boolean bool = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j;
    label93:
    View localView;
    if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8))
    {
      paramInt2 = 1;
      if ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8)) {
        break label164;
      }
      paramInt4 = getMeasuredHeight();
      j = this.mTabContainer.getMeasuredHeight();
      if ((this.mActionBarView.getDisplayOptions() & 0x2) != 0) {
        break label207;
      }
      int k = getChildCount();
      paramInt4 = 0;
      if (paramInt4 >= k) {
        break label151;
      }
      localView = getChildAt(paramInt4);
      if (localView != this.mTabContainer) {
        break label131;
      }
    }
    for (;;)
    {
      paramInt4 += 1;
      break label93;
      paramInt2 = 0;
      break;
      label131:
      if (!this.mActionBarView.isCollapsed()) {
        localView.offsetTopAndBottom(j);
      }
    }
    label151:
    this.mTabContainer.layout(paramInt1, 0, paramInt3, j);
    label164:
    if (this.mIsSplit)
    {
      if (this.mSplitBackground == null) {
        break label348;
      }
      this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      label207:
      this.mTabContainer.layout(paramInt1, paramInt4 - j, paramInt3, paramInt4);
      break;
      if (this.mBackground != null) {
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramBoolean = bool;
        if (paramInt2 != 0)
        {
          paramBoolean = bool;
          if (this.mStackedBackground != null) {
            paramBoolean = true;
          }
        }
        this.mIsStacked = paramBoolean;
        if (paramBoolean)
        {
          this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
          paramInt1 = i;
          break;
        }
        break;
      }
      label348:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mActionBarView == null) {}
    for (;;)
    {
      return;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mActionBarView.getLayoutParams();
      if (this.mActionBarView.isCollapsed()) {}
      int i;
      for (paramInt1 = 0; (this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8) && (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE); paramInt1 = localLayoutParams.bottomMargin + (paramInt1 + i))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + this.mTabContainer.getMeasuredHeight(), paramInt2));
        return;
        paramInt1 = this.mActionBarView.getMeasuredHeight();
        i = localLayoutParams.topMargin;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    this.mSplitBackground = paramDrawable;
    invalidate();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    this.mStackedBackground = paramDrawable;
    invalidate();
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null) {
      removeView(this.mTabContainer);
    }
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */