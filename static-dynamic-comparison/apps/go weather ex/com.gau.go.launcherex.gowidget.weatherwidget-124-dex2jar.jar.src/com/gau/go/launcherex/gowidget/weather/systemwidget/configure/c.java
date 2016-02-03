package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.weather.globaltheme.i;

class c
  implements View.OnClickListener
{
  c(b paramb, d paramd, com.gau.go.launcherex.gowidget.weather.globaltheme.b.d paramd1, int paramInt) {}
  
  public void onClick(View paramView)
  {
    i locali;
    int i;
    String str;
    if (paramView.equals(this.a.a))
    {
      boolean bool = com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(a.e(this.d.a), this.b);
      locali = i.a(a.e(this.d.a));
      i = this.b.u();
      str = this.b.x();
      if (!bool) {
        break label90;
      }
    }
    label90:
    for (paramView = "1";; paramView = "0")
    {
      locali.a(i, str, "a000", paramView, null, "31", this.c);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */