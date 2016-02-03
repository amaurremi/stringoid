package com.gau.go.launcherex.gowidget.weather.globaltheme.a;

import android.content.Context;
import com.android.a.aa;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gtp.a.a.b.c;
import com.jiubang.playsdk.a.k;

final class f
  implements k
{
  f(Context paramContext) {}
  
  public void a(aa paramaa)
  {
    c.a("WidgetStarManager", "queryForHasNewState->onErrorResponse->thread id: " + Thread.currentThread().getId());
    c.a("WidgetStarManager", "queryForHasNewState->onErrorResponse: " + paramaa.getMessage());
  }
  
  public void a(Boolean paramBoolean)
  {
    c.a("WidgetStarManager", "queryForHasNewState->onDataListner->thread id: " + Thread.currentThread().getId());
    c.a("WidgetStarManager", "queryForHasNewState->onDataListner: " + paramBoolean);
    if (paramBoolean.booleanValue())
    {
      d.a(this.a, true);
      r.a(this.a).a(new a(93, "news001"));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */