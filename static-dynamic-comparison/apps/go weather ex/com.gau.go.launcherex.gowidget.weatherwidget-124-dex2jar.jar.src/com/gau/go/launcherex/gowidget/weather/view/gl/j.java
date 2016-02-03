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

class j
  extends BroadcastReceiver
{
  j(GLWeatherWidget21 paramGLWeatherWidget21) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      return;
      break label265;
    }
    label107:
    label150:
    label265:
    label308:
    label390:
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
                paramContext = GLWeatherWidget21.access$800(this.a).getCitys().iterator();
                while (paramContext.hasNext()) {
                  ((GLWeather21)paramContext.next()).checkToUpdateWeatherIcon();
                }
              }
              if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
              {
                if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) {
                  GLWeatherWidget21.access$1600(this.a).a();
                }
                paramContext = GLWeatherWidget21.access$800(this.a).getCitys();
                i = 0;
                if (i < paramContext.size())
                {
                  paramIntent = (GLWeather21)paramContext.get(i);
                  if (GLWeatherWidget21.access$800(this.a).getCurScreen() != i) {
                    break label150;
                  }
                  paramIntent.showWeatherInfo(true);
                }
                for (;;)
                {
                  i += 1;
                  break label107;
                  break;
                  paramIntent.showWeatherInfo(false);
                }
              }
              if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY")) {
                break label308;
              }
              int i = paramIntent.getIntExtra("city_location_state", 3);
              paramContext = paramIntent.getStringExtra("city_location_id");
              if ((i != 4) || (TextUtils.isEmpty(paramContext))) {
                break;
              }
              paramContext = GLWeatherWidget21.access$800(this.a).getCitys().iterator();
            } while (!paramContext.hasNext());
            paramIntent = (GLWeather21)paramContext.next();
            if (!paramIntent.isEmptyCity()) {
              break;
            }
            paramIntent.setTip(GLWeatherWidget21.access$1700(this.a).getString(2131166457));
            return;
            paramContext = GLWeatherWidget21.access$800(this.a).getCitys().iterator();
          } while (!paramContext.hasNext());
          paramIntent = (GLWeather21)paramContext.next();
          if (!paramIntent.isEmptyCity()) {
            break;
          }
          paramIntent.setTip(GLWeatherWidget21.access$1800(this.a).getString(2131166455));
          return;
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA")) {
            break label390;
          }
        } while (GLWeatherWidget21.access$000(this.a) == null);
        try
        {
          this.a.initWidget(GLWeatherWidget21.access$000(this.a).b(), GLWeatherWidget21.access$000(this.a).a(), GLWeatherWidget21.access$000(this.a).a(GLWeatherWidget21.access$200(this.a)));
          return;
        }
        catch (Exception paramContext) {}
      } while (!c.a());
      paramContext.printStackTrace();
      return;
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"));
    if (GLWeatherWidget21.access$000(this.a) != null) {
      if (!GLWeatherWidget21.access$1900(this.a)) {}
    }
    for (;;)
    {
      try
      {
        this.a.initWidget(GLWeatherWidget21.access$000(this.a).b(), GLWeatherWidget21.access$000(this.a).a(), GLWeatherWidget21.access$000(this.a).a(GLWeatherWidget21.access$200(this.a)));
        GLWeatherWidget21.access$1902(this.a, false);
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
      if (GLWeatherWidget21.access$2000(this.a)) {
        GLWeatherWidget21.access$2300(this.a).bindService(new Intent(GLWeatherWidget21.access$2100(this.a), WeatherService.class), GLWeatherWidget21.access$2200(this.a), 1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */