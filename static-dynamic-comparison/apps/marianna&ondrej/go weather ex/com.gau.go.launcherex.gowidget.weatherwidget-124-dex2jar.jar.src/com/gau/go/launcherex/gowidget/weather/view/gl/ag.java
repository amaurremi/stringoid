package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class ag
  implements ServiceConnection
{
  ag(GLWeatherWidgetDays41 paramGLWeatherWidgetDays41) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GLWeatherWidgetDays41.access$002(this.a, g.a(paramIBinder));
    try
    {
      GLWeatherWidgetDays41.access$000(this.a).a(GLWeatherWidgetDays41.access$100(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      GLWeatherWidgetDays41.access$300(this.a, GLWeatherWidgetDays41.access$000(this.a).b(), GLWeatherWidgetDays41.access$000(this.a).a(), GLWeatherWidgetDays41.access$000(this.a).a(GLWeatherWidgetDays41.access$200(this.a)));
      if (GLWeatherWidgetDays41.access$400(this.a)) {
        GLWeatherWidgetDays41.access$000(this.a).a(GLWeatherWidgetDays41.access$200(this.a), 4);
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
    GLWeatherWidgetDays41.access$002(this.a, null);
    c.a("lishen", getClass().getSimpleName() + " onServiceDisconnected.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */