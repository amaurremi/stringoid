package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class BooleanType
  extends BooleanObjectType
{
  private static final BooleanType singleTon = new BooleanType();
  
  private BooleanType()
  {
    super(SqlType.BOOLEAN, new Class[] { Boolean.TYPE });
  }
  
  protected BooleanType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static BooleanType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isPrimitive()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/BooleanType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */