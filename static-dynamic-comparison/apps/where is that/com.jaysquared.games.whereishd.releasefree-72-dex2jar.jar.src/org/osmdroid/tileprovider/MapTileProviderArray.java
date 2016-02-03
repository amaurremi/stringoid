package org.osmdroid.tileprovider;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTileProviderArray
  extends MapTileProviderBase
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileProviderArray.class);
  protected final List<MapTileModuleProviderBase> mTileProviderList = new ArrayList();
  protected final HashMap<MapTile, MapTileRequestState> mWorking = new HashMap();
  
  protected MapTileProviderArray(ITileSource paramITileSource, IRegisterReceiver paramIRegisterReceiver)
  {
    this(paramITileSource, paramIRegisterReceiver, new MapTileModuleProviderBase[0]);
  }
  
  public MapTileProviderArray(ITileSource paramITileSource, IRegisterReceiver paramIRegisterReceiver, MapTileModuleProviderBase[] paramArrayOfMapTileModuleProviderBase)
  {
    super(paramITileSource);
    Collections.addAll(this.mTileProviderList, paramArrayOfMapTileModuleProviderBase);
  }
  
  public void detach()
  {
    synchronized (this.mTileProviderList)
    {
      Iterator localIterator = this.mTileProviderList.iterator();
      if (localIterator.hasNext()) {
        ((MapTileModuleProviderBase)localIterator.next()).detach();
      }
    }
    synchronized (this.mWorking)
    {
      this.mWorking.clear();
      return;
    }
  }
  
  protected MapTileModuleProviderBase findNextAppropriateProvider(MapTileRequestState paramMapTileRequestState)
  {
    int i = 0;
    int i1 = 0;
    int n = 0;
    MapTileModuleProviderBase localMapTileModuleProviderBase = paramMapTileRequestState.getNextProvider();
    int k = i1;
    int j = n;
    int m = i;
    if (localMapTileModuleProviderBase != null)
    {
      if (getProviderExists(localMapTileModuleProviderBase)) {
        break label141;
      }
      i = 1;
      label40:
      if ((useDataConnection()) || (!localMapTileModuleProviderBase.getUsesDataConnection())) {
        break label146;
      }
      k = 1;
      label58:
      j = paramMapTileRequestState.getMapTile().getZoomLevel();
      if ((j <= localMapTileModuleProviderBase.getMaximumZoomLevel()) && (j >= localMapTileModuleProviderBase.getMinimumZoomLevel())) {
        break label152;
      }
      j = 1;
    }
    for (m = i;; m = i)
    {
      if (localMapTileModuleProviderBase != null)
      {
        i1 = k;
        n = j;
        i = m;
        if (m != 0) {
          break;
        }
        i1 = k;
        n = j;
        i = m;
        if (k != 0) {
          break;
        }
        i1 = k;
        n = j;
        i = m;
        if (j != 0) {
          break;
        }
      }
      return localMapTileModuleProviderBase;
      label141:
      i = 0;
      break label40;
      label146:
      k = 0;
      break label58;
      label152:
      j = 0;
    }
  }
  
  public Drawable getMapTile(MapTile paramMapTile)
  {
    Drawable localDrawable = this.mTileCache.getMapTile(paramMapTile);
    if ((localDrawable != null) && (!ExpirableBitmapDrawable.isDrawableExpired(localDrawable))) {}
    for (;;)
    {
      return localDrawable;
      synchronized (this.mWorking)
      {
        boolean bool = this.mWorking.containsKey(paramMapTile);
        if (bool) {}
      }
    }
    Object localObject2;
    synchronized (this.mTileProviderList)
    {
      localObject2 = new MapTileModuleProviderBase[this.mTileProviderList.size()];
      localObject2 = new MapTileRequestState(paramMapTile, (MapTileModuleProviderBase[])this.mTileProviderList.toArray((Object[])localObject2), this);
      synchronized (this.mWorking)
      {
        if (!this.mWorking.containsKey(paramMapTile)) {
          break label141;
        }
        return null;
      }
      paramMapTile = finally;
      throw paramMapTile;
    }
    label141:
    this.mWorking.put(paramMapTile, localObject2);
    paramMapTile = findNextAppropriateProvider((MapTileRequestState)localObject2);
    if (paramMapTile != null)
    {
      paramMapTile.loadMapTileAsync((MapTileRequestState)localObject2);
      return localDrawable;
    }
    mapTileRequestFailed((MapTileRequestState)localObject2);
    return localDrawable;
  }
  
  public int getMaximumZoomLevel()
  {
    int i = 0;
    synchronized (this.mTileProviderList)
    {
      Iterator localIterator = this.mTileProviderList.iterator();
      while (localIterator.hasNext())
      {
        MapTileModuleProviderBase localMapTileModuleProviderBase = (MapTileModuleProviderBase)localIterator.next();
        if (localMapTileModuleProviderBase.getMaximumZoomLevel() > i) {
          i = localMapTileModuleProviderBase.getMaximumZoomLevel();
        }
      }
      return i;
    }
  }
  
  public int getMinimumZoomLevel()
  {
    int i = 22;
    synchronized (this.mTileProviderList)
    {
      Iterator localIterator = this.mTileProviderList.iterator();
      while (localIterator.hasNext())
      {
        MapTileModuleProviderBase localMapTileModuleProviderBase = (MapTileModuleProviderBase)localIterator.next();
        if (localMapTileModuleProviderBase.getMinimumZoomLevel() < i) {
          i = localMapTileModuleProviderBase.getMinimumZoomLevel();
        }
      }
      return i;
    }
  }
  
  public boolean getProviderExists(MapTileModuleProviderBase paramMapTileModuleProviderBase)
  {
    synchronized (this.mTileProviderList)
    {
      boolean bool = this.mTileProviderList.contains(paramMapTileModuleProviderBase);
      return bool;
    }
  }
  
  public void mapTileRequestCompleted(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
  {
    synchronized (this.mWorking)
    {
      this.mWorking.remove(paramMapTileRequestState.getMapTile());
      super.mapTileRequestCompleted(paramMapTileRequestState, paramDrawable);
      return;
    }
  }
  
  public void mapTileRequestExpiredTile(MapTileRequestState paramMapTileRequestState, Drawable arg2)
  {
    super.mapTileRequestExpiredTile(paramMapTileRequestState, ???);
    ??? = findNextAppropriateProvider(paramMapTileRequestState);
    if (??? != null)
    {
      ???.loadMapTileAsync(paramMapTileRequestState);
      return;
    }
    synchronized (this.mWorking)
    {
      this.mWorking.remove(paramMapTileRequestState.getMapTile());
      return;
    }
  }
  
  public void mapTileRequestFailed(MapTileRequestState paramMapTileRequestState)
  {
    ??? = findNextAppropriateProvider(paramMapTileRequestState);
    if (??? != null)
    {
      ((MapTileModuleProviderBase)???).loadMapTileAsync(paramMapTileRequestState);
      return;
    }
    synchronized (this.mWorking)
    {
      this.mWorking.remove(paramMapTileRequestState.getMapTile());
      super.mapTileRequestFailed(paramMapTileRequestState);
      return;
    }
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    super.setTileSource(paramITileSource);
    synchronized (this.mTileProviderList)
    {
      Iterator localIterator = this.mTileProviderList.iterator();
      if (localIterator.hasNext())
      {
        ((MapTileModuleProviderBase)localIterator.next()).setTileSource(paramITileSource);
        clearTileCache();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/MapTileProviderArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */