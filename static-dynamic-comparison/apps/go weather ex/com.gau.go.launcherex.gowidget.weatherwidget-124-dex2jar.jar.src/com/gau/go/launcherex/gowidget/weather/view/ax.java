package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class ax
  implements w
{
  ax(Setting42Activity paramSetting42Activity, int paramInt) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      if (this.a != i)
      {
        Setting42Activity.c(this.b, Setting42Activity.h(this.b)[i]);
        Setting42Activity.j(this.b).setText(Setting42Activity.i(this.b)[i]);
        Setting42Activity.b(this.b).j(Setting42Activity.k(this.b));
        Setting42Activity.b(this.b).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", Setting42Activity.k(this.b));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */