package com.gau.go.launcherex.gowidget.weather.service;

import com.gau.go.launcherex.gowidget.weather.b.x;
import com.gau.go.launcherex.gowidget.weather.util.r;

class i
  implements Runnable
{
  i(NotifyService paramNotifyService) {}
  
  public void run()
  {
    if (r.c(this.a.getApplicationContext())) {
      x.a(this.a.getApplicationContext()).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */