package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class SelectArg
  extends BaseArgumentHolder
  implements ArgumentHolder
{
  private boolean hasBeenSet = false;
  private Object value = null;
  
  public SelectArg() {}
  
  public SelectArg(SqlType paramSqlType)
  {
    super(paramSqlType);
  }
  
  public SelectArg(SqlType paramSqlType, Object paramObject)
  {
    super(paramSqlType);
    setValue(paramObject);
  }
  
  public SelectArg(Object paramObject)
  {
    setValue(paramObject);
  }
  
  public SelectArg(String paramString, Object paramObject)
  {
    super(paramString);
    setValue(paramObject);
  }
  
  protected Object getValue()
  {
    return this.value;
  }
  
  protected boolean isValueSet()
  {
    return this.hasBeenSet;
  }
  
  public void setValue(Object paramObject)
  {
    this.hasBeenSet = true;
    this.value = paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/SelectArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */