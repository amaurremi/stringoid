package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

public abstract interface GenericRawResults<T>
  extends CloseableWrappedIterable<T>
{
  public abstract void close()
    throws SQLException;
  
  public abstract String[] getColumnNames();
  
  public abstract T getFirstResult()
    throws SQLException;
  
  public abstract int getNumberColumns();
  
  public abstract List<T> getResults()
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/GenericRawResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */