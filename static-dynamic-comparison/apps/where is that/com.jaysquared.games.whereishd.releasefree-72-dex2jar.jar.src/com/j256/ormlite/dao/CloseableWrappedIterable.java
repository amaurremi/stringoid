package com.j256.ormlite.dao;

import java.sql.SQLException;

public abstract interface CloseableWrappedIterable<T>
  extends CloseableIterable<T>
{
  public abstract void close()
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/CloseableWrappedIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */