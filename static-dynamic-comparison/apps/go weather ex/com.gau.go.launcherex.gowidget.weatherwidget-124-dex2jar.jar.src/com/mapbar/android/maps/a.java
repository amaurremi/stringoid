package com.mapbar.android.maps;

public final class a
{
  static double a(double paramDouble)
  {
    int j = 0;
    if (paramDouble < 0.0D) {
      paramDouble = -paramDouble;
    }
    for (int i = 1;; i = 0)
    {
      paramDouble -= (paramDouble / 6.283185307179586D) * 6.283185307179586D;
      if (paramDouble > 3.141592653589793D)
      {
        paramDouble -= 3.141592653589793D;
        if (i == 1) {
          i = j;
        }
      }
      for (;;)
      {
        double d1 = paramDouble * paramDouble;
        double d2 = paramDouble * d1;
        double d3 = d2 * d1;
        double d4 = d3 * d1;
        double d5 = d4 * d1;
        d1 = paramDouble - 0.166666666666667D * d2 + 0.00833333333333333D * d3 - 1.98412698412698E-4D * d4 + 2.75573192239859E-6D * d5 - d1 * d5 * 2.50521083854417E-8D;
        paramDouble = d1;
        if (i == 1) {
          paramDouble = -d1;
        }
        return paramDouble;
        i = 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */