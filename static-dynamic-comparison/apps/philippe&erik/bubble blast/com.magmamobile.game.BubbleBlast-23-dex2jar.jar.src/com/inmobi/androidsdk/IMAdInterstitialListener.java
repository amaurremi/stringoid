package com.inmobi.androidsdk;

public abstract interface IMAdInterstitialListener
{
  public abstract void onAdRequestFailed(IMAdInterstitial paramIMAdInterstitial, IMAdRequest.ErrorCode paramErrorCode);
  
  public abstract void onAdRequestLoaded(IMAdInterstitial paramIMAdInterstitial);
  
  public abstract void onDismissAdScreen(IMAdInterstitial paramIMAdInterstitial);
  
  public abstract void onLeaveApplication(IMAdInterstitial paramIMAdInterstitial);
  
  public abstract void onShowAdScreen(IMAdInterstitial paramIMAdInterstitial);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/IMAdInterstitialListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */