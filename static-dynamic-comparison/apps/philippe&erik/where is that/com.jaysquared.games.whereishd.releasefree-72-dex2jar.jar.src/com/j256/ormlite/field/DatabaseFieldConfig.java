package com.j256.ormlite.field;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DatabaseFieldConfig
{
  public static final boolean DEFAULT_CAN_BE_NULL = true;
  public static final DataType DEFAULT_DATA_TYPE = DataType.UNKNOWN;
  public static final boolean DEFAULT_FOREIGN_COLLECTION_ORDER_ASCENDING = true;
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  public static final Class<? extends DataPersister> DEFAULT_PERSISTER_CLASS = VoidType.class;
  private boolean allowGeneratedIdInsert;
  private boolean canBeNull = true;
  private String columnDefinition;
  private String columnName;
  private DataPersister dataPersister;
  private DataType dataType = DEFAULT_DATA_TYPE;
  private String defaultValue;
  private String fieldName;
  private boolean foreign;
  private boolean foreignAutoCreate;
  private boolean foreignAutoRefresh;
  private boolean foreignCollection;
  private String foreignCollectionColumnName;
  private boolean foreignCollectionEager;
  private String foreignCollectionForeignFieldName;
  private int foreignCollectionMaxEagerLevel = 1;
  private boolean foreignCollectionOrderAscending = true;
  private String foreignCollectionOrderColumnName;
  private String foreignColumnName;
  private DatabaseTableConfig<?> foreignTableConfig;
  private String format;
  private boolean generatedId;
  private String generatedIdSequence;
  private boolean id;
  private boolean index;
  private String indexName;
  private int maxForeignAutoRefreshLevel = -1;
  private boolean persisted = true;
  private Class<? extends DataPersister> persisterClass = DEFAULT_PERSISTER_CLASS;
  private boolean readOnly;
  private boolean throwIfNull;
  private boolean unique;
  private boolean uniqueCombo;
  private boolean uniqueIndex;
  private String uniqueIndexName;
  private Enum<?> unknownEnumValue;
  private boolean useGetSet;
  private boolean version;
  private int width;
  
  public DatabaseFieldConfig() {}
  
  public DatabaseFieldConfig(String paramString)
  {
    this.fieldName = paramString;
  }
  
  public DatabaseFieldConfig(String paramString1, String paramString2, DataType paramDataType, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, boolean paramBoolean4, DatabaseTableConfig<?> paramDatabaseTableConfig, boolean paramBoolean5, Enum<?> paramEnum, boolean paramBoolean6, String paramString5, boolean paramBoolean7, String paramString6, String paramString7, boolean paramBoolean8, int paramInt2, int paramInt3)
  {
    this.fieldName = paramString1;
    this.columnName = paramString2;
    this.dataType = DataType.UNKNOWN;
    this.defaultValue = paramString3;
    this.width = paramInt1;
    this.canBeNull = paramBoolean1;
    this.id = paramBoolean2;
    this.generatedId = paramBoolean3;
    this.generatedIdSequence = paramString4;
    this.foreign = paramBoolean4;
    this.foreignTableConfig = paramDatabaseTableConfig;
    this.useGetSet = paramBoolean5;
    this.unknownEnumValue = paramEnum;
    this.throwIfNull = paramBoolean6;
    this.format = paramString5;
    this.unique = paramBoolean7;
    this.indexName = paramString6;
    this.uniqueIndexName = paramString7;
    this.foreignAutoRefresh = paramBoolean8;
    this.maxForeignAutoRefreshLevel = paramInt2;
    this.foreignCollectionMaxEagerLevel = paramInt3;
  }
  
  public static Method findGetMethod(Field paramField, boolean paramBoolean)
  {
    String str = methodFromField(paramField, "get");
    Method localMethod2;
    try
    {
      Method localMethod1 = paramField.getDeclaringClass().getMethod(str, new Class[0]);
      localMethod2 = localMethod1;
      if (localMethod1.getReturnType() != paramField.getType())
      {
        if (!paramBoolean) {
          break label115;
        }
        throw new IllegalArgumentException("Return type of get method " + str + " does not return " + paramField.getType());
      }
    }
    catch (Exception localException)
    {
      if (paramBoolean) {
        throw new IllegalArgumentException("Could not find appropriate get method for " + paramField);
      }
      localMethod2 = null;
    }
    return localMethod2;
    label115:
    return null;
  }
  
  private String findIndexName(String paramString)
  {
    if (this.columnName == null) {
      return paramString + "_" + this.fieldName + "_idx";
    }
    return paramString + "_" + this.columnName + "_idx";
  }
  
  public static Enum<?> findMatchingEnumVal(Field paramField, String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject = null;
      return (Enum<?>)localObject;
    }
    Enum[] arrayOfEnum = (Enum[])paramField.getType().getEnumConstants();
    int j = arrayOfEnum.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      Enum localEnum = arrayOfEnum[i];
      localObject = localEnum;
      if (localEnum.name().equals(paramString)) {
        break;
      }
      i += 1;
    }
    label72:
    throw new IllegalArgumentException("Unknwown enum unknown name " + paramString + " for field " + paramField);
  }
  
  public static Method findSetMethod(Field paramField, boolean paramBoolean)
  {
    String str = methodFromField(paramField, "set");
    try
    {
      Object localObject = paramField.getDeclaringClass().getMethod(str, new Class[] { paramField.getType() });
      paramField = (Field)localObject;
      localObject = paramField;
      if (paramField.getReturnType() != Void.TYPE)
      {
        if (!paramBoolean) {
          break label125;
        }
        throw new IllegalArgumentException("Return type of set method " + str + " returns " + paramField.getReturnType() + " instead of void");
      }
    }
    catch (Exception localException)
    {
      if (paramBoolean) {
        throw new IllegalArgumentException("Could not find appropriate set method for " + paramField);
      }
      Method localMethod = null;
      return localMethod;
    }
    label125:
    return null;
  }
  
  public static DatabaseFieldConfig fromDatabaseField(DatabaseType paramDatabaseType, String paramString, Field paramField, DatabaseField paramDatabaseField)
  {
    paramString = new DatabaseFieldConfig();
    paramString.fieldName = paramField.getName();
    if (paramDatabaseType.isEntityNamesMustBeUpCase()) {
      paramString.fieldName = paramString.fieldName.toUpperCase();
    }
    paramString.columnName = valueIfNotBlank(paramDatabaseField.columnName());
    paramString.dataType = paramDatabaseField.dataType();
    paramDatabaseType = paramDatabaseField.defaultValue();
    if (!paramDatabaseType.equals("__ormlite__ no default value string was specified")) {
      paramString.defaultValue = paramDatabaseType;
    }
    paramString.width = paramDatabaseField.width();
    paramString.canBeNull = paramDatabaseField.canBeNull();
    paramString.id = paramDatabaseField.id();
    paramString.generatedId = paramDatabaseField.generatedId();
    paramString.generatedIdSequence = valueIfNotBlank(paramDatabaseField.generatedIdSequence());
    paramString.foreign = paramDatabaseField.foreign();
    paramString.useGetSet = paramDatabaseField.useGetSet();
    paramString.unknownEnumValue = findMatchingEnumVal(paramField, paramDatabaseField.unknownEnumName());
    paramString.throwIfNull = paramDatabaseField.throwIfNull();
    paramString.format = valueIfNotBlank(paramDatabaseField.format());
    paramString.unique = paramDatabaseField.unique();
    paramString.uniqueCombo = paramDatabaseField.uniqueCombo();
    paramString.index = paramDatabaseField.index();
    paramString.indexName = valueIfNotBlank(paramDatabaseField.indexName());
    paramString.uniqueIndex = paramDatabaseField.uniqueIndex();
    paramString.uniqueIndexName = valueIfNotBlank(paramDatabaseField.uniqueIndexName());
    paramString.foreignAutoRefresh = paramDatabaseField.foreignAutoRefresh();
    paramString.maxForeignAutoRefreshLevel = paramDatabaseField.maxForeignAutoRefreshLevel();
    paramString.persisterClass = paramDatabaseField.persisterClass();
    paramString.allowGeneratedIdInsert = paramDatabaseField.allowGeneratedIdInsert();
    paramString.columnDefinition = valueIfNotBlank(paramDatabaseField.columnDefinition());
    paramString.foreignAutoCreate = paramDatabaseField.foreignAutoCreate();
    paramString.version = paramDatabaseField.version();
    paramString.foreignColumnName = valueIfNotBlank(paramDatabaseField.foreignColumnName());
    paramString.readOnly = paramDatabaseField.readOnly();
    return paramString;
  }
  
  public static DatabaseFieldConfig fromField(DatabaseType paramDatabaseType, String paramString, Field paramField)
    throws SQLException
  {
    DatabaseField localDatabaseField = (DatabaseField)paramField.getAnnotation(DatabaseField.class);
    if (localDatabaseField != null)
    {
      if (localDatabaseField.persisted()) {
        return fromDatabaseField(paramDatabaseType, paramString, paramField, localDatabaseField);
      }
      return null;
    }
    paramString = (ForeignCollectionField)paramField.getAnnotation(ForeignCollectionField.class);
    if (paramString != null) {
      return fromForeignCollection(paramDatabaseType, paramField, paramString);
    }
    return JavaxPersistence.createFieldConfig(paramDatabaseType, paramField);
  }
  
  private static DatabaseFieldConfig fromForeignCollection(DatabaseType paramDatabaseType, Field paramField, ForeignCollectionField paramForeignCollectionField)
  {
    paramDatabaseType = new DatabaseFieldConfig();
    paramDatabaseType.fieldName = paramField.getName();
    if (paramForeignCollectionField.columnName().length() > 0) {
      paramDatabaseType.columnName = paramForeignCollectionField.columnName();
    }
    paramDatabaseType.foreignCollection = true;
    paramDatabaseType.foreignCollectionEager = paramForeignCollectionField.eager();
    int i = paramForeignCollectionField.maxEagerForeignCollectionLevel();
    if (i != 1) {}
    for (paramDatabaseType.foreignCollectionMaxEagerLevel = i;; paramDatabaseType.foreignCollectionMaxEagerLevel = paramForeignCollectionField.maxEagerLevel())
    {
      paramDatabaseType.foreignCollectionOrderColumnName = valueIfNotBlank(paramForeignCollectionField.orderColumnName());
      paramDatabaseType.foreignCollectionOrderAscending = paramForeignCollectionField.orderAscending();
      paramDatabaseType.foreignCollectionColumnName = valueIfNotBlank(paramForeignCollectionField.columnName());
      paramField = valueIfNotBlank(paramForeignCollectionField.foreignFieldName());
      if (paramField != null) {
        break;
      }
      paramDatabaseType.foreignCollectionForeignFieldName = valueIfNotBlank(valueIfNotBlank(paramForeignCollectionField.foreignColumnName()));
      return paramDatabaseType;
    }
    paramDatabaseType.foreignCollectionForeignFieldName = paramField;
    return paramDatabaseType;
  }
  
  private static String methodFromField(Field paramField, String paramString)
  {
    return paramString + paramField.getName().substring(0, 1).toUpperCase() + paramField.getName().substring(1);
  }
  
  private static String valueIfNotBlank(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  public String getColumnDefinition()
  {
    return this.columnDefinition;
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public DataPersister getDataPersister()
  {
    if (this.dataPersister == null) {
      return this.dataType.getDataPersister();
    }
    return this.dataPersister;
  }
  
  public DataType getDataType()
  {
    return this.dataType;
  }
  
  public String getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public String getFieldName()
  {
    return this.fieldName;
  }
  
  public String getForeignCollectionColumnName()
  {
    return this.foreignCollectionColumnName;
  }
  
  public String getForeignCollectionForeignFieldName()
  {
    return this.foreignCollectionForeignFieldName;
  }
  
  public int getForeignCollectionMaxEagerLevel()
  {
    return this.foreignCollectionMaxEagerLevel;
  }
  
  public String getForeignCollectionOrderColumnName()
  {
    return this.foreignCollectionOrderColumnName;
  }
  
  public String getForeignColumnName()
  {
    return this.foreignColumnName;
  }
  
  public DatabaseTableConfig<?> getForeignTableConfig()
  {
    return this.foreignTableConfig;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public String getGeneratedIdSequence()
  {
    return this.generatedIdSequence;
  }
  
  public String getIndexName(String paramString)
  {
    if ((this.index) && (this.indexName == null)) {
      this.indexName = findIndexName(paramString);
    }
    return this.indexName;
  }
  
  public int getMaxForeignAutoRefreshLevel()
  {
    return this.maxForeignAutoRefreshLevel;
  }
  
  public Class<? extends DataPersister> getPersisterClass()
  {
    return this.persisterClass;
  }
  
  public String getUniqueIndexName(String paramString)
  {
    if ((this.uniqueIndex) && (this.uniqueIndexName == null)) {
      this.uniqueIndexName = findIndexName(paramString);
    }
    return this.uniqueIndexName;
  }
  
  public Enum<?> getUnknownEnumValue()
  {
    return this.unknownEnumValue;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isAllowGeneratedIdInsert()
  {
    return this.allowGeneratedIdInsert;
  }
  
  public boolean isCanBeNull()
  {
    return this.canBeNull;
  }
  
  public boolean isForeign()
  {
    return this.foreign;
  }
  
  public boolean isForeignAutoCreate()
  {
    return this.foreignAutoCreate;
  }
  
  public boolean isForeignAutoRefresh()
  {
    return this.foreignAutoRefresh;
  }
  
  public boolean isForeignCollection()
  {
    return this.foreignCollection;
  }
  
  public boolean isForeignCollectionEager()
  {
    return this.foreignCollectionEager;
  }
  
  public boolean isForeignCollectionOrderAscending()
  {
    return this.foreignCollectionOrderAscending;
  }
  
  public boolean isGeneratedId()
  {
    return this.generatedId;
  }
  
  public boolean isId()
  {
    return this.id;
  }
  
  public boolean isIndex()
  {
    return this.index;
  }
  
  public boolean isPersisted()
  {
    return this.persisted;
  }
  
  public boolean isReadOnly()
  {
    return this.readOnly;
  }
  
  public boolean isThrowIfNull()
  {
    return this.throwIfNull;
  }
  
  public boolean isUnique()
  {
    return this.unique;
  }
  
  public boolean isUniqueCombo()
  {
    return this.uniqueCombo;
  }
  
  public boolean isUniqueIndex()
  {
    return this.uniqueIndex;
  }
  
  public boolean isUseGetSet()
  {
    return this.useGetSet;
  }
  
  public boolean isVersion()
  {
    return this.version;
  }
  
  public void postProcess()
  {
    if (this.foreignColumnName != null) {
      this.foreignAutoRefresh = true;
    }
    if ((this.foreignAutoRefresh) && (this.maxForeignAutoRefreshLevel == -1)) {
      this.maxForeignAutoRefreshLevel = 2;
    }
  }
  
  public void setAllowGeneratedIdInsert(boolean paramBoolean)
  {
    this.allowGeneratedIdInsert = paramBoolean;
  }
  
  public void setCanBeNull(boolean paramBoolean)
  {
    this.canBeNull = paramBoolean;
  }
  
  public void setColumnDefinition(String paramString)
  {
    this.columnDefinition = paramString;
  }
  
  public void setColumnName(String paramString)
  {
    this.columnName = paramString;
  }
  
  public void setDataPersister(DataPersister paramDataPersister)
  {
    this.dataPersister = paramDataPersister;
  }
  
  public void setDataType(DataType paramDataType)
  {
    this.dataType = paramDataType;
  }
  
  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }
  
  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }
  
  public void setForeign(boolean paramBoolean)
  {
    this.foreign = paramBoolean;
  }
  
  public void setForeignAutoCreate(boolean paramBoolean)
  {
    this.foreignAutoCreate = paramBoolean;
  }
  
  public void setForeignAutoRefresh(boolean paramBoolean)
  {
    this.foreignAutoRefresh = paramBoolean;
  }
  
  public void setForeignCollection(boolean paramBoolean)
  {
    this.foreignCollection = paramBoolean;
  }
  
  public void setForeignCollectionColumnName(String paramString)
  {
    this.foreignCollectionColumnName = paramString;
  }
  
  public void setForeignCollectionEager(boolean paramBoolean)
  {
    this.foreignCollectionEager = paramBoolean;
  }
  
  @Deprecated
  public void setForeignCollectionForeignColumnName(String paramString)
  {
    this.foreignCollectionForeignFieldName = paramString;
  }
  
  public void setForeignCollectionForeignFieldName(String paramString)
  {
    this.foreignCollectionForeignFieldName = paramString;
  }
  
  @Deprecated
  public void setForeignCollectionMaxEagerForeignCollectionLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setForeignCollectionMaxEagerLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setForeignCollectionOrderAscending(boolean paramBoolean)
  {
    this.foreignCollectionOrderAscending = paramBoolean;
  }
  
  @Deprecated
  public void setForeignCollectionOrderColumn(String paramString)
  {
    this.foreignCollectionOrderColumnName = paramString;
  }
  
  public void setForeignCollectionOrderColumnName(String paramString)
  {
    this.foreignCollectionOrderColumnName = paramString;
  }
  
  public void setForeignColumnName(String paramString)
  {
    this.foreignColumnName = paramString;
  }
  
  public void setForeignTableConfig(DatabaseTableConfig<?> paramDatabaseTableConfig)
  {
    this.foreignTableConfig = paramDatabaseTableConfig;
  }
  
  public void setFormat(String paramString)
  {
    this.format = paramString;
  }
  
  public void setGeneratedId(boolean paramBoolean)
  {
    this.generatedId = paramBoolean;
  }
  
  public void setGeneratedIdSequence(String paramString)
  {
    this.generatedIdSequence = paramString;
  }
  
  public void setId(boolean paramBoolean)
  {
    this.id = paramBoolean;
  }
  
  public void setIndex(boolean paramBoolean)
  {
    this.index = paramBoolean;
  }
  
  public void setIndexName(String paramString)
  {
    this.indexName = paramString;
  }
  
  @Deprecated
  public void setMaxEagerForeignCollectionLevel(int paramInt)
  {
    this.foreignCollectionMaxEagerLevel = paramInt;
  }
  
  public void setMaxForeignAutoRefreshLevel(int paramInt)
  {
    this.maxForeignAutoRefreshLevel = paramInt;
  }
  
  public void setPersisted(boolean paramBoolean)
  {
    this.persisted = paramBoolean;
  }
  
  public void setPersisterClass(Class<? extends DataPersister> paramClass)
  {
    this.persisterClass = paramClass;
  }
  
  public void setReadOnly(boolean paramBoolean)
  {
    this.readOnly = paramBoolean;
  }
  
  public void setThrowIfNull(boolean paramBoolean)
  {
    this.throwIfNull = paramBoolean;
  }
  
  public void setUnique(boolean paramBoolean)
  {
    this.unique = paramBoolean;
  }
  
  public void setUniqueCombo(boolean paramBoolean)
  {
    this.uniqueCombo = paramBoolean;
  }
  
  public void setUniqueIndex(boolean paramBoolean)
  {
    this.uniqueIndex = paramBoolean;
  }
  
  public void setUniqueIndexName(String paramString)
  {
    this.uniqueIndexName = paramString;
  }
  
  public void setUnknownEnumValue(Enum<?> paramEnum)
  {
    this.unknownEnumValue = paramEnum;
  }
  
  public void setUseGetSet(boolean paramBoolean)
  {
    this.useGetSet = paramBoolean;
  }
  
  public void setVersion(boolean paramBoolean)
  {
    this.version = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/DatabaseFieldConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */