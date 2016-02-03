package org.osmdroid.tileprovider.tilesource;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;

public abstract class OnlineTileSourceBase
  extends BitmapTileSourceBase
{
  private final String[] mBaseUrls;
  
  public OnlineTileSourceBase(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2);
    this.mBaseUrls = paramArrayOfString;
  }
  
  protected String getBaseUrl()
  {
    return this.mBaseUrls[this.random.nextInt(this.mBaseUrls.length)];
  }
  
  public abstract String getTileURLString(MapTile paramMapTile);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/OnlineTileSourceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */