package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ideashower.readitlater.views.ResizeDetectFrameLayout;

public class TouchShiftFrameLayout
  extends ResizeDetectFrameLayout
{
  private boolean a;
  private int b;
  
  public TouchShiftFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchShiftFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchShiftFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = getTop() - this.b;
    if ((this.a) && (i != 0)) {
      paramMotionEvent.offsetLocation(0.0F, i);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.a = false;
      continue;
      this.b = getTop();
      this.a = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/TouchShiftFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */