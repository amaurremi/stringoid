package com.gau.go.launcherex.goweather.goplay.a;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.jiubang.playsdk.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class b
{
  private boolean a = false;
  private ArrayList b = new ArrayList();
  private ArrayList c = new ArrayList();
  private boolean d = false;
  private ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();
  private boolean g = false;
  private ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();
  private HashMap j = new HashMap();
  
  public e a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a(paramContext.getResources().getStringArray(2131558425)[0]);
    case 2: 
      return a("go_widget_theme_white");
    }
    return a("com.gau.go.launcherex.gowidget.weatherwidget");
  }
  
  public e a(a parama)
  {
    return (e)this.j.get(parama.a());
  }
  
  public e a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (this.j.containsKey(paramString)) {
        localObject1 = (e)this.j.get(paramString);
      }
    }
    return (e)localObject1;
  }
  
  public void a()
  {
    this.a = false;
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = false;
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = false;
    this.h = new ArrayList();
    this.i = new ArrayList();
    this.j = new HashMap();
  }
  
  public void a(e parame)
  {
    if ((parame != null) && (!this.j.containsKey(parame.x())))
    {
      this.b.add(0, parame);
      a locala = new a();
      locala.a(parame.u());
      locala.a(parame.y());
      locala.c(parame.z());
      locala.a(parame.A());
      locala.b(parame.x());
      locala.b(true);
      locala.g(parame.w());
      this.c.add(0, locala);
      this.j.put(parame.x(), parame);
    }
  }
  
  public void a(List paramList)
  {
    this.a = true;
    int k = this.b.size() - 1;
    while (k >= 0)
    {
      this.j.remove(((e)this.b.get(k)).x());
      this.b.remove(k);
      this.c.remove(k);
      k -= 1;
    }
    if (paramList != null)
    {
      int m = paramList.size();
      k = 0;
      while (k < m)
      {
        e locale = (e)paramList.get(k);
        this.b.add(locale);
        a locala = new a();
        locala.a(locale.u());
        locala.a(locale.y());
        locala.c(locale.z());
        locala.a(locale.A());
        locala.b(locale.x());
        locala.b(true);
        locala.g(locale.w());
        this.c.add(locala);
        this.j.put(locale.x(), locale);
        k += 1;
      }
    }
  }
  
  public void b(e parame)
  {
    int k;
    if ((parame != null) && (this.j.containsKey(parame.x()))) {
      k = 0;
    }
    for (;;)
    {
      if (k < this.b.size())
      {
        if (((e)this.b.get(k)).x().equals(parame.x()))
        {
          parame.i(((e)this.b.get(k)).m());
          this.b.set(k, parame);
          this.j.put(parame.x(), parame);
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  public void b(List paramList)
  {
    this.d = true;
    int k = this.e.size() - 1;
    while (k >= 0)
    {
      this.j.remove(((e)this.e.get(k)).x());
      this.e.remove(k);
      this.f.remove(k);
      k -= 1;
    }
    if (paramList != null)
    {
      int m = paramList.size();
      k = 0;
      while (k < m)
      {
        e locale = (e)paramList.get(k);
        this.e.add(locale);
        String str = d.a(locale);
        a locala = new a();
        locala.a(locale.u());
        locala.a(locale.y());
        locala.c(locale.z());
        locala.a(locale.A());
        locala.b(str);
        locala.b(true);
        locala.g(locale.w());
        this.f.add(locala);
        this.j.put(str, locale);
        k += 1;
      }
    }
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public ArrayList c()
  {
    return this.c;
  }
  
  public void c(e parame)
  {
    if ((parame != null) && (this.j.containsKey(parame.x())))
    {
      Iterator localIterator = this.b.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (e)localIterator.next();
        if (((e)localObject).x().equalsIgnoreCase(parame.x())) {
          this.b.remove(localObject);
        }
      }
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        if (((a)localObject).a().equalsIgnoreCase(parame.x())) {
          this.c.remove(localObject);
        }
      }
      this.j.remove(parame.x());
    }
  }
  
  public void c(List paramList)
  {
    this.g = true;
    int k = this.h.size() - 1;
    while (k >= 0)
    {
      this.j.remove(((e)this.h.get(k)).x());
      this.h.remove(k);
      this.i.remove(k);
      k -= 1;
    }
    if (paramList != null)
    {
      int m = paramList.size();
      k = 0;
      while (k < m)
      {
        e locale = (e)paramList.get(k);
        this.h.add(locale);
        a locala = new a();
        locala.a(locale.u());
        locala.a(locale.y());
        locala.c(locale.z());
        locala.a(locale.A());
        locala.b(locale.x());
        locala.b(true);
        locala.g(locale.w());
        locala.c(true);
        this.i.add(locala);
        this.j.put(locale.x(), locale);
        k += 1;
      }
    }
  }
  
  public void d(e parame)
  {
    if ((parame != null) && (!this.j.containsKey(parame.x())))
    {
      this.e.add(0, parame);
      String str = d.a(parame);
      a locala = new a();
      locala.a(parame.u());
      locala.a(parame.y());
      locala.c(parame.z());
      locala.a(parame.A());
      locala.b(str);
      locala.b(true);
      locala.g(parame.w());
      this.f.add(0, locala);
      this.j.put(str, parame);
    }
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public ArrayList e()
  {
    return this.f;
  }
  
  public void e(e parame)
  {
    int k;
    if ((parame != null) && (this.j.containsKey(parame.x()))) {
      k = 0;
    }
    for (;;)
    {
      if (k < this.e.size())
      {
        if (((e)this.e.get(k)).x().equals(parame.x()))
        {
          parame.i(((e)this.e.get(k)).m());
          this.e.set(k, parame);
          this.j.put(parame.x(), parame);
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  public void f(e parame)
  {
    String str = d.a(parame);
    if ((parame != null) && (this.j.containsKey(str)))
    {
      parame = this.e.iterator();
      Object localObject;
      while (parame.hasNext())
      {
        localObject = (e)parame.next();
        if (d.a((e)localObject).equalsIgnoreCase(str)) {
          this.e.remove(localObject);
        }
      }
      parame = this.f.iterator();
      while (parame.hasNext())
      {
        localObject = (a)parame.next();
        if (((a)localObject).a().equalsIgnoreCase(str)) {
          this.f.remove(localObject);
        }
      }
      this.j.remove(str);
    }
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public ArrayList g()
  {
    return this.i;
  }
  
  public void g(e parame)
  {
    if ((parame != null) && (!this.j.containsKey(parame.x())))
    {
      this.h.add(0, parame);
      a locala = new a();
      locala.a(parame.u());
      locala.a(parame.y());
      locala.c(parame.z());
      locala.a(parame.A());
      locala.b(parame.x());
      locala.b(true);
      locala.g(parame.w());
      locala.c(true);
      this.i.add(0, locala);
      this.j.put(parame.x(), parame);
    }
  }
  
  public void h(e parame)
  {
    int k;
    if ((parame != null) && (this.j.containsKey(parame.x()))) {
      k = 0;
    }
    for (;;)
    {
      if (k < this.h.size())
      {
        if (((e)this.h.get(k)).x().equals(parame.x()))
        {
          parame.i(((e)this.h.get(k)).m());
          this.h.set(k, parame);
          this.j.put(parame.x(), parame);
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  public void i(e parame)
  {
    if ((parame != null) && (this.j.containsKey(parame.x())))
    {
      Iterator localIterator = this.h.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (e)localIterator.next();
        if (((e)localObject).x().equalsIgnoreCase(parame.x())) {
          this.h.remove(localObject);
        }
      }
      localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        if (((a)localObject).a().equalsIgnoreCase(parame.x())) {
          this.i.remove(localObject);
        }
      }
      this.j.remove(parame.x());
    }
  }
  
  public boolean j(e parame)
  {
    if (parame == null) {
      return false;
    }
    Iterator localIterator;
    if (parame.D())
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).i(false);
      }
      parame.i(true);
    }
    for (;;)
    {
      return true;
      if (parame.C())
      {
        localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).i(false);
        }
        parame.i(true);
      }
      else
      {
        localIterator = this.h.iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).i(false);
        }
        parame.i(true);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */