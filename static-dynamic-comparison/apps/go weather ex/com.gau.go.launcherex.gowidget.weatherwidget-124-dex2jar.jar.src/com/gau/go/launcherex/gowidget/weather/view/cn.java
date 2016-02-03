package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class cn
  implements ServiceConnection
{
  cn(WeatherWidget41Style2 paramWeatherWidget41Style2) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    WeatherWidget41Style2.a(this.a, g.a(paramIBinder));
    try
    {
      WeatherWidget41Style2.b(this.a).a(WeatherWidget41Style2.a(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      WeatherWidget41Style2.a(this.a, WeatherWidget41Style2.b(this.a).b(), WeatherWidget41Style2.b(this.a).a(), WeatherWidget41Style2.b(this.a).a(WeatherWidget41Style2.c(this.a)));
      if (WeatherWidget41Style2.d(this.a)) {
        WeatherWidget41Style2.b(this.a).a(WeatherWidget41Style2.c(this.a), 5);
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
    WeatherWidget41Style2.a(this.a, null);
    c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */