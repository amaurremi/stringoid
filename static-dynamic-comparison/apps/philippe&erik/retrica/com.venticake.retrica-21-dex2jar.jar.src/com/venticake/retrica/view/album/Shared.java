package com.venticake.retrica.view.album;

import android.graphics.Color;

public final class Shared
{
  public static final int INFINITY = Integer.MAX_VALUE;
  public static final int INVALID = -1;
  
  public static int argb(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Color.argb((int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F), (int)(255.0F * paramFloat4));
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static long clamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < paramLong2) {
      return paramLong2;
    }
    if (paramLong1 > paramLong3) {
      return paramLong3;
    }
    return paramLong1;
  }
  
  public static int degreesToExifOrientation(float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    do
    {
      return 1;
      if (paramFloat == 90.0F) {
        return 6;
      }
      if (paramFloat == 180.0F) {
        return 3;
      }
    } while (paramFloat != 270.0F);
    return 8;
  }
  
  public static float exifOrientationToDegrees(int paramInt)
  {
    if (paramInt == 6) {
      return 90.0F;
    }
    if (paramInt == 3) {
      return 180.0F;
    }
    if (paramInt == 8) {
      return 270.0F;
    }
    return 0.0F;
  }
  
  public static boolean isPowerOf2(int paramInt)
  {
    return (-paramInt & paramInt) == paramInt;
  }
  
  public static int midPointIterator(int paramInt)
  {
    if (paramInt != 0)
    {
      int i = (paramInt - 1) / 2;
      if ((paramInt - 1) % 2 == 0) {}
      for (paramInt = 1;; paramInt = -1) {
        return paramInt * (i + 1);
      }
    }
    return 0;
  }
  
  public static int nextPowerOf2(int paramInt)
  {
    paramInt -= 1;
    paramInt |= paramInt >>> 16;
    paramInt |= paramInt >>> 8;
    paramInt |= paramInt >>> 4;
    paramInt |= paramInt >>> 2;
    return (paramInt | paramInt >>> 1) + 1;
  }
  
  public static float normalizePositive(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    float f = paramFloat / 360.0F;
    int i = 0;
    if (paramFloat < 0.0F) {
      i = (int)(f - 1.0F);
    }
    for (;;)
    {
      paramFloat -= i * 360.0F;
      if (paramFloat == 360.0F) {
        break;
      }
      return paramFloat;
      if (paramFloat > 360.0F) {
        i = (int)f;
      }
    }
  }
  
  public static int prevPowerOf2(int paramInt)
  {
    if (isPowerOf2(paramInt)) {
      return nextPowerOf2(paramInt);
    }
    return nextPowerOf2(paramInt) - 1;
  }
  
  public static float scaleToFit(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    paramFloat1 = paramFloat3 / paramFloat1;
    paramFloat2 = paramFloat4 / paramFloat2;
    if (paramBoolean)
    {
      if (paramFloat1 <= paramFloat2) {}
    }
    else {
      while (paramFloat1 < paramFloat2) {
        return paramFloat1;
      }
    }
    return paramFloat2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Shared.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */