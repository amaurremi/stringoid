package com.pocket.m.a.a;

import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import com.pocket.m.a;

public abstract class d
{
  private static final Object a = new Object();
  private static boolean b;
  private static boolean c;
  private static com.pocket.m.e d;
  
  protected static void a()
  {
    synchronized (a)
    {
      if (!c.f()) {
        return;
      }
      if (a.a(true))
      {
        d();
        return;
      }
    }
    if (b) {
      return;
    }
    b = true;
    e locale = new e(null);
    locale.a(new l()
    {
      public void a() {}
      
      public void a(k arg1, boolean paramAnonymousBoolean)
      {
        synchronized ()
        {
          d.a(false);
          return;
        }
      }
    }, false);
    locale.f();
  }
  
  private static void d()
  {
    if (c) {}
    do
    {
      return;
      c = true;
    } while (d != null);
    d = new com.pocket.m.e()
    {
      public void a()
      {
        if ((d.c()) && (!a.a(true)))
        {
          d.b(false);
          d.a();
        }
      }
    };
    a.a(d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */