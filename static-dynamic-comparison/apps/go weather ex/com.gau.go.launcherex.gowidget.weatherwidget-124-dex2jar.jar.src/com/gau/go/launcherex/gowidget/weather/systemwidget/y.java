package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class y
  extends BroadcastReceiver
{
  y(x paramx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label14;
      }
    }
    label14:
    do
    {
      return;
      if ((paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PACKAGE_REMOVED")) || (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE")))
      {
        x.a(this.a, "app_widget_theme");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT"))
      {
        x.a(this.a, "tempUnit");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR"))
      {
        x.a(this.a, "calendarType");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL"))
      {
        x.a(this.a, "festival");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT"))
      {
        x.a(this.a, "dateStyle");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION"))
      {
        x.a(this.a, "auto_location");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK"))
      {
        x.a(this.a, "world_clock");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE"))
      {
        x.a(this.a).startQuery(1, "need_notify_widget", WeatherContentProvider.j, null, null, null, null);
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app"))
      {
        x.a(this.a, "widgt_clock");
        return;
      }
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app"))
      {
        x.a(this.a, "widgt_calendar");
        return;
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT"));
    x.a(this.a, "windUnit");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */