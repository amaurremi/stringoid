package com.getjar.sdk.data.package_events;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.data.RecordSyncedListener;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PackageEventDatabase
  extends SQLiteOpenHelper
  implements RecordSyncedListener
{
  private static final String DATABASE_NAME_PREFIX = "GetJarDBPackageEvents";
  private static final String DATABASE_TABLE = "packageEvents";
  private static final int DATABASE_VERSION = 1;
  private static int LRU_CAP = 1000;
  private static volatile PackageEventDatabase _Instance = null;
  protected volatile Object _databaseAccessLock = new Object();
  
  private PackageEventDatabase(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
    Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "PackageEventDatabase: Opened user specific database '%1$s%2$d'", new Object[] { "GetJarDBPackageEvents", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) });
  }
  
  protected static PackageEventDatabase getInstance()
  {
    try
    {
      if (_Instance == null) {
        throw new IllegalStateException("initialize() must be called first");
      }
    }
    finally {}
    PackageEventDatabase localPackageEventDatabase = _Instance;
    return localPackageEventDatabase;
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
  
  protected static void initialize(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("'context' can not be NULL");
      }
      finally {}
    }
    if (_Instance == null)
    {
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "PackageEventDatabase: waitForUserAccess() START [%1$s]", new Object[] { Logger.getShortStack() });
      AuthManager.initialize(paramContext);
      AuthManager.getInstance().waitOnAuth();
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "PackageEventDatabase: waitForUserAccess() DONE", new Object[0]);
      if (StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserAccessId())) {
        throw new IllegalStateException("Must have a user access ID");
      }
      _Instance = new PackageEventDatabase(paramContext, String.format(Locale.US, "%1$s%2$d", new Object[] { "GetJarDBPackageEvents", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) }));
      return;
    }
    throw new IllegalStateException("PackageEventDatabase has already been initialized");
  }
  
  public void addRecord(String paramString, PackageEventManager.EventType paramEventType)
  {
    synchronized (this._databaseAccessLock)
    {
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
      }
    }
    if (paramEventType == null) {
      throw new IllegalArgumentException("'eventType' cannot be NULL");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("packageName", paramString);
    localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("eventType", paramEventType.name());
    localContentValues.put("synced", Integer.valueOf(0));
    getWritableDatabase().insert("packageEvents", null, localContentValues);
    Logger.v(Area.USAGE.value() | Area.STORAGE.value(), "PackageEventDatabase: Added a '%1$s' record for '%2$s'", new Object[] { paramEventType.name(), paramString });
    trimLruEntries();
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
  
  protected int getLRUCap()
  {
    return LRU_CAP;
  }
  
  public long getRecordCount()
  {
    synchronized (this._databaseAccessLock)
    {
      long l = getRecordCountInternal();
      return l;
    }
  }
  
  protected String getTableName()
  {
    return "packageEvents";
  }
  
  public List<PackageEventRecord> loadAllRecords()
  {
    synchronized (this._databaseAccessLock)
    {
      localArrayList = new ArrayList();
      localObject1 = null;
      try
      {
        Cursor localCursor = getReadableDatabase().query(getTableName(), null, null, null, null, null, null);
        for (;;)
        {
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localArrayList.add(loadFromDB(localCursor));
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
          catch (Throwable localThrowable1)
          {
            for (;;) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
  }
  
  protected PackageEventRecord loadFromDB(Cursor paramCursor)
  {
    return PackageEventRecord.loadFromDB(paramCursor);
  }
  
  public List<PackageEventRecord> loadUnsyncedRecords()
  {
    synchronized (this._databaseAccessLock)
    {
      localArrayList = new ArrayList();
      localObject1 = null;
      try
      {
        Cursor localCursor = getReadableDatabase().query(getTableName(), null, "synced = 0", null, null, null, null);
        for (;;)
        {
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          localArrayList.add(loadFromDB(localCursor));
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
          catch (Throwable localThrowable1)
          {
            for (;;) {}
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this._databaseAccessLock)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS packageEvents (id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT NOT NULL, timestamp INTEGER NOT NULL, eventType TEXT NOT NULL, synced INTEGER NOT NULL DEFAULT 0, UNIQUE(packageName, timestamp, eventType) ON CONFLICT REPLACE);");
      return;
    }
  }
  
  public void onRecordSynced(long paramLong)
  {
    synchronized (this._databaseAccessLock)
    {
      if (checkForRecord(paramLong))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("synced", Integer.valueOf(1));
        getWritableDatabase().update(getTableName(), localContentValues, String.format(Locale.US, "id = %1$d", new Object[] { Long.valueOf(paramLong) }), null);
        return;
      }
      Logger.w(Area.STORAGE.value(), "Usage: %1$s: setRecordAsSynced() failed to find record %2$d", new Object[] { getClass().getName(), Long.valueOf(paramLong) });
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    synchronized (this._databaseAccessLock)
    {
      Logger.d(Area.STORAGE.value(), "Upgrading database from version %1$d to %2$d [deleting old data from table '%3$s']", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), getTableName() });
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTableName());
      onCreate(paramSQLiteDatabase);
      return;
    }
  }
  
  public void purgeSyncedRecords()
  {
    synchronized (this._databaseAccessLock)
    {
      getWritableDatabase().delete(getTableName(), "synced = 1", null);
      return;
    }
  }
  
  /* Error */
  public void trimLruEntries()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/getjar/sdk/data/package_events/PackageEventDatabase:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 333	com/getjar/sdk/data/package_events/PackageEventDatabase:getLRUCap	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifge +22 -> 37
    //   18: new 85	java/lang/IllegalStateException
    //   21: dup
    //   22: ldc_w 335
    //   25: invokespecial 90	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   28: athrow
    //   29: astore 4
    //   31: aload 7
    //   33: monitorexit
    //   34: aload 4
    //   36: athrow
    //   37: aload_0
    //   38: invokespecial 243	com/getjar/sdk/data/package_events/PackageEventDatabase:getRecordCountInternal	()J
    //   41: iload_1
    //   42: i2l
    //   43: lcmp
    //   44: ifge +7 -> 51
    //   47: aload 7
    //   49: monitorexit
    //   50: return
    //   51: aconst_null
    //   52: astore 5
    //   54: aconst_null
    //   55: astore 4
    //   57: aload_0
    //   58: invokevirtual 97	com/getjar/sdk/data/package_events/PackageEventDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   61: aload_0
    //   62: invokevirtual 108	com/getjar/sdk/data/package_events/PackageEventDatabase:getTableName	()Ljava/lang/String;
    //   65: iconst_1
    //   66: anewarray 66	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 337
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: ldc_w 339
    //   82: invokevirtual 254	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 4
    //   91: aload 6
    //   93: iload_1
    //   94: invokeinterface 343 2 0
    //   99: ifeq +22 -> 121
    //   102: aload 6
    //   104: astore 4
    //   106: aload 6
    //   108: iconst_0
    //   109: invokeinterface 347 2 0
    //   114: lstore_2
    //   115: lload_2
    //   116: invokestatic 192	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   119: astore 5
    //   121: aload 6
    //   123: ifnull +10 -> 133
    //   126: aload 6
    //   128: invokeinterface 271 1 0
    //   133: aload_0
    //   134: invokevirtual 210	com/getjar/sdk/data/package_events/PackageEventDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   137: aload_0
    //   138: invokevirtual 108	com/getjar/sdk/data/package_events/PackageEventDatabase:getTableName	()Ljava/lang/String;
    //   141: getstatic 103	java/util/Locale:US	Ljava/util/Locale;
    //   144: ldc_w 349
    //   147: iconst_1
    //   148: anewarray 35	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload 5
    //   155: aastore
    //   156: invokestatic 112	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   159: aconst_null
    //   160: invokevirtual 235	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   163: istore_1
    //   164: iload_1
    //   165: ifle +43 -> 208
    //   168: getstatic 52	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   171: invokevirtual 49	com/getjar/sdk/logging/Area:value	()J
    //   174: ldc_w 351
    //   177: iconst_3
    //   178: anewarray 35	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: invokevirtual 299	java/lang/Object:getClass	()Ljava/lang/Class;
    //   187: invokevirtual 304	java/lang/Class:getName	()Ljava/lang/String;
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_1
    //   194: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: aload_0
    //   201: invokevirtual 108	com/getjar/sdk/data/package_events/PackageEventDatabase:getTableName	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 219	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 7
    //   210: monitorexit
    //   211: return
    //   212: astore 5
    //   214: aload 4
    //   216: ifnull +10 -> 226
    //   219: aload 4
    //   221: invokeinterface 271 1 0
    //   226: aload 5
    //   228: athrow
    //   229: astore 4
    //   231: goto -98 -> 133
    //   234: astore 4
    //   236: goto -10 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	PackageEventDatabase
    //   13	181	1	i	int
    //   114	2	2	l	long
    //   29	6	4	localObject1	Object
    //   55	165	4	localObject2	Object
    //   229	1	4	localException1	Exception
    //   234	1	4	localException2	Exception
    //   52	102	5	localLong	Long
    //   212	15	5	localObject3	Object
    //   85	42	6	localCursor	Cursor
    //   4	205	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	29	finally
    //   18	29	29	finally
    //   31	34	29	finally
    //   37	50	29	finally
    //   126	133	29	finally
    //   133	164	29	finally
    //   168	208	29	finally
    //   208	211	29	finally
    //   219	226	29	finally
    //   226	229	29	finally
    //   57	87	212	finally
    //   91	102	212	finally
    //   106	115	212	finally
    //   126	133	229	java/lang/Exception
    //   219	226	234	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/package_events/PackageEventDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */