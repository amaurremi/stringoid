package org.slf4j;

public abstract interface IMarkerFactory
{
  public abstract boolean detachMarker(String paramString);
  
  public abstract boolean exists(String paramString);
  
  public abstract Marker getDetachedMarker(String paramString);
  
  public abstract Marker getMarker(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/IMarkerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */