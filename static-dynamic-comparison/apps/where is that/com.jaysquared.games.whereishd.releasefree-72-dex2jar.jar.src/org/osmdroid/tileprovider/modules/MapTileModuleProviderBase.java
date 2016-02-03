package org.osmdroid.tileprovider.modules;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.osmdroid.tileprovider.ExpirableBitmapDrawable;
import org.osmdroid.tileprovider.IMapTileProviderCallback;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileRequestState;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MapTileModuleProviderBase
  implements OpenStreetMapTileProviderConstants
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileModuleProviderBase.class);
  private final ExecutorService mExecutor;
  protected final LinkedHashMap<MapTile, MapTileRequestState> mPending;
  protected final Object mQueueLockObject = new Object();
  protected final HashMap<MapTile, MapTileRequestState> mWorking;
  
  public MapTileModuleProviderBase(int paramInt1, final int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 < paramInt1)
    {
      logger.warn("The pending queue size is smaller than the thread pool size. Automatically reducing the thread pool size.");
      i = paramInt2;
    }
    this.mExecutor = Executors.newFixedThreadPool(i, new ConfigurablePriorityThreadFactory(5, getThreadGroupName()));
    this.mWorking = new HashMap();
    this.mPending = new LinkedHashMap(paramInt2 + 2, 0.1F, true)
    {
      private static final long serialVersionUID = 6455337315681858866L;
      
      protected boolean removeEldestEntry(Map.Entry<MapTile, MapTileRequestState> paramAnonymousEntry)
      {
        if (size() > paramInt2)
        {
          paramAnonymousEntry = null;
          Iterator localIterator = MapTileModuleProviderBase.this.mPending.keySet().iterator();
          Object localObject;
          while ((paramAnonymousEntry == null) && (localIterator.hasNext()))
          {
            localObject = (MapTile)localIterator.next();
            if (!MapTileModuleProviderBase.this.mWorking.containsKey(localObject)) {
              paramAnonymousEntry = (Map.Entry<MapTile, MapTileRequestState>)localObject;
            }
          }
          if (paramAnonymousEntry != null)
          {
            localObject = (MapTileRequestState)MapTileModuleProviderBase.this.mPending.get(paramAnonymousEntry);
            MapTileModuleProviderBase.this.removeTileFromQueues(paramAnonymousEntry);
            ((MapTileRequestState)localObject).getCallback().mapTileRequestFailed((MapTileRequestState)localObject);
          }
        }
        return false;
      }
    };
  }
  
  private void clearQueue()
  {
    synchronized (this.mQueueLockObject)
    {
      this.mPending.clear();
      this.mWorking.clear();
      return;
    }
  }
  
  public void detach()
  {
    clearQueue();
    this.mExecutor.shutdown();
  }
  
  public abstract int getMaximumZoomLevel();
  
  public abstract int getMinimumZoomLevel();
  
  protected abstract String getName();
  
  protected abstract String getThreadGroupName();
  
  protected abstract Runnable getTileLoader();
  
  public abstract boolean getUsesDataConnection();
  
  public void loadMapTileAsync(MapTileRequestState paramMapTileRequestState)
  {
    synchronized (this.mQueueLockObject)
    {
      this.mPending.put(paramMapTileRequestState.getMapTile(), paramMapTileRequestState);
    }
    try
    {
      this.mExecutor.execute(getTileLoader());
      return;
    }
    catch (RejectedExecutionException paramMapTileRequestState)
    {
      logger.warn("RejectedExecutionException", paramMapTileRequestState);
    }
    paramMapTileRequestState = finally;
    throw paramMapTileRequestState;
  }
  
  void removeTileFromQueues(MapTile paramMapTile)
  {
    synchronized (this.mQueueLockObject)
    {
      this.mPending.remove(paramMapTile);
      this.mWorking.remove(paramMapTile);
      return;
    }
  }
  
  public abstract void setTileSource(ITileSource paramITileSource);
  
  public class CantContinueException
    extends Exception
  {
    private static final long serialVersionUID = 146526524087765133L;
    
    public CantContinueException(String paramString)
    {
      super();
    }
    
    public CantContinueException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  protected abstract class TileLoader
    implements Runnable
  {
    protected TileLoader() {}
    
    protected abstract Drawable loadTile(MapTileRequestState paramMapTileRequestState)
      throws MapTileModuleProviderBase.CantContinueException;
    
    protected MapTileRequestState nextTile()
    {
      Object localObject4 = MapTileModuleProviderBase.this.mQueueLockObject;
      Object localObject3;
      for (Object localObject1 = null;; localObject3 = null) {
        try
        {
          Iterator localIterator = MapTileModuleProviderBase.this.mPending.keySet().iterator();
          while (localIterator.hasNext())
          {
            MapTile localMapTile = (MapTile)localIterator.next();
            if (!MapTileModuleProviderBase.this.mWorking.containsKey(localMapTile)) {
              localObject1 = localMapTile;
            }
          }
          if (localObject1 != null) {
            MapTileModuleProviderBase.this.mWorking.put(localObject1, MapTileModuleProviderBase.this.mPending.get(localObject1));
          }
          if (localObject1 != null)
          {
            localObject1 = (MapTileRequestState)MapTileModuleProviderBase.this.mPending.get(localObject1);
            return (MapTileRequestState)localObject1;
          }
        }
        finally {}
      }
    }
    
    protected void onTileLoaderInit() {}
    
    protected void onTileLoaderShutdown() {}
    
    public final void run()
    {
      onTileLoaderInit();
      for (;;)
      {
        MapTileRequestState localMapTileRequestState = nextTile();
        if (localMapTileRequestState == null) {
          break;
        }
        Object localObject = null;
        try
        {
          Drawable localDrawable = loadTile(localMapTileRequestState);
          localObject = localDrawable;
          if (localObject == null) {
            tileLoadedFailed(localMapTileRequestState);
          }
        }
        catch (MapTileModuleProviderBase.CantContinueException localCantContinueException)
        {
          for (;;)
          {
            MapTileModuleProviderBase.logger.info("Tile loader can't continue: " + localMapTileRequestState.getMapTile(), localCantContinueException);
            MapTileModuleProviderBase.this.clearQueue();
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            MapTileModuleProviderBase.logger.error("Error downloading tile: " + localMapTileRequestState.getMapTile(), localThrowable);
          }
          if (ExpirableBitmapDrawable.isDrawableExpired((Drawable)localObject)) {
            tileLoadedExpired(localMapTileRequestState, (Drawable)localObject);
          } else {
            tileLoaded(localMapTileRequestState, (Drawable)localObject);
          }
        }
      }
      onTileLoaderShutdown();
    }
    
    protected void tileLoaded(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
    {
      MapTileModuleProviderBase.this.removeTileFromQueues(paramMapTileRequestState.getMapTile());
      paramMapTileRequestState.getCallback().mapTileRequestCompleted(paramMapTileRequestState, paramDrawable);
    }
    
    protected void tileLoadedExpired(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
    {
      MapTileModuleProviderBase.this.removeTileFromQueues(paramMapTileRequestState.getMapTile());
      paramMapTileRequestState.getCallback().mapTileRequestExpiredTile(paramMapTileRequestState, paramDrawable);
    }
    
    protected void tileLoadedFailed(MapTileRequestState paramMapTileRequestState)
    {
      MapTileModuleProviderBase.this.removeTileFromQueues(paramMapTileRequestState.getMapTile());
      paramMapTileRequestState.getCallback().mapTileRequestFailed(paramMapTileRequestState);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/MapTileModuleProviderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */