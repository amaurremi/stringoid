package com.j256.ormlite.table;

import java.lang.reflect.Constructor;
import java.sql.SQLException;

public abstract interface ObjectFactory<T>
{
  public abstract T createObject(Constructor<T> paramConstructor, Class<T> paramClass)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/table/ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */