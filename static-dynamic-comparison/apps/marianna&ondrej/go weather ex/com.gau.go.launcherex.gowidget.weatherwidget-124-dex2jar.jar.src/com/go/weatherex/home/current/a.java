package com.go.weatherex.home.current;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class a
  extends BroadcastReceiver
{
  a(AirQualityIndex paramAirQualityIndex) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.getAction().equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA")) {
      return;
    }
    AirQualityIndex.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */