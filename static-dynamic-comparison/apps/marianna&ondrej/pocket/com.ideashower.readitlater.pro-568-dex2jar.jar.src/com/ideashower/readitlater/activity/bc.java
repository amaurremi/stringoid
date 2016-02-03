package com.ideashower.readitlater.activity;

import android.graphics.Bitmap;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ideashower.readitlater.views.BaseWebView;

class bc
  extends WebViewClient
{
  private bc(SubscriptionCustomWebActivity paramSubscriptionCustomWebActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    SubscriptionCustomWebActivity.a(this.a).setProgressBarVisibility(false);
    CookieSyncManager.getInstance().sync();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    SubscriptionCustomWebActivity.a(this.a).setProgressBarVisibility(true);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */