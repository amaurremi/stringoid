package com.j256.ormlite.db;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDatabaseType
  implements DatabaseType
{
  protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
  protected Driver driver;
  
  private void addSingleUnique(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2)
  {
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append(" UNIQUE (");
    appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(")");
    paramList1.add(paramStringBuilder.toString());
  }
  
  private void appendCanBeNull(StringBuilder paramStringBuilder, FieldType paramFieldType) {}
  
  private void appendDefaultValue(StringBuilder paramStringBuilder, FieldType paramFieldType, Object paramObject)
  {
    if (paramFieldType.isEscapedDefaultValue())
    {
      appendEscapedWord(paramStringBuilder, paramObject.toString());
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void appendDoubleType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("DOUBLE PRECISION");
  }
  
  private void appendFloatType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("FLOAT");
  }
  
  private void appendIntegerType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("INTEGER");
  }
  
  public void addPrimaryKeySql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    paramList2 = null;
    int j = paramArrayOfFieldType.length;
    int i = 0;
    if (i < j)
    {
      paramList4 = paramArrayOfFieldType[i];
      if ((paramList4.isGeneratedId()) && (!generatedIdSqlAtEnd()) && (!paramList4.isSelfGeneratedId())) {
        paramList3 = paramList2;
      }
      do
      {
        i += 1;
        paramList2 = paramList3;
        break;
        paramList3 = paramList2;
      } while (!paramList4.isId());
      if (paramList2 == null)
      {
        paramList2 = new StringBuilder(48);
        paramList2.append("PRIMARY KEY (");
      }
      for (;;)
      {
        appendEscapedEntityName(paramList2, paramList4.getColumnName());
        paramList3 = paramList2;
        break;
        paramList2.append(',');
      }
    }
    if (paramList2 != null)
    {
      paramList2.append(") ");
      paramList1.add(paramList2.toString());
    }
  }
  
  public void addUniqueComboSql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    paramList2 = null;
    int j = paramArrayOfFieldType.length;
    int i = 0;
    if (i < j)
    {
      paramList4 = paramArrayOfFieldType[i];
      paramList3 = paramList2;
      if (paramList4.isUniqueCombo())
      {
        if (paramList2 != null) {
          break label79;
        }
        paramList2 = new StringBuilder(48);
        paramList2.append("UNIQUE (");
      }
      for (;;)
      {
        appendEscapedEntityName(paramList2, paramList4.getColumnName());
        paramList3 = paramList2;
        i += 1;
        paramList2 = paramList3;
        break;
        label79:
        paramList2.append(',');
      }
    }
    if (paramList2 != null)
    {
      paramList2.append(") ");
      paramList1.add(paramList2.toString());
    }
  }
  
  protected void appendBigDecimalNumericType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("NUMERIC");
  }
  
  protected void appendBooleanType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("BOOLEAN");
  }
  
  protected void appendByteArrayType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("BLOB");
  }
  
  protected void appendByteType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("TINYINT");
  }
  
  protected void appendCharType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("CHAR");
  }
  
  public void appendColumnArg(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    throws SQLException
  {
    appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(' ');
    DataPersister localDataPersister = paramFieldType.getDataPersister();
    int j = paramFieldType.getWidth();
    int i = j;
    if (j == 0) {
      i = localDataPersister.getDefaultWidth();
    }
    switch (localDataPersister.getSqlType())
    {
    default: 
      throw new IllegalArgumentException("Unknown SQL-type " + localDataPersister.getSqlType());
    case ???: 
      appendStringType(paramStringBuilder, paramFieldType, i);
      paramStringBuilder.append(' ');
      if ((paramFieldType.isGeneratedIdSequence()) && (!paramFieldType.isSelfGeneratedId()))
      {
        configureGeneratedIdSequence(paramStringBuilder, paramFieldType, paramList2, paramList1, paramList4);
        label206:
        if (!paramFieldType.isGeneratedId())
        {
          paramString = paramFieldType.getDefaultValue();
          if (paramString != null)
          {
            paramStringBuilder.append("DEFAULT ");
            appendDefaultValue(paramStringBuilder, paramFieldType, paramString);
            paramStringBuilder.append(' ');
          }
          if (!paramFieldType.isCanBeNull()) {
            break label471;
          }
          appendCanBeNull(paramStringBuilder, paramFieldType);
        }
      }
      break;
    }
    for (;;)
    {
      if (paramFieldType.isUnique()) {
        addSingleUnique(paramStringBuilder, paramFieldType, paramList1, paramList3);
      }
      return;
      appendLongStringType(paramStringBuilder, paramFieldType, i);
      break;
      appendBooleanType(paramStringBuilder, paramFieldType, i);
      break;
      appendDateType(paramStringBuilder, paramFieldType, i);
      break;
      appendCharType(paramStringBuilder, paramFieldType, i);
      break;
      appendByteType(paramStringBuilder, paramFieldType, i);
      break;
      appendByteArrayType(paramStringBuilder, paramFieldType, i);
      break;
      appendShortType(paramStringBuilder, paramFieldType, i);
      break;
      appendIntegerType(paramStringBuilder, paramFieldType, i);
      break;
      appendLongType(paramStringBuilder, paramFieldType, i);
      break;
      appendFloatType(paramStringBuilder, paramFieldType, i);
      break;
      appendDoubleType(paramStringBuilder, paramFieldType, i);
      break;
      appendSerializableType(paramStringBuilder, paramFieldType, i);
      break;
      appendBigDecimalNumericType(paramStringBuilder, paramFieldType, i);
      break;
      if ((paramFieldType.isGeneratedId()) && (!paramFieldType.isSelfGeneratedId()))
      {
        configureGeneratedId(paramString, paramStringBuilder, paramFieldType, paramList2, paramList3, paramList1, paramList4);
        break label206;
      }
      if (!paramFieldType.isId()) {
        break label206;
      }
      configureId(paramStringBuilder, paramFieldType, paramList2, paramList1, paramList4);
      break label206;
      label471:
      paramStringBuilder.append("NOT NULL ");
    }
  }
  
  public void appendCreateTableSuffix(StringBuilder paramStringBuilder) {}
  
  protected void appendDateType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("TIMESTAMP");
  }
  
  public void appendEscapedEntityName(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('`').append(paramString).append('`');
  }
  
  public void appendEscapedWord(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'').append(paramString).append('\'');
  }
  
  public void appendLimitValue(StringBuilder paramStringBuilder, long paramLong, Long paramLong1)
  {
    paramStringBuilder.append("LIMIT ").append(paramLong).append(' ');
  }
  
  protected void appendLongStringType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("TEXT");
  }
  
  protected void appendLongType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("BIGINT");
  }
  
  public void appendOffsetValue(StringBuilder paramStringBuilder, long paramLong)
  {
    paramStringBuilder.append("OFFSET ").append(paramLong).append(' ');
  }
  
  public void appendSelectNextValFromSequence(StringBuilder paramStringBuilder, String paramString) {}
  
  protected void appendSerializableType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("BLOB");
  }
  
  protected void appendShortType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    paramStringBuilder.append("SMALLINT");
  }
  
  protected void appendStringType(StringBuilder paramStringBuilder, FieldType paramFieldType, int paramInt)
  {
    if (isVarcharFieldWidthSupported())
    {
      paramStringBuilder.append("VARCHAR(").append(paramInt).append(")");
      return;
    }
    paramStringBuilder.append("VARCHAR");
  }
  
  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    throw new IllegalStateException("GeneratedId is not supported by database " + getDatabaseName() + " for field " + paramFieldType);
  }
  
  protected void configureGeneratedIdSequence(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3)
    throws SQLException
  {
    throw new SQLException("GeneratedIdSequence is not supported by database " + getDatabaseName() + " for field " + paramFieldType);
  }
  
  protected void configureId(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3) {}
  
  public void dropColumnArg(FieldType paramFieldType, List<String> paramList1, List<String> paramList2) {}
  
  public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return null;
  }
  
  public String generateIdSequenceName(String paramString, FieldType paramFieldType)
  {
    paramFieldType = paramString + DEFAULT_SEQUENCE_SUFFIX;
    paramString = paramFieldType;
    if (isEntityNamesMustBeUpCase()) {
      paramString = paramFieldType.toUpperCase();
    }
    return paramString;
  }
  
  protected boolean generatedIdSqlAtEnd()
  {
    return true;
  }
  
  public String getCommentLinePrefix()
  {
    return "-- ";
  }
  
  protected abstract String getDriverClassName();
  
  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    return paramDataPersister;
  }
  
  public String getPingStatement()
  {
    return "SELECT 1";
  }
  
  public boolean isAllowGeneratedIdInsertSupported()
  {
    return true;
  }
  
  public boolean isBatchUseTransaction()
  {
    return false;
  }
  
  public boolean isCreateIfNotExistsSupported()
  {
    return false;
  }
  
  public boolean isCreateIndexIfNotExistsSupported()
  {
    return isCreateIfNotExistsSupported();
  }
  
  public boolean isCreateTableReturnsNegative()
  {
    return false;
  }
  
  public boolean isCreateTableReturnsZero()
  {
    return true;
  }
  
  public boolean isEntityNamesMustBeUpCase()
  {
    return false;
  }
  
  public boolean isIdSequenceNeeded()
  {
    return false;
  }
  
  public boolean isLimitAfterSelect()
  {
    return false;
  }
  
  public boolean isLimitSqlSupported()
  {
    return true;
  }
  
  public boolean isNestedSavePointsSupported()
  {
    return true;
  }
  
  public boolean isOffsetLimitArgument()
  {
    return false;
  }
  
  public boolean isOffsetSqlSupported()
  {
    return true;
  }
  
  public boolean isSelectSequenceBeforeInsert()
  {
    return false;
  }
  
  public boolean isTruncateSupported()
  {
    return false;
  }
  
  public boolean isVarcharFieldWidthSupported()
  {
    return true;
  }
  
  public void loadDriver()
    throws SQLException
  {
    String str = getDriverClassName();
    if (str != null) {}
    try
    {
      Class.forName(str);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw SqlExceptionUtil.create("Driver class was not found for " + getDatabaseName() + " database.  Missing jar with class " + str + ".", localClassNotFoundException);
    }
  }
  
  public void setDriver(Driver paramDriver)
  {
    this.driver = paramDriver;
  }
  
  protected static class BooleanNumberFieldConverter
    extends BaseFieldConverter
  {
    public SqlType getSqlType()
    {
      return SqlType.BOOLEAN;
    }
    
    public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    {
      if (((Boolean)paramObject).booleanValue()) {
        return Byte.valueOf((byte)1);
      }
      return Byte.valueOf((byte)0);
    }
    
    public Object parseDefaultString(FieldType paramFieldType, String paramString)
    {
      if (Boolean.parseBoolean(paramString)) {
        return Byte.valueOf((byte)1);
      }
      return Byte.valueOf((byte)0);
    }
    
    public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt)
    {
      return sqlArgToJava(paramFieldType, Byte.valueOf(Byte.parseByte(paramString)), paramInt);
    }
    
    public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
      throws SQLException
    {
      return Byte.valueOf(paramDatabaseResults.getByte(paramInt));
    }
    
    public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    {
      if (((Byte)paramObject).byteValue() == 1) {
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/db/BaseDatabaseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */