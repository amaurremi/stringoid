package com.gau.go.launcherex.gowidget.a;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.gtp.a.a.a.a;

class e
  extends BroadcastReceiver
{
  private e(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      do
      {
        return;
        if (!str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          break;
        }
      } while ((!paramIntent.getBooleanExtra("noConnectivity", false)) || (!b.a(this.a)));
      this.a.a();
      return;
      if ((str.equals("android.intent.action.TIME_SET")) || (str.equals("android.intent.action.TIMEZONE_CHANGED")))
      {
        a.a().a("[广播]时间改变了，定时器重新调度。", "getjar_log.txt");
        b.a(this.a, false);
        return;
      }
      if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GETJAR_HTTP_REQUEST"))
      {
        this.a.a();
        return;
      }
    } while ((!str.equals("android.intent.action.LOCALE_CHANGED")) || (((TelephonyManager)paramContext.getSystemService("phone")).getSimState() == 5));
    b.c(this.a).cancel(b.b(this.a));
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */