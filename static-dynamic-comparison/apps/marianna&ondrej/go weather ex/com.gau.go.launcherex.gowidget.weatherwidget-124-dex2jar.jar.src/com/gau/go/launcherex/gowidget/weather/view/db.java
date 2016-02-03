package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class db
  implements ServiceConnection
{
  db(WeatherWidgetDays41 paramWeatherWidgetDays41) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WeatherWidgetDays41.a(this.a, g.a(paramIBinder));
    try
    {
      WeatherWidgetDays41.b(this.a).a(WeatherWidgetDays41.a(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      WeatherWidgetDays41.a(this.a, WeatherWidgetDays41.b(this.a).b(), WeatherWidgetDays41.b(this.a).a(), WeatherWidgetDays41.b(this.a).a(WeatherWidgetDays41.c(this.a)));
      if (WeatherWidgetDays41.d(this.a)) {
        WeatherWidgetDays41.b(this.a).a(WeatherWidgetDays41.c(this.a), 4);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    WeatherWidgetDays41.a(this.a, null);
    c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */