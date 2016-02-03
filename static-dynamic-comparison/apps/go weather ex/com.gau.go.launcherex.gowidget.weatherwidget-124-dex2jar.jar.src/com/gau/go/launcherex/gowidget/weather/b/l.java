package com.gau.go.launcherex.gowidget.weather.b;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;

class l
  extends AsyncTask
{
  private l(g paramg) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    g.i(this.a);
    return Boolean.valueOf(g.j(this.a));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      g.b(this.a, g.f(this.a));
    }
    g.a(this.a, false);
    g.a(this.a, null);
    if (g.c(this.a) != null)
    {
      g.c(this.a).b();
      g.c(this.a).c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */