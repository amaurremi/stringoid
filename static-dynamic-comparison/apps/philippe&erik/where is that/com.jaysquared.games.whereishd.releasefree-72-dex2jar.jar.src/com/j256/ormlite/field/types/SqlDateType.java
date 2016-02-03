package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;

public class SqlDateType
  extends DateType
{
  private static final SqlDateType singleTon = new SqlDateType();
  private static final BaseDateType.DateStringFormatConfig sqlDateFormatConfig = new BaseDateType.DateStringFormatConfig("yyyy-MM-dd");
  
  private SqlDateType()
  {
    super(SqlType.DATE, new Class[] { Date.class });
  }
  
  protected SqlDateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static SqlDateType getSingleton()
  {
    return singleTon;
  }
  
  protected BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig()
  {
    return sqlDateFormatConfig;
  }
  
  public boolean isValidForField(Field paramField)
  {
    return paramField.getType() == Date.class;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return new Timestamp(((Date)paramObject).getTime());
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
  {
    return sqlArgToJava(paramFieldType, Timestamp.valueOf(paramString), paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
  {
    return new Date(((Timestamp)paramObject).getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/SqlDateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */