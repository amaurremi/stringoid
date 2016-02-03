package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;

public class CustomEventInterstitialAdapterFactory
{
  protected static CustomEventInterstitialAdapterFactory instance = new CustomEventInterstitialAdapterFactory();
  
  public static CustomEventInterstitialAdapter create(MoPubInterstitial paramMoPubInterstitial, String paramString1, String paramString2)
  {
    return instance.internalCreate(paramMoPubInterstitial, paramString1, paramString2);
  }
  
  @Deprecated
  public static void setInstance(CustomEventInterstitialAdapterFactory paramCustomEventInterstitialAdapterFactory)
  {
    instance = paramCustomEventInterstitialAdapterFactory;
  }
  
  protected CustomEventInterstitialAdapter internalCreate(MoPubInterstitial paramMoPubInterstitial, String paramString1, String paramString2)
  {
    return new CustomEventInterstitialAdapter(paramMoPubInterstitial, paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventInterstitialAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */