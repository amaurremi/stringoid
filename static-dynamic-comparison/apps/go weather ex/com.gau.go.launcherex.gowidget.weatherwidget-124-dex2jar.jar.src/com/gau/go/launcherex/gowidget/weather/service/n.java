package com.gau.go.launcherex.gowidget.weather.service;

import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import java.util.Comparator;

class n
  implements Comparator
{
  n(m paramm) {}
  
  public int a(WeatherBean paramWeatherBean1, WeatherBean paramWeatherBean2)
  {
    if (paramWeatherBean1.q() < paramWeatherBean2.q()) {
      return -1;
    }
    if (paramWeatherBean1.q() > paramWeatherBean2.q()) {
      return 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */