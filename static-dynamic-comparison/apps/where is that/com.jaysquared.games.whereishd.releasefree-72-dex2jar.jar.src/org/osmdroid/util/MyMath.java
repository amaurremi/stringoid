package org.osmdroid.util;

import org.osmdroid.views.util.constants.MathConstants;

public class MyMath
  implements MathConstants
{
  public static double gudermann(double paramDouble)
  {
    return 57.295780181884766D * Math.atan(Math.sinh(paramDouble));
  }
  
  public static double gudermannInverse(double paramDouble)
  {
    return Math.log(Math.tan(0.7853981852531433D + 0.01745329238474369D * paramDouble / 2.0D));
  }
  
  public static int mod(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > 0)
    {
      paramInt1 %= paramInt2;
      return paramInt1;
    }
    for (;;)
    {
      paramInt1 = i;
      if (i >= 0) {
        break;
      }
      i += paramInt2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/MyMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */