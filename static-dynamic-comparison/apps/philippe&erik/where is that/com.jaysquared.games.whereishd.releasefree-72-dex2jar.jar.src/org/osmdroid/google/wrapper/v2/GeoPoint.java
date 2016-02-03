package org.osmdroid.google.wrapper.v2;

import com.google.android.gms.maps.model.LatLng;
import org.osmdroid.api.IGeoPoint;

public class GeoPoint
  implements IGeoPoint
{
  private final LatLng mLatLng;
  
  public GeoPoint(LatLng paramLatLng)
  {
    this.mLatLng = paramLatLng;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    return ((GeoPoint)paramObject).mLatLng.equals(this.mLatLng);
  }
  
  public double getLatitude()
  {
    return this.mLatLng.latitude;
  }
  
  public int getLatitudeE6()
  {
    return (int)(this.mLatLng.latitude * 1000000.0D);
  }
  
  public double getLongitude()
  {
    return this.mLatLng.longitude;
  }
  
  public int getLongitudeE6()
  {
    return (int)(this.mLatLng.longitude * 1000000.0D);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */