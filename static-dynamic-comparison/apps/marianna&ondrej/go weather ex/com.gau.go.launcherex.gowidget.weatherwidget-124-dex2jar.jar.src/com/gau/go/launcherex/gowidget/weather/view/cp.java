package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;

class cp
  extends BroadcastReceiver
{
  cp(WeatherWidget41Style2 paramWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (this.a.mWidgetScrollGroup == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("android.intent.action.TIME_TICK"))
          {
            WeatherWidget41Style2.f(this.a);
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_OFF"))
          {
            WeatherWidget41Style2.a(this.a, false);
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_ON"))
          {
            WeatherWidget41Style2.a(this.a, true);
            WeatherWidget41Style2.f(this.a);
            return;
          }
          if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED"))
          {
            WeatherWidget41Style2.f(this.a);
            return;
          }
          if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.DATE_CHANGED")))
          {
            WeatherWidget41Style2.g(this.a).a();
            WeatherWidget41Style2.f(this.a);
            return;
          }
          if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            WeatherWidget41Style2.b(this.a, true);
            return;
          }
          if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"))
          {
            WeatherWidget41Style2.c(this.a, false);
            int i = paramIntent.getIntExtra("city_location_state", 3);
            paramContext = paramIntent.getStringExtra("city_location_id");
            if ((i == 4) && (!TextUtils.isEmpty(paramContext)))
            {
              WeatherWidget41Style2.h(this.a);
              return;
            }
            WeatherWidget41Style2.h(this.a);
            return;
          }
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA")) {
            break;
          }
        } while (WeatherWidget41Style2.b(this.a) == null);
        try
        {
          WeatherWidget41Style2.a(this.a, WeatherWidget41Style2.b(this.a).b(), WeatherWidget41Style2.b(this.a).a(), WeatherWidget41Style2.b(this.a).a(WeatherWidget41Style2.c(this.a)));
          return;
        }
        catch (Exception paramContext) {}
      } while (!c.a());
      paramContext.printStackTrace();
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
      {
        if (WeatherWidget41Style2.b(this.a) != null) {
          if (!WeatherWidget41Style2.i(this.a)) {}
        }
        for (;;)
        {
          try
          {
            WeatherWidget41Style2.a(this.a, WeatherWidget41Style2.b(this.a).b(), WeatherWidget41Style2.b(this.a).a(), WeatherWidget41Style2.b(this.a).a(WeatherWidget41Style2.c(this.a)));
            WeatherWidget41Style2.d(this.a, false);
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
          if (WeatherWidget41Style2.j(this.a)) {
            WeatherWidget41Style2.m(this.a).bindService(new Intent(WeatherWidget41Style2.k(this.a), WeatherService.class), WeatherWidget41Style2.l(this.a), 1);
          }
        }
      }
    } while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION")) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS")));
    WeatherWidget41Style2.a(this.a, d.e(WeatherWidget41Style2.n(this.a), this.a.getResources()));
    WeatherWidget41Style2.o(this.a);
    WeatherWidget41Style2.p(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */