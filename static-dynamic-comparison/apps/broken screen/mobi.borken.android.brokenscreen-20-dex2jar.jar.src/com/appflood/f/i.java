package com.appflood.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.appflood.c.d;
import com.appflood.e.b;

public final class i
  extends a
{
  private int d = 15;
  private int e = 15;
  private int f = 15;
  private float g = 1.0F;
  private Paint h;
  private b i = new b(182.0F, 89.0F);
  private b j = new b(182.0F, 32.0F);
  private int k = 20;
  private boolean l;
  private int m = 5;
  
  public i(Context paramContext, float paramFloat, boolean paramBoolean)
  {
    super(paramContext);
    this.g = paramFloat;
    this.l = paramBoolean;
    if (this.l)
    {
      this.d = ((int)(this.g * 15.0F));
      this.e = this.d;
      this.f = ((int)(this.g * 15.0F));
      this.i.a(paramFloat);
      this.j.a(paramFloat);
      this.m = ((int)(this.m * paramFloat));
    }
    for (this.k = ((int)(20.0F * paramFloat));; this.k = ((int)(15.0F * paramFloat)))
    {
      this.h = new Paint();
      return;
      this.d = ((int)(11.0F * this.g));
      this.e = ((int)(this.g * 8.0F));
      this.f = ((int)(this.g * 8.0F));
      this.i = new b(155.0F, 76.0F);
      this.i.a(paramFloat);
      this.j = new b(155.0F, 25.0F);
      this.j.a(paramFloat);
      this.m = ((int)(this.m * paramFloat));
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.a = d.d;
    this.b = paramString2;
    postInvalidate();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      if (this.l)
      {
        this.h.setColor(-526083);
        this.h.clearShadowLayer();
        this.h.setStyle(Paint.Style.FILL);
        paramCanvas.drawRoundRect(new RectF(new Rect(this.m + 1, this.m + 1, getWidth() - 2 - this.m, getHeight() - 2 - this.m)), 3.0F, 3.0F, this.h);
      }
      Object localObject = new RectF(this.f + this.m, this.d + this.m, this.f + (int)this.i.a + this.m, this.d + (int)this.i.b + this.m);
      if (this.c != null) {
        paramCanvas.drawBitmap(this.c, null, (RectF)localObject, null);
      }
      localObject = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { -2863104, -885504 });
      ((GradientDrawable)localObject).setCornerRadius(3.0F);
      int n = this.f + this.m;
      int i1 = this.e + this.d + (int)this.i.b + this.m;
      ((GradientDrawable)localObject).setBounds(new Rect(n, i1, (int)this.j.a + n, (int)this.j.b + i1));
      ((GradientDrawable)localObject).draw(paramCanvas);
      if (this.a != null)
      {
        this.h.setColor(-1052172);
        this.h.setAntiAlias(true);
        this.h.setTypeface(Typeface.DEFAULT_BOLD);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.h.setShadowLayer(2.0F, 0.0F, -1.0F, -5939712);
        this.h.setTextSize(this.k);
        Paint.FontMetrics localFontMetrics = this.h.getFontMetrics();
        float f1 = (localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
        float f2 = localFontMetrics.bottom;
        paramCanvas.drawText(this.a, ((GradientDrawable)localObject).getBounds().centerX(), f1 - f2 + ((GradientDrawable)localObject).getBounds().centerY(), this.h);
      }
      return;
    }
    catch (Throwable paramCanvas) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */