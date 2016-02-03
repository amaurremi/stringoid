package com.go.weatherex.setting;

import android.widget.CheckBox;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.c;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bg
  implements c
{
  bg(bb parambb) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      bb.e(this.a).setChecked(true);
      this.a.c = 1;
      bb.a(this.a).p(this.a.c);
      bb.a(this.a).a(WeatherContentProvider.g, "setting_key", "weather_warning_switch", "setting_value", this.a.c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */