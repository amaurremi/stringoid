package com.jiubang.goweather.c;

import android.location.Location;
import com.gtp.a.a.b.c;

public class e
{
  public static boolean a(Location paramLocation1, Location paramLocation2)
  {
    float[] arrayOfFloat = new float[2];
    Location.distanceBetween(paramLocation1.getLatitude(), paramLocation1.getLongitude(), paramLocation2.getLatitude(), paramLocation2.getLongitude(), arrayOfFloat);
    c.a("GwLocationManager", "两次定位的距离是:" + arrayOfFloat[0] + "m , bearing: " + arrayOfFloat[1]);
    return arrayOfFloat[0] > 200.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */