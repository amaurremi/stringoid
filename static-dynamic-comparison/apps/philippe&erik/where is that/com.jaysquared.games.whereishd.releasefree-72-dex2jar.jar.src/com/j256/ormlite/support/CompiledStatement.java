package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract interface CompiledStatement
{
  public abstract void close()
    throws SQLException;
  
  public abstract void closeQuietly();
  
  public abstract int getColumnCount()
    throws SQLException;
  
  public abstract String getColumnName(int paramInt)
    throws SQLException;
  
  public abstract int runExecute()
    throws SQLException;
  
  public abstract DatabaseResults runQuery(ObjectCache paramObjectCache)
    throws SQLException;
  
  public abstract int runUpdate()
    throws SQLException;
  
  public abstract void setMaxRows(int paramInt)
    throws SQLException;
  
  public abstract void setObject(int paramInt, Object paramObject, SqlType paramSqlType)
    throws SQLException;
  
  public abstract void setQueryTimeout(long paramLong)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/support/CompiledStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */