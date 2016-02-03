package com.mopub.mobileads;

import android.content.Context;

public class HtmlBannerWebView
  extends BaseHtmlWebView
{
  public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";
  
  public HtmlBannerWebView(Context paramContext, AdConfiguration paramAdConfiguration)
  {
    super(paramContext, paramAdConfiguration);
  }
  
  public void init(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, boolean paramBoolean, String paramString1, String paramString2)
  {
    super.init(paramBoolean);
    setWebViewClient(new HtmlWebViewClient(new HtmlBannerWebViewListener(paramCustomEventBannerListener), this, paramString2, paramString1));
  }
  
  static class HtmlBannerWebViewListener
    implements HtmlWebViewListener
  {
    private final CustomEventBanner.CustomEventBannerListener mCustomEventBannerListener;
    
    public HtmlBannerWebViewListener(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener)
    {
      this.mCustomEventBannerListener = paramCustomEventBannerListener;
    }
    
    public void onClicked()
    {
      this.mCustomEventBannerListener.onBannerClicked();
    }
    
    public void onCollapsed()
    {
      this.mCustomEventBannerListener.onBannerCollapsed();
    }
    
    public void onFailed(MoPubErrorCode paramMoPubErrorCode)
    {
      this.mCustomEventBannerListener.onBannerFailed(paramMoPubErrorCode);
    }
    
    public void onLoaded(BaseHtmlWebView paramBaseHtmlWebView)
    {
      this.mCustomEventBannerListener.onBannerLoaded(paramBaseHtmlWebView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/HtmlBannerWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */