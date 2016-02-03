package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.gtp.nextlauncher.a.a.a;

public class c
{
  private Activity a;
  
  public c(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private void a(String paramString)
  {
    c(paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    return !TextUtils.isEmpty(a.a(paramContext));
  }
  
  private void b()
  {
    int i = Integer.valueOf(com.gau.go.launcherex.gowidget.statistics.y.f(this.a)).intValue();
    int j = Integer.valueOf(this.a.getString(2131166430)).intValue();
    String str1 = this.a.getString(2131166431);
    String str2 = this.a.getString(2131166432);
    a.a(this.a, i, j, "market://details?id=com.gtp.nextlauncher&referrer=utm_source%3DGOWeather%26utm_medium%3DHyperlink%26utm_campaign%3DNextWeather", "market://details?id=com.gtp.nextlauncher.trial&referrer=utm_source%3DGOWeather%26utm_medium%3DHyperlink%26utm_campaign%3DNextWeather", str1, str2);
  }
  
  private boolean b(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    PackageManager localPackageManager = this.a.getPackageManager();
    try
    {
      i = localPackageManager.getPackageInfo(paramString, 1).versionCode;
      if ("com.gtp.nextlauncher".equals(paramString))
      {
        if (i < 49) {
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (Exception localException)
    {
      int i;
      do
      {
        do
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          bool1 = bool2;
        } while (!"com.gtp.nextlauncher.trial".equals(paramString));
        bool1 = bool2;
      } while (i < 13);
    }
    return false;
  }
  
  private void c()
  {
    com.gau.go.launcherex.gowidget.weather.globalview.y localy = new com.gau.go.launcherex.gowidget.weather.globalview.y(this.a);
    localy.a(2131166433);
    localy.b(2131166434);
    localy.c(2131166435);
    localy.a(new d(this));
    localy.a();
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.putExtra("com.gtp.nextlauncher.intentaction.action", 2);
    localIntent.putExtra("com.gtp.nextlauncher.intentaction.package", this.a.getPackageName());
    int i = 100;
    int[] arrayOfInt = this.a.getResources().getIntArray(2131558429);
    if (arrayOfInt.length > 0) {
      i = arrayOfInt[0];
    }
    localIntent.putExtra("com.gtp.nextlauncher.intentaction.widgettype", i);
    localIntent.setComponent(new ComponentName(paramString, "com.gtp.nextlauncher.LauncherActivity"));
    try
    {
      this.a.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      do
      {
        b();
      } while (!com.gtp.a.a.b.c.a());
      paramString.printStackTrace();
    }
  }
  
  private void d()
  {
    com.gau.go.launcherex.gowidget.weather.globalview.y localy = new com.gau.go.launcherex.gowidget.weather.globalview.y(this.a);
    localy.a(2131166436);
    localy.b(2131166436);
    localy.c(2131166438);
    localy.a(new e(this));
    localy.a();
  }
  
  private void e()
  {
    com.gau.go.launcherex.gowidget.weather.globalview.y localy = new com.gau.go.launcherex.gowidget.weather.globalview.y(this.a);
    localy.a(2131166439);
    localy.b(2131166434);
    localy.c(2131166441);
    localy.a(new f(this));
    localy.a();
  }
  
  public void a()
  {
    String str = a.a(this.a);
    if (TextUtils.isEmpty(str))
    {
      c();
      return;
    }
    if ("com.gtp.nextlauncher".equals(str))
    {
      if (b(str))
      {
        d();
        return;
      }
      a(str);
      return;
    }
    if ("com.gtp.nextlauncher.trial".equals(str))
    {
      if (b(str))
      {
        e();
        return;
      }
      a(str);
      return;
    }
    e();
  }
  
  public boolean a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity != this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.a = paramActivity;
      }
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */