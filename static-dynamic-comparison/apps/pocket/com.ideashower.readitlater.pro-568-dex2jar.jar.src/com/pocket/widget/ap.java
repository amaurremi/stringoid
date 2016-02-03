package com.pocket.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.pocket.i.a.l;
import com.pocket.i.a.m;

public class ap
  extends l
{
  private final m b = new m(this.a.getContext(), 2131165832);
  private final RectF c = new RectF();
  
  public ap(ThemedSwitch paramThemedSwitch)
  {
    a(this.b);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(this.c, ThemedSwitch.c(), ThemedSwitch.c(), this.b);
  }
  
  public int getIntrinsicHeight()
  {
    return ThemedSwitch.h() + ThemedSwitch.a();
  }
  
  public int getIntrinsicWidth()
  {
    return ThemedSwitch.g();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.c.set(paramRect);
    paramRect = this.c;
    paramRect.bottom -= ThemedSwitch.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */