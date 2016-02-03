package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;

class aq
  extends BroadcastReceiver
{
  private boolean b;
  private long c;
  private boolean d;
  
  aq(ap paramap) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) {
        break label24;
      }
      this.b = true;
    }
    label24:
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            break;
          }
          paramContext = ap.a(this.a).getActiveNetworkInfo();
        } while ((!this.d) || (!this.b) || (paramContext == null) || (!paramContext.isConnected()));
        ap.b(this.a);
        this.d = false;
        return;
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          this.d = false;
          this.c = SystemClock.elapsedRealtime();
          return;
        }
      } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
      paramContext = ap.a(this.a).getActiveNetworkInfo();
      l = SystemClock.elapsedRealtime();
      if ((this.b) && (paramContext != null) && (paramContext.isConnected()) && (l - this.c > 600000L))
      {
        ap.b(this.a);
        return;
      }
    } while ((!this.b) || ((paramContext != null) && (paramContext.isConnected())) || (l - this.c <= 600000L));
    this.d = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */