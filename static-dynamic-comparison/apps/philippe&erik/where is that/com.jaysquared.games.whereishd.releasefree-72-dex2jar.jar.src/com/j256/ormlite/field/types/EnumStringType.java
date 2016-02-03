package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumStringType
  extends BaseEnumType
{
  public static int DEFAULT_WIDTH = 100;
  private static final EnumStringType singleTon = new EnumStringType();
  
  private EnumStringType()
  {
    super(SqlType.STRING, new Class[] { Enum.class });
  }
  
  protected EnumStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static EnumStringType getSingleton()
  {
    return singleTon;
  }
  
  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    return ((Enum)paramObject).name();
  }
  
  public Object makeConfigObject(FieldType paramFieldType)
    throws SQLException
  {
    HashMap localHashMap = new HashMap();
    Enum[] arrayOfEnum = (Enum[])paramFieldType.getType().getEnumConstants();
    if (arrayOfEnum == null) {
      throw new SQLException("Field " + paramFieldType + " improperly configured as type " + this);
    }
    int j = arrayOfEnum.length;
    int i = 0;
    while (i < j)
    {
      paramFieldType = arrayOfEnum[i];
      localHashMap.put(paramFieldType.name(), paramFieldType);
      i += 1;
    }
    return localHashMap;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return paramString;
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
    if (paramFieldType == null) {
      return paramObject;
    }
    paramObject = (String)paramObject;
    Map localMap = (Map)paramFieldType.getDataTypeConfigObj();
    if (localMap == null) {
      return enumVal(paramFieldType, paramObject, null, paramFieldType.getUnknownEnumVal());
    }
    return enumVal(paramFieldType, paramObject, (Enum)localMap.get(paramObject), paramFieldType.getUnknownEnumVal());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/EnumStringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */