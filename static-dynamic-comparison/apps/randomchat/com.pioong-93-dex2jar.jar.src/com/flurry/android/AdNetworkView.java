package com.flurry.android;

import android.content.Context;
import java.util.Map;

public abstract class AdNetworkView
  extends p
{
  private final AdCreative er;
  
  public AdNetworkView(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdCreative paramAdCreative)
  {
    super(paramContext, paramFlurryAds, paramcz);
    this.er = paramAdCreative;
  }
  
  public AdCreative getAdCreative()
  {
    return this.er;
  }
  
  public void onAdClicked(Map<String, String> paramMap)
  {
    super.a("clicked", paramMap);
  }
  
  public void onAdClosed(Map<String, String> paramMap)
  {
    super.a("adClosed", paramMap);
  }
  
  public void onAdFilled(Map<String, String> paramMap)
  {
    super.a("filled", paramMap);
  }
  
  public void onAdShown(Map<String, String> paramMap)
  {
    super.a("rendered", paramMap);
  }
  
  public void onAdUnFilled(Map<String, String> paramMap)
  {
    super.a("unfilled", paramMap);
  }
  
  public void onRenderFailed(Map<String, String> paramMap)
  {
    super.a("renderFailed", paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdNetworkView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */