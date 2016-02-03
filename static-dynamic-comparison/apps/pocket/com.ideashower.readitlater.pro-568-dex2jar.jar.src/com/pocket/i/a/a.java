package com.pocket.i.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class a
  extends Drawable
{
  private final Paint a = new Paint();
  private final ColorStateList b;
  private int c = 255;
  
  public a(Context paramContext, int paramInt)
  {
    this(paramContext.getResources().getColorStateList(paramInt));
  }
  
  public a(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(getBounds(), this.a);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.a.setColor(this.b.getColorForState(paramArrayOfInt, 0));
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt == this.c) {
      return;
    }
    this.a.setAlpha(paramInt);
    this.c = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.a.getColorFilter() == paramColorFilter) {
      return;
    }
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */