package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bn
  implements w
{
  bn(bm parambm, int paramInt) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      if (this.a != i)
      {
        bm.a(this.b, bm.a(this.b)[i]);
        bm.c(this.b).setText(bm.b(this.b)[i]);
        bm.e(this.b).a(WeatherContentProvider.g, "setting_key", "festival", "setting_value", bm.d(this.b));
        bm.e(this.b).j(bm.d(this.b));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */