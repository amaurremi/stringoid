package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class as
  implements w
{
  as(Setting41Activity paramSetting41Activity, int paramInt) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      if (this.a != i)
      {
        this.b.b = Setting41Activity.e(this.b)[i];
        Setting41Activity.g(this.b).setText(Setting41Activity.f(this.b)[i]);
        Setting41Activity.b(this.b).a(WeatherContentProvider.g, "setting_key", "autpUpdateFreq", "setting_value", this.b.b);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */