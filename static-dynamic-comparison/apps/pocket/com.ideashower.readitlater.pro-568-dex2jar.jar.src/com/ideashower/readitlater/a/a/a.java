package com.ideashower.readitlater.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.h.i;

public class a
{
  private static d a;
  private static d b;
  private static SharedPreferences c;
  private static final Object d = new Object();
  private static com.ideashower.readitlater.g.g e;
  private static com.ideashower.readitlater.g.g f;
  
  public static com.ideashower.readitlater.g.g a(int paramInt)
  {
    synchronized (d)
    {
      if (f != null)
      {
        localg = f;
        return localg;
      }
      com.ideashower.readitlater.g.g localg = new b(paramInt).h();
      return localg;
    }
  }
  
  public static String a(String paramString)
  {
    return "loggedInto".concat(paramString);
  }
  
  public static void a()
  {
    l();
  }
  
  private static void a(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    k().edit().putBoolean(a(paramString), paramBoolean).commit();
  }
  
  public static void b() {}
  
  public static void b(int paramInt)
  {
    if (paramInt > i.a(com.ideashower.readitlater.h.a.bo)) {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          a.a(this.a);
        }
      });
    }
  }
  
  public static void b(String paramString)
  {
    a(true, paramString);
    com.pocket.m.a.a(paramString);
    ReaderFragment.a(paramString);
  }
  
  public static d c()
  {
    if (b == null) {
      if (!d()) {
        l();
      }
    }
    synchronized (d)
    {
      com.ideashower.readitlater.g.g localg1 = e;
      com.ideashower.readitlater.g.g localg2 = f;
      if (localg1 != null) {
        localg1.d();
      }
      if (localg2 != null) {
        localg2.d();
      }
      return b;
    }
  }
  
  public static void c(String paramString)
  {
    k().edit().putBoolean(a(paramString), false).commit();
  }
  
  public static boolean d()
  {
    for (;;)
    {
      synchronized (d)
      {
        if (f == null)
        {
          if (e == null) {
            break label35;
          }
          break label30;
          return bool;
        }
      }
      label30:
      boolean bool = true;
      continue;
      label35:
      bool = false;
    }
  }
  
  public static ag e()
  {
    new ag()
    {
      public void a() {}
      
      public void b() {}
      
      public void c() {}
    };
  }
  
  private static SharedPreferences k()
  {
    if (c == null) {
      c = com.ideashower.readitlater.a.g.c().getSharedPreferences("subscriptions", 0);
    }
    return c;
  }
  
  private static com.ideashower.readitlater.g.g l()
  {
    synchronized (d)
    {
      if (e == null) {
        e = new c(null).h();
      }
      com.ideashower.readitlater.g.g localg = e;
      return localg;
    }
  }
  
  private static boolean m()
  {
    for (;;)
    {
      synchronized (d)
      {
        if (f != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static void n()
  {
    k().edit().clear().commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */