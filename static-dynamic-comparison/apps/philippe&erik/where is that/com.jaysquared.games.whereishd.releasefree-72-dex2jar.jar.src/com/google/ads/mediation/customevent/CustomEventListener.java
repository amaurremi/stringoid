package com.google.ads.mediation.customevent;

public abstract interface CustomEventListener
{
  public abstract void onDismissScreen();
  
  public abstract void onFailedToReceiveAd();
  
  public abstract void onLeaveApplication();
  
  public abstract void onPresentScreen();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */