package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import java.util.List;

public abstract class BaseSqliteDatabaseType
  extends BaseDatabaseType
  implements DatabaseType
{
  private static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();
  
  protected void appendLongType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    if ((paramFieldType.getSqlType() == SqlType.LONG) && (paramFieldType.isGeneratedId()))
    {
      paramStringBuilder.append("INTEGER");
      return;
    }
    paramStringBuilder.append("BIGINT");
  }
  
  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    if ((paramFieldType.getSqlType() != SqlType.INTEGER) && (paramFieldType.getSqlType() != SqlType.LONG)) {
      throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
    }
    paramStringBuilder.append("PRIMARY KEY AUTOINCREMENT ");
  }
  
  protected boolean generatedIdSqlAtEnd()
  {
    return false;
  }
  
  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    switch (paramDataPersister.getSqlType())
    {
    default: 
      return super.getFieldConverter(paramDataPersister);
    case ???: 
      return booleanConverter;
    }
    return BigDecimalStringType.getSingleton();
  }
  
  public boolean isCreateIfNotExistsSupported()
  {
    return true;
  }
  
  public boolean isCreateTableReturnsZero()
  {
    return false;
  }
  
  public boolean isVarcharFieldWidthSupported()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/db/BaseSqliteDatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */