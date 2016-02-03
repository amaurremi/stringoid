package com.gau.go.launcherex.gowidget.weather.scroller;

import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

abstract class g
{
  protected static final Interpolator k = new j();
  protected static final Interpolator l = new OvershootInterpolator(0.0F);
  private long a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected float h;
  protected boolean i = false;
  protected long j;
  private int m;
  private float n;
  private int o;
  private float p;
  
  public final int a(long paramLong)
  {
    if (this.a == -1L)
    {
      this.a = paramLong;
      return 0;
    }
    return (int)(paramLong - this.a);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = 1;
    this.p = 0.0F;
    this.m = paramInt3;
    this.a = -1L;
    this.b = paramInt1;
    this.d = paramInt2;
    this.c = (paramInt1 + paramInt2);
    this.n = (1.0F / this.m);
    this.j = (AnimationUtils.currentAnimationTimeMillis() + 100L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    return false;
  }
  
  protected void b(float paramFloat) {}
  
  public final boolean d()
  {
    return this.g == 0;
  }
  
  protected void e(int paramInt) {}
  
  protected final boolean e()
  {
    return this.o >= this.m;
  }
  
  public void f()
  {
    if (this.g == 1) {
      this.g = 0;
    }
  }
  
  public void f(int paramInt)
  {
    this.f = paramInt;
  }
  
  public boolean g()
  {
    switch (this.g)
    {
    }
    do
    {
      return false;
      l1 = AnimationUtils.currentAnimationTimeMillis();
      this.o = a(l1);
      if (this.o >= this.m)
      {
        this.o = this.m;
        if ((!this.i) || (this.h <= 0.0F)) {
          this.g = 0;
        }
      }
      if ((this.i) && (l1 >= this.j))
      {
        i1 = (int)(l1 - this.j);
        this.j = l1;
        this.h = Math.max(0.0F, this.h - i1 / 200.0F);
        i();
      }
      this.p = (this.o * this.n);
      b(this.p);
      return true;
    } while ((!this.i) || (this.h >= 1.0F));
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    int i1 = (int)(l1 - this.j);
    this.j = l1;
    float f1 = this.h;
    this.h = Math.min(1.0F, i1 / 200.0F + f1);
    i();
    return true;
  }
  
  protected void h()
  {
    if (this.g == 0) {
      this.j = AnimationUtils.currentAnimationTimeMillis();
    }
    this.g = 2;
  }
  
  protected void i() {}
  
  public float j()
  {
    if (this.i)
    {
      float f1 = 1.0F - this.h;
      return 1.0F - f1 * f1;
    }
    return 0.0F;
  }
  
  public final int k()
  {
    return this.e;
  }
  
  public final int l()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */