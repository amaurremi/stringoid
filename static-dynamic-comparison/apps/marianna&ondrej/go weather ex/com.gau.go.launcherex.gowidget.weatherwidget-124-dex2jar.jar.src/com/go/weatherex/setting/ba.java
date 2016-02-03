package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ba
  extends BroadcastReceiver
{
  private ba(ay paramay) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
    } while ((!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION".equals(paramContext)) && (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION_FAILED".equals(paramContext)));
    ay.a(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */