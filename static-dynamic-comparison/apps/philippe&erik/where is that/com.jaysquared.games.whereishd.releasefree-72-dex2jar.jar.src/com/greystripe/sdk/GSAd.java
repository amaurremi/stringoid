package com.greystripe.sdk;

public abstract interface GSAd
{
  public abstract void addListener(GSAdListener paramGSAdListener);
  
  public abstract int getId();
  
  public abstract boolean isAdReady();
  
  public abstract void removeListener(GSAdListener paramGSAdListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */