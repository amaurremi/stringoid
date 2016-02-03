package org.osmdroid.events;

import org.osmdroid.views.MapView;

public class ZoomEvent
  implements MapEvent
{
  protected MapView source;
  protected int zoomLevel;
  
  public ZoomEvent(MapView paramMapView, int paramInt)
  {
    this.source = paramMapView;
    this.zoomLevel = paramInt;
  }
  
  public MapView getSource()
  {
    return this.source;
  }
  
  public int getZoomLevel()
  {
    return this.zoomLevel;
  }
  
  public String toString()
  {
    return "ZoomEvent [source=" + this.source + ", zoomLevel=" + this.zoomLevel + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/events/ZoomEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */