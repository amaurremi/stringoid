package com.gtp.go.weather.sharephoto.view;

import com.gtp.go.weather.sharephoto.b.h;
import java.util.Comparator;

class i
  implements Comparator
{
  i(g paramg) {}
  
  public int a(h paramh1, h paramh2)
  {
    if (paramh1.e()) {
      return -1;
    }
    if (paramh2.e()) {
      return 1;
    }
    return -paramh1.a().compareTo(paramh2.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */