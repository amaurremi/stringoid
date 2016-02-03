package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawResultsImpl<T>
  implements GenericRawResults<T>
{
  private final String[] columnNames;
  private SelectIterator<T, Void> iterator;
  
  public RawResultsImpl(ConnectionSource paramConnectionSource, DatabaseConnection paramDatabaseConnection, String paramString, Class<?> paramClass, CompiledStatement paramCompiledStatement, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws SQLException
  {
    this.iterator = new SelectIterator(paramClass, null, paramGenericRowMapper, paramConnectionSource, paramDatabaseConnection, paramCompiledStatement, paramString, paramObjectCache);
    this.columnNames = this.iterator.getRawResults().getColumnNames();
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
    return this.iterator;
  }
  
  public String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public T getFirstResult()
    throws SQLException
  {
    try
    {
      if (this.iterator.hasNextThrow())
      {
        Object localObject1 = this.iterator.nextThrow();
        return (T)localObject1;
      }
      return null;
    }
    finally
    {
      close();
    }
  }
  
  public int getNumberColumns()
  {
    return this.columnNames.length;
  }
  
  public List<T> getResults()
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.iterator.hasNext()) {
        localArrayList.add(this.iterator.next());
      }
      return localList;
    }
    finally
    {
      this.iterator.close();
    }
  }
  
  public CloseableIterator<T> iterator()
  {
    return this.iterator;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/RawResultsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */