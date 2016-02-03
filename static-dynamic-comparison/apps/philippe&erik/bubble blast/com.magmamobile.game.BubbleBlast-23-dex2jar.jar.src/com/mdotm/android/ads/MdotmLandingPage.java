package com.mdotm.android.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MdotmLandingPage
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(2);
    paramBundle = new WebView(this);
    setContentView(paramBundle);
    paramBundle.getSettings().setJavaScriptEnabled(true);
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        jdField_this.setProgress(paramAnonymousInt * 1000);
      }
    });
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        Toast.makeText(jdField_this, "Oh no! " + paramAnonymousString1, 0).show();
      }
    });
    paramBundle.loadUrl(getIntent().getExtras().getString("bStrLandingPage"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/mdotm/android/ads/MdotmLandingPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */