package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

public class AndroidConnectionSource
  extends BaseConnectionSource
  implements ConnectionSource
{
  private static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
  private AndroidDatabaseConnection connection = null;
  private final DatabaseType databaseType = new SqliteAndroidDatabaseType();
  private final SQLiteOpenHelper helper;
  private volatile boolean isOpen = true;
  private final SQLiteDatabase sqliteDatabase;
  
  public AndroidConnectionSource(SQLiteDatabase paramSQLiteDatabase)
  {
    this.helper = null;
    this.sqliteDatabase = paramSQLiteDatabase;
  }
  
  public AndroidConnectionSource(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.helper = paramSQLiteOpenHelper;
    this.sqliteDatabase = null;
  }
  
  public void clearSpecialConnection(DatabaseConnection paramDatabaseConnection)
  {
    clearSpecial(paramDatabaseConnection, logger);
  }
  
  public void close()
  {
    this.isOpen = false;
  }
  
  public void closeQuietly()
  {
    close();
  }
  
  public DatabaseType getDatabaseType()
  {
    return this.databaseType;
  }
  
  public DatabaseConnection getReadOnlyConnection()
    throws java.sql.SQLException
  {
    return getReadWriteConnection();
  }
  
  public DatabaseConnection getReadWriteConnection()
    throws java.sql.SQLException
  {
    Object localObject = getSavedConnection();
    if (localObject != null) {
      return (DatabaseConnection)localObject;
    }
    if (this.connection == null) {
      if (this.sqliteDatabase != null) {}
    }
    for (;;)
    {
      try
      {
        localObject = this.helper.getWritableDatabase();
        this.connection = new AndroidDatabaseConnection((SQLiteDatabase)localObject, true);
        logger.trace("created connection {} for db {}, helper {}", this.connection, localObject, this.helper);
        return this.connection;
      }
      catch (android.database.SQLException localSQLException)
      {
        throw SqlExceptionUtil.create("Getting a writable database from helper " + this.helper + " failed", localSQLException);
      }
      SQLiteDatabase localSQLiteDatabase = this.sqliteDatabase;
      continue;
      logger.trace("{}: returning read-write connection {}, helper {}", this, this.connection, this.helper);
    }
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  public void releaseConnection(DatabaseConnection paramDatabaseConnection) {}
  
  public boolean saveSpecialConnection(DatabaseConnection paramDatabaseConnection)
    throws java.sql.SQLException
  {
    return saveSpecial(paramDatabaseConnection);
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/AndroidConnectionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */