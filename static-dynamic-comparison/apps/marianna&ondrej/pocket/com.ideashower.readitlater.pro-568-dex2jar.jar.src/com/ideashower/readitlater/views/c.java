package com.ideashower.readitlater.views;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.j;

public class c
  extends Drawable
{
  private final int a = 5;
  private final int b = 0;
  private final int c = 1;
  private final int d = 3;
  private final Paint e = new Paint();
  private final ColorStateList f;
  private final int g;
  private final int h;
  private final int i;
  private int j = 255;
  
  public c(Resources paramResources)
  {
    this.f = paramResources.getColorStateList(2131165733);
    this.e.setAntiAlias(true);
    this.e.setStrokeWidth(0.0F);
    this.g = j.a(5.0F);
    this.h = 1;
    this.i = j.a(1.0F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = localRect.top;
    float f2 = j.a(12.5F);
    float f3 = localRect.exactCenterX() - f2 / 2.0F;
    f1 += j.a(5.0F) + 1;
    int k = 0;
    while (k < 3)
    {
      paramCanvas.drawLine(f3, f1, f2 + f3, f1, this.e);
      f1 += j.a(1.0F) + 1;
      k += 1;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return getMinimumHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public int getMinimumHeight()
  {
    return this.g + this.h * 3 + this.i * 3;
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
    paramRect.set(0, getMinimumHeight(), 0, 0);
    return true;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int k = this.f.getColorForState(paramArrayOfInt, 0);
    if (k != this.e.getColor())
    {
      this.e.setColor(k);
      bool = true;
    }
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.j)
    {
      this.j = paramInt;
      this.e.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */