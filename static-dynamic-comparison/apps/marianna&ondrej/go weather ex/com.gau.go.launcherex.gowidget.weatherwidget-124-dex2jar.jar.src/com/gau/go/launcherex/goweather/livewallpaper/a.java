package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.Context;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  ConcurrentHashMap a;
  private int b;
  private ExecutorService c;
  private String d;
  private Handler e;
  private Context f;
  private com.gau.go.launcherex.goweather.livewallpaper.b.c g;
  private int h;
  private boolean i;
  private boolean j;
  
  public a(Context paramContext, com.gau.go.launcherex.goweather.livewallpaper.b.c paramc)
  {
    this.f = paramContext;
    this.g = paramc;
    this.d = this.f.getPackageName();
    c();
    this.a = new ConcurrentHashMap();
    this.c = Executors.newCachedThreadPool();
    this.h = 0;
    this.i = true;
    this.j = false;
  }
  
  private void c()
  {
    this.e = new b(this);
  }
  
  private ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("wallpaper/weather_dynamicbackground_sunny_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_sunny_night.xml");
    localArrayList.add("wallpaper/weather_background_sunny_day.xml");
    localArrayList.add("wallpaper/weather_background_sunny_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_cloudy_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_cloudy_night.xml");
    localArrayList.add("wallpaper/weather_background_cloudy_day.xml");
    localArrayList.add("wallpaper/weather_background_cloudy_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_overcast_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_overcast_night.xml");
    localArrayList.add("wallpaper/weather_background_overcast_day.xml");
    localArrayList.add("wallpaper/weather_background_overcast_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_rainy_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_rainy_night.xml");
    localArrayList.add("wallpaper/weather_background_rainy_day.xml");
    localArrayList.add("wallpaper/weather_background_rainy_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_snowy_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_snowy_night.xml");
    localArrayList.add("wallpaper/weather_background_snowy_day.xml");
    localArrayList.add("wallpaper/weather_background_snowy_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_foggy_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_foggy_night.xml");
    localArrayList.add("wallpaper/weather_background_foggy_day.xml");
    localArrayList.add("wallpaper/weather_background_foggy_night.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_thunderstorm_day.xml");
    localArrayList.add("wallpaper/weather_dynamicbackground_thunderstorm_night.xml");
    localArrayList.add("wallpaper/weather_background_thunderstorm_day.xml");
    localArrayList.add("wallpaper/weather_background_thunderstorm_night.xml");
    return localArrayList;
  }
  
  public z a(String paramString)
  {
    return (z)this.a.get(paramString);
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.j = true;
    this.a.clear();
    this.c.shutdown();
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
    com.gtp.a.a.b.c.a("wallpaper", "setPackageName:[packageName]=" + paramString);
    if (d.a(paramString))
    {
      this.g.b(this.d);
      return;
    }
    this.h = 0;
    this.i = true;
    paramString = d();
    this.b = paramString.size();
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.c.execute(new c(this, this.f, str, true, false));
    }
    paramString.clear();
  }
  
  public void c(String paramString)
  {
    this.c.execute(new c(this, this.f, paramString, false, false));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */