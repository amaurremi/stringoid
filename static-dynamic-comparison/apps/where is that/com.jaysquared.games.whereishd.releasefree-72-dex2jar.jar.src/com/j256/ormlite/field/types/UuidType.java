package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.UUID;

public class UuidType
  extends BaseDataType
{
  public static int DEFAULT_WIDTH = 48;
  private static final UuidType singleTon = new UuidType();
  
  private UuidType()
  {
    super(SqlType.STRING, new Class[] { UUID.class });
  }
  
  protected UuidType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static UuidType getSingleton()
  {
    return singleTon;
  }
  
  public Object generateId()
  {
    return UUID.randomUUID();
  }
  
  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }
  
  public boolean isSelfGeneratedId()
  {
    return true;
  }
  
  public boolean isValidGeneratedType()
  {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return ((UUID)paramObject).toString();
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    try
    {
      UUID localUUID = UUID.fromString(paramString);
      return localUUID;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw SqlExceptionUtil.create("Problems with field " + paramFieldType + " parsing default UUID-string '" + paramString + "'", localIllegalArgumentException);
    }
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    paramFieldType = (String)paramObject;
    try
    {
      paramObject = UUID.fromString(paramFieldType);
      return paramObject;
    }
    catch (IllegalArgumentException paramObject)
    {
      throw SqlExceptionUtil.create("Problems with column " + paramInt + " parsing UUID-string '" + paramFieldType + "'", (Throwable)paramObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/UuidType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */