package com.gau.go.launcherex.gowidget.a;

import android.content.Intent;
import android.text.TextUtils;
import com.getjar.sdk.GetjarClient;
import java.util.concurrent.ConcurrentLinkedQueue;

class h
  implements Runnable
{
  h(g paramg) {}
  
  public void run()
  {
    while (!g.a(this.a).isEmpty())
    {
      Object localObject = ((f)g.a(this.a).remove()).a();
      String str = ((Intent)localObject).getStringExtra("getjar.intent.type");
      if (!TextUtils.isEmpty(str)) {
        if ("redeem_voucher".equals(str))
        {
          localObject = ((Intent)localObject).getStringExtra("getjar.voucher_token");
          g.b(this.a).redeemVoucher((String)localObject, "A custom string typically used to identify your user and/or transaction", this.a);
        }
        else if ("update_license".equals(str))
        {
          this.a.removeMessages(0);
          this.a.sendEmptyMessageDelayed(0, 200L);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */