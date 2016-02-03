package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bj
  implements w
{
  bj(bb parambb, int[] paramArrayOfInt, CharSequence[] paramArrayOfCharSequence) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      int i = ((Integer)parama.c).intValue();
      this.c.j = this.a[i];
      bb.i(this.c).setText(this.b[i]);
      bb.h(this.c);
      bb.a(this.c).a(WeatherContentProvider.g, "setting_key", "notify_type", "setting_value", this.c.j);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */