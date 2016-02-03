package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class SerializableType
  extends BaseDataType
{
  private static final SerializableType singleTon = new SerializableType();
  
  private SerializableType()
  {
    super(SqlType.SERIALIZABLE, new Class[0]);
  }
  
  protected SerializableType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static SerializableType getSingleton()
  {
    return singleTon;
  }
  
  public Class<?> getPrimaryClass()
  {
    return Serializable.class;
  }
  
  public boolean isAppropriateId()
  {
    return false;
  }
  
  public boolean isArgumentHolderRequired()
  {
    return true;
  }
  
  public boolean isComparable()
  {
    return false;
  }
  
  public boolean isStreamType()
  {
    return true;
  }
  
  public boolean isValidForField(Field paramField)
  {
    return Serializable.class.isAssignableFrom(paramField.getType());
  }
  
  /* Error */
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_1
    //   4: new 60	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 61	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore 4
    //   13: aload_3
    //   14: astore_1
    //   15: new 63	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 66	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_3
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual 70	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_3
    //   31: invokevirtual 73	java/io/ObjectOutputStream:close	()V
    //   34: aconst_null
    //   35: astore_1
    //   36: aload 4
    //   38: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: astore_3
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 79	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 80	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: aload_3
    //   55: areturn
    //   56: aconst_null
    //   57: astore_1
    //   58: astore_3
    //   59: new 82	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   66: ldc 85
    //   68: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: aload_3
    //   79: invokestatic 102	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   82: athrow
    //   83: astore_2
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 73	java/io/ObjectOutputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: aload_3
    //   96: areturn
    //   97: astore_1
    //   98: goto -6 -> 92
    //   101: astore_2
    //   102: aload_3
    //   103: astore_1
    //   104: goto -20 -> 84
    //   107: astore 4
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: astore_3
    //   114: goto -55 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	SerializableType
    //   0	117	1	paramFieldType	FieldType
    //   0	117	2	paramObject	Object
    //   1	54	3	localObject1	Object
    //   58	52	3	localException1	Exception
    //   113	1	3	localObject2	Object
    //   11	26	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   107	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   4	13	56	java/lang/Exception
    //   15	25	56	java/lang/Exception
    //   36	42	56	java/lang/Exception
    //   4	13	83	finally
    //   15	25	83	finally
    //   36	42	83	finally
    //   59	83	83	finally
    //   46	54	94	java/io/IOException
    //   88	92	97	java/io/IOException
    //   25	34	101	finally
    //   25	34	107	java/lang/Exception
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    throw new SQLException("Default values for serializable types are not supported");
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
    throws SQLException
  {
    throw new SQLException("Serializable type cannot be converted from string to Java");
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getBytes(paramInt);
  }
  
  /* Error */
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 126	[B
    //   4: checkcast 126	[B
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore 4
    //   14: new 128	java/io/ObjectInputStream
    //   17: dup
    //   18: new 130	java/io/ByteArrayInputStream
    //   21: dup
    //   22: aload 5
    //   24: invokespecial 133	java/io/ByteArrayInputStream:<init>	([B)V
    //   27: invokespecial 136	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 140	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 141	java/io/ObjectInputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_2
    //   47: aload 4
    //   49: astore_1
    //   50: new 82	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   57: ldc -113
    //   59: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 5
    //   64: invokestatic 148	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   67: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc -106
    //   72: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 5
    //   77: arraylength
    //   78: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: ldc -101
    //   83: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aload_2
    //   90: invokestatic 102	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   93: athrow
    //   94: astore_2
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 141	java/io/ObjectInputStream:close	()V
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: goto -6 -> 103
    //   112: astore 4
    //   114: aload_2
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: goto -24 -> 95
    //   122: astore 4
    //   124: aload_2
    //   125: astore_1
    //   126: aload 4
    //   128: astore_2
    //   129: goto -79 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SerializableType
    //   0	132	1	paramFieldType	FieldType
    //   0	132	2	paramObject	Object
    //   0	132	3	paramInt	int
    //   12	36	4	localObject1	Object
    //   112	5	4	localObject2	Object
    //   122	5	4	localException	Exception
    //   7	69	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	31	46	java/lang/Exception
    //   14	31	94	finally
    //   50	94	94	finally
    //   40	44	105	java/io/IOException
    //   99	103	108	java/io/IOException
    //   31	36	112	finally
    //   31	36	122	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/SerializableType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */