package org.osmdroid.api;

public abstract interface IMapController
{
  public abstract void animateTo(IGeoPoint paramIGeoPoint);
  
  public abstract void scrollBy(int paramInt1, int paramInt2);
  
  public abstract void setCenter(IGeoPoint paramIGeoPoint);
  
  public abstract int setZoom(int paramInt);
  
  public abstract void stopAnimation(boolean paramBoolean);
  
  public abstract void stopPanning();
  
  public abstract boolean zoomIn();
  
  public abstract boolean zoomInFixing(int paramInt1, int paramInt2);
  
  public abstract boolean zoomOut();
  
  public abstract boolean zoomOutFixing(int paramInt1, int paramInt2);
  
  public abstract void zoomToSpan(int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IMapController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */