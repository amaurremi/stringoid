package com.appbrain.a;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;
import cmn.q;
import com.appbrain.d.a;

final class bb
  extends PaintDrawable
{
  Paint a = new Paint();
  
  bb(at.b paramb, a parama)
  {
    this.a.setMaskFilter(new BlurMaskFilter(q.a(4.0F), BlurMaskFilter.Blur.OUTER));
    this.a.setColor(Integer.MIN_VALUE);
    setShape(this.b.getShape());
  }
  
  protected final void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
  {
    super.onDraw(paramShape, paramCanvas, paramPaint);
    paramShape.draw(paramCanvas, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */