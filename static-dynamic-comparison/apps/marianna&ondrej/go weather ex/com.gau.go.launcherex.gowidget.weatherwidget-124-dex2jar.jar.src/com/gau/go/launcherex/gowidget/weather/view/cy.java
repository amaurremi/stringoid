package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class cy
  extends BroadcastReceiver
{
  cy(WeatherWidget42 paramWeatherWidget42) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (WeatherWidget42.m(this.a) == null)) {}
    while ((!paramContext.equals("android.intent.action.PACKAGE_DATA_CLEARED")) || (!paramIntent.getDataString().replace("package:", "").equals(this.a.getContext().getPackageName()))) {
      return;
    }
    WeatherWidget42.D(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */