package com.go.weatherex.setting;

import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.globalview.w;
import com.gau.go.launcherex.gowidget.weather.model.r;

class bh
  implements w
{
  bh(bb parambb) {}
  
  public void a(t paramt, boolean paramBoolean, a parama)
  {
    if ((paramBoolean) && (parama != null))
    {
      paramt = (r)parama.c;
      this.a.h = paramt.a;
      bb.f(this.a).setText(paramt.b);
      this.a.i = paramt.c;
      bb.a(this.a).a(this.a.h, this.a.i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */