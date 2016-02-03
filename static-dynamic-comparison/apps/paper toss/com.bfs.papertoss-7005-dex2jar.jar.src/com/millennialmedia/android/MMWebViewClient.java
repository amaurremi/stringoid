package com.millennialmedia.android;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class MMWebViewClient
  extends WebViewClient
{
  String adUrl;
  boolean hasDoneMraidCalls;
  OverlaySettings settings;
  
  private MMWebViewClient() {}
  
  MMWebViewClient(OverlaySettings paramOverlaySettings)
  {
    this.settings = paramOverlaySettings;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    if (paramString.substring(0, 6).equalsIgnoreCase("mmsdk:"))
    {
      MMAdViewSDK.Log.v("Running JS bridge command: " + paramString);
      paramWebView = new MMCommand(paramWebView, paramString);
      paramWebView.settings = this.settings;
      new Thread(paramWebView).start();
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */