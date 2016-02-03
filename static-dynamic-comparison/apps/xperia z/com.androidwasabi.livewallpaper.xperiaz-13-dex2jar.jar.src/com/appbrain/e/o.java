package com.appbrain.e;

import com.appbrain.b.l;

public final class o
  extends l
  implements p
{
  private int a;
  private Object b = "";
  private Object c = "";
  private boolean d;
  
  private o f()
  {
    return new o().a(g());
  }
  
  private n g()
  {
    int j = 1;
    n localn = new n('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      n.a(localn, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      n.b(localn, this.c);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      n.a(localn, this.d);
      n.a(localn, j);
      return localn;
      j = 0;
    }
  }
  
  public final o a(n paramn)
  {
    if (paramn == n.f()) {}
    do
    {
      return this;
      if (paramn.g())
      {
        this.a |= 0x1;
        this.b = n.a(paramn);
      }
      if (paramn.i())
      {
        this.a |= 0x2;
        this.c = n.b(paramn);
      }
    } while (!paramn.k());
    boolean bool = paramn.l();
    this.a |= 0x4;
    this.d = bool;
    return this;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */