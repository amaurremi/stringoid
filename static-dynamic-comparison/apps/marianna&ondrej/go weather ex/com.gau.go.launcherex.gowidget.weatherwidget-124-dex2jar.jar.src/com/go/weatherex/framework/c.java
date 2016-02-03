package com.go.weatherex.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  extends b
{
  private final List a = new ArrayList();
  private final List b = new ArrayList();
  private Context c;
  private com.gau.go.launcherex.gowidget.weather.c.c d;
  private f e;
  private com.go.weatherex.city.c f;
  private final BroadcastReceiver g = new d(this);
  
  public c(Context paramContext)
  {
    this.c = paramContext;
    this.d = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext);
    this.e = this.d.h();
    this.f = com.go.weatherex.city.c.a();
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_VISIBILITY_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PRESSURE_UNIT");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.TIME_TICK");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION_FAILED");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE");
    this.c.registerReceiver(this.g, paramContext);
  }
  
  private void d(boolean paramBoolean)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).d(paramBoolean);
    }
    this.b.clear();
  }
  
  private void f()
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).e();
    }
    this.b.clear();
  }
  
  public void a()
  {
    this.c.unregisterReceiver(this.g);
  }
  
  protected void a(int paramInt)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
    this.b.clear();
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("WeatherChangeListener can not be null!");
    }
    if (this.a.contains(parama)) {
      throw new IllegalStateException("WeatherChangeListener had register before, did you forget to unregister it?");
    }
    this.a.add(parama);
  }
  
  protected void a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.f.b(paramString1);
    }
    this.f.b(paramString1);
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.a(paramString1, paramString2, this.e.a(paramString1, paramArrayList));
      locala.b(paramArrayList);
    }
    this.b.clear();
  }
  
  protected void a(List paramList)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramList);
    }
    this.b.clear();
  }
  
  protected void a(List paramList, int paramInt, String paramString, ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    int i = paramInt;
    if (!r.c(paramInt, 0, j - 1)) {
      i = j - 1;
    }
    paramString = (WeatherBean)paramArrayList.get(i);
    if (paramString != null)
    {
      paramString = paramString.c();
      this.f.b(paramString);
    }
    this.b.addAll(this.a);
    paramString = this.b.iterator();
    while (paramString.hasNext())
    {
      a locala = (a)paramString.next();
      locala.a(paramList, i);
      locala.b(paramArrayList);
    }
    this.b.clear();
  }
  
  protected void a(List paramList, w paramw)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramList, paramw);
    }
    this.b.clear();
  }
  
  protected void a(boolean paramBoolean)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramBoolean);
    }
    this.b.clear();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.b.addAll(this.a);
    int j = -1;
    int i = j;
    if (paramBoolean)
    {
      localObject = this.e.g();
      i = j;
      if (localObject != null)
      {
        i = ((WeatherBean)localObject).q();
        this.f.b(((WeatherBean)localObject).c());
      }
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(paramBoolean, paramString1, paramString2, i);
    }
    this.b.clear();
  }
  
  protected void b()
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
    this.b.clear();
  }
  
  protected void b(int paramInt)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramInt);
    }
    this.b.clear();
  }
  
  public void b(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("WeatherChangeListener can not be null!");
    }
    if (!this.a.contains(parama)) {
      throw new IllegalStateException("WeatherChangeListener did not register before, do unregister the wrong one?");
    }
    this.a.remove(parama);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramBoolean);
    }
    this.b.clear();
  }
  
  protected void c()
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
    this.b.clear();
  }
  
  protected void c(int paramInt)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c(paramInt);
    }
    this.b.clear();
  }
  
  protected void c(boolean paramBoolean)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c(paramBoolean);
    }
    this.b.clear();
  }
  
  protected void d()
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c();
    }
    this.b.clear();
  }
  
  protected void d(int paramInt)
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).d(paramInt);
    }
    this.b.clear();
  }
  
  protected void e()
  {
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).d();
    }
    this.b.clear();
  }
  
  protected void e(int paramInt)
  {
    this.d.g().a(0, paramInt);
    this.b.addAll(this.a);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).e(paramInt);
    }
    this.b.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */