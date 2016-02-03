package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;

public class SystemBootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = new Intent(paramContext, NotifyService.class);
    paramIntent.putExtra("notify_request", 23);
    paramContext.startService(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/SystemBootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */