package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class CharacterObjectType
  extends BaseDataType
{
  private static final CharacterObjectType singleTon = new CharacterObjectType();
  
  private CharacterObjectType()
  {
    super(SqlType.CHAR, new Class[] { Character.class });
  }
  
  protected CharacterObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static CharacterObjectType getSingleton()
  {
    return singleTon;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    if (paramString.length() != 1) {
      throw new SQLException("Problems with field " + paramFieldType + ", default string to long for Character: '" + paramString + "'");
    }
    return Character.valueOf(paramString.charAt(0));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Character.valueOf(paramDatabaseResults.getChar(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/types/CharacterObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */