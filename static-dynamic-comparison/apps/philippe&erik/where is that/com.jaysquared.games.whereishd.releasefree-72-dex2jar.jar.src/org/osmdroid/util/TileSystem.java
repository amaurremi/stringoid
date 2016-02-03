package org.osmdroid.util;

import android.graphics.Point;

public final class TileSystem
{
  public static double GroundResolution(double paramDouble, int paramInt)
  {
    return microsoft.mappoint.TileSystem.GroundResolution(wrap(paramDouble, -90.0D, 90.0D, 180.0D), paramInt);
  }
  
  public static Point LatLongToPixelXY(double paramDouble1, double paramDouble2, int paramInt, Point paramPoint)
  {
    return microsoft.mappoint.TileSystem.LatLongToPixelXY(wrap(paramDouble1, -90.0D, 90.0D, 180.0D), wrap(paramDouble2, -180.0D, 180.0D, 360.0D), paramInt, paramPoint);
  }
  
  public static double MapScale(double paramDouble, int paramInt1, int paramInt2)
  {
    return microsoft.mappoint.TileSystem.MapScale(paramDouble, paramInt1, paramInt2);
  }
  
  public static int MapSize(int paramInt)
  {
    return microsoft.mappoint.TileSystem.MapSize(paramInt);
  }
  
  public static GeoPoint PixelXYToLatLong(int paramInt1, int paramInt2, int paramInt3, GeoPoint paramGeoPoint)
  {
    int i = MapSize(paramInt3);
    return microsoft.mappoint.TileSystem.PixelXYToLatLong((int)wrap(paramInt1, 0.0D, i - 1, i), (int)wrap(paramInt2, 0.0D, i - 1, i), paramInt3, paramGeoPoint);
  }
  
  public static Point PixelXYToTileXY(int paramInt1, int paramInt2, Point paramPoint)
  {
    return microsoft.mappoint.TileSystem.PixelXYToTileXY(paramInt1, paramInt2, paramPoint);
  }
  
  public static Point QuadKeyToTileXY(String paramString, Point paramPoint)
  {
    return microsoft.mappoint.TileSystem.QuadKeyToTileXY(paramString, paramPoint);
  }
  
  public static Point TileXYToPixelXY(int paramInt1, int paramInt2, Point paramPoint)
  {
    return microsoft.mappoint.TileSystem.TileXYToPixelXY(paramInt1, paramInt2, paramPoint);
  }
  
  public static String TileXYToQuadKey(int paramInt1, int paramInt2, int paramInt3)
  {
    return microsoft.mappoint.TileSystem.TileXYToQuadKey(paramInt1, paramInt2, paramInt3);
  }
  
  public static int getTileSize()
  {
    return microsoft.mappoint.TileSystem.getTileSize();
  }
  
  public static void setTileSize(int paramInt)
  {
    microsoft.mappoint.TileSystem.setTileSize(paramInt);
  }
  
  private static double wrap(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (paramDouble2 > paramDouble3) {
      throw new IllegalArgumentException("minValue must be smaller than maxValue: " + paramDouble2 + ">" + paramDouble3);
    }
    if (paramDouble4 > paramDouble3 - paramDouble2 + 1.0D) {
      throw new IllegalArgumentException("interval must be equal or smaller than maxValue-minValue: min: " + paramDouble2 + " max:" + paramDouble3 + " int:" + paramDouble4);
    }
    double d;
    for (;;)
    {
      d = paramDouble1;
      if (paramDouble1 >= paramDouble2) {
        break;
      }
      paramDouble1 += paramDouble4;
    }
    while (d > paramDouble3) {
      d -= paramDouble4;
    }
    return d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/TileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */