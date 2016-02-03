package com.gau.go.launcherex.gowidget.billing;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class e
  implements DialogInterface.OnKeyListener
{
  e(BillingActivity paramBillingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      BillingActivity.c(this.a).dismiss();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */