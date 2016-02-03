package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.Savepoint;

public class AndroidDatabaseConnection
  implements DatabaseConnection
{
  private static final String ANDROID_VERSION = "VERSION__4.47__";
  private static final String[] NO_STRING_ARGS;
  private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
  private final SQLiteDatabase db;
  private final boolean readWrite;
  
  static
  {
    NO_STRING_ARGS = new String[0];
    VersionUtils.checkCoreVersusAndroidVersions("VERSION__4.47__");
  }
  
  public AndroidDatabaseConnection(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    this.db = paramSQLiteDatabase;
    this.readWrite = paramBoolean;
    logger.trace("{}: db {} opened, read-write = {}", this, paramSQLiteDatabase, Boolean.valueOf(paramBoolean));
  }
  
  private void bindArgs(SQLiteStatement paramSQLiteStatement, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    if (paramArrayOfObject == null) {
      return;
    }
    int i = 0;
    label8:
    Object localObject;
    if (i < paramArrayOfObject.length)
    {
      localObject = paramArrayOfObject[i];
      if (localObject != null) {
        break label43;
      }
      paramSQLiteStatement.bindNull(i + 1);
    }
    label43:
    SqlType localSqlType;
    for (;;)
    {
      i += 1;
      break label8;
      break;
      localSqlType = paramArrayOfFieldType[i].getSqlType();
      switch (localSqlType)
      {
      default: 
        throw new java.sql.SQLException("Unknown sql argument type: " + localSqlType);
      case ???: 
      case ???: 
      case ???: 
        paramSQLiteStatement.bindString(i + 1, localObject.toString());
        break;
      case ???: 
      case ???: 
      case ???: 
      case ???: 
      case ???: 
        paramSQLiteStatement.bindLong(i + 1, ((Number)localObject).longValue());
        break;
      case ???: 
      case ???: 
        paramSQLiteStatement.bindDouble(i + 1, ((Number)localObject).doubleValue());
        break;
      case ???: 
      case ???: 
        paramSQLiteStatement.bindBlob(i + 1, (byte[])localObject);
      }
    }
    throw new java.sql.SQLException("Invalid Android type: " + localSqlType);
  }
  
  private String[] toStrings(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      localObject = null;
    }
    String[] arrayOfString;
    int i;
    do
    {
      return (String[])localObject;
      arrayOfString = new String[paramArrayOfObject.length];
      i = 0;
      localObject = arrayOfString;
    } while (i >= paramArrayOfObject.length);
    Object localObject = paramArrayOfObject[i];
    if (localObject == null) {
      arrayOfString[i] = null;
    }
    for (;;)
    {
      i += 1;
      break;
      arrayOfString[i] = localObject.toString();
    }
  }
  
  private int update(String paramString1, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, String paramString2)
    throws java.sql.SQLException
  {
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      int j;
      int i;
      try
      {
        SQLiteStatement localSQLiteStatement = this.db.compileStatement(paramString1);
        localObject1 = localSQLiteStatement;
        localObject2 = localSQLiteStatement;
        bindArgs(localSQLiteStatement, paramArrayOfObject, paramArrayOfFieldType);
        localObject1 = localSQLiteStatement;
        localObject2 = localSQLiteStatement;
        localSQLiteStatement.execute();
        paramArrayOfObject = localSQLiteStatement;
        if (localSQLiteStatement != null)
        {
          localSQLiteStatement.close();
          paramArrayOfObject = null;
        }
        paramArrayOfFieldType = paramArrayOfObject;
      }
      catch (android.database.SQLException paramArrayOfObject)
      {
        long l;
        localObject2 = localObject1;
        throw SqlExceptionUtil.create("updating database failed: " + paramString1, paramArrayOfObject);
      }
      finally
      {
        if (localObject2 != null) {
          ((SQLiteStatement)localObject2).close();
        }
      }
      try
      {
        localObject1 = this.db.compileStatement("SELECT CHANGES()");
        paramArrayOfFieldType = (FieldType[])localObject1;
        paramArrayOfObject = (Object[])localObject1;
        l = ((SQLiteStatement)localObject1).simpleQueryForLong();
        j = (int)l;
        i = j;
        if (localObject1 != null)
        {
          ((SQLiteStatement)localObject1).close();
          i = j;
        }
      }
      catch (android.database.SQLException paramArrayOfObject)
      {
        j = 1;
        i = j;
        if (paramArrayOfFieldType == null) {
          continue;
        }
        paramArrayOfFieldType.close();
        i = j;
      }
      finally
      {
        if (paramArrayOfObject == null) {
          break label202;
        }
        paramArrayOfObject.close();
      }
    }
    logger.trace("{} statement is compiled and executed, changed {}: {}", paramString2, Integer.valueOf(i), paramString1);
    return i;
  }
  
  public void close()
    throws java.sql.SQLException
  {
    try
    {
      this.db.close();
      logger.trace("{}: db {} closed", this, this.db);
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems closing the database connection", localSQLException);
    }
  }
  
  public void closeQuietly()
  {
    try
    {
      close();
      return;
    }
    catch (java.sql.SQLException localSQLException) {}
  }
  
  public void commit(Savepoint paramSavepoint)
    throws java.sql.SQLException
  {
    try
    {
      this.db.setTransactionSuccessful();
      this.db.endTransaction();
      if (paramSavepoint == null)
      {
        logger.trace("{}: transaction is successfuly ended", this);
        return;
      }
      logger.trace("{}: transaction {} is successfuly ended", this, paramSavepoint.getSavepointName());
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      if (paramSavepoint == null) {
        throw SqlExceptionUtil.create("problems commiting transaction", localSQLException);
      }
      throw SqlExceptionUtil.create("problems commiting transaction " + paramSavepoint.getSavepointName(), localSQLException);
    }
  }
  
  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType)
  {
    paramStatementType = new AndroidCompiledStatement(paramString, this.db, paramStatementType);
    logger.trace("{}: compiled statement got {}: {}", this, paramStatementType, paramString);
    return paramStatementType;
  }
  
  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt)
  {
    return compileStatement(paramString, paramStatementType, paramArrayOfFieldType);
  }
  
  public int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "deleted");
  }
  
  public int executeStatement(String paramString, int paramInt)
    throws java.sql.SQLException
  {
    return AndroidCompiledStatement.execSql(this.db, paramString, paramString, NO_STRING_ARGS);
  }
  
  public int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder)
    throws java.sql.SQLException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteStatement localSQLiteStatement = this.db.compileStatement(paramString);
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      bindArgs(localSQLiteStatement, paramArrayOfObject, paramArrayOfFieldType);
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      long l = localSQLiteStatement.executeInsert();
      if (paramGeneratedKeyHolder != null)
      {
        localObject1 = localSQLiteStatement;
        localObject2 = localSQLiteStatement;
        paramGeneratedKeyHolder.addKey(Long.valueOf(l));
      }
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      logger.trace("{}: insert statement is compiled and executed, changed {}: {}", this, Integer.valueOf(1), paramString);
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      return 1;
    }
    catch (android.database.SQLException paramArrayOfObject)
    {
      localObject2 = localObject1;
      throw SqlExceptionUtil.create("inserting to database failed: " + paramString, paramArrayOfObject);
    }
    finally
    {
      if (localObject2 != null) {
        ((SQLiteStatement)localObject2).close();
      }
    }
  }
  
  public boolean isAutoCommit()
    throws java.sql.SQLException
  {
    try
    {
      boolean bool = this.db.inTransaction();
      logger.trace("{}: in transaction is {}", this, Boolean.valueOf(bool));
      return !bool;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems getting auto-commit from database", localSQLException);
    }
  }
  
  public boolean isAutoCommitSupported()
  {
    return true;
  }
  
  public boolean isClosed()
    throws java.sql.SQLException
  {
    try
    {
      boolean bool = this.db.isOpen();
      logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(bool));
      return !bool;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems detecting if the database is closed", localSQLException);
    }
  }
  
  public boolean isReadWrite()
  {
    return this.readWrite;
  }
  
  /* Error */
  public boolean isTableExists(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/j256/ormlite/android/AndroidDatabaseConnection:db	Landroid/database/sqlite/SQLiteDatabase;
    //   4: new 94	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 282
    //   14: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 284
    //   24: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: aconst_null
    //   31: invokevirtual 288	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_3
    //   35: aload_3
    //   36: invokeinterface 293 1 0
    //   41: ifle +28 -> 69
    //   44: iconst_1
    //   45: istore_2
    //   46: getstatic 33	com/j256/ormlite/android/AndroidDatabaseConnection:logger	Lcom/j256/ormlite/logger/Logger;
    //   49: ldc_w 295
    //   52: aload_0
    //   53: aload_1
    //   54: iload_2
    //   55: invokestatic 60	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: invokevirtual 66	com/j256/ormlite/logger/Logger:trace	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   61: aload_3
    //   62: invokeinterface 296 1 0
    //   67: iload_2
    //   68: ireturn
    //   69: iconst_0
    //   70: istore_2
    //   71: goto -25 -> 46
    //   74: astore_1
    //   75: aload_3
    //   76: invokeinterface 296 1 0
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	AndroidDatabaseConnection
    //   0	83	1	paramString	String
    //   45	26	2	bool	boolean
    //   34	42	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   35	44	74	finally
    //   46	61	74	finally
  }
  
  public long queryForLong(String paramString)
    throws java.sql.SQLException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteStatement localSQLiteStatement = this.db.compileStatement(paramString);
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      long l = localSQLiteStatement.simpleQueryForLong();
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(l), paramString);
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      return l;
    }
    catch (android.database.SQLException localSQLException)
    {
      localObject2 = localObject1;
      throw SqlExceptionUtil.create("queryForLong from database failed: " + paramString, localSQLException);
    }
    finally
    {
      if (localObject2 != null) {
        ((SQLiteStatement)localObject2).close();
      }
    }
  }
  
  /* Error */
  public long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 50	com/j256/ormlite/android/AndroidDatabaseConnection:db	Landroid/database/sqlite/SQLiteDatabase;
    //   9: aload_1
    //   10: aload_0
    //   11: aload_2
    //   12: invokespecial 305	com/j256/ormlite/android/AndroidDatabaseConnection:toStrings	([Ljava/lang/Object;)[Ljava/lang/String;
    //   15: invokevirtual 288	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_3
    //   21: aload_2
    //   22: astore 6
    //   24: new 307	com/j256/ormlite/android/AndroidDatabaseResults
    //   27: dup
    //   28: aload_2
    //   29: aconst_null
    //   30: invokespecial 310	com/j256/ormlite/android/AndroidDatabaseResults:<init>	(Landroid/database/Cursor;Lcom/j256/ormlite/dao/ObjectCache;)V
    //   33: astore 7
    //   35: aload_2
    //   36: astore_3
    //   37: aload_2
    //   38: astore 6
    //   40: aload 7
    //   42: invokevirtual 313	com/j256/ormlite/android/AndroidDatabaseResults:first	()Z
    //   45: ifeq +50 -> 95
    //   48: aload_2
    //   49: astore_3
    //   50: aload_2
    //   51: astore 6
    //   53: aload 7
    //   55: iconst_0
    //   56: invokevirtual 317	com/j256/ormlite/android/AndroidDatabaseResults:getLong	(I)J
    //   59: lstore 4
    //   61: aload_2
    //   62: astore_3
    //   63: aload_2
    //   64: astore 6
    //   66: getstatic 33	com/j256/ormlite/android/AndroidDatabaseConnection:logger	Lcom/j256/ormlite/logger/Logger;
    //   69: ldc_w 319
    //   72: aload_0
    //   73: lload 4
    //   75: invokestatic 249	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   78: aload_1
    //   79: invokevirtual 66	com/j256/ormlite/logger/Logger:trace	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   82: aload_2
    //   83: ifnull +9 -> 92
    //   86: aload_2
    //   87: invokeinterface 296 1 0
    //   92: lload 4
    //   94: lreturn
    //   95: lconst_0
    //   96: lstore 4
    //   98: goto -37 -> 61
    //   101: astore_2
    //   102: aload_3
    //   103: astore 6
    //   105: new 94	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 302
    //   115: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_2
    //   126: invokestatic 182	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   129: athrow
    //   130: astore_1
    //   131: aload 6
    //   133: ifnull +10 -> 143
    //   136: aload 6
    //   138: invokeinterface 296 1 0
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	AndroidDatabaseConnection
    //   0	145	1	paramString	String
    //   0	145	2	paramArrayOfObject	Object[]
    //   0	145	3	paramArrayOfFieldType	FieldType[]
    //   59	38	4	l	long
    //   1	136	6	localObject	Object
    //   33	21	7	localAndroidDatabaseResults	AndroidDatabaseResults
    // Exception table:
    //   from	to	target	type
    //   5	19	101	android/database/SQLException
    //   24	35	101	android/database/SQLException
    //   40	48	101	android/database/SQLException
    //   53	61	101	android/database/SQLException
    //   66	82	101	android/database/SQLException
    //   5	19	130	finally
    //   24	35	130	finally
    //   40	48	130	finally
    //   53	61	130	finally
    //   66	82	130	finally
    //   105	130	130	finally
  }
  
  public <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache)
    throws java.sql.SQLException
  {
    Object localObject = null;
    paramArrayOfFieldType = null;
    try
    {
      paramArrayOfObject = this.db.rawQuery(paramString, toStrings(paramArrayOfObject));
      paramArrayOfFieldType = paramArrayOfObject;
      localObject = paramArrayOfObject;
      paramObjectCache = new AndroidDatabaseResults(paramArrayOfObject, paramObjectCache);
      paramArrayOfFieldType = paramArrayOfObject;
      localObject = paramArrayOfObject;
      logger.trace("{}: queried for one result: {}", this, paramString);
      paramArrayOfFieldType = paramArrayOfObject;
      localObject = paramArrayOfObject;
      boolean bool = paramObjectCache.first();
      if (!bool)
      {
        paramArrayOfFieldType = null;
        paramString = paramArrayOfFieldType;
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject.close();
          paramString = paramArrayOfFieldType;
        }
      }
      do
      {
        do
        {
          return paramString;
          paramArrayOfFieldType = paramArrayOfObject;
          localObject = paramArrayOfObject;
          paramGenericRowMapper = paramGenericRowMapper.mapRow(paramObjectCache);
          paramArrayOfFieldType = paramArrayOfObject;
          localObject = paramArrayOfObject;
          if (!paramObjectCache.next()) {
            break;
          }
          paramArrayOfFieldType = paramArrayOfObject;
          localObject = paramArrayOfObject;
          paramGenericRowMapper = MORE_THAN_ONE;
          paramString = paramGenericRowMapper;
        } while (paramArrayOfObject == null);
        paramArrayOfObject.close();
        return paramGenericRowMapper;
        paramString = paramGenericRowMapper;
      } while (paramArrayOfObject == null);
      paramArrayOfObject.close();
      return paramGenericRowMapper;
    }
    catch (android.database.SQLException paramArrayOfObject)
    {
      localObject = paramArrayOfFieldType;
      throw SqlExceptionUtil.create("queryForOne from database failed: " + paramString, paramArrayOfObject);
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
    }
  }
  
  public void rollback(Savepoint paramSavepoint)
    throws java.sql.SQLException
  {
    try
    {
      this.db.endTransaction();
      if (paramSavepoint == null)
      {
        logger.trace("{}: transaction is ended, unsuccessfuly", this);
        return;
      }
      logger.trace("{}: transaction {} is ended, unsuccessfuly", this, paramSavepoint.getSavepointName());
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      if (paramSavepoint == null) {
        throw SqlExceptionUtil.create("problems rolling back transaction", localSQLException);
      }
      throw SqlExceptionUtil.create("problems rolling back transaction " + paramSavepoint.getSavepointName(), localSQLException);
    }
  }
  
  public void setAutoCommit(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.db.inTransaction())
      {
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
      }
    }
    while (this.db.inTransaction()) {
      return;
    }
    this.db.beginTransaction();
  }
  
  public Savepoint setSavePoint(String paramString)
    throws java.sql.SQLException
  {
    try
    {
      this.db.beginTransaction();
      logger.trace("{}: save-point set with name {}", this, paramString);
      OurSavePoint localOurSavePoint = new OurSavePoint(paramString);
      return localOurSavePoint;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("problems beginning transaction " + paramString, localSQLException);
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
  }
  
  public int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType)
    throws java.sql.SQLException
  {
    return update(paramString, paramArrayOfObject, paramArrayOfFieldType, "updated");
  }
  
  private static class OurSavePoint
    implements Savepoint
  {
    private String name;
    
    public OurSavePoint(String paramString)
    {
      this.name = paramString;
    }
    
    public int getSavepointId()
    {
      return 0;
    }
    
    public String getSavepointName()
    {
      return this.name;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/AndroidDatabaseConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */