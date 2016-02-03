package com.pocket.m.a.a;

import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;

public abstract class a
{
  private static final Object a = new Object();
  private static boolean b;
  
  protected static void a()
  {
    synchronized (a)
    {
      if (c.f()) {
        return;
      }
      if (b) {
        return;
      }
    }
    b = true;
    b localb = new b(null);
    localb.a(new l()
    {
      public void a() {}
      
      public void a(k arg1, boolean paramAnonymousBoolean)
      {
        synchronized ()
        {
          a.a(false);
          return;
        }
      }
    }, false);
    localb.f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */