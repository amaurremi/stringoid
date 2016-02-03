package com.gau.go.launcherex.gowidget.weather.globaltheme.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.gau.go.launcherex.goweather.goplay.q;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.service.a.b;
import com.jiubang.core.b.a;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;

public class d
{
  public static void a(Context paramContext)
  {
    b.a(new e(paramContext));
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if ("com.gau.go.launcherex.gowidget.weatherwidget".equals(GoWidgetApplication.a(paramContext)))
    {
      localObject = GoWidgetApplication.c(paramContext).a().edit();
      ((SharedPreferences.Editor)localObject).putBoolean("new_theme", paramBoolean);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Intent)localObject).putExtra("extra_new_theme_flag", i);
        paramContext.sendBroadcast((Intent)localObject);
        return;
      }
    }
    Object localObject = new Intent(paramContext, NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 35);
    localBundle.putBoolean("request_extra_show_new_theme_star", paramBoolean);
    ((Intent)localObject).putExtras(localBundle);
    paramContext.startService((Intent)localObject);
  }
  
  private static void c(Context paramContext)
  {
    aa.a().a(paramContext);
    Object localObject = aa.a().b();
    if ((localObject == null) || (((c)localObject).o() != 84))
    {
      localObject = new q();
      aa.a().a((c)localObject);
    }
    aa.a().a(new f(paramContext));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */