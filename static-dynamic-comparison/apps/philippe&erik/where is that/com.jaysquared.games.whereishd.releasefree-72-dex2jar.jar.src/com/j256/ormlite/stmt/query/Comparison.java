package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

abstract interface Comparison
  extends Clause
{
  public abstract void appendOperation(StringBuilder paramStringBuilder);
  
  public abstract void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException;
  
  public abstract String getColumnName();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/Comparison.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */