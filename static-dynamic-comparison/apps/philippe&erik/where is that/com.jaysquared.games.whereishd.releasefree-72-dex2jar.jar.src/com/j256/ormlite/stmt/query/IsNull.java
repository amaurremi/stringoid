package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class IsNull
  extends BaseComparison
{
  public IsNull(String paramString, FieldType paramFieldType)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
  }
  
  public void appendOperation(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("IS NULL ");
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/IsNull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */