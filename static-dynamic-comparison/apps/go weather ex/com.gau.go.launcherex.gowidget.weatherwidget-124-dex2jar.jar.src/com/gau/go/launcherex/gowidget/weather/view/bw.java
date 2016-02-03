package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class bw
  implements ServiceConnection
{
  bw(WeatherWidget11 paramWeatherWidget11) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WeatherWidget11.a(this.a, g.a(paramIBinder));
    try
    {
      WeatherWidget11.b(this.a).a(WeatherWidget11.a(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      this.a.a(WeatherWidget11.b(this.a).b(), WeatherWidget11.b(this.a).a(), WeatherWidget11.b(this.a).a(WeatherWidget11.c(this.a)));
      if (WeatherWidget11.d(this.a)) {
        WeatherWidget11.b(this.a).a(WeatherWidget11.c(this.a), 2);
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
    WeatherWidget11.a(this.a, null);
    c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */