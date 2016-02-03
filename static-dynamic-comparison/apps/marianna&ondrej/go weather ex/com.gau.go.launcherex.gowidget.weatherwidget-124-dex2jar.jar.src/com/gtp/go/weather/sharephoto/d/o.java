package com.gtp.go.weather.sharephoto.d;

import com.gtp.go.weather.sharephoto.b.g;
import java.util.Comparator;

final class o
  implements Comparator
{
  public int a(g paramg1, g paramg2)
  {
    if ((paramg1.g() == 2) && (paramg2.g() == 2)) {}
    do
    {
      return 0;
      if (paramg1.g() < paramg2.g()) {
        return 1;
      }
      if (paramg1.g() > paramg2.g()) {
        return -1;
      }
      if (paramg1.j() < paramg2.j()) {
        return 1;
      }
    } while (paramg1.j() <= paramg2.j());
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */