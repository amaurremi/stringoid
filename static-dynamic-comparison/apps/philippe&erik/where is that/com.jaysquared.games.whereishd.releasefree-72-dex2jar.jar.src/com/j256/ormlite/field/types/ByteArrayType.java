package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Arrays;

public class ByteArrayType
  extends BaseDataType
{
  private static final ByteArrayType singleTon = new ByteArrayType();
  
  private ByteArrayType()
  {
    super(SqlType.BYTE_ARRAY, new Class[0]);
  }
  
  protected ByteArrayType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ByteArrayType getSingleton()
  {
    return singleTon;
  }
  
  public boolean dataIsEqual(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if (paramObject1 == null) {
      if (paramObject2 == null) {
        bool = true;
      }
    }
    while (paramObject2 == null) {
      return bool;
    }
    return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
  }
  
  public Class<?> getPrimaryClass()
  {
    return byte[].class;
  }
  
  public boolean isAppropriateId()
  {
    return false;
  }
  
  public boolean isArgumentHolderRequired()
  {
    return true;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    throw new SQLException("byte[] type cannot have default values");
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
    throws SQLException
  {
    throw new SQLException("byte[] type cannot be converted from string to Java");
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return (byte[])paramDatabaseResults.getBytes(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/ByteArrayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */