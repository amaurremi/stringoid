package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

public class DeleteBuilder<T, ID>
  extends StatementBuilder<T, ID>
{
  public DeleteBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, StatementBuilder.StatementType.DELETE);
  }
  
  protected void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {}
  
  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    paramStringBuilder.append("DELETE FROM ");
    this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableInfo.getTableName());
    paramStringBuilder.append(' ');
  }
  
  @Deprecated
  public void clear()
  {
    reset();
  }
  
  public int delete()
    throws SQLException
  {
    return this.dao.delete(prepare());
  }
  
  public PreparedDelete<T> prepare()
    throws SQLException
  {
    return super.prepareStatement(null);
  }
  
  public void reset()
  {
    super.reset();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/DeleteBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */