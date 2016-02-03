package com.pocket.list.adapter.data;

import android.util.SparseArray;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.q;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.h;
import com.ideashower.readitlater.objects.i;
import java.util.Iterator;

class b
  implements g
{
  private b(a parama) {}
  
  private void a()
  {
    a.c(this.a).a(0, 0);
  }
  
  private void a(h paramh)
  {
    paramh = paramh.iterator();
    while (paramh.hasNext())
    {
      o localo = (o)paramh.next();
      Object localObject = localo.ah();
      if (localObject != null)
      {
        localObject = ((q)localObject).b();
        if (localObject != null) {
          a.g(this.a).put(a.e(this.a).indexOf(localo), localObject);
        }
        localo.ai();
      }
    }
  }
  
  public void a(f paramf, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    if (paramf != a.b(this.a)) {}
    do
    {
      return;
      a();
      if (a.e(this.a).isEmpty())
      {
        if ((this.a.e()) && (this.a.j().m()))
        {
          a.a(this.a, true, null);
          return;
        }
        a.f(this.a).a(this.a, true, null);
        return;
      }
    } while (a.c(this.a).b <= a.e(this.a).size());
    a.f(this.a).b(this.a, true, null);
  }
  
  public void a(f paramf, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, ErrorReport paramErrorReport)
  {
    if (paramf != a.b(this.a)) {}
    do
    {
      return;
      a();
      if (a.e(this.a).isEmpty())
      {
        if ((this.a.e()) && (this.a.j().m()))
        {
          a.a(this.a, false, paramErrorReport);
          return;
        }
        a.f(this.a).a(this.a, false, paramErrorReport);
        return;
      }
    } while (a.c(this.a).b <= a.e(this.a).size());
    a.f(this.a).b(this.a, false, paramErrorReport);
  }
  
  public void a(f paramf, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery, h paramh, Boolean paramBoolean)
  {
    if (paramf != a.b(this.a)) {}
    label163:
    label235:
    label310:
    for (;;)
    {
      return;
      a();
      int j;
      if (paramBoolean != null)
      {
        a.a(this.a, paramBoolean.booleanValue());
        j = this.a.h();
        if (!a.e(this.a).isEmpty()) {
          break label163;
        }
        a.e(this.a).addAll(paramh);
        a(paramh);
        a.f(this.a).c(this.a);
      }
      for (;;)
      {
        if (j == this.a.h()) {
          break label310;
        }
        a.f(this.a).b(this.a, this.a.h());
        return;
        paramf = this.a;
        if (paramh.size() < a.d(this.a)) {}
        for (boolean bool = true;; bool = false)
        {
          a.a(paramf, bool);
          break;
        }
        if (!paramh.isEmpty())
        {
          if (paramReadOnlyItemQuery.o() != null) {}
          for (int i = paramReadOnlyItemQuery.o().intValue();; i = 0)
          {
            if (i <= 0) {
              break label235;
            }
            a.e(this.a).addAll(paramh);
            a(paramh);
            a.f(this.a).a(this.a, i);
            break;
          }
          a.e(this.a).clear();
          a.e(this.a).addAll(paramh);
          a.g(this.a).clear();
          a(paramh);
          a.f(this.a).a(this.a, 0);
        }
        else
        {
          a.f(this.a).a(this.a, -1);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */