package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class LongType
  extends LongObjectType
{
  private static final LongType singleTon = new LongType();
  
  private LongType()
  {
    super(SqlType.LONG, new Class[] { Long.TYPE });
  }
  
  protected LongType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static LongType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isPrimitive()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/LongType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */