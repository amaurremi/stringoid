package com.appbrain.g;

import com.appbrain.b.ab;
import com.appbrain.b.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends l
  implements d
{
  private int a;
  private Object b = "";
  private com.appbrain.b.d c = com.appbrain.b.d.a;
  private com.appbrain.b.d d = com.appbrain.b.d.a;
  private long e;
  private e f = e.a;
  private boolean g;
  private Object h = "";
  private boolean i;
  private boolean j;
  private Object k = "";
  private Object l = "";
  private Object m = "";
  private Object n = "";
  private Object o = "";
  private int p;
  private Object q = "";
  private List r = Collections.emptyList();
  private List s = Collections.emptyList();
  
  private b j()
  {
    int i2 = 1;
    b localb = new b('\000');
    int i3 = this.a;
    if ((i3 & 0x1) == 1) {}
    for (;;)
    {
      b.a(localb, this.b);
      int i1 = i2;
      if ((i3 & 0x2) == 2) {
        i1 = i2 | 0x2;
      }
      b.a(localb, this.c);
      i2 = i1;
      if ((i3 & 0x4) == 4) {
        i2 = i1 | 0x4;
      }
      b.b(localb, this.d);
      i1 = i2;
      if ((i3 & 0x8) == 8) {
        i1 = i2 | 0x8;
      }
      b.a(localb, this.e);
      i2 = i1;
      if ((i3 & 0x10) == 16) {
        i2 = i1 | 0x10;
      }
      b.a(localb, this.f);
      i1 = i2;
      if ((i3 & 0x20) == 32) {
        i1 = i2 | 0x20;
      }
      b.a(localb, this.g);
      i2 = i1;
      if ((i3 & 0x40) == 64) {
        i2 = i1 | 0x40;
      }
      b.b(localb, this.h);
      i1 = i2;
      if ((i3 & 0x80) == 128) {
        i1 = i2 | 0x80;
      }
      b.b(localb, this.i);
      i2 = i1;
      if ((i3 & 0x100) == 256) {
        i2 = i1 | 0x100;
      }
      b.c(localb, this.j);
      i1 = i2;
      if ((i3 & 0x200) == 512) {
        i1 = i2 | 0x200;
      }
      b.c(localb, this.k);
      i2 = i1;
      if ((i3 & 0x400) == 1024) {
        i2 = i1 | 0x400;
      }
      b.d(localb, this.l);
      i1 = i2;
      if ((i3 & 0x800) == 2048) {
        i1 = i2 | 0x800;
      }
      b.e(localb, this.m);
      i2 = i1;
      if ((i3 & 0x1000) == 4096) {
        i2 = i1 | 0x1000;
      }
      b.f(localb, this.n);
      i1 = i2;
      if ((i3 & 0x2000) == 8192) {
        i1 = i2 | 0x2000;
      }
      b.g(localb, this.o);
      i2 = i1;
      if ((i3 & 0x4000) == 16384) {
        i2 = i1 | 0x4000;
      }
      b.a(localb, this.p);
      i1 = i2;
      if ((i3 & 0x8000) == 32768) {
        i1 = i2 | 0x8000;
      }
      b.h(localb, this.q);
      if ((this.a & 0x10000) == 65536)
      {
        this.r = Collections.unmodifiableList(this.r);
        this.a &= 0xFFFEFFFF;
      }
      b.a(localb, this.r);
      if ((this.a & 0x20000) == 131072)
      {
        this.s = Collections.unmodifiableList(this.s);
        this.a &= 0xFFFDFFFF;
      }
      b.b(localb, this.s);
      b.b(localb, i1);
      return localb;
      i2 = 0;
    }
  }
  
  private void k()
  {
    if ((this.a & 0x10000) != 65536)
    {
      this.r = new ArrayList(this.r);
      this.a |= 0x10000;
    }
  }
  
  private void l()
  {
    if ((this.a & 0x20000) != 131072)
    {
      this.s = new ArrayList(this.s);
      this.a |= 0x20000;
    }
  }
  
  public final c a(int paramInt)
  {
    this.a |= 0x4000;
    this.p = paramInt;
    return this;
  }
  
  public final c a(long paramLong)
  {
    this.a |= 0x8;
    this.e = paramLong;
    return this;
  }
  
  public final c a(com.appbrain.b.d paramd)
  {
    if (paramd == null) {
      throw new NullPointerException();
    }
    this.a |= 0x2;
    this.c = paramd;
    return this;
  }
  
  public final c a(b paramb)
  {
    if (paramb == b.f()) {}
    for (;;)
    {
      return this;
      if (paramb.g())
      {
        this.a |= 0x1;
        this.b = b.a(paramb);
      }
      if (paramb.h()) {
        a(paramb.i());
      }
      if (paramb.j())
      {
        com.appbrain.b.d locald = paramb.k();
        if (locald == null) {
          throw new NullPointerException();
        }
        this.a |= 0x4;
        this.d = locald;
      }
      if (paramb.l()) {
        a(paramb.m());
      }
      if (paramb.n()) {
        a(paramb.o());
      }
      boolean bool;
      if (paramb.p())
      {
        bool = paramb.q();
        this.a |= 0x20;
        this.g = bool;
      }
      if (paramb.r())
      {
        this.a |= 0x40;
        this.h = b.b(paramb);
      }
      if (paramb.t())
      {
        bool = paramb.u();
        this.a |= 0x80;
        this.i = bool;
      }
      if (paramb.v())
      {
        bool = paramb.w();
        this.a |= 0x100;
        this.j = bool;
      }
      if (paramb.x())
      {
        this.a |= 0x200;
        this.k = b.c(paramb);
      }
      if (paramb.y())
      {
        this.a |= 0x400;
        this.l = b.d(paramb);
      }
      if (paramb.z())
      {
        this.a |= 0x800;
        this.m = b.e(paramb);
      }
      if (paramb.A())
      {
        this.a |= 0x1000;
        this.n = b.f(paramb);
      }
      if (paramb.B())
      {
        this.a |= 0x2000;
        this.o = b.g(paramb);
      }
      if (paramb.C()) {
        a(paramb.D());
      }
      if (paramb.E())
      {
        this.a |= 0x8000;
        this.q = b.h(paramb);
      }
      if (!b.i(paramb).isEmpty())
      {
        if (!this.r.isEmpty()) {
          break label498;
        }
        this.r = b.i(paramb);
        this.a &= 0xFFFEFFFF;
      }
      while (!b.j(paramb).isEmpty())
      {
        if (!this.s.isEmpty()) {
          break label519;
        }
        this.s = b.j(paramb);
        this.a &= 0xFFFDFFFF;
        return this;
        label498:
        k();
        this.r.addAll(b.i(paramb));
      }
    }
    label519:
    l();
    this.s.addAll(b.j(paramb));
    return this;
  }
  
  public final c a(e parame)
  {
    if (parame == null) {
      throw new NullPointerException();
    }
    this.a |= 0x10;
    this.f = parame;
    return this;
  }
  
  public final c a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x1;
    this.b = paramString;
    return this;
  }
  
  public final c b(int paramInt)
  {
    k();
    this.r.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public final c b(com.appbrain.b.d paramd)
  {
    if (paramd == null) {
      throw new NullPointerException();
    }
    l();
    this.s.add(paramd);
    return this;
  }
  
  public final c d()
  {
    return new c().a(j());
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final b f()
  {
    b localb = j();
    if (!localb.e()) {
      throw new ab();
    }
    return localb;
  }
  
  public final c g()
  {
    this.a &= 0xFFFFFFF7;
    this.e = 0L;
    return this;
  }
  
  public final c h()
  {
    this.a &= 0xFFFFFFEF;
    this.f = e.a;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */