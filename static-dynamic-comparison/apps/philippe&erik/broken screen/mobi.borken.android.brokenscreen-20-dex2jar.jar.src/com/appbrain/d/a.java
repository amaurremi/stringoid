package com.appbrain.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.DisplayMetrics;

public final class a
  extends PaintDrawable
{
  Drawable.ConstantState a = new b(this);
  private Paint b = new Paint(1);
  
  public a(Shape paramShape)
  {
    setShape(paramShape);
    this.b.setStyle(Paint.Style.STROKE);
  }
  
  public static a a(Context paramContext, float paramFloat, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    paramContext = new a(new RectShape());
    paramContext.setCornerRadius(paramFloat * f);
    if (paramInt != 0)
    {
      paramContext.b.setStrokeWidth(f * 2.0F);
      paramContext.b.setColor(paramInt);
      return paramContext;
    }
    paramContext.b.setStrokeWidth(0.0F);
    return paramContext;
  }
  
  public final Paint a()
  {
    return this.b;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  protected final void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
  {
    paramShape.draw(paramCanvas, paramPaint);
    if (this.b.getStrokeWidth() > 0.0F) {
      paramShape.draw(paramCanvas, this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */