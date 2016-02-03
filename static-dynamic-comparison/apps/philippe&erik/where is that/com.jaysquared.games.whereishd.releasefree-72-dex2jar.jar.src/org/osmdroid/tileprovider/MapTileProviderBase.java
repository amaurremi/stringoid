package org.osmdroid.tileprovider;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import microsoft.mappoint.TileSystem;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.modules.MapTileModuleProviderBase;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.util.TileLooper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MapTileProviderBase
  implements IMapTileProviderCallback, OpenStreetMapTileProviderConstants
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileProviderBase.class);
  protected final MapTileCache mTileCache = createTileCache();
  protected Handler mTileRequestCompleteHandler;
  private ITileSource mTileSource;
  protected boolean mUseDataConnection = true;
  
  public MapTileProviderBase(ITileSource paramITileSource)
  {
    this(paramITileSource, null);
  }
  
  public MapTileProviderBase(ITileSource paramITileSource, Handler paramHandler)
  {
    this.mTileRequestCompleteHandler = paramHandler;
    this.mTileSource = paramITileSource;
  }
  
  public void clearTileCache()
  {
    this.mTileCache.clear();
  }
  
  public MapTileCache createTileCache()
  {
    return new MapTileCache();
  }
  
  public abstract void detach();
  
  public void ensureCapacity(int paramInt)
  {
    this.mTileCache.ensureCapacity(paramInt);
  }
  
  public abstract Drawable getMapTile(MapTile paramMapTile);
  
  public abstract int getMaximumZoomLevel();
  
  public abstract int getMinimumZoomLevel();
  
  public ITileSource getTileSource()
  {
    return this.mTileSource;
  }
  
  public void mapTileRequestCompleted(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
  {
    putTileIntoCache(paramMapTileRequestState, paramDrawable);
    if (this.mTileRequestCompleteHandler != null) {
      this.mTileRequestCompleteHandler.sendEmptyMessage(0);
    }
  }
  
  public void mapTileRequestExpiredTile(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
  {
    putExpiredTileIntoCache(paramMapTileRequestState, paramDrawable);
    if (this.mTileRequestCompleteHandler != null) {
      this.mTileRequestCompleteHandler.sendEmptyMessage(0);
    }
  }
  
  public void mapTileRequestFailed(MapTileRequestState paramMapTileRequestState)
  {
    if (this.mTileRequestCompleteHandler != null) {
      this.mTileRequestCompleteHandler.sendEmptyMessage(1);
    }
  }
  
  protected void putExpiredTileIntoCache(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
  {
    paramMapTileRequestState = paramMapTileRequestState.getMapTile();
    if ((paramDrawable != null) && (!this.mTileCache.containsTile(paramMapTileRequestState))) {
      this.mTileCache.putTile(paramMapTileRequestState, paramDrawable);
    }
  }
  
  protected void putTileIntoCache(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
  {
    paramMapTileRequestState = paramMapTileRequestState.getMapTile();
    if (paramDrawable != null) {
      this.mTileCache.putTile(paramMapTileRequestState, paramDrawable);
    }
  }
  
  public void rescaleCache(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    long l1 = System.currentTimeMillis();
    logger.info("rescale tile cache from " + paramInt2 + " to " + paramInt1);
    int i = getTileSource().getTileSizePixels();
    int j = TileSystem.MapSize(paramInt1) >> 1;
    Rect localRect = new Rect(paramRect);
    localRect.offset(j, j);
    if (paramInt1 > paramInt2) {}
    for (paramRect = new ZoomInTileLooper(paramInt2);; paramRect = new ZoomOutTileLooper(paramInt2))
    {
      paramRect.loop(null, paramInt1, i, localRect);
      long l2 = System.currentTimeMillis();
      logger.info("Finished rescale in " + (l2 - l1) + "ms");
      return;
    }
  }
  
  public void setTileRequestCompleteHandler(Handler paramHandler)
  {
    this.mTileRequestCompleteHandler = paramHandler;
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    this.mTileSource = paramITileSource;
    clearTileCache();
  }
  
  public void setUseDataConnection(boolean paramBoolean)
  {
    this.mUseDataConnection = paramBoolean;
  }
  
  public boolean useDataConnection()
  {
    return this.mUseDataConnection;
  }
  
  private abstract class ScaleTileLooper
    extends TileLooper
  {
    protected Paint mDebugPaint;
    protected Rect mDestRect;
    protected int mDiff;
    protected final HashMap<MapTile, Bitmap> mNewTiles;
    protected final int mOldZoomLevel;
    protected Rect mSrcRect;
    protected int mTileSize_2;
    
    public ScaleTileLooper(int paramInt)
    {
      this.mOldZoomLevel = paramInt;
      this.mNewTiles = new HashMap();
      this.mSrcRect = new Rect();
      this.mDestRect = new Rect();
      this.mDebugPaint = new Paint();
    }
    
    public void finaliseLoop()
    {
      while (!this.mNewTiles.isEmpty())
      {
        MapTile localMapTile = (MapTile)this.mNewTiles.keySet().iterator().next();
        ReusableBitmapDrawable localReusableBitmapDrawable = new ReusableBitmapDrawable((Bitmap)this.mNewTiles.remove(localMapTile));
        localReusableBitmapDrawable.setState(new int[] { -1 });
        Drawable localDrawable = MapTileProviderBase.this.mTileCache.getMapTile(localMapTile);
        if ((localDrawable == null) || (ExpirableBitmapDrawable.isDrawableExpired(localDrawable))) {
          MapTileProviderBase.this.putExpiredTileIntoCache(new MapTileRequestState(localMapTile, new MapTileModuleProviderBase[0], null), localReusableBitmapDrawable);
        }
      }
    }
    
    protected abstract void handleTile(int paramInt1, MapTile paramMapTile, int paramInt2, int paramInt3);
    
    public void handleTile(Canvas paramCanvas, int paramInt1, MapTile paramMapTile, int paramInt2, int paramInt3)
    {
      if (MapTileProviderBase.this.getMapTile(paramMapTile) == null) {}
      try
      {
        handleTile(paramInt1, paramMapTile, paramInt2, paramInt3);
        return;
      }
      catch (OutOfMemoryError paramCanvas)
      {
        MapTileProviderBase.logger.error("OutOfMemoryError rescaling cache");
      }
    }
    
    public void initialiseLoop(int paramInt1, int paramInt2)
    {
      this.mDiff = Math.abs(paramInt1 - this.mOldZoomLevel);
      this.mTileSize_2 = (paramInt2 >> this.mDiff);
    }
  }
  
  private class ZoomInTileLooper
    extends MapTileProviderBase.ScaleTileLooper
  {
    public ZoomInTileLooper(int paramInt)
    {
      super(paramInt);
    }
    
    public void handleTile(int paramInt1, MapTile paramMapTile, int paramInt2, int paramInt3)
    {
      Object localObject1 = new MapTile(this.mOldZoomLevel, paramMapTile.getX() >> this.mDiff, paramMapTile.getY() >> this.mDiff);
      Drawable localDrawable = MapTileProviderBase.this.mTileCache.getMapTile((MapTile)localObject1);
      Canvas localCanvas;
      if ((localDrawable instanceof BitmapDrawable))
      {
        paramInt2 = paramInt2 % (1 << this.mDiff) * this.mTileSize_2;
        paramInt3 = paramInt3 % (1 << this.mDiff) * this.mTileSize_2;
        this.mSrcRect.set(paramInt2, paramInt3, this.mTileSize_2 + paramInt2, this.mTileSize_2 + paramInt3);
        this.mDestRect.set(0, 0, paramInt1, paramInt1);
        localObject2 = BitmapPool.getInstance().obtainSizedBitmapFromPool(paramInt1, paramInt1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
        localCanvas = new Canvas((Bitmap)localObject1);
        bool = localDrawable instanceof ReusableBitmapDrawable;
        if (!bool) {
          break label251;
        }
      }
      for (localObject2 = (ReusableBitmapDrawable)localDrawable;; localObject2 = null)
      {
        paramInt1 = 0;
        if (bool) {
          ((ReusableBitmapDrawable)localObject2).beginUsingDrawable();
        }
        if (bool) {}
        try
        {
          if (((ReusableBitmapDrawable)localObject2).isBitmapValid())
          {
            localCanvas.drawBitmap(((BitmapDrawable)localDrawable).getBitmap(), this.mSrcRect, this.mDestRect, null);
            paramInt1 = 1;
          }
          if (bool) {
            ((ReusableBitmapDrawable)localObject2).finishUsingDrawable();
          }
          if (paramInt1 != 0) {
            this.mNewTiles.put(paramMapTile, localObject1);
          }
          return;
        }
        finally
        {
          label251:
          if (!bool) {
            break;
          }
          ((ReusableBitmapDrawable)localObject2).finishUsingDrawable();
        }
      }
    }
  }
  
  private class ZoomOutTileLooper
    extends MapTileProviderBase.ScaleTileLooper
  {
    private static final int MAX_ZOOM_OUT_DIFF = 4;
    
    public ZoomOutTileLooper(int paramInt)
    {
      super(paramInt);
    }
    
    protected void handleTile(int paramInt1, MapTile paramMapTile, int paramInt2, int paramInt3)
    {
      if (this.mDiff >= 4) {}
      Object localObject1;
      do
      {
        return;
        int i = paramMapTile.getX();
        int j = this.mDiff;
        int k = paramMapTile.getY();
        int m = this.mDiff;
        int n = 1 << this.mDiff;
        localObject1 = null;
        Object localObject2 = null;
        paramInt2 = 0;
        while (paramInt2 < n)
        {
          paramInt3 = 0;
          while (paramInt3 < n)
          {
            Object localObject3 = new MapTile(this.mOldZoomLevel, (i << j) + paramInt2, (k << m) + paramInt3);
            localObject3 = MapTileProviderBase.this.mTileCache.getMapTile((MapTile)localObject3);
            Object localObject4 = localObject1;
            Object localObject5 = localObject2;
            if ((localObject3 instanceof BitmapDrawable))
            {
              Bitmap localBitmap = ((BitmapDrawable)localObject3).getBitmap();
              localObject4 = localObject1;
              localObject5 = localObject2;
              if (localBitmap != null)
              {
                localObject3 = localObject1;
                if (localObject1 == null)
                {
                  localObject1 = BitmapPool.getInstance().obtainSizedBitmapFromPool(paramInt1, paramInt1);
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
                  }
                  localObject2 = new Canvas((Bitmap)localObject3);
                  ((Canvas)localObject2).drawColor(-3355444);
                }
                this.mDestRect.set(this.mTileSize_2 * paramInt2, this.mTileSize_2 * paramInt3, (paramInt2 + 1) * this.mTileSize_2, (paramInt3 + 1) * this.mTileSize_2);
                localObject4 = localObject3;
                localObject5 = localObject2;
                if (localBitmap != null)
                {
                  ((Canvas)localObject2).drawBitmap(localBitmap, null, this.mDestRect, null);
                  MapTileProviderBase.this.mTileCache.mCachedTiles.remove(localBitmap);
                  localObject5 = localObject2;
                  localObject4 = localObject3;
                }
              }
            }
            paramInt3 += 1;
            localObject1 = localObject4;
            localObject2 = localObject5;
          }
          paramInt2 += 1;
        }
      } while (localObject1 == null);
      this.mNewTiles.put(paramMapTile, localObject1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/MapTileProviderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */