package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

public class CharType
  extends CharacterObjectType
{
  private static final CharType singleTon = new CharType();
  
  private CharType()
  {
    super(SqlType.CHAR, new Class[] { Character.TYPE });
  }
  
  protected CharType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static CharType getSingleton()
  {
    return singleTon;
  }
  
  public boolean isPrimitive()
  {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    paramObject = (Character)paramObject;
    if (paramObject != null)
    {
      paramFieldType = (FieldType)paramObject;
      if (((Character)paramObject).charValue() != 0) {}
    }
    else
    {
      paramFieldType = null;
    }
    return paramFieldType;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/CharType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */