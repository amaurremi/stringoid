package com.gau.go.launcherex.gowidget.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WeatherGCMBroadcastReceiver
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    WeatherGCMService.a(paramContext, paramIntent);
    setResult(-1, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/WeatherGCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */