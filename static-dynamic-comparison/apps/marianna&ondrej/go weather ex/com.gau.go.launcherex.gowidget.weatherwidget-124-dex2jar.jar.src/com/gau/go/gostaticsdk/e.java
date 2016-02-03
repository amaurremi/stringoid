package com.gau.go.gostaticsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.gostaticsdk.f.c;

class e
  extends BroadcastReceiver
{
  e(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      if (c.e(paramContext))
      {
        com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "net connection ok , check post queue!");
        d.f(this.a);
      }
    }
    else {
      return;
    }
    com.gau.go.gostaticsdk.f.d.a("StatisticsManager", "lost network,quit!");
    d.a(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */