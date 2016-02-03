package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class RawRowMapperImpl<T, ID>
  implements RawRowMapper<T>
{
  private final TableInfo<T, ID> tableInfo;
  
  public RawRowMapperImpl(TableInfo<T, ID> paramTableInfo)
  {
    this.tableInfo = paramTableInfo;
  }
  
  public T mapRow(String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SQLException
  {
    Object localObject = this.tableInfo.createObject();
    int i = 0;
    if (i < paramArrayOfString1.length)
    {
      if (i >= paramArrayOfString2.length) {}
      for (;;)
      {
        i += 1;
        break;
        FieldType localFieldType = this.tableInfo.getFieldTypeByColumnName(paramArrayOfString1[i]);
        localFieldType.assignField(localObject, localFieldType.convertStringToJavaField(paramArrayOfString2[i], i), false, null);
      }
    }
    return (T)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/RawRowMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */