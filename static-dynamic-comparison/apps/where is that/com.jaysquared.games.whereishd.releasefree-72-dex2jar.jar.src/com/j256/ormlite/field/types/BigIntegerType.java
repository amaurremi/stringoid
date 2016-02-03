package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigInteger;
import java.sql.SQLException;

public class BigIntegerType
  extends BaseDataType
{
  public static int DEFAULT_WIDTH = 255;
  private static final BigIntegerType singleTon = new BigIntegerType();
  
  protected BigIntegerType()
  {
    super(SqlType.STRING, new Class[] { BigInteger.class });
  }
  
  protected BigIntegerType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static BigIntegerType getSingleton()
  {
    return singleTon;
  }
  
  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }
  
  public boolean isAppropriateId()
  {
    return false;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return ((BigInteger)paramObject).toString();
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    try
    {
      BigInteger localBigInteger = new BigInteger(paramString);
      return localBigInteger;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw SqlExceptionUtil.create("Problems with field " + paramFieldType + " parsing default BigInteger string '" + paramString + "'", localIllegalArgumentException);
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
    try
    {
      paramFieldType = new BigInteger((String)paramObject);
      return paramFieldType;
    }
    catch (IllegalArgumentException paramFieldType)
    {
      throw SqlExceptionUtil.create("Problems with column " + paramInt + " parsing BigInteger string '" + paramObject + "'", paramFieldType);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/BigIntegerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */