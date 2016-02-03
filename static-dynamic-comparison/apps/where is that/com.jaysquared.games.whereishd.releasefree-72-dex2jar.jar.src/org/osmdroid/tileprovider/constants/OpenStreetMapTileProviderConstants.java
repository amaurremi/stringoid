package org.osmdroid.tileprovider.constants;

import android.os.Environment;
import java.io.File;

public abstract interface OpenStreetMapTileProviderConstants
{
  public static final int CACHE_MAPTILECOUNT_DEFAULT = 9;
  public static final boolean DEBUGMODE = false;
  public static final boolean DEBUG_TILE_PROVIDERS = false;
  public static final long DEFAULT_MAXIMUM_CACHED_FILE_AGE = 604800000L;
  public static final int MAXIMUM_ZOOMLEVEL = 22;
  public static final int MINIMUM_ZOOMLEVEL = 0;
  public static final int NUMBER_OF_TILE_DOWNLOAD_THREADS = 2;
  public static final int NUMBER_OF_TILE_FILESYSTEM_THREADS = 8;
  public static final long ONE_DAY = 86400000L;
  public static final long ONE_HOUR = 3600000L;
  public static final long ONE_MINUTE = 60000L;
  public static final long ONE_SECOND = 1000L;
  public static final long ONE_WEEK = 604800000L;
  public static final long ONE_YEAR = 31536000000L;
  public static final File OSMDROID_PATH = new File(Environment.getExternalStorageDirectory(), "osmdroid");
  public static final int TILE_DOWNLOAD_MAXIMUM_QUEUE_SIZE = 40;
  public static final long TILE_EXPIRY_TIME_MILLISECONDS = 2592000000L;
  public static final int TILE_FILESYSTEM_MAXIMUM_QUEUE_SIZE = 40;
  public static final long TILE_MAX_CACHE_SIZE_BYTES = 629145600L;
  public static final File TILE_PATH_BASE = new File(OSMDROID_PATH, "tiles");
  public static final String TILE_PATH_EXTENSION = ".tile";
  public static final long TILE_TRIM_CACHE_SIZE_BYTES = 524288000L;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/constants/OpenStreetMapTileProviderConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */