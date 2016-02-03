package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.a.a;

class ao
  extends BroadcastReceiver
{
  ao(an paraman) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"))
    {
      paramContext = c.a(paramContext.getApplicationContext()).f().a();
      this.a.a(paramContext);
      an.a(this.a).a();
      an.b(this.a).a();
    }
    do
    {
      boolean bool;
      do
      {
        int i;
        do
        {
          int j;
          do
          {
            return;
            if (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WEATHER_UPDATE_TIME")) {
              break;
            }
            i = paramIntent.getIntExtra("auto_weather_update", 0);
            j = paramIntent.getIntExtra("auto_weather_frequency", -1);
            if (i != an.c(this.a))
            {
              if (i == 1)
              {
                a.a().a("开启定时刷新功能。");
                an.a(this.a, j);
                this.a.a(false);
              }
              for (;;)
              {
                an.b(this.a, i);
                return;
                this.a.a();
                an.a(this.a, 0L);
                a.a().a("关闭定时刷新功能。");
              }
            }
          } while (an.d(this.a) == j);
          an.a(this.a, j);
        } while (i != 1);
        this.a.a(false);
        return;
        if (!str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
          break;
        }
        bool = paramIntent.getBooleanExtra("noConnectivity", false);
      } while ((!an.e(this.a)) || (bool));
      a.a().a("网络准备好，开始刷新。");
      an.c(this.a, 2);
      an.a(this.a, false);
      return;
      if ((str.equals("android.intent.action.TIME_SET")) || (str.equals("android.intent.action.TIMEZONE_CHANGED")))
      {
        a.a().a("[Broadcast] ACTION_TIME_CHANGED");
        this.a.a(false);
        return;
      }
    } while (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_UPDATE"));
    a.a().a("定时刷新时间到达，开始刷新。");
    if (r.c(an.f(this.a)))
    {
      an.c(this.a, 2);
      return;
    }
    a.a().a("没有网络，等待网络好了后，刷新天气。");
    an.a(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */