package org.osmdroid.views.overlay.compass;

public abstract interface IOrientationProvider
{
  public abstract float getLastKnownOrientation();
  
  public abstract boolean startOrientationProvider(IOrientationConsumer paramIOrientationConsumer);
  
  public abstract void stopOrientationProvider();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/compass/IOrientationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */