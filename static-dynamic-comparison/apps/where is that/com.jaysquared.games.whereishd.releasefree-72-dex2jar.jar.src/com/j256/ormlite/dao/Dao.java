package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract interface Dao<T, ID>
  extends CloseableIterable<T>
{
  public abstract void assignEmptyForeignCollection(T paramT, String paramString)
    throws SQLException;
  
  public abstract <CT> CT callBatchTasks(Callable<CT> paramCallable)
    throws Exception;
  
  public abstract void clearObjectCache();
  
  public abstract void closeLastIterator()
    throws SQLException;
  
  public abstract void commit(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
  
  public abstract long countOf()
    throws SQLException;
  
  public abstract long countOf(PreparedQuery<T> paramPreparedQuery)
    throws SQLException;
  
  public abstract int create(T paramT)
    throws SQLException;
  
  public abstract T createIfNotExists(T paramT)
    throws SQLException;
  
  public abstract CreateOrUpdateStatus createOrUpdate(T paramT)
    throws SQLException;
  
  public abstract int delete(PreparedDelete<T> paramPreparedDelete)
    throws SQLException;
  
  public abstract int delete(T paramT)
    throws SQLException;
  
  public abstract int delete(Collection<T> paramCollection)
    throws SQLException;
  
  public abstract DeleteBuilder<T, ID> deleteBuilder();
  
  public abstract int deleteById(ID paramID)
    throws SQLException;
  
  public abstract int deleteIds(Collection<ID> paramCollection)
    throws SQLException;
  
  public abstract void endThreadConnection(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
  
  public abstract int executeRaw(String paramString, String... paramVarArgs)
    throws SQLException;
  
  public abstract int executeRawNoArgs(String paramString)
    throws SQLException;
  
  public abstract ID extractId(T paramT)
    throws SQLException;
  
  public abstract FieldType findForeignFieldType(Class<?> paramClass);
  
  public abstract ConnectionSource getConnectionSource();
  
  public abstract Class<T> getDataClass();
  
  public abstract <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString)
    throws SQLException;
  
  public abstract ObjectCache getObjectCache();
  
  public abstract RawRowMapper<T> getRawRowMapper();
  
  public abstract GenericRowMapper<T> getSelectStarRowMapper()
    throws SQLException;
  
  public abstract CloseableWrappedIterable<T> getWrappedIterable();
  
  public abstract CloseableWrappedIterable<T> getWrappedIterable(PreparedQuery<T> paramPreparedQuery);
  
  public abstract boolean idExists(ID paramID)
    throws SQLException;
  
  @Deprecated
  public abstract boolean isAutoCommit()
    throws SQLException;
  
  public abstract boolean isAutoCommit(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
  
  public abstract boolean isTableExists()
    throws SQLException;
  
  public abstract boolean isUpdatable();
  
  public abstract CloseableIterator<T> iterator();
  
  public abstract CloseableIterator<T> iterator(int paramInt);
  
  public abstract CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery)
    throws SQLException;
  
  public abstract CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
    throws SQLException;
  
  public abstract T mapSelectStarRow(DatabaseResults paramDatabaseResults)
    throws SQLException;
  
  public abstract String objectToString(T paramT);
  
  public abstract boolean objectsEqual(T paramT1, T paramT2)
    throws SQLException;
  
  public abstract List<T> query(PreparedQuery<T> paramPreparedQuery)
    throws SQLException;
  
  public abstract QueryBuilder<T, ID> queryBuilder();
  
  public abstract List<T> queryForAll()
    throws SQLException;
  
  public abstract List<T> queryForEq(String paramString, Object paramObject)
    throws SQLException;
  
  public abstract List<T> queryForFieldValues(Map<String, Object> paramMap)
    throws SQLException;
  
  public abstract List<T> queryForFieldValuesArgs(Map<String, Object> paramMap)
    throws SQLException;
  
  public abstract T queryForFirst(PreparedQuery<T> paramPreparedQuery)
    throws SQLException;
  
  public abstract T queryForId(ID paramID)
    throws SQLException;
  
  public abstract List<T> queryForMatching(T paramT)
    throws SQLException;
  
  public abstract List<T> queryForMatchingArgs(T paramT)
    throws SQLException;
  
  public abstract T queryForSameId(T paramT)
    throws SQLException;
  
  public abstract <UO> GenericRawResults<UO> queryRaw(String paramString, RawRowMapper<UO> paramRawRowMapper, String... paramVarArgs)
    throws SQLException;
  
  public abstract <UO> GenericRawResults<UO> queryRaw(String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String... paramVarArgs)
    throws SQLException;
  
  public abstract GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String... paramVarArgs)
    throws SQLException;
  
  public abstract GenericRawResults<String[]> queryRaw(String paramString, String... paramVarArgs)
    throws SQLException;
  
  public abstract long queryRawValue(String paramString, String... paramVarArgs)
    throws SQLException;
  
  public abstract int refresh(T paramT)
    throws SQLException;
  
  public abstract void rollBack(DatabaseConnection paramDatabaseConnection)
    throws SQLException;
  
  public abstract void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean)
    throws SQLException;
  
  @Deprecated
  public abstract void setAutoCommit(boolean paramBoolean)
    throws SQLException;
  
  public abstract void setObjectCache(ObjectCache paramObjectCache)
    throws SQLException;
  
  public abstract void setObjectCache(boolean paramBoolean)
    throws SQLException;
  
  public abstract void setObjectFactory(ObjectFactory<T> paramObjectFactory);
  
  public abstract DatabaseConnection startThreadConnection()
    throws SQLException;
  
  public abstract int update(PreparedUpdate<T> paramPreparedUpdate)
    throws SQLException;
  
  public abstract int update(T paramT)
    throws SQLException;
  
  public abstract UpdateBuilder<T, ID> updateBuilder();
  
  public abstract int updateId(T paramT, ID paramID)
    throws SQLException;
  
  public abstract int updateRaw(String paramString, String... paramVarArgs)
    throws SQLException;
  
  public static class CreateOrUpdateStatus
  {
    private boolean created;
    private int numLinesChanged;
    private boolean updated;
    
    public CreateOrUpdateStatus(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.created = paramBoolean1;
      this.updated = paramBoolean2;
      this.numLinesChanged = paramInt;
    }
    
    public int getNumLinesChanged()
    {
      return this.numLinesChanged;
    }
    
    public boolean isCreated()
    {
      return this.created;
    }
    
    public boolean isUpdated()
    {
      return this.updated;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/Dao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */