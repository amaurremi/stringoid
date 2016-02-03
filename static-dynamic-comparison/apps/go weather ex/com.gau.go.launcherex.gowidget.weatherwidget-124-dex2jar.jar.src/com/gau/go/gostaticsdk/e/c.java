package com.gau.go.gostaticsdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class c
  extends BroadcastReceiver
{
  private c(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      if ((com.gau.go.gostaticsdk.f.c.e(paramContext)) && (a.d(this.a)))
      {
        a.e(this.a);
        a.a(this.a, false);
      }
    }
    do
    {
      return;
      if (paramIntent.equals(a.f(this.a)))
      {
        if (com.gau.go.gostaticsdk.f.c.e(paramContext))
        {
          a.e(this.a);
          return;
        }
        a.a(this.a, true);
        return;
      }
    } while (!paramIntent.equals(a.c(this.a)));
    a.g(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */