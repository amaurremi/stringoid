package com.admob.android.ads;

public abstract interface AdListener
{
  public abstract void onFailedToReceiveAd(AdView paramAdView);
  
  public abstract void onFailedToReceiveRefreshedAd(AdView paramAdView);
  
  public abstract void onReceiveAd(AdView paramAdView);
  
  public abstract void onReceiveRefreshedAd(AdView paramAdView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */