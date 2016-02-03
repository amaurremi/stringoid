package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.scriptengine.parser.DescriptionBean;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  ConcurrentHashMap a;
  private String b;
  private Context c;
  private Handler d;
  private ExecutorService e;
  private int f;
  
  public a(Context paramContext)
  {
    this.c = paramContext;
    this.a = new ConcurrentHashMap();
    this.b = this.c.getPackageName();
    c();
    this.e = Executors.newCachedThreadPool();
  }
  
  private void a(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
  {
    paramString1 = ((z)this.a.get(paramString1)).a();
    DescriptionBean localDescriptionBean = ((z)this.a.get(paramString2)).a();
    if (paramString1 == null)
    {
      paramString1 = new DescriptionBean();
      paramString1.a(1);
    }
    for (;;)
    {
      paramString1.b(paramInt);
      if (localDescriptionBean == null)
      {
        localDescriptionBean = new DescriptionBean();
        localDescriptionBean.a(2);
      }
      for (;;)
      {
        localDescriptionBean.b(paramInt);
        paramInt = paramString1.a();
        int i = localDescriptionBean.a();
        if ((paramInt == 0) && (i == 0))
        {
          this.a.remove(paramString2);
          paramArrayList.add(paramString1);
          return;
        }
        paramArrayList.add(paramString1);
        paramArrayList.add(localDescriptionBean);
        return;
      }
    }
  }
  
  private void c()
  {
    this.d = new b(this);
  }
  
  private ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("background/weather_dynamicbackground_sunny_day.xml");
    localArrayList.add("background/weather_dynamicbackground_sunny_night.xml");
    localArrayList.add("background/weather_dynamicbackground_cloudy_day.xml");
    localArrayList.add("background/weather_dynamicbackground_cloudy_night.xml");
    localArrayList.add("background/weather_dynamicbackground_overcast_day.xml");
    localArrayList.add("background/weather_dynamicbackground_overcast_night.xml");
    localArrayList.add("background/weather_dynamicbackground_rainy_day.xml");
    localArrayList.add("background/weather_dynamicbackground_rainy_night.xml");
    localArrayList.add("background/weather_dynamicbackground_snowy_day.xml");
    localArrayList.add("background/weather_dynamicbackground_snowy_night.xml");
    localArrayList.add("background/weather_dynamicbackground_foggy_day.xml");
    localArrayList.add("background/weather_dynamicbackground_foggy_night.xml");
    localArrayList.add("background/weather_dynamicbackground_thunderstorm_day.xml");
    localArrayList.add("background/weather_dynamicbackground_thunderstorm_night.xml");
    return localArrayList;
  }
  
  private ArrayList e()
  {
    ArrayList localArrayList = new ArrayList();
    a("background/weather_dynamicbackground_sunny_day.xml", "background/weather_dynamicbackground_sunny_night.xml", 2, localArrayList);
    a("background/weather_dynamicbackground_overcast_day.xml", "background/weather_dynamicbackground_overcast_night.xml", 4, localArrayList);
    a("background/weather_dynamicbackground_cloudy_day.xml", "background/weather_dynamicbackground_cloudy_night.xml", 3, localArrayList);
    a("background/weather_dynamicbackground_foggy_day.xml", "background/weather_dynamicbackground_foggy_night.xml", 6, localArrayList);
    a("background/weather_dynamicbackground_rainy_day.xml", "background/weather_dynamicbackground_rainy_night.xml", 7, localArrayList);
    a("background/weather_dynamicbackground_snowy_day.xml", "background/weather_dynamicbackground_snowy_night.xml", 5, localArrayList);
    a("background/weather_dynamicbackground_thunderstorm_day.xml", "background/weather_dynamicbackground_thunderstorm_night.xml", 8, localArrayList);
    return localArrayList;
  }
  
  public z a(String paramString)
  {
    return (z)this.a.get(paramString);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.a.clear();
    this.e.shutdown();
  }
  
  public void b(String paramString)
  {
    this.e.execute(new c(this, this.c, paramString, false, false));
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
    this.d.sendEmptyMessageDelayed(0, 0L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */