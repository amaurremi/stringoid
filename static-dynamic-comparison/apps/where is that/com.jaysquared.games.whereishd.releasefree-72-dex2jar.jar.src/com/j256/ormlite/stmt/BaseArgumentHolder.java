package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract class BaseArgumentHolder
  implements ArgumentHolder
{
  private String columnName = null;
  private FieldType fieldType = null;
  private SqlType sqlType = null;
  
  public BaseArgumentHolder() {}
  
  public BaseArgumentHolder(SqlType paramSqlType)
  {
    this.sqlType = paramSqlType;
  }
  
  public BaseArgumentHolder(String paramString)
  {
    this.columnName = paramString;
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public FieldType getFieldType()
  {
    return this.fieldType;
  }
  
  public Object getSqlArgValue()
    throws SQLException
  {
    if (!isValueSet()) {
      throw new SQLException("Column value has not been set for " + this.columnName);
    }
    Object localObject2 = getValue();
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (this.fieldType == null);
    if ((this.fieldType.isForeign()) && (this.fieldType.getType() == localObject2.getClass())) {
      return this.fieldType.getForeignIdField().extractJavaFieldValue(localObject2);
    }
    return this.fieldType.convertJavaFieldToSqlArgValue(localObject2);
  }
  
  public SqlType getSqlType()
  {
    return this.sqlType;
  }
  
  protected abstract Object getValue();
  
  protected abstract boolean isValueSet();
  
  public void setMetaInfo(FieldType paramFieldType)
  {
    if (this.fieldType == null) {}
    while (this.fieldType == paramFieldType)
    {
      this.fieldType = paramFieldType;
      return;
    }
    throw new IllegalArgumentException("FieldType name cannot be set twice from " + this.fieldType + " to " + paramFieldType + ".  Using a SelectArg twice in query with different columns?");
  }
  
  public void setMetaInfo(String paramString)
  {
    if (this.columnName == null) {}
    while (this.columnName.equals(paramString))
    {
      this.columnName = paramString;
      return;
    }
    throw new IllegalArgumentException("Column name cannot be set twice from " + this.columnName + " to " + paramString + ".  Using a SelectArg twice in query with different columns?");
  }
  
  public void setMetaInfo(String paramString, FieldType paramFieldType)
  {
    setMetaInfo(paramString);
    setMetaInfo(paramFieldType);
  }
  
  public abstract void setValue(Object paramObject);
  
  public String toString()
  {
    if (!isValueSet()) {
      return "[unset]";
    }
    try
    {
      Object localObject = getSqlArgValue();
      if (localObject == null) {
        return "[null]";
      }
      localObject = localObject.toString();
      return (String)localObject;
    }
    catch (SQLException localSQLException)
    {
      return "[could not get value: " + localSQLException + "]";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/BaseArgumentHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */