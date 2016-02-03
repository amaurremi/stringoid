package com.gau.go.launcherex.gowidget.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class c
  extends BroadcastReceiver
{
  c(GoWidgetActivity paramGoWidgetActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.getAction().equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) {
      return;
    }
    long l = System.currentTimeMillis() - GoWidgetActivity.a(this.a);
    if (l < 1200L)
    {
      GoWidgetActivity.b(this.a).sendEmptyMessageDelayed(0, 1200L - l);
      return;
    }
    GoWidgetActivity.b(this.a).sendEmptyMessage(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */