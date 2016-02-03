package com.greystripe.sdk;

public abstract interface GSAdListener
{
  public abstract void onAdClickthrough(GSAd paramGSAd);
  
  public abstract void onAdCollapse(GSAd paramGSAd);
  
  public abstract void onAdDismissal(GSAd paramGSAd);
  
  public abstract void onAdExpansion(GSAd paramGSAd);
  
  public abstract void onFailedToFetchAd(GSAd paramGSAd, GSAdErrorCode paramGSAdErrorCode);
  
  public abstract void onFetchedAd(GSAd paramGSAd);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */