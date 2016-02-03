package com.j256.ormlite.dao;

public abstract interface CloseableIterable<T>
  extends Iterable<T>
{
  public abstract CloseableIterator<T> closeableIterator();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/CloseableIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */