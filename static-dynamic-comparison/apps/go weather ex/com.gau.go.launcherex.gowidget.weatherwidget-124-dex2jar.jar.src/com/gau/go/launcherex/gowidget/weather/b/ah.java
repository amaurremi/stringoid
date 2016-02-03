package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ah
  extends BroadcastReceiver
{
  ah(ag paramag) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT")) {
      ag.a(this.a);
    }
    do
    {
      do
      {
        return;
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA"))
        {
          ag.a(this.a);
          return;
        }
        if (!paramContext.equals("android.intent.action.TIME_TICK")) {
          break;
        }
      } while (!ag.b(this.a));
      ag.a(this.a);
      return;
      if ((paramContext.equals("android.intent.action.TIMEZONE_CHANGED")) || (paramContext.equals("android.intent.action.TIME_SET")))
      {
        ag.b(this.a);
        ag.a(this.a);
        return;
      }
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED"));
    ag.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */