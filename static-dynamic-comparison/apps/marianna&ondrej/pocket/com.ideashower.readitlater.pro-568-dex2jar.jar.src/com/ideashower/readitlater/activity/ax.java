package com.ideashower.readitlater.activity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ax
  extends Drawable
{
  private final Paint a = new Paint();
  private final ColorStateList b;
  
  public ax(Resources paramResources, int paramInt)
  {
    this.b = paramResources.getColorStateList(paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.bottom, this.a);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.a.setColor(this.b.getColorForState(paramArrayOfInt, 0));
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */