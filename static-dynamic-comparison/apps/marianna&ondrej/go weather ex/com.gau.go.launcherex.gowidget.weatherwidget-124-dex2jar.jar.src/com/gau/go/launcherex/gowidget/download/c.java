package com.gau.go.launcherex.gowidget.download;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static volatile c f = null;
  private ConcurrentHashMap a = null;
  private List b = null;
  private List c = null;
  private ConcurrentHashMap d = null;
  private int e = 2;
  private Context g = null;
  
  private c(Context paramContext)
  {
    this.g = paramContext;
    this.a = new ConcurrentHashMap();
    this.d = new ConcurrentHashMap();
    this.b = Collections.synchronizedList(new ArrayList());
    this.c = Collections.synchronizedList(new ArrayList());
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = new c(paramContext);
      }
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  public ConcurrentHashMap a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    if (this.a != null)
    {
      e locale = (e)this.a.get(Long.valueOf(paramLong));
      if (locale != null) {
        locale.b(7);
      }
    }
  }
  
  public void a(e parame)
  {
    Object localObject;
    if ((this.g != null) && (parame != null))
    {
      localObject = parame.c();
      String str1 = parame.d();
      String str2 = parame.g();
      if ((localObject != null) && (!"".equals(((String)localObject).trim())) && (str1 != null) && (!"".equals(str1.trim())) && (str2 != null) && (!"".equals(str2.trim())))
      {
        localObject = Long.valueOf(parame.b());
        if ((this.a != null) && (!this.a.contains(parame))) {
          this.a.put(localObject, parame);
        }
        if ((this.b == null) || (this.b.size() >= this.e)) {
          break label194;
        }
        this.b.add(localObject);
        localObject = new Intent();
        ((Intent)localObject).setClass(this.g, DownloadService.class);
        ((Intent)localObject).setFlags(268435456);
        ((Intent)localObject).putExtra("download_task_id_key", parame.b());
        this.g.startService((Intent)localObject);
      }
    }
    return;
    label194:
    parame.b(1);
    if (this.c != null) {
      this.c.add(localObject);
    }
    parame.c(7);
  }
  
  public void a(Long paramLong)
  {
    if ((this.b != null) && (this.b.contains(paramLong)))
    {
      this.b.remove(paramLong);
      if ((this.c != null) && (this.c.size() > 0)) {
        a(d(((Long)this.c.remove(0)).longValue()));
      }
    }
  }
  
  public void b(long paramLong)
  {
    if (this.a != null) {
      b((e)this.a.get(Long.valueOf(paramLong)));
    }
  }
  
  public void b(e parame)
  {
    if (parame != null)
    {
      parame.b(8);
      a(parame);
    }
  }
  
  public e c(long paramLong)
  {
    Object localObject = null;
    if ((this.b != null) && (this.b.contains(Long.valueOf(paramLong)))) {
      this.b.remove(Long.valueOf(paramLong));
    }
    if ((this.c != null) && (this.c.contains(Long.valueOf(paramLong)))) {
      this.c.remove(Long.valueOf(paramLong));
    }
    if (this.a != null)
    {
      e locale = (e)this.a.remove(Long.valueOf(paramLong));
      localObject = locale;
      if (locale != null)
      {
        if ((locale.h() == 5) && (this.d != null)) {
          this.d.put(Long.valueOf(locale.b()), locale.j());
        }
        locale.b(6);
        locale.k();
        localObject = locale;
      }
    }
    return (e)localObject;
  }
  
  public e c(e parame)
  {
    e locale = null;
    if (parame != null) {
      locale = c(parame.b());
    }
    return locale;
  }
  
  public e d(long paramLong)
  {
    e locale = null;
    if (this.a != null) {
      locale = (e)this.a.get(Long.valueOf(paramLong));
    }
    return locale;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */