package com.gau.go.launcherex.gowidget.billing;

import com.gau.go.launcherex.gowidget.a.j;
import com.gau.go.launcherex.gowidget.statistics.o;
import com.gau.go.launcherex.gowidget.statistics.p;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.getjar.sdk.GetjarLicense;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class b
  implements j
{
  b(BillingActivity paramBillingActivity) {}
  
  public void a(int paramInt, List paramList)
  {
    if (!BillingActivity.o(this.a)) {}
    label162:
    label168:
    do
    {
      for (;;)
      {
        return;
        BillingActivity.c(this.a, false);
        int i;
        if ((paramInt == 0) && (paramList != null))
        {
          Iterator localIterator = paramList.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label168;
          }
          paramList = (GetjarLicense)localIterator.next();
        }
        try
        {
          paramList = new JSONObject(paramList.getSignedLicenseData());
          bool = BillingActivity.b(this.a, paramList);
          if (!bool) {
            break label162;
          }
          try
          {
            if (BillingActivity.e(this.a).a("goweatherex_getjar_id", true))
            {
              BillingActivity.e(this.a).b("goweatherex_getjar_id");
              BillingActivity.h(this.a).a(new o(BillingActivity.g(this.a), 0, 0, 1, 0, 1));
              BillingActivity.d(this.a);
              return;
            }
          }
          catch (JSONException paramList)
          {
            i = bool;
          }
        }
        catch (JSONException paramList)
        {
          boolean bool;
          for (;;) {}
        }
      }
      paramList.printStackTrace();
      for (;;)
      {
        break;
        i = bool;
      }
    } while (i != 0);
    BillingActivity.a(this.a, null, this.a.getString(2131166057));
    new l(this.a).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */