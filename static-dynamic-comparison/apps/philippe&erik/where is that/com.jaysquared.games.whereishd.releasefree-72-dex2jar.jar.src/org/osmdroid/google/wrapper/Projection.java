package org.osmdroid.google.wrapper;

import android.graphics.Point;
import com.google.android.maps.MapView;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IProjection;

public class Projection
  implements IProjection
{
  private final int mHeight;
  private final com.google.android.maps.Projection mProjection;
  private final int mWidth;
  
  public Projection(MapView paramMapView)
  {
    this.mProjection = paramMapView.getProjection();
    this.mWidth = paramMapView.getWidth();
    this.mHeight = paramMapView.getHeight();
  }
  
  public IGeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    return new GeoPoint(this.mProjection.fromPixels(paramInt1, paramInt2));
  }
  
  public IGeoPoint getNorthEast()
  {
    return fromPixels(this.mWidth, 0);
  }
  
  public IGeoPoint getSouthWest()
  {
    return fromPixels(0, this.mHeight);
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return this.mProjection.metersToEquatorPixels(paramFloat);
  }
  
  public Point toPixels(IGeoPoint paramIGeoPoint, Point paramPoint)
  {
    paramIGeoPoint = new com.google.android.maps.GeoPoint(paramIGeoPoint.getLatitudeE6(), paramIGeoPoint.getLongitudeE6());
    return this.mProjection.toPixels(paramIGeoPoint, paramPoint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */