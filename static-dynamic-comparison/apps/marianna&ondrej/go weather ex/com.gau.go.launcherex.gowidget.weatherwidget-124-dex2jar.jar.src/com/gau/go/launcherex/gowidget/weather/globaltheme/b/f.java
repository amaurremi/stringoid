package com.gau.go.launcherex.gowidget.weather.globaltheme.b;

import java.util.Comparator;

public class f
  implements Comparator
{
  public int a(e parame1, e parame2)
  {
    long l = parame1.b() - parame2.b();
    if (l == 0L) {
      return 0;
    }
    if (l > 0L) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */