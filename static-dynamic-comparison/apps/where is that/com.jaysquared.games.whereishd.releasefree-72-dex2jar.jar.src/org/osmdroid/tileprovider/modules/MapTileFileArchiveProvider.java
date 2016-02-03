package org.osmdroid.tileprovider.modules;

import android.graphics.drawable.Drawable;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.osmdroid.tileprovider.IRegisterReceiver;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.MapTileRequestState;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.util.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTileFileArchiveProvider
  extends MapTileFileStorageProviderBase
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileFileArchiveProvider.class);
  private final ArrayList<IArchiveFile> mArchiveFiles = new ArrayList();
  private final boolean mSpecificArchivesProvided;
  private final AtomicReference<ITileSource> mTileSource = new AtomicReference();
  
  public MapTileFileArchiveProvider(IRegisterReceiver paramIRegisterReceiver, ITileSource paramITileSource)
  {
    this(paramIRegisterReceiver, paramITileSource, null);
  }
  
  public MapTileFileArchiveProvider(IRegisterReceiver paramIRegisterReceiver, ITileSource paramITileSource, IArchiveFile[] paramArrayOfIArchiveFile)
  {
    super(paramIRegisterReceiver, 8, 40);
    setTileSource(paramITileSource);
    if (paramArrayOfIArchiveFile == null)
    {
      this.mSpecificArchivesProvided = false;
      findArchiveFiles();
    }
    for (;;)
    {
      return;
      this.mSpecificArchivesProvided = true;
      int i = paramArrayOfIArchiveFile.length - 1;
      while (i >= 0)
      {
        this.mArchiveFiles.add(paramArrayOfIArchiveFile[i]);
        i -= 1;
      }
    }
  }
  
  private void findArchiveFiles()
  {
    this.mArchiveFiles.clear();
    if (!getSdCardAvailable()) {}
    for (;;)
    {
      return;
      File[] arrayOfFile = OSMDROID_PATH.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          IArchiveFile localIArchiveFile = ArchiveFileFactory.getArchiveFile(arrayOfFile[i]);
          if (localIArchiveFile != null) {
            this.mArchiveFiles.add(localIArchiveFile);
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  private InputStream getInputStream(MapTile paramMapTile, ITileSource paramITileSource)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	org/osmdroid/tileprovider/modules/MapTileFileArchiveProvider:mArchiveFiles	Ljava/util/ArrayList;
    //   6: invokevirtual 97	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 4
    //   11: aload 4
    //   13: invokeinterface 102 1 0
    //   18: ifeq +29 -> 47
    //   21: aload 4
    //   23: invokeinterface 106 1 0
    //   28: checkcast 108	org/osmdroid/tileprovider/modules/IArchiveFile
    //   31: aload_2
    //   32: aload_1
    //   33: invokeinterface 111 3 0
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull -29 -> 11
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: areturn
    //   47: aconst_null
    //   48: astore_3
    //   49: goto -6 -> 43
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	MapTileFileArchiveProvider
    //   0	57	1	paramMapTile	MapTile
    //   0	57	2	paramITileSource	ITileSource
    //   38	11	3	localInputStream	InputStream
    //   9	13	4	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	11	52	finally
    //   11	39	52	finally
  }
  
  public void detach()
  {
    while (!this.mArchiveFiles.isEmpty())
    {
      ((IArchiveFile)this.mArchiveFiles.get(0)).close();
      this.mArchiveFiles.remove(0);
    }
    super.detach();
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
    return "File Archive Provider";
  }
  
  protected String getThreadGroupName()
  {
    return "filearchive";
  }
  
  protected Runnable getTileLoader()
  {
    return new TileLoader();
  }
  
  public boolean getUsesDataConnection()
  {
    return false;
  }
  
  protected void onMediaMounted()
  {
    if (!this.mSpecificArchivesProvided) {
      findArchiveFiles();
    }
  }
  
  protected void onMediaUnmounted()
  {
    if (!this.mSpecificArchivesProvided) {
      findArchiveFiles();
    }
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
    {
      Object localObject3 = null;
      Object localObject4 = (ITileSource)MapTileFileArchiveProvider.this.mTileSource.get();
      Object localObject1;
      if (localObject4 == null) {
        localObject1 = localObject3;
      }
      for (;;)
      {
        return (Drawable)localObject1;
        Object localObject2 = paramMapTileRequestState.getMapTile();
        localObject1 = localObject3;
        if (!MapTileFileArchiveProvider.this.getSdCardAvailable()) {
          continue;
        }
        localObject1 = null;
        paramMapTileRequestState = null;
        try
        {
          localObject2 = MapTileFileArchiveProvider.this.getInputStream((MapTile)localObject2, (ITileSource)localObject4);
          if (localObject2 != null)
          {
            paramMapTileRequestState = (MapTileRequestState)localObject2;
            localObject1 = localObject2;
            localObject4 = ((ITileSource)localObject4).getDrawable((InputStream)localObject2);
            paramMapTileRequestState = (MapTileRequestState)localObject4;
            localObject1 = paramMapTileRequestState;
            return paramMapTileRequestState;
          }
          localObject1 = localObject3;
          return null;
        }
        catch (Throwable localThrowable)
        {
          localObject1 = paramMapTileRequestState;
          MapTileFileArchiveProvider.logger.error("Error loading tile", localThrowable);
          localObject1 = localObject3;
          if (paramMapTileRequestState == null) {
            continue;
          }
          StreamUtils.closeStream(paramMapTileRequestState);
          return null;
        }
        finally
        {
          if (localObject1 != null) {
            StreamUtils.closeStream((Closeable)localObject1);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/MapTileFileArchiveProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */