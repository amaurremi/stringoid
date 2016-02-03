package org.osmdroid.views.overlay.mylocation;

import android.location.Location;

public abstract interface IMyLocationProvider
{
  public abstract Location getLastKnownLocation();
  
  public abstract boolean startLocationProvider(IMyLocationConsumer paramIMyLocationConsumer);
  
  public abstract void stopLocationProvider();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/mylocation/IMyLocationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */