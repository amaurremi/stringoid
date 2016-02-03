package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bd
  implements w
{
  bd(bb parambb, q paramq, String[] paramArrayOfString) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    int j;
    int i;
    if ((paramBoolean) && (parama != null))
    {
      j = ((Integer)parama.c).intValue();
      i = 0;
      if (this.a.g != 2) {
        break label127;
      }
      i = bb.a(this.c, j);
    }
    for (;;)
    {
      if (this.c.f != i)
      {
        this.c.f = i;
        bb.a(this.c).s(this.c.f);
        bb.a(this.c).a(WeatherContentProvider.g, "setting_key", "temp_change_high", "setting_value", this.c.f);
        bb.c(this.c).setText(this.b[j]);
      }
      return;
      label127:
      if (this.a.g == 1) {
        i = bb.b(this.c, j);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */