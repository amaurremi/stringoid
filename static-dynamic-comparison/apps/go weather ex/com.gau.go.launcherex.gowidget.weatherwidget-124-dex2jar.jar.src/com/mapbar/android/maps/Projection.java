package com.mapbar.android.maps;

import android.graphics.Point;

public abstract interface Projection
{
  public abstract GeoPoint fromPixels(int paramInt1, int paramInt2);
  
  public abstract float metersToEquatorPixels(float paramFloat);
  
  public abstract Point toPixels(GeoPoint paramGeoPoint, Point paramPoint);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */