package com.parse;

import android.location.Criteria;

public class ParseGeoPoint
{
  static double EARTH_MEAN_RADIUS_KM = 6371.0D;
  static double EARTH_MEAN_RADIUS_MILE = 3958.8D;
  private double latitude = 0.0D;
  private double longitude = 0.0D;
  
  public ParseGeoPoint() {}
  
  public ParseGeoPoint(double paramDouble1, double paramDouble2)
  {
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
  }
  
  public static void getCurrentLocationInBackground(long paramLong, Criteria paramCriteria, LocationCallback paramLocationCallback)
  {
    Parse.callbackOnMainThreadAsync(LocationNotifier.getCurrentLocationAsync(paramLong, paramCriteria), paramLocationCallback);
  }
  
  public static void getCurrentLocationInBackground(long paramLong, LocationCallback paramLocationCallback)
  {
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(0);
    localCriteria.setPowerRequirement(0);
    getCurrentLocationInBackground(paramLong, localCriteria, paramLocationCallback);
  }
  
  public double distanceInKilometersTo(ParseGeoPoint paramParseGeoPoint)
  {
    return distanceInRadiansTo(paramParseGeoPoint) * EARTH_MEAN_RADIUS_KM;
  }
  
  public double distanceInMilesTo(ParseGeoPoint paramParseGeoPoint)
  {
    return distanceInRadiansTo(paramParseGeoPoint) * EARTH_MEAN_RADIUS_MILE;
  }
  
  public double distanceInRadiansTo(ParseGeoPoint paramParseGeoPoint)
  {
    double d1 = this.latitude * 0.017453292519943295D;
    double d4 = this.longitude;
    double d2 = paramParseGeoPoint.getLatitude() * 0.017453292519943295D;
    double d5 = paramParseGeoPoint.getLongitude();
    double d3 = Math.sin((d1 - d2) / 2.0D);
    d4 = Math.sin((d4 * 0.017453292519943295D - d5 * 0.017453292519943295D) / 2.0D);
    return 2.0D * Math.asin(Math.sqrt(Math.min(1.0D, d3 * d3 + Math.cos(d1) * Math.cos(d2) * d4 * d4)));
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public void setLatitude(double paramDouble)
  {
    if ((paramDouble > 90.0D) || (paramDouble < -90.0D)) {
      throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
    }
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    if ((paramDouble > 180.0D) || (paramDouble < -180.0D)) {
      throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
    }
    this.longitude = paramDouble;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseGeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */