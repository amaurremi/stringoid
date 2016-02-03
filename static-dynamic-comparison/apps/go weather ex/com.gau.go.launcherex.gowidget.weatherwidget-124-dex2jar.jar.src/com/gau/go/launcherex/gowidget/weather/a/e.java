package com.gau.go.launcherex.gowidget.weather.a;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.a.a.a;
import com.gau.go.launcherex.gowidget.weather.provider.b;
import com.jiubang.goweather.c.r;
import java.util.ArrayList;
import java.util.List;

class e
  extends AsyncTask
{
  private e(c paramc) {}
  
  protected List a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (c.a(this.a)) {
      return r.a(this.a.a, paramVarArgs, 2131099678);
    }
    return b.a(this.a.a, paramVarArgs);
  }
  
  protected void a(List paramList)
  {
    String str = this.a.b;
    this.a.b = null;
    if (isCancelled()) {
      return;
    }
    a locala = new a();
    locala.c = str;
    locala.a.addAll(paramList);
    locala.b = 1;
    this.a.a(locala);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */