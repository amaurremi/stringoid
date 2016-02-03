package com.gau.go.launcherex.gowidget.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.d.g;
import com.gtp.a.a.a.a;

class x
  extends BroadcastReceiver
{
  private x(u paramu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    try
    {
      if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        if ((!u.a(this.a)) || (!g.a(u.b(this.a)))) {
          return;
        }
        a.a().a("网络连接恢复", "statistics_log.txt");
        u.c(this.a);
        u.a(this.a, false);
        return;
      }
      if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.statistics.action_upload")) {
        break label128;
      }
      a.a().a("收到开始上传广播", "statistics_log.txt");
      if (g.a(u.b(this.a)))
      {
        u.c(this.a);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    a.a().a("无网络，等待网络链接", "statistics_log.txt");
    u.a(this.a, true);
    return;
    label128:
    if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
    {
      long l = u.d(this.a);
      if (System.currentTimeMillis() < l)
      {
        a.a().a("时间被往后调了，马上启动一次上传", "statistics_log.txt");
        u.a(this.a, 0L);
        u.c(this.a);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */