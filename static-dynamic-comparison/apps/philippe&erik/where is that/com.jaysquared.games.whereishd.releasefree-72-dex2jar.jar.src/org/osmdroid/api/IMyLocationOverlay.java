package org.osmdroid.api;

import android.location.Location;
import android.os.Bundle;

public abstract interface IMyLocationOverlay
{
  public abstract void disableCompass();
  
  public abstract void disableMyLocation();
  
  public abstract boolean enableCompass();
  
  public abstract boolean enableMyLocation();
  
  public abstract Location getLastFix();
  
  public abstract float getOrientation();
  
  public abstract boolean isCompassEnabled();
  
  public abstract boolean isMyLocationEnabled();
  
  public abstract void onStatusChanged(String paramString, int paramInt, Bundle paramBundle);
  
  public abstract boolean runOnFirstFix(Runnable paramRunnable);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/IMyLocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */