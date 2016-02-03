package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class OrmLiteSqliteOpenHelper
  extends SQLiteOpenHelper
{
  protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
  protected AndroidConnectionSource connectionSource = new AndroidConnectionSource(this);
  private volatile boolean isOpen = true;
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    logger.trace("{}: constructed connectionSource {}", this, this.connectionSource);
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt1, openFileId(paramContext, paramInt2));
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, File paramFile)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, openFile(paramFile));
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, InputStream paramInputStream)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    if (paramInputStream == null) {
      return;
    }
    try
    {
      DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(new BufferedReader(new InputStreamReader(paramInputStream), 4096)));
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramContext)
      {
        return;
      }
      try
      {
        paramInputStream.close();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
    }
    catch (SQLException paramContext)
    {
      paramContext = paramContext;
      throw new IllegalStateException("Could not load object config file", paramContext);
    }
    finally {}
  }
  
  private static InputStream openFile(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      return localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      throw new IllegalArgumentException("Could not open config file " + paramFile, localFileNotFoundException);
    }
  }
  
  private static InputStream openFileId(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().openRawResource(paramInt);
    if (paramContext == null) {
      throw new IllegalStateException("Could not find object config file with id " + paramInt);
    }
    return paramContext;
  }
  
  public void close()
  {
    super.close();
    this.connectionSource.close();
    this.isOpen = false;
  }
  
  public ConnectionSource getConnectionSource()
  {
    if (!this.isOpen) {
      logger.warn(new IllegalStateException(), "Getting connectionSource was called after closed");
    }
    return this.connectionSource;
  }
  
  public <D extends Dao<T, ?>, T> D getDao(Class<T> paramClass)
    throws SQLException
  {
    return DaoManager.createDao(getConnectionSource(), paramClass);
  }
  
  public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> paramClass)
  {
    try
    {
      RuntimeExceptionDao localRuntimeExceptionDao = new RuntimeExceptionDao(getDao(paramClass));
      return localRuntimeExceptionDao;
    }
    catch (SQLException localSQLException)
    {
      throw new RuntimeException("Could not create RuntimeExcepitionDao for class " + paramClass, localSQLException);
    }
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  /* Error */
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 155	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:getConnectionSource	()Lcom/j256/ormlite/support/ConnectionSource;
    //   4: astore 5
    //   6: aload 5
    //   8: invokeinterface 186 1 0
    //   13: astore 4
    //   15: iconst_0
    //   16: istore_2
    //   17: aload 4
    //   19: astore_3
    //   20: aload 4
    //   22: ifnonnull +24 -> 46
    //   25: new 188	com/j256/ormlite/android/AndroidDatabaseConnection
    //   28: dup
    //   29: aload_1
    //   30: iconst_1
    //   31: invokespecial 191	com/j256/ormlite/android/AndroidDatabaseConnection:<init>	(Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   34: astore_3
    //   35: aload 5
    //   37: aload_3
    //   38: invokeinterface 195 2 0
    //   43: pop
    //   44: iconst_1
    //   45: istore_2
    //   46: aload_0
    //   47: aload_1
    //   48: aload 5
    //   50: invokevirtual 198	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:onCreate	(Landroid/database/sqlite/SQLiteDatabase;Lcom/j256/ormlite/support/ConnectionSource;)V
    //   53: iload_2
    //   54: ifeq +11 -> 65
    //   57: aload 5
    //   59: aload_3
    //   60: invokeinterface 202 2 0
    //   65: return
    //   66: astore_1
    //   67: new 88	java/lang/IllegalStateException
    //   70: dup
    //   71: ldc -52
    //   73: aload_1
    //   74: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: astore_1
    //   79: iload_2
    //   80: ifeq +11 -> 91
    //   83: aload 5
    //   85: aload_3
    //   86: invokeinterface 202 2 0
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	OrmLiteSqliteOpenHelper
    //   0	93	1	paramSQLiteDatabase	SQLiteDatabase
    //   16	64	2	i	int
    //   19	67	3	localObject	Object
    //   13	8	4	localDatabaseConnection	com.j256.ormlite.support.DatabaseConnection
    //   4	80	5	localConnectionSource	ConnectionSource
    // Exception table:
    //   from	to	target	type
    //   35	44	66	java/sql/SQLException
    //   46	53	78	finally
  }
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource);
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 155	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:getConnectionSource	()Lcom/j256/ormlite/support/ConnectionSource;
    //   4: astore 7
    //   6: aload 7
    //   8: invokeinterface 186 1 0
    //   13: astore 6
    //   15: iconst_0
    //   16: istore 4
    //   18: aload 6
    //   20: astore 5
    //   22: aload 6
    //   24: ifnonnull +27 -> 51
    //   27: new 188	com/j256/ormlite/android/AndroidDatabaseConnection
    //   30: dup
    //   31: aload_1
    //   32: iconst_1
    //   33: invokespecial 191	com/j256/ormlite/android/AndroidDatabaseConnection:<init>	(Landroid/database/sqlite/SQLiteDatabase;Z)V
    //   36: astore 5
    //   38: aload 7
    //   40: aload 5
    //   42: invokeinterface 195 2 0
    //   47: pop
    //   48: iconst_1
    //   49: istore 4
    //   51: aload_0
    //   52: aload_1
    //   53: aload 7
    //   55: iload_2
    //   56: iload_3
    //   57: invokevirtual 209	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper:onUpgrade	(Landroid/database/sqlite/SQLiteDatabase;Lcom/j256/ormlite/support/ConnectionSource;II)V
    //   60: iload 4
    //   62: ifeq +12 -> 74
    //   65: aload 7
    //   67: aload 5
    //   69: invokeinterface 202 2 0
    //   74: return
    //   75: astore_1
    //   76: new 88	java/lang/IllegalStateException
    //   79: dup
    //   80: ldc -52
    //   82: aload_1
    //   83: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_1
    //   88: iload 4
    //   90: ifeq +12 -> 102
    //   93: aload 7
    //   95: aload 5
    //   97: invokeinterface 202 2 0
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	OrmLiteSqliteOpenHelper
    //   0	104	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	104	2	paramInt1	int
    //   0	104	3	paramInt2	int
    //   16	73	4	i	int
    //   20	76	5	localObject	Object
    //   13	10	6	localDatabaseConnection	com.j256.ormlite.support.DatabaseConnection
    //   4	90	7	localConnectionSource	ConnectionSource
    // Exception table:
    //   from	to	target	type
    //   38	48	75	java/sql/SQLException
    //   51	60	87	finally
  }
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2);
  
  public String toString()
  {
    return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */