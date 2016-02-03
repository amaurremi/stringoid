package com.greystripe.sdk;

final class an
  implements GSAdListener
{
  private an(am paramam) {}
  
  public final void onAdClickthrough(GSAd paramGSAd) {}
  
  public final void onAdCollapse(GSAd paramGSAd) {}
  
  public final void onAdDismissal(GSAd paramGSAd) {}
  
  public final void onAdExpansion(GSAd paramGSAd) {}
  
  public final void onFailedToFetchAd(GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode) {}
  
  public final void onFetchedAd(GSAd paramGSAd)
  {
    paramGSAd = this.a;
    paramGSAd.post(new ao(this, paramGSAd));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */