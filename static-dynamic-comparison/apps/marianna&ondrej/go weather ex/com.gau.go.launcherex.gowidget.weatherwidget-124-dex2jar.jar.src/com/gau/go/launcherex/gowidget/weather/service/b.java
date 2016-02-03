package com.gau.go.launcherex.gowidget.weather.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.d;

class b
  extends BroadcastReceiver
{
  private b(AppWidgetService paramAppWidgetService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label14;
      }
    }
    label14:
    int i;
    do
    {
      do
      {
        return;
        if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED"))
        {
          d.a(this.a).a(this.a);
          return;
        }
      } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_INITIALIZED_CITY"));
      i = paramIntent.getIntExtra("city_location_state", 3);
      paramContext = paramIntent.getStringExtra("city_location_id");
    } while ((i != 4) || (TextUtils.isEmpty(paramContext)));
    AppWidgetService.a(this.a, 1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */