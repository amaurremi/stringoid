package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.List;

abstract class BaseComparison
  implements Comparison
{
  private static final String NUMBER_CHARACTERS = "0123456789.-+";
  protected final String columnName;
  protected final FieldType fieldType;
  private final Object value;
  
  protected BaseComparison(String paramString, FieldType paramFieldType, Object paramObject, boolean paramBoolean)
    throws SQLException
  {
    if ((paramBoolean) && (paramFieldType != null) && (!paramFieldType.isComparable())) {
      throw new SQLException("Field '" + paramString + "' is of data type " + paramFieldType.getDataPersister() + " which can not be compared");
    }
    this.columnName = paramString;
    this.fieldType = paramFieldType;
    this.value = paramObject;
  }
  
  protected void appendArgOrValue(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, Object paramObject)
    throws SQLException
  {
    int i = 1;
    if (paramObject == null) {
      throw new SQLException("argument for '" + paramFieldType.getFieldName() + "' is null");
    }
    if ((paramObject instanceof ArgumentHolder))
    {
      paramStringBuilder.append('?');
      paramDatabaseType = (ArgumentHolder)paramObject;
      paramDatabaseType.setMetaInfo(this.columnName, paramFieldType);
      paramList.add(paramDatabaseType);
    }
    for (;;)
    {
      if (i != 0) {
        paramStringBuilder.append(' ');
      }
      return;
      if ((paramObject instanceof ColumnArg))
      {
        paramFieldType = (ColumnArg)paramObject;
        paramList = paramFieldType.getTableName();
        if (paramList != null)
        {
          paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramList);
          paramStringBuilder.append('.');
        }
        paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
      }
      else if (paramFieldType.isArgumentHolderRequired())
      {
        paramStringBuilder.append('?');
        paramDatabaseType = new SelectArg();
        paramDatabaseType.setMetaInfo(this.columnName, paramFieldType);
        paramDatabaseType.setValue(paramObject);
        paramList.add(paramDatabaseType);
      }
      else if ((paramFieldType.isForeign()) && (paramFieldType.getType().isAssignableFrom(paramObject.getClass())))
      {
        paramFieldType = paramFieldType.getForeignIdField();
        appendArgOrValue(paramDatabaseType, paramFieldType, paramStringBuilder, paramList, paramFieldType.extractJavaFieldValue(paramObject));
        i = 0;
      }
      else if (paramFieldType.isEscapedValue())
      {
        paramDatabaseType.appendEscapedWord(paramStringBuilder, paramFieldType.convertJavaFieldToSqlArgValue(paramObject).toString());
      }
      else if (paramFieldType.isForeign())
      {
        paramDatabaseType = paramFieldType.convertJavaFieldToSqlArgValue(paramObject).toString();
        if ((paramDatabaseType.length() > 0) && ("0123456789.-+".indexOf(paramDatabaseType.charAt(0)) < 0)) {
          throw new SQLException("Foreign field " + paramFieldType + " does not seem to be producing a numerical value '" + paramDatabaseType + "'. Maybe you are passing the wrong object to comparison: " + this);
        }
        paramStringBuilder.append(paramDatabaseType);
      }
      else
      {
        paramStringBuilder.append(paramFieldType.convertJavaFieldToSqlArgValue(paramObject));
      }
    }
  }
  
  public abstract void appendOperation(StringBuilder paramStringBuilder);
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    if (paramString != null)
    {
      paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramString);
      paramStringBuilder.append('.');
    }
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, this.columnName);
    paramStringBuilder.append(' ');
    appendOperation(paramStringBuilder);
    appendValue(paramDatabaseType, paramStringBuilder, paramList);
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    appendArgOrValue(paramDatabaseType, this.fieldType, paramStringBuilder, paramList, this.value);
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.columnName).append(' ');
    appendOperation(localStringBuilder);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/query/BaseComparison.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */