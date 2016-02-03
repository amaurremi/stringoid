package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class cq
  extends BroadcastReceiver
{
  cq(WeatherWidget41Style2 paramWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext == null) || (this.a.mWidgetScrollGroup == null)) {}
    while ((!paramContext.equals("android.intent.action.PACKAGE_DATA_CLEARED")) || (!paramIntent.getDataString().replace("package:", "").equals(this.a.getContext().getPackageName()))) {
      return;
    }
    WeatherWidget41Style2.q(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */