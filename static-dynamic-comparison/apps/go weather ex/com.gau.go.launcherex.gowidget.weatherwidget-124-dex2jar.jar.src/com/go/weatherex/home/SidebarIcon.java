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
import android.view.animation.AccelerateDecelerateInterpolator;

public class SidebarIcon
  extends View
{
  private af a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private RectF h;
  private Paint i;
  private ag j;
  private boolean k = false;
  private boolean l = false;
  private float m = 1.05F;
  
  public SidebarIcon(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SidebarIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SidebarIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new af(this, null);
    this.i = new Paint(35);
    this.i.setTextAlign(Paint.Align.CENTER);
    this.i.setColor(-1);
    this.h = new RectF();
    this.m *= paramContext.getResources().getDisplayMetrics().density;
    this.j = new ag(this, null);
    this.j.setStartOffset(1L);
    this.j.setDuration(450L);
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a()
  {
    if ((!this.j.hasStarted()) || (this.j.hasEnded()))
    {
      this.j.setAnimationListener(null);
      clearAnimation();
      this.k = false;
      if (!this.l) {
        this.a.d(0.0F);
      }
      for (;;)
      {
        startAnimation(this.j);
        return;
        this.a.d(1.0F);
      }
    }
    this.j.setAnimationListener(new ac(this));
  }
  
  public void b()
  {
    if ((!this.j.hasStarted()) || (this.j.hasEnded()))
    {
      if (this.l) {
        return;
      }
      this.j.setAnimationListener(null);
      clearAnimation();
      this.k = false;
      this.a.d(0.0F);
      startAnimation(this.j);
      return;
    }
    if (this.l)
    {
      this.j.setAnimationListener(new ad(this));
      return;
    }
    this.j.setAnimationListener(null);
  }
  
  public void c()
  {
    if ((!this.j.hasStarted()) || (this.j.hasEnded()))
    {
      if (!this.l) {
        return;
      }
      this.j.setAnimationListener(null);
      clearAnimation();
      this.k = false;
      this.a.d(1.0F);
      startAnimation(this.j);
      return;
    }
    if (!this.l)
    {
      this.j.setAnimationListener(new ae(this));
      return;
    }
    this.j.setAnimationListener(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = this.g + this.c;
    float f3 = this.g - this.f + this.b;
    float f1 = this.f;
    paramCanvas.save();
    paramCanvas.rotate(this.a.a(), this.g + this.c, this.g + this.b);
    float f4 = this.m + f1 + (this.f * (float)Math.sqrt(2.0D) - f1 - this.m) * (1.0F - this.a.d());
    float f5 = this.m;
    this.h.set(f2 - f4, f3 - f5, f2 + f4, f3 + f5);
    paramCanvas.drawRect(this.h, this.i);
    paramCanvas.restore();
    f2 = this.g + this.c;
    f3 = this.g + this.b;
    paramCanvas.save();
    paramCanvas.rotate(this.a.b(), this.g + this.c, this.g + this.b);
    f4 = this.f * (float)Math.sqrt(2.0D);
    f5 = this.m;
    this.h.set(f2 - f4, f3 - f5, f2 + f4, f3 + f5);
    paramCanvas.drawRect(this.h, this.i);
    paramCanvas.restore();
    f2 = this.g + this.c;
    f3 = this.g + this.f + this.b;
    paramCanvas.save();
    paramCanvas.rotate(this.a.c(), this.g + this.c, this.g + this.b);
    f4 = this.m;
    f1 = (this.f * (float)Math.sqrt(2.0D) - f1 - this.m) * (1.0F - this.a.d()) + (f4 + f1);
    f4 = this.m;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/SidebarIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */