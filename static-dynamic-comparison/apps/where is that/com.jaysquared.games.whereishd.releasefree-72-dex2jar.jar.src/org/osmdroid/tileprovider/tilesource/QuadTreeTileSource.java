package org.osmdroid.tileprovider.tilesource;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;

public class QuadTreeTileSource
  extends OnlineTileSourceBase
{
  public QuadTreeTileSource(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2, paramArrayOfString);
  }
  
  public String getTileURLString(MapTile paramMapTile)
  {
    return getBaseUrl() + quadTree(paramMapTile) + this.mImageFilenameEnding;
  }
  
  protected String quadTree(MapTile paramMapTile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramMapTile.getZoomLevel();
    while (j > 0)
    {
      int i = 0;
      int m = 1 << j - 1;
      if ((paramMapTile.getX() & m) != 0) {
        i = 0 + 1;
      }
      int k = i;
      if ((paramMapTile.getY() & m) != 0) {
        k = i + 2;
      }
      localStringBuilder.append("" + k);
      j -= 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/QuadTreeTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */