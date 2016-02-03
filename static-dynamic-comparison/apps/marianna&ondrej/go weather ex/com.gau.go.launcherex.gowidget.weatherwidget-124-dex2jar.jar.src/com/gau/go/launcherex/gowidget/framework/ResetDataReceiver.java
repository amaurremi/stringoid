package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

public class ResetDataReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext.getContentResolver().delete(WeatherContentProvider.c, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/ResetDataReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */