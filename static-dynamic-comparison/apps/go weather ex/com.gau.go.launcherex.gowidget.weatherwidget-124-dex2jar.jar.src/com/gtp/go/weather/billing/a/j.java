package com.gtp.go.weather.billing.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.a.m;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.billing.view.PayActivity;
import java.util.Map;

class j
  extends AsyncTask
{
  private volatile Map b;
  
  j(a parama) {}
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = a.c(this.a).createPackageContext(a.j(this.a), 2);
      if (paramVarArgs != null)
      {
        i = paramVarArgs.getResources().getIdentifier("getjar_solid_prices", "raw", a.j(this.a));
        if ((i != -1) && (i != 0)) {
          this.b = m.b(paramVarArgs, i);
        }
      }
      else
      {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramVarArgs)
    {
      int i;
      do
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
          paramVarArgs = null;
        }
        i = paramVarArgs.getResources().getIdentifier("getjar_solid_prices", "xml", a.j(this.a));
      } while ((i == -1) || (i == 0));
      this.b = m.a(paramVarArgs, i);
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    for (;;)
    {
      try
      {
        paramVoid = y.n(a.c(this.a));
        if (this.b != null)
        {
          if (!this.b.containsKey(paramVoid)) {
            continue;
          }
          a.a(this.a, ((Integer)this.b.get(paramVoid)).intValue());
        }
        if (a.k(this.a) == 0) {
          a.a(this.a, 75);
        }
        a.b(this.a, a.k(this.a));
        paramVoid = this.a;
      }
      catch (Exception paramVoid)
      {
        paramVoid.printStackTrace();
        paramVoid = this.a;
        continue;
      }
      finally
      {
        a.d(this.a);
      }
      a.d(paramVoid);
      a.a(this.a, false);
      return;
      a.a(this.a, ((Integer)this.b.get("others")).intValue());
    }
  }
  
  protected void onPreExecute()
  {
    a.a(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */