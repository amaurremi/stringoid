package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SetExpression;
import com.j256.ormlite.stmt.query.SetValue;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateBuilder<T, ID>
  extends StatementBuilder<T, ID>
{
  private List<Clause> updateClauseList = null;
  
  public UpdateBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, StatementBuilder.StatementType.UPDATE);
  }
  
  private void addUpdateColumnToList(String paramString, Clause paramClause)
  {
    if (this.updateClauseList == null) {
      this.updateClauseList = new ArrayList();
    }
    this.updateClauseList.add(paramClause);
  }
  
  protected void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {}
  
  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if ((this.updateClauseList == null) || (this.updateClauseList.isEmpty())) {
      throw new IllegalArgumentException("UPDATE statements must have at least one SET column");
    }
    paramStringBuilder.append("UPDATE ");
    this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableInfo.getTableName());
    paramStringBuilder.append(" SET ");
    int i = 1;
    Iterator localIterator = this.updateClauseList.iterator();
    if (localIterator.hasNext())
    {
      Clause localClause = (Clause)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localClause.appendSql(this.databaseType, null, paramStringBuilder, paramList);
        break;
        paramStringBuilder.append(',');
      }
    }
  }
  
  @Deprecated
  public void clear()
  {
    reset();
  }
  
  public String escapeColumnName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 4);
    this.databaseType.appendEscapedEntityName(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public void escapeColumnName(StringBuilder paramStringBuilder, String paramString)
  {
    this.databaseType.appendEscapedEntityName(paramStringBuilder, paramString);
  }
  
  public String escapeValue(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 4);
    this.databaseType.appendEscapedWord(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public void escapeValue(StringBuilder paramStringBuilder, String paramString)
  {
    this.databaseType.appendEscapedWord(paramStringBuilder, paramString);
  }
  
  public PreparedUpdate<T> prepare()
    throws SQLException
  {
    return super.prepareStatement(null);
  }
  
  public void reset()
  {
    super.reset();
    this.updateClauseList = null;
  }
  
  public int update()
    throws SQLException
  {
    return this.dao.update(prepare());
  }
  
  public StatementBuilder<T, ID> updateColumnExpression(String paramString1, String paramString2)
    throws SQLException
  {
    FieldType localFieldType = verifyColumnName(paramString1);
    if (localFieldType.isForeignCollection()) {
      throw new SQLException("Can't update foreign colletion field: " + paramString1);
    }
    addUpdateColumnToList(paramString1, new SetExpression(paramString1, localFieldType, paramString2));
    return this;
  }
  
  public StatementBuilder<T, ID> updateColumnValue(String paramString, Object paramObject)
    throws SQLException
  {
    FieldType localFieldType = verifyColumnName(paramString);
    if (localFieldType.isForeignCollection()) {
      throw new SQLException("Can't update foreign colletion field: " + paramString);
    }
    addUpdateColumnToList(paramString, new SetValue(paramString, localFieldType, paramObject));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/UpdateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */