package com.jumptap.adtag.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class JtLocation
{
  private static Location currentLocation = null;
  private static JtLocation jtLocationInstance = null;
  private static LocationManager locationManager = null;
  private LocationListener listenerCoarse = null;
  
  private void createLocationListeners()
  {
    this.listenerCoarse = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        JtLocation.setCurrentLocation(paramAnonymousLocation);
        if ((paramAnonymousLocation.getAccuracy() > 1000.0F) && (paramAnonymousLocation.hasAccuracy())) {
          JtLocation.locationManager.removeUpdates(this);
        }
      }
      
      public void onProviderDisabled(String paramAnonymousString) {}
      
      public void onProviderEnabled(String paramAnonymousString) {}
      
      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
    };
  }
  
  public static Location getCurrentLocation()
  {
    return currentLocation;
  }
  
  protected static JtLocation getInstance()
  {
    if (jtLocationInstance == null) {
      jtLocationInstance = new JtLocation();
    }
    return jtLocationInstance;
  }
  
  public static void init(Context paramContext)
  {
    if (locationManager == null) {
      getInstance().registerLocationListeners(paramContext);
    }
  }
  
  private void registerLocationListeners(Context paramContext)
  {
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
      {
        locationManager = (LocationManager)paramContext.getSystemService("location");
        setCurrentLocation(locationManager.getLastKnownLocation("network"));
        if (this.listenerCoarse == null) {
          createLocationListeners();
        }
        locationManager.requestLocationUpdates("network", 500L, 1000.0F, this.listenerCoarse);
        return;
      }
      Log.e("JtAd", "Requires ACCESS_COARSE_LOCATION permission");
      return;
    }
    catch (SecurityException paramContext)
    {
      Log.e("JtAd", "Requires ACCESS_COARSE_LOCATION permission");
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      if (("sdk".equals(Build.MODEL)) || (Build.MODEL.contains("SDK")))
      {
        Log.e("JtAd", "Emulator is not sending location updates.");
        return;
      }
      throw paramContext;
    }
  }
  
  private static void setCurrentLocation(Location paramLocation)
  {
    currentLocation = paramLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */