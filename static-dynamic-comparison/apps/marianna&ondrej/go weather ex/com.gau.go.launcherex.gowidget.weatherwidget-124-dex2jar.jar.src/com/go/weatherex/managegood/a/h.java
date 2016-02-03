package com.go.weatherex.managegood.a;

import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import com.gtp.a.a.b.c;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

class h
  implements Runnable
{
  h(g paramg, int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult) {}
  
  public void run()
  {
    try
    {
      if (this.a == 0)
      {
        String str1 = this.b.getSignedTransactionData();
        c.a("ManageGoodGetjarHelper", "signedTransactionData: " + str1);
        str1 = new JSONObject(str1).getString("voucher_token");
        if (a.i(this.c.a).contains(str1))
        {
          str1 = String.format(Locale.US, "Voucher previously redeemed [%1$s]", new Object[] { str1 });
          c.a("ManageGoodGetjarHelper", String.format(Locale.US, "onVoucherRedeemed() %1$s", new Object[] { str1 }));
          return;
        }
        String str3 = String.format("purchased", new Object[0]);
        c.a("ManageGoodGetjarHelper", String.format(Locale.US, "onVoucherRedeemed() %1$s", new Object[] { str3 }));
        a.i(this.c.a).add(str1);
        a.j(this.c.a).confirmVoucher(str1);
        a.h(this.c.a);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (this.a == 3) {}
    for (String str2 = "Voucher Already Redeemed";; str2 = String.format(Locale.US, "Redeem failed (statusCode:%1$d)", new Object[] { Integer.valueOf(this.a) }))
    {
      c.a("ManageGoodGetjarHelper", String.format(Locale.US, "onVoucherRedeemed() %1$s", new Object[] { str2 }));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */