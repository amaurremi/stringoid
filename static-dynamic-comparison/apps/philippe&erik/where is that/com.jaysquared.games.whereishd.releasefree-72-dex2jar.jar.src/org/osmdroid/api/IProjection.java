package org.osmdroid.api;

import android.graphics.Point;

public abstract interface IProjection
{
  public abstract IGeoPoint fromPixels(int paramInt1, int paramInt2);
  
  public abstract IGeoPoint getNorthEast();
  
  public abstract IGeoPoint getSouthWest();
  
  public abstract float metersToEquatorPixels(float paramFloat);
  
  public abstract Point toPixels(IGeoPoint paramIGeoPoint, Point paramPoint);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */