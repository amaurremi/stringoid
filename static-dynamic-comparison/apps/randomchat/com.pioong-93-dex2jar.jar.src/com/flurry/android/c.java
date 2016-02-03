package com.flurry.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class c
  extends WebViewClient
{
  private c(cl paramcl, byte paramByte) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    new StringBuilder().append("onPageFinished: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != cl.a(this.e))) {
      return;
    }
    cl.a(this.e, false);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    new StringBuilder().append("onPageStarted: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != cl.a(this.e))) {
      return;
    }
    if (cl.c(this.e))
    {
      boolean bool = false;
      if (cl.b(this.e) != null) {
        bool = cl.b(this.e).a(paramString, cl.c(this.e));
      }
      if (bool) {
        paramWebView.stopLoading();
      }
    }
    cl.a(this.e, true);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    new StringBuilder().append("shouldOverrideUrlLoading: url = ").append(paramString).toString();
    if ((paramString == null) || (paramWebView == null) || (paramWebView != cl.a(this.e))) {
      return false;
    }
    if (cl.b(this.e) != null) {}
    for (boolean bool = cl.b(this.e).a(paramString, cl.c(this.e));; bool = false)
    {
      cl.a(this.e, false);
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */