package com.mapbar.android.maps;

import android.graphics.Point;
import com.mapbar.map.MapPoint;

public class GeoPoint
{
  private static double a = 0.1111D;
  private int b;
  private int c;
  
  GeoPoint(double paramDouble1, double paramDouble2)
  {
    this((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public GeoPoint(MapPoint paramMapPoint)
  {
    this(paramMapPoint.getLatitude() * 10, paramMapPoint.getLongitude() * 10);
  }
  
  public int distance(GeoPoint paramGeoPoint)
  {
    int i = (this.b + paramGeoPoint.b) / 2;
    double d1 = (this.c - paramGeoPoint.c) * Math.cos(Math.toRadians(i / 1000000.0D));
    double d2 = this.b - paramGeoPoint.b;
    return (int)(Math.sqrt(d1 * d1 + d2 * d2) * a + 0.5D);
  }
  
  public int getLatitudeE6()
  {
    return this.b;
  }
  
  public int getLongitudeE6()
  {
    return this.c;
  }
  
  public MapPoint getMapPoint()
  {
    return new MapPoint(this.b / 10, this.c / 10);
  }
  
  public Point getPoint()
  {
    return new Point(this.c, this.b);
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return "GeoPoint: Latitude: " + this.b + ", Longitude: " + this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */