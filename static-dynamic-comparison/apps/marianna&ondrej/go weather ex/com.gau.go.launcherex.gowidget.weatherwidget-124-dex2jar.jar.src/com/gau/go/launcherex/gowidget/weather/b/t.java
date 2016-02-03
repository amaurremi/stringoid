package com.gau.go.launcherex.gowidget.weather.b;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;

class t
  extends AsyncTask
{
  private t(o paramo) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    o.i(this.a);
    return Boolean.valueOf(o.j(this.a));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      o.b(this.a, o.f(this.a));
    }
    o.a(this.a, false);
    o.a(this.a, null);
    if (o.c(this.a) != null)
    {
      o.c(this.a).b();
      o.c(this.a).c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */