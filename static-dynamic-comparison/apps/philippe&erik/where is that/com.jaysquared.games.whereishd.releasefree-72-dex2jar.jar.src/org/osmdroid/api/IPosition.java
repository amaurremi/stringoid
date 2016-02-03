package org.osmdroid.api;

public abstract interface IPosition
{
  public abstract float getBearing();
  
  public abstract double getLatitude();
  
  public abstract double getLongitude();
  
  public abstract float getZoomLevel();
  
  public abstract boolean hasBearing();
  
  public abstract boolean hasZoomLevel();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */