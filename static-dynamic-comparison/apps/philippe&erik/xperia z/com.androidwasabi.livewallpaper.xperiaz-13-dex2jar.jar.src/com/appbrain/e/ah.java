package com.appbrain.e;

import com.appbrain.b.ac;
import com.appbrain.b.l;
import com.appbrain.b.p;
import com.appbrain.b.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ah
  extends l
  implements ai
{
  private int a;
  private q b = p.a;
  private q c = p.a;
  private q d = p.a;
  private q e = p.a;
  private q f = p.a;
  private q g = p.a;
  private List h = Collections.emptyList();
  private Object i = "";
  private boolean j;
  private q k = p.a;
  private List l = Collections.emptyList();
  
  private ah f()
  {
    return new ah().a(g());
  }
  
  private ag g()
  {
    int m = 1;
    ag localag = new ag('\000');
    int i1 = this.a;
    if ((this.a & 0x1) == 1)
    {
      this.b = new ac(this.b);
      this.a &= 0xFFFFFFFE;
    }
    ag.a(localag, this.b);
    if ((this.a & 0x2) == 2)
    {
      this.c = new ac(this.c);
      this.a &= 0xFFFFFFFD;
    }
    ag.b(localag, this.c);
    if ((this.a & 0x4) == 4)
    {
      this.d = new ac(this.d);
      this.a &= 0xFFFFFFFB;
    }
    ag.c(localag, this.d);
    if ((this.a & 0x8) == 8)
    {
      this.e = new ac(this.e);
      this.a &= 0xFFFFFFF7;
    }
    ag.d(localag, this.e);
    if ((this.a & 0x10) == 16)
    {
      this.f = new ac(this.f);
      this.a &= 0xFFFFFFEF;
    }
    ag.e(localag, this.f);
    if ((this.a & 0x20) == 32)
    {
      this.g = new ac(this.g);
      this.a &= 0xFFFFFFDF;
    }
    ag.f(localag, this.g);
    if ((this.a & 0x40) == 64)
    {
      this.h = Collections.unmodifiableList(this.h);
      this.a &= 0xFFFFFFBF;
    }
    ag.a(localag, this.h);
    if ((i1 & 0x80) == 128) {}
    for (;;)
    {
      ag.a(localag, this.i);
      int n = m;
      if ((i1 & 0x100) == 256) {
        n = m | 0x2;
      }
      ag.a(localag, this.j);
      if ((this.a & 0x200) == 512)
      {
        this.k = new ac(this.k);
        this.a &= 0xFDFF;
      }
      ag.g(localag, this.k);
      if ((this.a & 0x400) == 1024)
      {
        this.l = Collections.unmodifiableList(this.l);
        this.a &= 0xFBFF;
      }
      ag.b(localag, this.l);
      ag.a(localag, n);
      return localag;
      m = 0;
    }
  }
  
  public final ah a(ag paramag)
  {
    if (paramag == ag.f()) {}
    label95:
    label138:
    label181:
    label224:
    label267:
    label310:
    label508:
    label560:
    label612:
    label667:
    label722:
    label777:
    label832:
    label888:
    for (;;)
    {
      return this;
      if (!ag.a(paramag).isEmpty())
      {
        if (this.b.isEmpty())
        {
          this.b = ag.a(paramag);
          this.a &= 0xFFFFFFFE;
        }
      }
      else
      {
        if (!ag.b(paramag).isEmpty())
        {
          if (!this.c.isEmpty()) {
            break label508;
          }
          this.c = ag.b(paramag);
          this.a &= 0xFFFFFFFD;
        }
        if (!ag.c(paramag).isEmpty())
        {
          if (!this.d.isEmpty()) {
            break label560;
          }
          this.d = ag.c(paramag);
          this.a &= 0xFFFFFFFB;
        }
        if (!ag.d(paramag).isEmpty())
        {
          if (!this.e.isEmpty()) {
            break label612;
          }
          this.e = ag.d(paramag);
          this.a &= 0xFFFFFFF7;
        }
        if (!ag.e(paramag).isEmpty())
        {
          if (!this.f.isEmpty()) {
            break label667;
          }
          this.f = ag.e(paramag);
          this.a &= 0xFFFFFFEF;
        }
        if (!ag.f(paramag).isEmpty())
        {
          if (!this.g.isEmpty()) {
            break label722;
          }
          this.g = ag.f(paramag);
          this.a &= 0xFFFFFFDF;
        }
        if (!ag.g(paramag).isEmpty())
        {
          if (!this.h.isEmpty()) {
            break label777;
          }
          this.h = ag.g(paramag);
          this.a &= 0xFFFFFFBF;
        }
        if (paramag.h())
        {
          this.a |= 0x80;
          this.i = ag.h(paramag);
        }
        if (paramag.j())
        {
          boolean bool = paramag.k();
          this.a |= 0x100;
          this.j = bool;
        }
        if (!ag.i(paramag).isEmpty())
        {
          if (!this.k.isEmpty()) {
            break label832;
          }
          this.k = ag.i(paramag);
          this.a &= 0xFDFF;
        }
      }
      for (;;)
      {
        if (ag.j(paramag).isEmpty()) {
          break label888;
        }
        if (!this.l.isEmpty()) {
          break label890;
        }
        this.l = ag.j(paramag);
        this.a &= 0xFBFF;
        return this;
        if ((this.a & 0x1) != 1)
        {
          this.b = new p(this.b);
          this.a |= 0x1;
        }
        this.b.addAll(ag.a(paramag));
        break;
        if ((this.a & 0x2) != 2)
        {
          this.c = new p(this.c);
          this.a |= 0x2;
        }
        this.c.addAll(ag.b(paramag));
        break label95;
        if ((this.a & 0x4) != 4)
        {
          this.d = new p(this.d);
          this.a |= 0x4;
        }
        this.d.addAll(ag.c(paramag));
        break label138;
        if ((this.a & 0x8) != 8)
        {
          this.e = new p(this.e);
          this.a |= 0x8;
        }
        this.e.addAll(ag.d(paramag));
        break label181;
        if ((this.a & 0x10) != 16)
        {
          this.f = new p(this.f);
          this.a |= 0x10;
        }
        this.f.addAll(ag.e(paramag));
        break label224;
        if ((this.a & 0x20) != 32)
        {
          this.g = new p(this.g);
          this.a |= 0x20;
        }
        this.g.addAll(ag.f(paramag));
        break label267;
        if ((this.a & 0x40) != 64)
        {
          this.h = new ArrayList(this.h);
          this.a |= 0x40;
        }
        this.h.addAll(ag.g(paramag));
        break label310;
        if ((this.a & 0x200) != 512)
        {
          this.k = new p(this.k);
          this.a |= 0x200;
        }
        this.k.addAll(ag.i(paramag));
      }
    }
    label890:
    if ((this.a & 0x400) != 1024)
    {
      this.l = new ArrayList(this.l);
      this.a |= 0x400;
    }
    this.l.addAll(ag.j(paramag));
    return this;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */