package com.jiubang.core.a;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class p
  extends j
{
  private ArrayList m = new ArrayList();
  private boolean n = true;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong1, paramLong2);
  }
  
  private int a()
  {
    if (this.j == 1) {
      return this.k * 100 / this.h;
    }
    q localq;
    if (this.n)
    {
      j = (int)(this.l - this.c);
      k = this.m.size();
      i = 0;
      while (i < k)
      {
        localq = (q)this.m.get(i);
        if ((localq.b <= j) && (j < localq.c)) {
          return i;
        }
        i += 1;
      }
      return 0;
    }
    int j = (int)(this.h - (this.l - this.c));
    int k = this.m.size();
    int i = k - 1;
    while (i >= 0)
    {
      localq = (q)this.m.get(i);
      if ((localq.b <= j) && (j < localq.c)) {
        return i;
      }
      i -= 1;
    }
    return k - 1;
  }
  
  private q a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.size())) {
      return (q)this.m.get(paramInt);
    }
    return null;
  }
  
  private void a(s params, l paraml)
  {
    boolean bool = true;
    params = a(a());
    if (params != null)
    {
      paraml.a(params.a);
      if (params.d != 1) {
        break label37;
      }
    }
    for (;;)
    {
      paraml.a(bool);
      return;
      label37:
      bool = false;
    }
  }
  
  public q a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    q localq = new q(this);
    localq.a = paramBitmap;
    localq.b = paramInt1;
    localq.c = paramInt2;
    localq.d = paramInt3;
    this.m.add(localq);
    return localq;
  }
  
  protected void a(long paramLong)
  {
    this.k = 0;
    this.l = 0L;
    if (this.g == 2) {}
    for (this.n = false;; this.n = true)
    {
      c(paramLong);
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.k = 0;
    this.l = 0L;
    if ((this.g == 2) && (paramLong2 % 2L == 0L)) {}
    for (this.n = false;; this.n = true)
    {
      c(paramLong1);
      return;
    }
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    if (this.j == 1) {
      if (this.k == 0) {
        this.d = false;
      }
    }
    while (this.d)
    {
      return false;
      if (this.l == 0L) {
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
        break label216;
      }
      if ((this.k == 1) || (this.k >= this.h)) {
        break label160;
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
      label160:
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
          label216:
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */