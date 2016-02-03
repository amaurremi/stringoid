package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory
{
  protected static MoPubViewFactory instance = new MoPubViewFactory();
  
  public static MoPubView create(Context paramContext)
  {
    return instance.internalCreate(paramContext);
  }
  
  @Deprecated
  public static void setInstance(MoPubViewFactory paramMoPubViewFactory)
  {
    instance = paramMoPubViewFactory;
  }
  
  protected MoPubView internalCreate(Context paramContext)
  {
    return new MoPubView(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/MoPubViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */