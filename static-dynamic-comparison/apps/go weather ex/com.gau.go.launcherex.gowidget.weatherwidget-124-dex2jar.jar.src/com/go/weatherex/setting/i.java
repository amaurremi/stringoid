package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class i
  implements w
{
  i(h paramh, int paramInt) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      if (this.a != i)
      {
        h.a(this.b, h.a(this.b)[i]);
        h.c(this.b).setText(h.b(this.b)[i]);
        h.e(this.b).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", h.d(this.b));
        h.e(this.b).j(h.d(this.b));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */