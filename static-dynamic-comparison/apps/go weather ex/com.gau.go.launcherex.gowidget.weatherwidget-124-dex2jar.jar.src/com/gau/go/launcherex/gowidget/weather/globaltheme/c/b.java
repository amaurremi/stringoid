package com.gau.go.launcherex.gowidget.weather.globaltheme.c;

import android.text.format.Time;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;

public abstract class b
{
  public static boolean a(a parama)
  {
    boolean bool = false;
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("GMT00:00");
    if (localTime.toMillis(false) > parama.c()) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(a parama)
  {
    boolean bool = false;
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("GMT00:00");
    if (localTime.toMillis(false) > parama.c() + 259200000L) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */