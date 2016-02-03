package com.ideashower.readitlater.a;

import android.content.Context;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.j;
import com.pocket.oauth.f;
import com.pocket.user.UserMeta;
import com.pocket.user.b;
import com.pocket.widget.ValidatedEditText;
import com.pocket.widget.aw;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;

public final class as
{
  private static ArrayList a = new ArrayList();
  private static boolean b = false;
  private static com.pocket.user.a c;
  private static boolean d = false;
  
  private static void A()
  {
    String str3 = i.a(com.ideashower.readitlater.h.a.a);
    if (str3 == null)
    {
      c = new com.pocket.user.c();
      return;
    }
    UserMeta localUserMeta = UserMeta.l();
    String str1 = a(i.a(com.ideashower.readitlater.h.a.c), i.a(com.ideashower.readitlater.h.a.d));
    if (str1 != null)
    {
      c = new com.pocket.user.c(str3, str1, localUserMeta);
      return;
    }
    str1 = i.a(com.ideashower.readitlater.h.a.b);
    if (!i.a(com.ideashower.readitlater.h.a.al)) {}
    for (;;)
    {
      String str2 = str1;
      if (str1 == null)
      {
        str2 = "";
        d = true;
      }
      c = new b(str3, str2, localUserMeta);
      return;
      try
      {
        str1 = j.a("798yafK!#fs983AS45df,;Td4n,<KDa98y3KSD$(sj@#*h", str1);
      }
      catch (Exception localException)
      {
        com.ideashower.readitlater.util.e.a(localException);
        Object localObject = null;
      }
    }
  }
  
  private static void B()
  {
    i.a(com.ideashower.readitlater.h.a.p, false);
  }
  
  public static com.pocket.widget.av a(com.pocket.widget.au paramau)
  {
    new com.pocket.widget.av()
    {
      public aw a(ValidatedEditText paramAnonymousValidatedEditText, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        paramAnonymousValidatedEditText = k.b(paramAnonymousString);
        if ((paramAnonymousBoolean) && (paramAnonymousValidatedEditText.length() == 0)) {
          return aw.c;
        }
        if (paramAnonymousValidatedEditText.length() >= 6) {
          return aw.a;
        }
        if (paramAnonymousValidatedEditText.length() == 0) {
          as.this.a(2131493433);
        }
        for (;;)
        {
          return aw.b;
          as.this.a(2131493436);
        }
      }
    };
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    return paramString1.substring(10).concat(paramString2);
  }
  
  public static void a() {}
  
  public static void a(at paramat)
  {
    if (!w())
    {
      B();
      paramat.a();
      return;
    }
    com.pocket.oauth.d.a(v(), new f()
    {
      public void a(final com.google.android.gms.b.a paramAnonymousa)
      {
        if (paramAnonymousa == null)
        {
          as.z();
          as.this.a();
          return;
        }
        com.pocket.c.d.a(new at()
        {
          public void a()
          {
            paramAnonymousa.a(new com.google.android.gms.b.c()
            {
              public void a(com.google.android.gms.common.a paramAnonymous3a)
              {
                if (paramAnonymous3a.b())
                {
                  as.z();
                  as.this.a();
                  return;
                }
                paramAnonymous3a = new ErrorReport(-1, g.c().getString(2131493434), String.valueOf(paramAnonymous3a.c()));
                as.this.a(paramAnonymous3a);
              }
            });
          }
          
          public void a(ErrorReport paramAnonymous2ErrorReport)
          {
            as.this.a(paramAnonymous2ErrorReport);
          }
        }).h();
      }
    });
  }
  
  public static void a(au paramau)
  {
    a.add(paramau);
  }
  
  public static void a(UserMeta paramUserMeta)
  {
    i.b().a(com.ideashower.readitlater.h.a.bh, false).a();
    a(paramUserMeta, h(), i.a(com.ideashower.readitlater.h.a.m));
  }
  
  public static void a(UserMeta paramUserMeta, String paramString)
  {
    a(paramUserMeta, paramString, 1);
  }
  
  private static void a(UserMeta paramUserMeta, String paramString, int paramInt)
  {
    Object localObject = a(paramString);
    localObject = i.b().a(com.ideashower.readitlater.h.a.a, paramUserMeta.i()).a(com.ideashower.readitlater.h.a.c, localObject[0]).a(com.ideashower.readitlater.h.a.d, localObject[1]).a(com.ideashower.readitlater.h.a.m, paramInt);
    paramUserMeta.a((l)localObject);
    if (((c instanceof b)) || (i.a(com.ideashower.readitlater.h.a.b))) {
      ((l)localObject).a(com.ideashower.readitlater.h.a.b).a(com.ideashower.readitlater.h.a.al);
    }
    ((l)localObject).a();
    c = new com.pocket.user.c(paramUserMeta.i(), paramString, paramUserMeta);
    y();
  }
  
  public static void a(UserMeta paramUserMeta, String paramString1, String paramString2)
  {
    a(paramUserMeta, paramString1, 2);
    i.b().a(com.ideashower.readitlater.h.a.o, paramString2).a(com.ideashower.readitlater.h.a.p, true).a();
  }
  
  private static String[] a(String paramString)
  {
    return new String[] { org.apache.a.c.g.a(4) + "-" + org.apache.a.c.g.a(4) + "-" + paramString.substring(0, paramString.length() / 2), paramString.substring(paramString.length() / 2) };
  }
  
  public static void b()
  {
    
    if (!d()) {
      com.pocket.c.e.d(false);
    }
    c();
  }
  
  public static void b(au paramau)
  {
    a.remove(paramau);
  }
  
  public static void c()
  {
    if (!l()) {}
    while ((c.h() != null) && (c.i()) && (!i.a(com.ideashower.readitlater.h.a.bh))) {
      return;
    }
    com.pocket.c.e.a(null, false);
  }
  
  public static boolean d()
  {
    return c instanceof com.pocket.user.c;
  }
  
  public static String e()
  {
    return c.a();
  }
  
  public static boolean f()
  {
    return !k.g(e(), "*");
  }
  
  public static String g()
  {
    String str = c.j();
    if (k.e(str) > 0) {
      return str;
    }
    if (f()) {
      return e();
    }
    return j();
  }
  
  public static String h()
  {
    return ((com.pocket.user.c)c).k();
  }
  
  public static String i()
  {
    return c.b();
  }
  
  public static String j()
  {
    return c.f();
  }
  
  public static com.pocket.user.a k()
  {
    return c;
  }
  
  public static boolean l()
  {
    if (c != null) {
      return c.g();
    }
    return false;
  }
  
  public static boolean m()
  {
    boolean bool = true;
    if (!l()) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if ((!g.y()) || (i.a(com.ideashower.readitlater.h.a.cr) == 0)) {
          break;
        }
      } while (i.a(com.ideashower.readitlater.h.a.cr) == 1);
      return false;
    } while (c.h().d() == 1);
    return false;
  }
  
  public static int n()
  {
    return c.h().e();
  }
  
  public static ag o()
  {
    new ag()
    {
      public void a() {}
      
      public void b()
      {
        as.a(new com.pocket.user.c());
      }
      
      public void c() {}
    };
  }
  
  public static boolean p()
  {
    return (d) && (l());
  }
  
  public static int q()
  {
    return c.e();
  }
  
  public static boolean r()
  {
    return !k.c(c.f());
  }
  
  public static boolean s()
  {
    return (!k.c(c.c())) || (!k.c(c.d()));
  }
  
  public static boolean t()
  {
    return i.a(com.ideashower.readitlater.h.a.w);
  }
  
  public static boolean u()
  {
    return (!t()) && (k().h().c());
  }
  
  public static String v()
  {
    return i.a(com.ideashower.readitlater.h.a.o);
  }
  
  public static boolean w()
  {
    return (i.a(com.ideashower.readitlater.h.a.m) == 2) && (v() != null) && (i.a(com.ideashower.readitlater.h.a.p));
  }
  
  public static av x()
  {
    return new av(null);
  }
  
  public static void y()
  {
    if (b != m())
    {
      b = m();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((au)localIterator.next()).i(b);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */