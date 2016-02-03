package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.service.ThemeService;
import java.util.ArrayList;

class d
  extends AsyncTask
{
  private d(a parama) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = new ArrayList();
    a.a(this.a, paramVarArgs);
    return Boolean.valueOf(a.b(this.a, paramVarArgs));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if (a.g(this.a)) {
        a.a(this.a, a.f(this.a));
      }
      a.h(this.a);
      new e(this.a, null).execute(new Void[0]);
    }
    do
    {
      return;
      if (a.g(this.a))
      {
        paramBoolean = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_NO_DATA");
        a.e(this.a).sendBroadcast(paramBoolean);
      }
      a.a(this.a, false);
      a.a(this.a, null);
    } while (a.c(this.a) == null);
    a.c(this.a).b();
    a.c(this.a).c();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a.f(this.a).clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */