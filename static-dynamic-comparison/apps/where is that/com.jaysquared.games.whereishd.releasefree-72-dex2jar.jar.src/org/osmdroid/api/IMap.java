package org.osmdroid.api;

public abstract interface IMap
{
  public abstract void addMarker(Marker paramMarker);
  
  public abstract void addPointsToPolyline(int paramInt, IGeoPoint... paramVarArgs);
  
  public abstract int addPolyline(Polyline paramPolyline);
  
  public abstract void clear();
  
  public abstract void clearPolyline(int paramInt);
  
  public abstract float getBearing();
  
  public abstract IGeoPoint getCenter();
  
  public abstract IProjection getProjection();
  
  public abstract float getZoomLevel();
  
  public abstract boolean isMyLocationEnabled();
  
  public abstract void setBearing(float paramFloat);
  
  public abstract void setCenter(double paramDouble1, double paramDouble2);
  
  public abstract void setMyLocationEnabled(boolean paramBoolean);
  
  public abstract void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void setPosition(IPosition paramIPosition);
  
  public abstract void setZoom(float paramFloat);
  
  public abstract boolean zoomIn();
  
  public abstract boolean zoomOut();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */