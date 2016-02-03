package com.go.weatherex.themestore;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.gau.go.launcherex.goweather.goplay.ThemeDataHandler;
import com.gau.go.launcherex.goweather.goplay.q;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.e.c;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.g.e;
import com.jiubang.playsdk.imageload.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class u
{
  private static u a;
  private final Context b;
  private final Handler c = new Handler();
  private final aa d;
  private final q e = new q();
  private final ThemeDataHandler f;
  private final ab g = new ab(null);
  private com.jiubang.playsdk.a.x h;
  private int i = 0;
  private boolean j;
  private boolean k;
  private final SparseArray l = new SparseArray(3);
  private boolean m = false;
  private final t n = new t();
  private final List o = new ArrayList();
  private k p = new v(this);
  private com.gau.go.launcherex.goweather.goplay.f q = new w(this);
  private Runnable r = new y(this);
  
  private u(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.d = aa.a();
    this.d.a(this.b);
    this.d.a(this.e);
    this.g.a(this.p);
    this.f = ThemeDataHandler.a(this.b);
    this.f.a(this.q);
    new com.jiubang.playsdk.imageload.a().a(this.b);
  }
  
  public static d a(int paramInt)
  {
    return l().c(paramInt);
  }
  
  private d a(int paramInt, d paramd, com.jiubang.playsdk.a.x paramx)
  {
    d locald;
    if ((paramd == null) || (paramx == null))
    {
      locald = null;
      return locald;
    }
    if (paramd.i() == 1)
    {
      List localList = paramd.e();
      paramd = null;
      int i1 = 0;
      for (;;)
      {
        locald = paramd;
        if (i1 >= localList.size()) {
          break;
        }
        c localc = (c)localList.get(i1);
        locald = this.h.a(localc.a());
        if (locald != null) {
          if (!localc.a(paramInt)) {
            break label105;
          }
        }
        label105:
        for (paramd = locald; paramd != null; paramd = a(paramInt, locald, paramx)) {
          return a(paramd, paramx, paramInt);
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private d a(d paramd, com.jiubang.playsdk.a.x paramx, int paramInt)
  {
    if (paramd == null) {}
    label114:
    label138:
    for (;;)
    {
      return paramd;
      Iterator localIterator = null;
      Object localObject2 = null;
      List localList = paramd.e();
      Object localObject1 = localIterator;
      if (paramx != null)
      {
        localObject1 = localIterator;
        if (localList != null)
        {
          localObject1 = localIterator;
          if (localList.size() > 0)
          {
            localIterator = localList.iterator();
            localObject1 = localObject2;
            if (localIterator.hasNext())
            {
              localObject2 = (c)localIterator.next();
              localObject1 = paramx.a(((c)localObject2).a());
              if (paramInt != ((c)localObject2).a()) {
                break label114;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label138;
        }
        return (d)localObject1;
        localObject2 = a((d)localObject1, paramx, paramInt);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public static List a(d paramd)
  {
    return l().b(paramd);
  }
  
  private List a(List paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new ArrayList();
      return (List)localObject;
    }
    int i1 = 0;
    label16:
    if (i1 < paramList.size()) {
      if (!this.e.d(this.b, (com.jiubang.playsdk.a.a)paramList.get(i1))) {}
    }
    for (;;)
    {
      localObject = paramList;
      if (i1 <= 0) {
        break;
      }
      localObject = paramList;
      if (i1 > paramList.size()) {
        break;
      }
      com.jiubang.playsdk.a.a locala = (com.jiubang.playsdk.a.a)paramList.remove(i1);
      localObject = paramList;
      if (locala == null) {
        break;
      }
      paramList.add(0, locala);
      return paramList;
      i1 += 1;
      break label16;
      i1 = 0;
    }
  }
  
  public static void a(Context paramContext)
  {
    
    if (a == null) {
      a = new u(paramContext);
    }
  }
  
  private void a(SparseArray paramSparseArray)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(paramSparseArray);
    }
  }
  
  public static void a(ac paramac)
  {
    l().c(paramac);
  }
  
  private void a(com.jiubang.playsdk.a.x paramx)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(paramx);
    }
  }
  
  private void a(String paramString)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).b(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(paramString, paramInt);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(paramBoolean);
    }
  }
  
  public static boolean a()
  {
    return l().n();
  }
  
  public static List b(int paramInt)
  {
    return l().d(paramInt);
  }
  
  private List b(d paramd)
  {
    List localList = null;
    if (paramd != null) {
      localList = paramd.f();
    }
    return ad.a(this.b, localList);
  }
  
  public static void b()
  {
    l().o();
  }
  
  public static void b(ac paramac)
  {
    l().d(paramac);
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).c(paramString);
    }
  }
  
  public static t c()
  {
    return l().q();
  }
  
  private d c(int paramInt)
  {
    if (this.h == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("theme type undefined: " + paramInt);
    case 1: 
      paramInt = 40;
    }
    for (;;)
    {
      return a(paramInt, this.h.a(this.h.a()), this.h);
      paramInt = 39;
      continue;
      paramInt = 41;
    }
  }
  
  private void c(ac paramac)
  {
    if (paramac == null) {
      return;
    }
    if (this.o.contains(paramac)) {
      throw new IllegalStateException("did you forget to unregister OnThemeStoreEventListener: " + paramac);
    }
    this.o.add(paramac);
  }
  
  private void c(String paramString)
  {
    Iterator localIterator = new ArrayList(this.o).iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).a(paramString);
    }
  }
  
  private List d(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new IllegalArgumentException("themeType undefined: " + paramInt);
    }
    return a((List)this.l.get(paramInt));
  }
  
  public static void d()
  {
    l().r();
  }
  
  private void d(ac paramac)
  {
    if (paramac == null) {
      return;
    }
    this.o.remove(paramac);
  }
  
  public static aa e()
  {
    return l().s();
  }
  
  public static q f()
  {
    return l().t();
  }
  
  public static boolean g()
  {
    return l().u();
  }
  
  public static void h()
  {
    l().v();
  }
  
  public static void i()
  {
    l().w();
  }
  
  private void j()
  {
    if (this.m) {
      return;
    }
    this.l.clear();
    this.l.put(1, this.e.a(this.b, 1));
    this.l.put(2, this.e.a(this.b, 2));
    this.l.put(3, this.e.a(this.b, 3));
  }
  
  private static void k()
  {
    if (!m()) {
      throw new IllegalStateException("please call initSingleton on main thread...");
    }
  }
  
  private static u l()
  {
    
    if (a == null) {
      throw new IllegalStateException("did you forget to call initSingleton?");
    }
    return a;
  }
  
  private static boolean m()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  private boolean n()
  {
    return this.h != null;
  }
  
  private void o()
  {
    if (this.i > 0) {
      return;
    }
    this.j = false;
    this.k = false;
    if (this.d.f())
    {
      p();
      return;
    }
    if (!e.j(this.b))
    {
      p();
      return;
    }
    this.i += 1;
    this.d.a(0L, 1, 2, 0, this.g);
    this.c.postDelayed(this.r, 5000L);
  }
  
  private void p()
  {
    new x(this, com.jiubang.playsdk.e.f.b(0L, 1, 2, 0)).execute(new Void[0]);
    this.i += 1;
  }
  
  private t q()
  {
    return this.n;
  }
  
  private void r()
  {
    this.e.a(this.n.b);
  }
  
  private aa s()
  {
    return this.d;
  }
  
  private q t()
  {
    return this.e;
  }
  
  private boolean u()
  {
    return this.l.size() > 0;
  }
  
  private void v()
  {
    if (this.m) {
      return;
    }
    this.m = true;
    new z(this).execute(new Void[0]);
  }
  
  private void w()
  {
    aa.a().c();
    p.a().b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */