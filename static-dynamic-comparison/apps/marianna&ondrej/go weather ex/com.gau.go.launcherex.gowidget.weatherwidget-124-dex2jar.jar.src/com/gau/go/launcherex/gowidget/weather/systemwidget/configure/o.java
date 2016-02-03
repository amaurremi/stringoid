package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.a.a.an;
import com.a.a.au;

class o
  implements au
{
  o(i parami, View paramView, d paramd) {}
  
  public void a(an paraman)
  {
    int i = ((Integer)paraman.l()).intValue();
    paraman = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paraman.width = i;
    if (this.b.f < i.b(this.c).b.getChildCount() - 1) {
      paraman.setMargins(0, 0, i * i.b(this.c).e / i.b(this.c).c, 0);
    }
    for (;;)
    {
      this.a.setLayoutParams(paraman);
      return;
      paraman.setMargins(0, 0, 0, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */