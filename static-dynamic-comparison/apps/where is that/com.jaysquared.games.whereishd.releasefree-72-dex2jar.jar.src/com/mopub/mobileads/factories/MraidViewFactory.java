package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.MraidView;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.PlacementType;

public class MraidViewFactory
{
  protected static MraidViewFactory instance = new MraidViewFactory();
  
  public static MraidView create(Context paramContext, AdConfiguration paramAdConfiguration)
  {
    return instance.internalCreate(paramContext, paramAdConfiguration);
  }
  
  public static MraidView create(Context paramContext, AdConfiguration paramAdConfiguration, MraidView.ExpansionStyle paramExpansionStyle, MraidView.NativeCloseButtonStyle paramNativeCloseButtonStyle, MraidView.PlacementType paramPlacementType)
  {
    return instance.internalCreate(paramContext, paramAdConfiguration, paramExpansionStyle, paramNativeCloseButtonStyle, paramPlacementType);
  }
  
  @Deprecated
  public static void setInstance(MraidViewFactory paramMraidViewFactory)
  {
    instance = paramMraidViewFactory;
  }
  
  protected MraidView internalCreate(Context paramContext, AdConfiguration paramAdConfiguration)
  {
    return new MraidView(paramContext, paramAdConfiguration);
  }
  
  protected MraidView internalCreate(Context paramContext, AdConfiguration paramAdConfiguration, MraidView.ExpansionStyle paramExpansionStyle, MraidView.NativeCloseButtonStyle paramNativeCloseButtonStyle, MraidView.PlacementType paramPlacementType)
  {
    return new MraidView(paramContext, paramAdConfiguration, paramExpansionStyle, paramNativeCloseButtonStyle, paramPlacementType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/factories/MraidViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */