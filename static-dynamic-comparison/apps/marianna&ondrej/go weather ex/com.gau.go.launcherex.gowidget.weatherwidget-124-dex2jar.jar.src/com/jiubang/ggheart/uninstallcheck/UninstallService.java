package com.jiubang.ggheart.uninstallcheck;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Process;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.a.a.b.c;
import java.util.List;

public class UninstallService
  extends Service
{
  private static int a = 0;
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer("http://goweatherex.3g.cn/goweatherexUninstall/weather/getUninstall");
    localStringBuffer.append("?lang=");
    localStringBuffer.append(y.j(this));
    localStringBuffer.append("&versionName=");
    localStringBuffer.append(y.c(this));
    return localStringBuffer.toString();
  }
  
  public static void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    if (Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels) < 480) {}
    int i;
    do
    {
      return;
      i = UninstallCheck.a(paramContext);
      if (i == 0)
      {
        paramContext.startService(new Intent("com.jiubang.ggheart.uninstallcheck.UninstallService"));
        return;
      }
    } while (i == -2);
    c.a("myunistall_init", "check lock file locked");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(30);
    if (paramContext.size() <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramContext.size())
      {
        if (((ActivityManager.RunningServiceInfo)paramContext.get(i)).service.getClassName().equals(paramString) == true) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    if ((a(paramContext, "com.jiubang.ggheart.uninstallcheck.UninstallService")) && (a != 0)) {
      Process.killProcess(a);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    c.a("UninstallService", "UninstallService onBind");
    return null;
  }
  
  public void onCreate()
  {
    c.a("UninstallService", "UninstallService onCreate");
    c.a("UninstallService", getPackageCodePath());
    c.a("UninstallService", getPackageName());
    a = UninstallCheck.a(this, a());
    c.a("myunistall_init", "pid = " + a);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    c.a("myunistall_init", "UninstallService.ondestory");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    c.a("UninstallService", "UninstallService onStart");
    super.onStart(paramIntent, paramInt);
    stopSelf();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    c.a("UninstallService", "UninstallService onStartCommand");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/uninstallcheck/UninstallService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */