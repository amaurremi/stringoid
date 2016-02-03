package com.gtp.go.weather.billing.a;

import com.getjar.sdk.GetjarLicense;
import com.gtp.go.weather.billing.view.PayActivity;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class f
  implements com.gau.go.launcherex.gowidget.a.j
{
  f(a parama) {}
  
  public void a(int paramInt, List paramList)
  {
    if ((!a.a(this.a)) || (paramInt != 0) || (paramList == null)) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    label29:
    if (localIterator.hasNext()) {
      paramList = (GetjarLicense)localIterator.next();
    }
    for (;;)
    {
      try
      {
        paramList = new JSONObject(paramList.getSignedLicenseData());
        bool2 = a.b(this.a, paramList);
        bool1 = bool2;
        bool2 = bool1;
        if (!bool1) {}
      }
      catch (JSONException paramList)
      {
        try
        {
          a.d(this.a);
          a.h(this.a);
          if ((bool1) || (a.i(this.a))) {
            break;
          }
          a.a(this.a, null, a.c(this.a).getString(2131166057));
          new j(this.a).execute(new Void[0]);
          return;
        }
        catch (JSONException paramList)
        {
          boolean bool2;
          continue;
        }
        paramList = paramList;
        paramList.printStackTrace();
        bool2 = bool1;
        bool1 = bool2;
      }
      break label29;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */