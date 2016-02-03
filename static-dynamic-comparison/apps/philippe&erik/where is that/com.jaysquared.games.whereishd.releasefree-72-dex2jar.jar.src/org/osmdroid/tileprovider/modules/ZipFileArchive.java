package org.osmdroid.tileprovider.modules;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipFileArchive
  implements IArchiveFile
{
  private static final Logger logger = LoggerFactory.getLogger(ZipFileArchive.class);
  private final ZipFile mZipFile;
  
  private ZipFileArchive(ZipFile paramZipFile)
  {
    this.mZipFile = paramZipFile;
  }
  
  public static ZipFileArchive getZipFileArchive(File paramFile)
    throws ZipException, IOException
  {
    return new ZipFileArchive(new ZipFile(paramFile));
  }
  
  public void close()
  {
    try
    {
      this.mZipFile.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public InputStream getInputStream(ITileSource paramITileSource, MapTile paramMapTile)
  {
    paramITileSource = paramITileSource.getTileRelativeFilenameString(paramMapTile);
    try
    {
      paramITileSource = this.mZipFile.getEntry(paramITileSource);
      if (paramITileSource != null)
      {
        paramITileSource = this.mZipFile.getInputStream(paramITileSource);
        return paramITileSource;
      }
    }
    catch (IOException paramITileSource)
    {
      logger.warn("Error getting zip stream: " + paramMapTile, paramITileSource);
    }
    return null;
  }
  
  public String toString()
  {
    return "ZipFileArchive [mZipFile=" + this.mZipFile.getName() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/ZipFileArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */