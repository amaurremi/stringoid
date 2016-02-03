package com.mopub.mobileads.factories;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.ViewGestureDetector;

public class ViewGestureDetectorFactory
{
  protected static ViewGestureDetectorFactory instance = new ViewGestureDetectorFactory();
  
  public static ViewGestureDetector create(Context paramContext, View paramView, AdConfiguration paramAdConfiguration)
  {
    return instance.internalCreate(paramContext, paramView, paramAdConfiguration);
  }
  
  @Deprecated
  public static void setInstance(ViewGestureDetectorFactory paramViewGestureDetectorFactory)
  {
    instance = paramViewGestureDetectorFactory;
  }
  
  protected ViewGestureDetector internalCreate(Context paramContext, View paramView, AdConfiguration paramAdConfiguration)
  {
    return new ViewGestureDetector(paramContext, paramView, paramAdConfiguration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/ViewGestureDetectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */