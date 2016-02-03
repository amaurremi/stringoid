package com.gau.go.launcherex.gowidget.billing;

import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

class k
  implements Runnable
{
  k(j paramj, int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult) {}
  
  public void run()
  {
    try
    {
      if (this.a != 0) {
        return;
      }
      JSONObject localJSONObject = new JSONObject(this.b.getSignedTransactionData());
      String str = localJSONObject.getString("voucher_token");
      if (!BillingActivity.q(this.c.a).contains(str))
      {
        BillingActivity.a(this.c.a, localJSONObject);
        BillingActivity.q(this.c.a).add(str);
        BillingActivity.r(this.c.a).confirmVoucher(str);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */