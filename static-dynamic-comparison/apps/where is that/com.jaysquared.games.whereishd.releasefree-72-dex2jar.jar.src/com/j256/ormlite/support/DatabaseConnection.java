package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import java.sql.SQLException;
import java.sql.Savepoint;

public abstract interface DatabaseConnection
{
  public static final int DEFAULT_RESULT_FLAGS = -1;
  public static final Object MORE_THAN_ONE = new Object();
  
  public abstract void close()
    throws SQLException;
  
  public abstract void closeQuietly();
  
  public abstract void commit(Savepoint paramSavepoint)
    throws SQLException;
  
  public abstract CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType)
    throws SQLException;
  
  public abstract CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt)
    throws SQLException;
  
  public abstract int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;
  
  public abstract int executeStatement(String paramString, int paramInt)
    throws SQLException;
  
  public abstract int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder)
    throws SQLException;
  
  public abstract boolean isAutoCommit()
    throws SQLException;
  
  public abstract boolean isAutoCommitSupported()
    throws SQLException;
  
  public abstract boolean isClosed()
    throws SQLException;
  
  public abstract boolean isTableExists(String paramString)
    throws SQLException;
  
  public abstract long queryForLong(String paramString)
    throws SQLException;
  
  public abstract long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;
  
  public abstract <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws SQLException;
  
  public abstract void rollback(Savepoint paramSavepoint)
    throws SQLException;
  
  public abstract void setAutoCommit(boolean paramBoolean)
    throws SQLException;
  
  public abstract Savepoint setSavePoint(String paramString)
    throws SQLException;
  
  public abstract int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws SQLException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/support/DatabaseConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */