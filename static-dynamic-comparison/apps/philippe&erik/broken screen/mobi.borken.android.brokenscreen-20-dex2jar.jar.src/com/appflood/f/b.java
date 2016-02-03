package com.appflood.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public final class b
  extends View
{
  private int a = -1;
  private int b;
  private Paint c;
  private RectF d = new RectF();
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.b = paramInt;
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(this.a);
    this.c.setStrokeWidth(this.b);
    this.c.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      this.d.set(this.b, this.b, getWidth() - this.b, getHeight() - this.b);
      paramCanvas.drawRoundRect(this.d, 0.0F, 0.0F, this.c);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */