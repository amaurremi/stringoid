package com.google.ads;

public abstract interface Ad
{
  public abstract boolean isReady();
  
  public abstract void loadAd(AdRequest paramAdRequest);
  
  public abstract void setAdListener(AdListener paramAdListener);
  
  public abstract void stopLoading();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */