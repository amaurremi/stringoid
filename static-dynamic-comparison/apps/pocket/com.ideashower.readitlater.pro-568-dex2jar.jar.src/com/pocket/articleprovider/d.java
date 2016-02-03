package com.pocket.articleprovider;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import java.util.Collection;
import java.util.Iterator;

public class d
  extends j
  implements e
{
  private final int p;
  private final int q;
  private final int r;
  private h s;
  
  protected d(b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p = paramInt1;
    this.q = paramInt2;
    this.r = paramInt3;
  }
  
  protected void c_()
  {
    Object localObject2 = null;
    int j = 0;
    com.ideashower.readitlater.e.e locale = r.a(this.p, this.h);
    long l = locale.u();
    int i;
    if (this.q != 0)
    {
      localObject1 = b.a(this.e).a();
      if (this.q > 0)
      {
        i = this.q;
        ((l)localObject1).d(Integer.valueOf(i)).c().e("time_added>=" + l).a();
      }
    }
    for (Object localObject1 = r.a(b.a(this.e).c(), this.h, this);; localObject1 = null)
    {
      if (this.r != 0)
      {
        localObject2 = b.a(this.e).a();
        i = j;
        if (this.r > 0) {
          i = this.r;
        }
        ((l)localObject2).d(Integer.valueOf(i)).c().e("time_added<=" + l).a();
        localObject2 = r.a(b.a(this.e).c(), this.h, this);
      }
      Iterator localIterator;
      label221:
      o localo;
      if ((localObject1 != null) && (localObject2 != null))
      {
        localIterator = ((h)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localo = (o)localIterator.next();
          if (localo.u() == l) {}
        }
        else
        {
          ((h)localObject1).addAll((Collection)localObject2);
          this.s = ((h)localObject1);
        }
      }
      for (;;)
      {
        if (!this.s.f(this.p)) {
          this.s.a(locale);
        }
        b.a(this.s);
        return;
        i = 0;
        break;
        if (!((h)localObject1).f(localo.f())) {
          break label221;
        }
        localIterator.remove();
        break label221;
        if (localObject1 != null) {
          this.s = ((h)localObject1);
        } else {
          this.s = ((h)localObject2);
        }
      }
    }
  }
  
  public h e()
  {
    return this.s;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/articleprovider/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */