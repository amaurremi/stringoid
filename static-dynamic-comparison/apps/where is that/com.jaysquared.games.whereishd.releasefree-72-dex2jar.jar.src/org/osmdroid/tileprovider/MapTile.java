package org.osmdroid.tileprovider;

public class MapTile
{
  public static final int MAPTILE_FAIL_ID = 1;
  public static final int MAPTILE_SUCCESS_ID = 0;
  private final int x;
  private final int y;
  private final int zoomLevel;
  
  public MapTile(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zoomLevel = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (!(paramObject instanceof MapTile));
    paramObject = (MapTile)paramObject;
    if ((this.zoomLevel == ((MapTile)paramObject).zoomLevel) && (this.x == ((MapTile)paramObject).x) && (this.y == ((MapTile)paramObject).y)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public int getZoomLevel()
  {
    return this.zoomLevel;
  }
  
  public int hashCode()
  {
    return 17 * (this.zoomLevel + 37) * (this.x + 37) * (this.y + 37);
  }
  
  public String toString()
  {
    return "/" + this.zoomLevel + "/" + this.x + "/" + this.y;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/MapTile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */