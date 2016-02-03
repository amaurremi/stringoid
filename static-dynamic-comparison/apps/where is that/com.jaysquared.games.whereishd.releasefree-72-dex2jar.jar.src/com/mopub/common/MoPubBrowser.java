package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.IntentUtils;
import com.mopub.nativeads.util.Utils;

public class MoPubBrowser
  extends Activity
{
  public static final String DESTINATION_URL_KEY = "URL";
  private static final int INNER_LAYOUT_ID = 1;
  private ImageButton mBackButton;
  private ImageButton mCloseButton;
  private ImageButton mForwardButton;
  private ImageButton mRefreshButton;
  private WebView mWebView;
  
  private void enableCookies()
  {
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
  }
  
  private ImageButton getButton(Drawable paramDrawable)
  {
    ImageButton localImageButton = new ImageButton(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    localLayoutParams.gravity = 16;
    localImageButton.setLayoutParams(localLayoutParams);
    localImageButton.setImageDrawable(paramDrawable);
    return localImageButton;
  }
  
  private View getMoPubBrowserView()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localRelativeLayout);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setId(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setBackgroundDrawable(Drawables.BACKGROUND.decodeImage(this));
    localRelativeLayout.addView((View)localObject);
    this.mBackButton = getButton(Drawables.LEFT_ARROW.decodeImage(this));
    this.mForwardButton = getButton(Drawables.RIGHT_ARROW.decodeImage(this));
    this.mRefreshButton = getButton(Drawables.REFRESH.decodeImage(this));
    this.mCloseButton = getButton(Drawables.CLOSE.decodeImage(this));
    ((LinearLayout)localObject).addView(this.mBackButton);
    ((LinearLayout)localObject).addView(this.mForwardButton);
    ((LinearLayout)localObject).addView(this.mRefreshButton);
    ((LinearLayout)localObject).addView(this.mCloseButton);
    this.mWebView = new WebView(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 1);
    this.mWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(this.mWebView);
    return localLinearLayout;
  }
  
  private void initializeButtons()
  {
    this.mBackButton.setBackgroundColor(0);
    this.mBackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MoPubBrowser.this.mWebView.canGoBack()) {
          MoPubBrowser.this.mWebView.goBack();
        }
      }
    });
    this.mForwardButton.setBackgroundColor(0);
    this.mForwardButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (MoPubBrowser.this.mWebView.canGoForward()) {
          MoPubBrowser.this.mWebView.goForward();
        }
      }
    });
    this.mRefreshButton.setBackgroundColor(0);
    this.mRefreshButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoPubBrowser.this.mWebView.reload();
      }
    });
    this.mCloseButton.setBackgroundColor(0);
    this.mCloseButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoPubBrowser.this.finish();
      }
    });
  }
  
  private void initializeWebView()
  {
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    this.mWebView.loadUrl(getIntent().getStringExtra("URL"));
    this.mWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        if (paramAnonymousWebView.canGoBack())
        {
          paramAnonymousString = Drawables.LEFT_ARROW.decodeImage(MoPubBrowser.this);
          MoPubBrowser.this.mBackButton.setImageDrawable(paramAnonymousString);
          if (!paramAnonymousWebView.canGoForward()) {
            break label79;
          }
        }
        label79:
        for (paramAnonymousWebView = Drawables.RIGHT_ARROW.decodeImage(MoPubBrowser.this);; paramAnonymousWebView = Drawables.UNRIGHT_ARROW.decodeImage(MoPubBrowser.this))
        {
          MoPubBrowser.this.mForwardButton.setImageDrawable(paramAnonymousWebView);
          return;
          paramAnonymousString = Drawables.UNLEFT_ARROW.decodeImage(MoPubBrowser.this);
          break;
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        MoPubBrowser.this.mForwardButton.setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(MoPubBrowser.this));
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        Toast.makeText(MoPubBrowser.this, "MoPubBrowser error: " + paramAnonymousString1, 0).show();
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString == null) {}
        do
        {
          return false;
          paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
        } while ((!IntentUtils.isDeepLink(paramAnonymousString)) || (!IntentUtils.deviceCanHandleIntent(MoPubBrowser.this, paramAnonymousWebView)));
        MoPubBrowser.this.startActivity(paramAnonymousWebView);
        MoPubBrowser.this.finish();
        return true;
      }
    });
    this.mWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        MoPubBrowser.this.setTitle("Loading...");
        MoPubBrowser.this.setProgress(paramAnonymousInt * 100);
        if (paramAnonymousInt == 100) {
          MoPubBrowser.this.setTitle(paramAnonymousWebView.getUrl());
        }
      }
    });
  }
  
  public static void open(Context paramContext, String paramString)
  {
    Utils.MoPubLog("Opening url in MoPubBrowser: " + paramString);
    Intent localIntent = new Intent(paramContext, MoPubBrowser.class);
    localIntent.putExtra("URL", paramString);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    setContentView(getMoPubBrowserView());
    initializeWebView();
    initializeButtons();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/MoPubBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */