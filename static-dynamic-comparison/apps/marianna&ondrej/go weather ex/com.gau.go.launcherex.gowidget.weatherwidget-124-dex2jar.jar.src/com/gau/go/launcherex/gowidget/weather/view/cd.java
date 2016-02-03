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

class cd
  extends BroadcastReceiver
{
  cd(WeatherWidget21 paramWeatherWidget21) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      return;
      break label305;
    }
    label126:
    label187:
    label305:
    label348:
    label430:
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
              while (paramContext.equals("android.intent.action.TIME_TICK"))
              {
                paramContext = WeatherWidget21.g(this.a).c().iterator();
                while (paramContext.hasNext()) {
                  ((bk)paramContext.next()).b(null, this.a.b, this.a.c.g, true);
                }
              }
              if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
              {
                if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) {
                  WeatherWidget21.l(this.a).a();
                }
                paramContext = WeatherWidget21.g(this.a).c();
                i = 0;
                if (i < paramContext.size())
                {
                  paramIntent = (bk)paramContext.get(i);
                  if (WeatherWidget21.g(this.a).b() != i) {
                    break label187;
                  }
                  paramIntent.a(null, this.a.b, this.a.c.g, true);
                }
                for (;;)
                {
                  i += 1;
                  break label126;
                  break;
                  paramIntent.a(null, false, false, false);
                }
              }
              if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
                break label348;
              }
              int i = paramIntent.getIntExtra("city_location_state", 3);
              paramContext = paramIntent.getStringExtra("city_location_id");
              if ((i != 4) || (TextUtils.isEmpty(paramContext))) {
                break;
              }
              paramContext = WeatherWidget21.g(this.a).c().iterator();
            } while (!paramContext.hasNext());
            paramIntent = (bk)paramContext.next();
            if (!paramIntent.b()) {
              break;
            }
            paramIntent.a(WeatherWidget21.m(this.a).getString(2131166457));
            return;
            paramContext = WeatherWidget21.g(this.a).c().iterator();
          } while (!paramContext.hasNext());
          paramIntent = (bk)paramContext.next();
          if (!paramIntent.b()) {
            break;
          }
          paramIntent.a(WeatherWidget21.n(this.a).getString(2131166455));
          return;
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA")) {
            break label430;
          }
        } while (WeatherWidget21.b(this.a) == null);
        try
        {
          this.a.a(WeatherWidget21.b(this.a).b(), WeatherWidget21.b(this.a).a(), WeatherWidget21.b(this.a).a(WeatherWidget21.c(this.a)));
          return;
        }
        catch (Exception paramContext) {}
      } while (!c.a());
      paramContext.printStackTrace();
      return;
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"));
    if (WeatherWidget21.b(this.a) != null) {
      if (!WeatherWidget21.o(this.a)) {}
    }
    for (;;)
    {
      try
      {
        this.a.a(WeatherWidget21.b(this.a).b(), WeatherWidget21.b(this.a).a(), WeatherWidget21.b(this.a).a(WeatherWidget21.c(this.a)));
        WeatherWidget21.a(this.a, false);
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
      if (WeatherWidget21.p(this.a)) {
        WeatherWidget21.s(this.a).bindService(new Intent(WeatherWidget21.q(this.a), WeatherService.class), WeatherWidget21.r(this.a), 1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */