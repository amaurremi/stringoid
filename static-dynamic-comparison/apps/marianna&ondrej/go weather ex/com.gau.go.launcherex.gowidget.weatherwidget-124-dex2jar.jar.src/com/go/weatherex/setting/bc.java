package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class bc
  implements w
{
  bc(bb parambb, q paramq, String[] paramArrayOfString) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    int j;
    if ((paramBoolean) && (parama != null))
    {
      j = ((Integer)parama.c).intValue();
      if (this.a.g != 2) {
        break label124;
      }
    }
    label124:
    for (int i = bb.a(this.c, j);; i = bb.b(this.c, j))
    {
      if (this.c.e != i)
      {
        this.c.e = i;
        bb.a(this.c).r(this.c.e);
        bb.a(this.c).a(WeatherContentProvider.g, "setting_key", "temp_change_low", "setting_value", this.c.e);
        bb.b(this.c).setText(this.b[j]);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */