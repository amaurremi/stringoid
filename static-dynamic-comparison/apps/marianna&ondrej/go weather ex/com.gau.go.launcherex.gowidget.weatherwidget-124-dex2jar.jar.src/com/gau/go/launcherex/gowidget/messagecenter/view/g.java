package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class g
  extends WebViewClient
{
  private String b = "";
  
  g(MessageCenterWebView paramMessageCenterWebView) {}
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    MessageCenterWebView.b(this.a);
    if (this.b.equals(paramString)) {
      paramWebView.loadUrl("javascript:init('" + MessageCenterWebView.c(this.a) + "','" + MessageCenterWebView.d(this.a) + "')");
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    MessageCenterWebView.a(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */