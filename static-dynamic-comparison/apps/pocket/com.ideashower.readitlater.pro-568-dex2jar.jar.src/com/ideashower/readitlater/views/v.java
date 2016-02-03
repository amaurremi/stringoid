package com.ideashower.readitlater.views;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class v
  extends Drawable
{
  private final Paint a = new Paint();
  private final ColorStateList b;
  private final Paint c = new Paint();
  private final ColorStateList d;
  private int e = 255;
  
  public v(Resources paramResources)
  {
    this.b = paramResources.getColorStateList(2131165733);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(0.0F);
    this.d = paramResources.getColorStateList(2131165731);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f = localRect.top;
    paramCanvas.drawPaint(this.c);
    paramCanvas.drawLine(localRect.left, f, localRect.right, f, this.a);
  }
  
  public int getIntrinsicHeight()
  {
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public int getMinimumHeight()
  {
    return 0;
  }
  
  public int getMinimumWidth()
  {
    return 0;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(0, 1, 0, 0);
    return true;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    int i = this.b.getColorForState(paramArrayOfInt, 0);
    if (i != this.a.getColor())
    {
      this.a.setColor(i);
      bool1 = true;
    }
    i = this.d.getColorForState(paramArrayOfInt, 0);
    if (i != this.c.getColor())
    {
      this.c.setColor(i);
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        invalidateSelf();
      }
      return bool1;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      this.a.setAlpha(paramInt);
      this.c.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    this.c.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */