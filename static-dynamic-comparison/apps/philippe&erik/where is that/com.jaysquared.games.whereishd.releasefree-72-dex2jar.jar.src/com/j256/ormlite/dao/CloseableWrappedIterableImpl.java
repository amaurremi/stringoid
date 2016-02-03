package com.j256.ormlite.dao;

import java.sql.SQLException;

public class CloseableWrappedIterableImpl<T>
  implements CloseableWrappedIterable<T>
{
  private final CloseableIterable<T> iterable;
  private CloseableIterator<T> iterator;
  
  public CloseableWrappedIterableImpl(CloseableIterable<T> paramCloseableIterable)
  {
    this.iterable = paramCloseableIterable;
  }
  
  public void close()
    throws SQLException
  {
    if (this.iterator != null)
    {
      this.iterator.close();
      this.iterator = null;
    }
  }
  
  public CloseableIterator<T> closeableIterator()
  {
    try
    {
      close();
      this.iterator = this.iterable.closeableIterator();
      return this.iterator;
    }
    catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
  
  public CloseableIterator<T> iterator()
  {
    return closeableIterator();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/CloseableWrappedIterableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */