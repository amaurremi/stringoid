package com.pocket.widget;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.pocket.i.a.l;
import com.pocket.i.a.m;
import com.pocket.p.u;

public class ao
  extends l
{
  private final m b = new m(this.a.getContext(), 2131165831);
  private final m c = new m(this.a.getContext(), 2131165830);
  private final RectF d = new RectF();
  
  public ao(ThemedSwitch paramThemedSwitch)
  {
    a(this.b);
    a(this.c);
    u.a(this.b, 2.0F, 0.0F, ThemedSwitch.a(), ThemedSwitch.b());
    this.b.setStyle(Paint.Style.FILL);
    this.c.setStyle(Paint.Style.FILL);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.d.set(getBounds());
    RectF localRectF = this.d;
    localRectF.bottom -= ThemedSwitch.a();
    paramCanvas.drawRoundRect(this.d, ThemedSwitch.c(), ThemedSwitch.c(), this.b);
    this.d.inset(ThemedSwitch.d(), ThemedSwitch.d());
    paramCanvas.drawRoundRect(this.d, ThemedSwitch.c() / 2.0F, ThemedSwitch.c() / 2.0F, this.c);
  }
  
  public int getIntrinsicHeight()
  {
    return ThemedSwitch.f() + ThemedSwitch.a();
  }
  
  public int getIntrinsicWidth()
  {
    return ThemedSwitch.e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */