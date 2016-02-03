package com.flurry.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.webkit.WebView;

final class bv
  implements DialogInterface.OnDismissListener
{
  bv(bn parambn) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (bn.b(this.dW) != null) {
      bn.b(this.dW).loadUrl("javascript:if(window.mraid){window.mraid.close();};");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */