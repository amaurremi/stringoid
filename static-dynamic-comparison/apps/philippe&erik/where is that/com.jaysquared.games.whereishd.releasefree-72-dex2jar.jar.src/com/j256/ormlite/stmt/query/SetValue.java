package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;

public class SetValue
  extends BaseComparison
{
  private static final ArgumentHolder nullValue = new NullArgHolder();
  
  public SetValue(String paramString, FieldType paramFieldType, Object paramObject)
    throws SQLException
  {
    super(paramString, paramFieldType, localObject, false);
  }
  
  public void appendOperation(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("= ");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/SetValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */