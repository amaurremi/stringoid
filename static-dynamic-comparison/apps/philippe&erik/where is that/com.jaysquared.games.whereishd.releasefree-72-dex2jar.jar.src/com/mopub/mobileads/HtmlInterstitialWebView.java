package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.mopub.common.util.VersionCode;

public class HtmlInterstitialWebView
  extends BaseHtmlWebView
{
  protected static final String MOPUB_JS_INTERFACE_NAME = "mopubUriInterface";
  private Handler mHandler = new Handler();
  
  public HtmlInterstitialWebView(Context paramContext, AdConfiguration paramAdConfiguration)
  {
    super(paramContext, paramAdConfiguration);
  }
  
  private void postHandlerRunnable(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  void addMoPubUriJavascriptInterface(final MoPubUriJavascriptFireFinishLoadListener paramMoPubUriJavascriptFireFinishLoadListener)
  {
    addJavascriptInterface(new Object()
    {
      @JavascriptInterface
      public boolean fireFinishLoad()
      {
        this.this$0.postHandlerRunnable(new Runnable()
        {
          public void run()
          {
            HtmlInterstitialWebView.1MoPubUriJavascriptInterface.this.val$moPubUriJavascriptFireFinishLoadListener.onInterstitialLoaded();
          }
        });
        return true;
      }
    }, "mopubUriInterface");
  }
  
  @TargetApi(11)
  public void destroy()
  {
    if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
      removeJavascriptInterface("mopubUriInterface");
    }
    super.destroy();
  }
  
  public void init(final CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener, boolean paramBoolean, String paramString1, String paramString2)
  {
    super.init(paramBoolean);
    setWebViewClient(new HtmlWebViewClient(new HtmlInterstitialWebViewListener(paramCustomEventInterstitialListener), this, paramString2, paramString1));
    addMoPubUriJavascriptInterface(new MoPubUriJavascriptFireFinishLoadListener()
    {
      public void onInterstitialLoaded()
      {
        if (!HtmlInterstitialWebView.this.mIsDestroyed) {
          paramCustomEventInterstitialListener.onInterstitialLoaded();
        }
      }
    });
  }
  
  static class HtmlInterstitialWebViewListener
    implements HtmlWebViewListener
  {
    private final CustomEventInterstitial.CustomEventInterstitialListener mCustomEventInterstitialListener;
    
    public HtmlInterstitialWebViewListener(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener)
    {
      this.mCustomEventInterstitialListener = paramCustomEventInterstitialListener;
    }
    
    public void onClicked()
    {
      this.mCustomEventInterstitialListener.onInterstitialClicked();
    }
    
    public void onCollapsed() {}
    
    public void onFailed(MoPubErrorCode paramMoPubErrorCode)
    {
      this.mCustomEventInterstitialListener.onInterstitialFailed(paramMoPubErrorCode);
    }
    
    public void onLoaded(BaseHtmlWebView paramBaseHtmlWebView)
    {
      this.mCustomEventInterstitialListener.onInterstitialLoaded();
    }
  }
  
  static abstract interface MoPubUriJavascriptFireFinishLoadListener
  {
    public abstract void onInterstitialLoaded();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/HtmlInterstitialWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */