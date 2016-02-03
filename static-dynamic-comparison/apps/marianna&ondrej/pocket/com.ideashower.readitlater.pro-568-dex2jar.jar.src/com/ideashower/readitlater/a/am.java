package com.ideashower.readitlater.a;

import android.content.Context;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.service.b;

public final class am
{
  private static ap a;
  
  public static void a() {}
  
  public static void a(Context paramContext)
  {
    if (!as.l()) {
      e();
    }
    ap localap;
    do
    {
      do
      {
        return;
      } while (!b.b());
      localap = c();
    } while (localap == null);
    localap.a(paramContext, new aq()
    {
      public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        if (!paramAnonymousBoolean) {
          am.a(am.this, false);
        }
      }
    }, null);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    i.b().a(com.ideashower.readitlater.h.a.aZ, true).a();
    if (paramBoolean) {
      a(paramContext);
    }
  }
  
  public static void b() {}
  
  public static void b(Context paramContext)
  {
    ap localap = c();
    if (b.b())
    {
      if (localap != null)
      {
        localap.a(paramContext, new aq()
        {
          public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            if (!paramAnonymousBoolean) {
              b.a(am.this, UiTrigger.B);
            }
          }
        }, null);
        return;
      }
      b.a(paramContext, UiTrigger.B);
      return;
    }
    if ((i.a(com.ideashower.readitlater.h.a.Y)) && (localap != null))
    {
      localap.a(paramContext, new aq()
      {
        public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          if (paramAnonymousBoolean)
          {
            b.a(am.this, 0, UiTrigger.B);
            return;
          }
          b.a(am.this);
        }
      }, null);
      i.b().a(com.ideashower.readitlater.h.a.Y, false).a();
      return;
    }
    b.a(paramContext);
  }
  
  public static ap c()
  {
    if (a == null) {
      a = g.b().k();
    }
    return a;
  }
  
  public static ag d()
  {
    ap localap = c();
    if (localap == null) {
      return null;
    }
    return localap.b();
  }
  
  public static void e()
  {
    i.b().a(com.ideashower.readitlater.h.a.aZ, false).a();
  }
  
  public static void f()
  {
    if (i.a(com.ideashower.readitlater.h.a.aZ)) {
      a(g.c());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */