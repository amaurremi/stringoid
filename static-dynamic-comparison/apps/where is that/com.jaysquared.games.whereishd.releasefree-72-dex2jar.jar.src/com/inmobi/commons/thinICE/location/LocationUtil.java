package com.inmobi.commons.thinICE.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.HashMap;

public final class LocationUtil
{
  private static LocationInfo a(Context paramContext, String paramString)
  {
    paramContext = ((LocationManager)paramContext.getSystemService("location")).getLastKnownLocation(paramString);
    if (paramContext == null) {
      return null;
    }
    paramString = new LocationInfo();
    paramString.time = paramContext.getTime();
    paramString.provider = paramContext.getProvider();
    paramString.latitude = paramContext.getLatitude();
    paramString.longitude = paramContext.getLongitude();
    paramString.accuracy = paramContext.getAccuracy();
    return paramString;
  }
  
  public static HashMap<String, LocationInfo> getLastKnownLocations(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (hasFineLocationPermission(paramContext)) {
      localHashMap.put("gps", a(paramContext, "gps"));
    }
    if (hasCoarseLocationPermission(paramContext)) {
      localHashMap.put("network", a(paramContext, "network"));
    }
    return localHashMap;
  }
  
  public static boolean hasCoarseLocationPermission(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
  }
  
  public static boolean hasFineLocationPermission(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  public static boolean hasLocationPermission(Context paramContext)
  {
    return (hasFineLocationPermission(paramContext)) || (hasCoarseLocationPermission(paramContext));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/location/LocationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */