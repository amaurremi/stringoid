package com.appbrain.e;

import com.appbrain.b.ac;
import com.appbrain.b.l;
import com.appbrain.b.p;
import com.appbrain.b.q;

public final class au
  extends l
  implements av
{
  private int a;
  private aa b = aa.f();
  private q c = p.a;
  private q d = p.a;
  private Object e = "";
  
  private au g()
  {
    return new au().a(h());
  }
  
  private at h()
  {
    int i = 1;
    at localat = new at('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      at.a(localat, this.b);
      if ((this.a & 0x2) == 2)
      {
        this.c = new ac(this.c);
        this.a &= 0xFFFFFFFD;
      }
      at.a(localat, this.c);
      if ((this.a & 0x4) == 4)
      {
        this.d = new ac(this.d);
        this.a &= 0xFFFFFFFB;
      }
      at.b(localat, this.d);
      int j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x2;
      }
      at.a(localat, this.e);
      at.a(localat, j);
      return localat;
      i = 0;
    }
  }
  
  private void i()
  {
    if ((this.a & 0x2) != 2)
    {
      this.c = new p(this.c);
      this.a |= 0x2;
    }
  }
  
  private void j()
  {
    if ((this.a & 0x4) != 4)
    {
      this.d = new p(this.d);
      this.a |= 0x4;
    }
  }
  
  public final au a(aa paramaa)
  {
    if (paramaa == null) {
      throw new NullPointerException();
    }
    this.b = paramaa;
    this.a |= 0x1;
    return this;
  }
  
  public final au a(at paramat)
  {
    if (paramat == at.f()) {}
    label112:
    label191:
    label212:
    label231:
    for (;;)
    {
      return this;
      aa localaa;
      if (paramat.g())
      {
        localaa = paramat.h();
        if (((this.a & 0x1) == 1) && (this.b != aa.f()))
        {
          this.b = aa.a(this.b).a(localaa).f();
          this.a |= 0x1;
        }
      }
      else
      {
        if (!at.a(paramat).isEmpty())
        {
          if (!this.c.isEmpty()) {
            break label191;
          }
          this.c = at.a(paramat);
          this.a &= 0xFFFFFFFD;
        }
        if (!at.b(paramat).isEmpty())
        {
          if (!this.d.isEmpty()) {
            break label212;
          }
          this.d = at.b(paramat);
          this.a &= 0xFFFFFFFB;
        }
      }
      for (;;)
      {
        if (!paramat.i()) {
          break label231;
        }
        this.a |= 0x8;
        this.e = at.c(paramat);
        return this;
        this.b = localaa;
        break;
        i();
        this.c.addAll(at.a(paramat));
        break label112;
        j();
        this.d.addAll(at.b(paramat));
      }
    }
  }
  
  public final au a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    i();
    this.c.add(paramString);
    return this;
  }
  
  public final au b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    j();
    this.d.add(paramString);
    return this;
  }
  
  public final au c(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x8;
    this.e = paramString;
    return this;
  }
  
  public final at d()
  {
    at localat = h();
    if (!localat.e()) {
      throw new com.appbrain.b.ab();
    }
    return localat;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */