package com.appbrain.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class ai
  extends Drawable
{
  private int h;
  private int i;
  
  ai(ae paramae, RectF paramRectF, int paramInt1, int paramInt2, Paint paramPaint1, int paramInt3, Paint paramPaint2) {}
  
  public final void draw(Canvas paramCanvas)
  {
    this.a.set(this.b, this.b, this.h - this.b, this.i - this.b);
    paramCanvas.drawRoundRect(this.a, this.c, this.c, this.d);
    this.a.set(this.e, this.e, this.h - this.e, this.i - this.e);
    paramCanvas.drawRoundRect(this.a, this.c, this.c, this.f);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.h = paramRect.width();
    this.i = paramRect.height();
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */