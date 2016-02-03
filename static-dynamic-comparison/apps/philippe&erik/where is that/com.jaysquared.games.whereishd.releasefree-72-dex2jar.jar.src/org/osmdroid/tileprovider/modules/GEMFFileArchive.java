package org.osmdroid.tileprovider.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.util.GEMFFile;

public class GEMFFileArchive
  implements IArchiveFile
{
  private final GEMFFile mFile;
  
  private GEMFFileArchive(File paramFile)
    throws FileNotFoundException, IOException
  {
    this.mFile = new GEMFFile(paramFile);
  }
  
  public static GEMFFileArchive getGEMFFileArchive(File paramFile)
    throws FileNotFoundException, IOException
  {
    return new GEMFFileArchive(paramFile);
  }
  
  public void close()
  {
    try
    {
      this.mFile.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public InputStream getInputStream(ITileSource paramITileSource, MapTile paramMapTile)
  {
    return this.mFile.getInputStream(paramMapTile.getX(), paramMapTile.getY(), paramMapTile.getZoomLevel());
  }
  
  public String toString()
  {
    return "GEMFFileArchive [mGEMFFile=" + this.mFile.getName() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/GEMFFileArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */