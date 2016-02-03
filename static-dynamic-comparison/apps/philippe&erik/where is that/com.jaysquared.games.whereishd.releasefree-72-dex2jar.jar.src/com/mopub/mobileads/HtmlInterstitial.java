package com.mopub.mobileads;

import android.net.Uri;
import java.util.Map;

public class HtmlInterstitial
  extends ResponseBodyInterstitial
{
  private String mClickthroughUrl;
  private String mHtmlData;
  private boolean mIsScrollable;
  private String mRedirectUrl;
  
  protected void extractExtras(Map<String, String> paramMap)
  {
    this.mHtmlData = Uri.decode((String)paramMap.get("Html-Response-Body"));
    this.mIsScrollable = Boolean.valueOf((String)paramMap.get("Scrollable")).booleanValue();
    this.mRedirectUrl = ((String)paramMap.get("Redirect-Url"));
    this.mClickthroughUrl = ((String)paramMap.get("Clickthrough-Url"));
  }
  
  protected void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener paramCustomEventInterstitialListener)
  {
    MoPubActivity.preRenderHtml(this.mContext, paramCustomEventInterstitialListener, this.mHtmlData);
  }
  
  protected void showInterstitial()
  {
    MoPubActivity.start(this.mContext, this.mHtmlData, this.mIsScrollable, this.mRedirectUrl, this.mClickthroughUrl, this.mAdConfiguration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/HtmlInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */