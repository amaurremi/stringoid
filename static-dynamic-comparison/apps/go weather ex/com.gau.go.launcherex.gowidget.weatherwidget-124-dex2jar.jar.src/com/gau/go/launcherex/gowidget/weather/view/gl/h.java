package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class h
  implements ServiceConnection
{
  h(GLWeatherWidget21 paramGLWeatherWidget21) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GLWeatherWidget21.access$002(this.a, g.a(paramIBinder));
    try
    {
      GLWeatherWidget21.access$000(this.a).a(GLWeatherWidget21.access$100(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      this.a.initWidget(GLWeatherWidget21.access$000(this.a).b(), GLWeatherWidget21.access$000(this.a).a(), GLWeatherWidget21.access$000(this.a).a(GLWeatherWidget21.access$200(this.a)));
      if (GLWeatherWidget21.access$300(this.a)) {
        GLWeatherWidget21.access$000(this.a).a(GLWeatherWidget21.access$200(this.a), 3);
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
    GLWeatherWidget21.access$002(this.a, null);
    c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */