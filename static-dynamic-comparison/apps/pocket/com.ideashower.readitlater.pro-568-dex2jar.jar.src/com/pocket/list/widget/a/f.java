package com.pocket.list.widget.a;

import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.d;
import java.util.Iterator;
import java.util.List;

class f
  implements com.ideashower.readitlater.d.c, l
{
  private f(c paramc) {}
  
  private boolean b(o paramo)
  {
    if (c.a(this.a).c(paramo) < 0) {
      return false;
    }
    if ((paramo.al() != 0) && (paramo.al() != 3)) {
      c.a(this.a, paramo);
    }
    if (paramo.A() == null) {
      c.a(this.a, paramo);
    }
    return true;
  }
  
  public void a() {}
  
  public void a(o paramo)
  {
    int i = c.a(this.a).size();
    if (b(paramo))
    {
      if (c.a(this.a).size() < i) {
        c.b(this.a).b();
      }
      this.a.c();
    }
  }
  
  public void a(k paramk, boolean paramBoolean)
  {
    int j = 0;
    paramk = e.a((e)paramk);
    int m = paramk.length;
    int i = 0;
    while (i < m)
    {
      int k = paramk[i];
      if (k == 0) {
        break;
      }
      o localo = c.a(this.a).a(k);
      k = j;
      if (localo != null)
      {
        k = j;
        if (localo.al() != 0)
        {
          c.a(this.a, localo);
          k = 1;
        }
      }
      i += 1;
      j = k;
    }
    if (j != 0) {
      this.a.c();
    }
    if (c.a(this.a).size() < c.e()) {
      c.b(this.a).b();
    }
  }
  
  public void a(List paramList)
  {
    int j = c.a(this.a).size();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!b((o)paramList.next())) {
        break label86;
      }
      i = 1;
    }
    label86:
    for (;;)
    {
      break;
      if (i != 0)
      {
        if (c.a(this.a).size() < j) {
          c.b(this.a).b();
        }
        this.a.c();
      }
      return;
    }
  }
  
  public void aj()
  {
    if (!c.a(this.a).isEmpty())
    {
      locale = new e(this.a, new int[c.a(this.a).size()], null);
      locale.a(this, true);
      locale.f();
    }
    while (c.a(this.a).size() >= c.e())
    {
      e locale;
      return;
    }
    c.b(this.a).b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */