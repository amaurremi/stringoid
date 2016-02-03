package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfig<T>
{
  private Constructor<T> constructor;
  private Class<T> dataClass;
  private List<DatabaseFieldConfig> fieldConfigs;
  private FieldType[] fieldTypes;
  private String tableName;
  
  public DatabaseTableConfig() {}
  
  public DatabaseTableConfig(Class<T> paramClass, String paramString, List<DatabaseFieldConfig> paramList)
  {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldConfigs = paramList;
  }
  
  private DatabaseTableConfig(Class<T> paramClass, String paramString, FieldType[] paramArrayOfFieldType)
  {
    this.dataClass = paramClass;
    this.tableName = paramString;
    this.fieldTypes = paramArrayOfFieldType;
  }
  
  public DatabaseTableConfig(Class<T> paramClass, List<DatabaseFieldConfig> paramList)
  {
    this(paramClass, extractTableName(paramClass), paramList);
  }
  
  private FieldType[] convertFieldConfigs(ConnectionSource paramConnectionSource, String paramString, List<DatabaseFieldConfig> paramList)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DatabaseFieldConfig localDatabaseFieldConfig = (DatabaseFieldConfig)localIterator.next();
      Object localObject2 = null;
      paramList = this.dataClass;
      for (;;)
      {
        Object localObject1 = localObject2;
        if (paramList != null) {}
        try
        {
          localObject1 = paramList.getDeclaredField(localDatabaseFieldConfig.getFieldName());
          if (localObject1 != null)
          {
            localObject1 = new FieldType(paramConnectionSource, paramString, (Field)localObject1, localDatabaseFieldConfig, this.dataClass);
            if (localObject1 != null) {
              break;
            }
            throw new SQLException("Could not find declared field with name '" + localDatabaseFieldConfig.getFieldName() + "' for " + this.dataClass);
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          paramList = paramList.getSuperclass();
        }
      }
      localArrayList.add(localNoSuchFieldException);
    }
    if (localArrayList.isEmpty()) {
      throw new SQLException("No fields were configured for class " + this.dataClass);
    }
    return (FieldType[])localArrayList.toArray(new FieldType[localArrayList.size()]);
  }
  
  private static <T> FieldType[] extractFieldTypes(ConnectionSource paramConnectionSource, Class<T> paramClass, String paramString)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject = paramClass; localObject != null; localObject = ((Class)localObject).getSuperclass())
    {
      Field[] arrayOfField = ((Class)localObject).getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        FieldType localFieldType = FieldType.createFieldType(paramConnectionSource, paramString, arrayOfField[i], paramClass);
        if (localFieldType != null) {
          localArrayList.add(localFieldType);
        }
        i += 1;
      }
    }
    if (localArrayList.isEmpty()) {
      throw new IllegalArgumentException("No fields have a " + DatabaseField.class.getSimpleName() + " annotation in " + paramClass);
    }
    return (FieldType[])localArrayList.toArray(new FieldType[localArrayList.size()]);
  }
  
  public static <T> String extractTableName(Class<T> paramClass)
  {
    Object localObject = (DatabaseTable)paramClass.getAnnotation(DatabaseTable.class);
    if ((localObject != null) && (((DatabaseTable)localObject).tableName() != null) && (((DatabaseTable)localObject).tableName().length() > 0)) {
      localObject = ((DatabaseTable)localObject).tableName();
    }
    String str;
    do
    {
      return (String)localObject;
      str = JavaxPersistence.getEntityName(paramClass);
      localObject = str;
    } while (str != null);
    return paramClass.getSimpleName().toLowerCase();
  }
  
  /* Error */
  public static <T> Constructor<T> findNoArgConstructor(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 185	java/lang/Class:getDeclaredConstructors	()[Ljava/lang/reflect/Constructor;
    //   4: checkcast 187	[Ljava/lang/reflect/Constructor;
    //   7: astore_3
    //   8: aload_3
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload_2
    //   15: if_icmpge +98 -> 113
    //   18: aload_3
    //   19: iload_1
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 193	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   28: arraylength
    //   29: ifne +77 -> 106
    //   32: aload 4
    //   34: invokevirtual 196	java/lang/reflect/Constructor:isAccessible	()Z
    //   37: ifne +9 -> 46
    //   40: aload 4
    //   42: iconst_1
    //   43: invokevirtual 200	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   46: aload 4
    //   48: areturn
    //   49: astore_3
    //   50: new 142	java/lang/IllegalArgumentException
    //   53: dup
    //   54: new 88	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   61: ldc -54
    //   63: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: aload_3
    //   74: invokespecial 205	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: astore_3
    //   79: new 142	java/lang/IllegalArgumentException
    //   82: dup
    //   83: new 88	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   90: ldc -49
    //   92: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 152	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   105: athrow
    //   106: iload_1
    //   107: iconst_1
    //   108: iadd
    //   109: istore_1
    //   110: goto -97 -> 13
    //   113: aload_0
    //   114: invokevirtual 210	java/lang/Class:getEnclosingClass	()Ljava/lang/Class;
    //   117: ifnonnull +30 -> 147
    //   120: new 142	java/lang/IllegalArgumentException
    //   123: dup
    //   124: new 88	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   131: ldc -44
    //   133: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 152	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: new 142	java/lang/IllegalArgumentException
    //   150: dup
    //   151: new 88	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   158: ldc -44
    //   160: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: ldc -42
    //   169: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 152	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramClass	Class<T>
    //   12	98	1	i	int
    //   10	6	2	j	int
    //   7	12	3	arrayOfConstructor	Constructor[]
    //   49	25	3	localException	Exception
    //   78	1	3	localSecurityException	SecurityException
    //   21	26	4	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   0	8	49	java/lang/Exception
    //   40	46	78	java/lang/SecurityException
  }
  
  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    String str2 = extractTableName(paramClass);
    String str1 = str2;
    if (paramConnectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
      str1 = str2.toUpperCase();
    }
    return new DatabaseTableConfig(paramClass, str1, extractFieldTypes(paramConnectionSource, paramClass, str1));
  }
  
  public void extractFieldTypes(ConnectionSource paramConnectionSource)
    throws SQLException
  {
    if (this.fieldTypes == null)
    {
      if (this.fieldConfigs == null) {
        this.fieldTypes = extractFieldTypes(paramConnectionSource, this.dataClass, this.tableName);
      }
    }
    else {
      return;
    }
    this.fieldTypes = convertFieldConfigs(paramConnectionSource, this.tableName, this.fieldConfigs);
  }
  
  public Constructor<T> getConstructor()
  {
    if (this.constructor == null) {
      this.constructor = findNoArgConstructor(this.dataClass);
    }
    return this.constructor;
  }
  
  public Class<T> getDataClass()
  {
    return this.dataClass;
  }
  
  public List<DatabaseFieldConfig> getFieldConfigs()
  {
    return this.fieldConfigs;
  }
  
  public FieldType[] getFieldTypes(DatabaseType paramDatabaseType)
    throws SQLException
  {
    if (this.fieldTypes == null) {
      throw new SQLException("Field types have not been extracted in table config");
    }
    return this.fieldTypes;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public void initialize()
  {
    if (this.dataClass == null) {
      throw new IllegalStateException("dataClass was never set on " + getClass().getSimpleName());
    }
    if (this.tableName == null) {
      this.tableName = extractTableName(this.dataClass);
    }
  }
  
  public void setConstructor(Constructor<T> paramConstructor)
  {
    this.constructor = paramConstructor;
  }
  
  public void setDataClass(Class<T> paramClass)
  {
    this.dataClass = paramClass;
  }
  
  public void setFieldConfigs(List<DatabaseFieldConfig> paramList)
  {
    this.fieldConfigs = paramList;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/table/DatabaseTableConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */