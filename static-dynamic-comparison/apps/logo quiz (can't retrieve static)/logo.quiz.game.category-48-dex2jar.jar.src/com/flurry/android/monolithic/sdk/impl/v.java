package com.flurry.android.monolithic.sdk.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.webkit.WebView;

class v
  implements DialogInterface.OnDismissListener
{
  v(o paramo) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ja.a(3, o.a(this.a), "extendedWebViewDialog.onDismiss()");
    if (o.b(this.a) != null) {
      o.b(this.a).loadUrl("javascript:if(window.mraid){window.mraid.close();};");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */