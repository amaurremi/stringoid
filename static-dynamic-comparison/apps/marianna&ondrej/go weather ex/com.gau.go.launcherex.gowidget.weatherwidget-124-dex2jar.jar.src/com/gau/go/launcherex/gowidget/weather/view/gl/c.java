package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;

class c
  implements ServiceConnection
{
  c(GLWeatherWidget11 paramGLWeatherWidget11) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GLWeatherWidget11.access$002(this.a, g.a(paramIBinder));
    try
    {
      GLWeatherWidget11.access$000(this.a).a(GLWeatherWidget11.access$100(this.a));
      com.gtp.a.a.b.c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      this.a.initWidget(GLWeatherWidget11.access$000(this.a).b(), GLWeatherWidget11.access$000(this.a).a(), GLWeatherWidget11.access$000(this.a).a(GLWeatherWidget11.access$200(this.a)));
      if (GLWeatherWidget11.access$300(this.a)) {
        GLWeatherWidget11.access$000(this.a).a(GLWeatherWidget11.access$200(this.a), 2);
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
    GLWeatherWidget11.access$002(this.a, null);
    com.gtp.a.a.b.c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */