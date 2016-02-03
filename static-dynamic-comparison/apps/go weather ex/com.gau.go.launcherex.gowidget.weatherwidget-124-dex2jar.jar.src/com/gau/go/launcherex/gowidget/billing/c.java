package com.gau.go.launcherex.gowidget.billing;

import com.gau.go.launcherex.gowidget.weather.scroller.AnimViewScrollGroup;

class c
  implements Runnable
{
  c(BillingActivity paramBillingActivity) {}
  
  public void run()
  {
    int i = BillingActivity.a(this.a).getChildCount();
    int j = BillingActivity.b(this.a);
    BillingActivity.a(this.a).a((j + 1) % i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */