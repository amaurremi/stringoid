package com.pocket.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.ideashower.readitlater.h.m;
import com.pocket.p.u;

class z
  extends ac
{
  private final Paint c = new Paint();
  private final Paint d = new Paint();
  private final ColorStateList e;
  private final ColorStateList f;
  private final int g = PocketSeekBar.b() + PocketSeekBar.c();
  
  private z(PocketSeekBar paramPocketSeekBar, Resources paramResources)
  {
    super(paramPocketSeekBar, paramResources, null);
    a(this.d);
    a(this.c);
    this.d.setStyle(Paint.Style.FILL);
    this.c.setStyle(Paint.Style.FILL);
    this.f = paramResources.getColorStateList(2131165786);
    this.e = paramResources.getColorStateList(2131165787);
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    this.c.setColor(this.e.getColorForState(paramArrayOfInt, 0));
    this.d.setColor(this.f.getColorForState(paramArrayOfInt, 0));
    if (m.a(paramArrayOfInt))
    {
      u.a(this.d, this.g, 0.0F, 0.0F, Color.argb(200, 0, 0, 0));
      return;
    }
    u.a(this.d, 0.0F, 0.0F, 0.0F, 0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), PocketSeekBar.b(), this.c);
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), PocketSeekBar.b() - PocketSeekBar.d(), this.d);
  }
  
  public int getIntrinsicHeight()
  {
    return this.g * 2;
  }
  
  public int getIntrinsicWidth()
  {
    return this.g * 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */