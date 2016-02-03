package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;

class ai
  extends BroadcastReceiver
{
  ai(GLWeatherWidgetDays41 paramGLWeatherWidgetDays41) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    if (!GLWeatherWidgetDays41.access$1800(this.a))
    {
      if (str.equals("android.intent.action.TIME_TICK")) {
        GLWeatherWidgetDays41.access$1900(this.a);
      }
    }
    else
    {
      label39:
      if (!str.equals("android.intent.action.SCREEN_OFF")) {
        break label201;
      }
      GLWeatherWidgetDays41.access$1802(this.a, true);
    }
    label58:
    label201:
    label547:
    for (;;)
    {
      int i;
      if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
      {
        if (GLWeatherWidgetDays41.access$000(this.a) == null) {
          break;
        }
        try
        {
          GLWeatherWidgetDays41.access$300(this.a, GLWeatherWidgetDays41.access$000(this.a).b(), GLWeatherWidgetDays41.access$000(this.a).a(), GLWeatherWidgetDays41.access$000(this.a).a(GLWeatherWidgetDays41.access$200(this.a)));
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
          GLWeatherWidgetDays41.access$2000(this.a);
          break label39;
        }
        if (!str.equals("android.intent.action.TIMEZONE_CHANGED")) {
          break label39;
        }
        GLWeatherWidgetDays41.access$2100(this.a).a();
        GLWeatherWidgetDays41.access$2000(this.a);
        break label39;
        if (str.equals("android.intent.action.SCREEN_ON"))
        {
          GLWeatherWidgetDays41.access$1802(this.a, false);
          GLWeatherWidgetDays41.access$1900(this.a);
          continue;
        }
        if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
        {
          GLWeatherWidgetDays41.access$2200(this.a, true);
          continue;
        }
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
          continue;
        }
        GLWeatherWidgetDays41.access$2302(this.a, false);
        i = paramIntent.getIntExtra("city_location_state", 3);
        paramIntent = paramIntent.getStringExtra("city_location_id");
        Iterator localIterator = GLWeatherWidgetDays41.access$900(this.a).getCitys().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramContext = (GLWeatherDays41)localIterator.next();
        } while (!paramContext.isEmptyCity());
      }
      for (;;)
      {
        if (paramContext == null) {
          break label547;
        }
        if ((i == 4) && (!TextUtils.isEmpty(paramIntent)))
        {
          paramContext.setTip(GLWeatherWidgetDays41.access$2400(this.a).getString(2131166457));
          paramContext.syncTime(true);
          break label58;
        }
        paramContext.setTip(GLWeatherWidgetDays41.access$2500(this.a).getString(2131166455));
        paramContext.syncTime(true);
        break label58;
        if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) {
          break;
        }
        if (GLWeatherWidgetDays41.access$000(this.a) != null) {
          if (!GLWeatherWidgetDays41.access$2600(this.a)) {}
        }
        for (;;)
        {
          try
          {
            GLWeatherWidgetDays41.access$300(this.a, GLWeatherWidgetDays41.access$000(this.a).b(), GLWeatherWidgetDays41.access$000(this.a).a(), GLWeatherWidgetDays41.access$000(this.a).a(GLWeatherWidgetDays41.access$200(this.a)));
            GLWeatherWidgetDays41.access$2602(this.a, false);
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
          if (GLWeatherWidgetDays41.access$2700(this.a)) {
            GLWeatherWidgetDays41.access$3000(this.a).bindService(new Intent(GLWeatherWidgetDays41.access$2800(this.a), WeatherService.class), GLWeatherWidgetDays41.access$2900(this.a), 1);
          }
        }
        paramContext = null;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */