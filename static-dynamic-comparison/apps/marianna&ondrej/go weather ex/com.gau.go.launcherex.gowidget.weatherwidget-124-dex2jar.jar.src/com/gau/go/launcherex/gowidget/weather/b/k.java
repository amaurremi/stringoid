package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import java.util.ArrayList;

class k
  extends AsyncTask
{
  private k(g paramg) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = new ArrayList();
    g.a(this.a, paramVarArgs);
    return Boolean.valueOf(g.b(this.a, paramVarArgs));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if (g.g(this.a)) {
        g.a(this.a, g.f(this.a));
      }
      g.h(this.a);
      new l(this.a, null).execute(new Void[0]);
    }
    do
    {
      return;
      if (g.g(this.a))
      {
        paramBoolean = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_WIDGET_NO_DATA");
        g.e(this.a).sendBroadcast(paramBoolean);
      }
      g.a(this.a, false);
      g.a(this.a, null);
    } while (g.c(this.a) == null);
    g.c(this.a).b();
    g.c(this.a).c();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    g.f(this.a).clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */