package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public final class f
  extends ImageView
{
  private RectF a;
  private Paint b;
  private Xfermode c;
  
  public f(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    float f = getContext().getResources().getDisplayMetrics().density;
    this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    this.a = new RectF();
    this.b = new Paint();
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1509949440);
    this.b.setStrokeWidth(Math.max(1.0F, f * 1.0F));
    this.b.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = getContext().getResources().getDisplayMetrics().density;
    float f1 = 10.0F * f2;
    f2 = 1.0F * f2;
    Object localObject = getDrawable();
    if ((localObject instanceof BitmapDrawable))
    {
      Paint localPaint = ((BitmapDrawable)localObject).getPaint();
      localObject = ((Drawable)localObject).getBounds();
      this.a.set((Rect)localObject);
      if (getImageMatrix() != null) {
        getImageMatrix().mapRect(this.a);
      }
      int i = paramCanvas.saveLayer(this.a, null, 31);
      localPaint.setAntiAlias(true);
      paramCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      paramCanvas.drawRoundRect(this.a, f1, f1, localPaint);
      localObject = localPaint.getXfermode();
      localPaint.setXfermode(this.c);
      super.onDraw(paramCanvas);
      localPaint.setXfermode((Xfermode)localObject);
      paramCanvas.restoreToCount(i);
    }
    for (;;)
    {
      this.a.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.inset(f2 / 2.0F, f2 / 2.0F);
      paramCanvas.drawRoundRect(this.a, f1, f1, this.b);
      return;
      super.onDraw(paramCanvas);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */