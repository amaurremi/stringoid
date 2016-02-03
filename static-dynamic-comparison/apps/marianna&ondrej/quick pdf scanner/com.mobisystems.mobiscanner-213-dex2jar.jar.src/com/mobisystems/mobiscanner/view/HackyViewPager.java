package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class HackyViewPager
  extends ViewPager
{
  public HackyViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public HackyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/HackyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */