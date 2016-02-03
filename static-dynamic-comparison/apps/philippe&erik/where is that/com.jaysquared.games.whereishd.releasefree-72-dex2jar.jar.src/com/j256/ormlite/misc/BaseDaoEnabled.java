package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

public abstract class BaseDaoEnabled<T, ID>
{
  protected transient Dao<T, ID> dao;
  
  private void checkForDao()
    throws SQLException
  {
    if (this.dao == null) {
      throw new SQLException("Dao has not been set on " + getClass() + " object: " + this);
    }
  }
  
  public int create()
    throws SQLException
  {
    checkForDao();
    return this.dao.create(this);
  }
  
  public int delete()
    throws SQLException
  {
    checkForDao();
    return this.dao.delete(this);
  }
  
  public ID extractId()
    throws SQLException
  {
    checkForDao();
    return (ID)this.dao.extractId(this);
  }
  
  public Dao<T, ID> getDao()
  {
    return this.dao;
  }
  
  public String objectToString()
  {
    try
    {
      checkForDao();
      return this.dao.objectToString(this);
    }
    catch (SQLException localSQLException)
    {
      throw new IllegalArgumentException(localSQLException);
    }
  }
  
  public boolean objectsEqual(T paramT)
    throws SQLException
  {
    checkForDao();
    return this.dao.objectsEqual(this, paramT);
  }
  
  public int refresh()
    throws SQLException
  {
    checkForDao();
    return this.dao.refresh(this);
  }
  
  public void setDao(Dao<T, ID> paramDao)
  {
    this.dao = paramDao;
  }
  
  public int update()
    throws SQLException
  {
    checkForDao();
    return this.dao.update(this);
  }
  
  public int updateId(ID paramID)
    throws SQLException
  {
    checkForDao();
    return this.dao.updateId(this, paramID);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/misc/BaseDaoEnabled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */