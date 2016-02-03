package microsoft.mappoint;

import android.graphics.Point;
import org.osmdroid.util.GeoPoint;

public final class TileSystem
{
  private static final double EarthRadius = 6378137.0D;
  private static final double MaxLatitude = 85.05112878D;
  private static final double MaxLongitude = 180.0D;
  private static final double MinLatitude = -85.05112878D;
  private static final double MinLongitude = -180.0D;
  protected static int mTileSize = 256;
  
  private static double Clip(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(Math.max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double GroundResolution(double paramDouble, int paramInt)
  {
    return Math.cos(Clip(paramDouble, -85.05112878D, 85.05112878D) * 3.141592653589793D / 180.0D) * 2.0D * 3.141592653589793D * 6378137.0D / MapSize(paramInt);
  }
  
  public static Point LatLongToPixelXY(double paramDouble1, double paramDouble2, int paramInt, Point paramPoint)
  {
    if (paramPoint == null) {
      paramPoint = new Point();
    }
    for (;;)
    {
      double d = Clip(paramDouble1, -85.05112878D, 85.05112878D);
      paramDouble1 = (180.0D + Clip(paramDouble2, -180.0D, 180.0D)) / 360.0D;
      paramDouble2 = Math.sin(3.141592653589793D * d / 180.0D);
      paramDouble2 = Math.log((1.0D + paramDouble2) / (1.0D - paramDouble2)) / 12.566370614359172D;
      paramInt = MapSize(paramInt);
      paramPoint.x = ((int)Clip(paramInt * paramDouble1 + 0.5D, 0.0D, paramInt - 1));
      paramPoint.y = ((int)Clip(paramInt * (0.5D - paramDouble2) + 0.5D, 0.0D, paramInt - 1));
      return paramPoint;
    }
  }
  
  public static double MapScale(double paramDouble, int paramInt1, int paramInt2)
  {
    return GroundResolution(paramDouble, paramInt1) * paramInt2 / 0.0254D;
  }
  
  public static int MapSize(int paramInt)
  {
    return mTileSize << paramInt;
  }
  
  public static GeoPoint PixelXYToLatLong(float paramFloat1, float paramFloat2, int paramInt, GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      paramGeoPoint = new GeoPoint(0, 0);
    }
    for (;;)
    {
      double d1 = MapSize(paramInt);
      double d2 = Clip(paramFloat1, 0.0D, d1 - 1.0D) / d1;
      paramGeoPoint.setLatitudeE6((int)(1000000.0D * (90.0D - 360.0D * Math.atan(Math.exp(-(0.5D - Clip(paramFloat2, 0.0D, d1 - 1.0D) / d1) * 2.0D * 3.141592653589793D)) / 3.141592653589793D)));
      paramGeoPoint.setLongitudeE6((int)(1000000.0D * (360.0D * (d2 - 0.5D))));
      return paramGeoPoint;
    }
  }
  
  public static Point PixelXYToTileXY(int paramInt1, int paramInt2, Point paramPoint)
  {
    if (paramPoint == null) {
      paramPoint = new Point();
    }
    for (;;)
    {
      paramPoint.x = (paramInt1 / mTileSize);
      paramPoint.y = (paramInt2 / mTileSize);
      return paramPoint;
    }
  }
  
  public static Point QuadKeyToTileXY(String paramString, Point paramPoint)
  {
    if (paramPoint == null) {
      paramPoint = new Point();
    }
    int n;
    int m;
    int k;
    int i2;
    for (;;)
    {
      n = 0;
      m = 0;
      int i1 = paramString.length();
      k = i1;
      if (k <= 0) {
        break;
      }
      i2 = 1 << k - 1;
      i = n;
      j = m;
      switch (paramString.charAt(i1 - k))
      {
      default: 
        throw new IllegalArgumentException("Invalid QuadKey digit sequence.");
      }
    }
    int i = n | i2;
    int j = m;
    for (;;)
    {
      k -= 1;
      n = i;
      m = j;
      break;
      j = m | i2;
      i = n;
      continue;
      i = n | i2;
      j = m | i2;
    }
    paramPoint.set(n, m);
    return paramPoint;
  }
  
  public static Point TileXYToPixelXY(int paramInt1, int paramInt2, Point paramPoint)
  {
    if (paramPoint == null) {
      paramPoint = new Point();
    }
    for (;;)
    {
      paramPoint.x = (mTileSize * paramInt1);
      paramPoint.y = (mTileSize * paramInt2);
      return paramPoint;
    }
  }
  
  public static String TileXYToQuadKey(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramInt3 > 0)
    {
      char c1 = '0';
      int i = 1 << paramInt3 - 1;
      if ((paramInt1 & i) != 0) {
        c1 = (char)49;
      }
      char c2 = c1;
      if ((paramInt2 & i) != 0) {
        c2 = (char)((char)(c1 + '\001') + '\001');
      }
      localStringBuilder.append(c2);
      paramInt3 -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int getTileSize()
  {
    return mTileSize;
  }
  
  public static void setTileSize(int paramInt)
  {
    mTileSize = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/microsoft/mappoint/TileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */