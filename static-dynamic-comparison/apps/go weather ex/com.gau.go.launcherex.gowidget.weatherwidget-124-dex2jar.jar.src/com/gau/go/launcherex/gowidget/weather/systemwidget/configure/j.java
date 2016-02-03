package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.a.a.an;
import com.a.a.au;

class j
  implements au
{
  j(i parami, View paramView, h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(an paraman)
  {
    int i = ((Integer)paraman.l()).intValue();
    paraman = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paraman.width = i;
    if (this.b.g < i.a(this.g).b.getChildCount() - 1) {
      paraman.setMargins(0, 0, i.a(this.g).e * i / i.a(this.g).c, 0);
    }
    for (;;)
    {
      this.a.setLayoutParams(paraman);
      int j;
      if (this.c != 0)
      {
        j = this.d;
        int k = this.c * i / i.a(this.g).c;
        i.a(this.g).a.scrollTo(j + k, i.a(this.g).a.getScrollY());
      }
      if (this.e != 0)
      {
        j = this.f;
        i = i * this.e / i.b(this.g).c;
        i.b(this.g).a.scrollTo(j + i, i.b(this.g).a.getScrollY());
      }
      return;
      paraman.setMargins(0, 0, 0, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */