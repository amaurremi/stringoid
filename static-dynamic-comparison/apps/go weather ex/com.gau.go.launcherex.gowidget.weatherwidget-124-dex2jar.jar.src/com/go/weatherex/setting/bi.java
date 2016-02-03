package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bi
  implements w
{
  bi(bb parambb, CharSequence[] paramArrayOfCharSequence) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      bb.c(this.b, i);
      bb.g(this.b).setText(this.a[i]);
      bb.h(this.b);
      bb.a(this.b).a(WeatherContentProvider.g, "setting_key", "notification_style", "setting_value", bb.c()[i]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */