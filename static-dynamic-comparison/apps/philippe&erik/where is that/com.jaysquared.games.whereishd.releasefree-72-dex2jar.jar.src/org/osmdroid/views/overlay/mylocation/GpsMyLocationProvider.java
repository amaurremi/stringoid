package org.osmdroid.views.overlay.mylocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.util.NetworkLocationIgnorer;

public class GpsMyLocationProvider
  implements IMyLocationProvider, LocationListener
{
  private final NetworkLocationIgnorer mIgnorer = new NetworkLocationIgnorer();
  private Location mLocation;
  private final LocationManager mLocationManager;
  private float mLocationUpdateMinDistance = 0.0F;
  private long mLocationUpdateMinTime = 0L;
  private IMyLocationConsumer mMyLocationConsumer;
  
  public GpsMyLocationProvider(Context paramContext)
  {
    this.mLocationManager = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  public Location getLastKnownLocation()
  {
    return this.mLocation;
  }
  
  public float getLocationUpdateMinDistance()
  {
    return this.mLocationUpdateMinDistance;
  }
  
  public long getLocationUpdateMinTime()
  {
    return this.mLocationUpdateMinTime;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (this.mIgnorer.shouldIgnore(paramLocation.getProvider(), System.currentTimeMillis())) {}
    do
    {
      return;
      this.mLocation = paramLocation;
    } while (this.mMyLocationConsumer == null);
    this.mMyLocationConsumer.onLocationChanged(this.mLocation, this);
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public void setLocationUpdateMinDistance(float paramFloat)
  {
    this.mLocationUpdateMinDistance = paramFloat;
  }
  
  public void setLocationUpdateMinTime(long paramLong)
  {
    this.mLocationUpdateMinTime = paramLong;
  }
  
  public boolean startLocationProvider(IMyLocationConsumer paramIMyLocationConsumer)
  {
    this.mMyLocationConsumer = paramIMyLocationConsumer;
    boolean bool = false;
    paramIMyLocationConsumer = this.mLocationManager.getProviders(true).iterator();
    while (paramIMyLocationConsumer.hasNext())
    {
      String str = (String)paramIMyLocationConsumer.next();
      if (("gps".equals(str)) || ("network".equals(str)))
      {
        bool = true;
        this.mLocationManager.requestLocationUpdates(str, this.mLocationUpdateMinTime, this.mLocationUpdateMinDistance, this);
      }
    }
    return bool;
  }
  
  public void stopLocationProvider()
  {
    this.mMyLocationConsumer = null;
    this.mLocationManager.removeUpdates(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/mylocation/GpsMyLocationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */