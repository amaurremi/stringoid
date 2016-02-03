package com.gtp.go.weather.billing.a;

import com.gau.go.launcherex.gowidget.a.k;
import com.getjar.sdk.GetjarVoucherRedeemedResult;
import com.gtp.go.weather.billing.view.PayActivity;

class d
  implements k
{
  d(a parama) {}
  
  public void a(int paramInt, GetjarVoucherRedeemedResult paramGetjarVoucherRedeemedResult)
  {
    if (!a.a(this.a)) {
      return;
    }
    a.c(this.a).runOnUiThread(new e(this, paramInt, paramGetjarVoucherRedeemedResult));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */