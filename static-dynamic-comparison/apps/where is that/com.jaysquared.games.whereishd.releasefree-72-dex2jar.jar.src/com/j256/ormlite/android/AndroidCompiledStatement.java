package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.util.ArrayList;
import java.util.List;

public class AndroidCompiledStatement
  implements CompiledStatement
{
  private static final String[] NO_STRING_ARGS = new String[0];
  private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
  private List<Object> args;
  private Cursor cursor;
  private final SQLiteDatabase db;
  private Integer max;
  private final String sql;
  private final StatementBuilder.StatementType type;
  
  public AndroidCompiledStatement(String paramString, SQLiteDatabase paramSQLiteDatabase, StatementBuilder.StatementType paramStatementType)
  {
    this.sql = paramString;
    this.db = paramSQLiteDatabase;
    this.type = paramStatementType;
  }
  
  static int execSql(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws java.sql.SQLException
  {
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      int j;
      int i;
      try
      {
        paramSQLiteDatabase.execSQL(paramString2, paramArrayOfObject);
        localSQLiteDatabase = null;
        paramArrayOfObject = null;
      }
      catch (android.database.SQLException paramSQLiteDatabase)
      {
        long l;
        throw SqlExceptionUtil.create("Problems executing " + paramString1 + " Android statement: " + paramString2, paramSQLiteDatabase);
      }
      label136:
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.compileStatement("SELECT CHANGES()");
        paramArrayOfObject = paramSQLiteDatabase;
        localSQLiteDatabase = paramSQLiteDatabase;
        l = paramSQLiteDatabase.simpleQueryForLong();
        j = (int)l;
        i = j;
        if (paramSQLiteDatabase != null)
        {
          paramSQLiteDatabase.close();
          i = j;
        }
      }
      catch (android.database.SQLException paramSQLiteDatabase)
      {
        j = 1;
        i = j;
        if (paramArrayOfObject == null) {
          continue;
        }
        paramArrayOfObject.close();
        i = j;
      }
      finally
      {
        if (localSQLiteDatabase == null) {
          break label136;
        }
        localSQLiteDatabase.close();
      }
    }
    logger.trace("executing statement {} changed {} rows: {}", paramString1, Integer.valueOf(i), paramString2);
    return i;
  }
  
  private Object[] getArgArray()
  {
    if (this.args == null) {
      return NO_STRING_ARGS;
    }
    return this.args.toArray(new Object[this.args.size()]);
  }
  
  private String[] getStringArray()
  {
    if (this.args == null) {
      return NO_STRING_ARGS;
    }
    return (String[])this.args.toArray(new String[this.args.size()]);
  }
  
  private void isInPrep()
    throws java.sql.SQLException
  {
    if (this.cursor != null) {
      throw new java.sql.SQLException("Query already run. Cannot add argument values.");
    }
  }
  
  public void close()
    throws java.sql.SQLException
  {
    if (this.cursor != null) {}
    try
    {
      this.cursor.close();
      return;
    }
    catch (android.database.SQLException localSQLException)
    {
      throw SqlExceptionUtil.create("Problems closing Android cursor", localSQLException);
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
  
  public int getColumnCount()
    throws java.sql.SQLException
  {
    return getCursor().getColumnCount();
  }
  
  public String getColumnName(int paramInt)
    throws java.sql.SQLException
  {
    return getCursor().getColumnName(paramInt);
  }
  
  /* Error */
  public Cursor getCursor()
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/j256/ormlite/android/AndroidCompiledStatement:cursor	Landroid/database/Cursor;
    //   4: ifnonnull +63 -> 67
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 158	com/j256/ormlite/android/AndroidCompiledStatement:max	Ljava/lang/Integer;
    //   15: ifnonnull +57 -> 72
    //   18: aload_1
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 46	com/j256/ormlite/android/AndroidCompiledStatement:sql	Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: astore_2
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 48	com/j256/ormlite/android/AndroidCompiledStatement:db	Landroid/database/sqlite/SQLiteDatabase;
    //   32: aload_1
    //   33: aload_0
    //   34: invokespecial 160	com/j256/ormlite/android/AndroidCompiledStatement:getStringArray	()[Ljava/lang/String;
    //   37: invokevirtual 164	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   40: putfield 133	com/j256/ormlite/android/AndroidCompiledStatement:cursor	Landroid/database/Cursor;
    //   43: aload_1
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 133	com/j256/ormlite/android/AndroidCompiledStatement:cursor	Landroid/database/Cursor;
    //   49: invokeinterface 168 1 0
    //   54: pop
    //   55: aload_1
    //   56: astore_2
    //   57: getstatic 35	com/j256/ormlite/android/AndroidCompiledStatement:logger	Lcom/j256/ormlite/logger/Logger;
    //   60: ldc -86
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 173	com/j256/ormlite/logger/Logger:trace	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield 133	com/j256/ormlite/android/AndroidCompiledStatement:cursor	Landroid/database/Cursor;
    //   71: areturn
    //   72: aload_1
    //   73: astore_2
    //   74: new 93	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   81: aload_0
    //   82: getfield 46	com/j256/ormlite/android/AndroidCompiledStatement:sql	Ljava/lang/String;
    //   85: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc -81
    //   90: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 158	com/j256/ormlite/android/AndroidCompiledStatement:max	Ljava/lang/Integer;
    //   97: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_1
    //   104: goto -79 -> 25
    //   107: astore_1
    //   108: new 93	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   115: ldc -76
    //   117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_2
    //   121: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload_1
    //   128: invokestatic 112	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	AndroidCompiledStatement
    //   8	96	1	str1	String
    //   107	21	1	localSQLException	android.database.SQLException
    //   10	111	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   11	18	107	android/database/SQLException
    //   20	25	107	android/database/SQLException
    //   27	43	107	android/database/SQLException
    //   45	55	107	android/database/SQLException
    //   57	67	107	android/database/SQLException
    //   74	104	107	android/database/SQLException
  }
  
  public int runExecute()
    throws java.sql.SQLException
  {
    if (!this.type.isOkForExecute()) {
      throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
    }
    return execSql(this.db, "runExecute", this.sql, getArgArray());
  }
  
  public DatabaseResults runQuery(ObjectCache paramObjectCache)
    throws java.sql.SQLException
  {
    if (!this.type.isOkForQuery()) {
      throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
    }
    return new AndroidDatabaseResults(getCursor(), paramObjectCache);
  }
  
  public int runUpdate()
    throws java.sql.SQLException
  {
    if (!this.type.isOkForUpdate()) {
      throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
    }
    if (this.max == null) {}
    for (String str = this.sql;; str = this.sql + " " + this.max) {
      return execSql(this.db, "runUpdate", str, getArgArray());
    }
  }
  
  public void setMaxRows(int paramInt)
    throws java.sql.SQLException
  {
    isInPrep();
    this.max = Integer.valueOf(paramInt);
  }
  
  public void setObject(int paramInt, Object paramObject, SqlType paramSqlType)
    throws java.sql.SQLException
  {
    isInPrep();
    if (this.args == null) {
      this.args = new ArrayList();
    }
    if (paramObject == null)
    {
      this.args.add(paramInt, null);
      return;
    }
    switch (paramSqlType)
    {
    default: 
      throw new java.sql.SQLException("Unknown sql argument type: " + paramSqlType);
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      this.args.add(paramInt, paramObject.toString());
      return;
    case ???: 
    case ???: 
      this.args.add(paramInt, paramObject);
      return;
    }
    throw new java.sql.SQLException("Invalid Android type: " + paramSqlType);
  }
  
  public void setQueryTimeout(long paramLong) {}
  
  public String toString()
  {
    return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/AndroidCompiledStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */