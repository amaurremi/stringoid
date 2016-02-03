package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class d
  extends BroadcastReceiver
{
  d(c paramc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_LOADING_FINISH".equals(paramIntent.getAction())) {
      return;
    }
    c.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */