package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gtp.go.weather.sharephoto.award.k;
import com.gtp.go.weather.sharephoto.award.o;

class t
  extends o
{
  t(s params, e parame, k paramk) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (this.a.x().equals(paramString))
    {
      if (paramInt != 1) {
        break label84;
      }
      if (!paramBoolean) {
        break label70;
      }
      this.a.d(true);
      a.a(this.a.x(), true, this.c.a);
      s.a(this.c, this.a);
    }
    for (;;)
    {
      this.b.a();
      return;
      label70:
      s.b(this.c, this.a);
      continue;
      label84:
      Toast.makeText(this.c.a, this.c.a.getString(2131166398), 0).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */