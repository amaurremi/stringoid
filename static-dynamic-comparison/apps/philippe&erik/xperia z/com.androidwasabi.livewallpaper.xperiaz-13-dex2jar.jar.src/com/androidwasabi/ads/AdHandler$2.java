package com.androidwasabi.ads;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class AdHandler$2
  extends WebViewClient
{
  AdHandler$2(AdHandler paramAdHandler) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    int i = 0;
    if ((paramString.startsWith("market://")) || (paramString.startsWith("https://play.google.com/"))) {}
    for (;;)
    {
      try
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.this$0.startActivity(paramWebView);
        try
        {
          this.this$0.progDailog.dismiss();
          i = 1;
          if (i != 0) {
            this.this$0.finish();
          }
          return bool;
        }
        catch (Exception paramWebView)
        {
          continue;
        }
      }
      catch (ActivityNotFoundException paramWebView)
      {
        continue;
      }
      bool = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdHandler$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */