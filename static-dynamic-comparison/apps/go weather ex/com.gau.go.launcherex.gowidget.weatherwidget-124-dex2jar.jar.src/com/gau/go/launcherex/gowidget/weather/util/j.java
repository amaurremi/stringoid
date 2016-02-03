package com.gau.go.launcherex.gowidget.weather.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class j
  extends BroadcastReceiver
{
  j(f paramf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.LOCALE_CHANGED")) {
      this.a.i();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */