package com.gau.go.launcherex.goweather.a;

import android.text.TextUtils;

public class e
{
  public static double[] a(String paramString)
  {
    double[] arrayOfDouble = new double[2];
    double[] tmp5_4 = arrayOfDouble;
    tmp5_4[0] = -10000.0D;
    double[] tmp11_5 = tmp5_4;
    tmp11_5[1] = -10000.0D;
    tmp11_5;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("#")))
    {
      paramString = paramString.split("#");
      if (paramString.length != 2) {}
    }
    try
    {
      arrayOfDouble[0] = Double.valueOf(paramString[0]).doubleValue();
      arrayOfDouble[1] = Double.valueOf(paramString[1]).doubleValue();
      return arrayOfDouble;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return arrayOfDouble;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */