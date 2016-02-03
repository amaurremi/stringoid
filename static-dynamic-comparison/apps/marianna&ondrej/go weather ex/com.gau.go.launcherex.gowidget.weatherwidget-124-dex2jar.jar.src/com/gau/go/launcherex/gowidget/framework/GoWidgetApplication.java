package com.gau.go.launcherex.gowidget.framework;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.os.Process;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.MapsInitializer;
import com.gtp.go.weather.sharephoto.a.g;
import com.jiubang.core.b.a;
import com.jiubang.core.util.CrashReport;
import java.util.Iterator;
import java.util.List;

public class GoWidgetApplication
  extends Application
{
  public static boolean a = true;
  public static boolean b;
  private static com.gau.go.launcherex.gowidget.weather.c.c c;
  private static a d;
  private static GoWidgetApplication e;
  
  public static String a(Context paramContext)
  {
    int i = Process.myPid();
    Object localObject;
    if (paramContext != null)
    {
      localObject = paramContext.getApplicationContext();
      if (localObject != null) {
        break label88;
      }
    }
    for (;;)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localObject != null) && (((ActivityManager.RunningAppProcessInfo)localObject).pid == i))
          {
            com.gtp.a.a.b.c.a("LJL", ((ActivityManager.RunningAppProcessInfo)localObject).processName);
            return ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
      }
      return null;
      label88:
      paramContext = (Context)localObject;
    }
  }
  
  public static com.gau.go.launcherex.gowidget.weather.d.f b(Context paramContext)
  {
    if (c != null)
    {
      com.gau.go.launcherex.gowidget.weather.d.f localf = c.e();
      paramContext = localf;
      if (localf != null) {}
    }
    else
    {
      paramContext = com.gau.go.launcherex.gowidget.weather.d.f.a(e);
    }
    return paramContext;
  }
  
  public static i c()
  {
    return c.d();
  }
  
  public static a c(Context paramContext)
  {
    if (d == null) {
      d = new a(paramContext);
    }
    return d;
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PAYINFO_SAVE_FINISH");
    registerReceiver(new e(this), localIntentFilter);
  }
  
  private void e()
  {
    if (d.a().getBoolean("new_theme", false))
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
      localIntent.putExtra("extra_new_theme_flag", 1);
      sendBroadcast(localIntent);
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(getApplicationContext(), NotifyService.class);
    localIntent.putExtra("notify_request", 31);
    startService(localIntent);
  }
  
  private void g()
  {
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    Object localObject = new Intent(getApplicationContext(), NotifyService.class);
    ((Intent)localObject).putExtra("notify_request", 12);
    localObject = PendingIntent.getService(getApplicationContext(), 1, (Intent)localObject, 134217728);
    localAlarmManager.set(0, System.currentTimeMillis() + 30000L, (PendingIntent)localObject);
  }
  
  public void a()
  {
    if (((ActivityManager)getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion < 131072) {
      a = false;
    }
    if ((a) && (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) != 0)) {
      a = false;
    }
    try
    {
      if (a) {
        MapsInitializer.initialize(getApplicationContext());
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a = false;
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", -1);
    startService(localIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (("com.gau.go.launcherex.gowidget.weatherwidget".equals(a(getApplicationContext()))) && (c != null)) {
      c.c().i();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    e = this;
    new CrashReport().start(this);
    String str = a(this);
    if ("com.gau.go.launcherex.gowidget.weatherwidget".equals(str))
    {
      b = true;
      removeStickyBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY"));
      removeStickyBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED"));
      c = com.gau.go.launcherex.gowidget.weather.c.c.a(this);
      c.a();
      b();
      f();
      d = new a(this);
      com.gau.go.launcherex.gowidget.a.b.a(this).a();
      g();
      e();
      a();
      g.a(this);
      if (!com.go.weatherex.d.f.c(e)) {
        com.go.weatherex.d.b.a(e);
      }
    }
    while (!"com.gau.go.launcherex.gowidget.weatherwidget:Activity".equals(str)) {
      return;
    }
    c = com.gau.go.launcherex.gowidget.weather.c.c.a(this);
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/framework/GoWidgetApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */