package org.osmdroid.google.wrapper;

import com.google.android.maps.GeoPoint;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;

public class MapController
  implements IMapController
{
  private final com.google.android.maps.MapController mController;
  
  public MapController(com.google.android.maps.MapController paramMapController)
  {
    this.mController = paramMapController;
  }
  
  public void animateTo(IGeoPoint paramIGeoPoint)
  {
    this.mController.animateTo(new GeoPoint(paramIGeoPoint.getLatitudeE6(), paramIGeoPoint.getLongitudeE6()));
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    this.mController.scrollBy(paramInt1, paramInt2);
  }
  
  public void setCenter(IGeoPoint paramIGeoPoint)
  {
    this.mController.setCenter(new GeoPoint(paramIGeoPoint.getLatitudeE6(), paramIGeoPoint.getLongitudeE6()));
  }
  
  public int setZoom(int paramInt)
  {
    return this.mController.setZoom(paramInt);
  }
  
  public void stopAnimation(boolean paramBoolean)
  {
    this.mController.stopAnimation(paramBoolean);
  }
  
  public void stopPanning()
  {
    this.mController.stopPanning();
  }
  
  public boolean zoomIn()
  {
    return this.mController.zoomIn();
  }
  
  public boolean zoomInFixing(int paramInt1, int paramInt2)
  {
    return this.mController.zoomInFixing(paramInt1, paramInt2);
  }
  
  public boolean zoomOut()
  {
    return this.mController.zoomOut();
  }
  
  public boolean zoomOutFixing(int paramInt1, int paramInt2)
  {
    return this.mController.zoomOutFixing(paramInt1, paramInt2);
  }
  
  public void zoomToSpan(int paramInt1, int paramInt2)
  {
    this.mController.zoomToSpan(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/MapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */