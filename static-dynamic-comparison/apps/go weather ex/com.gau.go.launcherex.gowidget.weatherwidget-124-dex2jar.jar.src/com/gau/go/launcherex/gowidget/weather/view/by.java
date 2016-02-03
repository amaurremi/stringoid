package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class by
  extends BroadcastReceiver
{
  by(WeatherWidget11 paramWeatherWidget11) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      return;
      break label256;
    }
    label77:
    label138:
    label256:
    label299:
    label381:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              if (paramContext.equals("android.intent.action.TIME_TICK"))
              {
                WeatherWidget11.l(this.a);
                return;
              }
              if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
              {
                if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) {
                  WeatherWidget11.m(this.a).a();
                }
                paramContext = WeatherWidget11.g(this.a).c();
                i = 0;
                if (i < paramContext.size())
                {
                  paramIntent = (bj)paramContext.get(i);
                  if (i != WeatherWidget11.g(this.a).b()) {
                    break label138;
                  }
                  paramIntent.a(null, this.a.b, this.a.c.g, true);
                }
                for (;;)
                {
                  i += 1;
                  break label77;
                  break;
                  paramIntent.a(null, false, false, false);
                }
              }
              if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
                break label299;
              }
              int i = paramIntent.getIntExtra("city_location_state", 3);
              paramContext = paramIntent.getStringExtra("city_location_id");
              if ((i != 4) || (TextUtils.isEmpty(paramContext))) {
                break;
              }
              paramContext = WeatherWidget11.g(this.a).c().iterator();
            } while (!paramContext.hasNext());
            paramIntent = (bj)paramContext.next();
            if (!paramIntent.b()) {
              break;
            }
            paramIntent.a(WeatherWidget11.n(this.a).getString(2131166457));
            return;
            paramContext = WeatherWidget11.g(this.a).c().iterator();
          } while (!paramContext.hasNext());
          paramIntent = (bj)paramContext.next();
          if (!paramIntent.b()) {
            break;
          }
          paramIntent.a(WeatherWidget11.o(this.a).getString(2131166455));
          return;
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA")) {
            break label381;
          }
        } while (WeatherWidget11.b(this.a) == null);
        try
        {
          this.a.a(WeatherWidget11.b(this.a).b(), WeatherWidget11.b(this.a).a(), WeatherWidget11.b(this.a).a(WeatherWidget11.c(this.a)));
          return;
        }
        catch (Exception paramContext) {}
      } while (!c.a());
      paramContext.printStackTrace();
      return;
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"));
    if (WeatherWidget11.b(this.a) != null) {
      if (!WeatherWidget11.p(this.a)) {}
    }
    for (;;)
    {
      try
      {
        this.a.a(WeatherWidget11.b(this.a).b(), WeatherWidget11.b(this.a).a(), WeatherWidget11.b(this.a).a(WeatherWidget11.c(this.a)));
        WeatherWidget11.a(this.a, false);
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
      if (WeatherWidget11.q(this.a)) {
        WeatherWidget11.t(this.a).bindService(new Intent(WeatherWidget11.r(this.a), WeatherService.class), WeatherWidget11.s(this.a), 1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */