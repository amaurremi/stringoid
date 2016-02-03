package org.osmdroid.tileprovider.modules;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TileWriter
  implements IFilesystemCache, OpenStreetMapTileProviderConstants
{
  private static final Logger logger = LoggerFactory.getLogger(TileWriter.class);
  private static long mUsedCacheSpace;
  
  public TileWriter()
  {
    Thread local1 = new Thread()
    {
      public void run()
      {
        TileWriter.access$002(0L);
        TileWriter.this.calculateDirectorySize(OpenStreetMapTileProviderConstants.TILE_PATH_BASE);
        if (TileWriter.mUsedCacheSpace > 629145600L) {
          TileWriter.this.cutCurrentCache();
        }
      }
    };
    local1.setPriority(1);
    local1.start();
  }
  
  private void calculateDirectorySize(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isFile()) {
          mUsedCacheSpace += localFile.length();
        }
        if ((localFile.isDirectory()) && (!isSymbolicDirectoryLink(paramFile, localFile))) {
          calculateDirectorySize(localFile);
        }
        i += 1;
      }
    }
  }
  
  private boolean createFolderAndCheckIfExists(File paramFile)
  {
    if (paramFile.mkdirs()) {}
    for (;;)
    {
      return true;
      try
      {
        Thread.sleep(500L);
        if (paramFile.exists()) {
          continue;
        }
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  private void cutCurrentCache()
  {
    int i = 0;
    for (;;)
    {
      synchronized (TILE_PATH_BASE)
      {
        File localFile2;
        if (mUsedCacheSpace > 524288000L)
        {
          logger.info("Trimming tile cache from " + mUsedCacheSpace + " to " + 524288000L);
          File[] arrayOfFile = (File[])getDirectoryFileList(TILE_PATH_BASE).toArray(new File[0]);
          Arrays.sort(arrayOfFile, new Comparator()
          {
            public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
            {
              return Long.valueOf(paramAnonymousFile1.lastModified()).compareTo(Long.valueOf(paramAnonymousFile2.lastModified()));
            }
          });
          int j = arrayOfFile.length;
          if (i < j)
          {
            localFile2 = arrayOfFile[i];
            if (mUsedCacheSpace > 524288000L) {}
          }
          else
          {
            logger.info("Finished trimming tile cache");
          }
        }
        else
        {
          return;
        }
        long l = localFile2.length();
        if (localFile2.delete()) {
          mUsedCacheSpace -= l;
        }
      }
      i += 1;
    }
  }
  
  private List<File> getDirectoryFileList(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (((File)localObject).isFile()) {
          localArrayList.add(localObject);
        }
        if (((File)localObject).isDirectory()) {
          localArrayList.addAll(getDirectoryFileList((File)localObject));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static long getUsedCacheSpace()
  {
    return mUsedCacheSpace;
  }
  
  private boolean isSymbolicDirectoryLink(File paramFile1, File paramFile2)
  {
    try
    {
      boolean bool = paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalFile().getParent());
      return !bool;
    }
    catch (IOException paramFile1)
    {
      return true;
    }
    catch (NoSuchElementException paramFile1) {}
    return true;
  }
  
  /* Error */
  public boolean saveFile(org.osmdroid.tileprovider.tilesource.ITileSource paramITileSource, org.osmdroid.tileprovider.MapTile paramMapTile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 60	java/io/File
    //   3: dup
    //   4: getstatic 98	org/osmdroid/tileprovider/modules/TileWriter:TILE_PATH_BASE	Ljava/io/File;
    //   7: new 102	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: aload_2
    //   16: invokeinterface 189 2 0
    //   21: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc -65
    //   26: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 194	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 197	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 94	java/io/File:exists	()Z
    //   45: ifne +13 -> 58
    //   48: aload_0
    //   49: aload_2
    //   50: invokespecial 199	org/osmdroid/tileprovider/modules/TileWriter:createFolderAndCheckIfExists	(Ljava/io/File;)Z
    //   53: ifne +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: aconst_null
    //   59: astore 6
    //   61: aconst_null
    //   62: astore_2
    //   63: new 201	java/io/BufferedOutputStream
    //   66: dup
    //   67: new 203	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokevirtual 206	java/io/File:getPath	()Ljava/lang/String;
    //   75: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   78: sipush 8192
    //   81: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   84: astore_1
    //   85: aload_3
    //   86: aload_1
    //   87: invokestatic 217	org/osmdroid/tileprovider/util/StreamUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   90: lstore 4
    //   92: getstatic 46	org/osmdroid/tileprovider/modules/TileWriter:mUsedCacheSpace	J
    //   95: lload 4
    //   97: ladd
    //   98: putstatic 46	org/osmdroid/tileprovider/modules/TileWriter:mUsedCacheSpace	J
    //   101: getstatic 46	org/osmdroid/tileprovider/modules/TileWriter:mUsedCacheSpace	J
    //   104: ldc2_w 218
    //   107: lcmp
    //   108: ifle +7 -> 115
    //   111: aload_0
    //   112: invokespecial 58	org/osmdroid/tileprovider/modules/TileWriter:cutCurrentCache	()V
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokestatic 223	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_1
    //   126: aload_2
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull -73 -> 56
    //   132: aload_1
    //   133: invokestatic 223	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_2
    //   139: aload 6
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokestatic 223	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
    //   150: aload_2
    //   151: athrow
    //   152: astore_2
    //   153: goto -11 -> 142
    //   156: astore_2
    //   157: goto -29 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	TileWriter
    //   0	160	1	paramITileSource	org.osmdroid.tileprovider.tilesource.ITileSource
    //   0	160	2	paramMapTile	org.osmdroid.tileprovider.MapTile
    //   0	160	3	paramInputStream	java.io.InputStream
    //   90	6	4	l	long
    //   59	81	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	85	125	java/io/IOException
    //   63	85	138	finally
    //   85	115	152	finally
    //   85	115	156	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/TileWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */