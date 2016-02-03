package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.factories.MraidViewFactory;
import com.mopub.mobileads.util.WebViews;

public class MraidActivity
  extends BaseInterstitialActivity
{
  private MraidView mMraidView;
  
  private static Intent createIntent(Context paramContext, String paramString, AdConfiguration paramAdConfiguration)
  {
    paramContext = new Intent(paramContext, MraidActivity.class);
    paramContext.putExtra("Html-Response-Body", paramString);
    paramContext.putExtra("Ad-Configuration", paramAdConfiguration);
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  static void preRenderHtml(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, String paramString)
  {
    paramContext = MraidViewFactory.create(paramContext, null, MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE, MraidView.PlacementType.INTERSTITIAL);
    paramContext.enablePlugins(false);
    paramContext.setMraidListener(new MraidView.MraidListener()
    {
      public void onClose(MraidView paramAnonymousMraidView, MraidView.ViewState paramAnonymousViewState) {}
      
      public void onExpand(MraidView paramAnonymousMraidView) {}
      
      public void onFailure(MraidView paramAnonymousMraidView)
      {
        this.val$customEventInterstitialListener.onInterstitialFailed(null);
      }
      
      public void onOpen(MraidView paramAnonymousMraidView) {}
      
      public void onReady(MraidView paramAnonymousMraidView)
      {
        this.val$customEventInterstitialListener.onInterstitialLoaded();
      }
    });
    paramContext.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        this.val$customEventInterstitialListener.onInterstitialLoaded();
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return true;
      }
    });
    paramContext.loadHtmlData(paramString);
  }
  
  public static void start(Context paramContext, String paramString, AdConfiguration paramAdConfiguration)
  {
    paramString = createIntent(paramContext, paramString, paramAdConfiguration);
    try
    {
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
    }
  }
  
  public View getAdView()
  {
    this.mMraidView = MraidViewFactory.create(this, getAdConfiguration(), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INTERSTITIAL);
    this.mMraidView.setMraidListener(new MraidView.BaseMraidListener()
    {
      public void onClose(MraidView paramAnonymousMraidView, MraidView.ViewState paramAnonymousViewState)
      {
        MraidActivity.this.mMraidView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
        MraidActivity.this.finish();
      }
      
      public void onOpen(MraidView paramAnonymousMraidView)
      {
        EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
      }
      
      public void onReady(MraidView paramAnonymousMraidView)
      {
        MraidActivity.this.mMraidView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
        MraidActivity.this.showInterstitialCloseButton();
      }
    });
    this.mMraidView.setOnCloseButtonStateChange(new MraidView.OnCloseButtonStateChangeListener()
    {
      public void onCloseButtonStateChange(MraidView paramAnonymousMraidView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          MraidActivity.this.showInterstitialCloseButton();
          return;
        }
        MraidActivity.this.hideInterstitialCloseButton();
      }
    });
    String str = getIntent().getStringExtra("Html-Response-Body");
    this.mMraidView.loadHtmlData(str);
    return this.mMraidView;
  }
  
  @TargetApi(11)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.show");
    if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
      getWindow().setFlags(16777216, 16777216);
    }
  }
  
  protected void onDestroy()
  {
    this.mMraidView.destroy();
    EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.dismiss");
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    WebViews.onPause(this.mMraidView);
  }
  
  protected void onResume()
  {
    super.onResume();
    WebViews.onResume(this.mMraidView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */