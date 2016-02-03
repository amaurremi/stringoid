package com.j256.ormlite.db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

public class SqliteAndroidDatabaseType
  extends BaseSqliteDatabaseType
  implements DatabaseType
{
  protected void appendBooleanType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    appendShortType(paramStringBuilder, paramFieldType, paramInt);
  }
  
  protected void appendDateType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    appendStringType(paramStringBuilder, paramFieldType, paramInt);
  }
  
  public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return DatabaseTableConfigUtil.fromClass(paramConnectionSource, paramClass);
  }
  
  public String getDatabaseName()
  {
    return "Android SQLite";
  }
  
  protected String getDriverClassName()
  {
    return null;
  }
  
  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    switch (paramDataPersister.getSqlType())
    {
    default: 
      return super.getFieldConverter(paramDataPersister);
    }
    return DateStringType.getSingleton();
  }
  
  public boolean isBatchUseTransaction()
  {
    return true;
  }
  
  public boolean isDatabaseUrlThisType(String paramString1, String paramString2)
  {
    return true;
  }
  
  public boolean isNestedSavePointsSupported()
  {
    return false;
  }
  
  public void loadDriver() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/db/SqliteAndroidDatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */