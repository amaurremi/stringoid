package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;

public class MoPubActivity
  extends BaseInterstitialActivity
{
  private HtmlInterstitialWebView mHtmlInterstitialWebView;
  
  static Intent createIntent(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3, AdConfiguration paramAdConfiguration)
  {
    paramContext = new Intent(paramContext, MoPubActivity.class);
    paramContext.putExtra("Html-Response-Body", paramString1);
    paramContext.putExtra("Scrollable", paramBoolean);
    paramContext.putExtra("Clickthrough-Url", paramString3);
    paramContext.putExtra("Redirect-Url", paramString2);
    paramContext.putExtra("Ad-Configuration", paramAdConfiguration);
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  static void preRenderHtml(Context paramContext, CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, String paramString)
  {
    paramContext = HtmlInterstitialWebViewFactory.create(paramContext, paramCustomEventInterstitialListener, false, null, null, null);
    paramContext.enablePlugins(false);
    paramContext.addMoPubUriJavascriptInterface(new HtmlInterstitialWebView.MoPubUriJavascriptFireFinishLoadListener()
    {
      public void onInterstitialLoaded()
      {
        this.val$customEventInterstitialListener.onInterstitialLoaded();
      }
    });
    paramContext.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.equals("mopub://finishLoad")) {
          this.val$customEventInterstitialListener.onInterstitialLoaded();
        }
        for (;;)
        {
          return true;
          if (paramAnonymousString.equals("mopub://failLoad")) {
            this.val$customEventInterstitialListener.onInterstitialFailed(null);
          }
        }
      }
    });
    paramContext.loadHtmlResponse(paramString);
  }
  
  public static void start(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3, AdConfiguration paramAdConfiguration)
  {
    paramString1 = createIntent(paramContext, paramString1, paramBoolean, paramString2, paramString3, paramAdConfiguration);
    try
    {
      paramContext.startActivity(paramString1);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
    }
  }
  
  public View getAdView()
  {
    Object localObject = getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("Scrollable", false);
    String str1 = ((Intent)localObject).getStringExtra("Redirect-Url");
    String str2 = ((Intent)localObject).getStringExtra("Clickthrough-Url");
    localObject = ((Intent)localObject).getStringExtra("Html-Response-Body");
    this.mHtmlInterstitialWebView = HtmlInterstitialWebViewFactory.create(getApplicationContext(), new BroadcastingInterstitialListener(), bool, str1, str2, getAdConfiguration());
    this.mHtmlInterstitialWebView.loadHtmlResponse((String)localObject);
    return this.mHtmlInterstitialWebView;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.show");
  }
  
  protected void onDestroy()
  {
    this.mHtmlInterstitialWebView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
    this.mHtmlInterstitialWebView.destroy();
    EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.dismiss");
    super.onDestroy();
  }
  
  class BroadcastingInterstitialListener
    implements CustomEventInterstitial.CustomEventInterstitialListener
  {
    BroadcastingInterstitialListener() {}
    
    public void onInterstitialClicked()
    {
      EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
    }
    
    public void onInterstitialDismissed() {}
    
    public void onInterstitialFailed(MoPubErrorCode paramMoPubErrorCode)
    {
      EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.fail");
      MoPubActivity.this.finish();
    }
    
    public void onInterstitialLoaded()
    {
      MoPubActivity.this.mHtmlInterstitialWebView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
    }
    
    public void onInterstitialShown() {}
    
    public void onLeaveApplication() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MoPubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */