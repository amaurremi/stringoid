package org.osmdroid.api;

public abstract interface IMapView
{
  public abstract IMapController getController();
  
  public abstract int getLatitudeSpan();
  
  public abstract int getLongitudeSpan();
  
  public abstract IGeoPoint getMapCenter();
  
  public abstract int getMaxZoomLevel();
  
  public abstract IProjection getProjection();
  
  public abstract int getZoomLevel();
  
  public abstract void setBackgroundColor(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */