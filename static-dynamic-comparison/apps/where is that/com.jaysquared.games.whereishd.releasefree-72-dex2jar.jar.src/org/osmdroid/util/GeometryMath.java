package org.osmdroid.util;

import android.graphics.Point;
import android.graphics.Rect;

public class GeometryMath
{
  public static final double DEG2RAD = 0.017453292519943295D;
  public static final double RAD2DEG = 57.29577951308232D;
  
  private static double Max4(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return Math.ceil(Math.max(Math.max(paramDouble1, paramDouble2), Math.max(paramDouble3, paramDouble4)));
  }
  
  private static double Min4(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return Math.floor(Math.min(Math.min(paramDouble1, paramDouble2), Math.min(paramDouble3, paramDouble4)));
  }
  
  public static final Rect getBoundingBoxForRotatatedRectangle(Rect paramRect1, float paramFloat, Rect paramRect2)
  {
    return getBoundingBoxForRotatatedRectangle(paramRect1, paramRect1.centerX(), paramRect1.centerY(), paramFloat, paramRect2);
  }
  
  public static final Rect getBoundingBoxForRotatatedRectangle(Rect paramRect1, int paramInt1, int paramInt2, float paramFloat, Rect paramRect2)
  {
    Rect localRect = paramRect2;
    if (paramRect2 == null) {
      localRect = new Rect();
    }
    double d2 = paramFloat * 0.017453292519943295D;
    double d1 = Math.sin(d2);
    double d3 = Math.cos(d2);
    double d4 = paramRect1.left - paramInt1;
    double d5 = paramRect1.top - paramInt2;
    d2 = paramInt1 - d4 * d3 + d5 * d1;
    d4 = paramInt2 - d4 * d1 - d5 * d3;
    double d6 = paramRect1.right - paramInt1;
    double d7 = paramRect1.top - paramInt2;
    d5 = paramInt1 - d6 * d3 + d7 * d1;
    d6 = paramInt2 - d6 * d1 - d7 * d3;
    double d8 = paramRect1.left - paramInt1;
    double d9 = paramRect1.bottom - paramInt2;
    d7 = paramInt1 - d8 * d3 + d9 * d1;
    d8 = paramInt2 - d8 * d1 - d9 * d3;
    double d10 = paramRect1.right - paramInt1;
    double d11 = paramRect1.bottom - paramInt2;
    d9 = paramInt1 - d10 * d3 + d11 * d1;
    d1 = paramInt2 - d10 * d1 - d11 * d3;
    localRect.set((int)Min4(d2, d5, d7, d9), (int)Min4(d4, d6, d8, d1), (int)Max4(d2, d5, d7, d9), (int)Max4(d4, d6, d8, d1));
    return localRect;
  }
  
  public static final Rect getBoundingBoxForRotatatedRectangle(Rect paramRect1, Point paramPoint, float paramFloat, Rect paramRect2)
  {
    return getBoundingBoxForRotatatedRectangle(paramRect1, paramPoint.x, paramPoint.y, paramFloat, paramRect2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/GeometryMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */