package com.google.ads.mediation.adfonic.listener;

import com.adfonic.android.AdListener;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.adfonic.AdfonicAdapter;

public class MediationBannerAdListener
  implements AdListener
{
  private AdfonicAdapter adapter;
  private MediationBannerListener listener;
  
  public MediationBannerAdListener(MediationBannerListener paramMediationBannerListener, AdfonicAdapter paramAdfonicAdapter)
  {
    this.listener = paramMediationBannerListener;
    this.adapter = paramAdfonicAdapter;
  }
  
  public void onClick()
  {
    this.listener.onClick(this.adapter);
  }
  
  public void onDismissScreen()
  {
    this.listener.onDismissScreen(this.adapter);
  }
  
  public void onInternalError()
  {
    this.listener.onFailedToReceiveAd(this.adapter, AdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  public void onInvalidRequest()
  {
    this.listener.onFailedToReceiveAd(this.adapter, AdRequest.ErrorCode.INVALID_REQUEST);
  }
  
  public void onLeaveApplication()
  {
    this.listener.onLeaveApplication(this.adapter);
  }
  
  public void onNetworkError()
  {
    this.listener.onFailedToReceiveAd(this.adapter, AdRequest.ErrorCode.NETWORK_ERROR);
  }
  
  public void onNoFill()
  {
    this.listener.onFailedToReceiveAd(this.adapter, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onPresentScreen()
  {
    this.listener.onPresentScreen(this.adapter);
  }
  
  public void onReceivedAd()
  {
    this.listener.onReceivedAd(this.adapter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/adfonic/listener/MediationBannerAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */