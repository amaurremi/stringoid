package org.osmdroid.tileprovider;

import android.graphics.drawable.Drawable;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;

public class MapTileCache
  implements OpenStreetMapTileProviderConstants
{
  protected LRUMapTileCache mCachedTiles;
  protected final Object mCachedTilesLockObject = new Object();
  
  public MapTileCache()
  {
    this(9);
  }
  
  public MapTileCache(int paramInt)
  {
    this.mCachedTiles = new LRUMapTileCache(paramInt);
  }
  
  public void clear()
  {
    synchronized (this.mCachedTilesLockObject)
    {
      this.mCachedTiles.clear();
      return;
    }
  }
  
  public boolean containsTile(MapTile paramMapTile)
  {
    synchronized (this.mCachedTilesLockObject)
    {
      boolean bool = this.mCachedTiles.containsKey(paramMapTile);
      return bool;
    }
  }
  
  public void ensureCapacity(int paramInt)
  {
    synchronized (this.mCachedTilesLockObject)
    {
      this.mCachedTiles.ensureCapacity(paramInt);
      return;
    }
  }
  
  public Drawable getMapTile(MapTile paramMapTile)
  {
    synchronized (this.mCachedTilesLockObject)
    {
      paramMapTile = (Drawable)this.mCachedTiles.get(paramMapTile);
      return paramMapTile;
    }
  }
  
  public void putTile(MapTile paramMapTile, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      synchronized (this.mCachedTilesLockObject)
      {
        this.mCachedTiles.put(paramMapTile, paramDrawable);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/MapTileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */