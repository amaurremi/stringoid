package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class FieldType
{
  private static boolean DEFAULT_VALUE_BOOLEAN = false;
  private static byte DEFAULT_VALUE_BYTE = 0;
  private static char DEFAULT_VALUE_CHAR = '\000';
  private static double DEFAULT_VALUE_DOUBLE = 0.0D;
  private static float DEFAULT_VALUE_FLOAT = 0.0F;
  private static int DEFAULT_VALUE_INT = 0;
  private static long DEFAULT_VALUE_LONG = 0L;
  private static short DEFAULT_VALUE_SHORT = 0;
  public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
  private static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal()
  {
    protected FieldType.LevelCounters initialValue()
    {
      return new FieldType.LevelCounters(null);
    }
  };
  private final String columnName;
  private final ConnectionSource connectionSource;
  private DataPersister dataPersister;
  private Object dataTypeConfigObj;
  private Object defaultValue;
  private final Field field;
  private final DatabaseFieldConfig fieldConfig;
  private FieldConverter fieldConverter;
  private final Method fieldGetMethod;
  private final Method fieldSetMethod;
  private BaseDaoImpl<?, ?> foreignDao;
  private FieldType foreignFieldType;
  private FieldType foreignIdField;
  private TableInfo<?, ?> foreignTableInfo;
  private final String generatedIdSequence;
  private final boolean isGeneratedId;
  private final boolean isId;
  private MappedQueryForId<Object, Object> mappedQueryForId;
  private final Class<?> parentClass;
  private final String tableName;
  
  public FieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, DatabaseFieldConfig paramDatabaseFieldConfig, Class<?> paramClass)
    throws SQLException
  {
    this.connectionSource = paramConnectionSource;
    this.tableName = paramString;
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    this.field = paramField;
    this.parentClass = paramClass;
    paramDatabaseFieldConfig.postProcess();
    Object localObject = paramField.getType();
    if (paramDatabaseFieldConfig.getDataPersister() == null)
    {
      paramClass = paramDatabaseFieldConfig.getPersisterClass();
      if ((paramClass == null) || (paramClass == VoidType.class)) {
        paramConnectionSource = DataPersisterManager.lookupForField(paramField);
      }
    }
    String str;
    label300:
    do
    {
      for (;;)
      {
        paramClass = paramDatabaseFieldConfig.getForeignColumnName();
        str = paramField.getName();
        if ((!paramDatabaseFieldConfig.isForeign()) && (!paramDatabaseFieldConfig.isForeignAutoRefresh()) && (paramClass == null)) {
          break label574;
        }
        if ((paramConnectionSource == null) || (!paramConnectionSource.isPrimitive())) {
          break label449;
        }
        throw new IllegalArgumentException("Field " + this + " is a primitive class " + localObject + " but marked as foreign");
        try
        {
          paramConnectionSource = paramClass.getDeclaredMethod("getSingleton", new Class[0]);
          try
          {
            paramConnectionSource = (DataPersister)paramConnectionSource;
          }
          catch (Exception paramConnectionSource)
          {
            throw SqlExceptionUtil.create("Could not cast result of static getSingleton method to DataPersister from class " + paramClass, paramConnectionSource);
          }
        }
        catch (Exception paramConnectionSource)
        {
          try
          {
            paramConnectionSource = paramConnectionSource.invoke(null, new Object[0]);
            if (paramConnectionSource != null) {
              break label300;
            }
            throw new SQLException("Static getSingleton method should not return null on class " + paramClass);
          }
          catch (InvocationTargetException paramConnectionSource)
          {
            throw SqlExceptionUtil.create("Could not run getSingleton method on class " + paramClass, paramConnectionSource.getTargetException());
          }
          catch (Exception paramConnectionSource)
          {
            throw SqlExceptionUtil.create("Could not run getSingleton method on class " + paramClass, paramConnectionSource);
          }
          paramConnectionSource = paramConnectionSource;
          throw SqlExceptionUtil.create("Could not find getSingleton static method on class " + paramClass, paramConnectionSource);
        }
      }
      paramClass = paramDatabaseFieldConfig.getDataPersister();
      paramConnectionSource = paramClass;
    } while (paramClass.isValidForField(paramField));
    paramConnectionSource = new StringBuilder();
    paramConnectionSource.append("Field class ").append(((Class)localObject).getName());
    paramConnectionSource.append(" for field ").append(this);
    paramConnectionSource.append(" is not valid for type ").append(paramClass);
    paramString = paramClass.getPrimaryClass();
    if (paramString != null) {
      paramConnectionSource.append(", maybe should be " + paramString);
    }
    throw new IllegalArgumentException(paramConnectionSource.toString());
    label449:
    if (paramClass == null) {
      paramClass = str + "_id";
    }
    while (ForeignCollection.class.isAssignableFrom((Class)localObject))
    {
      throw new SQLException("Field '" + paramField.getName() + "' in class " + localObject + "' should use the @" + ForeignCollectionField.class.getSimpleName() + " annotation not foreign=true");
      paramClass = str + "_" + paramClass;
      continue;
      label574:
      if (paramDatabaseFieldConfig.isForeignCollection())
      {
        if ((localObject != Collection.class) && (!ForeignCollection.class.isAssignableFrom((Class)localObject))) {
          throw new SQLException("Field class for '" + paramField.getName() + "' must be of class " + ForeignCollection.class.getSimpleName() + " or Collection.");
        }
        localObject = paramField.getGenericType();
        if (!(localObject instanceof ParameterizedType)) {
          throw new SQLException("Field class for '" + paramField.getName() + "' must be a parameterized Collection.");
        }
        paramClass = str;
        if (((ParameterizedType)localObject).getActualTypeArguments().length == 0) {
          throw new SQLException("Field class for '" + paramField.getName() + "' must be a parameterized Collection with at least 1 type.");
        }
      }
      else
      {
        paramClass = str;
        if (paramConnectionSource == null)
        {
          paramClass = str;
          if (!paramDatabaseFieldConfig.isForeignCollection())
          {
            if (byte[].class.isAssignableFrom((Class)localObject)) {
              throw new SQLException("ORMLite does not know how to store " + localObject + " for field '" + paramField.getName() + "'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE");
            }
            if (Serializable.class.isAssignableFrom((Class)localObject)) {
              throw new SQLException("ORMLite does not know how to store " + localObject + " for field '" + paramField.getName() + "'.  Use another class, custom persister, or to serialize it use " + "dataType=DataType.SERIALIZABLE");
            }
            throw new IllegalArgumentException("ORMLite does not know how to store " + localObject + " for field " + paramField.getName() + ". Use another class or a custom persister.");
          }
        }
      }
    }
    if (paramDatabaseFieldConfig.getColumnName() == null) {}
    for (this.columnName = paramClass;; this.columnName = paramDatabaseFieldConfig.getColumnName())
    {
      this.fieldConfig = paramDatabaseFieldConfig;
      if (!paramDatabaseFieldConfig.isId()) {
        break label1105;
      }
      if ((!paramDatabaseFieldConfig.isGeneratedId()) && (paramDatabaseFieldConfig.getGeneratedIdSequence() == null)) {
        break;
      }
      throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + paramField.getName());
    }
    this.isId = true;
    this.isGeneratedId = false;
    this.generatedIdSequence = null;
    while ((this.isId) && ((paramDatabaseFieldConfig.isForeign()) || (paramDatabaseFieldConfig.isForeignAutoRefresh())))
    {
      throw new IllegalArgumentException("Id field " + paramField.getName() + " cannot also be a foreign object");
      label1105:
      if (paramDatabaseFieldConfig.isGeneratedId())
      {
        if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null) {
          throw new IllegalArgumentException("Must specify one of id, generatedId, and generatedIdSequence with " + paramField.getName());
        }
        this.isId = true;
        this.isGeneratedId = true;
        if (localDatabaseType.isIdSequenceNeeded()) {
          this.generatedIdSequence = localDatabaseType.generateIdSequenceName(paramString, this);
        } else {
          this.generatedIdSequence = null;
        }
      }
      else if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null)
      {
        this.isId = true;
        this.isGeneratedId = true;
        paramClass = paramDatabaseFieldConfig.getGeneratedIdSequence();
        paramString = paramClass;
        if (localDatabaseType.isEntityNamesMustBeUpCase()) {
          paramString = paramClass.toUpperCase();
        }
        this.generatedIdSequence = paramString;
      }
      else
      {
        this.isId = false;
        this.isGeneratedId = false;
        this.generatedIdSequence = null;
      }
    }
    if (paramDatabaseFieldConfig.isUseGetSet())
    {
      this.fieldGetMethod = DatabaseFieldConfig.findGetMethod(paramField, true);
      this.fieldSetMethod = DatabaseFieldConfig.findSetMethod(paramField, true);
    }
    while ((paramDatabaseFieldConfig.isAllowGeneratedIdInsert()) && (!paramDatabaseFieldConfig.isGeneratedId()))
    {
      throw new IllegalArgumentException("Field " + paramField.getName() + " must be a generated-id if allowGeneratedIdInsert = true");
      if (!paramField.isAccessible()) {}
      try
      {
        this.field.setAccessible(true);
        this.fieldGetMethod = null;
        this.fieldSetMethod = null;
      }
      catch (SecurityException paramConnectionSource)
      {
        throw new IllegalArgumentException("Could not open access to field " + paramField.getName() + ".  You may have to set useGetSet=true to fix.");
      }
    }
    if ((paramDatabaseFieldConfig.isForeignAutoRefresh()) && (!paramDatabaseFieldConfig.isForeign())) {
      throw new IllegalArgumentException("Field " + paramField.getName() + " must have foreign = true if foreignAutoRefresh = true");
    }
    if ((paramDatabaseFieldConfig.isForeignAutoCreate()) && (!paramDatabaseFieldConfig.isForeign())) {
      throw new IllegalArgumentException("Field " + paramField.getName() + " must have foreign = true if foreignAutoCreate = true");
    }
    if ((paramDatabaseFieldConfig.getForeignColumnName() != null) && (!paramDatabaseFieldConfig.isForeign())) {
      throw new IllegalArgumentException("Field " + paramField.getName() + " must have foreign = true if foreignColumnName is set");
    }
    if ((paramDatabaseFieldConfig.isVersion()) && ((paramConnectionSource == null) || (!paramConnectionSource.isValidForVersion()))) {
      throw new IllegalArgumentException("Field " + paramField.getName() + " is not a valid type to be a version field");
    }
    if ((paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel() > 0) && (!paramDatabaseFieldConfig.isForeignAutoRefresh())) {
      throw new IllegalArgumentException("Field " + paramField.getName() + " has maxForeignAutoRefreshLevel set but not foreignAutoRefresh is false");
    }
    assignDataType(localDatabaseType, paramConnectionSource);
  }
  
  private void assignDataType(DatabaseType paramDatabaseType, DataPersister paramDataPersister)
    throws SQLException
  {
    this.dataPersister = paramDataPersister;
    if (paramDataPersister == null)
    {
      if ((!this.fieldConfig.isForeign()) && (!this.fieldConfig.isForeignCollection())) {
        throw new SQLException("Data persister for field " + this + " is null but the field is not a foreign or foreignCollection");
      }
    }
    else
    {
      this.fieldConverter = paramDatabaseType.getFieldConverter(paramDataPersister);
      if ((this.isGeneratedId) && (!paramDataPersister.isValidGeneratedType()))
      {
        paramDatabaseType = new StringBuilder();
        paramDatabaseType.append("Generated-id field '").append(this.field.getName());
        paramDatabaseType.append("' in ").append(this.field.getDeclaringClass().getSimpleName());
        paramDatabaseType.append(" can't be type ").append(this.dataPersister.getSqlType());
        paramDatabaseType.append(".  Must be one of: ");
        paramDataPersister = DataType.values();
        int j = paramDataPersister.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramDataPersister[i];
          DataPersister localDataPersister = ((DataType)localObject).getDataPersister();
          if ((localDataPersister != null) && (localDataPersister.isValidGeneratedType())) {
            paramDatabaseType.append(localObject).append(' ');
          }
          i += 1;
        }
        throw new IllegalArgumentException(paramDatabaseType.toString());
      }
      if ((this.fieldConfig.isThrowIfNull()) && (!paramDataPersister.isPrimitive())) {
        throw new SQLException("Field " + this.field.getName() + " must be a primitive if set with throwIfNull");
      }
      if ((this.isId) && (!paramDataPersister.isAppropriateId())) {
        throw new SQLException("Field '" + this.field.getName() + "' is of data type " + paramDataPersister + " which cannot be the ID field");
      }
      this.dataTypeConfigObj = paramDataPersister.makeConfigObject(this);
      paramDatabaseType = this.fieldConfig.getDefaultValue();
      if (paramDatabaseType != null) {
        break label391;
      }
      this.defaultValue = null;
    }
    return;
    label391:
    if (this.isGeneratedId) {
      throw new SQLException("Field '" + this.field.getName() + "' cannot be a generatedId and have a default value '" + paramDatabaseType + "'");
    }
    this.defaultValue = this.fieldConverter.parseDefaultString(this, paramDatabaseType);
  }
  
  public static FieldType createFieldType(ConnectionSource paramConnectionSource, String paramString, Field paramField, Class<?> paramClass)
    throws SQLException
  {
    DatabaseFieldConfig localDatabaseFieldConfig = DatabaseFieldConfig.fromField(paramConnectionSource.getDatabaseType(), paramString, paramField);
    if (localDatabaseFieldConfig == null) {
      return null;
    }
    return new FieldType(paramConnectionSource, paramString, paramField, localDatabaseFieldConfig, paramClass);
  }
  
  private FieldType findForeignFieldType(Class<?> paramClass1, Class<?> paramClass2, BaseDaoImpl<?, ?> paramBaseDaoImpl)
    throws SQLException
  {
    String str = this.fieldConfig.getForeignCollectionForeignFieldName();
    paramBaseDaoImpl = paramBaseDaoImpl.getTableInfo().getFieldTypes();
    int j = paramBaseDaoImpl.length;
    int i = 0;
    FieldType localFieldType;
    while (i < j)
    {
      localFieldType = paramBaseDaoImpl[i];
      if ((localFieldType.getType() == paramClass2) && ((str == null) || (localFieldType.getField().getName().equals(str))))
      {
        if ((localFieldType.fieldConfig.isForeign()) || (localFieldType.fieldConfig.isForeignAutoRefresh())) {
          break label255;
        }
        throw new SQLException("Foreign collection object " + paramClass1 + " for field '" + this.field.getName() + "' contains a field of class " + paramClass2 + " but it's not foreign");
      }
      i += 1;
    }
    paramBaseDaoImpl = new StringBuilder();
    paramBaseDaoImpl.append("Foreign collection class ").append(paramClass1.getName());
    paramBaseDaoImpl.append(" for field '").append(this.field.getName()).append("' column-name does not contain a foreign field");
    if (str != null) {
      paramBaseDaoImpl.append(" named '").append(str).append('\'');
    }
    paramBaseDaoImpl.append(" of class ").append(paramClass2.getName());
    throw new SQLException(paramBaseDaoImpl.toString());
    label255:
    return localFieldType;
  }
  
  private boolean isFieldValueDefault(Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    return paramObject.equals(getJavaDefaultValueDefault());
  }
  
  /* Error */
  public void assignField(Object paramObject1, Object paramObject2, boolean paramBoolean, ObjectCache paramObjectCache)
    throws SQLException
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 524	com/j256/ormlite/field/FieldType:foreignIdField	Lcom/j256/ormlite/field/FieldType;
    //   7: ifnull +111 -> 118
    //   10: aload_2
    //   11: astore 5
    //   13: aload_2
    //   14: ifnull +104 -> 118
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 528	com/j256/ormlite/field/FieldType:extractJavaFieldValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +13 -> 39
    //   29: aload 5
    //   31: aload_2
    //   32: invokevirtual 518	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +4 -> 39
    //   38: return
    //   39: aload_2
    //   40: astore 5
    //   42: iload_3
    //   43: ifne +75 -> 118
    //   46: getstatic 81	com/j256/ormlite/field/FieldType:threadLevelCounters	Ljava/lang/ThreadLocal;
    //   49: invokevirtual 533	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   52: checkcast 8	com/j256/ormlite/field/FieldType$LevelCounters
    //   55: astore 5
    //   57: aload 5
    //   59: getfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   62: ifne +15 -> 77
    //   65: aload 5
    //   67: aload_0
    //   68: getfield 293	com/j256/ormlite/field/FieldType:fieldConfig	Lcom/j256/ormlite/field/DatabaseFieldConfig;
    //   71: invokevirtual 380	com/j256/ormlite/field/DatabaseFieldConfig:getMaxForeignAutoRefreshLevel	()I
    //   74: putfield 539	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevelMax	I
    //   77: aload 5
    //   79: getfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   82: aload 5
    //   84: getfield 539	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevelMax	I
    //   87: if_icmplt +86 -> 173
    //   90: aload_0
    //   91: getfield 541	com/j256/ormlite/field/FieldType:foreignTableInfo	Lcom/j256/ormlite/table/TableInfo;
    //   94: invokevirtual 544	com/j256/ormlite/table/TableInfo:createObject	()Ljava/lang/Object;
    //   97: astore 5
    //   99: aload_0
    //   100: getfield 524	com/j256/ormlite/field/FieldType:foreignIdField	Lcom/j256/ormlite/field/FieldType;
    //   103: aload 5
    //   105: aload_2
    //   106: iconst_0
    //   107: aload 4
    //   109: invokevirtual 546	com/j256/ormlite/field/FieldType:assignField	(Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V
    //   112: aload 5
    //   114: astore_2
    //   115: aload_2
    //   116: astore 5
    //   118: aload_0
    //   119: getfield 343	com/j256/ormlite/field/FieldType:fieldSetMethod	Ljava/lang/reflect/Method;
    //   122: ifnonnull +213 -> 335
    //   125: aload_0
    //   126: getfield 104	com/j256/ormlite/field/FieldType:field	Ljava/lang/reflect/Field;
    //   129: aload_1
    //   130: aload 5
    //   132: invokevirtual 550	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   135: return
    //   136: astore_1
    //   137: new 155	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 552
    //   147: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 5
    //   152: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: ldc_w 554
    //   158: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_1
    //   169: invokestatic 200	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   172: athrow
    //   173: aload_0
    //   174: getfield 556	com/j256/ormlite/field/FieldType:mappedQueryForId	Lcom/j256/ormlite/stmt/mapped/MappedQueryForId;
    //   177: ifnonnull +30 -> 207
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 94	com/j256/ormlite/field/FieldType:connectionSource	Lcom/j256/ormlite/support/ConnectionSource;
    //   185: invokeinterface 102 1 0
    //   190: aload_0
    //   191: getfield 558	com/j256/ormlite/field/FieldType:foreignDao	Lcom/j256/ormlite/dao/BaseDaoImpl;
    //   194: invokevirtual 482	com/j256/ormlite/dao/BaseDaoImpl:getTableInfo	()Lcom/j256/ormlite/table/TableInfo;
    //   197: aload_0
    //   198: getfield 524	com/j256/ormlite/field/FieldType:foreignIdField	Lcom/j256/ormlite/field/FieldType;
    //   201: invokestatic 564	com/j256/ormlite/stmt/mapped/MappedQueryForId:build	(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/table/TableInfo;Lcom/j256/ormlite/field/FieldType;)Lcom/j256/ormlite/stmt/mapped/MappedQueryForId;
    //   204: putfield 556	com/j256/ormlite/field/FieldType:mappedQueryForId	Lcom/j256/ormlite/stmt/mapped/MappedQueryForId;
    //   207: aload 5
    //   209: aload 5
    //   211: getfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   214: iconst_1
    //   215: iadd
    //   216: putfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   219: aload_0
    //   220: getfield 94	com/j256/ormlite/field/FieldType:connectionSource	Lcom/j256/ormlite/support/ConnectionSource;
    //   223: invokeinterface 568 1 0
    //   228: astore 6
    //   230: aload_0
    //   231: getfield 556	com/j256/ormlite/field/FieldType:mappedQueryForId	Lcom/j256/ormlite/stmt/mapped/MappedQueryForId;
    //   234: aload 6
    //   236: aload_2
    //   237: aload 4
    //   239: invokevirtual 572	com/j256/ormlite/stmt/mapped/MappedQueryForId:execute	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/lang/Object;Lcom/j256/ormlite/dao/ObjectCache;)Ljava/lang/Object;
    //   242: astore_2
    //   243: aload_0
    //   244: getfield 94	com/j256/ormlite/field/FieldType:connectionSource	Lcom/j256/ormlite/support/ConnectionSource;
    //   247: aload 6
    //   249: invokeinterface 576 2 0
    //   254: aload 5
    //   256: aload 5
    //   258: getfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   261: iconst_1
    //   262: isub
    //   263: putfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   266: goto -151 -> 115
    //   269: astore_1
    //   270: aload_0
    //   271: getfield 94	com/j256/ormlite/field/FieldType:connectionSource	Lcom/j256/ormlite/support/ConnectionSource;
    //   274: aload 6
    //   276: invokeinterface 576 2 0
    //   281: aload_1
    //   282: athrow
    //   283: astore_1
    //   284: aload 5
    //   286: aload 5
    //   288: getfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   291: iconst_1
    //   292: isub
    //   293: putfield 536	com/j256/ormlite/field/FieldType$LevelCounters:autoRefreshLevel	I
    //   296: aload_1
    //   297: athrow
    //   298: astore_1
    //   299: new 155	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 552
    //   309: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 5
    //   314: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   317: ldc_w 554
    //   320: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: aload_1
    //   331: invokestatic 200	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   334: athrow
    //   335: aload_0
    //   336: getfield 343	com/j256/ormlite/field/FieldType:fieldSetMethod	Ljava/lang/reflect/Method;
    //   339: aload_1
    //   340: iconst_1
    //   341: anewarray 4	java/lang/Object
    //   344: dup
    //   345: iconst_0
    //   346: aload 5
    //   348: aastore
    //   349: invokevirtual 189	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   352: pop
    //   353: return
    //   354: astore_1
    //   355: new 155	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 578
    //   365: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_0
    //   369: getfield 343	com/j256/ormlite/field/FieldType:fieldSetMethod	Ljava/lang/reflect/Method;
    //   372: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   375: ldc_w 580
    //   378: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 5
    //   383: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: ldc_w 582
    //   389: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_0
    //   393: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: aload_1
    //   400: invokestatic 200	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   403: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	FieldType
    //   0	404	1	paramObject1	Object
    //   0	404	2	paramObject2	Object
    //   0	404	3	paramBoolean	boolean
    //   0	404	4	paramObjectCache	ObjectCache
    //   1	381	5	localObject	Object
    //   228	47	6	localDatabaseConnection	com.j256.ormlite.support.DatabaseConnection
    // Exception table:
    //   from	to	target	type
    //   125	135	136	java/lang/IllegalArgumentException
    //   230	243	269	finally
    //   219	230	283	finally
    //   243	254	283	finally
    //   270	283	283	finally
    //   125	135	298	java/lang/IllegalAccessException
    //   335	353	354	java/lang/Exception
  }
  
  public Object assignIdValue(Object paramObject, Number paramNumber, ObjectCache paramObjectCache)
    throws SQLException
  {
    paramNumber = this.dataPersister.convertIdNumber(paramNumber);
    if (paramNumber == null) {
      throw new SQLException("Invalid class " + this.dataPersister + " for sequence-id " + this);
    }
    assignField(paramObject, paramNumber, false, paramObjectCache);
    return paramNumber;
  }
  
  public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(Object paramObject, FID paramFID)
    throws SQLException
  {
    if (this.foreignFieldType == null) {
      return null;
    }
    BaseDaoImpl localBaseDaoImpl = this.foreignDao;
    if (!this.fieldConfig.isForeignCollectionEager()) {
      return new LazyForeignCollection(localBaseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
    }
    LevelCounters localLevelCounters = (LevelCounters)threadLevelCounters.get();
    if (localLevelCounters.foreignCollectionLevel == 0) {
      localLevelCounters.foreignCollectionLevelMax = this.fieldConfig.getForeignCollectionMaxEagerLevel();
    }
    if (localLevelCounters.foreignCollectionLevel >= localLevelCounters.foreignCollectionLevelMax) {
      return new LazyForeignCollection(localBaseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
    }
    localLevelCounters.foreignCollectionLevel += 1;
    try
    {
      paramObject = new EagerForeignCollection(localBaseDaoImpl, paramObject, paramFID, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
      return (BaseForeignCollection<FT, FID>)paramObject;
    }
    finally
    {
      localLevelCounters.foreignCollectionLevel -= 1;
    }
  }
  
  public void configDaoInformation(ConnectionSource paramConnectionSource, Class<?> paramClass)
    throws SQLException
  {
    Object localObject3 = this.field.getType();
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    String str = this.fieldConfig.getForeignColumnName();
    Object localObject2;
    Object localObject1;
    if ((this.fieldConfig.isForeignAutoRefresh()) || (str != null))
    {
      paramClass = this.fieldConfig.getForeignTableConfig();
      if (paramClass == null) {
        paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, (Class)localObject3);
      }
      for (localObject2 = paramConnectionSource.getTableInfo(); str == null; localObject2 = paramConnectionSource.getTableInfo())
      {
        paramClass = ((TableInfo)localObject2).getIdField();
        localObject1 = paramClass;
        if (paramClass != null) {
          break label204;
        }
        throw new IllegalArgumentException("Foreign field " + localObject3 + " does not have id field");
        paramClass.extractFieldTypes(paramConnectionSource);
        paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, paramClass);
      }
      paramClass = ((TableInfo)localObject2).getFieldTypeByColumnName(str);
      localObject1 = paramClass;
      if (paramClass == null) {
        throw new IllegalArgumentException("Foreign field " + localObject3 + " does not have field named '" + str + "'");
      }
      label204:
      localObject3 = MappedQueryForId.build(localDatabaseType, (TableInfo)localObject2, (FieldType)localObject1);
      paramClass = null;
    }
    for (;;)
    {
      this.mappedQueryForId = ((MappedQueryForId)localObject3);
      this.foreignTableInfo = ((TableInfo)localObject2);
      this.foreignFieldType = paramClass;
      this.foreignDao = paramConnectionSource;
      this.foreignIdField = ((FieldType)localObject1);
      if (this.foreignIdField != null) {
        assignDataType(localDatabaseType, this.foreignIdField.getDataPersister());
      }
      return;
      if (this.fieldConfig.isForeign())
      {
        if ((this.dataPersister != null) && (this.dataPersister.isPrimitive())) {
          throw new IllegalArgumentException("Field " + this + " is a primitive class " + localObject3 + " but marked as foreign");
        }
        paramClass = this.fieldConfig.getForeignTableConfig();
        if (paramClass != null) {
          paramClass.extractFieldTypes(paramConnectionSource);
        }
        for (paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, paramClass);; paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, (Class)localObject3))
        {
          localObject2 = paramConnectionSource.getTableInfo();
          localObject1 = ((TableInfo)localObject2).getIdField();
          if (localObject1 != null) {
            break;
          }
          throw new IllegalArgumentException("Foreign field " + localObject3 + " does not have id field");
        }
        if ((isForeignAutoCreate()) && (!((FieldType)localObject1).isGeneratedId())) {
          throw new IllegalArgumentException("Field " + this.field.getName() + ", if foreignAutoCreate = true then class " + ((Class)localObject3).getSimpleName() + " must have id field with generatedId = true");
        }
        paramClass = null;
        localObject3 = null;
      }
      else
      {
        if (this.fieldConfig.isForeignCollection())
        {
          if ((localObject3 != Collection.class) && (!ForeignCollection.class.isAssignableFrom((Class)localObject3))) {
            throw new SQLException("Field class for '" + this.field.getName() + "' must be of class " + ForeignCollection.class.getSimpleName() + " or Collection.");
          }
          localObject1 = this.field.getGenericType();
          if (!(localObject1 instanceof ParameterizedType)) {
            throw new SQLException("Field class for '" + this.field.getName() + "' must be a parameterized Collection.");
          }
          localObject1 = ((ParameterizedType)localObject1).getActualTypeArguments();
          if (localObject1.length == 0) {
            throw new SQLException("Field class for '" + this.field.getName() + "' must be a parameterized Collection with at least 1 type.");
          }
          localObject2 = (Class)localObject1[0];
          localObject1 = this.fieldConfig.getForeignTableConfig();
          if (localObject1 == null) {}
          for (paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, (Class)localObject2);; paramConnectionSource = (BaseDaoImpl)DaoManager.createDao(paramConnectionSource, (DatabaseTableConfig)localObject1))
          {
            localObject1 = paramConnectionSource;
            paramClass = findForeignFieldType((Class)localObject2, paramClass, paramConnectionSource);
            str = null;
            localObject2 = null;
            localObject3 = null;
            paramConnectionSource = (ConnectionSource)localObject1;
            localObject1 = str;
            break;
          }
        }
        localObject2 = null;
        localObject1 = null;
        paramClass = null;
        paramConnectionSource = null;
        localObject3 = null;
      }
    }
  }
  
  public Object convertJavaFieldToSqlArgValue(Object paramObject)
    throws SQLException
  {
    if (paramObject == null) {
      return null;
    }
    return this.fieldConverter.javaToSqlArg(this, paramObject);
  }
  
  public Object convertStringToJavaField(String paramString, int paramInt)
    throws SQLException
  {
    if (paramString == null) {
      return null;
    }
    return this.fieldConverter.resultStringToJava(this, paramString, paramInt);
  }
  
  public <T> int createWithForeignDao(T paramT)
    throws SQLException
  {
    return this.foreignDao.create(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    do
    {
      do
      {
        return false;
        paramObject = (FieldType)paramObject;
      } while (!this.field.equals(((FieldType)paramObject).field));
      if (this.parentClass != null) {
        break;
      }
    } while (((FieldType)paramObject).parentClass != null);
    for (;;)
    {
      return true;
      if (!this.parentClass.equals(((FieldType)paramObject).parentClass)) {
        break;
      }
    }
  }
  
  public Object extractJavaFieldToSqlArgValue(Object paramObject)
    throws SQLException
  {
    return convertJavaFieldToSqlArgValue(extractJavaFieldValue(paramObject));
  }
  
  public Object extractJavaFieldValue(Object paramObject)
    throws SQLException
  {
    Object localObject = extractRawJavaFieldValue(paramObject);
    paramObject = localObject;
    if (this.foreignIdField != null)
    {
      paramObject = localObject;
      if (localObject != null) {
        paramObject = this.foreignIdField.extractRawJavaFieldValue(localObject);
      }
    }
    return paramObject;
  }
  
  public <FV> FV extractRawJavaFieldValue(Object paramObject)
    throws SQLException
  {
    if (this.fieldGetMethod == null) {}
    for (;;)
    {
      try
      {
        paramObject = this.field.get(paramObject);
        return (FV)paramObject;
      }
      catch (Exception paramObject)
      {
        throw SqlExceptionUtil.create("Could not get field value for " + this, (Throwable)paramObject);
      }
      try
      {
        paramObject = this.fieldGetMethod.invoke(paramObject, new Object[0]);
      }
      catch (Exception paramObject)
      {
        throw SqlExceptionUtil.create("Could not call " + this.fieldGetMethod + " for " + this, (Throwable)paramObject);
      }
    }
  }
  
  public Object generateId()
  {
    return this.dataPersister.generateId();
  }
  
  public String getColumnDefinition()
  {
    return this.fieldConfig.getColumnDefinition();
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public DataPersister getDataPersister()
  {
    return this.dataPersister;
  }
  
  public Object getDataTypeConfigObj()
  {
    return this.dataTypeConfigObj;
  }
  
  public Object getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public Field getField()
  {
    return this.field;
  }
  
  public String getFieldName()
  {
    return this.field.getName();
  }
  
  public <FV> FV getFieldValueIfNotDefault(Object paramObject)
    throws SQLException
  {
    Object localObject = extractJavaFieldValue(paramObject);
    paramObject = localObject;
    if (isFieldValueDefault(localObject)) {
      paramObject = null;
    }
    return (FV)paramObject;
  }
  
  public FieldType getForeignIdField()
  {
    return this.foreignIdField;
  }
  
  public String getFormat()
  {
    return this.fieldConfig.getFormat();
  }
  
  public String getGeneratedIdSequence()
  {
    return this.generatedIdSequence;
  }
  
  public String getIndexName()
  {
    return this.fieldConfig.getIndexName(this.tableName);
  }
  
  public Object getJavaDefaultValueDefault()
  {
    if (this.field.getType() == Boolean.TYPE) {
      return Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
    }
    if ((this.field.getType() == Byte.TYPE) || (this.field.getType() == Byte.class)) {
      return Byte.valueOf(DEFAULT_VALUE_BYTE);
    }
    if ((this.field.getType() == Character.TYPE) || (this.field.getType() == Character.class)) {
      return Character.valueOf(DEFAULT_VALUE_CHAR);
    }
    if ((this.field.getType() == Short.TYPE) || (this.field.getType() == Short.class)) {
      return Short.valueOf(DEFAULT_VALUE_SHORT);
    }
    if ((this.field.getType() == Integer.TYPE) || (this.field.getType() == Integer.class)) {
      return Integer.valueOf(DEFAULT_VALUE_INT);
    }
    if ((this.field.getType() == Long.TYPE) || (this.field.getType() == Long.class)) {
      return Long.valueOf(DEFAULT_VALUE_LONG);
    }
    if ((this.field.getType() == Float.TYPE) || (this.field.getType() == Float.class)) {
      return Float.valueOf(DEFAULT_VALUE_FLOAT);
    }
    if ((this.field.getType() == Double.TYPE) || (this.field.getType() == Double.class)) {
      return Double.valueOf(DEFAULT_VALUE_DOUBLE);
    }
    return null;
  }
  
  public SqlType getSqlType()
  {
    return this.fieldConverter.getSqlType();
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public Class<?> getType()
  {
    return this.field.getType();
  }
  
  public String getUniqueIndexName()
  {
    return this.fieldConfig.getUniqueIndexName(this.tableName);
  }
  
  public Enum<?> getUnknownEnumVal()
  {
    return this.fieldConfig.getUnknownEnumValue();
  }
  
  public int getWidth()
  {
    return this.fieldConfig.getWidth();
  }
  
  public int hashCode()
  {
    return this.field.hashCode();
  }
  
  public boolean isAllowGeneratedIdInsert()
  {
    return this.fieldConfig.isAllowGeneratedIdInsert();
  }
  
  public boolean isArgumentHolderRequired()
  {
    return this.dataPersister.isArgumentHolderRequired();
  }
  
  public boolean isCanBeNull()
  {
    return this.fieldConfig.isCanBeNull();
  }
  
  public boolean isComparable()
    throws SQLException
  {
    if (this.fieldConfig.isForeignCollection()) {
      return false;
    }
    if (this.dataPersister == null) {
      throw new SQLException("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: " + this);
    }
    return this.dataPersister.isComparable();
  }
  
  public boolean isEscapedDefaultValue()
  {
    return this.dataPersister.isEscapedDefaultValue();
  }
  
  public boolean isEscapedValue()
  {
    return this.dataPersister.isEscapedValue();
  }
  
  public boolean isForeign()
  {
    return this.fieldConfig.isForeign();
  }
  
  public boolean isForeignAutoCreate()
  {
    return this.fieldConfig.isForeignAutoCreate();
  }
  
  public boolean isForeignCollection()
  {
    return this.fieldConfig.isForeignCollection();
  }
  
  public boolean isGeneratedId()
  {
    return this.isGeneratedId;
  }
  
  public boolean isGeneratedIdSequence()
  {
    return this.generatedIdSequence != null;
  }
  
  public boolean isId()
  {
    return this.isId;
  }
  
  public boolean isObjectsFieldValueDefault(Object paramObject)
    throws SQLException
  {
    return isFieldValueDefault(extractJavaFieldValue(paramObject));
  }
  
  public boolean isReadOnly()
  {
    return this.fieldConfig.isReadOnly();
  }
  
  public boolean isSelfGeneratedId()
  {
    return this.dataPersister.isSelfGeneratedId();
  }
  
  public boolean isUnique()
  {
    return this.fieldConfig.isUnique();
  }
  
  public boolean isUniqueCombo()
  {
    return this.fieldConfig.isUniqueCombo();
  }
  
  public boolean isVersion()
  {
    return this.fieldConfig.isVersion();
  }
  
  public Object moveToNextValue(Object paramObject)
  {
    if (this.dataPersister == null) {
      return null;
    }
    return this.dataPersister.moveToNextValue(paramObject);
  }
  
  public <T> T resultToJava(DatabaseResults paramDatabaseResults, Map<String, Integer> paramMap)
    throws SQLException
  {
    Object localObject2 = (Integer)paramMap.get(this.columnName);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Integer.valueOf(paramDatabaseResults.findColumn(this.columnName));
      paramMap.put(this.columnName, localObject1);
    }
    localObject2 = this.fieldConverter.resultToJava(this, paramDatabaseResults, ((Integer)localObject1).intValue());
    if (this.fieldConfig.isForeign())
    {
      paramMap = (Map<String, Integer>)localObject2;
      if (paramDatabaseResults.wasNull(((Integer)localObject1).intValue())) {
        paramMap = null;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramMap;
            if (!this.dataPersister.isPrimitive()) {
              break;
            }
            paramMap = (Map<String, Integer>)localObject2;
          } while (!this.fieldConfig.isThrowIfNull());
          paramMap = (Map<String, Integer>)localObject2;
        } while (!paramDatabaseResults.wasNull(((Integer)localObject1).intValue()));
        throw new SQLException("Results value for primitive field '" + this.field.getName() + "' was an invalid null value");
        paramMap = (Map<String, Integer>)localObject2;
      } while (this.fieldConverter.isStreamType());
      paramMap = (Map<String, Integer>)localObject2;
    } while (!paramDatabaseResults.wasNull(((Integer)localObject1).intValue()));
    return null;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + ":name=" + this.field.getName() + ",class=" + this.field.getDeclaringClass().getSimpleName();
  }
  
  private static class LevelCounters
  {
    int autoRefreshLevel;
    int autoRefreshLevelMax;
    int foreignCollectionLevel;
    int foreignCollectionLevelMax;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */