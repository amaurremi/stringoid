package com.ideashower.readitlater.a;

import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.service.PocketDemoService;

public class ar
{
  public static long a = 0L;
  
  public static void a()
  {
    b();
  }
  
  public static long b()
  {
    int j = 1;
    long l3;
    int i;
    if (a == 0L)
    {
      l3 = i.a(a.aY);
      if (l3 != 0L) {
        break label62;
      }
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        a = System.currentTimeMillis();
        i.b().a(a.aY, a).a();
      }
      for (;;)
      {
        return ((float)a / 1000.0F);
        label62:
        long l4 = i.a(a.aa);
        long l2 = System.currentTimeMillis() - l4;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        i = j;
        if (l4 == 0L) {
          break;
        }
        if (l1 <= 1200000L) {
          break label128;
        }
        i = j;
        if (!PocketDemoService.d()) {
          break;
        }
        i = 0;
        break;
        a = l3;
      }
      label128:
      i = 0;
    }
  }
  
  public static void c()
  {
    i.b().a(a.aa, System.currentTimeMillis()).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */