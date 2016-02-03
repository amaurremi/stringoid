package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import com.mopub.mobileads.factories.HtmlBannerWebViewFactory;
import java.util.Map;

public class HtmlBanner
  extends CustomEventBanner
{
  private HtmlBannerWebView mHtmlBannerWebView;
  
  private boolean extrasAreValid(Map<String, String> paramMap)
  {
    return paramMap.containsKey("Html-Response-Body");
  }
  
  protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    if (extrasAreValid(paramMap1))
    {
      String str1 = Uri.decode((String)paramMap1.get("Html-Response-Body"));
      String str2 = (String)paramMap1.get("Redirect-Url");
      String str3 = (String)paramMap1.get("Clickthrough-Url");
      paramMap1 = Boolean.valueOf((String)paramMap1.get("Scrollable"));
      paramMap = AdConfiguration.extractFromMap(paramMap);
      this.mHtmlBannerWebView = HtmlBannerWebViewFactory.create(paramContext, paramCustomEventBannerListener, paramMap1.booleanValue(), str2, str3, paramMap);
      AdViewController.setShouldHonorServerDimensions(this.mHtmlBannerWebView);
      this.mHtmlBannerWebView.loadHtmlResponse(str1);
      return;
    }
    paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
  }
  
  protected void onInvalidate()
  {
    if (this.mHtmlBannerWebView != null) {
      this.mHtmlBannerWebView.destroy();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/HtmlBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */