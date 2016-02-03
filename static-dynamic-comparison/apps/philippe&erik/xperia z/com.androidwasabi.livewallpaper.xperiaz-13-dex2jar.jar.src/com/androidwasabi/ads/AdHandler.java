package com.androidwasabi.ads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AdHandler
  extends Activity
{
  public static final String TAG = "AdHandler";
  ProgressDialog progDailog;
  WebView web;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras().getString("url");
    try
    {
      this.progDailog = new ProgressDialog(this);
      this.progDailog.setMessage("Loading...");
      this.progDailog.setIndeterminate(false);
      this.progDailog.setProgressStyle(0);
      this.progDailog.setCancelable(true);
      this.progDailog.show();
      this.progDailog.setOnCancelListener(new AdHandler.1(this));
      this.web = new WebView(getApplicationContext());
      this.web.getSettings().setJavaScriptEnabled(true);
      this.web.setWebViewClient(new AdHandler.2(this));
      this.web.loadUrl(paramBundle);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.web != null) {
        this.web.destroy();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */