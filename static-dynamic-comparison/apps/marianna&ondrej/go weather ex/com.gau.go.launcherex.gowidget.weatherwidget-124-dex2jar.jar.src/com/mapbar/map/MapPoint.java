package com.mapbar.map;

import android.app.PendingIntent;
import com.mapbar.android.maps.G;

public class MapPoint
{
  private int a;
  private int b;
  
  public MapPoint(double paramDouble1, double paramDouble2)
  {
    int i = (int)(paramDouble1 * 100000.0D);
    double[] arrayOfDouble = G.a((int)(paramDouble2 * 100000.0D), i);
    arrayOfDouble = a.a(arrayOfDouble[0], arrayOfDouble[1]);
    this.b = ((int)(arrayOfDouble[0] * 100000.0D));
    this.a = ((int)(arrayOfDouble[1] * 100000.0D));
  }
  
  public MapPoint(double paramDouble1, double paramDouble2, PendingIntent paramPendingIntent)
  {
    if ((paramPendingIntent != null) && ((paramPendingIntent.getTargetPackage().startsWith("com.mapbar")) || (paramPendingIntent.getTargetPackage().startsWith("com.aloqa.me")) || (paramPendingIntent.getTargetPackage().startsWith("com.platomix"))))
    {
      paramPendingIntent = a.a(paramDouble1, paramDouble2);
      this.b = ((int)(paramPendingIntent[0] * 100000.0D));
      this.a = ((int)(paramPendingIntent[1] * 100000.0D));
    }
  }
  
  public MapPoint(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int getLatitude()
  {
    return this.a;
  }
  
  public int getLongitude()
  {
    return this.b;
  }
  
  public void setLatitude(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setLongitude(int paramInt)
  {
    this.b = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b).append(",").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/map/MapPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */