package org.osmdroid.tileprovider.tilesource;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;

public class XYTileSource
  extends OnlineTileSourceBase
{
  public XYTileSource(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2, paramArrayOfString);
  }
  
  public String getTileURLString(MapTile paramMapTile)
  {
    return getBaseUrl() + paramMapTile.getZoomLevel() + "/" + paramMapTile.getX() + "/" + paramMapTile.getY() + this.mImageFilenameEnding;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/XYTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */