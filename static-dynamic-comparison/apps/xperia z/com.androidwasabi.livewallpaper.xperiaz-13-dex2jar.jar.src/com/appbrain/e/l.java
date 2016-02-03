package com.appbrain.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l
  extends com.appbrain.b.l
  implements m
{
  private int a;
  private List b = Collections.emptyList();
  private List c = Collections.emptyList();
  private boolean d;
  private boolean e;
  
  private l g()
  {
    return new l().a(d());
  }
  
  public final l a(k paramk)
  {
    if (paramk == k.f()) {
      return this;
    }
    if (!k.b(paramk).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = k.b(paramk);
        this.a &= 0xFFFFFFFE;
      }
    }
    else {
      label52:
      if (!k.c(paramk).isEmpty())
      {
        if (!this.c.isEmpty()) {
          break label204;
        }
        this.c = k.c(paramk);
        this.a &= 0xFFFFFFFD;
      }
    }
    for (;;)
    {
      if (paramk.k())
      {
        bool = paramk.l();
        this.a |= 0x4;
        this.d = bool;
      }
      if (!paramk.m()) {
        break;
      }
      boolean bool = paramk.n();
      this.a |= 0x8;
      this.e = bool;
      return this;
      if ((this.a & 0x1) != 1)
      {
        this.b = new ArrayList(this.b);
        this.a |= 0x1;
      }
      this.b.addAll(k.b(paramk));
      break label52;
      label204:
      if ((this.a & 0x2) != 2)
      {
        this.c = new ArrayList(this.c);
        this.a |= 0x2;
      }
      this.c.addAll(k.c(paramk));
    }
  }
  
  public final k d()
  {
    int i = 1;
    k localk = new k('\000');
    int k = this.a;
    if ((this.a & 0x1) == 1)
    {
      this.b = Collections.unmodifiableList(this.b);
      this.a &= 0xFFFFFFFE;
    }
    k.a(localk, this.b);
    if ((this.a & 0x2) == 2)
    {
      this.c = Collections.unmodifiableList(this.c);
      this.a &= 0xFFFFFFFD;
    }
    k.b(localk, this.c);
    if ((k & 0x4) == 4) {}
    for (;;)
    {
      k.a(localk, this.d);
      int j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x2;
      }
      k.b(localk, this.e);
      k.a(localk, j);
      return localk;
      i = 0;
    }
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */