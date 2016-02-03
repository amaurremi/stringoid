package com.j256.ormlite.stmt;

import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

public abstract interface PreparedStmt<T>
  extends GenericRowMapper<T>
{
  public abstract CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType)
    throws SQLException;
  
  public abstract CompiledStatement compile(DatabaseConnection paramDatabaseConnection, StatementBuilder.StatementType paramStatementType, int paramInt)
    throws SQLException;
  
  public abstract String getStatement()
    throws SQLException;
  
  public abstract StatementBuilder.StatementType getType();
  
  public abstract void setArgumentHolderValue(int paramInt, Object paramObject)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/PreparedStmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */