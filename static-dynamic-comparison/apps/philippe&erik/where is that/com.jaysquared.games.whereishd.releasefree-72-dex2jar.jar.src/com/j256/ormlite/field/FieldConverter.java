package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public abstract interface FieldConverter
{
  public abstract SqlType getSqlType();
  
  public abstract boolean isStreamType();
  
  public abstract Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    throws SQLException;
  
  public abstract Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException;
  
  public abstract Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
    throws SQLException;
  
  public abstract Object resultToJava(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException;
  
  public abstract Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException;
  
  public abstract Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/FieldConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */