package com.appbrain.a;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

final class cn
  extends WebViewClient
{
  cn(cm paramcm, ProgressBar paramProgressBar) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.setVisibility(8);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!cm.a(this.b, paramWebView, paramString)) {
      this.a.setVisibility(0);
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return cm.a(this.b, paramWebView, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */