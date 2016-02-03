package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class IntegerObjectType
  extends BaseDataType
{
  private static final IntegerObjectType singleTon = new IntegerObjectType();
  
  private IntegerObjectType()
  {
    super(SqlType.INTEGER, new Class[] { Integer.class });
  }
  
  protected IntegerObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static IntegerObjectType getSingleton()
  {
    return singleTon;
  }
  
  public Object convertIdNumber(Number paramNumber)
  {
    return Integer.valueOf(paramNumber.intValue());
  }
  
  public boolean isEscapedValue()
  {
    return false;
  }
  
  public boolean isValidForVersion()
  {
    return true;
  }
  
  public boolean isValidGeneratedType()
  {
    return true;
  }
  
  public Object moveToNextValue(Object paramObject)
  {
    if (paramObject == null) {
      return Integer.valueOf(1);
    }
    return Integer.valueOf(((Integer)paramObject).intValue() + 1);
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Integer.valueOf(Integer.parseInt(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Integer.valueOf(paramDatabaseResults.getInt(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/IntegerObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */