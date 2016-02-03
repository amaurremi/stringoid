package com.flurry.android;

import android.webkit.WebChromeClient.CustomViewCallback;

final class by
  implements BasicWebView.BasicWebViewFullScreenTransitionHandler.BasicWebViewFullScreenTransitionCallback
{
  private WebChromeClient.CustomViewCallback em;
  
  public by(WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.em = paramCustomViewCallback;
  }
  
  public final void onBasicWebViewTransitionFromFullScreenFinished()
  {
    if (this.em != null) {
      this.em.onCustomViewHidden();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */