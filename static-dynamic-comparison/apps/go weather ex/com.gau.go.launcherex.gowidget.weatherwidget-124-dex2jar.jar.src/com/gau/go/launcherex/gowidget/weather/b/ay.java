package com.gau.go.launcherex.gowidget.weather.b;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.util.r;

class ay
  extends BroadcastReceiver
{
  ay(ax paramax) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHECK_NEW_VERSION")) {
      if (!r.c(paramContext))
      {
        ax.c(this.a).cancel(ax.b(this.a));
        ax.a(this.a, true);
      }
    }
    while ((!str.equals("android.net.conn.CONNECTIVITY_CHANGE")) || (paramIntent.getBooleanExtra("noConnectivity", false)) || (!ax.e(this.a)))
    {
      return;
      ax.d(this.a);
      return;
    }
    ax.d(this.a);
    ax.a(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */