package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

public class MraidBrowser
  extends Activity
{
  public static final String URL_EXTRA = "extra_url";
  
  private void enableCookies()
  {
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
  }
  
  private void initializeButtons(Intent paramIntent)
  {
    paramIntent = (ImageButton)findViewById(R.id.browserBackButton);
    paramIntent.setBackgroundColor(0);
    paramIntent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (WebView)MraidBrowser.this.findViewById(R.id.webView);
        if (paramAnonymousView.canGoBack()) {
          paramAnonymousView.goBack();
        }
      }
    });
    paramIntent = (ImageButton)findViewById(R.id.browserForwardButton);
    paramIntent.setBackgroundColor(0);
    paramIntent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (WebView)MraidBrowser.this.findViewById(R.id.webView);
        if (paramAnonymousView.canGoForward()) {
          paramAnonymousView.goForward();
        }
      }
    });
    paramIntent = (ImageButton)findViewById(R.id.browserRefreshButton);
    paramIntent.setBackgroundColor(0);
    paramIntent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ((WebView)MraidBrowser.this.findViewById(R.id.webView)).reload();
      }
    });
    paramIntent = (ImageButton)findViewById(R.id.browserCloseButton);
    paramIntent.setBackgroundColor(0);
    paramIntent.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MraidBrowser.this.finish();
      }
    });
  }
  
  private void initializeWebView(Intent paramIntent)
  {
    WebView localWebView = (WebView)findViewById(R.id.webView);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebView.loadUrl(paramIntent.getStringExtra("extra_url"));
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        paramAnonymousString = (ImageButton)MraidBrowser.this.findViewById(R.id.browserBackButton);
        if (paramAnonymousWebView.canGoBack())
        {
          i = R.drawable.leftarrow;
          paramAnonymousString.setImageResource(i);
          paramAnonymousString = (ImageButton)MraidBrowser.this.findViewById(R.id.browserForwardButton);
          if (!paramAnonymousWebView.canGoForward()) {
            break label74;
          }
        }
        label74:
        for (int i = R.drawable.rightarrow;; i = R.drawable.unrightarrow)
        {
          paramAnonymousString.setImageResource(i);
          return;
          i = R.drawable.unleftarrow;
          break;
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        ((ImageButton)MraidBrowser.this.findViewById(R.id.browserForwardButton)).setImageResource(R.drawable.unrightarrow);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        Toast.makeText((Activity)paramAnonymousWebView.getContext(), "MRAID error: " + paramAnonymousString1, 0).show();
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString == null) {}
        do
        {
          return false;
          paramAnonymousWebView = Uri.parse(paramAnonymousString).getHost();
        } while ((!paramAnonymousString.startsWith("market:")) && (!paramAnonymousString.startsWith("tel:")) && (!paramAnonymousString.startsWith("voicemail:")) && (!paramAnonymousString.startsWith("sms:")) && (!paramAnonymousString.startsWith("mailto:")) && (!paramAnonymousString.startsWith("geo:")) && (!paramAnonymousString.startsWith("google.streetview:")) && (!"play.google.com".equals(paramAnonymousWebView)) && (!"market.android.com".equals(paramAnonymousWebView)));
        try
        {
          MraidBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
          MraidBrowser.this.finish();
          return true;
        }
        catch (ActivityNotFoundException paramAnonymousWebView)
        {
          for (;;)
          {
            Log.w("MoPub", "Unable to start activity for " + paramAnonymousString + ". " + "Ensure that your phone can handle this intent.");
          }
        }
      }
    });
    localWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        Activity localActivity = (Activity)paramAnonymousWebView.getContext();
        localActivity.setTitle("Loading...");
        localActivity.setProgress(paramAnonymousInt * 100);
        if (paramAnonymousInt == 100) {
          localActivity.setTitle(paramAnonymousWebView.getUrl());
        }
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    setContentView(R.layout.mraid_browser);
    paramBundle = getIntent();
    initializeWebView(paramBundle);
    initializeButtons(paramBundle);
    enableCookies();
  }
  
  protected void onPause()
  {
    super.onPause();
    CookieSyncManager.getInstance().stopSync();
  }
  
  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */