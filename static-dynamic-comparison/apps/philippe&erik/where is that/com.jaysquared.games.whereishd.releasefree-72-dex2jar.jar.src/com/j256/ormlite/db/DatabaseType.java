package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

public abstract interface DatabaseType
{
  public abstract void addPrimaryKeySql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    throws SQLException;
  
  public abstract void addUniqueComboSql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    throws SQLException;
  
  public abstract void appendColumnArg(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    throws SQLException;
  
  public abstract void appendCreateTableSuffix(StringBuilder paramStringBuilder);
  
  public abstract void appendEscapedEntityName(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void appendEscapedWord(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void appendLimitValue(StringBuilder paramStringBuilder, long paramLong, Long paramLong1);
  
  public abstract void appendOffsetValue(StringBuilder paramStringBuilder, long paramLong);
  
  public abstract void appendSelectNextValFromSequence(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void dropColumnArg(FieldType paramFieldType, List<String> paramList1, List<String> paramList2);
  
  public abstract <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException;
  
  public abstract String generateIdSequenceName(String paramString, FieldType paramFieldType);
  
  public abstract String getCommentLinePrefix();
  
  public abstract String getDatabaseName();
  
  public abstract FieldConverter getFieldConverter(DataPersister paramDataPersister);
  
  public abstract String getPingStatement();
  
  public abstract boolean isAllowGeneratedIdInsertSupported();
  
  public abstract boolean isBatchUseTransaction();
  
  public abstract boolean isCreateIfNotExistsSupported();
  
  public abstract boolean isCreateIndexIfNotExistsSupported();
  
  public abstract boolean isCreateTableReturnsNegative();
  
  public abstract boolean isCreateTableReturnsZero();
  
  public abstract boolean isDatabaseUrlThisType(String paramString1, String paramString2);
  
  public abstract boolean isEntityNamesMustBeUpCase();
  
  public abstract boolean isIdSequenceNeeded();
  
  public abstract boolean isLimitAfterSelect();
  
  public abstract boolean isLimitSqlSupported();
  
  public abstract boolean isNestedSavePointsSupported();
  
  public abstract boolean isOffsetLimitArgument();
  
  public abstract boolean isOffsetSqlSupported();
  
  public abstract boolean isSelectSequenceBeforeInsert();
  
  public abstract boolean isTruncateSupported();
  
  public abstract boolean isVarcharFieldWidthSupported();
  
  public abstract void loadDriver()
    throws SQLException;
  
  public abstract void setDriver(Driver paramDriver);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/db/DatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */