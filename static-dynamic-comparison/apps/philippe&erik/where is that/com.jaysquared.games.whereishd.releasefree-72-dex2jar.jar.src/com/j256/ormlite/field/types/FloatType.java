package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class FloatType
  extends FloatObjectType
{
  private static final FloatType singleTon = new FloatType();
  
  private FloatType()
  {
    super(SqlType.FLOAT, new Class[] { Float.TYPE });
  }
  
  protected FloatType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static FloatType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isPrimitive()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/FloatType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */