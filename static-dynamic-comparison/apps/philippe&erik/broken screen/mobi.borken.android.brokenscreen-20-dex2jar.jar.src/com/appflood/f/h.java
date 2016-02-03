package com.appflood.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import com.appflood.c.d;

public final class h
  extends View
{
  private Paint a;
  private Paint b;
  private Paint c;
  private float d;
  private GradientDrawable e = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { -15254166, -12543784 });
  private int f = 25;
  
  public h(Context paramContext, float paramFloat)
  {
    super(paramContext);
    this.f = ((int)(this.f * paramFloat));
    this.b = new Paint();
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setTextSize(this.f);
    this.b.setAntiAlias(true);
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    this.b.setColor(-1052172);
    this.b.setShadowLayer(2.0F, 0.0F, -1.0F, -12558972);
    paramContext = this.b.getFontMetrics();
    this.d = ((paramContext.bottom - paramContext.top) / 2.0F - paramContext.bottom);
    this.c = new Paint();
    this.c.setColor(-16767916);
    this.a = new Paint();
    this.a.setColor(-16379600);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.a);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight() + 1, this.c);
      this.e.setBounds(0, 0, getWidth(), getHeight());
      this.e.draw(paramCanvas);
      paramCanvas.drawText(d.b, getWidth() / 2, getHeight() / 2 + this.d, this.b);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */