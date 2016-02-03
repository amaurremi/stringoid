package org.osmdroid.tileprovider.tilesource;

import java.util.ArrayList;
import java.util.Iterator;
import org.osmdroid.ResourceProxy.string;

public class TileSourceFactory
{
  public static final OnlineTileSourceBase BASE;
  public static final OnlineTileSourceBase BASE_OVERLAY_NL;
  public static final OnlineTileSourceBase CLOUDMADESMALLTILES;
  public static final OnlineTileSourceBase CLOUDMADESTANDARDTILES;
  public static final OnlineTileSourceBase CYCLEMAP;
  public static final OnlineTileSourceBase DEFAULT_TILE_SOURCE;
  public static final OnlineTileSourceBase FIETS_OVERLAY_NL;
  public static final OnlineTileSourceBase HILLS;
  public static final OnlineTileSourceBase MAPNIK = new XYTileSource("Mapnik", ResourceProxy.string.mapnik, 0, 18, 256, ".png", new String[] { "http://a.tile.openstreetmap.org/", "http://b.tile.openstreetmap.org/", "http://c.tile.openstreetmap.org/" });
  public static final OnlineTileSourceBase MAPQUESTAERIAL;
  public static final OnlineTileSourceBase MAPQUESTOSM;
  public static final OnlineTileSourceBase PUBLIC_TRANSPORT;
  public static final OnlineTileSourceBase ROADS_OVERLAY_NL;
  public static final OnlineTileSourceBase TOPO;
  private static ArrayList<ITileSource> mTileSources;
  
  static
  {
    CYCLEMAP = new XYTileSource("CycleMap", ResourceProxy.string.cyclemap, 0, 17, 256, ".png", new String[] { "http://a.tile.opencyclemap.org/cycle/", "http://b.tile.opencyclemap.org/cycle/", "http://c.tile.opencyclemap.org/cycle/" });
    PUBLIC_TRANSPORT = new XYTileSource("OSMPublicTransport", ResourceProxy.string.public_transport, 0, 17, 256, ".png", new String[] { "http://openptmap.org/tiles/" });
    BASE = new XYTileSource("Base", ResourceProxy.string.base, 4, 17, 256, ".png", new String[] { "http://topo.openstreetmap.de/base/" });
    TOPO = new XYTileSource("Topo", ResourceProxy.string.topo, 4, 17, 256, ".png", new String[] { "http://topo.openstreetmap.de/topo/" });
    HILLS = new XYTileSource("Hills", ResourceProxy.string.hills, 8, 17, 256, ".png", new String[] { "http://topo.geofabrik.de/hills/" });
    CLOUDMADESTANDARDTILES = new CloudmadeTileSource("CloudMadeStandardTiles", ResourceProxy.string.cloudmade_standard, 0, 18, 256, ".png", new String[] { "http://a.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s", "http://b.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s", "http://c.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s" });
    CLOUDMADESMALLTILES = new CloudmadeTileSource("CloudMadeSmallTiles", ResourceProxy.string.cloudmade_small, 0, 21, 64, ".png", new String[] { "http://a.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s", "http://b.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s", "http://c.tile.cloudmade.com/%s/%d/%d/%d/%d/%d%s?token=%s" });
    MAPQUESTOSM = new XYTileSource("MapquestOSM", ResourceProxy.string.mapquest_osm, 0, 18, 256, ".png", new String[] { "http://otile1.mqcdn.com/tiles/1.0.0/map/", "http://otile2.mqcdn.com/tiles/1.0.0/map/", "http://otile3.mqcdn.com/tiles/1.0.0/map/", "http://otile4.mqcdn.com/tiles/1.0.0/map/" });
    MAPQUESTAERIAL = new XYTileSource("MapquestAerial", ResourceProxy.string.mapquest_aerial, 0, 11, 256, ".png", new String[] { "http://otile1.mqcdn.com/tiles/1.0.0/sat/", "http://otile2.mqcdn.com/tiles/1.0.0/sat/", "http://otile3.mqcdn.com/tiles/1.0.0/sat/", "http://otile4.mqcdn.com/tiles/1.0.0/sat/" });
    DEFAULT_TILE_SOURCE = MAPNIK;
    FIETS_OVERLAY_NL = new XYTileSource("Fiets", ResourceProxy.string.fiets_nl, 3, 18, 256, ".png", new String[] { "http://overlay.openstreetmap.nl/openfietskaart-overlay/" });
    BASE_OVERLAY_NL = new XYTileSource("BaseNL", ResourceProxy.string.base_nl, 0, 18, 256, ".png", new String[] { "http://overlay.openstreetmap.nl/basemap/" });
    ROADS_OVERLAY_NL = new XYTileSource("RoadsNL", ResourceProxy.string.roads_nl, 0, 18, 256, ".png", new String[] { "http://overlay.openstreetmap.nl/roads/" });
    mTileSources = new ArrayList();
    mTileSources.add(MAPNIK);
    mTileSources.add(CYCLEMAP);
    mTileSources.add(PUBLIC_TRANSPORT);
    mTileSources.add(BASE);
    mTileSources.add(TOPO);
    mTileSources.add(HILLS);
    mTileSources.add(CLOUDMADESTANDARDTILES);
    mTileSources.add(CLOUDMADESMALLTILES);
    mTileSources.add(MAPQUESTOSM);
    mTileSources.add(MAPQUESTAERIAL);
  }
  
  public static void addTileSource(ITileSource paramITileSource)
  {
    mTileSources.add(paramITileSource);
  }
  
  public static boolean containsTileSource(String paramString)
  {
    Iterator localIterator = mTileSources.iterator();
    while (localIterator.hasNext()) {
      if (((ITileSource)localIterator.next()).name().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static ITileSource getTileSource(int paramInt)
    throws IllegalArgumentException
  {
    Iterator localIterator = mTileSources.iterator();
    while (localIterator.hasNext())
    {
      ITileSource localITileSource = (ITileSource)localIterator.next();
      if (localITileSource.ordinal() == paramInt) {
        return localITileSource;
      }
    }
    throw new IllegalArgumentException("No tile source at position: " + paramInt);
  }
  
  public static ITileSource getTileSource(String paramString)
    throws IllegalArgumentException
  {
    Iterator localIterator = mTileSources.iterator();
    while (localIterator.hasNext())
    {
      ITileSource localITileSource = (ITileSource)localIterator.next();
      if (localITileSource.name().equals(paramString)) {
        return localITileSource;
      }
    }
    throw new IllegalArgumentException("No such tile source: " + paramString);
  }
  
  public static ArrayList<ITileSource> getTileSources()
  {
    return mTileSources;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/TileSourceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */