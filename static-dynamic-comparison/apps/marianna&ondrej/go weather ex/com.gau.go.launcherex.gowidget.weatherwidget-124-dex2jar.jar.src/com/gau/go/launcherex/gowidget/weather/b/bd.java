package com.gau.go.launcherex.gowidget.weather.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDayForecastActivity;
import com.jiubang.core.b.a;

public class bd
{
  Context a;
  BroadcastReceiver b;
  BroadcastReceiver c;
  a d = null;
  SharedPreferences e = null;
  SharedPreferences.Editor f = null;
  private boolean g = true;
  private boolean h = false;
  private Time i = new Time();
  private long j = 0L;
  private long k = 0L;
  private int l = 0;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  
  public bd(Context paramContext)
  {
    this.a = paramContext;
    com.gtp.a.a.b.c.a("Remind Handler", "注册数据加载监听器");
    if (this.c == null) {
      this.c = new be(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    this.a.registerReceiver(this.c, localIntentFilter);
    this.d = GoWidgetApplication.c(paramContext.getApplicationContext());
    this.e = this.d.a();
    this.f = this.e.edit();
  }
  
  private long a(int paramInt)
  {
    if (paramInt <= 3) {
      return 300000L;
    }
    if (paramInt == 4) {
      return 600000L;
    }
    if (paramInt == 5) {
      return 1200000L;
    }
    if (paramInt == 6) {
      return 1800000L;
    }
    return 3600000L;
  }
  
  private void c()
  {
    if (this.b != null)
    {
      this.a.unregisterReceiver(this.b);
      this.b = null;
    }
    if (this.h)
    {
      i();
      this.h = false;
    }
  }
  
  private void d()
  {
    if (!this.h)
    {
      com.gtp.a.a.b.c.a("Remind Handler", "注册业务广播接收器，初始化数据");
      if (this.b == null) {
        this.b = new bf(this);
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PREPARE_FORECASET_DATA");
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FORECASET");
      localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
      localIntentFilter.addAction("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.a.registerReceiver(this.b, localIntentFilter);
      this.h = true;
      this.m = false;
    }
    h();
  }
  
  private void e()
  {
    if ((this.n) && (!k())) {
      f();
    }
    if ((this.o) && (!l())) {
      g();
    }
  }
  
  private void f()
  {
    com.gtp.a.a.b.c.a("Remind Handler", "触发弹窗");
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, WeatherDayForecastActivity.class);
    localIntent.setFlags(268435456);
    this.a.startActivity(localIntent);
    this.i.setToNow();
    this.f.putLong("last_forecast_time", this.i.toMillis(true));
    this.f.commit();
  }
  
  private void g()
  {
    com.gtp.a.a.b.c.a("Remind Handler", "触发通知栏");
    at.a(this.a);
    this.i.setToNow();
    this.f.putLong("last_notify_time", this.i.toMillis(true));
    this.f.commit();
  }
  
  private void h()
  {
    com.gtp.a.a.b.c.a("Remind Handler", "设置定时器");
    AlarmManager localAlarmManager = (AlarmManager)this.a.getSystemService("alarm");
    this.i.setToNow();
    Object localObject = new Time();
    ((Time)localObject).set(0, 30, 18, this.i.monthDay, this.i.month, this.i.year);
    long l2 = ((Time)localObject).toMillis(true);
    long l1 = l2;
    if (m()) {
      l1 = l2 + 86400000L;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PREPARE_FORECASET_DATA");
    localAlarmManager.setRepeating(0, l1, 86400000L, PendingIntent.getBroadcast(this.a, 2, (Intent)localObject, 268435456));
    localObject = new Intent();
    ((Intent)localObject).setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FORECASET");
    localAlarmManager.setRepeating(0, l1 + 1800000L, 86400000L, PendingIntent.getBroadcast(this.a, 3, (Intent)localObject, 268435456));
  }
  
  private void i()
  {
    com.gtp.a.a.b.c.a("Remind Handler", "取消定时器");
    AlarmManager localAlarmManager = (AlarmManager)this.a.getSystemService("alarm");
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PREPARE_FORECASET_DATA");
    localAlarmManager.cancel(PendingIntent.getBroadcast(this.a, 2, localIntent, 268435456));
    localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FORECASET");
    localAlarmManager.cancel(PendingIntent.getBroadcast(this.a, 3, localIntent, 268435456));
  }
  
  private int j()
  {
    this.i.setToNow();
    int i1 = this.i.hour;
    int i2 = this.i.minute;
    if ((i1 >= 24) || (i1 < 18) || ((i1 == 18) && (i2 < 30))) {
      return 1;
    }
    if ((i1 < 24) && (i1 >= 19)) {
      return 2;
    }
    return 3;
  }
  
  private boolean k()
  {
    long l1 = this.e.getLong("last_forecast_time", 0L);
    Time localTime = new Time();
    localTime.set(l1);
    this.i.setToNow();
    if ((localTime.yearDay == this.i.yearDay) && (localTime.year == this.i.year))
    {
      com.gtp.a.a.b.c.a("Remind Handler", "今天已经触发过预报");
      return true;
    }
    com.gtp.a.a.b.c.a("Remind Handler", "今天没触发过预报");
    return false;
  }
  
  private boolean l()
  {
    long l1 = this.e.getLong("last_notify_time", 0L);
    Time localTime = new Time();
    localTime.set(l1);
    this.i.setToNow();
    if ((localTime.yearDay == this.i.yearDay) && (localTime.year == this.i.year))
    {
      com.gtp.a.a.b.c.a("Remind Handler", "今天已经触发温差提醒");
      return true;
    }
    com.gtp.a.a.b.c.a("Remind Handler", "今天未触发温差提醒");
    return false;
  }
  
  private boolean m()
  {
    boolean bool;
    if (this.n) {
      if (k()) {
        bool = true;
      }
    }
    for (;;)
    {
      if (this.o)
      {
        if ((bool) && (l()))
        {
          return true;
          bool = false;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return bool;
        bool = true;
      }
    }
  }
  
  private boolean n()
  {
    this.i.setToNow();
    long l1 = this.i.toMillis(true) - this.k;
    if ((l1 < 1800000L) && (l1 >= 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      com.gtp.a.a.b.c.a("Remind Handler", "上次刷新成功时间：" + this.k);
      com.gtp.a.a.b.c.a("Remind Handler", "当前时间：" + this.i.toMillis(true));
      return bool;
    }
  }
  
  public void a()
  {
    int i1 = 0;
    q localq = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).f().a();
    if (localq.s == 1)
    {
      bool = true;
      this.n = bool;
      if (localq.u != 1) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.o = bool;
      if ((this.o) || (this.n)) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label92;
      }
      com.gtp.a.a.b.c.a("Remind Handler", "开关打开");
      d();
      return;
      bool = false;
      break;
    }
    label92:
    com.gtp.a.a.b.c.a("Remind Handler", "开关关闭");
    c();
  }
  
  public void b()
  {
    com.gtp.a.a.b.c.a("Remind Handler", "销毁");
    if (this.c != null)
    {
      this.a.unregisterReceiver(this.c);
      this.c = null;
    }
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */