package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class dd
  extends BroadcastReceiver
{
  dd(WeatherWidgetDays41 paramWeatherWidgetDays41) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    if (!WeatherWidgetDays41.l(this.a))
    {
      if (str.equals("android.intent.action.TIME_TICK")) {
        WeatherWidgetDays41.m(this.a);
      }
    }
    else
    {
      label39:
      if (!str.equals("android.intent.action.SCREEN_OFF")) {
        break label201;
      }
      WeatherWidgetDays41.b(this.a, true);
    }
    label58:
    label201:
    label549:
    for (;;)
    {
      int i;
      if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
      {
        if (WeatherWidgetDays41.b(this.a) == null) {
          break;
        }
        try
        {
          WeatherWidgetDays41.a(this.a, WeatherWidgetDays41.b(this.a).b(), WeatherWidgetDays41.b(this.a).a(), WeatherWidgetDays41.b(this.a).a(WeatherWidgetDays41.c(this.a)));
          return;
        }
        catch (Exception paramContext) {}
        if (!c.a()) {
          break;
        }
        paramContext.printStackTrace();
        return;
        if ((str.equals("android.intent.action.TIME_SET")) || (str.equals("android.intent.action.DATE_CHANGED")))
        {
          WeatherWidgetDays41.n(this.a);
          break label39;
        }
        if (!str.equals("android.intent.action.TIMEZONE_CHANGED")) {
          break label39;
        }
        WeatherWidgetDays41.o(this.a).a();
        WeatherWidgetDays41.n(this.a);
        break label39;
        if (str.equals("android.intent.action.SCREEN_ON"))
        {
          WeatherWidgetDays41.b(this.a, false);
          WeatherWidgetDays41.m(this.a);
          continue;
        }
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
        {
          WeatherWidgetDays41.c(this.a, true);
          continue;
        }
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
          continue;
        }
        WeatherWidgetDays41.d(this.a, false);
        i = paramIntent.getIntExtra("city_location_state", 3);
        paramIntent = paramIntent.getStringExtra("city_location_id");
        Iterator localIterator = WeatherWidgetDays41.g(this.a).c().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (bs)localIterator.next();
        } while (!paramContext.b());
      }
      for (;;)
      {
        if (paramContext == null) {
          break label549;
        }
        if ((i == 4) && (!TextUtils.isEmpty(paramIntent)))
        {
          paramContext.a(WeatherWidgetDays41.p(this.a).getString(2131166457));
          paramContext.a(null, true);
          break label58;
        }
        paramContext.a(WeatherWidgetDays41.q(this.a).getString(2131166455));
        paramContext.a(null, true);
        break label58;
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) {
          break;
        }
        if (WeatherWidgetDays41.b(this.a) != null) {
          if (!WeatherWidgetDays41.r(this.a)) {}
        }
        for (;;)
        {
          try
          {
            WeatherWidgetDays41.a(this.a, WeatherWidgetDays41.b(this.a).b(), WeatherWidgetDays41.b(this.a).a(), WeatherWidgetDays41.b(this.a).a(WeatherWidgetDays41.c(this.a)));
            WeatherWidgetDays41.e(this.a, false);
            return;
          }
          catch (Exception paramContext)
          {
            if (!c.a()) {
              continue;
            }
            paramContext.printStackTrace();
            continue;
          }
          if (WeatherWidgetDays41.s(this.a)) {
            WeatherWidgetDays41.v(this.a).bindService(new Intent(WeatherWidgetDays41.t(this.a), WeatherService.class), WeatherWidgetDays41.u(this.a), 1);
          }
        }
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */