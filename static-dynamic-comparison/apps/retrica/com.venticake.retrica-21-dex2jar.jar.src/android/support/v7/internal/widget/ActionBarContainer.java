package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.b.f;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer
  extends FrameLayout
{
  private boolean a;
  private View b;
  private ActionBarView c;
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private boolean g;
  private boolean h;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.ActionBar);
    this.d = paramContext.getDrawable(10);
    this.e = paramContext.getDrawable(11);
    if (getId() == f.split_action_bar)
    {
      this.g = true;
      this.f = paramContext.getDrawable(12);
    }
    paramContext.recycle();
    if (this.g) {
      if (this.f != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      if ((this.d != null) || (this.e != null)) {
        bool = false;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.d != null) && (this.d.isStateful())) {
      this.d.setState(getDrawableState());
    }
    if ((this.e != null) && (this.e.isStateful())) {
      this.e.setState(getDrawableState());
    }
    if ((this.f != null) && (this.f.isStateful())) {
      this.f.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.b;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() == 0) || (getHeight() == 0)) {}
    do
    {
      do
      {
        return;
        if (!this.g) {
          break;
        }
      } while (this.f == null);
      this.f.draw(paramCanvas);
      return;
      if (this.d != null) {
        this.d.draw(paramCanvas);
      }
    } while ((this.e == null) || (!this.h));
    this.e.draw(paramCanvas);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((ActionBarView)findViewById(f.action_bar));
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.a) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    boolean bool = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j;
    label93:
    View localView;
    if ((this.b != null) && (this.b.getVisibility() != 8))
    {
      paramInt2 = 1;
      if ((this.b == null) || (this.b.getVisibility() == 8)) {
        break label164;
      }
      paramInt4 = getMeasuredHeight();
      j = this.b.getMeasuredHeight();
      if ((this.c.getDisplayOptions() & 0x2) != 0) {
        break label207;
      }
      int k = getChildCount();
      paramInt4 = 0;
      if (paramInt4 >= k) {
        break label151;
      }
      localView = getChildAt(paramInt4);
      if (localView != this.b) {
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
      if (!this.c.k()) {
        localView.offsetTopAndBottom(j);
      }
    }
    label151:
    this.b.layout(paramInt1, 0, paramInt3, j);
    label164:
    if (this.g)
    {
      if (this.f == null) {
        break label348;
      }
      this.f.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      label207:
      this.b.layout(paramInt1, paramInt4 - j, paramInt3, paramInt4);
      break;
      if (this.d != null) {
        this.d.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramBoolean = bool;
        if (paramInt2 != 0)
        {
          paramBoolean = bool;
          if (this.e != null) {
            paramBoolean = true;
          }
        }
        this.h = paramBoolean;
        if (paramBoolean)
        {
          this.e.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
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
    if (this.c == null) {}
    for (;;)
    {
      return;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      if (this.c.k()) {}
      int i;
      for (paramInt1 = 0; (this.b != null) && (this.b.getVisibility() != 8) && (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE); paramInt1 = localLayoutParams.bottomMargin + (paramInt1 + i))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + this.b.getMeasuredHeight(), paramInt2));
        return;
        paramInt1 = this.c.getMeasuredHeight();
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
    boolean bool = true;
    if (this.d != null)
    {
      this.d.setCallback(null);
      unscheduleDrawable(this.d);
    }
    this.d = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.g) {
      if (this.f != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.d != null) || (this.e != null)) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.f != null)
    {
      this.f.setCallback(null);
      unscheduleDrawable(this.f);
    }
    this.f = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.g) {
      if (this.f != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.d != null) || (this.e != null)) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.e != null)
    {
      this.e.setCallback(null);
      unscheduleDrawable(this.e);
    }
    this.e = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    if (this.g) {
      if (this.f != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.d != null) || (this.e != null)) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.b != null) {
      removeView(this.b);
    }
    this.b = paramScrollingTabContainerView;
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
    this.a = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.d != null) {
        this.d.setVisible(bool, false);
      }
      if (this.e != null) {
        this.e.setVisible(bool, false);
      }
      if (this.f != null) {
        this.f.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.d) && (!this.g)) || ((paramDrawable == this.e) && (this.h)) || ((paramDrawable == this.f) && (this.g)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */