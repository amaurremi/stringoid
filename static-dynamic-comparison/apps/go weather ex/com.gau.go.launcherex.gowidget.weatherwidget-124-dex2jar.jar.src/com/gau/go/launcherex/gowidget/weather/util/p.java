package com.gau.go.launcherex.gowidget.weather.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class p
{
  public static Intent a(Context paramContext, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    ComponentName localComponentName = new ComponentName("com.gau.go.launcherex.gowidget.weatherwidget", "com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity");
    Intent localIntent = new Intent();
    localIntent.setComponent(localComponentName);
    localIntent.putExtra("cityId", paramString1);
    localIntent.putExtra("EXTRA_BG_LOADING_IMMEDIATELY_", paramBoolean);
    localIntent.putExtra("detailSrc", paramInt1);
    localIntent.putExtra("extra_src_app_package_name", paramString2);
    localIntent.putExtra("detail_goto", paramInt2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    return localIntent;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */