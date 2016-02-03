package com.mapbar.android.maps;

public final class b
{
  private static boolean a = true;
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    d1 = 0.0D;
    try
    {
      Thread.sleep((Math.random() * 100.0D + 50.0D));
      double d3 = System.currentTimeMillis() % 91L / 1.0E7D;
      double d2 = System.currentTimeMillis() % 117L / 1.0E7D;
      d3 = d3 + (30.0D * Math.sin(18.84955592153876D * paramDouble2) + 20.0D * Math.sin(6.283185307179586D * paramDouble2)) * 0.6667D + paramDouble1;
      paramDouble1 = (50.0D * Math.sin(15.707963267948966D * d3) + 20.0D * Math.sin(72.25663103256524D) / paramDouble1) * 0.6667D + paramDouble2;
      Math.sin(34.55751918948772D * d3);
      Math.sin(d3 * 69.11503837897544D);
      paramDouble2 = Math.sin(25.132741228718345D * paramDouble1);
      d3 = Math.sin(9.42477796076938D * paramDouble1);
      paramDouble1 = (d3 * 20.0D + 110.0D * paramDouble2) * 0.6667D + d2 + paramDouble1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramDouble1 = d1;
      }
    }
    finally {}
    return paramDouble1;
  }
  
  public static double[] a(double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble1;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d1;
    double d2;
    try
    {
      arrayOfDouble1 = new double[2];
      d3 = 0.0D;
      d4 = 0.0D;
      arrayOfDouble1[0] = paramArrayOfDouble[0];
      arrayOfDouble1[1] = paramArrayOfDouble[1];
      d5 = arrayOfDouble1[0];
      d6 = arrayOfDouble1[1];
      d7 = 0.166666666666667D * d5;
      d1 = d4;
      d2 = d3;
      try
      {
        d6 += a(d7, 0.00833333333333333D * d6 + d7);
        d1 = d4;
        d2 = d3;
        d3 = System.currentTimeMillis() % 91L << 1;
        d1 = d4;
        d2 = d3;
        d3 /= 1.0E7D;
        d1 = d4;
        d2 = d3;
        d4 = System.currentTimeMillis() % 117L << 1;
        d1 = d4;
        d2 = d3;
        d4 /= 1.0E7D;
        d1 = d4;
        d2 = d3;
        d5 += (20.0D * Math.sin(18.84955592153876D * d6) + 20.0D * Math.sin(6.283185307179586D * d6)) * 0.6667D + d3;
        d1 = d4;
        d2 = d3;
        d6 += (30.0D * Math.sin(15.707963267948966D * d5) + 20.0D * Math.sin(72.25663103256524D) / arrayOfDouble1[2]) * 0.6667D;
        d1 = d4;
        d2 = d3;
        d7 = Math.sin(34.55751918948772D * d5);
        d1 = d4;
        d2 = d3;
        d8 = Math.sin(69.11503837897544D * d5);
        d1 = d4;
        d2 = d3;
        d9 = Math.sin(25.132741228718345D * d6);
        d1 = d4;
        d2 = d3;
        d3 = Math.sin(9.42477796076938D * d6);
        arrayOfDouble1[0] = (d5 + (150.0D * d7 + 20.0D * d8) * 0.6667D);
        arrayOfDouble1[1] = (d6 + ((10.0D * d9 + 20.0D * d3) * 0.6667D + d4));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          double d8;
          double d9;
          if (a)
          {
            double[] arrayOfDouble2 = new double[2];
            double d13 = paramArrayOfDouble[0];
            d3 = paramArrayOfDouble[1];
            d4 = d13 - 105.0D;
            d5 = d3 - 35.0D;
            double d14 = Math.sqrt(Math.sqrt(d4 * d4));
            double d15 = a.a(18.84955592153876D * d4);
            double d16 = a.a(6.283185307179586D * d4);
            double d17 = a.a(3.141592653589793D * d4);
            double d18 = a.a(3.141592653589793D * d4 / 3.0D);
            double d19 = a.a(3.141592653589793D * d4 / 12.0D);
            double d20 = a.a(3.141592653589793D * d4 / 30.0D);
            d6 = Math.sqrt(Math.sqrt(d4 * d4));
            d7 = a.a(18.84955592153876D * d4);
            d8 = a.a(d4 * 6.283185307179586D);
            d9 = a.a(3.141592653589793D * d5);
            double d10 = a.a(3.141592653589793D * d5 / 3.0D);
            double d11 = a.a(3.141592653589793D * d5 / 12.0D);
            double d12 = a.a(d5 * 3.141592653589793D / 30.0D);
            double d21 = a.a(3.141592653589793D * d3 / 180.0D);
            arrayOfDouble2[0] = (d13 + (300.0D + d4 + 2.0D * d5 + 0.1D * d4 * d4 + 0.1D * d4 * d5 + 0.1D * d14 + (20.0D * d15 + 20.0D * d16) * 0.6667D + (20.0D * d17 + 40.0D * d18) * 0.6667D + (150.0D * d19 + 300.0D * d20) * 0.6667D) * 180.0D / (6378245.0D / Math.sqrt(1.0D - d21 * (0.00669342D * d21)) * Math.cos(3.141592653589793D * d3 / 180.0D) * 3.141592653589793D));
            d13 = a.a(3.141592653589793D * d3 / 180.0D);
            d13 = 1.0D - d13 * (0.00669342D * d13);
            arrayOfDouble2[1] = (d3 + ((d8 * 20.0D + 20.0D * d7) * 0.6667D + (-100.0D + 2.0D * d4 + 3.0D * d5 + 0.2D * d5 * d5 + 0.1D * d4 * d5 + 0.2D * d6) + (20.0D * d9 + 40.0D * d10) * 0.6667D + (d12 * 320.0D + 160.0D * d11) * 0.6667D) * 180.0D / (6335552.7273521D / (d13 * Math.sqrt(d13)) * 3.141592653589793D));
            arrayOfDouble1[0] = (d2 + arrayOfDouble2[0]);
            arrayOfDouble1[1] = (d1 + arrayOfDouble2[1]);
          }
        }
      }
      return arrayOfDouble1;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */