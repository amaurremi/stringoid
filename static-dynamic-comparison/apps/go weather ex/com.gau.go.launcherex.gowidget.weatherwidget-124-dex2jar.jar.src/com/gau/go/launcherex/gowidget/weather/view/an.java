package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class an
  implements w
{
  an(Setting21Activity paramSetting21Activity, CharSequence[] paramArrayOfCharSequence) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      this.b.d = (i + 1);
      Setting21Activity.a(this.b).setText(this.a[i]);
      Setting21Activity.b(this.b).a(WeatherContentProvider.g, "setting_key", "tempUnit", "setting_value", this.b.d);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */