package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

public abstract interface MediationBannerListener
{
  public abstract void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
  
  public abstract void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/mediation/MediationBannerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */