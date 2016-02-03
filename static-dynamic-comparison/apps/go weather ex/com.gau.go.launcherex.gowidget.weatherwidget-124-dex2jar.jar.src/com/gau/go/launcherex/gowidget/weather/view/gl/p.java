package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class p
  extends BroadcastReceiver
{
  p(GLWeatherWidget41 paramGLWeatherWidget41) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    if (!GLWeatherWidget41.access$2500(this.a))
    {
      if (str.equals("android.intent.action.TIME_TICK")) {
        GLWeatherWidget41.access$2600(this.a);
      }
    }
    else
    {
      label39:
      if (!str.equals("android.intent.action.SCREEN_OFF")) {
        break label201;
      }
      GLWeatherWidget41.access$2502(this.a, true);
    }
    label58:
    label201:
    label600:
    for (;;)
    {
      int i;
      if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
      {
        if (GLWeatherWidget41.access$000(this.a) == null) {
          break;
        }
        try
        {
          GLWeatherWidget41.access$300(this.a, GLWeatherWidget41.access$000(this.a).b(), GLWeatherWidget41.access$000(this.a).a(), GLWeatherWidget41.access$000(this.a).a(GLWeatherWidget41.access$200(this.a)));
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
          GLWeatherWidget41.access$2700(this.a);
          break label39;
        }
        if (!str.equals("android.intent.action.TIMEZONE_CHANGED")) {
          break label39;
        }
        GLWeatherWidget41.access$2800(this.a).a();
        GLWeatherWidget41.access$2700(this.a);
        break label39;
        if (str.equals("android.intent.action.SCREEN_ON"))
        {
          GLWeatherWidget41.access$2502(this.a, false);
          GLWeatherWidget41.access$2600(this.a);
          continue;
        }
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
        {
          GLWeatherWidget41.access$2900(this.a, true);
          continue;
        }
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
          continue;
        }
        GLWeatherWidget41.access$3002(this.a, false);
        i = paramIntent.getIntExtra("city_location_state", 3);
        paramIntent = paramIntent.getStringExtra("city_location_id");
        Iterator localIterator = GLWeatherWidget41.access$1600(this.a).getCitys().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (GLWeather41)localIterator.next();
        } while (!paramContext.isEmptyCity());
      }
      for (;;)
      {
        if (paramContext == null) {
          break label600;
        }
        if ((i == 4) && (!TextUtils.isEmpty(paramIntent)))
        {
          paramContext.setTip(GLWeatherWidget41.access$3100(this.a).getString(2131166457));
          paramContext.syncTime(true);
          break label58;
        }
        paramContext.setTip(GLWeatherWidget41.access$3200(this.a).getString(2131166455));
        paramContext.syncTime(true);
        break label58;
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
        {
          if (GLWeatherWidget41.access$000(this.a) != null) {
            if (!GLWeatherWidget41.access$3300(this.a)) {}
          }
          for (;;)
          {
            try
            {
              GLWeatherWidget41.access$300(this.a, GLWeatherWidget41.access$000(this.a).b(), GLWeatherWidget41.access$000(this.a).a(), GLWeatherWidget41.access$000(this.a).a(GLWeatherWidget41.access$200(this.a)));
              GLWeatherWidget41.access$3302(this.a, false);
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
            if (GLWeatherWidget41.access$3400(this.a)) {
              GLWeatherWidget41.access$3700(this.a).bindService(new Intent(GLWeatherWidget41.access$3500(this.a), WeatherService.class), GLWeatherWidget41.access$3600(this.a), 1);
            }
          }
        }
        if ((!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS"))) {
          break;
        }
        GLWeatherWidget41.access$1302(this.a, d.e(GLWeatherWidget41.access$3800(this.a), this.a.getResources()));
        GLWeatherWidget41.access$1000(this.a);
        return;
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */