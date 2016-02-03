package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StatementExecutor<T, ID>
  implements GenericRowMapper<String[]>
{
  private static Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
  private static final FieldType[] noFieldTypes = new FieldType[0];
  private String countStarQuery;
  private final Dao<T, ID> dao;
  private final DatabaseType databaseType;
  private FieldType[] ifExistsFieldTypes;
  private String ifExistsQuery;
  private MappedDelete<T, ID> mappedDelete;
  private MappedCreate<T, ID> mappedInsert;
  private MappedQueryForId<T, ID> mappedQueryForId;
  private MappedRefresh<T, ID> mappedRefresh;
  private MappedUpdate<T, ID> mappedUpdate;
  private MappedUpdateId<T, ID> mappedUpdateId;
  private PreparedQuery<T> preparedQueryForAll;
  private RawRowMapper<T> rawRowMapper;
  private final TableInfo<T, ID> tableInfo;
  
  public StatementExecutor(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    this.databaseType = paramDatabaseType;
    this.tableInfo = paramTableInfo;
    this.dao = paramDao;
  }
  
  private void assignStatementArguments(CompiledStatement paramCompiledStatement, String[] paramArrayOfString)
    throws SQLException
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramCompiledStatement.setObject(i, paramArrayOfString[i], SqlType.STRING);
      i += 1;
    }
  }
  
  private void prepareQueryForAll()
    throws SQLException
  {
    if (this.preparedQueryForAll == null) {
      this.preparedQueryForAll = new QueryBuilder(this.databaseType, this.tableInfo, this.dao).prepare();
    }
  }
  
  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, int paramInt, ObjectCache paramObjectCache)
    throws SQLException
  {
    prepareQueryForAll();
    return buildIterator(paramBaseDaoImpl, paramConnectionSource, this.preparedQueryForAll, paramObjectCache, paramInt);
  }
  
  public SelectIterator<T, ID> buildIterator(BaseDaoImpl<T, ID> paramBaseDaoImpl, ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache, int paramInt)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadOnlyConnection();
    Object localObject = null;
    try
    {
      CompiledStatement localCompiledStatement = paramPreparedStmt.compile(localDatabaseConnection, StatementBuilder.StatementType.SELECT, paramInt);
      localObject = localCompiledStatement;
      paramBaseDaoImpl = new SelectIterator(this.tableInfo.getDataClass(), paramBaseDaoImpl, paramPreparedStmt, paramConnectionSource, localDatabaseConnection, localCompiledStatement, paramPreparedStmt.getStatement(), paramObjectCache);
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (0 != 0) {
        paramConnectionSource.releaseConnection(null);
      }
      return paramBaseDaoImpl;
    }
    finally
    {
      if (localObject != null) {
        ((CompiledStatement)localObject).close();
      }
      if (localDatabaseConnection != null) {
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }
  
  /* Error */
  public <CT> CT callBatchTasks(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, java.util.concurrent.Callable<CT> paramCallable)
    throws SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/j256/ormlite/stmt/StatementExecutor:databaseType	Lcom/j256/ormlite/db/DatabaseType;
    //   4: invokeinterface 173 1 0
    //   9: ifeq +16 -> 25
    //   12: aload_1
    //   13: iload_2
    //   14: aload_0
    //   15: getfield 77	com/j256/ormlite/stmt/StatementExecutor:databaseType	Lcom/j256/ormlite/db/DatabaseType;
    //   18: aload_3
    //   19: invokestatic 179	com/j256/ormlite/misc/TransactionManager:callInTransaction	(Lcom/j256/ormlite/support/DatabaseConnection;ZLcom/j256/ormlite/db/DatabaseType;Ljava/util/concurrent/Callable;)Ljava/lang/Object;
    //   22: astore_3
    //   23: aload_3
    //   24: areturn
    //   25: iconst_0
    //   26: istore 5
    //   28: iconst_0
    //   29: istore_2
    //   30: iload 5
    //   32: istore 4
    //   34: aload_1
    //   35: invokeinterface 184 1 0
    //   40: ifeq +56 -> 96
    //   43: iload 5
    //   45: istore 4
    //   47: aload_1
    //   48: invokeinterface 187 1 0
    //   53: istore 5
    //   55: iload 5
    //   57: istore_2
    //   58: iload 5
    //   60: ifeq +36 -> 96
    //   63: iload 5
    //   65: istore 4
    //   67: aload_1
    //   68: iconst_0
    //   69: invokeinterface 191 2 0
    //   74: iload 5
    //   76: istore 4
    //   78: getstatic 66	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   81: ldc -63
    //   83: aload_0
    //   84: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   87: invokevirtual 196	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   90: invokevirtual 202	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   93: iload 5
    //   95: istore_2
    //   96: iload_2
    //   97: istore 4
    //   99: aload_3
    //   100: invokeinterface 208 1 0
    //   105: astore 6
    //   107: aload 6
    //   109: astore_3
    //   110: iload_2
    //   111: ifeq -88 -> 23
    //   114: aload_1
    //   115: iconst_1
    //   116: invokeinterface 191 2 0
    //   121: getstatic 66	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   124: ldc -46
    //   126: aload_0
    //   127: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   130: invokevirtual 196	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   133: invokevirtual 202	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload 6
    //   138: areturn
    //   139: astore_3
    //   140: iload_2
    //   141: istore 4
    //   143: aload_3
    //   144: athrow
    //   145: astore_3
    //   146: iload 4
    //   148: ifeq +25 -> 173
    //   151: aload_1
    //   152: iconst_1
    //   153: invokeinterface 191 2 0
    //   158: getstatic 66	com/j256/ormlite/stmt/StatementExecutor:logger	Lcom/j256/ormlite/logger/Logger;
    //   161: ldc -46
    //   163: aload_0
    //   164: getfield 79	com/j256/ormlite/stmt/StatementExecutor:tableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   167: invokevirtual 196	com/j256/ormlite/table/TableInfo:getTableName	()Ljava/lang/String;
    //   170: invokevirtual 202	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   173: aload_3
    //   174: athrow
    //   175: astore_3
    //   176: iload_2
    //   177: istore 4
    //   179: ldc -44
    //   181: aload_3
    //   182: invokestatic 218	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	StatementExecutor
    //   0	186	1	paramDatabaseConnection	DatabaseConnection
    //   0	186	2	paramBoolean	boolean
    //   0	186	3	paramCallable	java.util.concurrent.Callable<CT>
    //   32	146	4	bool1	boolean
    //   26	68	5	bool2	boolean
    //   105	32	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	107	139	java/sql/SQLException
    //   34	43	145	finally
    //   47	55	145	finally
    //   67	74	145	finally
    //   78	93	145	finally
    //   99	107	145	finally
    //   143	145	145	finally
    //   179	186	145	finally
    //   99	107	175	java/lang/Exception
  }
  
  public int create(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedInsert == null) {
      this.mappedInsert = MappedCreate.build(this.databaseType, this.tableInfo);
    }
    return this.mappedInsert.insert(this.databaseType, paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int delete(DatabaseConnection paramDatabaseConnection, PreparedDelete<T> paramPreparedDelete)
    throws SQLException
  {
    paramDatabaseConnection = paramPreparedDelete.compile(paramDatabaseConnection, StatementBuilder.StatementType.DELETE);
    try
    {
      int i = paramDatabaseConnection.runUpdate();
      return i;
    }
    finally
    {
      paramDatabaseConnection.close();
    }
  }
  
  public int delete(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedDelete == null) {
      this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
    }
    return this.mappedDelete.delete(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int deleteById(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedDelete == null) {
      this.mappedDelete = MappedDelete.build(this.databaseType, this.tableInfo);
    }
    return this.mappedDelete.deleteById(paramDatabaseConnection, paramID, paramObjectCache);
  }
  
  public int deleteIds(DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    return MappedDeleteCollection.deleteIds(this.databaseType, this.tableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }
  
  public int deleteObjects(DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    return MappedDeleteCollection.deleteObjects(this.databaseType, this.tableInfo, paramDatabaseConnection, paramCollection, paramObjectCache);
  }
  
  public int executeRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    logger.debug("running raw execute statement: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("execute arguments: {}", paramArrayOfString);
    }
    paramDatabaseConnection = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
    try
    {
      assignStatementArguments(paramDatabaseConnection, paramArrayOfString);
      int i = paramDatabaseConnection.runExecute();
      return i;
    }
    finally
    {
      paramDatabaseConnection.close();
    }
  }
  
  public int executeRawNoArgs(DatabaseConnection paramDatabaseConnection, String paramString)
    throws SQLException
  {
    logger.debug("running raw execute statement: {}", paramString);
    return paramDatabaseConnection.executeStatement(paramString, -1);
  }
  
  public RawRowMapper<T> getRawRowMapper()
  {
    if (this.rawRowMapper == null) {
      this.rawRowMapper = new RawRowMapperImpl(this.tableInfo);
    }
    return this.rawRowMapper;
  }
  
  public GenericRowMapper<T> getSelectStarRowMapper()
    throws SQLException
  {
    prepareQueryForAll();
    return this.preparedQueryForAll;
  }
  
  public boolean ifExists(DatabaseConnection paramDatabaseConnection, ID paramID)
    throws SQLException
  {
    if (this.ifExistsQuery == null)
    {
      localObject = new QueryBuilder(this.databaseType, this.tableInfo, this.dao);
      ((QueryBuilder)localObject).selectRaw(new String[] { "COUNT(*)" });
      ((QueryBuilder)localObject).where().eq(this.tableInfo.getIdField().getColumnName(), new SelectArg());
      this.ifExistsQuery = ((QueryBuilder)localObject).prepareStatementString();
      this.ifExistsFieldTypes = new FieldType[] { this.tableInfo.getIdField() };
    }
    Object localObject = this.ifExistsQuery;
    FieldType[] arrayOfFieldType = this.ifExistsFieldTypes;
    long l = paramDatabaseConnection.queryForLong((String)localObject, new Object[] { paramID }, arrayOfFieldType);
    logger.debug("query of '{}' returned {}", this.ifExistsQuery, Long.valueOf(l));
    return l != 0L;
  }
  
  public String[] mapRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    int j = paramDatabaseResults.getColumnCount();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = paramDatabaseResults.getString(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public List<T> query(ConnectionSource paramConnectionSource, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache)
    throws SQLException
  {
    paramConnectionSource = buildIterator(null, paramConnectionSource, paramPreparedStmt, paramObjectCache, -1);
    try
    {
      paramObjectCache = new ArrayList();
      while (paramConnectionSource.hasNextThrow()) {
        paramObjectCache.add(paramConnectionSource.nextThrow());
      }
      logger.debug("query of '{}' returned {} results", paramPreparedStmt.getStatement(), Integer.valueOf(paramObjectCache.size()));
    }
    finally
    {
      paramConnectionSource.close();
    }
    paramConnectionSource.close();
    return paramObjectCache;
  }
  
  public List<T> queryForAll(ConnectionSource paramConnectionSource, ObjectCache paramObjectCache)
    throws SQLException
  {
    prepareQueryForAll();
    return query(paramConnectionSource, this.preparedQueryForAll, paramObjectCache);
  }
  
  public long queryForCountStar(DatabaseConnection paramDatabaseConnection)
    throws SQLException
  {
    if (this.countStarQuery == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("SELECT COUNT(*) FROM ");
      this.databaseType.appendEscapedEntityName(localStringBuilder, this.tableInfo.getTableName());
      this.countStarQuery = localStringBuilder.toString();
    }
    long l = paramDatabaseConnection.queryForLong(this.countStarQuery);
    logger.debug("query of '{}' returned {}", this.countStarQuery, Long.valueOf(l));
    return l;
  }
  
  public T queryForFirst(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt, ObjectCache paramObjectCache)
    throws SQLException
  {
    CompiledStatement localCompiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, StatementBuilder.StatementType.SELECT);
    paramDatabaseConnection = null;
    try
    {
      paramObjectCache = localCompiledStatement.runQuery(paramObjectCache);
      paramDatabaseConnection = paramObjectCache;
      if (paramObjectCache.first())
      {
        paramDatabaseConnection = paramObjectCache;
        logger.debug("query-for-first of '{}' returned at least 1 result", paramPreparedStmt.getStatement());
        paramDatabaseConnection = paramObjectCache;
        paramPreparedStmt = paramPreparedStmt.mapRow(paramObjectCache);
        return paramPreparedStmt;
      }
      paramDatabaseConnection = paramObjectCache;
      logger.debug("query-for-first of '{}' returned at 0 results", paramPreparedStmt.getStatement());
      return null;
    }
    finally
    {
      if (paramDatabaseConnection != null) {
        paramDatabaseConnection.close();
      }
      localCompiledStatement.close();
    }
  }
  
  public T queryForId(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedQueryForId == null) {
      this.mappedQueryForId = MappedQueryForId.build(this.databaseType, this.tableInfo, null);
    }
    return (T)this.mappedQueryForId.execute(paramDatabaseConnection, paramID, paramObjectCache);
  }
  
  public long queryForLong(DatabaseConnection paramDatabaseConnection, PreparedStmt<T> paramPreparedStmt)
    throws SQLException
  {
    CompiledStatement localCompiledStatement = paramPreparedStmt.compile(paramDatabaseConnection, StatementBuilder.StatementType.SELECT_LONG);
    paramDatabaseConnection = null;
    try
    {
      DatabaseResults localDatabaseResults = localCompiledStatement.runQuery(null);
      paramDatabaseConnection = localDatabaseResults;
      if (localDatabaseResults.first())
      {
        paramDatabaseConnection = localDatabaseResults;
        long l = localDatabaseResults.getLong(0);
        return l;
      }
      paramDatabaseConnection = localDatabaseResults;
      throw new SQLException("No result found in queryForLong: " + paramPreparedStmt.getStatement());
    }
    finally
    {
      if (paramDatabaseConnection != null) {
        paramDatabaseConnection.close();
      }
      localCompiledStatement.close();
    }
  }
  
  public long queryForLong(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    logger.debug("executing raw query for long: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("query arguments: {}", paramArrayOfString);
    }
    DatabaseConnection localDatabaseConnection = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramDatabaseConnection = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes);
      localObject1 = localObject2;
      localDatabaseConnection = paramDatabaseConnection;
      assignStatementArguments(paramDatabaseConnection, paramArrayOfString);
      localObject1 = localObject2;
      localDatabaseConnection = paramDatabaseConnection;
      paramArrayOfString = paramDatabaseConnection.runQuery(null);
      localObject1 = paramArrayOfString;
      localDatabaseConnection = paramDatabaseConnection;
      if (paramArrayOfString.first())
      {
        localObject1 = paramArrayOfString;
        localDatabaseConnection = paramDatabaseConnection;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        if (paramDatabaseConnection != null) {
          paramDatabaseConnection.close();
        }
        return l;
      }
      localObject1 = paramArrayOfString;
      localDatabaseConnection = paramDatabaseConnection;
      throw new SQLException("No result found in queryForLong: " + paramString);
    }
    finally
    {
      if (localObject1 != null) {
        ((DatabaseResults)localObject1).close();
      }
      if (localDatabaseConnection != null) {
        localDatabaseConnection.close();
      }
    }
  }
  
  public <UO> GenericRawResults<UO> queryRaw(ConnectionSource paramConnectionSource, String paramString, RawRowMapper<UO> paramRawRowMapper, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("query arguments: {}", paramArrayOfString);
    }
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadOnlyConnection();
    Object localObject = null;
    try
    {
      CompiledStatement localCompiledStatement = localDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes);
      localObject = localCompiledStatement;
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      localObject = localCompiledStatement;
      paramString = new RawResultsImpl(paramConnectionSource, localDatabaseConnection, paramString, String[].class, localCompiledStatement, new UserRawRowMapper(paramRawRowMapper, this), paramObjectCache);
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (0 != 0) {
        paramConnectionSource.releaseConnection(null);
      }
      return paramString;
    }
    finally
    {
      if (localObject != null) {
        ((CompiledStatement)localObject).close();
      }
      if (localDatabaseConnection != null) {
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }
  
  public <UO> GenericRawResults<UO> queryRaw(ConnectionSource paramConnectionSource, String paramString, DataType[] paramArrayOfDataType, RawRowObjectMapper<UO> paramRawRowObjectMapper, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("query arguments: {}", paramArrayOfString);
    }
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadOnlyConnection();
    Object localObject = null;
    try
    {
      CompiledStatement localCompiledStatement = localDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes);
      localObject = localCompiledStatement;
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      localObject = localCompiledStatement;
      paramString = new RawResultsImpl(paramConnectionSource, localDatabaseConnection, paramString, String[].class, localCompiledStatement, new UserRawRowObjectMapper(paramRawRowObjectMapper, paramArrayOfDataType), paramObjectCache);
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (0 != 0) {
        paramConnectionSource.releaseConnection(null);
      }
      return paramString;
    }
    finally
    {
      if (localObject != null) {
        ((CompiledStatement)localObject).close();
      }
      if (localDatabaseConnection != null) {
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }
  
  public GenericRawResults<Object[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, DataType[] paramArrayOfDataType, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("query arguments: {}", paramArrayOfString);
    }
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadOnlyConnection();
    Object localObject = null;
    try
    {
      CompiledStatement localCompiledStatement = localDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes);
      localObject = localCompiledStatement;
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      localObject = localCompiledStatement;
      paramString = new RawResultsImpl(paramConnectionSource, localDatabaseConnection, paramString, Object[].class, localCompiledStatement, new ObjectArrayRowMapper(paramArrayOfDataType), paramObjectCache);
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (0 != 0) {
        paramConnectionSource.releaseConnection(null);
      }
      return paramString;
    }
    finally
    {
      if (localObject != null) {
        ((CompiledStatement)localObject).close();
      }
      if (localDatabaseConnection != null) {
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }
  
  public GenericRawResults<String[]> queryRaw(ConnectionSource paramConnectionSource, String paramString, String[] paramArrayOfString, ObjectCache paramObjectCache)
    throws SQLException
  {
    logger.debug("executing raw query for: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("query arguments: {}", paramArrayOfString);
    }
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadOnlyConnection();
    Object localObject = null;
    try
    {
      CompiledStatement localCompiledStatement = localDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.SELECT, noFieldTypes);
      localObject = localCompiledStatement;
      assignStatementArguments(localCompiledStatement, paramArrayOfString);
      localObject = localCompiledStatement;
      paramString = new RawResultsImpl(paramConnectionSource, localDatabaseConnection, paramString, String[].class, localCompiledStatement, this, paramObjectCache);
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (0 != 0) {
        paramConnectionSource.releaseConnection(null);
      }
      return paramString;
    }
    finally
    {
      if (localObject != null) {
        ((CompiledStatement)localObject).close();
      }
      if (localDatabaseConnection != null) {
        paramConnectionSource.releaseConnection(localDatabaseConnection);
      }
    }
  }
  
  public int refresh(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedRefresh == null) {
      this.mappedRefresh = MappedRefresh.build(this.databaseType, this.tableInfo);
    }
    return this.mappedRefresh.executeRefresh(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int update(DatabaseConnection paramDatabaseConnection, PreparedUpdate<T> paramPreparedUpdate)
    throws SQLException
  {
    paramDatabaseConnection = paramPreparedUpdate.compile(paramDatabaseConnection, StatementBuilder.StatementType.UPDATE);
    try
    {
      int i = paramDatabaseConnection.runUpdate();
      return i;
    }
    finally
    {
      paramDatabaseConnection.close();
    }
  }
  
  public int update(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedUpdate == null) {
      this.mappedUpdate = MappedUpdate.build(this.databaseType, this.tableInfo);
    }
    return this.mappedUpdate.update(paramDatabaseConnection, paramT, paramObjectCache);
  }
  
  public int updateId(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    if (this.mappedUpdateId == null) {
      this.mappedUpdateId = MappedUpdateId.build(this.databaseType, this.tableInfo);
    }
    return this.mappedUpdateId.execute(paramDatabaseConnection, paramT, paramID, paramObjectCache);
  }
  
  public int updateRaw(DatabaseConnection paramDatabaseConnection, String paramString, String[] paramArrayOfString)
    throws SQLException
  {
    logger.debug("running raw update statement: {}", paramString);
    if (paramArrayOfString.length > 0) {
      logger.trace("update arguments: {}", paramArrayOfString);
    }
    paramDatabaseConnection = paramDatabaseConnection.compileStatement(paramString, StatementBuilder.StatementType.UPDATE, noFieldTypes);
    try
    {
      assignStatementArguments(paramDatabaseConnection, paramArrayOfString);
      int i = paramDatabaseConnection.runUpdate();
      return i;
    }
    finally
    {
      paramDatabaseConnection.close();
    }
  }
  
  private static class ObjectArrayRowMapper
    implements GenericRowMapper<Object[]>
  {
    private final DataType[] columnTypes;
    
    public ObjectArrayRowMapper(DataType[] paramArrayOfDataType)
    {
      this.columnTypes = paramArrayOfDataType;
    }
    
    public Object[] mapRow(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      int j = paramDatabaseResults.getColumnCount();
      Object[] arrayOfObject = new Object[j];
      int i = 0;
      if (i < j)
      {
        if (i >= this.columnTypes.length) {}
        for (DataType localDataType = DataType.STRING;; localDataType = this.columnTypes[i])
        {
          arrayOfObject[i] = localDataType.getDataPersister().resultToJava(null, paramDatabaseResults, i);
          i += 1;
          break;
        }
      }
      return arrayOfObject;
    }
  }
  
  private static class UserRawRowMapper<UO>
    implements GenericRowMapper<UO>
  {
    private String[] columnNames;
    private final RawRowMapper<UO> mapper;
    private final GenericRowMapper<String[]> stringRowMapper;
    
    public UserRawRowMapper(RawRowMapper<UO> paramRawRowMapper, GenericRowMapper<String[]> paramGenericRowMapper)
    {
      this.mapper = paramRawRowMapper;
      this.stringRowMapper = paramGenericRowMapper;
    }
    
    private String[] getColumnNames(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      if (this.columnNames != null) {
        return this.columnNames;
      }
      this.columnNames = paramDatabaseResults.getColumnNames();
      return this.columnNames;
    }
    
    public UO mapRow(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      String[] arrayOfString = (String[])this.stringRowMapper.mapRow(paramDatabaseResults);
      return (UO)this.mapper.mapRow(getColumnNames(paramDatabaseResults), arrayOfString);
    }
  }
  
  private static class UserRawRowObjectMapper<UO>
    implements GenericRowMapper<UO>
  {
    private String[] columnNames;
    private final DataType[] columnTypes;
    private final RawRowObjectMapper<UO> mapper;
    
    public UserRawRowObjectMapper(RawRowObjectMapper<UO> paramRawRowObjectMapper, DataType[] paramArrayOfDataType)
    {
      this.mapper = paramRawRowObjectMapper;
      this.columnTypes = paramArrayOfDataType;
    }
    
    private String[] getColumnNames(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      if (this.columnNames != null) {
        return this.columnNames;
      }
      this.columnNames = paramDatabaseResults.getColumnNames();
      return this.columnNames;
    }
    
    public UO mapRow(DatabaseResults paramDatabaseResults)
      throws SQLException
    {
      int j = paramDatabaseResults.getColumnCount();
      Object[] arrayOfObject = new Object[j];
      int i = 0;
      if (i < j)
      {
        if (i >= this.columnTypes.length) {
          arrayOfObject[i] = null;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfObject[i] = this.columnTypes[i].getDataPersister().resultToJava(null, paramDatabaseResults, i);
        }
      }
      return (UO)this.mapper.mapRow(getColumnNames(paramDatabaseResults), this.columnTypes, arrayOfObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/StatementExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */