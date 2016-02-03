package com.appbrain.e;

import com.appbrain.b.ab;
import com.appbrain.b.l;

public final class c
  extends l
  implements d
{
  private int a;
  private int b;
  private int c;
  private Object d = "";
  
  private c g()
  {
    return new c().a(h());
  }
  
  private b h()
  {
    int j = 1;
    b localb = new b('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      b.a(localb, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      b.b(localb, this.c);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      b.a(localb, this.d);
      b.c(localb, j);
      return localb;
      j = 0;
    }
  }
  
  public final c a(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    return this;
  }
  
  public final c a(b paramb)
  {
    if (paramb == b.f()) {}
    do
    {
      return this;
      if (paramb.g())
      {
        int i = paramb.h();
        this.a |= 0x1;
        this.b = i;
      }
      if (paramb.i()) {
        a(paramb.j());
      }
    } while (!paramb.k());
    this.a |= 0x4;
    this.d = b.a(paramb);
    return this;
  }
  
  public final c a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x4;
    this.d = paramString;
    return this;
  }
  
  public final b d()
  {
    b localb = h();
    if (!localb.e()) {
      throw new ab();
    }
    return localb;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */