package com.inmobi.commons.data;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.List;

public class LocationInfo
{
  private static LocationManager a;
  private static boolean b;
  private static double c;
  private static double d;
  private static double e;
  private static boolean f;
  private static long g;
  
  private static LocationManager a()
  {
    try
    {
      LocationManager localLocationManager = a;
      return localLocationManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void a(double paramDouble)
  {
    c = paramDouble;
  }
  
  private static void a(long paramLong)
  {
    g = paramLong;
  }
  
  static void a(Location paramLocation)
  {
    if (paramLocation != null)
    {
      b(true);
      a(paramLocation.getLatitude());
      b(paramLocation.getLongitude());
      c(paramLocation.getAccuracy());
      a(paramLocation.getTime());
    }
  }
  
  private static void a(LocationManager paramLocationManager)
  {
    try
    {
      a = paramLocationManager;
      return;
    }
    finally
    {
      paramLocationManager = finally;
      throw paramLocationManager;
    }
  }
  
  static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  private static Location b()
  {
    if (a() == null) {
      a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
    }
    if (a() != null)
    {
      LocationManager localLocationManager = a();
      List localList = localLocationManager.getProviders(true);
      int i = localList.size() - 1;
      while (i >= 0)
      {
        Object localObject = (String)localList.get(i);
        if (localLocationManager.isProviderEnabled((String)localObject))
        {
          localObject = localLocationManager.getLastKnownLocation((String)localObject);
          if (localObject != null) {
            return (Location)localObject;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  private static void b(double paramDouble)
  {
    d = paramDouble;
  }
  
  static void b(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  private static void c(double paramDouble)
  {
    e = paramDouble;
  }
  
  public static long getGeoTS()
  {
    return g;
  }
  
  public static double getLat()
  {
    return c;
  }
  
  public static double getLocAccuracy()
  {
    return e;
  }
  
  public static double getLon()
  {
    return d;
  }
  
  public static boolean isLocationDeniedByUser()
  {
    return b;
  }
  
  public static boolean isValidGeoInfo()
  {
    return f;
  }
  
  public static void updateBestKnownLocation()
  {
    try
    {
      if (a() == null) {
        a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
      }
      if (a() != null)
      {
        Object localObject1 = a();
        Object localObject2 = new Criteria();
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          ((Criteria)localObject2).setAccuracy(1);
        }
        for (;;)
        {
          ((Criteria)localObject2).setCostAllowed(false);
          localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, true);
          if ((isValidGeoInfo()) || (localObject2 == null)) {
            break;
          }
          localObject2 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
          Log.debug("[InMobi]-4.1.1", "lastBestKnownLocation: " + localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = b();
            Log.debug("[InMobi]-4.1.1", "lastKnownLocation: " + localObject1);
          }
          a((Location)localObject1);
          return;
          if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ((Criteria)localObject2).setAccuracy(2);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-4.1.1", "Error getting the Location Info ", localException);
    }
  }
  
  public static void verifyLocationPermission()
  {
    int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
    int j = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    if ((i != 0) && (j != 0))
    {
      a(true);
      return;
    }
    a(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/data/LocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */