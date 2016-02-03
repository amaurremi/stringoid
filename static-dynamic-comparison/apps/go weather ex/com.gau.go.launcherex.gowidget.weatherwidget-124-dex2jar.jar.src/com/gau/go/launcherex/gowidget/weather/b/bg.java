package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.jiubang.goweather.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bg
{
  private final Context a;
  private com.gau.go.launcherex.gowidget.weather.util.f b;
  private List c;
  private Handler d;
  private boolean e = false;
  private Intent f = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED");
  
  public bg(Context paramContext)
  {
    this.a = paramContext;
    this.c = new ArrayList();
    this.b = com.gau.go.launcherex.gowidget.weather.util.f.a(paramContext.getApplicationContext());
    d();
  }
  
  private void a(bj parambj)
  {
    Iterator localIterator = bj.a(parambj).iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while ((locala.a != 1) && (locala.a != 2));
    for (boolean bool = true;; bool = false)
    {
      if (bj.b(parambj) == 3) {
        a(bool);
      }
      for (;;)
      {
        this.a.removeStickyBroadcast(this.f);
        this.b.a(bj.c(parambj).c(), bj.c(parambj).e(), bj.a(parambj), bj.b(parambj), bj.d(parambj));
        return;
        if ((bj.b(parambj) == 2) || (bj.b(parambj) == 5)) {
          an.a(this.a).b(bool);
        }
      }
    }
  }
  
  private void a(bl parambl)
  {
    if ((parambl.a != null) && (!parambl.a.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = parambl.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((RequestBean)localIterator.next()).a);
      }
      this.f.putStringArrayListExtra("cityIds", localArrayList);
      this.a.sendStickyBroadcast(this.f);
      new bj(this, parambl.a, parambl.b, parambl.c).execute(new Void[0]);
      return;
    }
    f();
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("weather_info_file", 0).edit();
    if (paramBoolean) {
      localEditor.putLong("KEY_REFRESH_WEATHER_WHEN_ENTER_APP", System.currentTimeMillis());
    }
    localEditor.commit();
  }
  
  private void b(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = new bl(paramArrayList, paramInt1, paramInt2);
    this.c.add(paramArrayList);
    if ((this.c.size() == 1) && (this.e)) {
      a(paramArrayList);
    }
  }
  
  private void d()
  {
    this.d = new bh(this);
  }
  
  private boolean e()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      bl localbl = (bl)localIterator.next();
      if ((localbl.b == 22) && (localbl.c != 2) && (localbl.c != 5)) {
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    if (!this.c.isEmpty())
    {
      this.c.remove(0);
      if (!this.c.isEmpty()) {
        a((bl)this.c.get(0));
      }
    }
  }
  
  public void a()
  {
    this.e = true;
    if (!this.c.isEmpty()) {
      a((bl)this.c.get(0));
    }
  }
  
  public void a(int paramInt)
  {
    if (!e())
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.b.f();
      if (!((ArrayList)localObject).isEmpty())
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WeatherBean localWeatherBean = (WeatherBean)((Iterator)localObject).next();
          RequestBean localRequestBean = new RequestBean();
          localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
          localArrayList.add(localRequestBean);
        }
        b(localArrayList, 22, paramInt);
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 22) || (!e()))
    {
      if (paramInt2 == 3) {
        a(false);
      }
      b(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    return !this.c.isEmpty();
  }
  
  public void c()
  {
    this.e = false;
    this.c.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */