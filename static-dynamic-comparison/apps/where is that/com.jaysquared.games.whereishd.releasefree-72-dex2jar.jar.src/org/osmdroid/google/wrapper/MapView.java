package org.osmdroid.google.wrapper;

import android.content.Context;
import android.util.AttributeSet;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.api.IMapView;
import org.osmdroid.api.IProjection;

public class MapView
  implements IMapView
{
  private final com.google.android.maps.MapView mMapView;
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(new com.google.android.maps.MapView(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(new com.google.android.maps.MapView(paramContext, paramAttributeSet, paramInt));
  }
  
  public MapView(Context paramContext, String paramString)
  {
    this(new com.google.android.maps.MapView(paramContext, paramString));
  }
  
  public MapView(com.google.android.maps.MapView paramMapView)
  {
    this.mMapView = paramMapView;
  }
  
  public IMapController getController()
  {
    return new MapController(this.mMapView.getController());
  }
  
  public int getLatitudeSpan()
  {
    return this.mMapView.getLatitudeSpan();
  }
  
  public int getLongitudeSpan()
  {
    return this.mMapView.getLongitudeSpan();
  }
  
  public IGeoPoint getMapCenter()
  {
    return new GeoPoint(this.mMapView.getMapCenter());
  }
  
  public int getMaxZoomLevel()
  {
    return this.mMapView.getMaxZoomLevel();
  }
  
  public IProjection getProjection()
  {
    return new Projection(this.mMapView);
  }
  
  public int getZoomLevel()
  {
    return this.mMapView.getZoomLevel();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mMapView.setBackgroundColor(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */