package com.gau.go.launcherex.gowidget.statistics;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gtp.a.a.a.a;

public final class u
{
  private static u d;
  private Context a;
  private AlarmManager b;
  private x c;
  
  private u(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((AlarmManager)paramContext.getSystemService("alarm"));
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.statistics.action_upload");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.c = new x(this, null);
    this.a.registerReceiver(this.c, paramContext);
  }
  
  public static u a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new u(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("upload", paramBoolean).commit();
    }
  }
  
  private String b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong /= 1000L;
    localStringBuilder.append(paramLong / 3600L).append("小时").append(paramLong % 3600L / 60L).append("分钟").append(paramLong % 60L).append("秒");
    return localStringBuilder.toString();
  }
  
  private void c(long paramLong)
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("upload_time", paramLong).commit();
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("upload", false);
    }
    return bool;
  }
  
  private long d()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("upload_time", 0L);
    }
    return l;
  }
  
  private void d(long paramLong)
  {
    try
    {
      a.a().a(b(paramLong) + "后发送上传数据的广播", "statistics_log.txt");
      long l = System.currentTimeMillis();
      Object localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.statistics.action_upload");
      localObject = PendingIntent.getBroadcast(this.a, 0, (Intent)localObject, 134217728);
      this.b.set(0, l + paramLong, (PendingIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    new w(this).execute(new Void[0]);
  }
  
  public void a()
  {
    d(180000L);
  }
  
  public void a(long paramLong)
  {
    d(paramLong);
  }
  
  public void b()
  {
    try
    {
      this.a.unregisterReceiver(this.c);
      d = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */