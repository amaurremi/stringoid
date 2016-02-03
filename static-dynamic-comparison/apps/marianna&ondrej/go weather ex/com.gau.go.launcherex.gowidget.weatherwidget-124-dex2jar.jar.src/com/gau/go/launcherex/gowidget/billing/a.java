package com.gau.go.launcherex.gowidget.billing;

import android.os.Handler;
import android.os.Message;

class a
  extends Handler
{
  a(BillingActivity paramBillingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      BillingActivity.a(this.a, null, this.a.getString(2131166055));
      this.a.b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */