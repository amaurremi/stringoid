package com.google.ads;

public abstract interface AdViewListener
{
  public abstract void onAdFetchFailure();
  
  public abstract void onClickAd();
  
  public abstract void onFinishFetchAd();
  
  public abstract void onStartFetchAd();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AdViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */