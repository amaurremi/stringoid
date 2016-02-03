package org.osmdroid.events;

import org.osmdroid.views.MapView;

public class ScrollEvent
  implements MapEvent
{
  protected MapView source;
  protected int x;
  protected int y;
  
  public ScrollEvent(MapView paramMapView, int paramInt1, int paramInt2)
  {
    this.source = paramMapView;
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public MapView getSource()
  {
    return this.source;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public String toString()
  {
    return "ScrollEvent [source=" + this.source + ", x=" + this.x + ", y=" + this.y + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/events/ScrollEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */