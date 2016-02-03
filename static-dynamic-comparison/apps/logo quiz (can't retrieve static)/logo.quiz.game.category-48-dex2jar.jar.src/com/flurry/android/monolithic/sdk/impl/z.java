package com.flurry.android.monolithic.sdk.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.webkit.WebChromeClient;

class z
  implements DialogInterface.OnDismissListener
{
  z(w paramw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ja.a(3, o.a(this.a.a), "customViewFullScreenDialog.onDismiss()");
    if ((o.n(this.a.a) != null) && (o.o(this.a.a) != null)) {
      o.o(this.a.a).onHideCustomView();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */