package com.ideashower.readitlater.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class LockableViewPager
  extends ViewPager
{
  private boolean a = false;
  
  public LockableViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public LockableViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void g()
  {
    this.a = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/LockableViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */