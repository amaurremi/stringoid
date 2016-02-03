package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class af
  implements w
{
  af(MainWidgetSetting paramMainWidgetSetting, int paramInt) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      if (this.a != i)
      {
        MainWidgetSetting.a(this.b, MainWidgetSetting.a(this.b)[i]);
        MainWidgetSetting.c(this.b).setText(MainWidgetSetting.b(this.b)[i]);
        MainWidgetSetting.e(this.b).j(MainWidgetSetting.d(this.b));
        MainWidgetSetting.e(this.b).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", MainWidgetSetting.d(this.b));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */