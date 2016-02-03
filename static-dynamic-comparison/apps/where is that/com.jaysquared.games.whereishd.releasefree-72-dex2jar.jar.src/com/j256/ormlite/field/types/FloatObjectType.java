package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class FloatObjectType
  extends BaseDataType
{
  private static final FloatObjectType singleTon = new FloatObjectType();
  
  private FloatObjectType()
  {
    super(SqlType.FLOAT, new Class[] { Float.class });
  }
  
  protected FloatObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static FloatObjectType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isEscapedValue()
  {
    return false;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Float.valueOf(Float.parseFloat(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Float.valueOf(paramDatabaseResults.getFloat(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/FloatObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */