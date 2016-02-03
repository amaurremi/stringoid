package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public abstract class b
  extends LinearLayout
  implements g.b
{
  protected View.OnClickListener a = null;
  private RectF b = new RectF();
  private Paint c = null;
  private Paint d = null;
  private RectF e = null;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    if (this.d == null)
    {
      this.d = new Paint();
      this.d.setStyle(Paint.Style.FILL);
      this.d.setAntiAlias(true);
    }
    if ((this.e == null) || (Math.abs(paramRectF.top - this.e.top) > 0.1F) || (Math.abs(paramRectF.bottom - this.e.bottom) > 0.1F)) {
      this.d.setShader(new LinearGradient(0.0F, paramRectF.top, 0.0F, paramRectF.bottom, -1447447, -2302756, Shader.TileMode.CLAMP));
    }
    paramCanvas.drawRect(paramRectF, this.d);
  }
  
  private void b(Canvas paramCanvas, RectF paramRectF)
  {
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }
    this.c.setColor(-723724);
    paramCanvas.drawRect(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.top + 1.0F, this.c);
    this.c.setColor(-3355444);
    paramCanvas.drawRect(paramRectF.left, paramRectF.bottom - 1.0F, paramRectF.right, paramRectF.bottom, this.c);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.b.set(0.0F, 0.0F, getWidth(), a());
    a(paramCanvas, this.b);
    b(paramCanvas, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */