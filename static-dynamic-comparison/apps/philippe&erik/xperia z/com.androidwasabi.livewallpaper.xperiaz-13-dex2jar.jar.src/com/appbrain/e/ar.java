package com.appbrain.e;

import com.appbrain.b.l;

public final class ar
  extends l
  implements as
{
  private int a;
  private aa b = aa.f();
  private Object c = "";
  private af d = af.a;
  private long e;
  private long f;
  private Object g = "";
  private Object h = "";
  private boolean i;
  private int j;
  
  private ar h()
  {
    return new ar().a(f());
  }
  
  public final ar a(int paramInt)
  {
    this.a |= 0x100;
    this.j = paramInt;
    return this;
  }
  
  public final ar a(long paramLong)
  {
    this.a |= 0x8;
    this.e = paramLong;
    return this;
  }
  
  public final ar a(aa paramaa)
  {
    if (paramaa == null) {
      throw new NullPointerException();
    }
    this.b = paramaa;
    this.a |= 0x1;
    return this;
  }
  
  public final ar a(af paramaf)
  {
    if (paramaf == null) {
      throw new NullPointerException();
    }
    this.a |= 0x4;
    this.d = paramaf;
    return this;
  }
  
  public final ar a(aq paramaq)
  {
    if (paramaq == aq.f()) {
      return this;
    }
    aa localaa;
    if (paramaq.g())
    {
      localaa = paramaq.h();
      if (((this.a & 0x1) != 1) || (this.b == aa.f())) {
        break label228;
      }
    }
    label228:
    for (this.b = aa.a(this.b).a(localaa).f();; this.b = localaa)
    {
      this.a |= 0x1;
      if (paramaq.i())
      {
        this.a |= 0x2;
        this.c = aq.b(paramaq);
      }
      if (paramaq.k()) {
        a(paramaq.l());
      }
      if (paramaq.m()) {
        a(paramaq.n());
      }
      if (paramaq.o()) {
        b(paramaq.p());
      }
      if (paramaq.q())
      {
        this.a |= 0x20;
        this.g = aq.c(paramaq);
      }
      if (paramaq.r())
      {
        this.a |= 0x40;
        this.h = aq.d(paramaq);
      }
      if (paramaq.t()) {
        a(paramaq.u());
      }
      if (!paramaq.v()) {
        break;
      }
      a(paramaq.w());
      return this;
    }
  }
  
  public final ar a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x2;
    this.c = paramString;
    return this;
  }
  
  public final ar a(boolean paramBoolean)
  {
    this.a |= 0x80;
    this.i = paramBoolean;
    return this;
  }
  
  public final ar b(long paramLong)
  {
    this.a |= 0x10;
    this.f = paramLong;
    return this;
  }
  
  public final ar b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x20;
    this.g = paramString;
    return this;
  }
  
  public final ar c(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x40;
    this.h = paramString;
    return this;
  }
  
  public final aq d()
  {
    aq localaq = f();
    if (!localaq.e()) {
      throw new com.appbrain.b.ab();
    }
    return localaq;
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final aq f()
  {
    int m = 1;
    aq localaq = new aq('\000');
    int n = this.a;
    if ((n & 0x1) == 1) {}
    for (;;)
    {
      aq.a(localaq, this.b);
      int k = m;
      if ((n & 0x2) == 2) {
        k = m | 0x2;
      }
      aq.a(localaq, this.c);
      m = k;
      if ((n & 0x4) == 4) {
        m = k | 0x4;
      }
      aq.a(localaq, this.d);
      k = m;
      if ((n & 0x8) == 8) {
        k = m | 0x8;
      }
      aq.a(localaq, this.e);
      m = k;
      if ((n & 0x10) == 16) {
        m = k | 0x10;
      }
      aq.b(localaq, this.f);
      k = m;
      if ((n & 0x20) == 32) {
        k = m | 0x20;
      }
      aq.b(localaq, this.g);
      m = k;
      if ((n & 0x40) == 64) {
        m = k | 0x40;
      }
      aq.c(localaq, this.h);
      k = m;
      if ((n & 0x80) == 128) {
        k = m | 0x80;
      }
      aq.a(localaq, this.i);
      m = k;
      if ((n & 0x100) == 256) {
        m = k | 0x100;
      }
      aq.a(localaq, this.j);
      aq.b(localaq, m);
      return localaq;
      m = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */