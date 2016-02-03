package org.osmdroid.google.wrapper;

import org.osmdroid.api.IGeoPoint;

public class GeoPoint
  implements IGeoPoint
{
  private final com.google.android.maps.GeoPoint mGeoPoint;
  
  public GeoPoint(com.google.android.maps.GeoPoint paramGeoPoint)
  {
    this.mGeoPoint = paramGeoPoint;
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
    return ((GeoPoint)paramObject).mGeoPoint.equals(this.mGeoPoint);
  }
  
  public double getLatitude()
  {
    return this.mGeoPoint.getLatitudeE6() * 1.0E-6D;
  }
  
  public int getLatitudeE6()
  {
    return this.mGeoPoint.getLatitudeE6();
  }
  
  public double getLongitude()
  {
    return this.mGeoPoint.getLongitudeE6() * 1.0E-6D;
  }
  
  public int getLongitudeE6()
  {
    return this.mGeoPoint.getLongitudeE6();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */