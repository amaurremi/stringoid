package com.gau.go.launcherex.gowidget.weather.scroller;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;

class b
  extends h
{
  boolean a = true;
  
  public b(i parami)
  {
    super(parami);
    this.X = true;
  }
  
  static final int a(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = paramInt1 + paramInt2;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt1 < paramInt2);
    return paramInt1 - paramInt2;
  }
  
  public int a()
  {
    return a(this.F, this.A);
  }
  
  public void a(float paramFloat)
  {
    if (this.v <= 0) {}
    while (this.z == 0.5F) {
      return;
    }
    f();
    this.z = 0.5F;
    this.r = (-this.D / 2);
    this.s = (this.v + this.r);
    if (this.s > this.r) {}
    for (paramFloat = 1.0F / (this.s - this.r);; paramFloat = 0.0F)
    {
      this.w = paramFloat;
      a(a() * this.D);
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    int i = paramInt;
    if (this.A > 1)
    {
      if (paramInt >= this.r) {
        break label31;
      }
      i = paramInt + this.v;
    }
    for (;;)
    {
      super.a(i);
      return;
      label31:
      i = paramInt;
      if (paramInt >= this.s) {
        i = paramInt - this.v;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i;
    if ((paramInt1 > this.E) && ((paramInt1 - this.E) * 2 > this.A)) {
      i = paramInt1 - this.A;
    }
    for (;;)
    {
      super.a(i, paramInt2, paramInterpolator);
      return;
      i = paramInt1;
      if (paramInt1 < this.E)
      {
        i = paramInt1;
        if ((this.E - paramInt1) * 2 > this.A) {
          i = paramInt1 + this.A;
        }
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    super.a(paramDrawable);
    if (this.aa != null)
    {
      this.ab = new Paint();
      this.a = true;
      return;
    }
    this.ab = null;
    this.a = false;
  }
  
  public int b()
  {
    int j = this.E;
    int i = j;
    if (r() > 0) {
      i = j - 1;
    }
    j = a(i, this.A);
    if ((this.A < 2) && (j != i)) {
      return -1;
    }
    return j;
  }
  
  protected int b(int paramInt)
  {
    paramInt = super.b(paramInt);
    if ((paramInt >= 0) && (paramInt < this.A)) {
      return paramInt;
    }
    return 0;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, this.q);
  }
  
  public int c()
  {
    int j = this.E;
    int k = r();
    if (k == 0) {
      return -1;
    }
    int i = j;
    if (k < 0) {
      i = j + 1;
    }
    j = a(i, this.A);
    if ((this.A < 2) && (j != i)) {
      return -1;
    }
    return j;
  }
  
  protected int c(int paramInt)
  {
    int i;
    if (this.A < 2) {
      i = super.c(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.e + paramInt;
      if (j < this.r) {
        return paramInt + this.v;
      }
      i = paramInt;
    } while (j < this.s);
    return paramInt - this.v;
  }
  
  protected int d(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */