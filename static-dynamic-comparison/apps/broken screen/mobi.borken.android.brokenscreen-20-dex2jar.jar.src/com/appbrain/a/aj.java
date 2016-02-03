package com.appbrain.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

final class aj
  extends ShapeDrawable
{
  aj(ae paramae, Shape paramShape, Paint paramPaint)
  {
    super(paramShape);
  }
  
  protected final void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
  {
    super.onDraw(paramShape, paramCanvas, paramPaint);
    int i = (int)(paramShape.getWidth() * 0.3F);
    int j = (int)paramShape.getWidth() - i;
    int k = (int)(paramShape.getHeight() * 0.3F);
    int m = (int)paramShape.getHeight() - k;
    paramCanvas.drawLine(i, k, j, m, this.a);
    paramCanvas.drawLine(i, m, j, k, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */