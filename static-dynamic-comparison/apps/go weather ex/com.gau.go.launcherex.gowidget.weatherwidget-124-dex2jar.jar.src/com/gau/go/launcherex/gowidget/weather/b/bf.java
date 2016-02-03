package com.gau.go.launcherex.gowidget.weather.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.format.Time;
import com.gtp.a.a.b.c;
import java.util.ArrayList;

class bf
  extends BroadcastReceiver
{
  bf(bd parambd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 21;
    int j = 0;
    int k = bd.a(this.a);
    paramContext = paramIntent.getAction();
    if ((paramContext.equals("android.intent.action.TIME_SET")) || (paramContext.equals("android.intent.action.TIMEZONE_CHANGED")))
    {
      c.a("Remind Handler", "用户改变时区或时间");
      bd.b(this.a).setToNow();
      i = j;
      if (Math.abs(bd.b(this.a).toMillis(true) - bd.c(this.a)) < 1800000L) {
        i = 1;
      }
      if (i == 0)
      {
        c.a("Remind Handler", "刷新时间清零");
        bd.a(this.a, 0L);
      }
      bd.b(this.a, bd.b(this.a).toMillis(true));
      bd.d(this.a);
    }
    label411:
    label691:
    label697:
    for (;;)
    {
      return;
      if (paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        if (bd.e(this.a))
        {
          c.a("Remind Handler", "服务启动前的网络状态改变广播，丢弃");
          return;
        }
        if (!bool)
        {
          c.a("Remind Handler", "网络连接恢复");
          if (k == 3)
          {
            if (bd.f(this.a)) {}
          }
          else if ((k != 2) || (bd.f(this.a)) || (bd.g(this.a))) {}
        }
      }
      else if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PREPARE_FORECASET_DATA"))
      {
        if (k == 3)
        {
          c.a("Remind Handler", "开始刷新");
          return;
        }
        if ((k == 2) && (!bd.g(this.a))) {
          c.a("Remind Handler", "弹窗时间，先检查刷新");
        }
      }
      else if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FORECASET"))
      {
        if (k == 2)
        {
          c.a("Remind Handler", "到达7点");
          if (bd.f(this.a)) {
            bd.h(this.a);
          }
        }
      }
      else if ((paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA")) && ((k == 3) || (k == 2)))
      {
        c.a("Remind Handler", "刷新完成");
        paramContext = paramIntent.getExtras();
        if (paramContext != null)
        {
          j = paramContext.getInt("weather_update_status", 1);
          i = paramContext.getInt("request", 21);
        }
        for (;;)
        {
          if (((j != 1) && (j != 2)) || (i != 22)) {
            break label697;
          }
          paramContext = paramContext.getIntegerArrayList("weather_status");
          if (paramContext != null) {}
          for (i = paramContext.size();; i = 0)
          {
            if (i == 0) {
              break label691;
            }
            j = 0;
            if (j < i) {
              if ((((Integer)paramContext.get(j)).intValue() == 1) || (((Integer)paramContext.get(j)).intValue() == 2)) {}
            }
            for (i = 0;; i = 1)
            {
              if (i != 0)
              {
                c.a("Remind Handler", "全部刷新成功");
                bd.a(this.a, 0);
                bd.b(this.a).setToNow();
                bd.a(this.a, bd.b(this.a).toMillis(true));
                if (k != 2) {
                  break;
                }
                bd.h(this.a);
                return;
                j += 1;
                break label411;
              }
              if (!bd.i(this.a)) {
                break;
              }
              c.a("Remind Handler", "有失败");
              bd.b(this.a, false);
              paramContext = ((ConnectivityManager)this.a.a.getSystemService("connectivity")).getActiveNetworkInfo();
              if ((paramContext == null) || (!paramContext.isAvailable()) || (!paramContext.isConnected())) {
                break;
              }
              bd.b(this.a).setToNow();
              long l1 = bd.b(this.a, bd.j(this.a));
              long l2 = bd.b(this.a).toMillis(true);
              paramContext = (AlarmManager)this.a.a.getSystemService("alarm");
              paramIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PREPARE_FORECASET_DATA");
              paramIntent = PendingIntent.getBroadcast(this.a.a, 2, paramIntent, 268435456);
              paramContext.cancel(paramIntent);
              paramContext.set(0, l1 + l2, paramIntent);
              return;
            }
          }
          break;
          j = 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */