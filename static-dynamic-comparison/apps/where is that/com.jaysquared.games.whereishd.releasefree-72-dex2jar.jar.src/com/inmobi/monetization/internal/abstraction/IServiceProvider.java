package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.internal.GetLtvpRulesRequest;
import com.inmobi.monetization.internal.NativeAdRequest;

public abstract interface IServiceProvider
{
  public abstract void getLtvpRule(GetLtvpRulesRequest paramGetLtvpRulesRequest, IGetLtvpRuleRequestListener paramIGetLtvpRuleRequestListener);
  
  public abstract void getNativeAd(NativeAdRequest paramNativeAdRequest, INativeAdController paramINativeAdController);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/abstraction/IServiceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */