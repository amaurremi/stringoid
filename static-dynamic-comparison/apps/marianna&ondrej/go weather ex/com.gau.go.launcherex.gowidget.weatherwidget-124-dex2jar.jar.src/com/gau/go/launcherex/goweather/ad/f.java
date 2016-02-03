package com.gau.go.launcherex.goweather.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;

class f
  extends BroadcastReceiver
{
  f(c paramc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
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
        } while (paramIntent.getBooleanExtra("noConnectivity", false));
        if (c.a(this.a))
        {
          c.a(this.a, false);
          c.b(this.a).sendEmptyMessage(0);
        }
      } while (!c.c(this.a));
      c.b(this.a, false);
      c.e(this.a).a(c.d(this.a));
      return;
      if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_REQUEST"))
      {
        c.b(this.a).sendEmptyMessage(0);
        return;
      }
    } while ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INLAND_AD_PROFILE")) || (TextUtils.isEmpty(c.d(this.a))));
    if (com.jiubang.goweather.e.a.b(c.f(this.a)))
    {
      c.e(this.a).a(c.d(this.a));
      return;
    }
    c.b(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */