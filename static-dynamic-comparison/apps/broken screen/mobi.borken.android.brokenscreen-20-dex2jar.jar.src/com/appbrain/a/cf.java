package com.appbrain.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class cf
  extends WebViewClient
{
  cf(ce paramce) {}
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.loadData("<html><body style='color:#444;'><h2>There was a network error.</h2> Please check your internet connection and <a href=\"" + paramString2 + "\"> click here to try again</a>.</body></html>", "text/html", "utf-8");
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("/")) || (paramString.startsWith(ce.a(this.a))) || ((ce.b(this.a) != null) && (paramString.startsWith(ce.b(this.a))))) {
      return false;
    }
    paramWebView = new Intent("android.intent.action.VIEW");
    paramWebView.setData(Uri.parse(paramString));
    try
    {
      ce.c(this.a).startActivity(paramWebView);
      return true;
    }
    catch (ActivityNotFoundException paramWebView)
    {
      for (;;)
      {
        paramWebView.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */