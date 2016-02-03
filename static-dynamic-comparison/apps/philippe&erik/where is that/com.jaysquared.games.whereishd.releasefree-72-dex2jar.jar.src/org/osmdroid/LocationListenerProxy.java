package org.osmdroid;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

public class LocationListenerProxy
  implements LocationListener
{
  private LocationListener mListener = null;
  private final LocationManager mLocationManager;
  
  public LocationListenerProxy(LocationManager paramLocationManager)
  {
    this.mLocationManager = paramLocationManager;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (this.mListener != null) {
      this.mListener.onLocationChanged(paramLocation);
    }
  }
  
  public void onProviderDisabled(String paramString)
  {
    if (this.mListener != null) {
      this.mListener.onProviderDisabled(paramString);
    }
  }
  
  public void onProviderEnabled(String paramString)
  {
    if (this.mListener != null) {
      this.mListener.onProviderEnabled(paramString);
    }
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.mListener != null) {
      this.mListener.onStatusChanged(paramString, paramInt, paramBundle);
    }
  }
  
  public boolean startListening(LocationListener paramLocationListener, long paramLong, float paramFloat)
  {
    boolean bool = false;
    this.mListener = paramLocationListener;
    paramLocationListener = this.mLocationManager.getProviders(true).iterator();
    while (paramLocationListener.hasNext())
    {
      String str = (String)paramLocationListener.next();
      if (("gps".equals(str)) || ("network".equals(str)))
      {
        bool = true;
        this.mLocationManager.requestLocationUpdates(str, paramLong, paramFloat, this);
      }
    }
    return bool;
  }
  
  public void stopListening()
  {
    this.mListener = null;
    this.mLocationManager.removeUpdates(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/LocationListenerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */