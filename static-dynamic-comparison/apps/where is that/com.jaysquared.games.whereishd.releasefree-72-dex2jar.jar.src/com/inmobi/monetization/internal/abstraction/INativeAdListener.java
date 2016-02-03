package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;

public abstract interface INativeAdListener
{
  public abstract void onNativeRequestFailed(IMErrorCode paramIMErrorCode);
  
  public abstract void onNativeRequestSucceeded(IMNative paramIMNative);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/abstraction/INativeAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */