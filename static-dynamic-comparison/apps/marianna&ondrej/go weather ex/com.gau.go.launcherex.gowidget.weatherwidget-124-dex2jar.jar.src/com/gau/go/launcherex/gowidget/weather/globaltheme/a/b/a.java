package com.gau.go.launcherex.gowidget.weather.globaltheme.a.b;

import android.text.TextUtils;

public class a
{
  public static final String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("#")) && (paramInt >= 0) && (paramInt < 6))
    {
      paramString = paramString.split("#");
      if (paramString.length >= 6) {
        return paramString[paramInt];
      }
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */