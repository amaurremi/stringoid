package org.osmdroid.views.util;

import android.graphics.Point;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.util.constants.MapViewConstants;

@Deprecated
public class Mercator
  implements MapViewConstants
{
  static final double DEG2RAD = 0.017453292519943295D;
  
  public static BoundingBoxE6 getBoundingBoxFromCoords(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return new BoundingBoxE6(tile2lat(paramInt2, paramInt5), tile2lon(paramInt3, paramInt5), tile2lat(paramInt4, paramInt5), tile2lon(paramInt1, paramInt5));
  }
  
  public static BoundingBoxE6 getBoundingBoxFromPointInMapTile(Point paramPoint, int paramInt)
  {
    return new BoundingBoxE6(tile2lat(paramPoint.y, paramInt), tile2lon(paramPoint.x + 1, paramInt), tile2lat(paramPoint.y + 1, paramInt), tile2lon(paramPoint.x, paramInt));
  }
  
  public static Point projectGeoPoint(double paramDouble1, double paramDouble2, int paramInt, Point paramPoint)
  {
    if (paramPoint != null) {}
    for (;;)
    {
      paramPoint.x = ((int)Math.floor((180.0D + paramDouble2) / 360.0D * (1 << paramInt)));
      paramPoint.y = ((int)Math.floor((1.0D - Math.log(Math.tan(paramDouble1 * 0.017453292519943295D) + 1.0D / Math.cos(paramDouble1 * 0.017453292519943295D)) / 3.141592653589793D) / 2.0D * (1 << paramInt)));
      return paramPoint;
      paramPoint = new Point(0, 0);
    }
  }
  
  public static Point projectGeoPoint(int paramInt1, int paramInt2, int paramInt3, Point paramPoint)
  {
    return projectGeoPoint(paramInt1 * 1.0E-6D, paramInt2 * 1.0E-6D, paramInt3, paramPoint);
  }
  
  public static Point projectGeoPoint(IGeoPoint paramIGeoPoint, int paramInt, Point paramPoint)
  {
    return projectGeoPoint(paramIGeoPoint.getLatitudeE6() * 1.0E-6D, paramIGeoPoint.getLongitudeE6() * 1.0E-6D, paramInt, paramPoint);
  }
  
  public static GeoPoint projectPoint(int paramInt1, int paramInt2, int paramInt3)
  {
    return new GeoPoint((int)(tile2lat(paramInt2, paramInt3) * 1000000.0D), (int)(tile2lon(paramInt1, paramInt3) * 1000000.0D));
  }
  
  public static double tile2lat(int paramInt1, int paramInt2)
  {
    double d = 3.141592653589793D - 6.283185307179586D * paramInt1 / (1 << paramInt2);
    return 57.29577951308232D * Math.atan(0.5D * (Math.exp(d) - Math.exp(-d)));
  }
  
  public static double tile2lon(int paramInt1, int paramInt2)
  {
    return paramInt1 / (1 << paramInt2) * 360.0D - 180.0D;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/util/Mercator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */