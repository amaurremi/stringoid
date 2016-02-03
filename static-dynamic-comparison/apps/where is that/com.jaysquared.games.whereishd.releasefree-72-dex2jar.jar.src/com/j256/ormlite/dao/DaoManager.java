package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DaoManager
{
  private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
  private static Map<Class<?>, DatabaseTableConfig<?>> configMap = null;
  private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
  private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;
  
  static
  {
    classMap = null;
    tableConfigMap = null;
  }
  
  public static void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> paramCollection)
  {
    HashMap localHashMap;
    for (;;)
    {
      try
      {
        if (configMap == null)
        {
          localHashMap = new HashMap();
          paramCollection = paramCollection.iterator();
          if (!paramCollection.hasNext()) {
            break;
          }
          DatabaseTableConfig localDatabaseTableConfig = (DatabaseTableConfig)paramCollection.next();
          localHashMap.put(localDatabaseTableConfig.getDataClass(), localDatabaseTableConfig);
          logger.info("Loaded configuration for {}", localDatabaseTableConfig.getDataClass());
          continue;
        }
        localHashMap = new HashMap(configMap);
      }
      finally {}
    }
    configMap = localHashMap;
  }
  
  private static void addDaoToClassMap(ClassConnectionSource paramClassConnectionSource, Dao<?, ?> paramDao)
  {
    if (classMap == null) {
      classMap = new HashMap();
    }
    classMap.put(paramClassConnectionSource, paramDao);
  }
  
  private static void addDaoToTableMap(TableConfigConnectionSource paramTableConfigConnectionSource, Dao<?, ?> paramDao)
  {
    if (tableConfigMap == null) {
      tableConfigMap = new HashMap();
    }
    tableConfigMap.put(paramTableConfigConnectionSource, paramDao);
  }
  
  public static void clearCache()
  {
    try
    {
      if (configMap != null)
      {
        configMap.clear();
        configMap = null;
      }
      clearDaoCache();
      return;
    }
    finally {}
  }
  
  public static void clearDaoCache()
  {
    try
    {
      if (classMap != null)
      {
        classMap.clear();
        classMap = null;
      }
      if (tableConfigMap != null)
      {
        tableConfigMap.clear();
        tableConfigMap = null;
      }
      return;
    }
    finally {}
  }
  
  public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    paramConnectionSource = doCreateDao(paramConnectionSource, paramDatabaseTableConfig);
    return paramConnectionSource;
  }
  
  public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    Object localObject = lookupDao(new ClassConnectionSource(paramConnectionSource, paramClass));
    if (localObject != null) {}
    for (paramConnectionSource = (ConnectionSource)localObject;; paramConnectionSource = (ConnectionSource)localObject)
    {
      return paramConnectionSource;
      localObject = (Dao)createDaoFromConfig(paramConnectionSource, paramClass);
      if (localObject == null) {
        break;
      }
    }
    localObject = (DatabaseTable)paramClass.getAnnotation(DatabaseTable.class);
    if ((localObject == null) || (((DatabaseTable)localObject).daoClass() == Void.class) || (((DatabaseTable)localObject).daoClass() == BaseDaoImpl.class))
    {
      localObject = paramConnectionSource.getDatabaseType().extractDatabaseTableConfig(paramConnectionSource, paramClass);
      if (localObject == null)
      {
        localObject = BaseDaoImpl.createDao(paramConnectionSource, paramClass);
        label125:
        logger.debug("created dao for class {} with reflection", paramClass);
        paramClass = (Class<T>)localObject;
      }
    }
    for (;;)
    {
      registerDao(paramConnectionSource, paramClass);
      paramConnectionSource = paramClass;
      break;
      localObject = BaseDaoImpl.createDao(paramConnectionSource, (DatabaseTableConfig)localObject);
      break label125;
      Class localClass = ((DatabaseTable)localObject).daoClass();
      localObject = new Object[2];
      localObject[0] = paramConnectionSource;
      localObject[1] = paramClass;
      Constructor localConstructor2 = findConstructor(localClass, (Object[])localObject);
      Constructor localConstructor1 = localConstructor2;
      if (localConstructor2 == null)
      {
        localObject = new Object[1];
        localObject[0] = paramConnectionSource;
        localConstructor2 = findConstructor(localClass, (Object[])localObject);
        localConstructor1 = localConstructor2;
        if (localConstructor2 == null) {
          throw new SQLException("Could not find public constructor with ConnectionSource and optional Class parameters " + localClass + ".  Missing static on class?");
        }
      }
      try
      {
        localObject = (Dao)localConstructor1.newInstance((Object[])localObject);
        logger.debug("created dao for class {} from constructor", paramClass);
        paramClass = (Class<T>)localObject;
      }
      catch (Exception paramConnectionSource)
      {
        throw SqlExceptionUtil.create("Could not call the constructor in class " + localClass, paramConnectionSource);
      }
    }
  }
  
  private static <D, T> D createDaoFromConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    if (configMap == null) {}
    do
    {
      return null;
      paramClass = (DatabaseTableConfig)configMap.get(paramClass);
    } while (paramClass == null);
    return doCreateDao(paramConnectionSource, paramClass);
  }
  
  private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    TableConfigConnectionSource localTableConfigConnectionSource = new TableConfigConnectionSource(paramConnectionSource, paramDatabaseTableConfig);
    Object localObject1 = lookupDao(localTableConfigConnectionSource);
    if (localObject1 != null) {
      return (D)localObject1;
    }
    localObject1 = paramDatabaseTableConfig.getDataClass();
    ClassConnectionSource localClassConnectionSource = new ClassConnectionSource(paramConnectionSource, (Class)localObject1);
    Object localObject2 = lookupDao(localClassConnectionSource);
    if (localObject2 != null)
    {
      addDaoToTableMap(localTableConfigConnectionSource, (Dao)localObject2);
      return (D)localObject2;
    }
    localObject2 = (DatabaseTable)paramDatabaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
    if ((localObject2 == null) || (((DatabaseTable)localObject2).daoClass() == Void.class) || (((DatabaseTable)localObject2).daoClass() == BaseDaoImpl.class)) {
      paramConnectionSource = BaseDaoImpl.createDao(paramConnectionSource, paramDatabaseTableConfig);
    }
    for (;;)
    {
      addDaoToTableMap(localTableConfigConnectionSource, paramConnectionSource);
      logger.debug("created dao for class {} from table config", localObject1);
      if (lookupDao(localClassConnectionSource) == null) {
        addDaoToClassMap(localClassConnectionSource, paramConnectionSource);
      }
      return paramConnectionSource;
      localObject2 = ((DatabaseTable)localObject2).daoClass();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramConnectionSource;
      arrayOfObject[1] = paramDatabaseTableConfig;
      paramConnectionSource = findConstructor((Class)localObject2, arrayOfObject);
      if (paramConnectionSource == null) {
        throw new SQLException("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class " + localObject2);
      }
      try
      {
        paramConnectionSource = (Dao)paramConnectionSource.newInstance(arrayOfObject);
      }
      catch (Exception paramConnectionSource)
      {
        throw SqlExceptionUtil.create("Could not call the constructor in class " + localObject2, paramConnectionSource);
      }
    }
  }
  
  private static Constructor<?> findConstructor(Class<?> paramClass, Object[] paramArrayOfObject)
  {
    paramClass = paramClass.getConstructors();
    int n = paramClass.length;
    int i = 0;
    while (i < n)
    {
      Constructor<?> localConstructor = paramClass[i];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      if (arrayOfClass.length == paramArrayOfObject.length)
      {
        int m = 1;
        int j = 0;
        for (;;)
        {
          int k = m;
          if (j < arrayOfClass.length)
          {
            if (!arrayOfClass[j].isAssignableFrom(paramArrayOfObject[j].getClass())) {
              k = 0;
            }
          }
          else
          {
            if (k == 0) {
              break;
            }
            return localConstructor;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static <T> Dao<?, ?> lookupDao(ClassConnectionSource paramClassConnectionSource)
  {
    if (classMap == null) {
      classMap = new HashMap();
    }
    Dao localDao = (Dao)classMap.get(paramClassConnectionSource);
    paramClassConnectionSource = localDao;
    if (localDao == null) {
      paramClassConnectionSource = null;
    }
    return paramClassConnectionSource;
  }
  
  private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource paramTableConfigConnectionSource)
  {
    if (tableConfigMap == null) {
      tableConfigMap = new HashMap();
    }
    Dao localDao = (Dao)tableConfigMap.get(paramTableConfigConnectionSource);
    paramTableConfigConnectionSource = localDao;
    if (localDao == null) {
      paramTableConfigConnectionSource = null;
    }
    return paramTableConfigConnectionSource;
  }
  
  public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource paramConnectionSource, DatabaseTableConfig<T> paramDatabaseTableConfig)
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    paramConnectionSource = lookupDao(new TableConfigConnectionSource(paramConnectionSource, paramDatabaseTableConfig));
    if (paramConnectionSource == null) {
      paramConnectionSource = null;
    }
    for (;;)
    {
      return paramConnectionSource;
    }
  }
  
  public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource paramConnectionSource, Class<T> paramClass)
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    paramConnectionSource = lookupDao(new ClassConnectionSource(paramConnectionSource, paramClass));
    return paramConnectionSource;
  }
  
  public static void registerDao(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao)
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    addDaoToClassMap(new ClassConnectionSource(paramConnectionSource, paramDao.getDataClass()), paramDao);
  }
  
  public static void registerDaoWithTableConfig(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao)
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    if ((paramDao instanceof BaseDaoImpl))
    {
      DatabaseTableConfig localDatabaseTableConfig = ((BaseDaoImpl)paramDao).getTableConfig();
      if (localDatabaseTableConfig != null) {
        addDaoToTableMap(new TableConfigConnectionSource(paramConnectionSource, localDatabaseTableConfig), paramDao);
      }
    }
    for (;;)
    {
      return;
      addDaoToClassMap(new ClassConnectionSource(paramConnectionSource, paramDao.getDataClass()), paramDao);
    }
  }
  
  private static void removeDaoToClassMap(ClassConnectionSource paramClassConnectionSource, Dao<?, ?> paramDao)
  {
    if (classMap != null) {
      classMap.remove(paramClassConnectionSource);
    }
  }
  
  public static void unregisterDao(ConnectionSource paramConnectionSource, Dao<?, ?> paramDao)
  {
    if (paramConnectionSource == null) {
      try
      {
        throw new IllegalArgumentException("connectionSource argument cannot be null");
      }
      finally {}
    }
    removeDaoToClassMap(new ClassConnectionSource(paramConnectionSource, paramDao.getDataClass()), paramDao);
  }
  
  private static class ClassConnectionSource
  {
    Class<?> clazz;
    ConnectionSource connectionSource;
    
    public ClassConnectionSource(ConnectionSource paramConnectionSource, Class<?> paramClass)
    {
      this.connectionSource = paramConnectionSource;
      this.clazz = paramClass;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {}
      do
      {
        return false;
        paramObject = (ClassConnectionSource)paramObject;
      } while ((!this.clazz.equals(((ClassConnectionSource)paramObject).clazz)) || (!this.connectionSource.equals(((ClassConnectionSource)paramObject).connectionSource)));
      return true;
    }
    
    public int hashCode()
    {
      return (this.clazz.hashCode() + 31) * 31 + this.connectionSource.hashCode();
    }
  }
  
  private static class TableConfigConnectionSource
  {
    ConnectionSource connectionSource;
    DatabaseTableConfig<?> tableConfig;
    
    public TableConfigConnectionSource(ConnectionSource paramConnectionSource, DatabaseTableConfig<?> paramDatabaseTableConfig)
    {
      this.connectionSource = paramConnectionSource;
      this.tableConfig = paramDatabaseTableConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {}
      do
      {
        return false;
        paramObject = (TableConfigConnectionSource)paramObject;
      } while ((!this.tableConfig.equals(((TableConfigConnectionSource)paramObject).tableConfig)) || (!this.connectionSource.equals(((TableConfigConnectionSource)paramObject).connectionSource)));
      return true;
    }
    
    public int hashCode()
    {
      return (this.tableConfig.hashCode() + 31) * 31 + this.connectionSource.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/dao/DaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */