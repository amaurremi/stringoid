package com.gau.go.launcherex.gowidget.statistics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.text.format.Time;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.b.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class j
{
  private static volatile j a;
  private Context b;
  private AlarmManager c;
  private n d;
  private ExecutorService e;
  
  private j(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((AlarmManager)paramContext.getSystemService("alarm"));
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.statistics.network_time_and_status_upload");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.d = new n(this, null);
    this.b.registerReceiver(this.d, paramContext);
    this.e = Executors.newFixedThreadPool(1);
  }
  
  public static j a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new j(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    this.e.execute(new m(this));
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("network_time_and_status_schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("network_time_and_status_schedule_upload", paramBoolean).commit();
    }
  }
  
  private void b(long paramLong)
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("network_time_and_status_schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("network_time_and_status_schedule_upload_time", paramLong).commit();
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("network_time_and_status_schedule_task", 0);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("network_time_and_status_schedule_upload", false);
    }
    return bool;
  }
  
  private long c()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("network_time_and_status_schedule_task", 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("network_time_and_status_schedule_upload_time", 0L);
    }
    return l;
  }
  
  private void c(long paramLong)
  {
    try
    {
      a.a().a(d(paramLong) + "后发送上传数据的广播", "statistics_log.txt");
      c.a("CYN", d(paramLong) + "后发送上传数据的广播");
      long l = System.currentTimeMillis();
      Object localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.statistics.network_time_and_status_upload");
      localObject = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject, 134217728);
      this.c.set(0, l + paramLong, (PendingIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String d()
  {
    Time localTime = new Time("Asia/Shanghai");
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTime.year);
    localStringBuilder.append('-');
    localStringBuilder.append(localTime.month + 1);
    localStringBuilder.append('-');
    localStringBuilder.append(localTime.monthDay);
    localStringBuilder.append(' ');
    localStringBuilder.append(localTime.hour);
    localStringBuilder.append(':');
    localStringBuilder.append(localTime.minute);
    localStringBuilder.append(':');
    localStringBuilder.append(localTime.second);
    localStringBuilder.append(' ');
    localStringBuilder.append(localTime.gmtoff);
    return localStringBuilder.toString();
  }
  
  private String d(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong /= 1000L;
    localStringBuilder.append(paramLong / 3600L).append("小时").append(paramLong % 3600L / 60L).append("分钟").append(paramLong % 60L).append("秒");
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    d.a(this.b, 1, null);
  }
  
  public void a(long paramLong)
  {
    c(paramLong);
  }
  
  public void a(f paramf)
  {
    int i = 1;
    label643:
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("26||");
        localStringBuilder.append(Settings.Secure.getString(this.b.getContentResolver(), "android_id") + "||");
        localStringBuilder.append(d() + "||");
        localStringBuilder.append(com.gau.go.gostaticsdk.d.b(this.b) + "||");
        localStringBuilder.append(y.n(this.b) + "||");
        localStringBuilder.append(y.f(this.b) + "||");
        localStringBuilder.append(y.c(this.b) + "||");
        localStringBuilder.append(paramf.f() + "||");
        if (paramf.c() != 1) {
          if (paramf.c() == 2)
          {
            break label643;
            localStringBuilder.append(i + "||");
            localStringBuilder.append(paramf.b() + "||");
            c.a("NetworkStatistics", "请求时间 - " + paramf.d());
            localStringBuilder.append(paramf.d() + "||");
            localStringBuilder.append(paramf.g() + "||");
            localStringBuilder.append(paramf.i() + "||");
            localStringBuilder.append("0||");
            localStringBuilder.append("0||");
            localStringBuilder.append(paramf.k());
            paramf = localStringBuilder.toString();
            this.e.execute(new l(this, paramf, "network_time_and_status_statistics.txt", this.b));
            this.e.execute(new l(this, paramf, "network_time_and_status_statistics_email.txt", this.b));
          }
          else
          {
            int j = paramf.e();
            switch (j)
            {
            case 6: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 9: 
            case 11: 
            default: 
              i = 100;
              break;
            case 7: 
              i = 2;
              break;
            case 8: 
              i = 3;
              break;
            case 0: 
              i = 4;
              break;
            case -1: 
              i = 5;
              break;
            case 10: 
              i = 6;
              break;
            case 12: 
              i = 7;
              break;
            }
          }
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public void a(String paramString)
  {
    this.e.execute(new l(this, paramString, "collect_data_weather_refresh_error_info.txt", this.b));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */