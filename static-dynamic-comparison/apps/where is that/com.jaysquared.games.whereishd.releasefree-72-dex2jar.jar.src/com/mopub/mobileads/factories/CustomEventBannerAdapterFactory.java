package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;

public class CustomEventBannerAdapterFactory
{
  protected static CustomEventBannerAdapterFactory instance = new CustomEventBannerAdapterFactory();
  
  public static CustomEventBannerAdapter create(MoPubView paramMoPubView, String paramString1, String paramString2)
  {
    return instance.internalCreate(paramMoPubView, paramString1, paramString2);
  }
  
  @Deprecated
  public static void setInstance(CustomEventBannerAdapterFactory paramCustomEventBannerAdapterFactory)
  {
    instance = paramCustomEventBannerAdapterFactory;
  }
  
  protected CustomEventBannerAdapter internalCreate(MoPubView paramMoPubView, String paramString1, String paramString2)
  {
    return new CustomEventBannerAdapter(paramMoPubView, paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventBannerAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */