package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.e;

public class ThemedSwitch
  extends aj
{
  private static final int b = j.a(60.5F);
  private static final int c = j.a(20.0F);
  private static final int d = j.a(31.0F);
  private static final int e = c;
  private static final int f = j.a(3.0F);
  private static final int g = e.a(0.1F, 0);
  private static final float h = j.a(1.7F);
  private static final int i = j.a(1.0F);
  
  public ThemedSwitch(Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  public ThemedSwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  private void i()
  {
    if (getThumbDrawable() == null) {
      setThumbDrawable(new ao(this));
    }
    if (getTrackDrawable() == null) {
      setTrackDrawable(new ap(this));
    }
    if (getTextOff() == null) {
      setTextOff("");
    }
    if (getTextOn() == null) {
      setTextOn("");
    }
    if (getSwitchMinWidth() == 0) {
      setSwitchMinWidth(b);
    }
    if (getThumbMinWidth() == 0) {
      setThumbMinWidth(d);
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.onTouchEvent(paramMotionEvent)) {}
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ThemedSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */