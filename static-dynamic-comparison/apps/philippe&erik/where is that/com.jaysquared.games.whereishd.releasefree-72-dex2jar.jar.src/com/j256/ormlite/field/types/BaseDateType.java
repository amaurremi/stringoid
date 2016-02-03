package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDateType
  extends BaseDataType
{
  protected static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");
  
  protected BaseDateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  protected static DateStringFormatConfig convertDateStringConfig(FieldType paramFieldType, DateStringFormatConfig paramDateStringFormatConfig)
  {
    if (paramFieldType == null) {}
    do
    {
      return paramDateStringFormatConfig;
      paramFieldType = (DateStringFormatConfig)paramFieldType.getDataTypeConfigObj();
    } while (paramFieldType == null);
    return paramFieldType;
  }
  
  protected static String normalizeDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString)
    throws ParseException
  {
    paramDateStringFormatConfig = paramDateStringFormatConfig.getDateFormat();
    return paramDateStringFormatConfig.format(paramDateStringFormatConfig.parse(paramString));
  }
  
  protected static Date parseDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString)
    throws ParseException
  {
    return paramDateStringFormatConfig.getDateFormat().parse(paramString);
  }
  
  public boolean isValidForField(Field paramField)
  {
    return paramField.getType() == Date.class;
  }
  
  public boolean isValidForVersion()
  {
    return true;
  }
  
  public Object moveToNextValue(Object paramObject)
  {
    long l = System.currentTimeMillis();
    if (paramObject == null) {
      return new Date(l);
    }
    if (l == ((Date)paramObject).getTime()) {
      return new Date(1L + l);
    }
    return new Date(l);
  }
  
  protected static class DateStringFormatConfig
  {
    final String dateFormatStr;
    private final ThreadLocal<DateFormat> threadLocal = new ThreadLocal()
    {
      protected DateFormat initialValue()
      {
        return new SimpleDateFormat(BaseDateType.DateStringFormatConfig.this.dateFormatStr);
      }
    };
    
    public DateStringFormatConfig(String paramString)
    {
      this.dateFormatStr = paramString;
    }
    
    public DateFormat getDateFormat()
    {
      return (DateFormat)this.threadLocal.get();
    }
    
    public String toString()
    {
      return this.dateFormatStr;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/BaseDateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */