package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder.InternalQueryBuilderWrapper;
import java.sql.SQLException;
import java.util.List;

public class InSubQuery
  extends BaseComparison
{
  private final boolean in;
  private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;
  
  public InSubQuery(String paramString, FieldType paramFieldType, QueryBuilder.InternalQueryBuilderWrapper paramInternalQueryBuilderWrapper, boolean paramBoolean)
    throws SQLException
  {
    super(paramString, paramFieldType, null, true);
    this.subQueryBuilder = paramInternalQueryBuilderWrapper;
    this.in = paramBoolean;
  }
  
  public void appendOperation(StringBuilder paramStringBuilder)
  {
    if (this.in)
    {
      paramStringBuilder.append("IN ");
      return;
    }
    paramStringBuilder.append("NOT IN ");
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    paramStringBuilder.append('(');
    this.subQueryBuilder.appendStatementString(paramStringBuilder, paramList);
    paramDatabaseType = this.subQueryBuilder.getResultFieldTypes();
    if (paramDatabaseType == null) {}
    do
    {
      paramStringBuilder.append(") ");
      return;
      if (paramDatabaseType.length != 1) {
        throw new SQLException("There must be only 1 result column in sub-query but we found " + paramDatabaseType.length);
      }
    } while (this.fieldType.getSqlType() == paramDatabaseType[0].getSqlType());
    throw new SQLException("Outer column " + this.fieldType + " is not the same type as inner column " + paramDatabaseType[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/InSubQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */