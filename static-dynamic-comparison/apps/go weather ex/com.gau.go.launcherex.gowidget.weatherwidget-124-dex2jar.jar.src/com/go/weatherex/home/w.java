package com.go.weatherex.home;

import android.app.Activity;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.globalview.h;

class w
  implements h
{
  w(s params) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s.a(this.a, s.c(this.a).getPackageName());
      r.a(s.c(this.a).getApplicationContext()).a(new a(109, "score"));
      return;
    }
    r.a(s.c(this.a).getApplicationContext()).a(new a(109, "cancel"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */