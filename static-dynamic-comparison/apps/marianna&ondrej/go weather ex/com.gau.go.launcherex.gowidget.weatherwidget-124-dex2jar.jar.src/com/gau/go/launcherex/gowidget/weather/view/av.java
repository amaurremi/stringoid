package com.gau.go.launcherex.gowidget.weather.view;

import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class av
  implements w
{
  av(Setting42Activity paramSetting42Activity) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      Setting42Activity.a(this.a, i);
      Setting42Activity.b(this.a, Setting42Activity.c(this.a));
      Setting42Activity.b(this.a).a(WeatherContentProvider.g, "setting_key", "dateStyle", "setting_value", Setting42Activity.d(this.a)[Setting42Activity.c(this.a)]);
      paramt.dismiss();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */