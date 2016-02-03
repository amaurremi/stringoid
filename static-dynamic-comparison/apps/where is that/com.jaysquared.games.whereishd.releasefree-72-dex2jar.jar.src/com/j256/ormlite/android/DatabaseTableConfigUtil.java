package com.j256.ormlite.android;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfigUtil
{
  private static final int ALLOW_GENERATED_ID_INSERT = 24;
  private static final int CAN_BE_NULL = 5;
  private static final int COLUMN_DEFINITON = 25;
  private static final int COLUMN_NAME = 1;
  private static final int DATA_TYPE = 2;
  private static final int DEFAULT_VALUE = 3;
  private static final int FOREIGN = 9;
  private static final int FOREIGN_AUTO_CREATE = 26;
  private static final int FOREIGN_AUTO_REFRESH = 21;
  private static final int FOREIGN_COLUMN_NAME = 28;
  private static final int FORMAT = 14;
  private static final int GENERATED_ID = 7;
  private static final int GENERATED_ID_SEQUENCE = 8;
  private static final int ID = 6;
  private static final int INDEX = 17;
  private static final int INDEX_NAME = 19;
  private static final int MAX_FOREIGN_AUTO_REFRESH_LEVEL = 22;
  private static final int PERSISTED = 13;
  private static final int PERSISTER_CLASS = 23;
  private static final int READ_ONLY = 29;
  private static final int THROW_IF_NULL = 12;
  private static final int UNIQUE = 15;
  private static final int UNIQUE_COMBO = 16;
  private static final int UNIQUE_INDEX = 18;
  private static final int UNIQUE_INDEX_NAME = 20;
  private static final int UNKNOWN_ENUM_NAME = 11;
  private static final int USE_GET_SET = 10;
  private static final int VERSION = 27;
  private static final int WIDTH = 4;
  private static Class<?> annotationFactoryClazz;
  private static Class<?> annotationMemberClazz;
  private static final int[] configFieldNums = lookupClasses();
  private static Field elementsField;
  private static Field nameField;
  private static Field valueField;
  private static int workedC = 0;
  
  private static void assignConfigField(int paramInt, DatabaseFieldConfig paramDatabaseFieldConfig, Field paramField, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Could not find support for DatabaseField number " + paramInt);
    case 1: 
      paramDatabaseFieldConfig.setColumnName(valueIfNotBlank((String)paramObject));
    case 2: 
    case 3: 
      do
      {
        return;
        paramDatabaseFieldConfig.setDataType((DataType)paramObject);
        return;
        paramField = (String)paramObject;
      } while ((paramField == null) || (paramField.equals("__ormlite__ no default value string was specified")));
      paramDatabaseFieldConfig.setDefaultValue(paramField);
      return;
    case 4: 
      paramDatabaseFieldConfig.setWidth(((Integer)paramObject).intValue());
      return;
    case 5: 
      paramDatabaseFieldConfig.setCanBeNull(((Boolean)paramObject).booleanValue());
      return;
    case 6: 
      paramDatabaseFieldConfig.setId(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramDatabaseFieldConfig.setGeneratedId(((Boolean)paramObject).booleanValue());
      return;
    case 8: 
      paramDatabaseFieldConfig.setGeneratedIdSequence(valueIfNotBlank((String)paramObject));
      return;
    case 9: 
      paramDatabaseFieldConfig.setForeign(((Boolean)paramObject).booleanValue());
      return;
    case 10: 
      paramDatabaseFieldConfig.setUseGetSet(((Boolean)paramObject).booleanValue());
      return;
    case 11: 
      paramDatabaseFieldConfig.setUnknownEnumValue(DatabaseFieldConfig.findMatchingEnumVal(paramField, (String)paramObject));
      return;
    case 12: 
      paramDatabaseFieldConfig.setThrowIfNull(((Boolean)paramObject).booleanValue());
      return;
    case 13: 
      paramDatabaseFieldConfig.setPersisted(((Boolean)paramObject).booleanValue());
      return;
    case 14: 
      paramDatabaseFieldConfig.setFormat(valueIfNotBlank((String)paramObject));
      return;
    case 15: 
      paramDatabaseFieldConfig.setUnique(((Boolean)paramObject).booleanValue());
      return;
    case 16: 
      paramDatabaseFieldConfig.setUniqueCombo(((Boolean)paramObject).booleanValue());
      return;
    case 17: 
      paramDatabaseFieldConfig.setIndex(((Boolean)paramObject).booleanValue());
      return;
    case 18: 
      paramDatabaseFieldConfig.setUniqueIndex(((Boolean)paramObject).booleanValue());
      return;
    case 19: 
      paramDatabaseFieldConfig.setIndexName(valueIfNotBlank((String)paramObject));
      return;
    case 20: 
      paramDatabaseFieldConfig.setUniqueIndexName(valueIfNotBlank((String)paramObject));
      return;
    case 21: 
      paramDatabaseFieldConfig.setForeignAutoRefresh(((Boolean)paramObject).booleanValue());
      return;
    case 22: 
      paramDatabaseFieldConfig.setMaxForeignAutoRefreshLevel(((Integer)paramObject).intValue());
      return;
    case 23: 
      paramDatabaseFieldConfig.setPersisterClass((Class)paramObject);
      return;
    case 24: 
      paramDatabaseFieldConfig.setAllowGeneratedIdInsert(((Boolean)paramObject).booleanValue());
      return;
    case 25: 
      paramDatabaseFieldConfig.setColumnDefinition(valueIfNotBlank((String)paramObject));
      return;
    case 26: 
      paramDatabaseFieldConfig.setForeignAutoCreate(((Boolean)paramObject).booleanValue());
      return;
    case 27: 
      paramDatabaseFieldConfig.setVersion(((Boolean)paramObject).booleanValue());
      return;
    case 28: 
      paramDatabaseFieldConfig.setForeignColumnName(valueIfNotBlank((String)paramObject));
      return;
    }
    paramDatabaseFieldConfig.setReadOnly(((Boolean)paramObject).booleanValue());
  }
  
  private static DatabaseFieldConfig buildConfig(DatabaseField paramDatabaseField, String paramString, Field paramField)
    throws Exception
  {
    paramString = null;
    paramDatabaseField = Proxy.getInvocationHandler(paramDatabaseField);
    if (paramDatabaseField.getClass() != annotationFactoryClazz) {
      paramDatabaseField = paramString;
    }
    do
    {
      return paramDatabaseField;
      localObject = elementsField.get(paramDatabaseField);
      paramDatabaseField = paramString;
    } while (localObject == null);
    paramString = new DatabaseFieldConfig(paramField.getName());
    Object localObject = (Object[])localObject;
    int i = 0;
    for (;;)
    {
      paramDatabaseField = paramString;
      if (i >= configFieldNums.length) {
        break;
      }
      paramDatabaseField = valueField.get(localObject[i]);
      if (paramDatabaseField != null) {
        assignConfigField(configFieldNums[i], paramString, paramField, paramDatabaseField);
      }
      i += 1;
    }
  }
  
  private static int configFieldNameToNum(String paramString)
  {
    if (paramString.equals("columnName")) {
      return 1;
    }
    if (paramString.equals("dataType")) {
      return 2;
    }
    if (paramString.equals("defaultValue")) {
      return 3;
    }
    if (paramString.equals("width")) {
      return 4;
    }
    if (paramString.equals("canBeNull")) {
      return 5;
    }
    if (paramString.equals("id")) {
      return 6;
    }
    if (paramString.equals("generatedId")) {
      return 7;
    }
    if (paramString.equals("generatedIdSequence")) {
      return 8;
    }
    if (paramString.equals("foreign")) {
      return 9;
    }
    if (paramString.equals("useGetSet")) {
      return 10;
    }
    if (paramString.equals("unknownEnumName")) {
      return 11;
    }
    if (paramString.equals("throwIfNull")) {
      return 12;
    }
    if (paramString.equals("persisted")) {
      return 13;
    }
    if (paramString.equals("format")) {
      return 14;
    }
    if (paramString.equals("unique")) {
      return 15;
    }
    if (paramString.equals("uniqueCombo")) {
      return 16;
    }
    if (paramString.equals("index")) {
      return 17;
    }
    if (paramString.equals("uniqueIndex")) {
      return 18;
    }
    if (paramString.equals("indexName")) {
      return 19;
    }
    if (paramString.equals("uniqueIndexName")) {
      return 20;
    }
    if (paramString.equals("foreignAutoRefresh")) {
      return 21;
    }
    if (paramString.equals("maxForeignAutoRefreshLevel")) {
      return 22;
    }
    if (paramString.equals("persisterClass")) {
      return 23;
    }
    if (paramString.equals("allowGeneratedIdInsert")) {
      return 24;
    }
    if (paramString.equals("columnDefinition")) {
      return 25;
    }
    if (paramString.equals("foreignAutoCreate")) {
      return 26;
    }
    if (paramString.equals("version")) {
      return 27;
    }
    if (paramString.equals("foreignColumnName")) {
      return 28;
    }
    if (paramString.equals("readOnly")) {
      return 29;
    }
    throw new IllegalStateException("Could not find support for DatabaseField " + paramString);
  }
  
  private static DatabaseFieldConfig configFromField(DatabaseType paramDatabaseType, String paramString, Field paramField)
    throws SQLException
  {
    if (configFieldNums == null) {
      return DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField);
    }
    DatabaseField localDatabaseField = (DatabaseField)paramField.getAnnotation(DatabaseField.class);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localDatabaseField != null) {}
    try
    {
      localObject1 = buildConfig(localDatabaseField, paramString, paramField);
      if (localObject1 == null) {
        return DatabaseFieldConfig.fromField(paramDatabaseType, paramString, paramField);
      }
      workedC += 1;
      return (DatabaseFieldConfig)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    DatabaseType localDatabaseType = paramConnectionSource.getDatabaseType();
    String str = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList localArrayList = new ArrayList();
    for (paramConnectionSource = paramClass; paramConnectionSource != null; paramConnectionSource = paramConnectionSource.getSuperclass())
    {
      Field[] arrayOfField = paramConnectionSource.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        DatabaseFieldConfig localDatabaseFieldConfig = configFromField(localDatabaseType, str, arrayOfField[i]);
        if ((localDatabaseFieldConfig != null) && (localDatabaseFieldConfig.isPersisted())) {
          localArrayList.add(localDatabaseFieldConfig);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0) {
      return null;
    }
    return new DatabaseTableConfig(paramClass, str, localArrayList);
  }
  
  public static int getWorkedC()
  {
    return workedC;
  }
  
  /* Error */
  private static int[] lookupClasses()
  {
    // Byte code:
    //   0: ldc_w 405
    //   3: invokestatic 409	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   6: putstatic 256	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationFactoryClazz	Ljava/lang/Class;
    //   9: ldc_w 411
    //   12: invokestatic 409	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   15: putstatic 413	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationMemberClazz	Ljava/lang/Class;
    //   18: ldc_w 415
    //   21: invokestatic 409	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: astore_1
    //   25: getstatic 256	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationFactoryClazz	Ljava/lang/Class;
    //   28: ldc_w 417
    //   31: invokevirtual 421	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   34: putstatic 258	com/j256/ormlite/android/DatabaseTableConfigUtil:elementsField	Ljava/lang/reflect/Field;
    //   37: getstatic 258	com/j256/ormlite/android/DatabaseTableConfigUtil:elementsField	Ljava/lang/reflect/Field;
    //   40: iconst_1
    //   41: invokevirtual 424	java/lang/reflect/Field:setAccessible	(Z)V
    //   44: getstatic 413	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationMemberClazz	Ljava/lang/Class;
    //   47: ldc_w 426
    //   50: invokevirtual 421	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   53: putstatic 428	com/j256/ormlite/android/DatabaseTableConfigUtil:nameField	Ljava/lang/reflect/Field;
    //   56: getstatic 428	com/j256/ormlite/android/DatabaseTableConfigUtil:nameField	Ljava/lang/reflect/Field;
    //   59: iconst_1
    //   60: invokevirtual 424	java/lang/reflect/Field:setAccessible	(Z)V
    //   63: getstatic 413	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationMemberClazz	Ljava/lang/Class;
    //   66: ldc_w 430
    //   69: invokevirtual 421	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   72: putstatic 272	com/j256/ormlite/android/DatabaseTableConfigUtil:valueField	Ljava/lang/reflect/Field;
    //   75: getstatic 272	com/j256/ormlite/android/DatabaseTableConfigUtil:valueField	Ljava/lang/reflect/Field;
    //   78: iconst_1
    //   79: invokevirtual 424	java/lang/reflect/Field:setAccessible	(Z)V
    //   82: ldc 6
    //   84: ldc_w 432
    //   87: invokevirtual 421	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   90: astore_2
    //   91: aload_2
    //   92: ldc_w 346
    //   95: invokevirtual 350	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   98: checkcast 346	com/j256/ormlite/field/DatabaseField
    //   101: invokestatic 250	java/lang/reflect/Proxy:getInvocationHandler	(Ljava/lang/Object;)Ljava/lang/reflect/InvocationHandler;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 254	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: getstatic 256	com/j256/ormlite/android/DatabaseTableConfigUtil:annotationFactoryClazz	Ljava/lang/Class;
    //   112: if_acmpeq +16 -> 128
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aconst_null
    //   127: areturn
    //   128: getstatic 258	com/j256/ormlite/android/DatabaseTableConfigUtil:elementsField	Ljava/lang/reflect/Field;
    //   131: aload_2
    //   132: invokevirtual 264	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +65 -> 202
    //   140: aload_2
    //   141: invokevirtual 254	java/lang/Object:getClass	()Ljava/lang/Class;
    //   144: aload_1
    //   145: if_acmpeq +6 -> 151
    //   148: goto +54 -> 202
    //   151: aload_2
    //   152: checkcast 270	[Ljava/lang/Object;
    //   155: checkcast 270	[Ljava/lang/Object;
    //   158: astore_3
    //   159: aload_3
    //   160: arraylength
    //   161: newarray <illegal type>
    //   163: astore_2
    //   164: iconst_0
    //   165: istore_0
    //   166: aload_2
    //   167: astore_1
    //   168: iload_0
    //   169: aload_3
    //   170: arraylength
    //   171: if_icmpge -54 -> 117
    //   174: aload_2
    //   175: iload_0
    //   176: getstatic 428	com/j256/ormlite/android/DatabaseTableConfigUtil:nameField	Ljava/lang/reflect/Field;
    //   179: aload_3
    //   180: iload_0
    //   181: aaload
    //   182: invokevirtual 264	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast 116	java/lang/String
    //   188: invokestatic 434	com/j256/ormlite/android/DatabaseTableConfigUtil:configFieldNameToNum	(Ljava/lang/String;)I
    //   191: iastore
    //   192: iload_0
    //   193: iconst_1
    //   194: iadd
    //   195: istore_0
    //   196: goto -30 -> 166
    //   199: astore_1
    //   200: aconst_null
    //   201: areturn
    //   202: aconst_null
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   165	31	0	i	int
    //   24	94	1	localClass	Class
    //   119	1	1	localClassNotFoundException	ClassNotFoundException
    //   122	1	1	localSecurityException	SecurityException
    //   125	20	1	localNoSuchFieldException	NoSuchFieldException
    //   167	1	1	localObject1	Object
    //   199	1	1	localIllegalAccessException	IllegalAccessException
    //   90	85	2	localObject2	Object
    //   158	22	3	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   0	25	119	java/lang/ClassNotFoundException
    //   25	91	122	java/lang/SecurityException
    //   25	91	125	java/lang/NoSuchFieldException
    //   128	136	199	java/lang/IllegalAccessException
    //   140	148	199	java/lang/IllegalAccessException
    //   151	164	199	java/lang/IllegalAccessException
    //   168	192	199	java/lang/IllegalAccessException
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
  
  private static class DatabaseFieldSample
  {
    @DatabaseField
    String field;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/DatabaseTableConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */