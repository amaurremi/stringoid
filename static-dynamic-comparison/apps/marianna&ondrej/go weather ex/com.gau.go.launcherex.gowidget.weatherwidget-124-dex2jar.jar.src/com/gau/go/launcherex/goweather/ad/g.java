package com.gau.go.launcherex.goweather.ad;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class g
  extends WebViewClient
{
  g(AdWebviewActivity paramAdWebviewActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (AdWebviewActivity.a(this.a).isShown()) {
      AdWebviewActivity.a(this.a).setVisibility(4);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    AdWebviewActivity.a(this.a).setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */