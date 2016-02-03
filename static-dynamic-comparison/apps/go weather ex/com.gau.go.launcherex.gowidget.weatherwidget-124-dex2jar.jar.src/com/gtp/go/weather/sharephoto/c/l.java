package com.gtp.go.weather.sharephoto.c;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.service.a.g;
import com.gtp.go.weather.sharephoto.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class l
{
  private static l a;
  private final ExecutorService b = Executors.newSingleThreadExecutor();
  private final ExecutorService c = Executors.newFixedThreadPool(2);
  private final List d = new ArrayList();
  private final HashMap e = new HashMap();
  private final List f = new ArrayList();
  private final g g = new m(this);
  
  private l()
  {
    com.gau.go.launcherex.gowidget.weather.service.a.b.a(this.g);
  }
  
  private static l a()
  {
    if (a == null) {
      a = new l();
    }
    return a;
  }
  
  public static void a(Context paramContext, e parame)
  {
    if ((parame == null) || (paramContext == null)) {}
    while (parame.f() == -1L) {
      return;
    }
    a(new n(paramContext.getApplicationContext(), parame));
  }
  
  public static void a(com.gau.go.launcherex.gowidget.weather.service.a.a parama)
  {
    if (parama == null) {
      return;
    }
    a().b(parama);
  }
  
  public static void a(g paramg)
  {
    com.gau.go.launcherex.gowidget.weather.service.a.b.a(paramg);
  }
  
  public static void a(a parama)
  {
    a().c(parama);
  }
  
  private void a(n paramn)
  {
    e locale = paramn.c();
    if (!b(Long.valueOf(locale.f())))
    {
      this.e.put(Long.valueOf(locale.f()), paramn);
      Iterator localIterator = new ArrayList(this.d).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(locale);
      }
      this.f.add(paramn);
      com.gau.go.launcherex.gowidget.weather.service.a.b.a(paramn, this.c);
    }
  }
  
  public static boolean a(Long paramLong)
  {
    return a().b(paramLong);
  }
  
  private void b(com.gau.go.launcherex.gowidget.weather.service.a.a parama)
  {
    if (this.f.contains(parama)) {}
    do
    {
      return;
      if ((parama instanceof b))
      {
        this.f.add(parama);
        com.gau.go.launcherex.gowidget.weather.service.a.b.a(parama, this.b);
        return;
      }
    } while (!(parama instanceof n));
    a((n)parama);
  }
  
  public static void b(g paramg)
  {
    com.gau.go.launcherex.gowidget.weather.service.a.b.b(paramg);
  }
  
  public static void b(a parama)
  {
    a().d(parama);
  }
  
  private void b(n paramn)
  {
    paramn = paramn.c();
    this.e.remove(Long.valueOf(paramn.f()));
    Iterator localIterator = new ArrayList(this.d).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramn);
    }
  }
  
  private boolean b(Long paramLong)
  {
    return this.e.get(paramLong) != null;
  }
  
  private void c(a parama)
  {
    if (this.d.contains(parama)) {
      throw new IllegalStateException(parama.toString() + "had be added before, did you forget to call removeListener()?");
    }
    this.d.add(parama);
  }
  
  private void d(a parama)
  {
    this.d.remove(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */