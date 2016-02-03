package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Iterator;

public abstract interface CloseableIterator<T>
  extends Iterator<T>
{
  public abstract void close()
    throws SQLException;
  
  public abstract void closeQuietly();
  
  public abstract T current()
    throws SQLException;
  
  public abstract T first()
    throws SQLException;
  
  public abstract DatabaseResults getRawResults();
  
  public abstract T moveRelative(int paramInt)
    throws SQLException;
  
  public abstract void moveToNext();
  
  public abstract T nextThrow()
    throws SQLException;
  
  public abstract T previous()
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/CloseableIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */