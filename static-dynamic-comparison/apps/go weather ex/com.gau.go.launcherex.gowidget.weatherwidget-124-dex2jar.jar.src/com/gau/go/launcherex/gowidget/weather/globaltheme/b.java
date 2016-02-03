package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.gau.go.launcherex.gowidget.statistics.y;

public abstract class b
{
  public static String a(Context paramContext)
  {
    int j = 1;
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append("2#");
    localStringBuffer.append("android#");
    localStringBuffer.append(Build.MODEL + "#");
    localStringBuffer.append(y.d(paramContext) + "#");
    localStringBuffer.append(y.f(paramContext) + "#");
    localStringBuffer.append(y.q(paramContext) + "#");
    localStringBuffer.append(y.c(paramContext) + "#");
    localStringBuffer.append(Build.VERSION.SDK_INT + "#");
    localStringBuffer.append(y.r(paramContext) + "#");
    if (y.s(paramContext))
    {
      i = 1;
      localStringBuffer.append(i + "#");
      if (!y.a()) {
        break label404;
      }
    }
    label404:
    for (int i = j;; i = 0)
    {
      localStringBuffer.append(i + "#");
      localStringBuffer.append(y.k(paramContext) + "#");
      localStringBuffer.append(y.n(paramContext) + "#");
      localStringBuffer.append(y.u(paramContext) + "#");
      localStringBuffer.append(y.b() + "#");
      localStringBuffer.append(y.e(paramContext));
      return localStringBuffer.toString();
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */