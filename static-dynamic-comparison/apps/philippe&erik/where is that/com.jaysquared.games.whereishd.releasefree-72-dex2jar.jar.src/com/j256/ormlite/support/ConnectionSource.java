package com.j256.ormlite.support;

import com.j256.ormlite.db.DatabaseType;
import java.sql.SQLException;

public abstract interface ConnectionSource
{
  public abstract void clearSpecialConnection(DatabaseConnection paramDatabaseConnection);
  
  public abstract void close()
    throws SQLException;
  
  public abstract void closeQuietly();
  
  public abstract DatabaseType getDatabaseType();
  
  public abstract DatabaseConnection getReadOnlyConnection()
    throws SQLException;
  
  public abstract DatabaseConnection getReadWriteConnection()
    throws SQLException;
  
  public abstract DatabaseConnection getSpecialConnection();
  
  public abstract boolean isOpen();
  
  public abstract void releaseConnection(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
  
  public abstract boolean saveSpecialConnection(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/support/ConnectionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */