package com.gau.go.launcherex.gowidget.weather.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class i
  extends BroadcastReceiver
{
  private i(g paramg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */