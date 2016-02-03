package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QueryBuilder<T, ID>
  extends StatementBuilder<T, ID>
{
  private boolean distinct;
  private List<String> groupByList;
  private String groupByRaw;
  private String having;
  private final FieldType idField;
  private boolean isCountOfQuery;
  private boolean isInnerQuery;
  private List<QueryBuilder<T, ID>.JoinInfo> joinList;
  private Long limit;
  private Long offset;
  private ArgumentHolder[] orderByArgs;
  private List<OrderBy> orderByList;
  private String orderByRaw;
  private FieldType[] resultFieldTypes;
  private List<String> selectColumnList;
  private boolean selectIdColumn = true;
  private List<String> selectRawList;
  
  public QueryBuilder(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, Dao<T, ID> paramDao)
  {
    super(paramDatabaseType, paramTableInfo, paramDao, StatementBuilder.StatementType.SELECT);
    this.idField = paramTableInfo.getIdField();
  }
  
  private void addJoinInfo(String paramString, QueryBuilder<?, ?> paramQueryBuilder, StatementBuilder.WhereOperation paramWhereOperation)
    throws SQLException
  {
    paramString = new JoinInfo(paramString, paramQueryBuilder, paramWhereOperation);
    matchJoinedFields(paramString, paramQueryBuilder);
    if (this.joinList == null) {
      this.joinList = new ArrayList();
    }
    this.joinList.add(paramString);
  }
  
  private void addSelectColumnToList(String paramString)
  {
    verifyColumnName(paramString);
    this.selectColumnList.add(paramString);
  }
  
  private void appendColumnName(StringBuilder paramStringBuilder, String paramString)
  {
    if (this.addTableName)
    {
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
      paramStringBuilder.append('.');
    }
    this.databaseType.appendEscapedEntityName(paramStringBuilder, paramString);
  }
  
  private void appendColumns(StringBuilder paramStringBuilder)
  {
    if (this.selectColumnList == null)
    {
      if (this.addTableName)
      {
        this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
        paramStringBuilder.append('.');
      }
      paramStringBuilder.append("* ");
      this.resultFieldTypes = this.tableInfo.getFieldTypes();
      return;
    }
    int j = 1;
    if (this.isInnerQuery) {}
    ArrayList localArrayList;
    Object localObject;
    for (int i = 1;; i = 0)
    {
      localArrayList = new ArrayList(this.selectColumnList.size() + 1);
      Iterator localIterator = this.selectColumnList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label204;
        }
        localObject = (String)localIterator.next();
        localObject = this.tableInfo.getFieldTypeByColumnName((String)localObject);
        if (!((FieldType)localObject).isForeignCollection()) {
          break;
        }
        localArrayList.add(localObject);
      }
    }
    if (j != 0) {}
    for (int k = 0;; k = j)
    {
      appendFieldColumnName(paramStringBuilder, (FieldType)localObject, localArrayList);
      j = k;
      if (localObject != this.idField) {
        break;
      }
      i = 1;
      j = k;
      break;
      paramStringBuilder.append(',');
    }
    label204:
    if ((i == 0) && (this.selectIdColumn))
    {
      if (j == 0) {
        paramStringBuilder.append(',');
      }
      appendFieldColumnName(paramStringBuilder, this.idField, localArrayList);
    }
    paramStringBuilder.append(' ');
    this.resultFieldTypes = ((FieldType[])localArrayList.toArray(new FieldType[localArrayList.size()]));
  }
  
  private void appendFieldColumnName(StringBuilder paramStringBuilder, FieldType paramFieldType, List<FieldType> paramList)
  {
    appendColumnName(paramStringBuilder, paramFieldType.getColumnName());
    if (paramList != null) {
      paramList.add(paramFieldType);
    }
  }
  
  private void appendGroupBys(StringBuilder paramStringBuilder)
  {
    boolean bool = true;
    if (hasGroupStuff())
    {
      appendGroupBys(paramStringBuilder, true);
      bool = false;
    }
    if (this.joinList != null)
    {
      Iterator localIterator = this.joinList.iterator();
      while (localIterator.hasNext())
      {
        JoinInfo localJoinInfo = (JoinInfo)localIterator.next();
        if ((localJoinInfo.queryBuilder != null) && (localJoinInfo.queryBuilder.hasGroupStuff())) {
          localJoinInfo.queryBuilder.appendGroupBys(paramStringBuilder, bool);
        }
      }
    }
  }
  
  private void appendGroupBys(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramStringBuilder.append("GROUP BY ");
    }
    if (this.groupByRaw != null)
    {
      if (!paramBoolean) {
        paramStringBuilder.append(',');
      }
      paramStringBuilder.append(this.groupByRaw);
      paramStringBuilder.append(' ');
      return;
    }
    Iterator localIterator = this.groupByList.iterator();
    label56:
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!paramBoolean) {
        break label92;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      appendColumnName(paramStringBuilder, str);
      break label56;
      break;
      label92:
      paramStringBuilder.append(',');
    }
  }
  
  private void appendHaving(StringBuilder paramStringBuilder)
  {
    if (this.having != null) {
      paramStringBuilder.append("HAVING ").append(this.having).append(' ');
    }
  }
  
  private void appendJoinSql(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.joinList.iterator();
    while (localIterator.hasNext())
    {
      JoinInfo localJoinInfo = (JoinInfo)localIterator.next();
      paramStringBuilder.append(localJoinInfo.type).append(" JOIN ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, localJoinInfo.queryBuilder.tableName);
      paramStringBuilder.append(" ON ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
      paramStringBuilder.append('.');
      this.databaseType.appendEscapedEntityName(paramStringBuilder, localJoinInfo.localField.getColumnName());
      paramStringBuilder.append(" = ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, localJoinInfo.queryBuilder.tableName);
      paramStringBuilder.append('.');
      this.databaseType.appendEscapedEntityName(paramStringBuilder, localJoinInfo.remoteField.getColumnName());
      paramStringBuilder.append(' ');
      if (localJoinInfo.queryBuilder.joinList != null) {
        localJoinInfo.queryBuilder.appendJoinSql(paramStringBuilder);
      }
    }
  }
  
  private void appendLimit(StringBuilder paramStringBuilder)
  {
    if ((this.limit != null) && (this.databaseType.isLimitSqlSupported())) {
      this.databaseType.appendLimitValue(paramStringBuilder, this.limit.longValue(), this.offset);
    }
  }
  
  private void appendOffset(StringBuilder paramStringBuilder)
    throws SQLException
  {
    if (this.offset == null) {}
    do
    {
      return;
      if (!this.databaseType.isOffsetLimitArgument()) {
        break;
      }
    } while (this.limit != null);
    throw new SQLException("If the offset is specified, limit must also be specified with this database");
    this.databaseType.appendOffsetValue(paramStringBuilder, this.offset.longValue());
  }
  
  private void appendOrderBys(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    boolean bool = true;
    if (hasOrderStuff())
    {
      appendOrderBys(paramStringBuilder, true, paramList);
      bool = false;
    }
    if (this.joinList != null)
    {
      Iterator localIterator = this.joinList.iterator();
      while (localIterator.hasNext())
      {
        JoinInfo localJoinInfo = (JoinInfo)localIterator.next();
        if ((localJoinInfo.queryBuilder != null) && (localJoinInfo.queryBuilder.hasOrderStuff())) {
          localJoinInfo.queryBuilder.appendOrderBys(paramStringBuilder, bool, paramList);
        }
      }
    }
  }
  
  private void appendOrderBys(StringBuilder paramStringBuilder, boolean paramBoolean, List<ArgumentHolder> paramList)
  {
    if (paramBoolean) {
      paramStringBuilder.append("ORDER BY ");
    }
    Object localObject;
    if (this.orderByRaw != null)
    {
      if (!paramBoolean) {
        paramStringBuilder.append(',');
      }
      paramStringBuilder.append(this.orderByRaw);
      if (this.orderByArgs != null)
      {
        localObject = this.orderByArgs;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramList.add(localObject[i]);
          i += 1;
        }
      }
    }
    else
    {
      paramList = this.orderByList.iterator();
      if (paramList.hasNext())
      {
        localObject = (OrderBy)paramList.next();
        if (paramBoolean) {}
        for (boolean bool = false;; bool = paramBoolean)
        {
          appendColumnName(paramStringBuilder, ((OrderBy)localObject).getColumnName());
          paramBoolean = bool;
          if (((OrderBy)localObject).isAscending()) {
            break;
          }
          paramStringBuilder.append(" DESC");
          paramBoolean = bool;
          break;
          paramStringBuilder.append(',');
        }
      }
    }
    paramStringBuilder.append(' ');
  }
  
  private void appendSelectRaw(StringBuilder paramStringBuilder)
  {
    int i = 1;
    Iterator localIterator = this.selectRawList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        paramStringBuilder.append(str);
        break;
        paramStringBuilder.append(", ");
      }
    }
    paramStringBuilder.append(' ');
  }
  
  private boolean hasGroupStuff()
  {
    return ((this.groupByList != null) && (!this.groupByList.isEmpty())) || (this.groupByRaw != null);
  }
  
  private boolean hasOrderStuff()
  {
    return ((this.orderByList != null) && (!this.orderByList.isEmpty())) || (this.orderByRaw != null);
  }
  
  private void matchJoinedFields(QueryBuilder<T, ID>.JoinInfo paramQueryBuilder, QueryBuilder<?, ?> paramQueryBuilder1)
    throws SQLException
  {
    FieldType[] arrayOfFieldType = this.tableInfo.getFieldTypes();
    int j = arrayOfFieldType.length;
    int i = 0;
    FieldType localFieldType1;
    while (i < j)
    {
      localFieldType1 = arrayOfFieldType[i];
      FieldType localFieldType2 = localFieldType1.getForeignIdField();
      if ((localFieldType1.isForeign()) && (localFieldType2.equals(paramQueryBuilder1.tableInfo.getIdField())))
      {
        paramQueryBuilder.localField = localFieldType1;
        paramQueryBuilder.remoteField = localFieldType2;
        return;
      }
      i += 1;
    }
    arrayOfFieldType = paramQueryBuilder1.tableInfo.getFieldTypes();
    j = arrayOfFieldType.length;
    i = 0;
    while (i < j)
    {
      localFieldType1 = arrayOfFieldType[i];
      if ((localFieldType1.isForeign()) && (localFieldType1.getForeignIdField().equals(this.idField)))
      {
        paramQueryBuilder.localField = this.idField;
        paramQueryBuilder.remoteField = localFieldType1;
        return;
      }
      i += 1;
    }
    throw new SQLException("Could not find a foreign " + this.tableInfo.getDataClass() + " field in " + paramQueryBuilder1.tableInfo.getDataClass() + " or vice versa");
  }
  
  private void setAddTableName(boolean paramBoolean)
  {
    this.addTableName = paramBoolean;
    if (this.joinList != null)
    {
      Iterator localIterator = this.joinList.iterator();
      while (localIterator.hasNext()) {
        ((JoinInfo)localIterator.next()).queryBuilder.setAddTableName(paramBoolean);
      }
    }
  }
  
  protected void appendStatementEnd(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    appendGroupBys(paramStringBuilder);
    appendHaving(paramStringBuilder);
    appendOrderBys(paramStringBuilder, paramList);
    if (!this.databaseType.isLimitAfterSelect()) {
      appendLimit(paramStringBuilder);
    }
    appendOffset(paramStringBuilder);
    setAddTableName(false);
  }
  
  protected void appendStatementStart(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
  {
    if (this.joinList == null)
    {
      setAddTableName(false);
      paramStringBuilder.append("SELECT ");
      if (this.databaseType.isLimitAfterSelect()) {
        appendLimit(paramStringBuilder);
      }
      if (this.distinct) {
        paramStringBuilder.append("DISTINCT ");
      }
      if (!this.isCountOfQuery) {
        break label124;
      }
      this.type = StatementBuilder.StatementType.SELECT_LONG;
      paramStringBuilder.append("COUNT(*) ");
    }
    for (;;)
    {
      paramStringBuilder.append("FROM ");
      this.databaseType.appendEscapedEntityName(paramStringBuilder, this.tableName);
      paramStringBuilder.append(' ');
      if (this.joinList != null) {
        appendJoinSql(paramStringBuilder);
      }
      return;
      setAddTableName(true);
      break;
      label124:
      if ((this.selectRawList != null) && (!this.selectRawList.isEmpty()))
      {
        this.type = StatementBuilder.StatementType.SELECT_RAW;
        appendSelectRaw(paramStringBuilder);
      }
      else
      {
        this.type = StatementBuilder.StatementType.SELECT;
        appendColumns(paramStringBuilder);
      }
    }
  }
  
  protected boolean appendWhereStatement(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, StatementBuilder.WhereOperation paramWhereOperation)
    throws SQLException
  {
    boolean bool1;
    boolean bool2;
    label48:
    JoinInfo localJoinInfo;
    if (paramWhereOperation == StatementBuilder.WhereOperation.FIRST)
    {
      bool1 = true;
      if (this.where != null) {
        bool1 = super.appendWhereStatement(paramStringBuilder, paramList, paramWhereOperation);
      }
      bool2 = bool1;
      if (this.joinList == null) {
        break label114;
      }
      Iterator localIterator = this.joinList.iterator();
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break label114;
      }
      localJoinInfo = (JoinInfo)localIterator.next();
      if (!bool1) {
        break label105;
      }
    }
    label105:
    for (paramWhereOperation = StatementBuilder.WhereOperation.FIRST;; paramWhereOperation = localJoinInfo.operation)
    {
      bool1 = localJoinInfo.queryBuilder.appendWhereStatement(paramStringBuilder, paramList, paramWhereOperation);
      break label48;
      bool1 = false;
      break;
    }
    label114:
    return bool2;
  }
  
  @Deprecated
  public void clear()
  {
    reset();
  }
  
  public long countOf()
    throws SQLException
  {
    setCountOf(true);
    return this.dao.countOf(prepare());
  }
  
  public QueryBuilder<T, ID> distinct()
  {
    this.distinct = true;
    this.selectIdColumn = false;
    return this;
  }
  
  void enableInnerQuery()
  {
    this.isInnerQuery = true;
  }
  
  protected FieldType[] getResultFieldTypes()
  {
    return this.resultFieldTypes;
  }
  
  int getSelectColumnCount()
  {
    if (this.isCountOfQuery) {
      return 1;
    }
    if ((this.selectRawList != null) && (!this.selectRawList.isEmpty())) {
      return this.selectRawList.size();
    }
    if (this.selectColumnList == null) {
      return 0;
    }
    return this.selectColumnList.size();
  }
  
  List<String> getSelectColumns()
  {
    if (this.isCountOfQuery) {
      return Collections.singletonList("COUNT(*)");
    }
    if ((this.selectRawList != null) && (!this.selectRawList.isEmpty())) {
      return this.selectRawList;
    }
    if (this.selectColumnList == null) {
      return Collections.emptyList();
    }
    return this.selectColumnList;
  }
  
  public QueryBuilder<T, ID> groupBy(String paramString)
  {
    if (verifyColumnName(paramString).isForeignCollection()) {
      throw new IllegalArgumentException("Can't groupBy foreign colletion field: " + paramString);
    }
    if (this.groupByList == null) {
      this.groupByList = new ArrayList();
    }
    this.groupByList.add(paramString);
    this.selectIdColumn = false;
    return this;
  }
  
  public QueryBuilder<T, ID> groupByRaw(String paramString)
  {
    this.groupByRaw = paramString;
    return this;
  }
  
  public QueryBuilder<T, ID> having(String paramString)
  {
    this.having = paramString;
    return this;
  }
  
  public CloseableIterator<T> iterator()
    throws SQLException
  {
    return this.dao.iterator(prepare());
  }
  
  public QueryBuilder<T, ID> join(QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    addJoinInfo("INNER", paramQueryBuilder, StatementBuilder.WhereOperation.AND);
    return this;
  }
  
  public QueryBuilder<T, ID> joinOr(QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    addJoinInfo("INNER", paramQueryBuilder, StatementBuilder.WhereOperation.OR);
    return this;
  }
  
  public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    addJoinInfo("LEFT", paramQueryBuilder, StatementBuilder.WhereOperation.AND);
    return this;
  }
  
  public QueryBuilder<T, ID> leftJoinOr(QueryBuilder<?, ?> paramQueryBuilder)
    throws SQLException
  {
    addJoinInfo("LEFT", paramQueryBuilder, StatementBuilder.WhereOperation.OR);
    return this;
  }
  
  @Deprecated
  public QueryBuilder<T, ID> limit(int paramInt)
  {
    return limit(Long.valueOf(paramInt));
  }
  
  public QueryBuilder<T, ID> limit(Long paramLong)
  {
    this.limit = paramLong;
    return this;
  }
  
  @Deprecated
  public QueryBuilder<T, ID> offset(int paramInt)
    throws SQLException
  {
    return offset(Long.valueOf(paramInt));
  }
  
  public QueryBuilder<T, ID> offset(Long paramLong)
    throws SQLException
  {
    if (this.databaseType.isOffsetSqlSupported())
    {
      this.offset = paramLong;
      return this;
    }
    throw new SQLException("Offset is not supported by this database");
  }
  
  public QueryBuilder<T, ID> orderBy(String paramString, boolean paramBoolean)
  {
    if (verifyColumnName(paramString).isForeignCollection()) {
      throw new IllegalArgumentException("Can't orderBy foreign colletion field: " + paramString);
    }
    if (this.orderByList == null) {
      this.orderByList = new ArrayList();
    }
    this.orderByList.add(new OrderBy(paramString, paramBoolean));
    return this;
  }
  
  public QueryBuilder<T, ID> orderByRaw(String paramString)
  {
    return orderByRaw(paramString, (ArgumentHolder[])null);
  }
  
  public QueryBuilder<T, ID> orderByRaw(String paramString, ArgumentHolder... paramVarArgs)
  {
    this.orderByRaw = paramString;
    this.orderByArgs = paramVarArgs;
    return this;
  }
  
  public PreparedQuery<T> prepare()
    throws SQLException
  {
    return super.prepareStatement(this.limit);
  }
  
  public List<T> query()
    throws SQLException
  {
    return this.dao.query(prepare());
  }
  
  public T queryForFirst()
    throws SQLException
  {
    return (T)this.dao.queryForFirst(prepare());
  }
  
  public GenericRawResults<String[]> queryRaw()
    throws SQLException
  {
    return this.dao.queryRaw(prepareStatementString(), new String[0]);
  }
  
  public String[] queryRawFirst()
    throws SQLException
  {
    return (String[])this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
  }
  
  public void reset()
  {
    super.reset();
    this.distinct = false;
    this.selectIdColumn = true;
    this.selectColumnList = null;
    this.selectRawList = null;
    this.orderByList = null;
    this.orderByRaw = null;
    this.groupByList = null;
    this.groupByRaw = null;
    this.isInnerQuery = false;
    this.isCountOfQuery = false;
    this.having = null;
    this.limit = null;
    this.offset = null;
    if (this.joinList != null)
    {
      this.joinList.clear();
      this.joinList = null;
    }
    this.addTableName = false;
  }
  
  public QueryBuilder<T, ID> selectColumns(Iterable<String> paramIterable)
  {
    if (this.selectColumnList == null) {
      this.selectColumnList = new ArrayList();
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addSelectColumnToList((String)paramIterable.next());
    }
    return this;
  }
  
  public QueryBuilder<T, ID> selectColumns(String... paramVarArgs)
  {
    if (this.selectColumnList == null) {
      this.selectColumnList = new ArrayList();
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addSelectColumnToList(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public QueryBuilder<T, ID> selectRaw(String... paramVarArgs)
  {
    if (this.selectRawList == null) {
      this.selectRawList = new ArrayList();
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      this.selectRawList.add(str);
      i += 1;
    }
    return this;
  }
  
  public QueryBuilder<T, ID> setCountOf(boolean paramBoolean)
  {
    this.isCountOfQuery = paramBoolean;
    return this;
  }
  
  protected boolean shouldPrependTableNameToColumns()
  {
    return this.joinList != null;
  }
  
  public static class InternalQueryBuilderWrapper
  {
    private final QueryBuilder<?, ?> queryBuilder;
    
    InternalQueryBuilderWrapper(QueryBuilder<?, ?> paramQueryBuilder)
    {
      this.queryBuilder = paramQueryBuilder;
    }
    
    public void appendStatementString(StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
      throws SQLException
    {
      this.queryBuilder.appendStatementString(paramStringBuilder, paramList);
    }
    
    public FieldType[] getResultFieldTypes()
    {
      return this.queryBuilder.getResultFieldTypes();
    }
  }
  
  private class JoinInfo
  {
    FieldType localField;
    StatementBuilder.WhereOperation operation;
    final QueryBuilder<?, ?> queryBuilder;
    FieldType remoteField;
    final String type;
    
    public JoinInfo(QueryBuilder<?, ?> paramQueryBuilder, StatementBuilder.WhereOperation paramWhereOperation)
    {
      this.type = paramQueryBuilder;
      this.queryBuilder = paramWhereOperation;
      StatementBuilder.WhereOperation localWhereOperation;
      this.operation = localWhereOperation;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */