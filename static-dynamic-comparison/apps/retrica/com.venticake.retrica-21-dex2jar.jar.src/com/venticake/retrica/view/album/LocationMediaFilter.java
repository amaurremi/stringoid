package com.venticake.retrica.view.album;

public class LocationMediaFilter
  extends MediaFilter
{
  public static final int EARTH_RADIUS_METERS = 6378137;
  public static final int LAT_MAX = 90;
  public static final int LAT_MIN = -90;
  public static final int LON_MAX = 180;
  public static final int LON_MIN = -180;
  private double mCenterLat;
  private double mCenterLon;
  private double mRadius;
  
  LocationMediaFilter(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.mCenterLat = paramDouble1;
    this.mCenterLon = paramDouble2;
    this.mRadius = paramDouble3;
  }
  
  LocationMediaFilter(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.mCenterLat = centerLat(paramDouble1, paramDouble3);
    this.mCenterLon = centerLon(paramDouble2, paramDouble4);
    this.mRadius = distanceBetween(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static final double centerLat(double paramDouble1, double paramDouble2)
  {
    return centerOfAngles(paramDouble1, paramDouble2, 90);
  }
  
  public static final double centerLon(double paramDouble1, double paramDouble2)
  {
    return centerOfAngles(paramDouble1, paramDouble2, 180);
  }
  
  private static final double centerOfAngles(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (Math.abs(paramDouble1 - paramDouble2) > paramInt) {}
    for (int i = 1;; i = 0)
    {
      paramDouble2 = (paramDouble1 + paramDouble2) * 0.5D;
      paramDouble1 = paramDouble2;
      if (i != 0) {
        paramDouble1 = (paramDouble2 + paramInt) % paramInt;
      }
      return paramDouble1;
    }
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = Math.toRadians(paramDouble3 - paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
    paramDouble4 = Math.sin(d1 / 2.0D);
    d1 = Math.sin(d1 / 2.0D);
    paramDouble1 = Math.cos(Math.toRadians(paramDouble1));
    paramDouble3 = Math.cos(Math.toRadians(paramDouble3));
    double d2 = Math.sin(paramDouble2 / 2.0D);
    paramDouble1 = d1 * paramDouble4 + Math.sin(paramDouble2 / 2.0D) * (paramDouble1 * paramDouble3 * d2);
    return Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * 6378137.0D;
  }
  
  public static final double toKm(double paramDouble)
  {
    return paramDouble / 1000.0D;
  }
  
  public static final double toMile(double paramDouble)
  {
    return paramDouble / 1609.0D;
  }
  
  public boolean pass(MediaItem paramMediaItem)
  {
    return distanceBetween(this.mCenterLat, this.mCenterLon, paramMediaItem.mLatitude, paramMediaItem.mLongitude) <= this.mRadius;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/LocationMediaFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */