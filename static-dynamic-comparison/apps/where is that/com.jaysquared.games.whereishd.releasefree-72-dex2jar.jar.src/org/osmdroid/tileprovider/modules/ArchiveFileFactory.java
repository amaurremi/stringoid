package org.osmdroid.tileprovider.modules;

import android.database.sqlite.SQLiteException;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchiveFileFactory
{
  private static final Logger logger = LoggerFactory.getLogger(ArchiveFileFactory.class);
  
  public static IArchiveFile getArchiveFile(File paramFile)
  {
    if (paramFile.getName().endsWith(".zip")) {
      try
      {
        ZipFileArchive localZipFileArchive = ZipFileArchive.getZipFileArchive(paramFile);
        return localZipFileArchive;
      }
      catch (IOException localIOException)
      {
        logger.error("Error opening ZIP file", localIOException);
      }
    }
    if (paramFile.getName().endsWith(".sqlite")) {
      try
      {
        DatabaseFileArchive localDatabaseFileArchive = DatabaseFileArchive.getDatabaseFileArchive(paramFile);
        return localDatabaseFileArchive;
      }
      catch (SQLiteException localSQLiteException1)
      {
        logger.error("Error opening SQL file", localSQLiteException1);
      }
    }
    if (paramFile.getName().endsWith(".mbtiles")) {
      try
      {
        MBTilesFileArchive localMBTilesFileArchive = MBTilesFileArchive.getDatabaseFileArchive(paramFile);
        return localMBTilesFileArchive;
      }
      catch (SQLiteException localSQLiteException2)
      {
        logger.error("Error opening MBTiles SQLite file", localSQLiteException2);
      }
    }
    if (paramFile.getName().endsWith(".gemf")) {
      try
      {
        paramFile = GEMFFileArchive.getGEMFFileArchive(paramFile);
        return paramFile;
      }
      catch (IOException paramFile)
      {
        logger.error("Error opening GEMF file", paramFile);
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/ArchiveFileFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */