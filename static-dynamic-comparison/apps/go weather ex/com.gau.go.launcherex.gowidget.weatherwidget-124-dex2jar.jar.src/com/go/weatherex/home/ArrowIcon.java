package com.go.weatherex.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class ArrowIcon
  extends View
{
  private b a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private RectF h;
  private Paint i;
  private float j = 1.05F;
  private boolean k = false;
  
  public ArrowIcon(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ArrowIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ArrowIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new b(this, null);
    this.i = new Paint(35);
    this.i.setTextAlign(Paint.Align.CENTER);
    this.i.setColor(-1);
    this.h = new RectF();
    this.j *= paramContext.getResources().getDisplayMetrics().density;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (this.k)
    {
      this.a.a(135.0F);
      this.a.b(225.0F);
    }
    for (;;)
    {
      invalidate();
      return;
      this.a.a(225.0F);
      this.a.b(135.0F);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = this.g + this.c;
    float f3 = this.g - this.f + this.b;
    float f1 = this.f;
    paramCanvas.save();
    paramCanvas.rotate(this.a.a(), this.g + this.c, this.g + this.b);
    float f4 = this.j + f1 + (this.f * (float)Math.sqrt(2.0D) - f1 - this.j) * (1.0F - this.a.d());
    float f5 = this.j;
    this.h.set(f2 - f4, f3 - f5, f2 + f4, f3 + f5);
    paramCanvas.drawRect(this.h, this.i);
    paramCanvas.restore();
    f2 = this.g + this.c;
    f3 = this.g + this.b;
    paramCanvas.save();
    paramCanvas.rotate(this.a.b(), this.g + this.c, this.g + this.b);
    f4 = this.f * (float)Math.sqrt(2.0D);
    f5 = this.j;
    this.h.set(f2 - f4, f3 - f5, f2 + f4, f3 + f5);
    paramCanvas.drawRect(this.h, this.i);
    paramCanvas.restore();
    f2 = this.g + this.c;
    f3 = this.g + this.f + this.b;
    paramCanvas.save();
    paramCanvas.rotate(this.a.c(), this.g + this.c, this.g + this.b);
    f4 = this.j;
    f1 = (this.f * (float)Math.sqrt(2.0D) - f1 - this.j) * (1.0F - this.a.d()) + (f4 + f1);
    f4 = this.j;
    this.h.set(f2 - f1, f3 - f4, f2 + f1, f3 + f4);
    paramCanvas.drawRect(this.h, this.i);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = getPaddingTop();
    this.c = getPaddingLeft();
    this.d = (getWidth() - getPaddingLeft() - getPaddingRight());
    this.e = (getHeight() - getPaddingTop() - getPaddingBottom());
    this.f = (Math.min(this.d, this.e) * (float)Math.sqrt(2.0D) / 4.0F);
    this.g = (Math.min(this.d, this.e) / 2.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/ArrowIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */