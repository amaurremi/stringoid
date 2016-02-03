package com.pocket.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class ae
  extends Drawable
{
  private final Paint a = new Paint();
  
  private ae()
  {
    this.a.setStrokeWidth(ad.a());
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(ad.b());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f = (localRect.width() - ad.a()) / 2.0F;
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), f, this.a);
  }
  
  public int getIntrinsicHeight()
  {
    return ad.c() * 2;
  }
  
  public int getIntrinsicWidth()
  {
    return ad.c() * 2;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */