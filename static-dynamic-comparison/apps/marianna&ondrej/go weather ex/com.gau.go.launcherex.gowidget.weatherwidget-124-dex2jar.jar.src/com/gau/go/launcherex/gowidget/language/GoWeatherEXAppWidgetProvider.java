package com.gau.go.launcherex.gowidget.language;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class GoWeatherEXAppWidgetProvider
  extends AppWidgetProvider
{
  private static b a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (a == null) {
      a = d.a(paramContext).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/GoWeatherEXAppWidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */