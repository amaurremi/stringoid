package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.util.List;

public class Raw
  implements Clause
{
  private final ArgumentHolder[] args;
  private final String statement;
  
  public Raw(String paramString, ArgumentHolder[] paramArrayOfArgumentHolder)
  {
    this.statement = paramString;
    this.args = paramArrayOfArgumentHolder;
  }
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    paramStringBuilder.append(this.statement);
    paramStringBuilder.append(' ');
    paramDatabaseType = this.args;
    int j = paramDatabaseType.length;
    int i = 0;
    while (i < j)
    {
      paramList.add(paramDatabaseType[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/Raw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */