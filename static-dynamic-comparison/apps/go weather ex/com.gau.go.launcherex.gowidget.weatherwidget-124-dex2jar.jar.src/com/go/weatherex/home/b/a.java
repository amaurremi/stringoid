package com.go.weatherex.home.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.ViewDebug.ExportedProperty;

public class a
  extends Drawable
{
  @ViewDebug.ExportedProperty(deepExport=true, prefix="state_")
  private c a;
  private final Paint b = new Paint();
  private boolean c;
  
  public a()
  {
    this(null);
  }
  
  public a(int paramInt)
  {
    this(null);
    a(paramInt);
  }
  
  private a(c paramc)
  {
    this.a = new c(paramc);
  }
  
  public void a(int paramInt)
  {
    if ((this.a.a != paramInt) || (this.a.b != paramInt))
    {
      invalidateSelf();
      c localc = this.a;
      this.a.b = paramInt;
      localc.a = paramInt;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.b >>> 24 != 0)
    {
      this.b.setColor(this.a.b);
      paramCanvas.drawRect(getBounds(), this.b);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.c;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    this.a.c = getChangingConfigurations();
    return this.a;
  }
  
  public int getOpacity()
  {
    switch (this.a.b >>> 24)
    {
    default: 
      return -3;
    case 255: 
      return -1;
    }
    return -2;
  }
  
  public Drawable mutate()
  {
    if ((!this.c) && (super.mutate() == this))
    {
      this.a = new c(this.a);
      this.c = true;
    }
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    int i = this.a.a;
    int j = this.a.b;
    this.a.b = (((paramInt >> 7) + paramInt) * (i >>> 24) >> 8 << 24 | this.a.a << 8 >>> 8);
    if (j != this.a.b) {
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */