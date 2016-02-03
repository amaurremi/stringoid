package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

public class CustomEventInterstitialFactory
{
  private static CustomEventInterstitialFactory instance = new CustomEventInterstitialFactory();
  
  public static CustomEventInterstitial create(String paramString)
    throws Exception
  {
    return instance.internalCreate(paramString);
  }
  
  @Deprecated
  public static void setInstance(CustomEventInterstitialFactory paramCustomEventInterstitialFactory)
  {
    instance = paramCustomEventInterstitialFactory;
  }
  
  protected CustomEventInterstitial internalCreate(String paramString)
    throws Exception
  {
    paramString = Class.forName(paramString).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor((Class[])null);
    paramString.setAccessible(true);
    return (CustomEventInterstitial)paramString.newInstance(new Object[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventInterstitialFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */