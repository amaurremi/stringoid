package com.pocket.list.adapter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.objects.ErrorReport;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.g;
import java.util.ArrayList;
import java.util.Iterator;

class b
  implements com.pocket.list.adapter.data.e
{
  private boolean b = true;
  private boolean c;
  private c d;
  private boolean e;
  private ErrorReport f;
  
  private b(a parama) {}
  
  private void a(c paramc, boolean paramBoolean, ErrorReport paramErrorReport)
  {
    this.d = paramc;
    this.f = paramErrorReport;
    this.e = paramBoolean;
    a();
  }
  
  private boolean c()
  {
    if (a.k(this.a) != null)
    {
      Iterator localIterator = a.k(this.a).iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a();
      }
    }
    if (a.l(this.a) != 0)
    {
      final int i = a.l(this.a);
      final int j = a.m(this.a);
      a.j(this.a).setSelectionFromTop(i, j);
      a.j(this.a).post(new Runnable()
      {
        public void run()
        {
          a.j(b.this.a).setSelectionFromTop(i, j);
        }
      });
      return false;
    }
    return true;
  }
  
  protected void a()
  {
    Iterator localIterator = a.g(this.a).iterator();
    while (localIterator.hasNext()) {
      a((g)localIterator.next());
    }
  }
  
  public void a(com.pocket.list.adapter.data.a parama)
  {
    a.a(this.a, 0);
    a.h(this.a).clear();
    a.i(this.a).clear();
    this.a.b(0);
  }
  
  public void a(com.pocket.list.adapter.data.a parama, int paramInt)
  {
    a.b(this.a, false);
    this.a.b(paramInt);
    a.b(this.a, a.j(this.a).getLastVisiblePosition());
  }
  
  public void a(com.pocket.list.adapter.data.a parama, o paramo, int paramInt)
  {
    if (paramInt < 0) {}
    do
    {
      return;
      if ((paramo.M()) && (a.n(this.a).valueAt(paramInt) == 0))
      {
        this.a.b(paramInt);
        return;
      }
      int i = a.b(this.a).a(paramo);
      int j = a.o(this.a).size();
      paramInt = 0;
      while (paramInt < j)
      {
        parama = (com.pocket.list.widget.b.a)a.o(this.a).get(paramInt);
        if (a.b(this.a).a(parama.getItem()) == i) {
          parama.a(paramo);
        }
        paramInt += 1;
      }
    } while (a.a(this.a) == null);
    a.a(this.a).e();
  }
  
  public void a(com.pocket.list.adapter.data.a parama, ItemQuery paramItemQuery)
  {
    a.p(this.a);
  }
  
  public void a(com.pocket.list.adapter.data.a parama, boolean paramBoolean, ErrorReport paramErrorReport)
  {
    a.b(this.a, false);
    a(c.e, paramBoolean, paramErrorReport);
  }
  
  protected void a(g paramg)
  {
    switch (a.2.a[this.d.ordinal()])
    {
    default: 
      paramg.F();
      return;
    case 1: 
      paramg.E();
      return;
    case 2: 
      paramg.C();
      return;
    case 3: 
      paramg.D();
      return;
    }
    paramg.a(this.e, this.f);
  }
  
  public void b()
  {
    a(c.a, false, null);
  }
  
  public void b(com.pocket.list.adapter.data.a parama)
  {
    this.b = true;
    a.b(this.a, false);
    a(c.d, false, null);
  }
  
  public void b(com.pocket.list.adapter.data.a parama, int paramInt)
  {
    parama = a.q(this.a).iterator();
    while (parama.hasNext()) {
      ((e)parama.next()).a(this.a);
    }
  }
  
  public void b(com.pocket.list.adapter.data.a parama, boolean paramBoolean, ErrorReport paramErrorReport)
  {
    a.b(this.a, false);
  }
  
  public void c(com.pocket.list.adapter.data.a parama)
  {
    a.b(this.a, false);
    if ((this.b) && (!parama.i())) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = parama.i();
      if (a.a(this.a) != null) {
        a.a(this.a).e();
      }
      this.a.b(0);
      if (!this.c)
      {
        this.c = true;
        bool = c();
      }
      if (bool) {
        a.j(this.a).post(new Runnable()
        {
          public void run()
          {
            a.j(b.this.a).setSelection(0);
          }
        });
      }
      if (this.b)
      {
        a(c.b, false, null);
        return;
      }
      a(c.c, false, null);
      return;
    }
  }
  
  public void d(com.pocket.list.adapter.data.a parama)
  {
    a.b(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */