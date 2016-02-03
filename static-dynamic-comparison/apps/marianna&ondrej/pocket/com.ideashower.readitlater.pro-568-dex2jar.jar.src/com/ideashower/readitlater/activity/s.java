package com.ideashower.readitlater.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pocket.d.k;

class s
  extends WebViewClient
{
  private s(r paramr) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.contains("readitlaterlist.com/oauthcallback"))
    {
      k.b(r.a(this.a, paramString));
      this.a.P();
      return true;
    }
    r.a(this.a).loadUrl(paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */