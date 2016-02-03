package com.ideashower.readitlater.a;

import android.util.SparseArray;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.db.operation.k;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

class al
  extends j
{
  private final ItemQuery.ReadOnlyItemQuery p;
  private final aj q = new aj(this.e);
  private boolean r = false;
  
  public al(ai paramai, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    this.p = paramReadOnlyItemQuery;
  }
  
  protected void c_()
  {
    Object localObject = r.a(this.p, this.h, this);
    if (localObject == null) {
      this.r = true;
    }
    long l;
    do
    {
      return;
      k localk = k();
      this.q.d.addAll((Collection)localObject);
      localObject = ((h)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        o localo = (o)((Iterator)localObject).next();
        if (localo.h(false))
        {
          Iterator localIterator = localo.T().iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            x localx = (x)localIterator.next();
            if (localx.g() == 0)
            {
              this.q.b.add(localx);
              if (!localx.i())
              {
                this.q.a.add(localx);
                i = 1;
              }
              this.q.f.put(localx.c(), localk.a(localx.c()));
            }
            for (;;)
            {
              break;
              if ((localx.g() == 2) && (!localx.l())) {
                this.q.c.add(localx);
              }
            }
          }
          if (i != 0) {
            this.q.e.a(localo);
          }
        }
      }
      this.q.g = q();
      Collections.sort(this.q.b, x.b);
      Collections.sort(this.q.a, x.b);
      Collections.sort(this.q.c, x.b);
      l = (System.currentTimeMillis() / 1000.0D);
      this.q.h = l;
      this.q.i = l;
      if ((!this.q.b.isEmpty()) && (((x)this.q.b.get(0)).f() > 0L)) {
        this.q.i = (l * 1000L);
      }
    } while ((this.q.a.isEmpty()) || (((x)this.q.a.get(0)).f() <= 0L));
    this.q.i = (l * 1000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */