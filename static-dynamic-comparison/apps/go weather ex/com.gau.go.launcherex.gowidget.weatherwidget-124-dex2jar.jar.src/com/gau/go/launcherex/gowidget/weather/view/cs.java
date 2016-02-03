package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class cs
  extends Handler
{
  private final WeakReference a;
  
  public cs(WeatherWidget41Style2 paramWeatherWidget41Style2)
  {
    this.a = new WeakReference(paramWeatherWidget41Style2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    WeatherWidget41Style2 localWeatherWidget41Style2 = (WeatherWidget41Style2)this.a.get();
    if (localWeatherWidget41Style2 == null) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 5: 
        default: 
          return;
        case 3: 
          paramMessage = (String)paramMessage.obj;
        }
      } while ((TextUtils.isEmpty(WeatherWidget41Style2.s(localWeatherWidget41Style2))) || (!h.a(localWeatherWidget41Style2.getContext(), WeatherWidget41Style2.c(localWeatherWidget41Style2), WeatherWidget41Style2.s(localWeatherWidget41Style2))));
      if (WeatherWidget41Style2.s(localWeatherWidget41Style2).equals("app_widget_theme_white"))
      {
        WeatherWidget41Style2.a(localWeatherWidget41Style2, localWeatherWidget41Style2.getContext().getPackageName());
        WeatherWidget41Style2.a(localWeatherWidget41Style2, 0);
      }
      for (;;)
      {
        WeatherWidget41Style2.p(localWeatherWidget41Style2);
        WeatherWidget41Style2.b(localWeatherWidget41Style2, WeatherWidget41Style2.t(localWeatherWidget41Style2));
        return;
        if (paramMessage.equals("app_widget_theme_black"))
        {
          WeatherWidget41Style2.a(localWeatherWidget41Style2, localWeatherWidget41Style2.getContext().getPackageName());
          WeatherWidget41Style2.a(localWeatherWidget41Style2, 0);
        }
        else
        {
          WeatherWidget41Style2.a(localWeatherWidget41Style2, paramMessage);
          WeatherWidget41Style2.a(localWeatherWidget41Style2, 0);
        }
      }
      WeatherWidget41Style2.u(localWeatherWidget41Style2);
      return;
    } while (WeatherWidget41Style2.v(localWeatherWidget41Style2).isEmpty());
    paramMessage = (e)WeatherWidget41Style2.v(localWeatherWidget41Style2).get(WeatherWidget41Style2.w(localWeatherWidget41Style2) % WeatherWidget41Style2.v(localWeatherWidget41Style2).size());
    WeatherWidget41Style2.x(localWeatherWidget41Style2).a(2, paramMessage);
    return;
    WeatherWidget41Style2.a(localWeatherWidget41Style2, com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(WeatherWidget41Style2.y(localWeatherWidget41Style2), localWeatherWidget41Style2.getResources()));
    WeatherWidget41Style2.o(localWeatherWidget41Style2);
    WeatherWidget41Style2.p(localWeatherWidget41Style2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */