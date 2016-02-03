package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import java.util.ArrayList;

class r
  extends AsyncTask
{
  private r(o paramo) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = new ArrayList();
    o.a(this.a, paramVarArgs);
    return Boolean.valueOf(o.b(this.a, paramVarArgs));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if (o.g(this.a)) {
        o.a(this.a, o.f(this.a));
      }
      o.h(this.a);
      new t(this.a, null).execute(new Void[0]);
    }
    do
    {
      return;
      if (o.g(this.a))
      {
        paramBoolean = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GO_WIDGET_NO_DATA");
        o.e(this.a).sendBroadcast(paramBoolean);
      }
      o.a(this.a, false);
      o.a(this.a, null);
    } while (o.c(this.a) == null);
    o.c(this.a).b();
    o.c(this.a).c();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    o.f(this.a).clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */