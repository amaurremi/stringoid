package com.gau.go.launcherex.goweather.a.a;

import com.google.android.gms.maps.model.LatLng;

public class a
{
  private final b a = new b(128.0D, 128.0D);
  private final double b = 0.7111111283302307D;
  private final double c = 40.74366543152521D;
  
  public static double a(double paramDouble)
  {
    return paramDouble / 0.017453292519943295D;
  }
  
  public LatLng a(b paramb)
  {
    double d = (paramb.b - this.a.b) / this.b;
    return new LatLng(a(Math.atan(Math.exp((paramb.a - this.a.a) / -this.c)) * 2.0D - 1.5707963267948966D), d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */