package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Where<T, ID>
{
  private static final int START_CLAUSE_SIZE = 4;
  private Clause[] clauseStack = new Clause[4];
  private int clauseStackLevel = 0;
  private final DatabaseType databaseType;
  private final String idColumnName;
  private final FieldType idFieldType;
  private NeedsFutureClause needsFuture = null;
  private final StatementBuilder<T, ID> statementBuilder;
  private final TableInfo<T, ID> tableInfo;
  
  Where(TableInfo<T, ID> paramTableInfo, StatementBuilder<T, ID> paramStatementBuilder, DatabaseType paramDatabaseType)
  {
    this.tableInfo = paramTableInfo;
    this.statementBuilder = paramStatementBuilder;
    this.idFieldType = paramTableInfo.getIdField();
    if (this.idFieldType == null) {}
    for (this.idColumnName = null;; this.idColumnName = this.idFieldType.getColumnName())
    {
      this.databaseType = paramDatabaseType;
      return;
    }
  }
  
  private void addClause(Clause paramClause)
  {
    if (this.needsFuture == null)
    {
      push(paramClause);
      return;
    }
    this.needsFuture.setMissingClause(paramClause);
    this.needsFuture = null;
  }
  
  private void addNeedsFuture(NeedsFutureClause paramNeedsFutureClause)
  {
    if (this.needsFuture != null) {
      throw new IllegalStateException(this.needsFuture + " is already waiting for a future clause, can't add: " + paramNeedsFutureClause);
    }
    this.needsFuture = paramNeedsFutureClause;
    push(paramNeedsFutureClause);
  }
  
  private Clause[] buildClauseArray(Where<T, ID>[] paramArrayOfWhere, String paramString)
  {
    if (paramArrayOfWhere.length == 0)
    {
      paramArrayOfWhere = null;
      return paramArrayOfWhere;
    }
    Clause[] arrayOfClause = new Clause[paramArrayOfWhere.length];
    int i = paramArrayOfWhere.length - 1;
    for (;;)
    {
      paramArrayOfWhere = arrayOfClause;
      if (i < 0) {
        break;
      }
      arrayOfClause[i] = pop(paramString);
      i -= 1;
    }
  }
  
  private QueryBuilder<T, ID> checkQueryBuilderMethod(String paramString)
    throws SQLException
  {
    if ((this.statementBuilder instanceof QueryBuilder)) {
      return (QueryBuilder)this.statementBuilder;
    }
    throw new SQLException("Cannot call " + paramString + " on a statement of type " + this.statementBuilder.getType());
  }
  
  private FieldType findColumnFieldType(String paramString)
  {
    return this.tableInfo.getFieldTypeByColumnName(paramString);
  }
  
  private Where<T, ID> in(boolean paramBoolean, String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    if (paramQueryBuilder.getSelectColumnCount() != 1)
    {
      if (paramQueryBuilder.getSelectColumnCount() == 0) {
        throw new SQLException("Inner query must have only 1 select column specified instead of *");
      }
      throw new SQLException("Inner query must have only 1 select column specified instead of " + paramQueryBuilder.getSelectColumnCount() + ": " + Arrays.toString(paramQueryBuilder.getSelectColumns().toArray(new String[0])));
    }
    paramQueryBuilder.enableInnerQuery();
    addClause(new InSubQuery(paramString, findColumnFieldType(paramString), new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder), paramBoolean));
    return this;
  }
  
  private Where<T, ID> in(boolean paramBoolean, String paramString, Object... paramVarArgs)
    throws SQLException
  {
    if (paramVarArgs.length == 1)
    {
      if (paramVarArgs[0].getClass().isArray())
      {
        paramVarArgs = new StringBuilder().append("Object argument to ");
        if (paramBoolean) {}
        for (paramString = "IN";; paramString = "notId") {
          throw new IllegalArgumentException(paramString + " seems to be an array within an array");
        }
      }
      if ((paramVarArgs[0] instanceof Where))
      {
        paramVarArgs = new StringBuilder().append("Object argument to ");
        if (paramBoolean) {}
        for (paramString = "IN";; paramString = "notId") {
          throw new IllegalArgumentException(paramString + " seems to be a Where object, did you mean the QueryBuilder?");
        }
      }
      if ((paramVarArgs[0] instanceof PreparedStmt))
      {
        paramVarArgs = new StringBuilder().append("Object argument to ");
        if (paramBoolean) {}
        for (paramString = "IN";; paramString = "notId") {
          throw new IllegalArgumentException(paramString + " seems to be a prepared statement, did you mean the QueryBuilder?");
        }
      }
    }
    addClause(new In(paramString, findColumnFieldType(paramString), paramVarArgs, paramBoolean));
    return this;
  }
  
  private Clause peek()
  {
    return this.clauseStack[(this.clauseStackLevel - 1)];
  }
  
  private Clause pop(String paramString)
  {
    if (this.clauseStackLevel == 0) {
      throw new IllegalStateException("Expecting there to be a clause already defined for '" + paramString + "' operation");
    }
    paramString = this.clauseStack;
    int i = this.clauseStackLevel - 1;
    this.clauseStackLevel = i;
    paramString = paramString[i];
    this.clauseStack[this.clauseStackLevel] = null;
    return paramString;
  }
  
  private void push(Clause paramClause)
  {
    if (this.clauseStackLevel == this.clauseStack.length)
    {
      arrayOfClause = new Clause[this.clauseStackLevel * 2];
      i = 0;
      while (i < this.clauseStackLevel)
      {
        arrayOfClause[i] = this.clauseStack[i];
        this.clauseStack[i] = null;
        i += 1;
      }
      this.clauseStack = arrayOfClause;
    }
    Clause[] arrayOfClause = this.clauseStack;
    int i = this.clauseStackLevel;
    this.clauseStackLevel = (i + 1);
    arrayOfClause[i] = paramClause;
  }
  
  public Where<T, ID> and()
  {
    addNeedsFuture(new ManyClause(pop("AND"), "AND"));
    return this;
  }
  
  public Where<T, ID> and(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
    }
    Clause[] arrayOfClause = new Clause[paramInt];
    paramInt -= 1;
    while (paramInt >= 0)
    {
      arrayOfClause[paramInt] = pop("AND");
      paramInt -= 1;
    }
    addClause(new ManyClause(arrayOfClause, "AND"));
    return this;
  }
  
  public Where<T, ID> and(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>... paramVarArgs)
  {
    paramWhere1 = buildClauseArray(paramVarArgs, "AND");
    paramWhere2 = pop("AND");
    addClause(new ManyClause(pop("AND"), paramWhere2, paramWhere1, "AND"));
    return this;
  }
  
  void appendSql(String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if (this.clauseStackLevel == 0) {
      throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
    }
    if (this.clauseStackLevel != 1) {
      throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
    }
    peek().appendSql(this.databaseType, paramString, paramStringBuilder, paramList);
  }
  
  public Where<T, ID> between(String paramString, Object paramObject1, Object paramObject2)
    throws SQLException
  {
    addClause(new Between(paramString, findColumnFieldType(paramString), paramObject1, paramObject2));
    return this;
  }
  
  @Deprecated
  public Where<T, ID> clear()
  {
    return reset();
  }
  
  public long countOf()
    throws SQLException
  {
    return checkQueryBuilderMethod("countOf()").countOf();
  }
  
  public Where<T, ID> eq(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "="));
    return this;
  }
  
  public Where<T, ID> exists(QueryBuilder<?, ?> paramQueryBuilder)
  {
    paramQueryBuilder.enableInnerQuery();
    addClause(new Exists(new QueryBuilder.InternalQueryBuilderWrapper(paramQueryBuilder)));
    return this;
  }
  
  public Where<T, ID> ge(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, ">="));
    return this;
  }
  
  public String getStatement()
    throws SQLException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendSql(null, localStringBuilder, new ArrayList());
    return localStringBuilder.toString();
  }
  
  public Where<T, ID> gt(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, ">"));
    return this;
  }
  
  public <OD> Where<T, ID> idEq(Dao<OD, ?> paramDao, OD paramOD)
    throws SQLException
  {
    if (this.idColumnName == null) {
      throw new SQLException("Object has no id column specified");
    }
    addClause(new SimpleComparison(this.idColumnName, this.idFieldType, paramDao.extractId(paramOD), "="));
    return this;
  }
  
  public Where<T, ID> idEq(ID paramID)
    throws SQLException
  {
    if (this.idColumnName == null) {
      throw new SQLException("Object has no id column specified");
    }
    addClause(new SimpleComparison(this.idColumnName, this.idFieldType, paramID, "="));
    return this;
  }
  
  public Where<T, ID> in(String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    return in(true, paramString, paramQueryBuilder);
  }
  
  public Where<T, ID> in(String paramString, Iterable<?> paramIterable)
    throws SQLException
  {
    addClause(new In(paramString, findColumnFieldType(paramString), paramIterable, true));
    return this;
  }
  
  public Where<T, ID> in(String paramString, Object... paramVarArgs)
    throws SQLException
  {
    return in(true, paramString, paramVarArgs);
  }
  
  public Where<T, ID> isNotNull(String paramString)
    throws SQLException
  {
    addClause(new IsNotNull(paramString, findColumnFieldType(paramString)));
    return this;
  }
  
  public Where<T, ID> isNull(String paramString)
    throws SQLException
  {
    addClause(new IsNull(paramString, findColumnFieldType(paramString)));
    return this;
  }
  
  public CloseableIterator<T> iterator()
    throws SQLException
  {
    return checkQueryBuilderMethod("iterator()").iterator();
  }
  
  public Where<T, ID> le(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<="));
    return this;
  }
  
  public Where<T, ID> like(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "LIKE"));
    return this;
  }
  
  public Where<T, ID> lt(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<"));
    return this;
  }
  
  public Where<T, ID> ne(String paramString, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString, findColumnFieldType(paramString), paramObject, "<>"));
    return this;
  }
  
  public Where<T, ID> not()
  {
    addNeedsFuture(new Not());
    return this;
  }
  
  public Where<T, ID> not(Where<T, ID> paramWhere)
  {
    addClause(new Not(pop("NOT")));
    return this;
  }
  
  public Where<T, ID> notIn(String paramString, QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    return in(false, paramString, paramQueryBuilder);
  }
  
  public Where<T, ID> notIn(String paramString, Iterable<?> paramIterable)
    throws SQLException
  {
    addClause(new In(paramString, findColumnFieldType(paramString), paramIterable, false));
    return this;
  }
  
  public Where<T, ID> notIn(String paramString, Object... paramVarArgs)
    throws SQLException
  {
    return in(false, paramString, paramVarArgs);
  }
  
  public Where<T, ID> or()
  {
    addNeedsFuture(new ManyClause(pop("OR"), "OR"));
    return this;
  }
  
  public Where<T, ID> or(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
    }
    Clause[] arrayOfClause = new Clause[paramInt];
    paramInt -= 1;
    while (paramInt >= 0)
    {
      arrayOfClause[paramInt] = pop("OR");
      paramInt -= 1;
    }
    addClause(new ManyClause(arrayOfClause, "OR"));
    return this;
  }
  
  public Where<T, ID> or(Where<T, ID> paramWhere1, Where<T, ID> paramWhere2, Where<T, ID>... paramVarArgs)
  {
    paramWhere1 = buildClauseArray(paramVarArgs, "OR");
    paramWhere2 = pop("OR");
    addClause(new ManyClause(pop("OR"), paramWhere2, paramWhere1, "OR"));
    return this;
  }
  
  public PreparedQuery<T> prepare()
    throws SQLException
  {
    return this.statementBuilder.prepareStatement(null);
  }
  
  public List<T> query()
    throws SQLException
  {
    return checkQueryBuilderMethod("query()").query();
  }
  
  public T queryForFirst()
    throws SQLException
  {
    return (T)checkQueryBuilderMethod("queryForFirst()").queryForFirst();
  }
  
  public GenericRawResults<String[]> queryRaw()
    throws SQLException
  {
    return checkQueryBuilderMethod("queryRaw()").queryRaw();
  }
  
  public String[] queryRawFirst()
    throws SQLException
  {
    return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
  }
  
  public Where<T, ID> raw(String paramString, ArgumentHolder... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ArgumentHolder localArgumentHolder = paramVarArgs[i];
      String str = localArgumentHolder.getColumnName();
      if (str == null)
      {
        if (localArgumentHolder.getSqlType() == null) {
          throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
        }
      }
      else {
        localArgumentHolder.setMetaInfo(findColumnFieldType(str));
      }
      i += 1;
    }
    addClause(new Raw(paramString, paramVarArgs));
    return this;
  }
  
  public Where<T, ID> rawComparison(String paramString1, String paramString2, Object paramObject)
    throws SQLException
  {
    addClause(new SimpleComparison(paramString1, findColumnFieldType(paramString1), paramObject, paramString2));
    return this;
  }
  
  public Where<T, ID> reset()
  {
    int i = 0;
    while (i < this.clauseStackLevel)
    {
      this.clauseStack[i] = null;
      i += 1;
    }
    this.clauseStackLevel = 0;
    return this;
  }
  
  public String toString()
  {
    if (this.clauseStackLevel == 0) {
      return "empty where clause";
    }
    Clause localClause = peek();
    return "where clause: " + localClause;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/Where.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */