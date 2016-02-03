package com.appbrain.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class az
  extends Drawable
{
  Path a = new Path();
  Path b = new Path();
  Paint c = new Paint();
  
  az(at.b paramb, at.d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.setColor(this.d.c.d);
    this.c.setStrokeWidth(this.e);
    this.c.setStrokeJoin(Paint.Join.MITER);
    this.c.setStyle(Paint.Style.STROKE);
    this.a.moveTo(this.f - 100, this.g - 100);
    this.a.lineTo(this.f, this.g);
    this.a.lineTo(this.f - 100, this.g + 100);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.a, this.c);
    paramCanvas.drawPath(this.b, this.c);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.offset(paramRect.right - paramRect.left, 0.0F, this.b);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */