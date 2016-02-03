package com.mopub.mobileads.factories;

import com.mopub.mobileads.AdFetcher;
import com.mopub.mobileads.AdViewController;

public class AdFetcherFactory
{
  protected static AdFetcherFactory instance = new AdFetcherFactory();
  
  public static AdFetcher create(AdViewController paramAdViewController, String paramString)
  {
    return instance.internalCreate(paramAdViewController, paramString);
  }
  
  @Deprecated
  public static void setInstance(AdFetcherFactory paramAdFetcherFactory)
  {
    instance = paramAdFetcherFactory;
  }
  
  protected AdFetcher internalCreate(AdViewController paramAdViewController, String paramString)
  {
    return new AdFetcher(paramAdViewController, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/AdFetcherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */