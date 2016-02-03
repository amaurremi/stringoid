package com.inmobi.androidsdk;

import java.util.Map;

public abstract interface InterstitialViewListener
{
  public abstract void onAdRequestFailed(InterstitialView paramInterstitialView, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onAdRequestLoaded(InterstitialView paramInterstitialView);
  
  public abstract void onDismissAdScreen(InterstitialView paramInterstitialView);
  
  public abstract void onInterstitialInteraction(InterstitialView paramInterstitialView, Map<String, String> paramMap);
  
  public abstract void onLeaveApplication(InterstitialView paramInterstitialView);
  
  public abstract void onShowAdScreen(InterstitialView paramInterstitialView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/InterstitialViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */