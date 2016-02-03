package com.appbrain.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  ColorFilter a;
  Paint b = new Paint();
  RectF c = null;
  
  b(Drawable paramDrawable) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.saveLayer(this.c, this.b, 31);
    this.d.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.d.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    return this.d.getIntrinsicWidth();
  }
  
  public final int getMinimumHeight()
  {
    return this.d.getMinimumHeight();
  }
  
  public final int getMinimumWidth()
  {
    return this.d.getMinimumWidth();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    return this.d.getPadding(paramRect);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.c = new RectF(paramRect);
    this.d.setBounds(paramRect);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a = paramColorFilter;
    this.b.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */