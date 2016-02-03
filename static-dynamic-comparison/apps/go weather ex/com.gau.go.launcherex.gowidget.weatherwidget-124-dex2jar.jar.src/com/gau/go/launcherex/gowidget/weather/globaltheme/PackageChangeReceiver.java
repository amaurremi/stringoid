package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.messagecenter.util.y;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import com.gau.go.launcherex.gowidget.weather.util.k;
import com.go.weatherex.d.f;
import com.gtp.a.a.b.c;

public class PackageChangeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    boolean bool;
    if (str.equals("android.intent.action.PACKAGE_ADDED"))
    {
      str = paramIntent.getDataString().replace("package:", "");
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((!TextUtils.isEmpty(str)) && (!bool))
      {
        c.a("LJL", "------------ACTION_PACKAGE_ADDED------" + System.currentTimeMillis());
        paramIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PACKAGE_ADDED");
        paramIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE", str);
        paramContext.sendBroadcast(paramIntent);
        new y(paramContext).b(str);
        f.a(paramContext, str);
      }
      paramIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_HIDE_THEME_ICON");
      if (Build.VERSION.SDK_INT >= 12) {
        paramIntent.setFlags(32);
      }
      paramContext.sendBroadcast(paramIntent);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!str.equals("android.intent.action.PACKAGE_REMOVED")) {
            break;
          }
          str = paramIntent.getDataString().replace("package:", "");
          bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
        } while ((TextUtils.isEmpty(str)) || (bool));
        c.a("LJL", "------------ACTION_PACKAGE_REMOVED------" + System.currentTimeMillis());
        paramIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PACKAGE_REMOVED");
        paramIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE", str);
        paramContext.sendBroadcast(paramIntent);
        paramIntent = new Intent(paramContext, ThemeService.class);
        paramIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE", str);
        paramIntent.putExtra("theme_data_request_code", 4);
        paramContext.startService(paramIntent);
        paramIntent = d.a(paramContext);
        if (str.equals("com.gau.go.weatherex.language." + paramIntent.c()))
        {
          c.a("Language", "当前正在使用的语言包被删除");
          paramIntent.a("default", "com.gau.go.launcherex.gowidget.weatherwidget");
        }
        k.a(paramContext, str);
        return;
      } while (!str.equals("android.intent.action.PACKAGE_REPLACED"));
      str = paramIntent.getDataString().replace("package:", "");
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
    } while ((TextUtils.isEmpty(str)) || (!bool));
    paramIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_PACKAGE_REPLACED");
    paramIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE", str);
    paramContext.sendBroadcast(paramIntent);
    paramIntent = new Intent(paramContext, ThemeService.class);
    paramIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE", str);
    paramIntent.putExtra("theme_data_request_code", 5);
    paramContext.startService(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/PackageChangeReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */