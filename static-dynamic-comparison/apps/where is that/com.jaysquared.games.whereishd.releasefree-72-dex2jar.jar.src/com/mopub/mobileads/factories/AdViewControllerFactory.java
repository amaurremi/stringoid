package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory
{
  protected static AdViewControllerFactory instance = new AdViewControllerFactory();
  
  public static AdViewController create(Context paramContext, MoPubView paramMoPubView)
  {
    return instance.internalCreate(paramContext, paramMoPubView);
  }
  
  @Deprecated
  public static void setInstance(AdViewControllerFactory paramAdViewControllerFactory)
  {
    instance = paramAdViewControllerFactory;
  }
  
  protected AdViewController internalCreate(Context paramContext, MoPubView paramMoPubView)
  {
    return new AdViewController(paramContext, paramMoPubView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/AdViewControllerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */