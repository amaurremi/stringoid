package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.SelectIterator;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public abstract class BaseDaoImpl<T, ID>
  implements Dao<T, ID>
{
  private static final ThreadLocal<DaoConfigArray> daoConfigLevelLocal = new ThreadLocal()
  {
    protected BaseDaoImpl.DaoConfigArray initialValue()
    {
      return new BaseDaoImpl.DaoConfigArray(null);
    }
  };
  private static ReferenceObjectCache defaultObjectCache;
  protected ConnectionSource connectionSource;
  protected final Class<T> dataClass;
  protected DatabaseType databaseType;
  private boolean initialized;
  protected CloseableIterator<T> lastIterator;
  private ObjectCache objectCache;
  protected ObjectFactory<T> objectFactory;
  protected StatementExecutor<T, ID> statementExecutor;
  protected DatabaseTableConfig<T> tableConfig;
  protected TableInfo<T, ID> tableInfo;
  
  protected BaseDaoImpl(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    this(paramConnectionSource, paramDatabaseTableConfig.getDataClass(), paramDatabaseTableConfig);
  }
  
  protected BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    this(paramConnectionSource, paramClass, null);
  }
  
  private BaseDaoImpl(ConnectionSource paramConnectionSource, Class<T> paramClass, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    this.dataClass = paramClass;
    this.tableConfig = paramDatabaseTableConfig;
    if (paramConnectionSource != null)
    {
      this.connectionSource = paramConnectionSource;
      initialize();
    }
  }
  
  protected BaseDaoImpl(Class<T> paramClass)
    throws SQLException
  {
    this(null, paramClass, null);
  }
  
  public static void clearAllInternalObjectCaches()
  {
    try
    {
      if (defaultObjectCache != null)
      {
        defaultObjectCache.clearAll();
        defaultObjectCache = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    new BaseDaoImpl(paramConnectionSource, paramDatabaseTableConfig) {};
  }
  
  static <T, ID> Dao<T, ID> createDao(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    new BaseDaoImpl(paramConnectionSource, paramClass) {};
  }
  
  private CloseableIterator<T> createIterator(int paramInt)
  {
    try
    {
      SelectIterator localSelectIterator = this.statementExecutor.buildIterator(this, this.connectionSource, paramInt, this.objectCache);
      return localSelectIterator;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("Could not build iterator for " + this.dataClass, localException);
    }
  }
  
  private CloseableIterator<T> createIterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
    throws SQLException
  {
    try
    {
      paramPreparedQuery = this.statementExecutor.buildIterator(this, this.connectionSource, paramPreparedQuery, this.objectCache, paramInt);
      return paramPreparedQuery;
    }
    catch (SQLException paramPreparedQuery)
    {
      throw SqlExceptionUtil.create("Could not build prepared-query iterator for " + this.dataClass, paramPreparedQuery);
    }
  }
  
  private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T paramT, String paramString)
    throws SQLException
  {
    checkForInitialized();
    Object localObject;
    FieldType[] arrayOfFieldType;
    int j;
    int i;
    if (paramT == null)
    {
      localObject = null;
      arrayOfFieldType = this.tableInfo.getFieldTypes();
      j = arrayOfFieldType.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label92;
      }
      FieldType localFieldType = arrayOfFieldType[i];
      if (localFieldType.getColumnName().equals(paramString))
      {
        paramString = localFieldType.buildForeignCollection(paramT, localObject);
        if (paramT != null) {
          localFieldType.assignField(paramT, paramString, true, null);
        }
        return paramString;
        localObject = extractId(paramT);
        break;
      }
      i += 1;
    }
    label92:
    throw new IllegalArgumentException("Could not find a field named " + paramString);
  }
  
  private List<T> queryForFieldValues(Map<String, Object> paramMap, boolean paramBoolean)
    throws SQLException
  {
    checkForInitialized();
    QueryBuilder localQueryBuilder = queryBuilder();
    Where localWhere = localQueryBuilder.where();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = localEntry.getValue();
      Object localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = new SelectArg(localObject2);
      }
      localWhere.eq((String)localEntry.getKey(), localObject1);
    }
    if (paramMap.size() == 0) {
      return Collections.emptyList();
    }
    localWhere.and(paramMap.size());
    return localQueryBuilder.query();
  }
  
  private List<T> queryForMatching(T paramT, boolean paramBoolean)
    throws SQLException
  {
    checkForInitialized();
    QueryBuilder localQueryBuilder = queryBuilder();
    Where localWhere = localQueryBuilder.where();
    int j = 0;
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int m = arrayOfFieldType.length;
    int i = 0;
    while (i < m)
    {
      FieldType localFieldType = arrayOfFieldType[i];
      Object localObject2 = localFieldType.getFieldValueIfNotDefault(paramT);
      int k = j;
      if (localObject2 != null)
      {
        Object localObject1 = localObject2;
        if (paramBoolean) {
          localObject1 = new SelectArg(localObject2);
        }
        localWhere.eq(localFieldType.getColumnName(), localObject1);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j == 0) {
      return Collections.emptyList();
    }
    localWhere.and(j);
    return localQueryBuilder.query();
  }
  
  public void assignEmptyForeignCollection(T paramT, String paramString)
    throws SQLException
  {
    makeEmptyForeignCollection(paramT, paramString);
  }
  
  public <CT> CT callBatchTasks(Callable<CT> paramCallable)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      boolean bool = this.connectionSource.saveSpecialConnection(localDatabaseConnection);
      paramCallable = this.statementExecutor.callBatchTasks(localDatabaseConnection, bool, paramCallable);
      return paramCallable;
    }
    finally
    {
      this.connectionSource.clearSpecialConnection(localDatabaseConnection);
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  protected void checkForInitialized()
  {
    if (!this.initialized) {
      throw new IllegalStateException("you must call initialize() before you can use the dao");
    }
  }
  
  public void clearObjectCache()
  {
    if (this.objectCache != null) {
      this.objectCache.clear(this.dataClass);
    }
  }
  
  public void closeLastIterator()
    throws SQLException
  {
    if (this.lastIterator != null)
    {
      this.lastIterator.close();
      this.lastIterator = null;
    }
  }
  
  public CloseableIterator<T> closeableIterator()
  {
    return iterator(-1);
  }
  
  public void commit(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    paramDatabaseConnection.commit(null);
  }
  
  public long countOf()
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      long l = this.statementExecutor.queryForCountStar(localDatabaseConnection);
      return l;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public long countOf(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    if (paramPreparedQuery.getType() != StatementBuilder.StatementType.SELECT_LONG) {
      throw new IllegalArgumentException("Prepared query is not of type " + StatementBuilder.StatementType.SELECT_LONG + ", did you call QueryBuilder.setCountOf(true)?");
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      long l = this.statementExecutor.queryForLong(localDatabaseConnection, paramPreparedQuery);
      return l;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int create(T paramT)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {
      return 0;
    }
    if ((paramT instanceof BaseDaoEnabled)) {
      ((BaseDaoEnabled)paramT).setDao(this);
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.create(localDatabaseConnection, paramT, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public T createIfNotExists(T paramT)
    throws SQLException
  {
    if (paramT == null) {
      return null;
    }
    Object localObject = queryForSameId(paramT);
    if (localObject == null)
    {
      create(paramT);
      return paramT;
    }
    return (T)localObject;
  }
  
  public Dao.CreateOrUpdateStatus createOrUpdate(T paramT)
    throws SQLException
  {
    if (paramT == null) {
      return new Dao.CreateOrUpdateStatus(false, false, 0);
    }
    Object localObject = extractId(paramT);
    if ((localObject == null) || (!idExists(localObject))) {
      return new Dao.CreateOrUpdateStatus(true, false, create(paramT));
    }
    return new Dao.CreateOrUpdateStatus(false, true, update(paramT));
  }
  
  public int delete(PreparedDelete<T> paramPreparedDelete)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.delete(localDatabaseConnection, paramPreparedDelete);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int delete(T paramT)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.delete(localDatabaseConnection, paramT, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int delete(Collection<T> paramCollection)
    throws SQLException
  {
    checkForInitialized();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.deleteObjects(localDatabaseConnection, paramCollection, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public DeleteBuilder<T, ID> deleteBuilder()
  {
    checkForInitialized();
    return new DeleteBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public int deleteById(ID paramID)
    throws SQLException
  {
    checkForInitialized();
    if (paramID == null) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.deleteById(localDatabaseConnection, paramID, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int deleteIds(Collection<ID> paramCollection)
    throws SQLException
  {
    checkForInitialized();
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.deleteIds(localDatabaseConnection, paramCollection, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public void endThreadConnection(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    this.connectionSource.clearSpecialConnection(paramDatabaseConnection);
    this.connectionSource.releaseConnection(paramDatabaseConnection);
  }
  
  public int executeRaw(String paramString, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.executeRaw(localDatabaseConnection, paramString, paramVarArgs);
      return i;
    }
    catch (SQLException paramVarArgs)
    {
      throw SqlExceptionUtil.create("Could not run raw execute statement " + paramString, paramVarArgs);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int executeRawNoArgs(String paramString)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.executeRawNoArgs(localDatabaseConnection, paramString);
      return i;
    }
    catch (SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Could not run raw execute statement " + paramString, localSQLException);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public ID extractId(T paramT)
    throws SQLException
  {
    checkForInitialized();
    FieldType localFieldType = this.tableInfo.getIdField();
    if (localFieldType == null) {
      throw new SQLException("Class " + this.dataClass + " does not have an id field");
    }
    return (ID)localFieldType.extractJavaFieldValue(paramT);
  }
  
  public FieldType findForeignFieldType(Class<?> paramClass)
  {
    checkForInitialized();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    int i = 0;
    while (i < j)
    {
      FieldType localFieldType = arrayOfFieldType[i];
      if (localFieldType.getType() == paramClass) {
        return localFieldType;
      }
      i += 1;
    }
    return null;
  }
  
  public ConnectionSource getConnectionSource()
  {
    return this.connectionSource;
  }
  
  public Class<T> getDataClass()
  {
    return this.dataClass;
  }
  
  public <FT> ForeignCollection<FT> getEmptyForeignCollection(String paramString)
    throws SQLException
  {
    return makeEmptyForeignCollection(null, paramString);
  }
  
  public ObjectCache getObjectCache()
  {
    return this.objectCache;
  }
  
  public ObjectFactory<T> getObjectFactory()
  {
    return this.objectFactory;
  }
  
  public RawRowMapper<T> getRawRowMapper()
  {
    return this.statementExecutor.getRawRowMapper();
  }
  
  public GenericRowMapper<T> getSelectStarRowMapper()
    throws SQLException
  {
    return this.statementExecutor.getSelectStarRowMapper();
  }
  
  public DatabaseTableConfig<T> getTableConfig()
  {
    return this.tableConfig;
  }
  
  public TableInfo<T, ID> getTableInfo()
  {
    return this.tableInfo;
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    checkForInitialized();
    new CloseableWrappedIterableImpl(new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          CloseableIterator localCloseableIterator = BaseDaoImpl.this.createIterator(-1);
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          throw new IllegalStateException("Could not build iterator for " + BaseDaoImpl.this.dataClass, localException);
        }
      }
      
      public Iterator<T> iterator()
      {
        return closeableIterator();
      }
    });
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> paramPreparedQuery)
  {
    checkForInitialized();
    new CloseableWrappedIterableImpl(new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          CloseableIterator localCloseableIterator = BaseDaoImpl.this.createIterator(paramPreparedQuery, -1);
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          throw new IllegalStateException("Could not build prepared-query iterator for " + BaseDaoImpl.this.dataClass, localException);
        }
      }
      
      public Iterator<T> iterator()
      {
        return closeableIterator();
      }
    });
  }
  
  public boolean idExists(ID paramID)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      boolean bool = this.statementExecutor.ifExists(localDatabaseConnection, paramID);
      return bool;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public void initialize()
    throws SQLException
  {
    if (this.initialized) {
      return;
    }
    if (this.connectionSource == null) {
      throw new IllegalStateException("connectionSource was never set on " + getClass().getSimpleName());
    }
    this.databaseType = this.connectionSource.getDatabaseType();
    if (this.databaseType == null) {
      throw new IllegalStateException("connectionSource is getting a null DatabaseType in " + getClass().getSimpleName());
    }
    if (this.tableConfig == null) {}
    DaoConfigArray localDaoConfigArray;
    for (this.tableInfo = new TableInfo(this.connectionSource, this, this.dataClass);; this.tableInfo = new TableInfo(this.databaseType, this, this.tableConfig))
    {
      this.statementExecutor = new StatementExecutor(this.databaseType, this.tableInfo, this);
      localDaoConfigArray = (DaoConfigArray)daoConfigLevelLocal.get();
      if (localDaoConfigArray.size() <= 0) {
        break;
      }
      localDaoConfigArray.addDao(this);
      return;
      this.tableConfig.extractFieldTypes(this.connectionSource);
    }
    localDaoConfigArray.addDao(this);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= localDaoConfigArray.size()) {
          break;
        }
        BaseDaoImpl localBaseDaoImpl = localDaoConfigArray.get(i);
        DaoManager.registerDao(this.connectionSource, localBaseDaoImpl);
        try
        {
          FieldType[] arrayOfFieldType = localBaseDaoImpl.getTableInfo().getFieldTypes();
          int k = arrayOfFieldType.length;
          int j = 0;
          if (j < k)
          {
            arrayOfFieldType[j].configDaoInformation(this.connectionSource, localBaseDaoImpl.getDataClass());
            j += 1;
            continue;
            localObject = finally;
          }
        }
        catch (SQLException localSQLException)
        {
          DaoManager.unregisterDao(this.connectionSource, localBaseDaoImpl);
          throw localSQLException;
        }
        ((BaseDaoImpl)localObject).initialized = true;
      }
      finally
      {
        localDaoConfigArray.clear();
      }
      i += 1;
    }
    localDaoConfigArray.clear();
  }
  
  public boolean isAutoCommit()
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      boolean bool = isAutoCommit(localDatabaseConnection);
      return bool;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public boolean isAutoCommit(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    return paramDatabaseConnection.isAutoCommit();
  }
  
  public boolean isTableExists()
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      boolean bool = localDatabaseConnection.isTableExists(this.tableInfo.getTableName());
      return bool;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public boolean isUpdatable()
  {
    return this.tableInfo.isUpdatable();
  }
  
  public CloseableIterator<T> iterator()
  {
    return iterator(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt)
  {
    checkForInitialized();
    this.lastIterator = createIterator(paramInt);
    return this.lastIterator;
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    return iterator(paramPreparedQuery, -1);
  }
  
  public CloseableIterator<T> iterator(PreparedQuery<T> paramPreparedQuery, int paramInt)
    throws SQLException
  {
    checkForInitialized();
    this.lastIterator = createIterator(paramPreparedQuery, paramInt);
    return this.lastIterator;
  }
  
  public T mapSelectStarRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    return (T)this.statementExecutor.getSelectStarRowMapper().mapRow(paramDatabaseResults);
  }
  
  public String objectToString(T paramT)
  {
    checkForInitialized();
    return this.tableInfo.objectToString(paramT);
  }
  
  public boolean objectsEqual(T paramT1, T paramT2)
    throws SQLException
  {
    checkForInitialized();
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    int i = 0;
    while (i < j)
    {
      FieldType localFieldType = arrayOfFieldType[i];
      Object localObject1 = localFieldType.extractJavaFieldValue(paramT1);
      Object localObject2 = localFieldType.extractJavaFieldValue(paramT2);
      if (!localFieldType.getDataPersister().dataIsEqual(localObject1, localObject2)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public List<T> query(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    return this.statementExecutor.query(this.connectionSource, paramPreparedQuery, this.objectCache);
  }
  
  public QueryBuilder<T, ID> queryBuilder()
  {
    checkForInitialized();
    return new QueryBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public List<T> queryForAll()
    throws SQLException
  {
    checkForInitialized();
    return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
  }
  
  public List<T> queryForEq(String paramString, Object paramObject)
    throws SQLException
  {
    return queryBuilder().where().eq(paramString, paramObject).query();
  }
  
  public List<T> queryForFieldValues(Map<String, Object> paramMap)
    throws SQLException
  {
    return queryForFieldValues(paramMap, false);
  }
  
  public List<T> queryForFieldValuesArgs(Map<String, Object> paramMap)
    throws SQLException
  {
    return queryForFieldValues(paramMap, true);
  }
  
  public T queryForFirst(PreparedQuery<T> paramPreparedQuery)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      paramPreparedQuery = this.statementExecutor.queryForFirst(localDatabaseConnection, paramPreparedQuery, this.objectCache);
      return paramPreparedQuery;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public T queryForId(ID paramID)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      paramID = this.statementExecutor.queryForId(localDatabaseConnection, paramID, this.objectCache);
      return paramID;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public List<T> queryForMatching(T paramT)
    throws SQLException
  {
    return queryForMatching(paramT, false);
  }
  
  public List<T> queryForMatchingArgs(T paramT)
    throws SQLException
  {
    return queryForMatching(paramT, true);
  }
  
  public T queryForSameId(T paramT)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {}
    do
    {
      return null;
      paramT = extractId(paramT);
    } while (paramT == null);
    return (T)queryForId(paramT);
  }
  
  public <GR> GenericRawResults<GR> queryRaw(String paramString, RawRowMapper<GR> paramRawRowMapper, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      paramRawRowMapper = this.statementExecutor.queryRaw(this.connectionSource, paramString, paramRawRowMapper, paramVarArgs, this.objectCache);
      return paramRawRowMapper;
    }
    catch (SQLException paramRawRowMapper)
    {
      throw SqlExceptionUtil.create("Could not perform raw query for " + paramString, paramRawRowMapper);
    }
  }
  
  public <UO> GenericRawResults<UO> queryRaw(String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      paramArrayOfDataType = this.statementExecutor.queryRaw(this.connectionSource, paramString, paramArrayOfDataType, paramRawRowObjectMapper, paramVarArgs, this.objectCache);
      return paramArrayOfDataType;
    }
    catch (SQLException paramArrayOfDataType)
    {
      throw SqlExceptionUtil.create("Could not perform raw query for " + paramString, paramArrayOfDataType);
    }
  }
  
  public GenericRawResults<Object[]> queryRaw(String paramString, DataType[] paramArrayOfDataType, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      paramArrayOfDataType = this.statementExecutor.queryRaw(this.connectionSource, paramString, paramArrayOfDataType, paramVarArgs, this.objectCache);
      return paramArrayOfDataType;
    }
    catch (SQLException paramArrayOfDataType)
    {
      throw SqlExceptionUtil.create("Could not perform raw query for " + paramString, paramArrayOfDataType);
    }
  }
  
  public GenericRawResults<String[]> queryRaw(String paramString, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    try
    {
      paramVarArgs = this.statementExecutor.queryRaw(this.connectionSource, paramString, paramVarArgs, this.objectCache);
      return paramVarArgs;
    }
    catch (SQLException paramVarArgs)
    {
      throw SqlExceptionUtil.create("Could not perform raw query for " + paramString, paramVarArgs);
    }
  }
  
  public long queryRawValue(String paramString, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      long l = this.statementExecutor.queryForLong(localDatabaseConnection, paramString, paramVarArgs);
      return l;
    }
    catch (SQLException paramVarArgs)
    {
      throw SqlExceptionUtil.create("Could not perform raw value query for " + paramString, paramVarArgs);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int refresh(T paramT)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {
      return 0;
    }
    if ((paramT instanceof BaseDaoEnabled)) {
      ((BaseDaoEnabled)paramT).setDao(this);
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadOnlyConnection();
    try
    {
      int i = this.statementExecutor.refresh(localDatabaseConnection, paramT, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public void rollBack(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    paramDatabaseConnection.rollback(null);
  }
  
  public void setAutoCommit(DatabaseConnection paramDatabaseConnection, boolean paramBoolean)
    throws SQLException
  {
    paramDatabaseConnection.setAutoCommit(paramBoolean);
  }
  
  public void setAutoCommit(boolean paramBoolean)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      setAutoCommit(localDatabaseConnection, paramBoolean);
      return;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public void setConnectionSource(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
  }
  
  public void setObjectCache(ObjectCache paramObjectCache)
    throws SQLException
  {
    if (paramObjectCache == null)
    {
      if (this.objectCache != null)
      {
        this.objectCache.clear(this.dataClass);
        this.objectCache = null;
      }
      return;
    }
    if ((this.objectCache != null) && (this.objectCache != paramObjectCache)) {
      this.objectCache.clear(this.dataClass);
    }
    if (this.tableInfo.getIdField() == null) {
      throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
    }
    this.objectCache = paramObjectCache;
    this.objectCache.registerClass(this.dataClass);
  }
  
  public void setObjectCache(boolean paramBoolean)
    throws SQLException
  {
    if (paramBoolean) {
      if (this.objectCache == null) {
        if (this.tableInfo.getIdField() == null) {
          throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
        }
      }
    }
    while (this.objectCache == null) {
      try
      {
        if (defaultObjectCache == null) {
          defaultObjectCache = ReferenceObjectCache.makeWeakCache();
        }
        this.objectCache = defaultObjectCache;
        this.objectCache.registerClass(this.dataClass);
        return;
      }
      finally {}
    }
    this.objectCache.clear(this.dataClass);
    this.objectCache = null;
  }
  
  public void setObjectFactory(ObjectFactory<T> paramObjectFactory)
  {
    checkForInitialized();
    this.objectFactory = paramObjectFactory;
  }
  
  public void setTableConfig(DatabaseTableConfig<T> paramDatabaseTableConfig)
  {
    this.tableConfig = paramDatabaseTableConfig;
  }
  
  public DatabaseConnection startThreadConnection()
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    this.connectionSource.saveSpecialConnection(localDatabaseConnection);
    return localDatabaseConnection;
  }
  
  public int update(PreparedUpdate<T> paramPreparedUpdate)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.update(localDatabaseConnection, paramPreparedUpdate);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int update(T paramT)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.update(localDatabaseConnection, paramT, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public UpdateBuilder<T, ID> updateBuilder()
  {
    checkForInitialized();
    return new UpdateBuilder(this.databaseType, this.tableInfo, this);
  }
  
  public int updateId(T paramT, ID paramID)
    throws SQLException
  {
    checkForInitialized();
    if (paramT == null) {
      return 0;
    }
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.updateId(localDatabaseConnection, paramT, paramID, this.objectCache);
      return i;
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public int updateRaw(String paramString, String... paramVarArgs)
    throws SQLException
  {
    checkForInitialized();
    DatabaseConnection localDatabaseConnection = this.connectionSource.getReadWriteConnection();
    try
    {
      int i = this.statementExecutor.updateRaw(localDatabaseConnection, paramString, paramVarArgs);
      return i;
    }
    catch (SQLException paramVarArgs)
    {
      throw SqlExceptionUtil.create("Could not run raw update statement " + paramString, paramVarArgs);
    }
    finally
    {
      this.connectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  private static class DaoConfigArray
  {
    private BaseDaoImpl<?, ?>[] daoArray = new BaseDaoImpl[10];
    private int daoArrayC = 0;
    
    public void addDao(BaseDaoImpl<?, ?> paramBaseDaoImpl)
    {
      if (this.daoArrayC == this.daoArray.length)
      {
        arrayOfBaseDaoImpl = new BaseDaoImpl[this.daoArray.length * 2];
        i = 0;
        while (i < this.daoArray.length)
        {
          arrayOfBaseDaoImpl[i] = this.daoArray[i];
          this.daoArray[i] = null;
          i += 1;
        }
        this.daoArray = arrayOfBaseDaoImpl;
      }
      BaseDaoImpl[] arrayOfBaseDaoImpl = this.daoArray;
      int i = this.daoArrayC;
      this.daoArrayC = (i + 1);
      arrayOfBaseDaoImpl[i] = paramBaseDaoImpl;
    }
    
    public void clear()
    {
      int i = 0;
      while (i < this.daoArrayC)
      {
        this.daoArray[i] = null;
        i += 1;
      }
      this.daoArrayC = 0;
    }
    
    public BaseDaoImpl<?, ?> get(int paramInt)
    {
      return this.daoArray[paramInt];
    }
    
    public int size()
    {
      return this.daoArrayC;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/BaseDaoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */