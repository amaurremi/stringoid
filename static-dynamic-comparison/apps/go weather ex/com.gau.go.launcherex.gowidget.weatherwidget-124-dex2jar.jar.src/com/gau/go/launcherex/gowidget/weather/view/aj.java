package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aj
  extends BroadcastReceiver
{
  aj(MapDetailActivity paramMapDetailActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramIntent.getAction().equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE"))
    {
      MapDetailActivity.a(this.a, true);
      paramContext = MapDetailActivity.b(this.a);
      if (MapDetailActivity.a(this.a)) {
        break label76;
      }
      bool1 = true;
      paramContext.a(bool1);
      paramContext = MapDetailActivity.c(this.a);
      if (MapDetailActivity.a(this.a)) {
        break label81;
      }
    }
    label76:
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.a(bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */