package com.jiubang.core.a;

import android.graphics.Bitmap;

public class m
  extends j
{
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2);
  }
  
  private int a()
  {
    if (this.j == 1) {
      return this.k * 100 / this.h;
    }
    return Math.min((int)((this.l - this.c) * 100000L / this.h), 100000);
  }
  
  private void a(v paramv, l paraml)
  {
    if ((c()) || (this.j == 1)) {
      return;
    }
    int i3 = a();
    Bitmap localBitmap = paraml.o();
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    int i4 = paraml.a();
    int k = paraml.b();
    int i1 = paraml.f();
    int i2 = paraml.g();
    float f;
    int i5;
    switch (this.o)
    {
    default: 
      return;
    case 1: 
      i4 = e.a();
      f = i / i4;
      i5 = -i4;
      this.m = (i3 * i5 / 100000 + (this.p - i1));
      if (this.m < i5) {
        this.m %= i5;
      }
      i3 = (int)(this.m * f);
      i5 = this.m + i4;
      paramv.a(-i3, 0, i, j);
      paramv.b(i1, i2, i1 + i5, i2 + k);
      paramv.c(0, 0, -i3, j);
      paramv.d(i1 + i5, i2, i1 + i4, i2 + k);
      return;
    case 2: 
      i4 = e.a();
      f = i / i4;
      this.m = (i3 * i4 / 100000 + (this.p - i1 - i4));
      if (this.m > i4) {
        this.m %= i4;
      }
      i3 = (int)(this.m * f);
      i5 = this.m;
      paramv.a(0, 0, i - i3, j);
      paramv.b(this.m + i1, i2, i4, i2 + k);
      paramv.c(i - i3, 0, i, j);
      paramv.d(i1, i2, this.m + i1, i2 + k);
      return;
    case 3: 
      i5 = -j;
      this.n = (i3 * i5 / 100000 + (this.q - i2));
      if (this.n < i5) {
        this.n %= i5;
      }
      i3 = this.n + j;
      if (i3 < k)
      {
        paramv.a(0, -this.n, i, j);
        paramv.b(i1, i2, i1 + i4, i2 + i3);
        paramv.c(0, 0, i, k - i3);
        paramv.d(i1, i3 + i2, i1 + i4, i2 + k);
        return;
      }
      paramv.a(0, -this.n, i, -this.n + k);
      paramv.b(i1, i2, i1 + i4, i2 + k);
      return;
    }
    this.n = (i3 * j / 100000 + (this.q - i2 - k));
    if (this.n > j) {
      this.n %= j;
    }
    i3 = j - this.n;
    if (i3 < k)
    {
      paramv.a(0, 0, i, i3);
      paramv.b(i1, i2 + k - i3, i1 + i4, i2 + k);
      paramv.c(0, j - k + i3, i, j);
      paramv.d(i1, i2, i1 + i4, i2 + k - i3);
      return;
    }
    paramv.a(0, i3 - k, i, i3);
    paramv.b(i1, i2, i1 + i4, i2 + k);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.o = paramInt3;
    this.p = paramInt1;
    this.q = paramInt2;
  }
  
  protected void a(long paramLong)
  {
    this.k = 0;
    this.l = 0L;
    if (this.g == 2) {}
    c(paramLong);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.k = 0;
    this.l = 0L;
    if ((this.g == 2) && (paramLong2 % 2L == 0L)) {}
    c(paramLong1);
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    if (this.j == 1)
    {
      if (this.k == 0) {
        this.d = false;
      }
      if (!this.d) {
        break label46;
      }
    }
    label46:
    label161:
    label215:
    label272:
    do
    {
      do
      {
        do
        {
          return false;
          if (this.l != 0L) {
            break;
          }
          this.d = false;
          break;
          if (this.j == 1) {
            this.k += 1;
          }
          for (;;)
          {
            if (this.l - this.c >= this.h) {
              this.l = (this.c + this.h);
            }
            a(paramv, paraml);
            if (this.j != 1) {
              break label215;
            }
            if ((this.k == 1) || (this.k >= this.h)) {
              break label161;
            }
            if (this.a == null) {
              break;
            }
            this.a.a(this, a());
            return false;
            this.l = paramLong;
          }
        } while (this.k != this.h);
        if ((this.f < this.e) || (this.e == -1))
        {
          a(paramLong);
          this.f += 1;
          return false;
        }
        this.d = true;
        return false;
        if ((this.l - this.c <= 5L) || (this.l - this.c >= this.h)) {
          break label272;
        }
      } while (this.a == null);
      this.a.a(this, a());
      return false;
    } while (this.l - this.c < this.h);
    if ((this.f < this.e) || (this.e == -1))
    {
      long l1 = this.h;
      long l2 = f();
      l1 = (paramLong - this.l) / (l1 + l2);
      a(paramLong, l1);
      this.f = ((int)(l1 + this.f + 1L));
      return false;
    }
    this.d = true;
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */