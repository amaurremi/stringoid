package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class SelectIterator<T, ID>
  implements CloseableIterator<T>
{
  private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
  private boolean alreadyMoved;
  private final Dao<T, ID> classDao;
  private boolean closed;
  private final CompiledStatement compiledStmt;
  private final DatabaseConnection connection;
  private final ConnectionSource connectionSource;
  private final Class<?> dataClass;
  private boolean first = true;
  private T last;
  private final DatabaseResults results;
  private int rowC;
  private final GenericRowMapper<T> rowMapper;
  private final String statement;
  
  public SelectIterator(Class<?> paramClass, Dao<T, ID> paramDao, GenericRowMapper<T> paramGenericRowMapper, ConnectionSource paramConnectionSource, DatabaseConnection paramDatabaseConnection, CompiledStatement paramCompiledStatement, String paramString, ObjectCache paramObjectCache)
    throws SQLException
  {
    this.dataClass = paramClass;
    this.classDao = paramDao;
    this.rowMapper = paramGenericRowMapper;
    this.connectionSource = paramConnectionSource;
    this.connection = paramDatabaseConnection;
    this.compiledStmt = paramCompiledStatement;
    this.results = paramCompiledStatement.runQuery(paramObjectCache);
    this.statement = paramString;
    if (paramString != null) {
      logger.debug("starting iterator @{} for '{}'", Integer.valueOf(hashCode()), paramString);
    }
  }
  
  private T getCurrent()
    throws SQLException
  {
    this.last = this.rowMapper.mapRow(this.results);
    this.alreadyMoved = false;
    this.rowC += 1;
    return (T)this.last;
  }
  
  public void close()
    throws SQLException
  {
    if (!this.closed)
    {
      this.compiledStmt.close();
      this.closed = true;
      this.last = null;
      if (this.statement != null) {
        logger.debug("closed iterator @{} after {} rows", Integer.valueOf(hashCode()), Integer.valueOf(this.rowC));
      }
      this.connectionSource.releaseConnection(this.connection);
    }
  }
  
  public void closeQuietly()
  {
    try
    {
      close();
      return;
    }
    catch (SQLException localSQLException) {}
  }
  
  public T current()
    throws SQLException
  {
    if (this.closed) {
      return null;
    }
    if (this.first) {
      return (T)first();
    }
    return (T)getCurrent();
  }
  
  public T first()
    throws SQLException
  {
    if (this.closed) {}
    do
    {
      return null;
      this.first = false;
    } while (!this.results.first());
    return (T)getCurrent();
  }
  
  public DatabaseResults getRawResults()
  {
    return this.results;
  }
  
  public boolean hasNext()
  {
    try
    {
      boolean bool = hasNextThrow();
      return bool;
    }
    catch (SQLException localSQLException)
    {
      this.last = null;
      closeQuietly();
      throw new IllegalStateException("Errors getting more results of " + this.dataClass, localSQLException);
    }
  }
  
  public boolean hasNextThrow()
    throws SQLException
  {
    if (this.closed) {
      return false;
    }
    if (this.alreadyMoved) {
      return true;
    }
    if (this.first) {
      this.first = false;
    }
    for (boolean bool = this.results.first();; bool = this.results.next())
    {
      if (!bool) {
        close();
      }
      this.alreadyMoved = true;
      return bool;
    }
  }
  
  public T moveRelative(int paramInt)
    throws SQLException
  {
    if (this.closed) {}
    do
    {
      return null;
      this.first = false;
    } while (!this.results.moveRelative(paramInt));
    return (T)getCurrent();
  }
  
  public void moveToNext()
  {
    this.last = null;
    this.first = false;
    this.alreadyMoved = false;
  }
  
  public T next()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = nextThrow();
      if (localObject2 != null) {
        return (T)localObject2;
      }
    }
    catch (SQLException localSQLException)
    {
      this.last = null;
      closeQuietly();
      throw new IllegalStateException("Could not get next result for " + this.dataClass, localSQLException);
    }
  }
  
  public T nextThrow()
    throws SQLException
  {
    if (this.closed) {
      return null;
    }
    if (!this.alreadyMoved)
    {
      if (this.first) {
        this.first = false;
      }
      for (boolean bool = this.results.first(); !bool; bool = this.results.next())
      {
        this.first = false;
        return null;
      }
    }
    this.first = false;
    return (T)getCurrent();
  }
  
  public T previous()
    throws SQLException
  {
    if (this.closed) {}
    do
    {
      return null;
      this.first = false;
    } while (!this.results.previous());
    return (T)getCurrent();
  }
  
  public void remove()
  {
    try
    {
      removeThrow();
      return;
    }
    catch (SQLException localSQLException)
    {
      closeQuietly();
      throw new IllegalStateException("Could not delete " + this.dataClass + " object " + this.last, localSQLException);
    }
  }
  
  public void removeThrow()
    throws SQLException
  {
    if (this.last == null) {
      throw new IllegalStateException("No last " + this.dataClass + " object to remove. Must be called after a call to next.");
    }
    if (this.classDao == null) {
      throw new IllegalStateException("Cannot remove " + this.dataClass + " object because classDao not initialized");
    }
    try
    {
      this.classDao.delete(this.last);
      return;
    }
    finally
    {
      this.last = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/SelectIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */