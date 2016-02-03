package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class au
  implements w
{
  au(Setting42Activity paramSetting42Activity, CharSequence[] paramArrayOfCharSequence) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      this.b.c = (i + 1);
      Setting42Activity.a(this.b).setText(this.a[i]);
      Setting42Activity.b(this.b).a(WeatherContentProvider.g, "setting_key", "tempUnit", "setting_value", this.b.c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */