package com.gau.go.launcherex.gowidget.billing;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.a.m;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.util.Map;

class l
  extends AsyncTask
{
  l(BillingActivity paramBillingActivity) {}
  
  protected Void a(Void... paramVarArgs)
  {
    if (BillingActivity.s(this.a) == null) {
      BillingActivity.a(this.a, m.a(this.a, 2131034121));
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    int i = 75;
    try
    {
      if (BillingActivity.t(this.a).getInt("key_getjar_pricetouse", -1) == -1)
      {
        paramVoid = y.n(this.a);
        if ((BillingActivity.s(this.a) != null) && (BillingActivity.s(this.a).containsKey(paramVoid))) {
          i = ((Integer)BillingActivity.s(this.a).get(paramVoid)).intValue();
        }
        for (;;)
        {
          BillingActivity.d(this.a);
          BillingActivity.a(this.a, BillingActivity.t(this.a).getInt("key_getjar_solid_price", i));
          if (BillingActivity.u(this.a) == 0) {
            BillingActivity.a(this.a, 75);
          }
          BillingActivity.b(this.a, BillingActivity.u(this.a));
          BillingActivity.d(this.a, false);
          return;
          if (BillingActivity.s(this.a) != null) {
            i = ((Integer)BillingActivity.s(this.a).get("others")).intValue();
          }
        }
      }
    }
    catch (Exception paramVoid)
    {
      for (;;)
      {
        paramVoid.printStackTrace();
        continue;
        i = 0;
      }
    }
  }
  
  protected void onPreExecute()
  {
    BillingActivity.d(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */