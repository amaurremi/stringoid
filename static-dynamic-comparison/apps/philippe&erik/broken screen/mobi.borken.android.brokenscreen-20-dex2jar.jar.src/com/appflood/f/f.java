package com.appflood.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.appflood.e.b;

public final class f
  extends a
{
  private Paint d = new Paint();
  private b e = new b(454.0F, 222.0F);
  private b f = new b(486.0F, 251.0F);
  private RectF g;
  private RectF h;
  private int i = 16;
  private int j;
  private int k = 22;
  private int l = 16;
  private int m = 25;
  
  public f(Context paramContext, float paramFloat, int paramInt)
  {
    super(paramContext);
    this.e.a(paramFloat);
    this.f.a(paramFloat);
    this.i = ((int)(this.i * paramFloat));
    this.k = ((int)(this.k * paramFloat));
    this.l = ((int)(this.l * paramFloat));
    this.m = ((int)(this.m * paramFloat));
    this.j = ((int)(paramInt * paramFloat));
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      int n = this.j;
      int i1 = (int)this.f.a;
      int i2 = (int)this.f.b;
      this.g = new RectF(n, 0.0F, i1 + n, i2 + 0);
      this.h = new RectF(this.i + n, this.i + 0, n + this.i + (int)this.e.a, (int)this.e.b + 0);
      this.d.setColor(-526083);
      this.d.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.g, 3.0F, 3.0F, this.d);
      if (this.c != null) {
        paramCanvas.drawBitmap(this.c, null, this.h, null);
      }
      return;
    }
    catch (Throwable paramCanvas) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */