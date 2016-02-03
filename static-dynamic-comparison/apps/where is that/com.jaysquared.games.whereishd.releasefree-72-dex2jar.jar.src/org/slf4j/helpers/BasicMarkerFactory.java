package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

public class BasicMarkerFactory
  implements IMarkerFactory
{
  Map markerMap = new HashMap();
  
  public boolean detachMarker(String paramString)
  {
    if (paramString == null) {}
    while (this.markerMap.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public boolean exists(String paramString)
  {
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = this.markerMap.containsKey(paramString);
      }
      finally {}
    }
  }
  
  public Marker getDetachedMarker(String paramString)
  {
    return new BasicMarker(paramString);
  }
  
  public Marker getMarker(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new IllegalArgumentException("Marker name cannot be null");
      }
      finally {}
    }
    Marker localMarker = (Marker)this.markerMap.get(paramString);
    Object localObject = localMarker;
    if (localMarker == null)
    {
      localObject = new BasicMarker(paramString);
      this.markerMap.put(paramString, localObject);
    }
    return (Marker)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/BasicMarkerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */