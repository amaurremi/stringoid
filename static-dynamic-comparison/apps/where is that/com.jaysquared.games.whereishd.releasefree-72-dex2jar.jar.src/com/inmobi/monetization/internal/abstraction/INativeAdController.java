package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.NativeAdRequest;
import com.inmobi.monetization.internal.NativeAdResponse;

public abstract interface INativeAdController
{
  public abstract void onAdRequestFailed(NativeAdRequest paramNativeAdRequest, IMErrorCode paramIMErrorCode);
  
  public abstract void onAdRequestSucceded(NativeAdRequest paramNativeAdRequest, NativeAdResponse paramNativeAdResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/abstraction/INativeAdController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */