package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXAppWidgetProvider;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gtp.a.a.b.c;

public class AppWidget41Provider
  extends GoWeatherEXAppWidgetProvider
{
  public static void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", paramInt);
    if (paramIntent != null) {
      localIntent.putExtra("request_extra_appwidget_41", paramIntent);
    }
    paramContext.startService(localIntent);
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_DELETE_APPWIDGET41");
    localIntent.putExtra("extra_appwidget_ids", paramArrayOfInt);
    a(paramContext, 14, localIntent);
  }
  
  public void onDisabled(Context paramContext)
  {
    c.a("appwidget_41_provider", "onDisabled");
    super.onDisabled(paramContext);
    a(paramContext, 10, null);
  }
  
  public void onEnabled(Context paramContext)
  {
    c.a("appwidget_41_provider", "onEnabled");
    super.onEnabled(paramContext);
    a(paramContext, 9, null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (!TextUtils.isEmpty(str)) {
        break label23;
      }
    }
    label23:
    do
    {
      do
      {
        return;
        if ((!str.equals("android.appwidget.action.APPWIDGET_UPDATE")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET41"))) {
          break;
        }
      } while (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length <= 0);
      a(paramContext, 9, paramIntent);
      return;
    } while (((!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_REFRESH_STARTED")) && (!str.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATA_READY")) && (!str.equals("android.intent.action.TIME_SET")) && (!str.equals("android.net.conn.CONNECTIVITY_CHANGE"))) || (AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, AppWidget41Provider.class)).length <= 0));
    a(paramContext, 9, null);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/AppWidget41Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */