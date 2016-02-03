package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract interface ArgumentHolder
{
  public abstract String getColumnName();
  
  public abstract FieldType getFieldType();
  
  public abstract Object getSqlArgValue()
    throws SQLException;
  
  public abstract SqlType getSqlType();
  
  public abstract void setMetaInfo(FieldType paramFieldType);
  
  public abstract void setMetaInfo(String paramString);
  
  public abstract void setMetaInfo(String paramString, FieldType paramFieldType);
  
  public abstract void setValue(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/ArgumentHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */