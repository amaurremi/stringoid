package org.osmdroid.util;

import android.location.Location;
import android.location.LocationManager;
import org.osmdroid.util.constants.UtilConstants;

public class LocationUtils
  implements UtilConstants
{
  public static Location getLastKnownLocation(LocationManager paramLocationManager)
  {
    if (paramLocationManager == null) {
      paramLocationManager = null;
    }
    Location localLocation2;
    Location localLocation1;
    do
    {
      do
      {
        return paramLocationManager;
        localLocation2 = getLastKnownLocation(paramLocationManager, "gps");
        localLocation1 = getLastKnownLocation(paramLocationManager, "network");
        paramLocationManager = localLocation1;
      } while (localLocation2 == null);
      if (localLocation1 == null) {
        return localLocation2;
      }
      paramLocationManager = localLocation1;
    } while (localLocation1.getTime() > localLocation2.getTime() + 20000L);
    return localLocation2;
  }
  
  private static Location getLastKnownLocation(LocationManager paramLocationManager, String paramString)
  {
    try
    {
      boolean bool = paramLocationManager.isProviderEnabled(paramString);
      if (!bool) {
        return null;
      }
    }
    catch (IllegalArgumentException paramLocationManager)
    {
      return null;
    }
    return paramLocationManager.getLastKnownLocation(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/LocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */