package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class LongStringType
  extends StringType
{
  private static final LongStringType singleTon = new LongStringType();
  
  private LongStringType()
  {
    super(SqlType.LONG_STRING, new Class[0]);
  }
  
  protected LongStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static LongStringType getSingleton()
  {
    return singleTon;
  }
  
  public int getDefaultWidth()
  {
    return 0;
  }
  
  public Class<?> getPrimaryClass()
  {
    return String.class;
  }
  
  public boolean isAppropriateId()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/LongStringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */