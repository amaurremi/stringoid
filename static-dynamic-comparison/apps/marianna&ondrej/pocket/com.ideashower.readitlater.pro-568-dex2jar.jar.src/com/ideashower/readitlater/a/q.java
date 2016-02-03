package com.ideashower.readitlater.a;

import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;

public final class q
{
  private static final Object a = new Object();
  private static String b;
  private static int c = 0;
  private static r d;
  
  public static void a() {}
  
  private static u b(u paramu, int paramInt)
  {
    synchronized (a)
    {
      if (paramInt == c)
      {
        if (paramu.a() != null)
        {
          b = paramu.a();
          i.b().a(a.x, b).a();
        }
        i();
        return paramu;
      }
      paramu.a(true);
    }
  }
  
  public static void b() {}
  
  public static void c()
  {
    g.a(new Runnable()
    {
      public void run()
      {
        new t(null).h();
      }
    });
  }
  
  public static u d()
  {
    synchronized (a)
    {
      u localu;
      if (b != null)
      {
        localu = new u(b, null);
        return localu;
      }
      b = i.a(a.x);
      if (b != null)
      {
        localu = new u(b, null);
        return localu;
      }
    }
    r localr = h();
    return r.a(localr);
  }
  
  public static void e()
  {
    synchronized (a)
    {
      i();
      b = null;
      i.b().a(a.x, null).a();
      return;
    }
  }
  
  public static ag f()
  {
    new ag()
    {
      public void a() {}
      
      public void b() {}
      
      public void c() {}
    };
  }
  
  private static r h()
  {
    synchronized (a)
    {
      if (d == null) {
        i();
      }
      r localr = d;
      return localr;
    }
  }
  
  private static void i()
  {
    synchronized (a)
    {
      d = new r();
      return;
    }
  }
  
  private static int j()
  {
    synchronized (a)
    {
      c += 1;
      int i = c;
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */