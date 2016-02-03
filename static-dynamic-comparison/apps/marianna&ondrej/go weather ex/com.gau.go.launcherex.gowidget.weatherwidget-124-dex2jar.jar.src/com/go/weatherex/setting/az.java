package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class az
  implements w
{
  az(ay paramay) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      this.a.a = ay.a(this.a)[i];
      ay.c(this.a).setText(ay.b(this.a)[i]);
      ay.d(this.a).a(WeatherContentProvider.g, "setting_key", "autpUpdateFreq", "setting_value", this.a.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */