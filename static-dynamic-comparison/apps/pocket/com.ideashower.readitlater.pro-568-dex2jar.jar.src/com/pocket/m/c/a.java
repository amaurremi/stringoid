package com.pocket.m.c;

import com.ideashower.readitlater.a.a.e;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.objects.h;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.m.a.k;

public class a
  extends d
{
  private String a;
  
  public a(String paramString, k paramk)
  {
    super(paramk);
    if (paramString != null) {}
    for (paramString = paramString.toLowerCase();; paramString = null)
    {
      this.a = paramString;
      return;
    }
  }
  
  protected void c_()
  {
    Object localObject1 = g();
    Object localObject2 = com.ideashower.readitlater.a.a.a.c().a(this.a);
    if (localObject2 == null) {}
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        this.a = ((e)localObject2).b();
      }
      localObject1 = r.a(((ItemQuery)localObject1).c(), this.h, this);
      if (localObject1 != null) {
        break;
      }
      return;
    }
    int m = ((h)localObject1).size();
    int k = 0;
    label73:
    Object localObject3;
    int i;
    if (k < m)
    {
      localObject2 = (o)((h)localObject1).get(k);
      localObject3 = ((o)localObject2).n();
      if ((j == 0) || (!((String)localObject3).equals(this.a))) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        a((o)localObject2, 1, 3, true, false);
      }
      k += 1;
      break label73;
      break;
      label136:
      localObject3 = com.ideashower.readitlater.a.a.a.c().a((String)localObject3);
      if ((localObject3 != null) && (((e)localObject3).b().equals(this.a))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */