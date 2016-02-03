package com.inmobi.commons.db;

import java.util.LinkedHashMap;

public class TableData
{
  private String a;
  private LinkedHashMap<String, ColumnData> b;
  
  public LinkedHashMap<String, ColumnData> getmColumns()
  {
    return this.b;
  }
  
  public String getmTableName()
  {
    return this.a;
  }
  
  public void setmColumns(LinkedHashMap<String, ColumnData> paramLinkedHashMap)
  {
    this.b = paramLinkedHashMap;
  }
  
  public void setmTableName(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/db/TableData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */