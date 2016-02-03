package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.g;

class f
  extends AsyncTask
{
  private f(d paramd) {}
  
  protected g a(Integer... paramVarArgs)
  {
    switch (paramVarArgs[0].intValue())
    {
    default: 
      return null;
    case 1: 
      return d.a(this.a);
    case 0: 
      return d.b(this.a);
    }
    return d.c(this.a);
  }
  
  protected void a(g paramg)
  {
    d.a(this.a, paramg);
    switch (paramg.a())
    {
    default: 
      return;
    case 0: 
      d.a(this.a, false);
      return;
    case 2: 
      d.b(this.a, false);
      return;
    }
    d.c(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */