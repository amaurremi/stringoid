package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;

public class HtmlBannerWebViewFactory
{
  protected static HtmlBannerWebViewFactory instance = new HtmlBannerWebViewFactory();
  
  public static HtmlBannerWebView create(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, boolean paramBoolean, String paramString1, String paramString2, AdConfiguration paramAdConfiguration)
  {
    return instance.internalCreate(paramContext, paramCustomEventBannerListener, paramBoolean, paramString1, paramString2, paramAdConfiguration);
  }
  
  @Deprecated
  public static void setInstance(HtmlBannerWebViewFactory paramHtmlBannerWebViewFactory)
  {
    instance = paramHtmlBannerWebViewFactory;
  }
  
  public HtmlBannerWebView internalCreate(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, boolean paramBoolean, String paramString1, String paramString2, AdConfiguration paramAdConfiguration)
  {
    paramContext = new HtmlBannerWebView(paramContext, paramAdConfiguration);
    paramContext.init(paramCustomEventBannerListener, paramBoolean, paramString1, paramString2);
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/HtmlBannerWebViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */