package com.jiubang.core.a;

public abstract class t
  extends j
{
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected boolean s;
  protected boolean t;
  
  public t(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt8, paramInt9, paramInt6, paramInt7, paramLong1, paramLong2);
    this.i = false;
    this.m = paramInt2;
    this.o = paramInt3;
    this.n = paramInt4;
    this.p = paramInt5;
    this.q = paramInt2;
    this.r = paramInt3;
    this.s = paramBoolean1;
    this.t = paramBoolean2;
    if (paramInt7 == 1) {
      if (this.h < 1) {
        this.h = 1;
      }
    }
    while (this.h >= 1) {
      return;
    }
    this.h = 300;
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
      int i = this.m;
      int j = this.o;
      this.m = this.n;
      this.o = this.p;
      this.n = i;
      this.p = j;
    }
    c(paramLong);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.k = 0;
    this.l = 0L;
    if ((this.g == 2) && (paramLong2 % 2L == 0L))
    {
      int i = this.m;
      int j = this.o;
      this.m = this.n;
      this.o = this.p;
      this.n = i;
      this.p = j;
    }
    c(paramLong1);
  }
  
  protected abstract void a(s params, l paraml);
  
  protected final boolean a(s params, l paraml, long paramLong, v paramv)
  {
    if (this.j == 1) {
      if (this.k == 0)
      {
        this.q = this.m;
        this.r = this.o;
        this.d = false;
      }
    }
    while (this.d)
    {
      return false;
      if (this.l == 0L)
      {
        this.q = this.m;
        this.r = this.o;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */