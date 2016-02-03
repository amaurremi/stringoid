package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class cj
  extends BroadcastReceiver
{
  cj(WeatherWidget41 paramWeatherWidget41) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    if (!WeatherWidget41.r(this.a))
    {
      if (str.equals("android.intent.action.TIME_TICK")) {
        WeatherWidget41.s(this.a);
      }
    }
    else
    {
      label39:
      if (!str.equals("android.intent.action.SCREEN_OFF")) {
        break label201;
      }
      WeatherWidget41.b(this.a, true);
    }
    label58:
    label201:
    label600:
    for (;;)
    {
      int i;
      if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
      {
        if (WeatherWidget41.b(this.a) == null) {
          break;
        }
        try
        {
          WeatherWidget41.a(this.a, WeatherWidget41.b(this.a).b(), WeatherWidget41.b(this.a).a(), WeatherWidget41.b(this.a).a(WeatherWidget41.c(this.a)));
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
          WeatherWidget41.t(this.a);
          break label39;
        }
        if (!str.equals("android.intent.action.TIMEZONE_CHANGED")) {
          break label39;
        }
        WeatherWidget41.u(this.a).a();
        WeatherWidget41.t(this.a);
        break label39;
        if (str.equals("android.intent.action.SCREEN_ON"))
        {
          WeatherWidget41.b(this.a, false);
          WeatherWidget41.s(this.a);
          continue;
        }
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
        {
          WeatherWidget41.c(this.a, true);
          continue;
        }
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
          continue;
        }
        WeatherWidget41.d(this.a, false);
        i = paramIntent.getIntExtra("city_location_state", 3);
        paramIntent = paramIntent.getStringExtra("city_location_id");
        Iterator localIterator = WeatherWidget41.m(this.a).c().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (bl)localIterator.next();
        } while (!paramContext.d());
      }
      for (;;)
      {
        if (paramContext == null) {
          break label600;
        }
        if ((i == 4) && (!TextUtils.isEmpty(paramIntent)))
        {
          paramContext.a(WeatherWidget41.v(this.a).getString(2131166457));
          paramContext.a(true);
          break label58;
        }
        paramContext.a(WeatherWidget41.w(this.a).getString(2131166455));
        paramContext.a(true);
        break label58;
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
        {
          if (WeatherWidget41.b(this.a) != null) {
            if (!WeatherWidget41.x(this.a)) {}
          }
          for (;;)
          {
            try
            {
              WeatherWidget41.a(this.a, WeatherWidget41.b(this.a).b(), WeatherWidget41.b(this.a).a(), WeatherWidget41.b(this.a).a(WeatherWidget41.c(this.a)));
              WeatherWidget41.e(this.a, false);
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
            if (WeatherWidget41.y(this.a)) {
              WeatherWidget41.B(this.a).bindService(new Intent(WeatherWidget41.z(this.a), WeatherService.class), WeatherWidget41.A(this.a), 1);
            }
          }
        }
        if ((!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS"))) {
          break;
        }
        WeatherWidget41.a(this.a, d.e(WeatherWidget41.C(this.a), this.a.getResources()));
        WeatherWidget41.g(this.a);
        return;
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */