package com.appflood.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.appflood.b.b.a;
import com.appflood.c.d;
import com.appflood.e.j;

public final class e
  extends a
{
  private Paint d = new Paint();
  private com.appflood.e.b e = new com.appflood.e.b(421.0F, 206.0F);
  private com.appflood.e.b f = new com.appflood.e.b(104.0F, 40.0F);
  private RectF g;
  private RectF h;
  private Rect i;
  private int j = 13;
  private int k;
  private float l = 20.0F;
  private int m = 16;
  private int n = 25;
  private Bitmap o;
  
  public e(Context paramContext, float paramFloat, int paramInt)
  {
    super(paramContext);
    this.e.a(paramFloat);
    this.f.a(paramFloat);
    this.j = ((int)(this.j * paramFloat));
    this.l = ((int)(this.l * paramFloat));
    this.m = ((int)(this.m * paramFloat));
    this.n = ((int)(this.n * paramFloat));
    this.k = ((int)(paramInt * paramFloat));
    paramContext = new com.appflood.b.b(d.z + d.e, (byte)0);
    paramContext.a(new b.a()
    {
      public final void a(com.appflood.b.b paramAnonymousb)
      {
        e.a(e.this, paramAnonymousb.d());
      }
      
      public final void a(com.appflood.b.b paramAnonymousb, int paramAnonymousInt)
      {
        j.c("failed to download download png");
      }
    });
    paramContext.f();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      int i2 = this.k;
      int i3 = this.k;
      int i4 = getWidth();
      int i5 = this.k;
      int i1 = getHeight() + i3 - this.k * 2;
      this.g = new RectF(i2, i3, i4 + i2 - i5 * 2, i1);
      this.h = new RectF(this.j + i2, this.j + i3, i2 + this.j + (int)this.e.a, i3 + (int)this.e.b);
      i2 = (int)(this.h.right + 2.0F - (int)this.f.a);
      i1 = (int)(this.h.bottom + (i1 - this.h.bottom - (int)this.f.b) / 2.0F);
      this.i = new Rect(i2, i1, (int)this.h.right + 2, (int)this.f.b + i1);
      this.d.setColor(-526083);
      this.d.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.g, 3.0F, 3.0F, this.d);
      if (this.c != null) {
        paramCanvas.drawBitmap(this.c, null, this.h, null);
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(-11182220);
      localPaint.setTypeface(Typeface.DEFAULT_BOLD);
      localPaint.setTextSize(this.l);
      localPaint.setTextAlign(Paint.Align.LEFT);
      if (this.a != null)
      {
        Rect localRect = new Rect();
        localPaint.getTextBounds(this.a, 0, this.a.length(), localRect);
        String str = this.a;
        float f1 = this.h.left;
        i1 = this.i.top;
        paramCanvas.drawText(str, f1, (localRect.height() << 1) / 3 + i1, localPaint);
      }
      if (this.b != null)
      {
        localPaint.setTypeface(Typeface.DEFAULT);
        localPaint.setTextSize(this.m);
        paramCanvas.drawText(this.b, this.h.left, this.i.bottom, localPaint);
      }
      paramCanvas.drawBitmap(this.o, null, this.i, null);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */