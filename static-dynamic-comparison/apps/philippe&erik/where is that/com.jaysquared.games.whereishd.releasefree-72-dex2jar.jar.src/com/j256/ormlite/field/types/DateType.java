package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class DateType
  extends BaseDateType
{
  private static final DateType singleTon = new DateType();
  
  private DateType()
  {
    super(SqlType.DATE, new Class[] { Date.class });
  }
  
  protected DateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DateType getSingleton()
  {
    return singleTon;
  }
  
  protected BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig()
  {
    return defaultDateFormatConfig;
  }
  
  public boolean isArgumentHolderRequired()
  {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return new Timestamp(((Date)paramObject).getTime());
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    paramFieldType = convertDateStringConfig(paramFieldType, getDefaultDateFormatConfig());
    try
    {
      Timestamp localTimestamp = new Timestamp(parseDateString(paramFieldType, paramString).getTime());
      return localTimestamp;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems parsing default date string '" + paramString + "' using '" + paramFieldType + '\'', localParseException);
    }
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getTimestamp(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
  {
    return new Date(((Timestamp)paramObject).getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/DateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */