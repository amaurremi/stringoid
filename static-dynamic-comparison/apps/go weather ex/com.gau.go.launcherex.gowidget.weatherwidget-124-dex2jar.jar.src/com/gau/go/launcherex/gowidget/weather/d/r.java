package com.gau.go.launcherex.gowidget.weather.d;

import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;

public class r
{
  public static String a(Context paramContext)
  {
    paramContext = y.d(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      throw new Exception("获取不到设备IMEI");
    }
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */