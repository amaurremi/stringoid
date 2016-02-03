package com.greystripe.sdk;

final class bb
  implements GSAdListener
{
  private bb(GSFullscreenAd paramGSFullscreenAd) {}
  
  public final void onAdClickthrough(GSAd paramGSAd)
  {
    GSFullscreenAd.a(this.a);
  }
  
  public final void onAdCollapse(GSAd paramGSAd) {}
  
  public final void onAdDismissal(GSAd paramGSAd)
  {
    GSFullscreenAd.a(this.a);
  }
  
  public final void onAdExpansion(GSAd paramGSAd) {}
  
  public final void onFailedToFetchAd(GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode) {}
  
  public final void onFetchedAd(GSAd paramGSAd) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */