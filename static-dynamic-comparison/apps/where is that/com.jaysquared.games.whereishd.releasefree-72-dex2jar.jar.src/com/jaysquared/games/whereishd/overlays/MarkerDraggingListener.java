package com.jaysquared.games.whereishd.overlays;

import org.osmdroid.api.IGeoPoint;

public abstract interface MarkerDraggingListener
{
  public abstract void onDragging(IGeoPoint paramIGeoPoint, int paramInt1, int paramInt2);
  
  public abstract void onDraggingFinished(IGeoPoint paramIGeoPoint);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/overlays/MarkerDraggingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */