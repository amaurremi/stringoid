package com.appbrain.e;

import com.appbrain.b.l;

public final class an
  extends l
  implements ao
{
  private int a;
  private aa b = aa.f();
  private int c;
  private int d;
  private ap e = ap.a;
  private int f;
  private boolean g;
  private Object h = "";
  
  private an g()
  {
    return new an().a(h());
  }
  
  private am h()
  {
    int j = 1;
    am localam = new am('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      am.a(localam, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      am.a(localam, this.c);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      am.b(localam, this.d);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      am.a(localam, this.e);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      am.c(localam, this.f);
      i = j;
      if ((k & 0x20) == 32) {
        i = j | 0x20;
      }
      am.a(localam, this.g);
      j = i;
      if ((k & 0x40) == 64) {
        j = i | 0x40;
      }
      am.a(localam, this.h);
      am.d(localam, j);
      return localam;
      j = 0;
    }
  }
  
  public final an a(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    return this;
  }
  
  public final an a(aa paramaa)
  {
    if (paramaa == null) {
      throw new NullPointerException();
    }
    this.b = paramaa;
    this.a |= 0x1;
    return this;
  }
  
  public final an a(am paramam)
  {
    if (paramam == am.f()) {
      return this;
    }
    aa localaa;
    if (paramam.g())
    {
      localaa = paramam.h();
      if (((this.a & 0x1) != 1) || (this.b == aa.f())) {
        break label177;
      }
    }
    label177:
    for (this.b = aa.a(this.b).a(localaa).f();; this.b = localaa)
    {
      this.a |= 0x1;
      if (paramam.i()) {
        a(paramam.j());
      }
      if (paramam.k()) {
        b(paramam.l());
      }
      if (paramam.m()) {
        a(paramam.n());
      }
      if (paramam.o()) {
        c(paramam.p());
      }
      if (paramam.q()) {
        a(paramam.r());
      }
      if (!paramam.s()) {
        break;
      }
      this.a |= 0x40;
      this.h = am.a(paramam);
      return this;
    }
  }
  
  public final an a(ap paramap)
  {
    if (paramap == null) {
      throw new NullPointerException();
    }
    this.a |= 0x8;
    this.e = paramap;
    return this;
  }
  
  public final an a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x40;
    this.h = paramString;
    return this;
  }
  
  public final an a(boolean paramBoolean)
  {
    this.a |= 0x20;
    this.g = paramBoolean;
    return this;
  }
  
  public final an b(int paramInt)
  {
    this.a |= 0x4;
    this.d = paramInt;
    return this;
  }
  
  public final an c(int paramInt)
  {
    this.a |= 0x10;
    this.f = paramInt;
    return this;
  }
  
  public final am d()
  {
    am localam = h();
    if (!localam.e()) {
      throw new com.appbrain.b.ab();
    }
    return localam;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */