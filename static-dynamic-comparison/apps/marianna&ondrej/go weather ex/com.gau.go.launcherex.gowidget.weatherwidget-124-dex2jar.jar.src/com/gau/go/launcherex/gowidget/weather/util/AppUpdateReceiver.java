package com.gau.go.launcherex.gowidget.weather.util;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.billing.r;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.a;
import com.gau.go.launcherex.gowidget.weather.systemwidget.e;
import com.gau.go.launcherex.gowidget.weather.systemwidget.i;

public class AppUpdateReceiver
  extends BroadcastReceiver
{
  private void a(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE"));
  }
  
  private void b(Context paramContext)
  {
    paramContext.startService(new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService"));
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", -1);
    paramContext.startService(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str.equals("android.intent.action.PACKAGE_REPLACED"))
    {
      str = paramIntent.getDataString().replace("package:", "");
      boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((str.equals(paramContext.getPackageName())) && (bool))
      {
        a(paramContext);
        paramIntent = paramContext.getSharedPreferences("bill_recommend", 0);
        int i = paramIntent.getInt("enter_times", 10) / 10;
        paramIntent = paramIntent.edit();
        paramIntent.putInt("enter_times", i * 10);
        paramIntent.commit();
        b(paramContext);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget42Provider.class)).length <= 0) {
                break;
              }
            } while (!str.equals(i.a));
            a(paramContext);
            return;
            if (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length <= 0) {
              break;
            }
          } while (!str.equals(e.a));
          a(paramContext);
          return;
        } while ((AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget21Provider.class)).length <= 0) || (!str.equals(a.a)));
        a(paramContext);
        return;
      } while ((!str.equals("android.intent.action.MEDIA_MOUNTED")) && (!str.equals("android.intent.action.MEDIA_SCANNER_FINISHED")));
      paramIntent = GoWidgetApplication.b(paramContext.getApplicationContext());
      if ((!paramIntent.b()) && (r.a(paramContext.getApplicationContext())) && (paramIntent.a("goweatherex_getjar_id", true))) {
        paramIntent.b("goweatherex_getjar_id");
      }
    } while ((AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget42Provider.class)).length <= 0) && (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length <= 0) && (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget21Provider.class)).length <= 0));
    a(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/AppUpdateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */