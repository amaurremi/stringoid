package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class StringType
  extends BaseDataType
{
  public static int DEFAULT_WIDTH = 255;
  private static final StringType singleTon = new StringType();
  
  private StringType()
  {
    super(SqlType.STRING, new Class[] { String.class });
  }
  
  protected StringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static StringType getSingleton()
  {
    return singleTon;
  }
  
  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return paramString;
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getString(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/StringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */