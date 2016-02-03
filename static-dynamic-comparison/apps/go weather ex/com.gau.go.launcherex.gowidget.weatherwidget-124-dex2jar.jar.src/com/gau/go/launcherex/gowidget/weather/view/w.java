package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

public class w
{
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ThemeSettingActivity.class);
    localIntent.setFlags(335544320);
    localIntent.putExtra("extra_theme_entrance", paramInt);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */