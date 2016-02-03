package com.gau.go.launcherex.gowidget.weather.view;

import com.gau.go.launcherex.gowidget.weather.b.x;
import com.gau.go.launcherex.gowidget.weather.globalview.c;
import com.gau.go.launcherex.gowidget.weather.model.h;

class y
  implements c
{
  y(LanguageSetting paramLanguageSetting, h paramh) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      LanguageSetting.a(this.b, this.a.b(), this.a.d());
      x.b(this.b.getApplicationContext());
      this.b.finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */