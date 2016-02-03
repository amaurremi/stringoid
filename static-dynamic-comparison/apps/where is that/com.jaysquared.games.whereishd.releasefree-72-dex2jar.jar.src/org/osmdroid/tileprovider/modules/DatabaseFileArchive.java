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

public class DatabaseFileArchive
  implements IArchiveFile
{
  private static final Logger logger = LoggerFactory.getLogger(DatabaseFileArchive.class);
  private final SQLiteDatabase mDatabase;
  
  private DatabaseFileArchive(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mDatabase = paramSQLiteDatabase;
  }
  
  public static DatabaseFileArchive getDatabaseFileArchive(File paramFile)
    throws SQLiteException
  {
    return new DatabaseFileArchive(SQLiteDatabase.openOrCreateDatabase(paramFile, null));
  }
  
  public void close()
  {
    this.mDatabase.close();
  }
  
  public InputStream getInputStream(ITileSource paramITileSource, MapTile paramMapTile)
  {
    Object localObject1 = null;
    try
    {
      long l1 = paramMapTile.getX();
      long l2 = paramMapTile.getY();
      long l3 = paramMapTile.getZoomLevel();
      int i = (int)l3;
      int j = (int)l3;
      Object localObject2 = this.mDatabase;
      paramITileSource = "key = " + (((l3 << i) + l1 << j) + l2) + " and provider = '" + paramITileSource.name() + "'";
      localObject2 = ((SQLiteDatabase)localObject2).query("tiles", new String[] { "tile" }, paramITileSource, null, null, null, null);
      paramITileSource = (ITileSource)localObject1;
      if (((Cursor)localObject2).getCount() != 0)
      {
        ((Cursor)localObject2).moveToFirst();
        paramITileSource = new ByteArrayInputStream(((Cursor)localObject2).getBlob(0));
      }
      ((Cursor)localObject2).close();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/DatabaseFileArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */