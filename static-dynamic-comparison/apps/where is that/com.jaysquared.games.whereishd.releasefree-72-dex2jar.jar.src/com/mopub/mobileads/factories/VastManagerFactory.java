package com.mopub.mobileads.factories;

import com.mopub.mobileads.util.vast.VastManager;

public class VastManagerFactory
{
  protected static VastManagerFactory instance = new VastManagerFactory();
  
  public static VastManager create()
  {
    return instance.internalCreate();
  }
  
  @Deprecated
  public static void setInstance(VastManagerFactory paramVastManagerFactory)
  {
    instance = paramVastManagerFactory;
  }
  
  public VastManager internalCreate()
  {
    return new VastManager();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/VastManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */