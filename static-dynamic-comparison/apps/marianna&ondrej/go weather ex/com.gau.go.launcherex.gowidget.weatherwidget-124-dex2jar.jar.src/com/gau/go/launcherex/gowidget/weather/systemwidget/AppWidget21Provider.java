package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXAppWidgetProvider;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gtp.a.a.b.c;

public class AppWidget21Provider
  extends GoWeatherEXAppWidgetProvider
{
  public AppWidget21Provider()
  {
    c.b("appwidget_21", "AppWidget21Provider");
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", paramInt);
    if (paramIntent != null) {
      localIntent.putExtra("request_extra_appwidget_21", paramIntent);
    }
    paramContext.startService(localIntent);
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    c.b("appwidget_21", "onDeleted");
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      c.a("appwidget_21", "appWidgetIds[" + i + "]" + paramArrayOfInt[i]);
      i += 1;
    }
    super.onDeleted(paramContext, paramArrayOfInt);
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET21");
    localIntent.putExtra("extra_appwidget_ids", paramArrayOfInt);
    a(paramContext, 13, localIntent);
  }
  
  public void onDisabled(Context paramContext)
  {
    c.b("appwidget_21", "onDisabled");
    super.onDisabled(paramContext);
    a(paramContext, 4, null);
  }
  
  public void onEnabled(Context paramContext)
  {
    c.b("appwidget_21", "onEnabled");
    super.onEnabled(paramContext);
    a(paramContext, 3, null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
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
          c.b("appwidget_21", "action:" + str);
        } while (TextUtils.isEmpty(str));
        if ((!str.equals("android.appwidget.action.APPWIDGET_UPDATE")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET21"))) {
          break;
        }
      } while (!a.a(paramContext, AppWidget21Provider.class));
      c.b("appwidget_21", "ids > 0    ACTION_APPWIDGET_UPDATE");
      a(paramContext, 3, paramIntent);
      return;
    } while (((!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) && (!str.equals("android.intent.action.TIME_SET")) && (!str.equals("android.net.conn.CONNECTIVITY_CHANGE"))) || (!a.a(paramContext, AppWidget21Provider.class)));
    a(paramContext, 3, null);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    c.b("appwidget_21", "onUpdate");
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      c.a("appwidget_21", "appWidgetIds[" + i + "]" + paramArrayOfInt[i]);
      i += 1;
    }
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/AppWidget21Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */