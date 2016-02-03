package com.pocket.list.adapter.data;

import android.util.SparseArray;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.objects.h;
import java.util.Iterator;
import java.util.List;

class c
  implements com.ideashower.readitlater.d.c
{
  private c(a parama) {}
  
  private int a(o paramo, boolean paramBoolean)
  {
    int i;
    int j;
    if (a.b(this.a) == a.i(this.a))
    {
      i = a.e(this.a).c(paramo);
      if (i < 0) {
        break label185;
      }
      j = 1;
      label36:
      if ((j == a.h(this.a).a(paramo)) || (j == 0) || (paramBoolean)) {
        break label191;
      }
      a.e(this.a).e(i);
      a.g(this.a).remove(i);
      a.f(this.a).b(this.a, this.a.h());
      a.f(this.a).a(this.a, i);
      if (a.b(this.a) == a.j(this.a)) {
        this.a.b();
      }
      i = -1;
    }
    label185:
    label191:
    for (;;)
    {
      a.f(this.a).a(this.a, paramo, i);
      return i;
      i = a.e(this.a).d(paramo);
      break;
      j = 0;
      break label36;
    }
  }
  
  public void a(o paramo)
  {
    if (a.h(this.a) == null) {
      return;
    }
    a(paramo, false);
  }
  
  public void a(List paramList)
  {
    int i = a.e(this.a).size();
    paramList = paramList.iterator();
    i -= 1;
    if (paramList.hasNext())
    {
      int j = a((o)paramList.next(), true);
      if (j == -1) {
        break label94;
      }
      i = Math.min(i, j);
    }
    label94:
    for (;;)
    {
      break;
      if (i < a.e(this.a).size() - 1) {
        a.f(this.a).a(this.a, i);
      }
      return;
    }
  }
  
  public void aj()
  {
    this.a.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */