package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.jfeinstein.jazzyviewpager.JazzyViewPager;

public class DisableableViewPager
  extends JazzyViewPager
{
  private boolean aLw = true;
  
  public DisableableViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public DisableableViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(View paramView1, View paramView2, float paramFloat)
  {
    super.a(paramView1, paramView2, paramFloat);
    super.c(paramView1, paramView2, paramFloat);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.aLw) {
      return true;
    }
    return super.a(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public void bv(boolean paramBoolean)
  {
    this.aLw = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLw) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aLw) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/DisableableViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */