package com.getjar.sdk.data.usage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class UsageDatabase
  extends SQLiteOpenHelper
{
  private static final String DATABASE_CREATE_TABLE_APP_SESSIONS = "CREATE TABLE IF NOT EXISTS appSessions (id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT NOT NULL, timestamp INTEGER NOT NULL, duration INTEGER NOT NULL, reason TEXT, phoneSessionId TEXT NOT NULL, synced INTEGER NOT NULL DEFAULT 0, finalized INTEGER NOT NULL DEFAULT 0);";
  private static final String DATABASE_NAME = "GetJarDBUsage";
  private static final String DATABASE_TABLE_APP_SESSIONS = "appSessions";
  private static final int DATABASE_VERSION = 5;
  private static final String[] DB_CREATE_TABLE_COMMANDS = { "CREATE TABLE IF NOT EXISTS appSessions (id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT NOT NULL, timestamp INTEGER NOT NULL, duration INTEGER NOT NULL, reason TEXT, phoneSessionId TEXT NOT NULL, synced INTEGER NOT NULL DEFAULT 0, finalized INTEGER NOT NULL DEFAULT 0);" };
  private static final String[] DB_TABLE_NAMES;
  public static final String EmptyUUID = "00000000-0000-0000-0000-000000000000";
  public static final int LRUCap = 2500;
  private static volatile UsageDatabase _Instance = null;
  private volatile Object _databaseAccessLock = new Object();
  
  static
  {
    DB_TABLE_NAMES = new String[] { "appSessions" };
  }
  
  private UsageDatabase(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 5);
    Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "UsageDatabase: Opened database '%1$s'", new Object[] { "GetJarDBUsage" });
  }
  
  private boolean checkForRecord(String paramString, long paramLong)
  {
    boolean bool = true;
    str = null;
    try
    {
      paramString = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE id = ?", new Object[] { paramString }));
      str = paramString;
      paramString.bindLong(1, paramLong);
      str = paramString;
      paramLong = paramString.simpleQueryForLong();
      if (paramLong > 0L) {}
      for (;;)
      {
        if (paramString != null) {}
        try
        {
          paramString.close();
          return bool;
        }
        catch (Exception paramString)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), paramString, "SQLiteStatement.close() failed", new Object[0]);
          return bool;
        }
        bool = false;
      }
      try
      {
        str.close();
        throw paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally
    {
      if (str == null) {}
    }
  }
  
  private void deleteAllRecords()
  {
    getWritableDatabase().delete("appSessions", null, null);
  }
  
  public static UsageDatabase getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' can not be NULL");
      }
      finally {}
    }
    if (_Instance == null) {
      _Instance = new UsageDatabase(paramContext, "GetJarDBUsage");
    }
    paramContext = _Instance;
    return paramContext;
  }
  
  protected static String getNewApplicationSessionID()
  {
    return UUID.randomUUID().toString();
  }
  
  protected static String getNewPhoneSessionID()
  {
    return UUID.randomUUID().toString();
  }
  
  private long getRecordCount(String paramString)
  {
    localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s", new Object[] { paramString }));
    try
    {
      long l = localSQLiteStatement.simpleQueryForLong();
      try
      {
        localSQLiteStatement.close();
        return l;
      }
      catch (Exception paramString)
      {
        Logger.e(Area.USAGE.value() | Area.STORAGE.value(), paramString, "SQLiteStatement.close() failed", new Object[0]);
        return l;
      }
      try
      {
        localSQLiteStatement.close();
        throw paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  private void setRecordAsSynced(String paramString, long paramLong)
  {
    if (checkForRecord(paramString, paramLong))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("synced", Integer.valueOf(1));
      getWritableDatabase().update(paramString, localContentValues, String.format(Locale.US, "id = %1$d", new Object[] { Long.valueOf(paramLong) }), null);
      return;
    }
    Logger.w(Area.USAGE.value() | Area.STORAGE.value(), "Usage: UsageDatabase: setRecordAsSynced() failed to find record %1$d", new Object[] { Long.valueOf(paramLong) });
  }
  
  /* Error */
  private void trimLruEntries(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +13 -> 14
    //   4: new 128	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc -66
    //   10: invokespecial 133	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 192	com/getjar/sdk/data/usage/UsageDatabase:getRecordCount	(Ljava/lang/String;)J
    //   19: iload_2
    //   20: i2l
    //   21: lcmp
    //   22: ifge +4 -> 26
    //   25: return
    //   26: aconst_null
    //   27: astore 6
    //   29: aconst_null
    //   30: astore 5
    //   32: aload_0
    //   33: invokevirtual 80	com/getjar/sdk/data/usage/UsageDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: aload_1
    //   37: iconst_1
    //   38: anewarray 35	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc -62
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc -60
    //   52: invokevirtual 200	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 7
    //   57: aload 7
    //   59: astore 5
    //   61: aload 7
    //   63: iload_2
    //   64: invokeinterface 206 2 0
    //   69: ifeq +22 -> 91
    //   72: aload 7
    //   74: astore 5
    //   76: aload 7
    //   78: iconst_0
    //   79: invokeinterface 210 2 0
    //   84: lstore_3
    //   85: lload_3
    //   86: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: astore 6
    //   91: aload 7
    //   93: ifnull +10 -> 103
    //   96: aload 7
    //   98: invokeinterface 211 1 0
    //   103: aload_0
    //   104: invokevirtual 120	com/getjar/sdk/data/usage/UsageDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   107: aload_1
    //   108: getstatic 86	java/util/Locale:US	Ljava/util/Locale;
    //   111: ldc -43
    //   113: iconst_1
    //   114: anewarray 47	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload 6
    //   121: aastore
    //   122: invokestatic 92	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: aconst_null
    //   126: invokevirtual 124	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   129: istore_2
    //   130: iload_2
    //   131: ifle -106 -> 25
    //   134: getstatic 57	com/getjar/sdk/logging/Area:USAGE	Lcom/getjar/sdk/logging/Area;
    //   137: invokevirtual 61	com/getjar/sdk/logging/Area:value	()J
    //   140: getstatic 64	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   143: invokevirtual 61	com/getjar/sdk/logging/Area:value	()J
    //   146: lor
    //   147: ldc -41
    //   149: iconst_2
    //   150: anewarray 47	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iload_2
    //   156: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload_1
    //   163: aastore
    //   164: invokestatic 218	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   167: return
    //   168: astore_1
    //   169: aload 5
    //   171: ifnull +10 -> 181
    //   174: aload 5
    //   176: invokeinterface 211 1 0
    //   181: aload_1
    //   182: athrow
    //   183: astore 5
    //   185: goto -82 -> 103
    //   188: astore 5
    //   190: goto -9 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	UsageDatabase
    //   0	193	1	paramString	String
    //   0	193	2	paramInt	int
    //   84	2	3	l	long
    //   30	145	5	localObject	Object
    //   183	1	5	localException1	Exception
    //   188	1	5	localException2	Exception
    //   27	93	6	localLong	Long
    //   55	42	7	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   32	57	168	finally
    //   61	72	168	finally
    //   76	85	168	finally
    //   96	103	183	java/lang/Exception
    //   174	181	188	java/lang/Exception
  }
  
  public long appSessionGetRecordCount()
  {
    synchronized (this._databaseAccessLock)
    {
      long l = getRecordCount("appSessions");
      return l;
    }
  }
  
  public List<ApplicationSessionEvent> appSessionLoadUnsynced()
  {
    synchronized (this._databaseAccessLock)
    {
      localArrayList = new ArrayList();
      localObject1 = null;
      try
      {
        Cursor localCursor = getReadableDatabase().query("appSessions", null, "synced = 0 AND finalized = 1", null, null, null, null);
        for (;;)
        {
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localArrayList.add(ApplicationSessionEvent.loadFromDB(localCursor));
        }
        try
        {
          ((Cursor)localObject1).close();
          throw ((Throwable)localObject3);
          localObject2 = finally;
          throw ((Throwable)localObject2);
          if (localObject3 != null) {}
          try
          {
            ((Cursor)localObject3).close();
            return localArrayList;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException1, "Usage: UsageDatabase: appSessionLoadUnsynced() failed", new Object[0]);
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException2, "Usage: UsageDatabase: appSessionLoadUnsynced() failed", new Object[0]);
          }
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
  }
  
  protected void appSessionSetAsSynced(long paramLong)
  {
    synchronized (this._databaseAccessLock)
    {
      setRecordAsSynced("appSessions", paramLong);
      return;
    }
  }
  
  protected void deleteAppSession(long paramLong)
  {
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().delete("appSessions", String.format(Locale.US, "id = %1$d", new Object[] { Long.valueOf(paramLong) }), null);
      return;
    }
  }
  
  protected List<AggregateUsageRecord> getAggregateSessions(long paramLong)
  {
    localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = null;
    Cursor localCursor = null;
    localObject1 = localSQLiteDatabase;
    try
    {
      Object localObject4 = this._databaseAccessLock;
      localObject1 = localSQLiteDatabase;
      localObject1 = localCursor;
      try
      {
        localSQLiteDatabase = getReadableDatabase();
        localObject1 = localCursor;
        String str = String.format(Locale.US, "timestamp > %d AND timestamp < %d", new Object[] { Long.valueOf(l - paramLong), Long.valueOf(l) });
        localObject1 = localCursor;
        localCursor = localSQLiteDatabase.query(true, "appSessions", new String[] { "packageName", "MIN(timestamp)", "MAX(timestamp+duration)", "SUM(duration)", "COUNT(*)" }, str, null, "packageName", null, null, null);
        for (;;)
        {
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localArrayList.add(new AggregateUsageRecord(localCursor.getString(0), localCursor.getLong(1), localCursor.getLong(2), localCursor.getInt(3), localCursor.getInt(4)));
        }
        localObject3 = finally;
      }
      finally {}
      try
      {
        ((Cursor)localObject1).close();
        throw ((Throwable)localObject3);
        localObject1 = localObject3;
        if (localObject3 != null) {}
        try
        {
          ((Cursor)localObject3).close();
          return localArrayList;
        }
        catch (Exception localException1)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException1, "Usage: UsageDatabase:  getAggregateSessions failed", new Object[0]);
          return localArrayList;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), localException2, "Usage: UsageDatabase:  getAggregateSessions failed", new Object[0]);
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  protected long getAppTotalDuration(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'currentPhoneSessionId' cannot be NULL or empty");
    }
    paramString2 = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT SUM(duration) FROM %s WHERE packageName='%s' AND timestamp > %d AND timestamp < %d AND phoneSessionId <> '%s'", new Object[] { "appSessions", paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 }));
    try
    {
      paramLong1 = paramString2.simpleQueryForLong();
      try
      {
        paramString2.close();
        return paramLong1;
      }
      catch (Exception paramString1)
      {
        Logger.e(Area.USAGE.value() | Area.STORAGE.value(), paramString1, "SQLiteStatement.close() failed", new Object[0]);
        return paramLong1;
      }
      try
      {
        paramString2.close();
        throw paramString1;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Logger.e(Area.USAGE.value() | Area.STORAGE.value(), paramString2, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  protected long insertAppSession(String arg1, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    if (StringUtility.isNullOrEmpty(???)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'phoneSessionId' cannot be NULL or empty");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("packageName", ???);
    localContentValues.put("timestamp", Long.valueOf(paramLong1));
    localContentValues.put("duration", Long.valueOf(paramLong2));
    localContentValues.put("reason", paramString2);
    localContentValues.put("phoneSessionId", paramString3);
    localContentValues.put("synced", Integer.valueOf(0));
    localContentValues.put("finalized", Integer.valueOf(0));
    synchronized (this._databaseAccessLock)
    {
      paramLong1 = getWritableDatabase().insert("appSessions", null, localContentValues);
      return paramLong1;
    }
  }
  
  /* Error */
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/getjar/sdk/data/usage/UsageDatabase:_databaseAccessLock	Ljava/lang/Object;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_2
    //   11: iload_2
    //   12: getstatic 39	com/getjar/sdk/data/usage/UsageDatabase:DB_CREATE_TABLE_COMMANDS	[Ljava/lang/String;
    //   15: arraylength
    //   16: if_icmpge +19 -> 35
    //   19: aload_1
    //   20: getstatic 39	com/getjar/sdk/data/usage/UsageDatabase:DB_CREATE_TABLE_COMMANDS	[Ljava/lang/String;
    //   23: iload_2
    //   24: aaload
    //   25: invokevirtual 332	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   28: iload_2
    //   29: iconst_1
    //   30: iadd
    //   31: istore_2
    //   32: goto -21 -> 11
    //   35: aload_3
    //   36: monitorexit
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_3
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	UsageDatabase
    //   0	50	1	paramSQLiteDatabase	SQLiteDatabase
    //   10	22	2	i	int
    //   6	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	28	40	finally
    //   35	37	40	finally
    //   41	43	40	finally
    //   2	9	45	finally
    //   43	45	45	finally
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        synchronized (this._databaseAccessLock)
        {
          Logger.d(Area.USAGE.value() | Area.STORAGE.value(), "Upgrading database '%1$s' from version %2$d to %3$d, which will destroy all old data", new Object[] { "GetJarDBUsage", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          String[] arrayOfString = DB_TABLE_NAMES;
          paramInt2 = arrayOfString.length;
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            String str = arrayOfString[paramInt1];
            paramSQLiteDatabase.execSQL(String.format(Locale.US, "DROP TABLE IF EXISTS %1$s", new Object[] { str }));
            paramInt1 += 1;
            continue;
            if (paramInt1 < DB_CREATE_TABLE_COMMANDS.length)
            {
              paramSQLiteDatabase.execSQL(DB_CREATE_TABLE_COMMANDS[paramInt1]);
              paramInt1 += 1;
              continue;
            }
            return;
          }
        }
        paramInt1 = 0;
      }
      finally {}
    }
  }
  
  protected void purgeOldEntries(long paramLong)
  {
    long l = System.currentTimeMillis();
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().delete("appSessions", String.format(Locale.US, "timestamp < %d", new Object[] { Long.valueOf(l - paramLong) }), null);
      return;
    }
  }
  
  public void setSessionAsFinal()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("finalized", Integer.valueOf(1));
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().update("appSessions", localContentValues, null, null);
      return;
    }
  }
  
  protected void trimLruEntries()
  {
    synchronized (this._databaseAccessLock)
    {
      trimLruEntries("appSessions", 2500);
      return;
    }
  }
  
  protected void updateAppSession(long paramLong1, long paramLong2, String arg5)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("duration", Long.valueOf(paramLong2));
    localContentValues.put("reason", ???);
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().update("appSessions", localContentValues, "id = " + paramLong1, null);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/UsageDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */