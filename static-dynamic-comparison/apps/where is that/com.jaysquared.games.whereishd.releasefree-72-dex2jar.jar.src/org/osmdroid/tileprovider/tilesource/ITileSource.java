package org.osmdroid.tileprovider.tilesource;

import android.graphics.drawable.Drawable;
import java.io.InputStream;
import org.osmdroid.ResourceProxy;
import org.osmdroid.tileprovider.MapTile;

public abstract interface ITileSource
{
  public abstract Drawable getDrawable(InputStream paramInputStream)
    throws BitmapTileSourceBase.LowMemoryException;
  
  public abstract Drawable getDrawable(String paramString)
    throws BitmapTileSourceBase.LowMemoryException;
  
  public abstract int getMaximumZoomLevel();
  
  public abstract int getMinimumZoomLevel();
  
  public abstract String getTileRelativeFilenameString(MapTile paramMapTile);
  
  public abstract int getTileSizePixels();
  
  public abstract String localizedName(ResourceProxy paramResourceProxy);
  
  public abstract String name();
  
  public abstract int ordinal();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/ITileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */