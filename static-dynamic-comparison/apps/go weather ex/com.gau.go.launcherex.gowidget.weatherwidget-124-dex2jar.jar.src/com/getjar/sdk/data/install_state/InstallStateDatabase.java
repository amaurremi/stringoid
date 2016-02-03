package com.getjar.sdk.data.install_state;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.data.DatabaseRecordBase;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

abstract class InstallStateDatabase<T extends DatabaseRecordBase>
  extends SQLiteOpenHelper
{
  protected final Context _context;
  protected volatile Object _databaseAccessLock = new Object();
  
  public InstallStateDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this._context = paramContext;
  }
  
  private long getRecordCountInternal()
  {
    localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s", new Object[] { getTableName() }));
    try
    {
      long l = localSQLiteStatement.simpleQueryForLong();
      try
      {
        localSQLiteStatement.close();
        return l;
      }
      catch (Exception localException1)
      {
        Logger.e(Area.STORAGE.value(), localException1, "SQLiteStatement.close() failed", new Object[0]);
        return l;
      }
      try
      {
        localSQLiteStatement.close();
        throw ((Throwable)localObject);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Logger.e(Area.STORAGE.value(), localException2, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  private List<T> loadRecords(String paramString)
  {
    synchronized (this._databaseAccessLock)
    {
      localArrayList = new ArrayList(26);
      str = null;
      try
      {
        paramString = getReadableDatabase().query(getTableName(), null, null, null, null, null, null, paramString);
        for (;;)
        {
          str = paramString;
          if (!paramString.moveToNext()) {
            break;
          }
          str = paramString;
          localArrayList.add(loadFromDB(paramString));
        }
        try
        {
          str.close();
          throw paramString;
          paramString = finally;
          throw paramString;
          if (paramString != null) {}
          try
          {
            paramString.close();
            return localArrayList;
          }
          catch (Throwable paramString)
          {
            for (;;) {}
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
      finally
      {
        if (str == null) {}
      }
    }
  }
  
  protected boolean checkForRecord(long paramLong)
  {
    boolean bool = true;
    Object localObject1 = null;
    try
    {
      SQLiteStatement localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE id = ?", new Object[] { getTableName() }));
      localObject1 = localSQLiteStatement;
      localSQLiteStatement.bindLong(1, paramLong);
      localObject1 = localSQLiteStatement;
      paramLong = localSQLiteStatement.simpleQueryForLong();
      if (paramLong > 0L) {}
      for (;;)
      {
        if (localSQLiteStatement != null) {}
        try
        {
          localSQLiteStatement.close();
          return bool;
        }
        catch (Exception localException1)
        {
          Logger.e(Area.STORAGE.value(), localException1, "SQLiteStatement.close() failed", new Object[0]);
          return bool;
        }
        bool = false;
      }
      try
      {
        localException1.close();
        throw ((Throwable)localObject2);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Logger.e(Area.STORAGE.value(), localException2, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally
    {
      if (localException1 == null) {}
    }
  }
  
  protected void deleteAllRecords()
  {
    getWritableDatabase().delete(getTableName(), null, null);
  }
  
  public void deleteRecord(long paramLong)
  {
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().delete(getTableName(), String.format(Locale.US, "id = %1$d", new Object[] { Long.valueOf(paramLong) }), null);
      return;
    }
  }
  
  protected abstract int getLRUCap();
  
  public long getRecordCount()
  {
    synchronized (this._databaseAccessLock)
    {
      long l = getRecordCountInternal();
      return l;
    }
  }
  
  protected abstract String getTableCreateSQL();
  
  protected abstract String getTableName();
  
  public List<T> loadAllRecords()
  {
    return loadRecords(null);
  }
  
  protected abstract T loadFromDB(Cursor paramCursor);
  
  public List<T> loadRecords(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'Invalid 'limit' provided");
    }
    return loadRecords(Integer.toString(paramInt));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this._databaseAccessLock)
    {
      paramSQLiteDatabase.execSQL(getTableCreateSQL());
      return;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    synchronized (this._databaseAccessLock)
    {
      Logger.d(Area.STORAGE.value(), "Upgrading database from version %1$d to %2$d [deleting old data from table '%3$s']", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), getTableName() });
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTableName());
      paramSQLiteDatabase.execSQL(getTableCreateSQL());
      return;
    }
  }
  
  /* Error */
  public void trimLruEntries()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/getjar/sdk/data/install_state/InstallStateDatabase:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 196	com/getjar/sdk/data/install_state/InstallStateDatabase:getLRUCap	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifge +21 -> 36
    //   18: new 198	java/lang/IllegalStateException
    //   21: dup
    //   22: ldc -56
    //   24: invokespecial 201	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: astore 4
    //   30: aload 7
    //   32: monitorexit
    //   33: aload 4
    //   35: athrow
    //   36: aload_0
    //   37: invokespecial 143	com/getjar/sdk/data/install_state/InstallStateDatabase:getRecordCountInternal	()J
    //   40: iload_1
    //   41: i2l
    //   42: lcmp
    //   43: ifge +7 -> 50
    //   46: aload 7
    //   48: monitorexit
    //   49: return
    //   50: aconst_null
    //   51: astore 5
    //   53: aconst_null
    //   54: astore 4
    //   56: aload_0
    //   57: invokevirtual 31	com/getjar/sdk/data/install_state/InstallStateDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   60: aload_0
    //   61: invokevirtual 43	com/getjar/sdk/data/install_state/InstallStateDatabase:getTableName	()Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 45	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: ldc -53
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc -51
    //   79: invokevirtual 208	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 6
    //   84: aload 6
    //   86: astore 4
    //   88: aload 6
    //   90: iload_1
    //   91: invokeinterface 212 2 0
    //   96: ifeq +22 -> 118
    //   99: aload 6
    //   101: astore 4
    //   103: aload 6
    //   105: iconst_0
    //   106: invokeinterface 216 2 0
    //   111: lstore_2
    //   112: lload_2
    //   113: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: astore 5
    //   118: aload 6
    //   120: ifnull +10 -> 130
    //   123: aload 6
    //   125: invokeinterface 110 1 0
    //   130: aload_0
    //   131: invokevirtual 124	com/getjar/sdk/data/install_state/InstallStateDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   134: aload_0
    //   135: invokevirtual 43	com/getjar/sdk/data/install_state/InstallStateDatabase:getTableName	()Ljava/lang/String;
    //   138: getstatic 37	java/util/Locale:US	Ljava/util/Locale;
    //   141: ldc -38
    //   143: iconst_1
    //   144: anewarray 15	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload 5
    //   151: aastore
    //   152: invokestatic 49	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: aconst_null
    //   156: invokevirtual 128	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   159: istore_1
    //   160: iload_1
    //   161: ifle +42 -> 203
    //   164: getstatic 69	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   167: invokevirtual 72	com/getjar/sdk/logging/Area:value	()J
    //   170: ldc -36
    //   172: iconst_3
    //   173: anewarray 15	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 224	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: iload_1
    //   189: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: aload_0
    //   196: invokevirtual 43	com/getjar/sdk/data/install_state/InstallStateDatabase:getTableName	()Ljava/lang/String;
    //   199: aastore
    //   200: invokestatic 232	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   203: aload 7
    //   205: monitorexit
    //   206: return
    //   207: astore 5
    //   209: aload 4
    //   211: ifnull +10 -> 221
    //   214: aload 4
    //   216: invokeinterface 110 1 0
    //   221: aload 5
    //   223: athrow
    //   224: astore 4
    //   226: goto -96 -> 130
    //   229: astore 4
    //   231: goto -10 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	InstallStateDatabase
    //   13	176	1	i	int
    //   111	2	2	l	long
    //   28	6	4	localObject1	Object
    //   54	161	4	localObject2	Object
    //   224	1	4	localException1	Exception
    //   229	1	4	localException2	Exception
    //   51	99	5	localLong	Long
    //   207	15	5	localObject3	Object
    //   82	42	6	localCursor	Cursor
    //   4	200	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	28	finally
    //   18	28	28	finally
    //   30	33	28	finally
    //   36	49	28	finally
    //   123	130	28	finally
    //   130	160	28	finally
    //   164	203	28	finally
    //   203	206	28	finally
    //   214	221	28	finally
    //   221	224	28	finally
    //   56	84	207	finally
    //   88	99	207	finally
    //   103	112	207	finally
    //   123	130	224	java/lang/Exception
    //   214	221	229	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/InstallStateDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */