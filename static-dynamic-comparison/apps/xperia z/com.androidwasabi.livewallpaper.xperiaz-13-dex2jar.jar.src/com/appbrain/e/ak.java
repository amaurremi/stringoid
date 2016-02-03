package com.appbrain.e;

import com.appbrain.b.ac;
import com.appbrain.b.l;
import com.appbrain.b.p;
import com.appbrain.b.q;

public final class ak
  extends l
  implements al
{
  private int a;
  private Object b = "";
  private long c;
  private q d = p.a;
  
  private ak f()
  {
    return new ak().a(g());
  }
  
  private aj g()
  {
    int i = 1;
    aj localaj = new aj('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      aj.a(localaj, this.b);
      int j = i;
      if ((k & 0x2) == 2) {
        j = i | 0x2;
      }
      aj.a(localaj, this.c);
      if ((this.a & 0x4) == 4)
      {
        this.d = new ac(this.d);
        this.a &= 0xFFFFFFFB;
      }
      aj.a(localaj, this.d);
      aj.a(localaj, j);
      return localaj;
      i = 0;
    }
  }
  
  public final ak a(aj paramaj)
  {
    if (paramaj == aj.f()) {}
    do
    {
      return this;
      if (paramaj.g())
      {
        this.a |= 0x1;
        this.b = aj.a(paramaj);
      }
      if (paramaj.h())
      {
        long l = paramaj.i();
        this.a |= 0x2;
        this.c = l;
      }
    } while (aj.b(paramaj).isEmpty());
    if (this.d.isEmpty())
    {
      this.d = aj.b(paramaj);
      this.a &= 0xFFFFFFFB;
      return this;
    }
    if ((this.a & 0x4) != 4)
    {
      this.d = new p(this.d);
      this.a |= 0x4;
    }
    this.d.addAll(aj.b(paramaj));
    return this;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */