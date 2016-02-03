package com.flurry.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.webkit.WebChromeClient;

final class o
  implements DialogInterface.OnDismissListener
{
  o(cs paramcs) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((bn.l(this.I.dW) != null) && (bn.m(this.I.dW) != null)) {
      bn.m(this.I.dW).onHideCustomView();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */