package com.gau.go.launcherex.gowidget.weather.c;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import com.gau.go.launcherex.gowidget.gcm.b;
import com.gau.go.launcherex.gowidget.messagecenter.util.m;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements o
{
  private static c b;
  private Context a;
  private SparseBooleanArray c = new SparseBooleanArray();
  private e d;
  private com.gau.go.launcherex.gowidget.weather.util.f e;
  private com.gau.go.launcherex.gowidget.language.d f;
  private m g;
  private i h;
  private com.gau.go.launcherex.gowidget.weather.d.f i;
  private b j;
  private g k;
  private final List l = new ArrayList();
  
  private c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    j();
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new c(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void j()
  {
    this.d = e.a(this.a);
    this.e = com.gau.go.launcherex.gowidget.weather.util.f.a(this.a);
    this.h = new i(this.a);
    this.f = com.gau.go.launcherex.gowidget.language.d.a(this.a);
    this.g = m.a(this.a);
    this.i = com.gau.go.launcherex.gowidget.weather.d.f.a(this.a);
    this.j = b.a(this.a);
    this.k = new g(this.a);
  }
  
  private void k()
  {
    if (this.d.f()) {
      this.d.c();
    }
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    this.a.sendStickyBroadcast(localIntent);
  }
  
  public void a()
  {
    this.c.put(1, false);
    this.c.put(4, false);
    this.c.put(5, false);
    this.c.put(6, false);
    this.d.a(this);
    this.e.a(this);
  }
  
  public void a(int paramInt)
  {
    this.c.put(paramInt, true);
    if (paramInt == 1)
    {
      this.f.j();
      this.h.a(this);
      this.k.a(this);
    }
    if (b())
    {
      k();
      i();
    }
  }
  
  public void a(d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("DataStateListener can not be null!");
    }
    if (this.l.contains(paramd)) {
      throw new IllegalStateException("DataStateListener had register before, did you forget to unregister it?");
    }
    this.l.add(paramd);
  }
  
  public void b(d paramd)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("DataStateListener can not be null!");
    }
    if (!this.l.contains(paramd)) {
      throw new IllegalStateException("DataStateListener did not register before, do unregister the wrong one?");
    }
    this.l.remove(paramd);
  }
  
  public boolean b()
  {
    int n = this.c.size();
    int m;
    if (n != 0) {
      m = 0;
    }
    while (m < n)
    {
      if (!this.c.valueAt(m)) {
        return false;
      }
      m += 1;
    }
    return true;
  }
  
  public com.gau.go.launcherex.gowidget.language.d c()
  {
    return this.f;
  }
  
  public i d()
  {
    return this.h;
  }
  
  public com.gau.go.launcherex.gowidget.weather.d.f e()
  {
    return this.i;
  }
  
  public e f()
  {
    return this.d;
  }
  
  public g g()
  {
    return this.k;
  }
  
  public com.gau.go.launcherex.gowidget.weather.util.f h()
  {
    return this.e;
  }
  
  protected void i()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.l);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d)((Iterator)localObject).next()).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */