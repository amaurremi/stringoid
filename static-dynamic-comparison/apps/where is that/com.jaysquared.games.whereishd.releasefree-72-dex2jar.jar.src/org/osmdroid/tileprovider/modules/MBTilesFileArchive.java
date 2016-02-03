package org.osmdroid.tileprovider.modules;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MBTilesFileArchive
  implements IArchiveFile
{
  public static final String COL_TILES_TILE_COLUMN = "tile_column";
  public static final String COL_TILES_TILE_DATA = "tile_data";
  public static final String COL_TILES_TILE_ROW = "tile_row";
  public static final String COL_TILES_ZOOM_LEVEL = "zoom_level";
  public static final String TABLE_TILES = "tiles";
  private static final Logger logger = LoggerFactory.getLogger(MBTilesFileArchive.class);
  private final SQLiteDatabase mDatabase;
  
  private MBTilesFileArchive(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  public static MBTilesFileArchive getDatabaseFileArchive(File paramFile)
    throws SQLiteException
  {
    return new MBTilesFileArchive(SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, 17));
  }
  
  public void close()
  {
    this.mDatabase.close();
  }
  
  public InputStream getInputStream(ITileSource paramITileSource, MapTile paramMapTile)
  {
    paramITileSource = null;
    try
    {
      Object localObject = Integer.toString(paramMapTile.getX());
      String str1 = Double.toString(Math.pow(2.0D, paramMapTile.getZoomLevel()) - paramMapTile.getY() - 1.0D);
      String str2 = Integer.toString(paramMapTile.getZoomLevel());
      localObject = this.mDatabase.query("tiles", new String[] { "tile_data" }, "tile_column=? and tile_row=? and zoom_level=?", new String[] { localObject, str1, str2 }, null, null, null);
      if (((Cursor)localObject).getCount() != 0)
      {
        ((Cursor)localObject).moveToFirst();
        paramITileSource = new ByteArrayInputStream(((Cursor)localObject).getBlob(0));
      }
      ((Cursor)localObject).close();
      if (paramITileSource != null) {
        return paramITileSource;
      }
    }
    catch (Throwable paramITileSource)
    {
      logger.warn("Error getting db stream: " + paramMapTile, paramITileSource);
    }
    return null;
  }
  
  public String toString()
  {
    return "DatabaseFileArchive [mDatabase=" + this.mDatabase.getPath() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/MBTilesFileArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */