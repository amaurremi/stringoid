package com.gau.go.launcherex.gowidget.billing;

import android.app.Dialog;

class g
  implements Runnable
{
  g(BillingActivity paramBillingActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      BillingActivity.m(this.a).dismiss();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */