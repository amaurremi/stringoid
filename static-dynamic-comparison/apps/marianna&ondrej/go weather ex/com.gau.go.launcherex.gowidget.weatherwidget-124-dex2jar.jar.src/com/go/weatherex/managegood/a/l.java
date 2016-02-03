package com.go.weatherex.managegood.a;

import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.a.f;
import com.getjar.sdk.GetjarClient;
import com.gtp.a.a.b.c;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

class l
  implements Runnable
{
  l(a parama) {}
  
  public void run()
  {
    while (!a.m(this.a).isEmpty())
    {
      Object localObject = ((f)a.m(this.a).remove()).a();
      String str = ((Intent)localObject).getStringExtra("getjar.intent.type");
      if ((!TextUtils.isEmpty(str)) && ("redeem_voucher".equals(str)))
      {
        localObject = ((Intent)localObject).getStringExtra("getjar.voucher_token");
        a.j(this.a).redeemVoucher((String)localObject, "A custom string typically used to identify your user and/or transaction", a.n(this.a));
        c.a("ManageGoodGetjarHelper", String.format(Locale.US, "GetjarClient.redeemVoucher() called [%1$s]", new Object[] { localObject }));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */