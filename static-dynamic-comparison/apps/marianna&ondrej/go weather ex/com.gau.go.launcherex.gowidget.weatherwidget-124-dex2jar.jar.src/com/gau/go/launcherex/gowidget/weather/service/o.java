package com.gau.go.launcherex.gowidget.weather.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class o
  extends BroadcastReceiver
{
  private o(WeatherService paramWeatherService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA")) {
          break label31;
        }
        this.a.a(paramIntent);
      }
    }
    label31:
    do
    {
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT"))
      {
        WeatherService.a(this.a, "tempUnit");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK"))
      {
        WeatherService.a(this.a, "world_clock");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_CYCLE_MODE"))
      {
        WeatherService.a(this.a, "isCycle");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app"))
      {
        WeatherService.a(this.a, "widgt_calendar");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app"))
      {
        WeatherService.a(this.a, "widgt_clock");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_GOWIDGET_DYNAMIC_ICON_CHANGE"))
      {
        WeatherService.a(this.a, "dynamic_icon_gowidget");
        return;
      }
      if (paramContext.equalsIgnoreCase("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT"))
      {
        WeatherService.a(this.a, "dateStyle");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE"))
      {
        WeatherService.a(this.a, "go_widget_theme");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION"))
      {
        WeatherService.a(this.a, "auto_location");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE"))
      {
        WeatherService.a(this.a, paramIntent);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY"))
      {
        WeatherService.b(this.a, paramIntent);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY"))
      {
        WeatherService.c(this.a, paramIntent);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION"))
      {
        WeatherService.d(this.a, paramIntent);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE"))
      {
        WeatherService.b(this.a);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE"))
      {
        WeatherService.e(this.a, paramIntent);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_THEME_SWITCHER_CHANGE"))
      {
        WeatherService.a(this.a, "widget_theme_switcher");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR"))
      {
        WeatherService.a(this.a, "calendarType");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL"))
      {
        WeatherService.a(this.a, "festival");
        return;
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT"));
    WeatherService.a(this.a, "windUnit");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */