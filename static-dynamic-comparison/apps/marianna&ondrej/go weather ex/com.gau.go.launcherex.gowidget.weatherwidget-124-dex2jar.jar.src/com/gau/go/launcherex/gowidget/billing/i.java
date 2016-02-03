package com.gau.go.launcherex.gowidget.billing;

import com.gau.go.launcherex.gowidget.a.g;
import com.getjar.sdk.GetjarConnectionResult;

class i
  implements com.gau.go.launcherex.gowidget.a.i
{
  i(BillingActivity paramBillingActivity) {}
  
  public void a()
  {
    if (!BillingActivity.o(this.a)) {
      return;
    }
    BillingActivity.a(this.a, null, this.a.getString(2131166054));
    BillingActivity.n(this.a).b();
    BillingActivity.n(this.a).a();
  }
  
  public void a(GetjarConnectionResult paramGetjarConnectionResult)
  {
    if (!BillingActivity.o(this.a)) {}
    while ((paramGetjarConnectionResult.getErrorCode() != 6) || (!paramGetjarConnectionResult.hasResolution())) {
      return;
    }
    BillingActivity.d(this.a);
    BillingActivity.a(this.a, paramGetjarConnectionResult.getResolutionIntent());
    this.a.startActivityForResult(BillingActivity.p(this.a), 909);
    BillingActivity.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */