package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gtp.go.weather.sharephoto.award.k;
import com.gtp.go.weather.sharephoto.award.o;

class n
  extends o
{
  n(m paramm, e parame, k paramk) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (this.a.x().equals(paramString))
    {
      if (paramInt != 1) {
        break label91;
      }
      if (!paramBoolean) {
        break label77;
      }
      this.a.d(true);
      a.a(this.a.x(), true, this.c.a);
      m.a(this.c, this.a);
    }
    for (;;)
    {
      m.a(this.c);
      this.b.a();
      return;
      label77:
      m.b(this.c, this.a);
      continue;
      label91:
      Toast.makeText(this.c.a, this.c.a.getString(2131166398), 0).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */