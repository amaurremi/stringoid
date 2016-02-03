package org.osmdroid.tileprovider.modules;

import java.io.InputStream;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.ITileSource;

public abstract interface IFilesystemCache
{
  public abstract boolean saveFile(ITileSource paramITileSource, MapTile paramMapTile, InputStream paramInputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/IFilesystemCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */