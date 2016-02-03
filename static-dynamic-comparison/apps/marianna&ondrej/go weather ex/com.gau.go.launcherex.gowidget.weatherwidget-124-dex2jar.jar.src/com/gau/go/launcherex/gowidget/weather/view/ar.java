package com.gau.go.launcherex.gowidget.weather.view;

import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class ar
  implements w
{
  ar(Setting41Activity paramSetting41Activity) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      Setting41Activity.a(this.a, i);
      Setting41Activity.b(this.a, Setting41Activity.c(this.a));
      Setting41Activity.b(this.a).a(WeatherContentProvider.g, "setting_key", "dateStyle", "setting_value", Setting41Activity.d(this.a)[Setting41Activity.c(this.a)]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */