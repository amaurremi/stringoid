package com.gau.go.launcherex.gowidget.weather.b;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;

class e
  extends AsyncTask
{
  private e(a parama) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    a.i(this.a);
    return Boolean.valueOf(a.j(this.a));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      a.b(this.a, a.f(this.a));
    }
    a.a(this.a, false);
    a.a(this.a, null);
    if (a.c(this.a) != null)
    {
      a.c(this.a).b();
      a.c(this.a).c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */