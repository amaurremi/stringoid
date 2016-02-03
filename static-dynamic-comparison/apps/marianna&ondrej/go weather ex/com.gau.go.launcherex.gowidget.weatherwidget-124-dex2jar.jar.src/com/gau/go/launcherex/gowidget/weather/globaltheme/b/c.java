package com.gau.go.launcherex.gowidget.weather.globaltheme.b;

import java.util.Comparator;

public class c
  implements Comparator
{
  public int a(a parama1, a parama2)
  {
    long l = parama1.c() - parama2.c();
    if (l == 0L) {
      return 0;
    }
    if (l > 0L) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */