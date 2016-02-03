package org.slf4j;

import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMarkerBinder;

public class MarkerFactory
{
  static IMarkerFactory markerFactory;
  
  static
  {
    try
    {
      markerFactory = StaticMarkerBinder.SINGLETON.getMarkerFactory();
      return;
    }
    catch (Exception localException)
    {
      Util.reportFailure("Could not instantiate instance of class [" + StaticMarkerBinder.SINGLETON.getMarkerFactoryClassStr() + "]", localException);
    }
  }
  
  public static Marker getDetachedMarker(String paramString)
  {
    return markerFactory.getDetachedMarker(paramString);
  }
  
  public static IMarkerFactory getIMarkerFactory()
  {
    return markerFactory;
  }
  
  public static Marker getMarker(String paramString)
  {
    return markerFactory.getMarker(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/MarkerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */