package com.flurry.android.monolithic.sdk.impl;

import android.webkit.WebChromeClient.CustomViewCallback;

final class ba
  implements ax
{
  private WebChromeClient.CustomViewCallback b;
  
  public ba(ar paramar, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.b = paramCustomViewCallback;
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.onCustomViewHidden();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */