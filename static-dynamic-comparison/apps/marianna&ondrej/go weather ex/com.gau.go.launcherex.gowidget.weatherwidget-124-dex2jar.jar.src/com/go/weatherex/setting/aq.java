package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;

class aq
  implements w
{
  aq(an paraman) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      paramt = (at)parama.c;
      an.b(this.a).f = paramt.c;
      an.d(this.a).setText(paramt.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */