package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

public class TimeStampType
  extends DateType
{
  private static final TimeStampType singleTon = new TimeStampType();
  
  private TimeStampType()
  {
    super(SqlType.DATE, new Class[] { Timestamp.class });
  }
  
  protected TimeStampType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static TimeStampType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isValidForField(Field paramField)
  {
    return paramField.getType() == Timestamp.class;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return paramObject;
  }
  
  public Object moveToNextValue(Object paramObject)
  {
    long l = System.currentTimeMillis();
    if (paramObject == null) {
      return new Timestamp(l);
    }
    if (l == ((Timestamp)paramObject).getTime()) {
      return new Timestamp(1L + l);
    }
    return new Timestamp(l);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
  {
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/TimeStampType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */