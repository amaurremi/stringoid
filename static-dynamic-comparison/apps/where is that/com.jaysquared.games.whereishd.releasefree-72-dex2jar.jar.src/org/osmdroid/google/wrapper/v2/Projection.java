package org.osmdroid.google.wrapper.v2;

import android.graphics.Point;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IProjection;

public class Projection
  implements IProjection
{
  private final Point mPoint = new Point();
  private final com.google.android.gms.maps.Projection mProjection;
  
  public Projection(com.google.android.gms.maps.Projection paramProjection)
  {
    this.mProjection = paramProjection;
  }
  
  public IGeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    this.mPoint.x = paramInt1;
    this.mPoint.y = paramInt2;
    return new GeoPoint(this.mProjection.fromScreenLocation(this.mPoint));
  }
  
  public IGeoPoint getNorthEast()
  {
    return new GeoPoint(this.mProjection.getVisibleRegion().latLngBounds.northeast);
  }
  
  public IGeoPoint getSouthWest()
  {
    return new GeoPoint(this.mProjection.getVisibleRegion().latLngBounds.southwest);
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return 0.0F;
  }
  
  public Point toPixels(IGeoPoint paramIGeoPoint, Point paramPoint)
  {
    paramIGeoPoint = new LatLng(paramIGeoPoint.getLatitude(), paramIGeoPoint.getLongitude());
    paramIGeoPoint = this.mProjection.toScreenLocation(paramIGeoPoint);
    if (paramPoint != null)
    {
      paramPoint.x = paramIGeoPoint.x;
      paramPoint.y = paramIGeoPoint.y;
    }
    return paramIGeoPoint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */