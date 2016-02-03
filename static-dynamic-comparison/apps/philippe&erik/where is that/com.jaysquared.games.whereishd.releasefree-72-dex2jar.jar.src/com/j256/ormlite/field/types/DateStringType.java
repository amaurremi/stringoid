package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateStringType
  extends BaseDateType
{
  public static int DEFAULT_WIDTH = 50;
  private static final DateStringType singleTon = new DateStringType();
  
  private DateStringType()
  {
    super(SqlType.STRING, new Class[0]);
  }
  
  protected DateStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DateStringType getSingleton()
  {
    return singleTon;
  }
  
  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }
  
  public Class<?> getPrimaryClass()
  {
    return byte[].class;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return convertDateStringConfig(paramFieldType, defaultDateFormatConfig).getDateFormat().format((Date)paramObject);
  }
  
  public Object makeConfigObject(FieldType paramFieldType)
  {
    paramFieldType = paramFieldType.getFormat();
    if (paramFieldType == null) {
      return defaultDateFormatConfig;
    }
    return new BaseDateType.DateStringFormatConfig(paramFieldType);
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    BaseDateType.DateStringFormatConfig localDateStringFormatConfig = convertDateStringConfig(paramFieldType, defaultDateFormatConfig);
    try
    {
      String str = normalizeDateString(localDateStringFormatConfig, paramString);
      return str;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems with field " + paramFieldType + " parsing default date-string '" + paramString + "' using '" + localDateStringFormatConfig + "'", localParseException);
    }
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
    throws SQLException
  {
    return sqlArgToJava(paramFieldType, paramString, paramInt);
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    paramObject = (String)paramObject;
    paramFieldType = convertDateStringConfig(paramFieldType, defaultDateFormatConfig);
    try
    {
      Date localDate = parseDateString(paramFieldType, (String)paramObject);
      return localDate;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems with column " + paramInt + " parsing date-string '" + (String)paramObject + "' using '" + paramFieldType + "'", localParseException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/DateStringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */