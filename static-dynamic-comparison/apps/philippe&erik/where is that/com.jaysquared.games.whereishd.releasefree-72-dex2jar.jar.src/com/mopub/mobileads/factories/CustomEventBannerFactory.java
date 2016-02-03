package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory
{
  private static CustomEventBannerFactory instance = new CustomEventBannerFactory();
  
  public static CustomEventBanner create(String paramString)
    throws Exception
  {
    return instance.internalCreate(paramString);
  }
  
  @Deprecated
  public static void setInstance(CustomEventBannerFactory paramCustomEventBannerFactory)
  {
    instance = paramCustomEventBannerFactory;
  }
  
  protected CustomEventBanner internalCreate(String paramString)
    throws Exception
  {
    paramString = Class.forName(paramString).asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[])null);
    paramString.setAccessible(true);
    return (CustomEventBanner)paramString.newInstance(new Object[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/CustomEventBannerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */