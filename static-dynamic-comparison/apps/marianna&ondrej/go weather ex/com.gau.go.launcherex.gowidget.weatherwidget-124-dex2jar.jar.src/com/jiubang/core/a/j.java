package com.jiubang.core.a;

public class j
{
  protected a a;
  protected long b;
  protected long c;
  protected boolean d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected boolean i;
  protected int j;
  protected int k;
  protected long l;
  private int m;
  private int n;
  private boolean o;
  private long p;
  private long q;
  private long r;
  private long s;
  private boolean t;
  private int u;
  private boolean v = false;
  private j w;
  
  public j(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("tickCount must > 0");
    }
    this.m = paramInt;
    this.n = paramInt;
    this.u = 0;
    this.v = true;
  }
  
  public j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("tickCount must > 0");
    }
    this.m = paramInt1;
    this.n = paramInt1;
    this.e = paramInt3;
    this.u = 0;
    this.v = true;
    this.j = paramInt5;
    this.h = paramInt4;
    this.g = paramInt2;
    this.f = 0;
    this.r = paramLong1;
    this.b = paramLong1;
    this.q = paramLong2;
    if (this.b > 0L) {
      this.t = true;
    }
    this.w = new j(paramInt1);
    this.w.m = this.m;
    this.w.n = this.n;
    this.w.e = this.e;
    this.w.u = this.u;
    this.w.v = this.v;
    this.w.j = this.j;
    this.w.h = this.h;
    this.w.g = this.g;
    this.w.f = this.f;
    this.w.r = this.r;
    this.w.b = this.b;
    this.w.q = this.q;
    this.w.t = this.t;
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    return false;
  }
  
  public void b(long paramLong)
  {
    this.o = false;
    if (this.v)
    {
      this.b = this.r;
      if ((this.j == 1) && (this.b > 0L))
      {
        this.s = 0L;
        this.t = true;
      }
    }
    for (;;)
    {
      if ((!this.t) && (this.c == 0L))
      {
        this.c = paramLong;
        if (this.a != null) {
          this.a.a(this);
        }
      }
      return;
      if ((this.j == 2) && (this.b > 0L))
      {
        this.p = paramLong;
        this.t = true;
        continue;
        this.b = this.q;
        if ((this.j == 1) && (this.b > 0L))
        {
          this.s = 0L;
          this.t = true;
        }
        else if ((this.j == 2) && (this.b > 0L))
        {
          this.p = paramLong;
          this.t = true;
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.t;
  }
  
  public boolean b(s params, l paraml, long paramLong, v paramv)
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      long l1;
      try
      {
        bool2 = this.o;
        if (bool2)
        {
          bool1 = false;
          return bool1;
        }
        if (!b()) {
          break label257;
        }
        if (this.p == 0L) {
          b(paramLong);
        }
        if (this.j == 1)
        {
          this.s += 1L;
          if (this.s >= this.b) {
            this.t = false;
          }
        }
        else if (this.j == 2)
        {
          long l2 = paramLong - this.p;
          if (l2 >= this.b) {
            if (l2 > this.b + this.h)
            {
              l1 = l2;
              if (this.b == this.r)
              {
                l1 = l2 - (this.b + this.h);
                this.b = this.q;
              }
              l1 %= (this.b + this.h);
              if (l1 >= this.b)
              {
                this.t = false;
                this.c = (this.p + this.b);
                this.p = 0L;
              }
            }
          }
        }
      }
      finally {}
      this.p = (paramLong - l1);
      break label353;
      this.t = false;
      this.c = (this.p + this.b);
      this.p = 0L;
      break label353;
      label257:
      if (this.c == 0L)
      {
        this.c = paramLong;
        if (this.a != null) {
          this.a.a(this);
        }
      }
      this.u += 1;
      if (this.u < this.n)
      {
        bool1 = false;
      }
      else
      {
        this.u = 0;
        bool2 = c(params, paraml, paramLong, paramv);
        if (this.v)
        {
          this.v = false;
        }
        else
        {
          bool1 = bool2;
          continue;
          label353:
          bool1 = false;
        }
      }
    }
  }
  
  public void c(long paramLong)
  {
    this.u = 0;
    this.c = 0L;
    b(paramLong);
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  protected boolean c(s params, l paraml, long paramLong, v paramv)
  {
    boolean bool = false;
    if (a(params, paraml, paramLong, paramv)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    return this.f != this.e;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public long f()
  {
    return this.q;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */