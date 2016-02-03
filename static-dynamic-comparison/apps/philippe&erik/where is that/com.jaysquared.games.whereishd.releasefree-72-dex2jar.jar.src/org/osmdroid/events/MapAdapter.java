package org.osmdroid.events;

public abstract class MapAdapter
  implements MapListener
{
  public boolean onScroll(ScrollEvent paramScrollEvent)
  {
    return false;
  }
  
  public boolean onZoom(ZoomEvent paramZoomEvent)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/events/MapAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */