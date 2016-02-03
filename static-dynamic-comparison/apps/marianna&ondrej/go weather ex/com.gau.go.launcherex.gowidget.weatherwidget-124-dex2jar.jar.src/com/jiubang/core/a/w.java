package com.jiubang.core.a;

import android.graphics.Matrix;

public class w
  extends j
{
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private int r;
  private int s;
  private w t;
  
  public w(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, int paramInt3, float paramFloat4, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt6, paramInt7, paramInt4, paramInt5, paramLong1, paramLong2);
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.q = 0.0F;
    this.o = paramFloat3;
    this.p = paramFloat4;
    this.r = paramInt2;
    this.s = paramInt3;
    this.j = paramInt5;
    if (paramInt5 == 1) {
      if (this.h < 1) {
        this.h = 1;
      }
    }
    for (;;)
    {
      this.t = new w(paramInt1, paramInt4, paramInt5, paramInt6, paramInt7, paramLong1, paramLong2);
      this.t.m = this.m;
      this.t.n = this.n;
      this.t.q = this.q;
      this.t.o = this.o;
      this.t.p = this.p;
      this.t.r = this.r;
      this.t.s = this.s;
      this.t.j = this.j;
      this.t.h = this.h;
      return;
      if (this.h < 1) {
        this.h = 300;
      }
    }
  }
  
  public w(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt4, paramInt5, paramInt2, paramInt3, paramLong1, paramLong2);
  }
  
  private void a(s params, l paraml)
  {
    int i = a();
    float f1 = this.n;
    float f2 = this.m;
    float f3 = this.m;
    this.q = (i / 100000.0F * (f1 - f2) + f3);
    i = paraml.f();
    int j = paraml.g();
    if (this.r == 1)
    {
      f1 = i + this.o;
      if (this.s != 1) {
        break label112;
      }
    }
    label112:
    for (f2 = j + this.p;; f2 = this.p)
    {
      params.a().postRotate(this.q, f1, f2);
      return;
      f1 = this.o;
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
      float f = this.m;
      this.m = this.n;
      this.n = f;
    }
    c(paramLong);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.k = 0;
    this.l = 0L;
    if ((this.g == 2) && (paramLong2 % 2L == 0L))
    {
      float f = this.m;
      this.m = this.n;
      this.n = f;
    }
    c(paramLong1);
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    if (this.j == 1) {
      if (this.k == 0)
      {
        this.q = this.m;
        this.d = false;
      }
    }
    while (this.d)
    {
      return false;
      if (this.l == 0L)
      {
        this.q = this.m;
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
        break label260;
      }
      if ((this.k == 1) || (this.k >= this.h)) {
        break label176;
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
      label176:
      if (this.k == this.h)
      {
        long l;
        if ((this.f < this.e) || (this.e == -1))
        {
          l = this.h + f();
          a(l * ((paramLong - this.l) / l) + this.l);
          this.f += 1;
        }
        else
        {
          this.d = true;
          continue;
          label260:
          if ((this.l - this.c > 5L) && (this.l - this.c < this.h))
          {
            if (this.a != null) {
              this.a.a(this, a());
            }
          }
          else if (this.l - this.c >= this.h) {
            if ((this.f < this.e) || (this.e == -1))
            {
              l = this.h + f();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */