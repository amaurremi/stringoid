package com.appbrain.e;

import com.appbrain.b.ab;
import com.appbrain.b.l;

public final class ax
  extends l
  implements ay
{
  private int a;
  private aq b = aq.f();
  private boolean c;
  private int d;
  
  private ax g()
  {
    return new ax().a(i());
  }
  
  private aw i()
  {
    int j = 1;
    aw localaw = new aw('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      aw.a(localaw, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      aw.a(localaw, this.c);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      aw.a(localaw, this.d);
      aw.b(localaw, j);
      return localaw;
      j = 0;
    }
  }
  
  public final ax a(int paramInt)
  {
    this.a |= 0x4;
    this.d = paramInt;
    return this;
  }
  
  public final ax a(ar paramar)
  {
    this.b = paramar.d();
    this.a |= 0x1;
    return this;
  }
  
  public final ax a(aw paramaw)
  {
    if (paramaw == aw.f()) {
      return this;
    }
    aq localaq;
    if (paramaw.g())
    {
      localaq = paramaw.h();
      if (((this.a & 0x1) != 1) || (this.b == aq.f())) {
        break label103;
      }
    }
    label103:
    for (this.b = aq.a(this.b).a(localaq).f();; this.b = localaq)
    {
      this.a |= 0x1;
      if (paramaw.i()) {
        a(paramaw.j());
      }
      if (!paramaw.k()) {
        break;
      }
      a(paramaw.l());
      return this;
    }
  }
  
  public final ax a(boolean paramBoolean)
  {
    this.a |= 0x2;
    this.c = paramBoolean;
    return this;
  }
  
  public final aw d()
  {
    aw localaw = i();
    if (!localaw.e()) {
      throw new ab();
    }
    return localaw;
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final aq h()
  {
    return this.b;
  }
  
  public final int l()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */