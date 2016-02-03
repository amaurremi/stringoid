package com.appbrain.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class e
  extends Drawable
{
  Paint a = new Paint();
  RectF b = null;
  
  e(Drawable paramDrawable) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.saveLayer(this.b, this.a, 31);
    this.c.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.c.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    return this.c.getIntrinsicWidth();
  }
  
  public final int getMinimumHeight()
  {
    return this.c.getMinimumHeight();
  }
  
  public final int getMinimumWidth()
  {
    return this.c.getMinimumWidth();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    return this.c.getPadding(paramRect);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.b = new RectF(paramRect);
    this.c.setBounds(paramRect);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */