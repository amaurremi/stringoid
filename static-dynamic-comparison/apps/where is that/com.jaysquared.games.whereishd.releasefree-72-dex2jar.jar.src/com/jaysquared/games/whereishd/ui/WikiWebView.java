package com.jaysquared.games.whereishd.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class WikiWebView
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = WikiWebView.class.getSimpleName();
  private MoPubView moPubView = null;
  private Button quitButton;
  private String wiki;
  
  private void SetupListeners()
  {
    this.quitButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WikiWebView.this.setResult(-1);
        WikiWebView.this.finish();
      }
    });
  }
  
  public void onBannerClicked(MoPubView paramMoPubView) {}
  
  public void onBannerCollapsed(MoPubView paramMoPubView) {}
  
  public void onBannerExpanded(MoPubView paramMoPubView) {}
  
  public void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode) {}
  
  public void onBannerLoaded(MoPubView paramMoPubView)
  {
    findViewById(2131230816).setVisibility(0);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    setContentView(2130903087);
    this.quitButton = ((Button)findViewById(2131230813));
    this.wiki = getIntent().getExtras().getString("wiki");
    paramBundle = (ProgressBar)findViewById(2131230812);
    paramBundle.setVisibility(0);
    final WebView localWebView = (WebView)findViewById(2131230989);
    localWebView.setVisibility(8);
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.loadUrl(this.wiki + "?useformat=mobile");
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        SLog.d(WikiWebView.LOG_TAG, "WIKI Wikipedia page loaded");
        paramBundle.setVisibility(8);
        localWebView.setVisibility(0);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    });
    localWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        paramBundle.setProgress(paramAnonymousInt);
      }
    });
    SetupListeners();
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS)
    {
      this.moPubView = ((MoPubView)findViewById(2131230817));
      return;
    }
    this.moPubView = ((MoPubView)findViewById(2131230817));
    this.moPubView.setBannerAdListener(this);
    this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
    this.moPubView.loadAd();
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    if (this.moPubView != null) {
      this.moPubView.destroy();
    }
    super.onDestroy();
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/WikiWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */