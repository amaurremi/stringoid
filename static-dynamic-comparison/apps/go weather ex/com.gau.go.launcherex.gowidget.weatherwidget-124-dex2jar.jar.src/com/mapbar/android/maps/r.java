package com.mapbar.android.maps;

public final class r
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
    double[] arrayOfDouble;
    double d1;
    double d2;
    try
    {
      arrayOfDouble = new double[2];
      double d3 = 0.0D;
      double d4 = 0.0D;
      arrayOfDouble[0] = paramArrayOfDouble[0];
      arrayOfDouble[1] = paramArrayOfDouble[1];
      double d5 = arrayOfDouble[0];
      double d6 = arrayOfDouble[1];
      double d7 = 0.166666666666667D * d5;
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
        d6 += (30.0D * Math.sin(15.707963267948966D * d5) + 20.0D * Math.sin(72.25663103256524D) / arrayOfDouble[2]) * 0.6667D;
        d1 = d4;
        d2 = d3;
        d7 = Math.sin(34.55751918948772D * d5);
        d1 = d4;
        d2 = d3;
        double d8 = Math.sin(69.11503837897544D * d5);
        d1 = d4;
        d2 = d3;
        double d9 = Math.sin(25.132741228718345D * d6);
        d1 = d4;
        d2 = d3;
        d3 = Math.sin(9.42477796076938D * d6);
        arrayOfDouble[0] = (d5 + (150.0D * d7 + 20.0D * d8) * 0.6667D);
        arrayOfDouble[1] = (d6 + ((10.0D * d9 + 20.0D * d3) * 0.6667D + d4));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (a)
          {
            paramArrayOfDouble = b.a(paramArrayOfDouble);
            arrayOfDouble[0] = (d2 + paramArrayOfDouble[0]);
            arrayOfDouble[1] = (d1 + paramArrayOfDouble[1]);
          }
        }
      }
      return arrayOfDouble;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */