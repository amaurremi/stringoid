package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TableUtils
{
  private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
  private static final FieldType[] noFieldTypes = new FieldType[0];
  
  private static <T, ID> void addCreateIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject4 = new HashMap();
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    int i = 0;
    label49:
    label73:
    Object localObject3;
    if (i < j)
    {
      FieldType localFieldType = arrayOfFieldType[i];
      if (paramBoolean2)
      {
        localObject1 = localFieldType.getUniqueIndexName();
        if (localObject1 != null) {
          break label73;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = localFieldType.getIndexName();
        break label49;
        localObject3 = (List)((Map)localObject4).get(localObject1);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new ArrayList();
          ((Map)localObject4).put(localObject1, localObject2);
        }
        ((List)localObject2).add(localFieldType.getColumnName());
      }
    }
    Object localObject1 = new StringBuilder(128);
    Object localObject2 = ((Map)localObject4).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      logger.info("creating index '{}' for table '{}", ((Map.Entry)localObject3).getKey(), paramTableInfo.getTableName());
      ((StringBuilder)localObject1).append("CREATE ");
      if (paramBoolean2) {
        ((StringBuilder)localObject1).append("UNIQUE ");
      }
      ((StringBuilder)localObject1).append("INDEX ");
      if ((paramBoolean1) && (paramDatabaseType.isCreateIndexIfNotExistsSupported())) {
        ((StringBuilder)localObject1).append("IF NOT EXISTS ");
      }
      paramDatabaseType.appendEscapedEntityName((StringBuilder)localObject1, (String)((Map.Entry)localObject3).getKey());
      ((StringBuilder)localObject1).append(" ON ");
      paramDatabaseType.appendEscapedEntityName((StringBuilder)localObject1, paramTableInfo.getTableName());
      ((StringBuilder)localObject1).append(" ( ");
      i = 1;
      localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          paramDatabaseType.appendEscapedEntityName((StringBuilder)localObject1, (String)localObject4);
          break;
          ((StringBuilder)localObject1).append(", ");
        }
      }
      ((StringBuilder)localObject1).append(" )");
      paramList.add(((StringBuilder)localObject1).toString());
      ((StringBuilder)localObject1).setLength(0);
    }
  }
  
  private static <T, ID> List<String> addCreateTableStatements(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    addCreateTableStatements(paramConnectionSource.getDatabaseType(), paramTableInfo, localArrayList1, localArrayList2, paramBoolean);
    return localArrayList1;
  }
  
  private static <T, ID> void addCreateTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
    throws SQLException
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("CREATE TABLE ");
    if ((paramBoolean) && (paramDatabaseType.isCreateIfNotExistsSupported())) {
      localStringBuilder.append("IF NOT EXISTS ");
    }
    paramDatabaseType.appendEscapedEntityName(localStringBuilder, paramTableInfo.getTableName());
    localStringBuilder.append(" (");
    Object localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 1;
    FieldType[] arrayOfFieldType = paramTableInfo.getFieldTypes();
    int k = arrayOfFieldType.length;
    int j = 0;
    if (j < k)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      if (localFieldType.isForeignCollection()) {}
      for (;;)
      {
        j += 1;
        break;
        if (i != 0) {
          i = 0;
        }
        String str;
        for (;;)
        {
          str = localFieldType.getColumnDefinition();
          if (str != null) {
            break label192;
          }
          paramDatabaseType.appendColumnArg(paramTableInfo.getTableName(), localStringBuilder, localFieldType, (List)localObject, localArrayList1, localArrayList2, paramList2);
          break;
          localStringBuilder.append(", ");
        }
        label192:
        paramDatabaseType.appendEscapedEntityName(localStringBuilder, localFieldType.getColumnName());
        localStringBuilder.append(' ').append(str).append(' ');
      }
    }
    paramDatabaseType.addPrimaryKeySql(paramTableInfo.getFieldTypes(), (List)localObject, localArrayList1, localArrayList2, paramList2);
    paramDatabaseType.addUniqueComboSql(paramTableInfo.getFieldTypes(), (List)localObject, localArrayList1, localArrayList2, paramList2);
    paramList2 = ((List)localObject).iterator();
    while (paramList2.hasNext())
    {
      localObject = (String)paramList2.next();
      localStringBuilder.append(", ").append((String)localObject);
    }
    localStringBuilder.append(") ");
    paramDatabaseType.appendCreateTableSuffix(localStringBuilder);
    paramList1.addAll(localArrayList1);
    paramList1.add(localStringBuilder.toString());
    paramList1.addAll(localArrayList2);
    addCreateIndexStatements(paramDatabaseType, paramTableInfo, paramList1, paramBoolean, false);
    addCreateIndexStatements(paramDatabaseType, paramTableInfo, paramList1, paramBoolean, true);
  }
  
  private static <T, ID> void addDropIndexStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList)
  {
    Object localObject1 = new HashSet();
    Object localObject2 = paramTableInfo.getFieldTypes();
    int j = localObject2.length;
    int i = 0;
    String str1;
    while (i < j)
    {
      str1 = localObject2[i];
      String str2 = str1.getIndexName();
      if (str2 != null) {
        ((Set)localObject1).add(str2);
      }
      str1 = str1.getUniqueIndexName();
      if (str1 != null) {
        ((Set)localObject1).add(str1);
      }
      i += 1;
    }
    localObject2 = new StringBuilder(48);
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str1 = (String)((Iterator)localObject1).next();
      logger.info("dropping index '{}' for table '{}", str1, paramTableInfo.getTableName());
      ((StringBuilder)localObject2).append("DROP INDEX ");
      paramDatabaseType.appendEscapedEntityName((StringBuilder)localObject2, str1);
      paramList.add(((StringBuilder)localObject2).toString());
      ((StringBuilder)localObject2).setLength(0);
    }
  }
  
  private static <T, ID> void addDropTableStatements(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, List<String> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = paramTableInfo.getFieldTypes();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramDatabaseType.dropColumnArg(localObject[i], localArrayList1, localArrayList2);
      i += 1;
    }
    localObject = new StringBuilder(64);
    ((StringBuilder)localObject).append("DROP TABLE ");
    paramDatabaseType.appendEscapedEntityName((StringBuilder)localObject, paramTableInfo.getTableName());
    ((StringBuilder)localObject).append(' ');
    paramList.addAll(localArrayList1);
    paramList.add(((StringBuilder)localObject).toString());
    paramList.addAll(localArrayList2);
  }
  
  public static <T> int clearTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return clearTable(paramConnectionSource, paramDatabaseTableConfig.getTableName());
  }
  
  public static <T> int clearTable(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    String str = DatabaseTableConfig.extractTableName(paramClass);
    paramClass = str;
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
      paramClass = str.toUpperCase();
    }
    return clearTable(paramConnectionSource, paramClass);
  }
  
  private static <T> int clearTable(ConnectionSource paramConnectionSource, String paramString)
    throws SQLException
  {
    Object localObject1 = paramConnectionSource.getDatabaseType();
    localObject3 = new StringBuilder(48);
    if (((DatabaseType)localObject1).isTruncateSupported()) {
      ((StringBuilder)localObject3).append("TRUNCATE TABLE ");
    }
    for (;;)
    {
      ((DatabaseType)localObject1).appendEscapedEntityName((StringBuilder)localObject3, paramString);
      localObject1 = ((StringBuilder)localObject3).toString();
      logger.info("clearing table '{}' with '{}", paramString, localObject1);
      paramString = null;
      localObject3 = paramConnectionSource.getReadWriteConnection();
      try
      {
        localObject1 = ((DatabaseConnection)localObject3).compileStatement((String)localObject1, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
        paramString = (String)localObject1;
        int i = ((CompiledStatement)localObject1).runExecute();
        if (localObject1 != null) {
          ((CompiledStatement)localObject1).close();
        }
        paramConnectionSource.releaseConnection((DatabaseConnection)localObject3);
        return i;
      }
      finally
      {
        if (paramString == null) {
          break;
        }
        paramString.close();
        paramConnectionSource.releaseConnection((DatabaseConnection)localObject3);
      }
      ((StringBuilder)localObject3).append("DELETE FROM ");
    }
  }
  
  public static <T> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, false);
  }
  
  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if ((localDao instanceof BaseDaoImpl)) {
      return doCreateTable(paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), paramBoolean);
    }
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return doCreateTable(paramConnectionSource, new TableInfo(paramConnectionSource.getDatabaseType(), null, paramDatabaseTableConfig), paramBoolean);
  }
  
  public static <T> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramClass, false);
  }
  
  private static <T, ID> int createTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    if ((localDao instanceof BaseDaoImpl)) {
      return doCreateTable(paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), paramBoolean);
    }
    return doCreateTable(paramConnectionSource, new TableInfo(paramConnectionSource, null, paramClass), paramBoolean);
  }
  
  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramDatabaseTableConfig, true);
  }
  
  public static <T> int createTableIfNotExists(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return createTable(paramConnectionSource, paramClass, true);
  }
  
  private static <T, ID> int doCreateTable(ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    logger.info("creating table '{}'", paramTableInfo.getTableName());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    addCreateTableStatements(localDatabaseType, paramTableInfo, localArrayList1, localArrayList2, paramBoolean);
    paramTableInfo = paramConnectionSource.getReadWriteConnection();
    try
    {
      int i = doStatements(paramTableInfo, "create", localArrayList1, false, localDatabaseType.isCreateTableReturnsNegative(), localDatabaseType.isCreateTableReturnsZero());
      int j = doCreateTestQueries(paramTableInfo, localDatabaseType, localArrayList2);
      return i + j;
    }
    finally
    {
      paramConnectionSource.releaseConnection(paramTableInfo);
    }
  }
  
  private static int doCreateTestQueries(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, List<String> paramList)
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      paramDatabaseType = null;
      try
      {
        CompiledStatement localCompiledStatement = paramDatabaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes);
        paramDatabaseType = localCompiledStatement;
        paramList = localCompiledStatement;
        DatabaseResults localDatabaseResults = localCompiledStatement.runQuery(null);
        int j = 0;
        paramDatabaseType = localCompiledStatement;
        paramList = localCompiledStatement;
        for (boolean bool = localDatabaseResults.first(); bool; bool = localDatabaseResults.next())
        {
          j += 1;
          paramDatabaseType = localCompiledStatement;
          paramList = localCompiledStatement;
        }
        paramDatabaseType = localCompiledStatement;
        paramList = localCompiledStatement;
        logger.info("executing create table after-query got {} results: {}", Integer.valueOf(j), str);
        if (localCompiledStatement != null) {
          localCompiledStatement.close();
        }
        i += 1;
      }
      catch (SQLException paramDatabaseConnection)
      {
        paramList = paramDatabaseType;
        throw SqlExceptionUtil.create("executing create table after-query failed: " + str, paramDatabaseConnection);
      }
      finally
      {
        if (paramList != null) {
          paramList.close();
        }
      }
    }
    return i;
  }
  
  private static <T, ID> int doDropTable(DatabaseType paramDatabaseType, ConnectionSource paramConnectionSource, TableInfo<T, ID> paramTableInfo, boolean paramBoolean)
    throws SQLException
  {
    logger.info("dropping table '{}'", paramTableInfo.getTableName());
    ArrayList localArrayList = new ArrayList();
    addDropIndexStatements(paramDatabaseType, paramTableInfo, localArrayList);
    addDropTableStatements(paramDatabaseType, paramTableInfo, localArrayList);
    paramTableInfo = paramConnectionSource.getReadWriteConnection();
    try
    {
      int i = doStatements(paramTableInfo, "drop", localArrayList, paramBoolean, paramDatabaseType.isCreateTableReturnsNegative(), false);
      return i;
    }
    finally
    {
      paramConnectionSource.releaseConnection(paramTableInfo);
    }
  }
  
  private static int doStatements(DatabaseConnection paramDatabaseConnection, String paramString, Collection<String> paramCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws SQLException
  {
    int j = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int k = 0;
      Object localObject = null;
      paramCollection = null;
      int i = k;
      int m;
      label272:
      try
      {
        CompiledStatement localCompiledStatement = paramDatabaseConnection.compileStatement(str, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
        paramCollection = localCompiledStatement;
        i = k;
        localObject = localCompiledStatement;
        k = localCompiledStatement.runExecute();
        paramCollection = localCompiledStatement;
        i = k;
        localObject = localCompiledStatement;
        logger.info("executed {} table statement changed {} rows: {}", paramString, Integer.valueOf(k), str);
        m = k;
        if (localCompiledStatement != null)
        {
          localCompiledStatement.close();
          m = k;
        }
      }
      catch (SQLException localSQLException)
      {
        while (paramBoolean1)
        {
          localObject = paramCollection;
          logger.info("ignoring {} error '{}' for statement: {}", paramString, localSQLException, str);
          m = i;
          if (paramCollection != null)
          {
            paramCollection.close();
            m = i;
          }
        }
        localObject = paramCollection;
        throw SqlExceptionUtil.create("SQL statement failed: " + str, localSQLException);
      }
      finally
      {
        if (localObject == null) {
          break label272;
        }
        ((CompiledStatement)localObject).close();
      }
      if (m < 0)
      {
        if (!paramBoolean2) {
          throw new SQLException("SQL statement " + str + " updated " + m + " rows, we were expecting >= 0");
        }
      }
      else if ((m > 0) && (paramBoolean3)) {
        throw new SQLException("SQL statement updated " + m + " rows, we were expecting == 0: " + str);
      }
      j += 1;
    }
    return j;
  }
  
  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if ((localDao instanceof BaseDaoImpl)) {
      return doDropTable(localDatabaseType, paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), paramBoolean);
    }
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return doDropTable(localDatabaseType, paramConnectionSource, new TableInfo(localDatabaseType, null, paramDatabaseTableConfig), paramBoolean);
  }
  
  public static <T, ID> int dropTable(ConnectionSource paramConnectionSource, Class<T> paramClass, boolean paramBoolean)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    if ((localDao instanceof BaseDaoImpl)) {
      return doDropTable(localDatabaseType, paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), paramBoolean);
    }
    return doDropTable(localDatabaseType, paramConnectionSource, new TableInfo(paramConnectionSource, null, paramClass), paramBoolean);
  }
  
  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramDatabaseTableConfig);
    if ((localDao instanceof BaseDaoImpl)) {
      return addCreateTableStatements(paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), false);
    }
    paramDatabaseTableConfig.extractFieldTypes(paramConnectionSource);
    return addCreateTableStatements(paramConnectionSource, new TableInfo(paramConnectionSource.getDatabaseType(), null, paramDatabaseTableConfig), false);
  }
  
  public static <T, ID> List<String> getCreateTableStatements(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    Dao localDao = DaoManager.createDao(paramConnectionSource, paramClass);
    if ((localDao instanceof BaseDaoImpl)) {
      return addCreateTableStatements(paramConnectionSource, ((BaseDaoImpl)localDao).getTableInfo(), false);
    }
    return addCreateTableStatements(paramConnectionSource, new TableInfo(paramConnectionSource, null, paramClass), false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/table/TableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */