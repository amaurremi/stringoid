package org.osmdroid.tileprovider.tilesource;

import android.content.Context;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.util.ManifestUtil;

public class MapBoxTileSource
  extends OnlineTileSourceBase
{
  private static final String MAPBOX_MAPID = "MAPBOX_MAPID";
  private static final String[] mapBoxBaseUrl = { "http://a.tiles.mapbox.com/v3/", "http://b.tiles.mapbox.com/v3/", "http://c.tiles.mapbox.com/v3/", "http://d.tiles.mapbox.com/v3/" };
  private static String mapBoxMapId = "";
  
  public MapBoxTileSource()
  {
    super("mbtiles", ResourceProxy.string.mapbox, 1, 18, 256, ".png", mapBoxBaseUrl);
  }
  
  public MapBoxTileSource(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2, mapBoxBaseUrl);
  }
  
  public MapBoxTileSource(String paramString1, ResourceProxy.string paramstring, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramstring, paramInt1, paramInt2, paramInt3, paramString2, new String[] { paramString4 });
  }
  
  public static String getMapBoxMapId()
  {
    return mapBoxMapId;
  }
  
  public static void retrieveMapBoxMapId(Context paramContext)
  {
    mapBoxMapId = ManifestUtil.retrieveKey(paramContext, "MAPBOX_MAPID");
  }
  
  public String getTileURLString(MapTile paramMapTile)
  {
    StringBuffer localStringBuffer = new StringBuffer(getBaseUrl());
    localStringBuffer.append(getMapBoxMapId());
    localStringBuffer.append("/");
    localStringBuffer.append(paramMapTile.getZoomLevel());
    localStringBuffer.append("/");
    localStringBuffer.append(paramMapTile.getX());
    localStringBuffer.append("/");
    localStringBuffer.append(paramMapTile.getY());
    localStringBuffer.append(".png");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/MapBoxTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */