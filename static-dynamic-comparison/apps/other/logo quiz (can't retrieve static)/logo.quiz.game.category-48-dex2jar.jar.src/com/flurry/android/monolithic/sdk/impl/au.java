package com.flurry.android.monolithic.sdk.impl;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class au
  extends WebViewClient
{
  private au(ar paramar) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ja.a(3, ar.a(this.a), "onPageFinished: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != ar.b(this.a))) {
      return;
    }
    ar.a(this.a, false);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    ja.a(3, ar.a(this.a), "onPageStarted: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != ar.b(this.a))) {
      return;
    }
    if (ar.d(this.a))
    {
      boolean bool = false;
      if (ar.c(this.a) != null) {
        bool = ar.c(this.a).a(this.a, paramString, ar.d(this.a));
      }
      if (bool) {
        paramWebView.stopLoading();
      }
    }
    ar.a(this.a, true);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ja.a(3, ar.a(this.a), "shouldOverrideUrlLoading: url = " + paramString);
    if ((paramString == null) || (paramWebView == null) || (paramWebView != ar.b(this.a))) {
      return false;
    }
    if (ar.c(this.a) != null) {}
    for (boolean bool = ar.c(this.a).a(this.a, paramString, ar.d(this.a));; bool = false)
    {
      ar.a(this.a, false);
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */