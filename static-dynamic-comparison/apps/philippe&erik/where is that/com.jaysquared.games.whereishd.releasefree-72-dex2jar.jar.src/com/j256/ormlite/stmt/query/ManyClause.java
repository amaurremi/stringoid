package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class ManyClause
  implements Clause, NeedsFutureClause
{
  public static final String AND_OPERATION = "AND";
  public static final String OR_OPERATION = "OR";
  private final Clause first;
  private final String operation;
  private final Clause[] others;
  private Clause second;
  private final int startOthersAt;
  
  public ManyClause(Clause paramClause1, Clause paramClause2, Clause[] paramArrayOfClause, String paramString)
  {
    this.first = paramClause1;
    this.second = paramClause2;
    this.others = paramArrayOfClause;
    this.startOthersAt = 0;
    this.operation = paramString;
  }
  
  public ManyClause(Clause paramClause, String paramString)
  {
    this.first = paramClause;
    this.second = null;
    this.others = null;
    this.startOthersAt = 0;
    this.operation = paramString;
  }
  
  public ManyClause(Clause[] paramArrayOfClause, String paramString)
  {
    this.first = paramArrayOfClause[0];
    if (paramArrayOfClause.length < 2) {
      this.second = null;
    }
    for (this.startOthersAt = paramArrayOfClause.length;; this.startOthersAt = 2)
    {
      this.others = paramArrayOfClause;
      this.operation = paramString;
      return;
      this.second = paramArrayOfClause[1];
    }
  }
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    paramStringBuilder.append("(");
    this.first.appendSql(paramDatabaseType, paramString, paramStringBuilder, paramList);
    if (this.second != null)
    {
      paramStringBuilder.append(this.operation);
      paramStringBuilder.append(' ');
      this.second.appendSql(paramDatabaseType, paramString, paramStringBuilder, paramList);
    }
    if (this.others != null)
    {
      int i = this.startOthersAt;
      while (i < this.others.length)
      {
        paramStringBuilder.append(this.operation);
        paramStringBuilder.append(' ');
        this.others[i].appendSql(paramDatabaseType, paramString, paramStringBuilder, paramList);
        i += 1;
      }
    }
    paramStringBuilder.append(") ");
  }
  
  public void setMissingClause(Clause paramClause)
  {
    this.second = paramClause;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/ManyClause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */