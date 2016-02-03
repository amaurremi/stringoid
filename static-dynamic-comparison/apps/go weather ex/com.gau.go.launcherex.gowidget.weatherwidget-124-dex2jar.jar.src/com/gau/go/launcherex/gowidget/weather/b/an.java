package com.gau.go.launcherex.gowidget.weather.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gtp.a.a.a.a;
import java.util.ArrayList;

public class an
{
  private static an h;
  private Context a;
  private aa b;
  private bg c;
  private AlarmManager d;
  private PendingIntent e;
  private int f;
  private int g;
  private e i;
  private boolean j;
  private final BroadcastReceiver k = new ao(this);
  
  private an(Context paramContext)
  {
    this.a = paramContext;
    this.b = new aa(paramContext);
    this.c = new bg(paramContext);
    this.i = c.a(this.a.getApplicationContext()).f();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WEATHER_UPDATE_TIME");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_UPDATE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    this.a.registerReceiver(this.k, localIntentFilter);
    this.d = ((AlarmManager)paramContext.getSystemService("alarm"));
    this.e = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_UPDATE"), 134217728);
    a.a().a("ScheduleUpdateManager create!");
  }
  
  public static an a(Context paramContext)
  {
    if (h == null) {
      h = new an(paramContext);
    }
    return h;
  }
  
  private void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("update_time", paramLong).commit();
    }
  }
  
  private void b(int paramInt)
  {
    a.a().a("自动更新开始。");
    if (this.i.e()) {
      this.b.a(2);
    }
    this.c.a(paramInt);
  }
  
  private void c(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("update", paramBoolean).commit();
    }
  }
  
  private long d()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("update_time", 0L);
    }
    return l;
  }
  
  private boolean e()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("schedule_task", 0);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("update", false);
    }
    return bool;
  }
  
  private long f()
  {
    return 900000L;
  }
  
  public void a()
  {
    this.d.cancel(this.e);
    c(false);
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(q paramq)
  {
    this.g = paramq.a;
    this.f = paramq.e;
    if (this.g == 1) {
      a(false);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    if (this.i.e()) {
      this.b.a(2);
    }
    this.c.a(paramArrayList, 22, paramInt);
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    this.c.a(paramArrayList, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    long l2 = d();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = System.currentTimeMillis();
      a(l1);
    }
    this.d.cancel(this.e);
    if (paramBoolean)
    {
      l1 = f() + System.currentTimeMillis();
      a.a().a("刷新失败，等待" + (l1 - System.currentTimeMillis()) / 60000L + "分钟后刷新。");
      a.a().a((l1 - System.currentTimeMillis()) / 60000L + "分钟定时刷新开始计时");
    }
    for (;;)
    {
      this.d.set(0, l1, this.e);
      return;
      l1 = l1 - l1 % 60000L + this.f - 600000L;
      a.a().a((l1 - System.currentTimeMillis()) / 60000L + "分钟定时刷新开始计时");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j = false;
      a(System.currentTimeMillis());
      a.a().a("刷新成功，准备下一次定时刷新。");
      a(false);
      return;
    }
    a.a().a("刷新失败，[mIsLastUpdateFailed]=" + this.j);
    a(true);
  }
  
  public boolean b()
  {
    return this.c.b();
  }
  
  public void c()
  {
    this.b.b();
    this.c.c();
    this.a.unregisterReceiver(this.k);
    a();
    h = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */