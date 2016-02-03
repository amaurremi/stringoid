package com.gau.go.launcherex.gowidget.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.d.g;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;

class n
  extends BroadcastReceiver
{
  private n(j paramj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    for (;;)
    {
      try
      {
        if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          if ((!j.a(this.a)) || (!g.a(j.b(this.a)))) {
            return;
          }
          a.a().a("网络连接恢复", "statistics_log.txt");
          c.a("CYN", "网络连接恢复");
          j.c(this.a);
          j.a(this.a, false);
          return;
        }
        if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.statistics.network_time_and_status_upload")) {
          break;
        }
        a.a().a("收到开始上传广播", "statistics_log.txt");
        c.a("CYN", "收到开始上传广播");
        if (g.a(j.b(this.a)))
        {
          j.c(this.a);
          j.d(this.a);
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      a.a().a("无网络，等待网络链接", "statistics_log.txt");
      c.a("CYN", "无网络，等待网络链接");
      j.a(this.a, true);
    }
    if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
    {
      long l = j.e(this.a);
      if (System.currentTimeMillis() < l)
      {
        a.a().a("时间被往后调了，马上启动一次上传", "statistics_log.txt");
        c.a("CYN", "时间被往后调了，马上启动一次上传");
        j.a(this.a, 0L);
        j.c(this.a);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */