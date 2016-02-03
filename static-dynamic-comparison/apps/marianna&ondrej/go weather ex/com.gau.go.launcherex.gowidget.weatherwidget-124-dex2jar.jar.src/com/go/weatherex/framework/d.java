package com.go.weatherex.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.v;

class d
  extends BroadcastReceiver
{
  d(c paramc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED".equals(paramContext))
    {
      paramContext = paramIntent.getStringArrayListExtra("cityIds");
      this.a.a(paramContext);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA".equals(paramContext))
    {
      paramContext = new v().a(paramIntent);
      paramIntent = com.gau.go.launcherex.gowidget.weather.c.c.a(c.a(this.a).getApplicationContext()).h();
      this.a.a(paramIntent.d(), paramContext);
      return;
    }
    int i;
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT".equals(paramContext))
    {
      i = paramIntent.getIntExtra("temperature_unit", 1);
      this.a.a(i);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT".equals(paramContext))
    {
      i = paramIntent.getIntExtra("wind_unit", 1);
      this.a.b(i);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_VISIBILITY_UNIT".equals(paramContext))
    {
      i = paramIntent.getIntExtra("visibility_unit", 1);
      this.a.c(i);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PRESSURE_UNIT".equals(paramContext))
    {
      i = paramIntent.getIntExtra("pressure_unit", 2);
      this.a.d(i);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT".equals(paramContext))
    {
      i = paramIntent.getIntExtra("datestyle_unit", 1);
      this.a.e(i);
      return;
    }
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK".equals(paramContext)) {
      if (paramIntent.getIntExtra("extra_world_clock", 0) != 1) {
        break label614;
      }
    }
    for (;;)
    {
      this.a.a(bool1);
      return;
      if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIME_TICK".equals(paramContext)))
      {
        this.a.b();
        return;
      }
      if ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext))
      {
        this.a.c();
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE".equals(paramContext))
      {
        this.a.d();
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION".equals(paramContext))
      {
        this.a.e();
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("city_code");
        paramIntent = paramIntent.getStringExtra("city_name");
        this.a.a(paramContext, paramIntent, c.b(this.a).d());
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY".equals(paramContext))
      {
        paramContext = paramIntent.getStringArrayListExtra("city_code_list");
        i = paramIntent.getIntExtra("city_index", 0);
        paramIntent = paramIntent.getStringExtra("city_code");
        this.a.a(paramContext, i, paramIntent, c.b(this.a).d());
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION".equals(paramContext))
      {
        if (paramIntent.getIntExtra("extra_auto_location_flag", 0) == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          this.a.b(bool1);
          return;
        }
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION_FAILED".equals(paramContext))
      {
        this.a.a(false, null, null);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("last_location_cityid");
        paramIntent = paramIntent.getStringExtra("city_code");
        this.a.a(true, paramContext, paramIntent);
        return;
      }
      if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE".equals(paramContext))
      {
        if (paramIntent.getIntExtra("extra_new_theme_flag", 0) == 1) {}
        for (bool1 = bool3;; bool1 = false)
        {
          this.a.c(bool1);
          return;
        }
      }
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        c.a(this.a, true);
        return;
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        c.a(this.a, false);
        return;
      }
      if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE")) {
        break;
      }
      c.c(this.a);
      return;
      label614:
      bool1 = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */