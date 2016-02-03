package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gau.go.launcherex.gowidget.weather.service.g;
import com.gtp.a.a.b.c;

class t
  implements ServiceConnection
{
  t(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GLWeatherWidget41Style2.access$002(this.a, g.a(paramIBinder));
    try
    {
      GLWeatherWidget41Style2.access$000(this.a).a(GLWeatherWidget41Style2.access$100(this.a));
      c.a("lishen", getClass().getSimpleName() + " onServiceConnected.");
      GLWeatherWidget41Style2.access$300(this.a, GLWeatherWidget41Style2.access$000(this.a).b(), GLWeatherWidget41Style2.access$000(this.a).a(), GLWeatherWidget41Style2.access$000(this.a).a(GLWeatherWidget41Style2.access$200(this.a)));
      if (GLWeatherWidget41Style2.access$400(this.a)) {
        GLWeatherWidget41Style2.access$000(this.a).a(GLWeatherWidget41Style2.access$200(this.a), 5);
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
    c.a("lishen", "WeatherWidget41Style2 onServiceDisconnected.");
    GLWeatherWidget41Style2.access$002(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */