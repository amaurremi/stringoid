package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.TextView;

class c
  implements Runnable
{
  c(AdvancedDayAniView paramAdvancedDayAniView) {}
  
  public void run()
  {
    this.a.a(AdvancedDayAniView.a(this.a), AdvancedDayAniView.i(this.a));
    AdvancedDayAniView.c(this.a).setText(String.valueOf(25));
    this.a.a(AdvancedDayAniView.c(this.a), AdvancedDayAniView.d(this.a));
    AdvancedDayAniView.e(this.a).b();
    AdvancedDayAniView.f(this.a).b();
    this.a.a(AdvancedDayAniView.g(this.a), AdvancedDayAniView.j(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */