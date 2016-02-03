package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gtp.a.a.b.c;

public class AppWidgetWorldClock42Provider
  extends AppWidgetProvider
{
  public AppWidgetWorldClock42Provider()
  {
    c.a("appwidget_worldclock", "AppWidgetWorldClock42Provider");
  }
  
  private void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", paramInt);
    if (paramIntent != null) {
      localIntent.putExtra("request_extra_appwidget_world_clock_42_enabled", paramIntent);
    }
    paramContext.startService(localIntent);
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    c.a("appwidget_worldclock", "onDeleted");
    super.onDeleted(paramContext, paramArrayOfInt);
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET_WORLDCLOCK42");
    localIntent.putExtra("extra_appwidget_ids", paramArrayOfInt);
    a(paramContext, 18, localIntent);
  }
  
  public void onDisabled(Context paramContext)
  {
    c.a("appwidget_worldclock", "onDisabled");
    super.onDisabled(paramContext);
    a(paramContext, 2, null);
  }
  
  public void onEnabled(Context paramContext)
  {
    c.a("appwidget_worldclock", "onEnabled");
    super.onEnabled(paramContext);
    a(paramContext, 1, null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    c.a("appwidget_worldclock", "AppWidgetWorldClock42Provider.onReceive:" + paramContext.getPackageName());
    super.onReceive(paramContext, paramIntent);
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = paramIntent.getAction();
          c.a("appwidget_worldclock", "AppWidgetWorldClock42Provider.onReceive>>action:" + str);
        } while (TextUtils.isEmpty(str));
        if (!str.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
          break;
        }
      } while (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetWorldClock42Provider.class)).length <= 0);
      Log.i("appwidget_worldclock", "+ " + str);
      a(paramContext, 1, paramIntent);
      return;
    } while (((!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) && (!str.equals("android.intent.action.TIME_SET"))) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidgetWorldClock42Provider.class)).length <= 0));
    Log.i("appwidget_worldclock", "++ " + str);
    a(paramContext, 1, null);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    c.a("appwidget_worldclock", "onUpdate");
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/AppWidgetWorldClock42Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */