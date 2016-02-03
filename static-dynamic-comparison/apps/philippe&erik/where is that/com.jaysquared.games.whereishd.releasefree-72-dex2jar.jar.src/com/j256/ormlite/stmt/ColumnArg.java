package com.j256.ormlite.stmt;

public class ColumnArg
{
  private final String columnName;
  private final String tableName;
  
  public ColumnArg(String paramString)
  {
    this.tableName = null;
    this.columnName = paramString;
  }
  
  public ColumnArg(String paramString1, String paramString2)
  {
    this.tableName = paramString1;
    this.columnName = paramString2;
  }
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/ColumnArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */