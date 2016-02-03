package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

public abstract interface ForeignCollection<T>
  extends Collection<T>, CloseableIterable<T>
{
  public abstract boolean add(T paramT);
  
  public abstract void closeLastIterator()
    throws SQLException;
  
  public abstract CloseableIterator<T> closeableIterator(int paramInt);
  
  public abstract CloseableWrappedIterable<T> getWrappedIterable();
  
  public abstract CloseableWrappedIterable<T> getWrappedIterable(int paramInt);
  
  public abstract boolean isEager();
  
  public abstract CloseableIterator<T> iterator(int paramInt);
  
  public abstract CloseableIterator<T> iteratorThrow()
    throws SQLException;
  
  public abstract CloseableIterator<T> iteratorThrow(int paramInt)
    throws SQLException;
  
  public abstract int refresh(T paramT)
    throws SQLException;
  
  public abstract int refreshAll()
    throws SQLException;
  
  public abstract int refreshCollection()
    throws SQLException;
  
  public abstract int update(T paramT)
    throws SQLException;
  
  public abstract int updateAll()
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/ForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */