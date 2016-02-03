package com.flurry.android.monolithic.sdk.impl;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;

final class at
  extends WebChromeClient
{
  private at(ar paramar) {}
  
  public void onHideCustomView()
  {
    ja.a(3, ar.a(this.a), "onHideCustomView()");
    if (ar.e(this.a) != null) {
      ar.e(this.a).a(this.a);
    }
    ar.b(this.a, false);
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    ja.a(3, ar.a(this.a), "onShowCustomView(14)");
    ar.b(this.a, true);
    if (ar.e(this.a) != null) {
      ar.e(this.a).a(this.a, paramView, paramInt, new ba(this.a, paramCustomViewCallback));
    }
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    ja.a(3, ar.a(this.a), "onShowCustomView(7)");
    ar.b(this.a, true);
    if (ar.e(this.a) != null) {
      ar.e(this.a).a(this.a, paramView, new ba(this.a, paramCustomViewCallback));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */