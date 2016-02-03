package com.appbrain.e;

import com.appbrain.b.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class r
  extends l
  implements s
{
  private int a;
  private aa b = aa.f();
  private boolean c;
  private List d = Collections.emptyList();
  private boolean e;
  private List f = Collections.emptyList();
  
  private r h()
  {
    return new r().a(i());
  }
  
  private q i()
  {
    int j = 1;
    q localq = new q('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      q.a(localq, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      q.a(localq, this.c);
      if ((this.a & 0x4) == 4)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a &= 0xFFFFFFFB;
      }
      q.a(localq, this.d);
      j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x4;
      }
      q.b(localq, this.e);
      if ((this.a & 0x10) == 16)
      {
        this.f = Collections.unmodifiableList(this.f);
        this.a &= 0xFFFFFFEF;
      }
      q.b(localq, this.f);
      q.a(localq, j);
      return localq;
      j = 0;
    }
  }
  
  private void j()
  {
    if ((this.a & 0x4) != 4)
    {
      this.d = new ArrayList(this.d);
      this.a |= 0x4;
    }
  }
  
  private void k()
  {
    if ((this.a & 0x10) != 16)
    {
      this.f = new ArrayList(this.f);
      this.a |= 0x10;
    }
  }
  
  public final r a(aa paramaa)
  {
    if (paramaa == null) {
      throw new NullPointerException();
    }
    this.b = paramaa;
    this.a |= 0x1;
    return this;
  }
  
  public final r a(c paramc)
  {
    j();
    this.d.add(paramc.d());
    return this;
  }
  
  public final r a(e parame)
  {
    if (parame == null) {
      throw new NullPointerException();
    }
    k();
    this.f.add(parame);
    return this;
  }
  
  public final r a(q paramq)
  {
    if (paramq == q.f()) {
      return this;
    }
    aa localaa;
    if (paramq.g())
    {
      localaa = paramq.h();
      if (((this.a & 0x1) == 1) && (this.b != aa.f()))
      {
        this.b = aa.a(this.b).a(localaa).f();
        label59:
        this.a |= 0x1;
      }
    }
    else
    {
      if (paramq.i())
      {
        boolean bool = paramq.j();
        this.a |= 0x2;
        this.c = bool;
      }
      if (!q.a(paramq).isEmpty())
      {
        if (!this.d.isEmpty()) {
          break label208;
        }
        this.d = q.a(paramq);
        this.a &= 0xFFFFFFFB;
      }
    }
    for (;;)
    {
      if (paramq.k()) {
        a(paramq.l());
      }
      if (q.b(paramq).isEmpty()) {
        break;
      }
      if (!this.f.isEmpty()) {
        break label229;
      }
      this.f = q.b(paramq);
      this.a &= 0xFFFFFFEF;
      return this;
      this.b = localaa;
      break label59;
      label208:
      j();
      this.d.addAll(q.a(paramq));
    }
    label229:
    k();
    this.f.addAll(q.b(paramq));
    return this;
  }
  
  public final r a(Iterable paramIterable)
  {
    k();
    l.a(paramIterable, this.f);
    return this;
  }
  
  public final r a(boolean paramBoolean)
  {
    this.a |= 0x8;
    this.e = paramBoolean;
    return this;
  }
  
  public final q d()
  {
    q localq = i();
    if (!localq.e()) {
      throw new com.appbrain.b.ab();
    }
    return localq;
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final int f()
  {
    return this.f.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */