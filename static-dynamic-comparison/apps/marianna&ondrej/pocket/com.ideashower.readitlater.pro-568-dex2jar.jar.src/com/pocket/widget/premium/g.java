package com.pocket.widget.premium;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class g
  extends WebViewClient
{
  private g(PremiumUpgradeWebView paramPremiumUpgradeWebView) {}
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    PremiumUpgradeWebView.a(this.a, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    PremiumUpgradeWebView.a(this.a, paramString);
    PremiumUpgradeWebView.a(this.a).a(false);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    PremiumUpgradeWebView.c(this.a);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.cancel();
    PremiumUpgradeWebView.c(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return PremiumUpgradeWebView.a(this.a, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */