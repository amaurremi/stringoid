package org.osmdroid.tileprovider.tilesource;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.util.CloudmadeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudmadeTileSource
  extends OnlineTileSourceBase
  implements IStyledTileSource<Integer>
{
  private static final Logger logger = LoggerFactory.getLogger(CloudmadeTileSource.class);
  private Integer mStyle = Integer.valueOf(1);
  
  public CloudmadeTileSource(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2, paramArrayOfString);
  }
  
  public Integer getStyle()
  {
    return this.mStyle;
  }
  
  public String getTileURLString(MapTile paramMapTile)
  {
    String str1 = CloudmadeUtil.getCloudmadeKey();
    if (str1.length() == 0) {
      logger.error("CloudMade key is not set. You should enter it in the manifest and call CloudmadeUtil.retrieveCloudmadeKey()");
    }
    String str2 = CloudmadeUtil.getCloudmadeToken();
    return String.format(getBaseUrl(), new Object[] { str1, this.mStyle, Integer.valueOf(getTileSizePixels()), Integer.valueOf(paramMapTile.getZoomLevel()), Integer.valueOf(paramMapTile.getX()), Integer.valueOf(paramMapTile.getY()), this.mImageFilenameEnding, str2 });
  }
  
  public String pathBase()
  {
    if ((this.mStyle == null) || (this.mStyle.intValue() <= 1)) {
      return this.mName;
    }
    return this.mName + this.mStyle;
  }
  
  public void setStyle(Integer paramInteger)
  {
    this.mStyle = paramInteger;
  }
  
  public void setStyle(String paramString)
  {
    try
    {
      this.mStyle = Integer.valueOf(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      logger.warn("Error setting integer style: " + paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/CloudmadeTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */