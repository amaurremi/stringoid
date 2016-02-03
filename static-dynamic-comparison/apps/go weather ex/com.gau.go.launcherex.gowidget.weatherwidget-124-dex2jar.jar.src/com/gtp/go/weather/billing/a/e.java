package com.gtp.go.weather.billing.a;

import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

class e
  implements Runnable
{
  e(d paramd, int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult) {}
  
  public void run()
  {
    try
    {
      if (this.a == 0)
      {
        JSONObject localJSONObject = new JSONObject(this.b.getSignedTransactionData());
        String str = localJSONObject.getString("voucher_token");
        if (!a.f(this.c.a).contains(str))
        {
          a.a(this.c.a, localJSONObject);
          a.f(this.c.a).add(str);
          a.g(this.c.a).confirmVoucher(str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */