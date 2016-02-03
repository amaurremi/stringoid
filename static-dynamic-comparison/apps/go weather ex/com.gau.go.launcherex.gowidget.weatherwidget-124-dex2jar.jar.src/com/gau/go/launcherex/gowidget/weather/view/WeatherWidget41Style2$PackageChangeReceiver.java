package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class WeatherWidget41Style2$PackageChangeReceiver
  extends BroadcastReceiver
{
  public WeatherWidget41Style2$PackageChangeReceiver(WeatherWidget41Style2 paramWeatherWidget41Style2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext.equals("android.intent.action.PACKAGE_ADDED")) || (paramContext.equals("android.intent.action.PACKAGE_REMOVED")))
    {
      paramContext = paramIntent.getDataString();
      if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget"))) {}
    }
    else
    {
      return;
    }
    WeatherWidget41Style2.r(this.a).sendEmptyMessage(7);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherWidget41Style2$PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */