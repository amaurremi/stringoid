package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import java.util.ArrayList;
import java.util.List;

class f
  extends BroadcastReceiver
{
  f(e parame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (!e.g(this.a))
        {
          if (paramContext.equals("android.intent.action.TIME_TICK"))
          {
            e.h(this.a);
            return;
          }
          if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.DATE_CHANGED")))
          {
            e.h(this.a);
            return;
          }
          if (paramContext.equals("android.intent.action.TIMEZONE_CHANGED"))
          {
            e.h(this.a);
            return;
          }
        }
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          e.b(this.a, true);
          e.a(this.a, "android.intent.action.SCREEN_OFF");
          return;
        }
        if (paramContext.equals("android.intent.action.SCREEN_ON"))
        {
          e.b(this.a, false);
          e.i(this.a);
          e.a(this.a, "android.intent.action.SCREEN_ON");
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"))
        {
          e.c(this.a, true);
          e.j(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app"))
        {
          e.b(this.a, "widgt_clock");
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY"))
        {
          paramContext = new ArrayList();
          paramContext.add(Integer.valueOf(1));
          paramContext.add(Integer.valueOf(3));
          paramContext.add(Integer.valueOf(4));
          e.a(this.a, paramContext);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY"))
        {
          e.k(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
        {
          e.b(this.a, null);
          e.c(this.a, false);
          e.l(this.a);
          e.m(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RELOAD_DATA"))
        {
          e.n(this.a);
          return;
        }
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
        {
          e.n(this.a);
          return;
        }
        if (paramContext.equalsIgnoreCase("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT"))
        {
          e.b(this.a, "tempUnit");
          return;
        }
        if (paramContext.equalsIgnoreCase("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT"))
        {
          e.b(this.a, "dateStyle");
          return;
        }
        if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION")) {
          break;
        }
      } while (paramIntent.getIntExtra("extra_auto_location_flag", -1) != 0);
      e.o(this.a);
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE"))
      {
        e.c(this.a, null);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK"))
      {
        if (paramIntent.getIntExtra("extra_world_clock", 0) == 1) {
          e.f(this.a).a(true);
        }
        for (;;)
        {
          e.i(this.a);
          return;
          e.f(this.a).a(false);
        }
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT"))
      {
        e.b(this.a, "windUnit");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE"))
      {
        i = paramIntent.getIntExtra("extra_convert_from_index", -1);
        int j = paramIntent.getIntExtra("extra_convert_to_index", -1);
        e.a(this.a, i, j);
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"));
    int i = paramIntent.getIntExtra("city_location_state", 3);
    paramContext = paramIntent.getStringExtra("city_location_id");
    if ((i == 4) && (!TextUtils.isEmpty(paramContext))) {}
    for (;;)
    {
      e.e(this.a, false);
      e.f(this.a, false);
      return;
      e.d(this.a, true);
      e.c(this.a, e.p(this.a).getResources().getString(2131166455));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */