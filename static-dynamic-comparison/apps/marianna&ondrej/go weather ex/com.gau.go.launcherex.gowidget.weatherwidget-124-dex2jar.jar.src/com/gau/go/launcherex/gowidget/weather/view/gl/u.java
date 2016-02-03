package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.service.WeatherService;
import com.gau.go.launcherex.gowidget.weather.service.f;
import com.gtp.a.a.b.c;

class u
  extends BroadcastReceiver
{
  u(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (GLWeatherWidget41Style2.access$500(this.a) == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramContext.equals("android.intent.action.TIME_TICK"))
          {
            GLWeatherWidget41Style2.access$600(this.a);
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_OFF"))
          {
            GLWeatherWidget41Style2.access$702(this.a, false);
            return;
          }
          if (paramContext.equals("android.intent.action.SCREEN_ON"))
          {
            GLWeatherWidget41Style2.access$702(this.a, true);
            GLWeatherWidget41Style2.access$600(this.a);
            return;
          }
          if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED"))
          {
            GLWeatherWidget41Style2.access$600(this.a);
            return;
          }
          if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.DATE_CHANGED")))
          {
            GLWeatherWidget41Style2.access$800(this.a).a();
            if ((this.a.mIsPro) && (this.a.mSettings.h)) {
              GLWeatherWidget41Style2.access$800(this.a).a(true);
            }
            GLWeatherWidget41Style2.access$600(this.a);
            return;
          }
          if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
          {
            GLWeatherWidget41Style2.access$900(this.a, true);
            return;
          }
          if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"))
          {
            GLWeatherWidget41Style2.access$1002(this.a, false);
            int i = paramIntent.getIntExtra("city_location_state", 3);
            paramContext = paramIntent.getStringExtra("city_location_id");
            if ((i == 4) && (!TextUtils.isEmpty(paramContext)))
            {
              GLWeatherWidget41Style2.access$1100(this.a);
              return;
            }
            GLWeatherWidget41Style2.access$1100(this.a);
            return;
          }
          if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA")) {
            break;
          }
        } while (GLWeatherWidget41Style2.access$000(this.a) == null);
        try
        {
          GLWeatherWidget41Style2.access$300(this.a, GLWeatherWidget41Style2.access$000(this.a).b(), GLWeatherWidget41Style2.access$000(this.a).a(), GLWeatherWidget41Style2.access$000(this.a).a(GLWeatherWidget41Style2.access$200(this.a)));
          return;
        }
        catch (Exception paramContext) {}
      } while (!c.a());
      paramContext.printStackTrace();
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
      {
        if (GLWeatherWidget41Style2.access$000(this.a) != null) {
          if (!GLWeatherWidget41Style2.access$1200(this.a)) {}
        }
        for (;;)
        {
          try
          {
            GLWeatherWidget41Style2.access$300(this.a, GLWeatherWidget41Style2.access$000(this.a).b(), GLWeatherWidget41Style2.access$000(this.a).a(), GLWeatherWidget41Style2.access$000(this.a).a(GLWeatherWidget41Style2.access$200(this.a)));
            GLWeatherWidget41Style2.access$1202(this.a, false);
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
          if (GLWeatherWidget41Style2.access$1300(this.a)) {
            GLWeatherWidget41Style2.access$1600(this.a).bindService(new Intent(GLWeatherWidget41Style2.access$1400(this.a), WeatherService.class), GLWeatherWidget41Style2.access$1500(this.a), 1);
          }
        }
      }
    } while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION")) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS")));
    GLWeatherWidget41Style2.access$1702(this.a, d.e(GLWeatherWidget41Style2.access$1800(this.a), this.a.getResources()));
    GLWeatherWidget41Style2.access$1900(this.a);
    GLWeatherWidget41Style2.access$2000(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */