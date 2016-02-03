package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class ByteType
  extends ByteObjectType
{
  private static final ByteType singleTon = new ByteType();
  
  private ByteType()
  {
    super(SqlType.BYTE, new Class[] { Byte.TYPE });
  }
  
  protected ByteType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ByteType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isPrimitive()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/ByteType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */