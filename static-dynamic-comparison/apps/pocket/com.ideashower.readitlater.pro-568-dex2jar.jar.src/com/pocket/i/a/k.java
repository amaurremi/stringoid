package com.pocket.i.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class k
  extends l
{
  private final m a = new m();
  private final m b = new m();
  private final RectF c = new RectF();
  private int d;
  private float e;
  
  public k()
  {
    a(this.a);
    a(this.b);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public k(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    this();
    a(paramInt3);
    if (paramInt1 != 0) {
      b(paramResources.getColorStateList(paramInt1));
    }
    if (paramInt2 != 0) {
      a(paramResources.getColorStateList(paramInt2));
    }
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
    invalidateSelf();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.b.setStrokeWidth(this.d);
    invalidateSelf();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.b.a(paramColorStateList, getState());
    invalidateSelf();
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    this.a.a(paramColorStateList, getState());
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.set(getBounds());
    if (this.e > 0.0F)
    {
      this.b.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.c, this.e, this.e, this.b);
      this.c.inset(this.d, this.d);
      paramCanvas.drawRoundRect(this.c, this.e, this.e, this.a);
    }
    float f;
    do
    {
      return;
      f = this.d / 2.0F;
      this.b.setStyle(Paint.Style.STROKE);
      if (this.b.a())
      {
        this.c.inset(f, f);
        paramCanvas.drawRect(this.c, this.b);
      }
    } while (!this.a.a());
    this.c.inset(f, f);
    paramCanvas.drawRect(this.c, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */