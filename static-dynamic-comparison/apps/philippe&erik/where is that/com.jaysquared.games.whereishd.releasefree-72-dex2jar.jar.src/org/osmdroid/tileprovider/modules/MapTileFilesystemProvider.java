package org.osmdroid.tileprovider.modules;

import android.graphics.drawable.Drawable;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import org.osmdroid.tileprovider.IRegisterReceiver;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileRequestState;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.tilesource.BitmapTileSourceBase.LowMemoryException;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTileFilesystemProvider
  extends MapTileFileStorageProviderBase
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileFilesystemProvider.class);
  private final long mMaximumCachedFileAge;
  private final AtomicReference<ITileSource> mTileSource = new AtomicReference();
  
  public MapTileFilesystemProvider(IRegisterReceiver paramIRegisterReceiver)
  {
    this(paramIRegisterReceiver, TileSourceFactory.DEFAULT_TILE_SOURCE);
  }
  
  public MapTileFilesystemProvider(IRegisterReceiver paramIRegisterReceiver, ITileSource paramITileSource)
  {
    this(paramIRegisterReceiver, paramITileSource, 604800000L);
  }
  
  public MapTileFilesystemProvider(IRegisterReceiver paramIRegisterReceiver, ITileSource paramITileSource, long paramLong)
  {
    this(paramIRegisterReceiver, paramITileSource, paramLong, 8, 40);
  }
  
  public MapTileFilesystemProvider(IRegisterReceiver paramIRegisterReceiver, ITileSource paramITileSource, long paramLong, int paramInt1, int paramInt2)
  {
    super(paramIRegisterReceiver, paramInt1, paramInt2);
    setTileSource(paramITileSource);
    this.mMaximumCachedFileAge = paramLong;
  }
  
  public int getMaximumZoomLevel()
  {
    ITileSource localITileSource = (ITileSource)this.mTileSource.get();
    if (localITileSource != null) {
      return localITileSource.getMaximumZoomLevel();
    }
    return 22;
  }
  
  public int getMinimumZoomLevel()
  {
    ITileSource localITileSource = (ITileSource)this.mTileSource.get();
    if (localITileSource != null) {
      return localITileSource.getMinimumZoomLevel();
    }
    return 0;
  }
  
  protected String getName()
  {
    return "File System Cache Provider";
  }
  
  protected String getThreadGroupName()
  {
    return "filesystem";
  }
  
  protected Runnable getTileLoader()
  {
    return new TileLoader();
  }
  
  public boolean getUsesDataConnection()
  {
    return false;
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    this.mTileSource.set(paramITileSource);
  }
  
  protected class TileLoader
    extends MapTileModuleProviderBase.TileLoader
  {
    protected TileLoader()
    {
      super();
    }
    
    public Drawable loadTile(MapTileRequestState paramMapTileRequestState)
      throws MapTileModuleProviderBase.CantContinueException
    {
      int i = 1;
      Drawable localDrawable = null;
      ITileSource localITileSource = (ITileSource)MapTileFilesystemProvider.this.mTileSource.get();
      if (localITileSource == null) {
        paramMapTileRequestState = localDrawable;
      }
      MapTile localMapTile;
      File localFile;
      do
      {
        do
        {
          return paramMapTileRequestState;
          localMapTile = paramMapTileRequestState.getMapTile();
          paramMapTileRequestState = localDrawable;
        } while (!MapTileFilesystemProvider.this.getSdCardAvailable());
        localFile = new File(OpenStreetMapTileProviderConstants.TILE_PATH_BASE, localITileSource.getTileRelativeFilenameString(localMapTile) + ".tile");
        paramMapTileRequestState = localDrawable;
      } while (!localFile.exists());
      for (;;)
      {
        try
        {
          localDrawable = localITileSource.getDrawable(localFile.getPath());
          long l = System.currentTimeMillis();
          if (localFile.lastModified() < l - MapTileFilesystemProvider.this.mMaximumCachedFileAge)
          {
            paramMapTileRequestState = localDrawable;
            if (i == 0) {
              break;
            }
            localDrawable.setState(new int[] { -1 });
            return localDrawable;
          }
        }
        catch (BitmapTileSourceBase.LowMemoryException paramMapTileRequestState)
        {
          MapTileFilesystemProvider.logger.warn("LowMemoryException downloading MapTile: " + localMapTile + " : " + paramMapTileRequestState);
          throw new MapTileModuleProviderBase.CantContinueException(MapTileFilesystemProvider.this, paramMapTileRequestState);
        }
        i = 0;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/MapTileFilesystemProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */