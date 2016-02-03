package com.gtp.go.weather.billing.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

class h
  implements DialogInterface.OnClickListener
{
  h(PayActivity paramPayActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(PayActivity.a(this.b, "http://market.android.com/support/bin/answer.py?answer=1050566&hl=%lang%&dl=%region%")));
    paramDialogInterface.addFlags(268435456);
    this.b.startActivity(paramDialogInterface);
    if (this.a) {
      this.b.finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */