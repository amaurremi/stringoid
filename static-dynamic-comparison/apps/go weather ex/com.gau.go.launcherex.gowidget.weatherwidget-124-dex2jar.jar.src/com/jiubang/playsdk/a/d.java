package com.jiubang.playsdk.a;

import android.content.Context;
import com.android.a.aa;
import com.jiubang.playsdk.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class d
{
  public Random a = new Random(System.currentTimeMillis());
  private final com.android.a.s b;
  private final s c;
  private t d;
  private Context e;
  private final HashMap f = new HashMap();
  private final Set g = new HashSet();
  private final LinkedList h = new LinkedList();
  private a i = null;
  
  public d(Context paramContext, com.android.a.s params, t paramt)
  {
    this.e = paramContext;
    this.b = params;
    this.c = new b(new c());
    this.d = paramt;
  }
  
  private com.android.a.p a(String paramString1, String paramString2, p paramp)
  {
    paramString1 = new o(paramString1, paramp, new e(this, paramString2), new f(this, paramString2));
    paramString1.a(false);
    return paramString1;
  }
  
  public static String a(Context paramContext)
  {
    String str = com.jiubang.playsdk.g.b.a;
    if (!com.jiubang.playsdk.g.e.a(paramContext)) {
      str = com.jiubang.playsdk.g.b.c;
    }
    return str;
  }
  
  private void a(String paramString, aa paramaa)
  {
    this.c.a(paramString, false);
    paramString = (h)this.f.remove(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.h.remove(paramString);
      paramString = h.a(paramString).iterator();
      while (paramString.hasNext())
      {
        l locall = (l)paramString.next();
        if (locall.a != null) {
          locall.a.a(paramaa);
        }
      }
    }
  }
  
  private void a(String paramString, Object paramObject)
  {
    paramString = (h)this.f.remove(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.h.remove(paramString);
      paramString = h.a(paramString).iterator();
      while (paramString.hasNext())
      {
        l locall = (l)paramString.next();
        if (locall.a != null) {
          locall.a.a(paramObject);
        }
      }
    }
  }
  
  private String b(Context paramContext)
  {
    paramContext = a(paramContext);
    return paramContext + "/recommendedapp/remdinfo.do?rd=" + this.a.nextLong();
  }
  
  public com.jiubang.playsdk.e.d a(String paramString)
  {
    return (com.jiubang.playsdk.e.d)this.c.e(paramString);
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, k paramk)
  {
    String str = com.jiubang.playsdk.e.f.b(paramLong, paramInt1, paramInt2, paramInt3);
    if (this.c.a(str))
    {
      paramk.a(this.c.c(str));
      return;
    }
    paramk = new l(this, paramk);
    Object localObject = (h)this.f.get(str);
    if (localObject != null)
    {
      ((h)localObject).a(paramk);
      return;
    }
    localObject = a(b(this.e), str, new i(this, str, new com.jiubang.playsdk.e.h(paramLong, paramInt1, paramInt2, paramInt3)));
    ((com.android.a.p)localObject).a(str);
    a(new h(this, (com.android.a.p)localObject, paramk));
  }
  
  public void a(long paramLong, k paramk)
  {
    paramk = new l(this, paramk);
    Object localObject = (h)this.f.get("appinfo_detail");
    if (localObject != null)
    {
      ((h)localObject).a(paramk);
      return;
    }
    localObject = a(com.jiubang.playsdk.g.m.c(this.e), "appinfo_detail", new g(this, paramLong));
    ((com.android.a.p)localObject).a("appinfo_detail");
    a(new h(this, (com.android.a.p)localObject, paramk));
  }
  
  public void a(h paramh)
  {
    com.jiubang.playsdk.g.d.a("DataLoader", "addDownQueue:" + paramh);
    this.b.a(h.b(paramh));
    this.f.put(paramh.a(), paramh);
    this.h.add(paramh);
  }
  
  public void a(k paramk)
  {
    paramk = new l(this, paramk);
    Object localObject = (h)this.f.get("has_new_state");
    if (localObject != null)
    {
      ((h)localObject).a(paramk);
      return;
    }
    localObject = a(com.jiubang.playsdk.g.m.b(this.e), "has_new_state", new j(this));
    ((com.android.a.p)localObject).a("has_new_state");
    a(new h(this, (com.android.a.p)localObject, paramk));
  }
  
  void a(Object paramObject)
  {
    Iterator localIterator1 = this.g.iterator();
    while (localIterator1.hasNext()) {
      if (((h)localIterator1.next()).a(paramObject)) {
        localIterator1.remove();
      }
    }
    Iterator localIterator2 = this.h.iterator();
    while (localIterator1.hasNext())
    {
      h localh = (h)localIterator2.next();
      if (localh.a(paramObject))
      {
        localIterator1.remove();
        this.f.remove(localh.a());
      }
    }
    localIterator1 = this.f.values().iterator();
    while (localIterator1.hasNext()) {
      if (((h)localIterator1.next()).a(paramObject)) {
        localIterator1.remove();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, k paramk)
  {
    a("other_themes_of_the_suit");
    paramk = new l(this, paramk);
    h localh = (h)this.f.get("other_themes_of_the_suit");
    if (localh != null)
    {
      localh.a(paramk);
      return;
    }
    paramString = a(com.jiubang.playsdk.g.m.a(this.e), "other_themes_of_the_suit", new m(this, paramString, paramInt1, paramInt2));
    paramString.a("other_themes_of_the_suit");
    a(new h(this, paramString, paramk));
  }
  
  public x b(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public boolean c(String paramString)
  {
    return this.c.d(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */