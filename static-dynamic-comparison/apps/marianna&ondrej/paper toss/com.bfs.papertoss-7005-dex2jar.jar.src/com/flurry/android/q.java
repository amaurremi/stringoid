package com.flurry.android;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.List;

final class q
  extends WebViewClient
{
  q(CatalogActivity paramCatalogActivity) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      paramWebView = CatalogActivity.a(this.a);
      paramString = new f((byte)5, CatalogActivity.b(this.a));
      long l = CatalogActivity.a(this.a).c;
      paramWebView.d.add(paramString);
      paramWebView.c = l;
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    ah.c("FlurryAgent", "Failed to load url: " + paramString2 + " with an errorCode of " + paramInt);
    paramWebView.loadData("Cannot find Android Market information. <p>Please check your network", "text/html", "UTF-8");
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (CatalogActivity.a(this.a) != null) {
      CatalogActivity.a(this.a).a(new f((byte)6, CatalogActivity.b(this.a)));
    }
    CatalogActivity.c(this.a).a(paramWebView.getContext(), CatalogActivity.a(this.a), paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */