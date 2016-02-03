package com.jiubang.core.a;

import android.graphics.Matrix;

public class x
  extends j
{
  private volatile float m;
  private volatile float n;
  private volatile float o;
  private volatile float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private int u;
  private int v;
  
  public x(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, float paramFloat5, int paramInt3, float paramFloat6, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt6, paramInt7, paramInt4, paramInt5, paramLong1, paramLong2);
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.o = paramFloat3;
    this.p = paramFloat4;
    this.u = paramInt2;
    this.v = paramInt3;
    this.q = paramFloat5;
    this.r = paramFloat6;
    this.s = 0.0F;
    this.t = 0.0F;
    this.j = paramInt5;
    if (paramInt5 == 1) {
      if (this.h < 1) {
        this.h = 1;
      }
    }
    while (this.h >= 1) {
      return;
    }
    this.h = 300;
  }
  
  private void a(s params, l paraml)
  {
    int i = a();
    float f1 = this.n;
    float f2 = this.m;
    float f3 = this.m;
    this.s = ((f1 - f2) * (i / 100000.0F) + f3);
    f1 = this.p;
    f2 = this.o;
    f3 = this.o;
    this.t = (i / 100000.0F * (f1 - f2) + f3);
    i = paraml.f();
    int j = paraml.g();
    if (this.u == 1)
    {
      f1 = i + this.q;
      if (this.v != 1) {
        break label151;
      }
    }
    label151:
    for (f2 = j + this.r;; f2 = this.r)
    {
      params.a().postScale(this.s, this.t, f1, f2);
      return;
      f1 = this.q;
      break;
    }
  }
  
  public int a()
  {
    int i = 100000;
    if (this.j == 1) {
      i = this.k * 100 / this.h;
    }
    int j;
    do
    {
      return i;
      j = (int)((this.l - this.c) * 100000L / this.h);
    } while (j > 100000);
    return j;
  }
  
  protected void a(long paramLong)
  {
    this.k = 0;
    this.l = 0L;
    if (this.g == 2)
    {
      float f1 = this.m;
      float f2 = this.o;
      this.m = this.n;
      this.o = this.p;
      this.n = f1;
      this.p = f2;
    }
    c(paramLong);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.k = 0;
    this.l = 0L;
    if ((this.g == 2) && (paramLong2 % 2L == 0L))
    {
      float f1 = this.m;
      float f2 = this.o;
      this.m = this.n;
      this.o = this.p;
      this.n = f1;
      this.p = f2;
    }
    c(paramLong1);
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    if (this.j == 1) {
      if (this.k == 0)
      {
        this.s = this.m;
        this.t = this.o;
        this.d = false;
      }
    }
    while (this.d)
    {
      return false;
      if (this.l == 0L)
      {
        this.s = this.m;
        this.t = this.o;
        this.d = false;
      }
    }
    if (this.j == 1)
    {
      this.k += 1;
      if (this.l - this.c >= this.h) {
        this.l = (this.c + this.h);
      }
      a(params, paraml);
      if (this.j != 1) {
        break label248;
      }
      if ((this.k == 1) || (this.k >= this.h)) {
        break label192;
      }
      if (this.a != null) {
        this.a.a(this, a());
      }
    }
    for (;;)
    {
      return true;
      this.l = paramLong;
      break;
      label192:
      if (this.k == this.h) {
        if ((this.f < this.e) || (this.e == -1))
        {
          a(paramLong);
          this.f += 1;
        }
        else
        {
          this.d = true;
          continue;
          label248:
          if ((this.l - this.c > 5L) && (this.l - this.c < this.h))
          {
            if (this.a != null) {
              this.a.a(this, a());
            }
          }
          else if (this.l - this.c >= this.h) {
            if ((this.f < this.e) || (this.e == -1))
            {
              long l = this.h + f();
              paramLong = (paramLong - this.l) / l;
              a(l * paramLong + this.l, paramLong);
              this.f = ((int)(this.f + paramLong + 1L));
            }
            else
            {
              this.d = true;
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */