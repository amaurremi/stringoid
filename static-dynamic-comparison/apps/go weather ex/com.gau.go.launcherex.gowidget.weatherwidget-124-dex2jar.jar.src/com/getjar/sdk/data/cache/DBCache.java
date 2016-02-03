package com.getjar.sdk.data.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DBCache
  extends SQLiteOpenHelper
{
  private static final String _DATABASE_TABLE_NAME = "cacheValues";
  private static final String _DB_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS cacheValues (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL UNIQUE, value TEXT, createdTimestamp INTEGER NOT NULL, lastUpdated INTEGER NOT NULL, ttl INTEGER NOT NULL, uri TEXT, etag TEXT);";
  private static Map<String, DBCache> _NamespaceToInstance = new HashMap();
  private static volatile Object _NamespaceToInstanceLock = new Object();
  private volatile Object _databaseAccessLock = new Object();
  private final String _databaseName;
  private final int _databaseVersionRequested;
  private volatile boolean _isDataCleared = false;
  
  private DBCache(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    this._databaseVersionRequested = paramInt;
    this._databaseName = paramString;
    Logger.i(Area.STORAGE.value(), "DBCache: Opened caching database '%1$s'", new Object[] { paramString });
  }
  
  public static DBCache getInstanceAllUsers(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'namespace' can not be NULL or empty");
    }
    if (!_NamespaceToInstance.containsKey(paramString)) {}
    synchronized (_NamespaceToInstanceLock)
    {
      if (!_NamespaceToInstance.containsKey(paramString)) {
        _NamespaceToInstance.put(paramString, new DBCache(paramContext, paramString, paramInt));
      }
      return (DBCache)_NamespaceToInstance.get(paramString);
    }
  }
  
  public static DBCache getInstanceUserSpecific(Context paramContext, String arg1, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' can not be NULL");
    }
    Logger.i(Area.STORAGE.value(), "DBCache: waitForUserAccess() START [%1$s] [%2$s]", new Object[] { ???, Logger.getShortStack() });
    AuthManager.initialize(paramContext);
    AuthManager.getInstance().waitOnAuth();
    Logger.i(Area.STORAGE.value(), "DBCache: waitForUserAccess() DONE [%1$s]", new Object[] { ??? });
    if (StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserAccessId())) {
      throw new IllegalStateException("Must have a user access ID");
    }
    if (StringUtility.isNullOrEmpty(???)) {
      throw new IllegalArgumentException("'namespace' can not be NULL or empty");
    }
    String str = String.format(Locale.US, "%1$s%2$d", new Object[] { ???, Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) });
    if (!_NamespaceToInstance.containsKey(str)) {}
    synchronized (_NamespaceToInstanceLock)
    {
      if (!_NamespaceToInstance.containsKey(str)) {
        _NamespaceToInstance.put(str, new DBCache(paramContext, str, paramInt));
      }
      return (DBCache)_NamespaceToInstance.get(str);
    }
  }
  
  /* Error */
  private Long getLruRangeStartId(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 162	com/getjar/sdk/data/cache/DBCache:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc 8
    //   9: iconst_1
    //   10: anewarray 140	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc -92
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: ldc -90
    //   24: invokevirtual 172	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 5
    //   29: aload 5
    //   31: iload_1
    //   32: invokeinterface 178 2 0
    //   37: ifeq +18 -> 55
    //   40: aload 5
    //   42: iconst_0
    //   43: invokeinterface 182 2 0
    //   48: lstore_2
    //   49: lload_2
    //   50: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: astore 4
    //   55: aload 5
    //   57: invokeinterface 190 1 0
    //   62: aload 4
    //   64: areturn
    //   65: astore 4
    //   67: aload 5
    //   69: invokeinterface 190 1 0
    //   74: aload 4
    //   76: athrow
    //   77: astore 5
    //   79: aload 4
    //   81: areturn
    //   82: astore 5
    //   84: goto -10 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	DBCache
    //   0	87	1	paramInt	int
    //   48	2	2	l	long
    //   1	62	4	localLong1	Long
    //   65	15	4	localLong2	Long
    //   27	41	5	localCursor	Cursor
    //   77	1	5	localException1	Exception
    //   82	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   29	49	65	finally
    //   55	62	77	java/lang/Exception
    //   67	74	82	java/lang/Exception
  }
  
  public boolean checkForCacheEntry(String paramString)
  {
    bool = true;
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'name' can not be NULL or empty");
    }
    synchronized (this._databaseAccessLock)
    {
      localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE name = ?", new Object[] { "cacheValues" }));
      for (;;)
      {
        try
        {
          localSQLiteStatement.bindString(1, paramString);
          long l = localSQLiteStatement.simpleQueryForLong();
          if (l <= 0L) {
            continue;
          }
        }
        finally
        {
          try
          {
            localSQLiteStatement.close();
            throw paramString;
          }
          catch (Exception localException)
          {
            Logger.e(Area.STORAGE.value(), localException, "DBCache: SQLiteStatement.close() failed", new Object[0]);
            continue;
          }
          bool = false;
        }
        try
        {
          localSQLiteStatement.close();
          return bool;
        }
        catch (Exception paramString)
        {
          Logger.e(Area.STORAGE.value(), paramString, "DBCache: SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
  }
  
  public int deleteCacheEntries()
  {
    synchronized (this._databaseAccessLock)
    {
      int i = getWritableDatabase().delete("cacheValues", "1", null);
      return i;
    }
  }
  
  public boolean deleteCacheEntry(String paramString)
  {
    boolean bool = true;
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'name' can not be NULL or empty");
    }
    for (;;)
    {
      synchronized (this._databaseAccessLock)
      {
        if (getWritableDatabase().delete("cacheValues", "name = ?", new String[] { paramString }) > 0) {
          return bool;
        }
      }
      bool = false;
    }
  }
  
  public String getDatabaseName()
  {
    return this._databaseName;
  }
  
  /* Error */
  protected ArrayList<CacheEntry> getLruEntries(int paramInt)
    throws URISyntaxException
  {
    // Byte code:
    //   0: iload_1
    //   1: ifge +13 -> 14
    //   4: new 71	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc -21
    //   10: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: new 237	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 238	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 241	com/getjar/sdk/data/cache/DBCache:getRecordCount	()J
    //   27: iload_1
    //   28: i2l
    //   29: lcmp
    //   30: ifge +6 -> 36
    //   33: aload 4
    //   35: areturn
    //   36: aload_0
    //   37: getfield 45	com/getjar/sdk/data/cache/DBCache:_databaseAccessLock	Ljava/lang/Object;
    //   40: astore_3
    //   41: aload_3
    //   42: monitorenter
    //   43: aload_0
    //   44: iload_1
    //   45: invokespecial 243	com/getjar/sdk/data/cache/DBCache:getLruRangeStartId	(I)Ljava/lang/Long;
    //   48: astore 5
    //   50: aload_0
    //   51: invokevirtual 162	com/getjar/sdk/data/cache/DBCache:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   54: ldc 8
    //   56: aconst_null
    //   57: getstatic 136	java/util/Locale:US	Ljava/util/Locale;
    //   60: ldc -11
    //   62: iconst_1
    //   63: anewarray 33	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 5
    //   70: aastore
    //   71: invokestatic 154	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc -90
    //   79: invokevirtual 172	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore 5
    //   84: aload 5
    //   86: ifnull +40 -> 126
    //   89: aload 5
    //   91: invokeinterface 249 1 0
    //   96: ifeq +30 -> 126
    //   99: aload 4
    //   101: new 251	com/getjar/sdk/data/cache/CacheEntry
    //   104: dup
    //   105: aload 5
    //   107: invokespecial 254	com/getjar/sdk/data/cache/CacheEntry:<init>	(Landroid/database/Cursor;)V
    //   110: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload 5
    //   116: invokeinterface 260 1 0
    //   121: istore_2
    //   122: iload_2
    //   123: ifne -24 -> 99
    //   126: aload 5
    //   128: invokeinterface 190 1 0
    //   133: getstatic 55	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   136: invokevirtual 59	com/getjar/sdk/logging/Area:value	()J
    //   139: ldc_w 262
    //   142: iconst_1
    //   143: anewarray 33	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload 4
    //   150: invokevirtual 265	java/util/ArrayList:size	()I
    //   153: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: invokestatic 268	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   160: aload_3
    //   161: monitorexit
    //   162: aload 4
    //   164: areturn
    //   165: astore 4
    //   167: aload_3
    //   168: monitorexit
    //   169: aload 4
    //   171: athrow
    //   172: astore 4
    //   174: aload 5
    //   176: invokeinterface 190 1 0
    //   181: aload 4
    //   183: athrow
    //   184: astore 5
    //   186: goto -53 -> 133
    //   189: astore 5
    //   191: goto -10 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	DBCache
    //   0	194	1	paramInt	int
    //   121	2	2	bool	boolean
    //   40	128	3	localObject1	Object
    //   21	142	4	localArrayList	ArrayList
    //   165	5	4	localObject2	Object
    //   172	10	4	localObject3	Object
    //   48	127	5	localObject4	Object
    //   184	1	5	localException1	Exception
    //   189	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	84	165	finally
    //   126	133	165	finally
    //   133	162	165	finally
    //   167	169	165	finally
    //   174	181	165	finally
    //   181	184	165	finally
    //   89	99	172	finally
    //   99	122	172	finally
    //   126	133	184	java/lang/Exception
    //   174	181	189	java/lang/Exception
  }
  
  /* Error */
  public long getRecordCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/getjar/sdk/data/cache/DBCache:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 219	com/getjar/sdk/data/cache/DBCache:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: getstatic 136	java/util/Locale:US	Ljava/util/Locale;
    //   14: ldc_w 273
    //   17: iconst_1
    //   18: anewarray 33	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: ldc 8
    //   25: aastore
    //   26: invokestatic 154	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 199	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 208	android/database/sqlite/SQLiteStatement:simpleQueryForLong	()J
    //   39: lstore_1
    //   40: aload 5
    //   42: invokevirtual 209	android/database/sqlite/SQLiteStatement:close	()V
    //   45: aload_3
    //   46: monitorexit
    //   47: lload_1
    //   48: lreturn
    //   49: astore 4
    //   51: getstatic 55	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   54: invokevirtual 59	com/getjar/sdk/logging/Area:value	()J
    //   57: aload 4
    //   59: ldc -45
    //   61: iconst_0
    //   62: anewarray 33	java/lang/Object
    //   65: invokestatic 215	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: goto -23 -> 45
    //   71: astore 4
    //   73: aload_3
    //   74: monitorexit
    //   75: aload 4
    //   77: athrow
    //   78: astore 4
    //   80: aload 5
    //   82: invokevirtual 209	android/database/sqlite/SQLiteStatement:close	()V
    //   85: aload 4
    //   87: athrow
    //   88: astore 5
    //   90: getstatic 55	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   93: invokevirtual 59	com/getjar/sdk/logging/Area:value	()J
    //   96: aload 5
    //   98: ldc -45
    //   100: iconst_0
    //   101: anewarray 33	java/lang/Object
    //   104: invokestatic 215	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: goto -22 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	DBCache
    //   39	9	1	l	long
    //   4	70	3	localObject1	Object
    //   49	9	4	localException1	Exception
    //   71	5	4	localObject2	Object
    //   78	8	4	localObject3	Object
    //   32	49	5	localSQLiteStatement	SQLiteStatement
    //   88	9	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   40	45	49	java/lang/Exception
    //   7	34	71	finally
    //   40	45	71	finally
    //   45	47	71	finally
    //   51	68	71	finally
    //   73	75	71	finally
    //   80	85	71	finally
    //   85	88	71	finally
    //   90	107	71	finally
    //   34	40	78	finally
    //   80	85	88	java/lang/Exception
  }
  
  public boolean isDatabaseNewVersion()
  {
    return (super.getReadableDatabase().getVersion() != this._databaseVersionRequested) || (this._isDataCleared);
  }
  
  /* Error */
  public ArrayList<CacheEntry> loadAllCacheEntries()
    throws URISyntaxException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/getjar/sdk/data/cache/DBCache:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: new 237	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 238	java/util/ArrayList:<init>	()V
    //   14: astore_3
    //   15: aload_0
    //   16: invokevirtual 162	com/getjar/sdk/data/cache/DBCache:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: ldc 8
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 172	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore 4
    //   32: aload 4
    //   34: invokeinterface 249 1 0
    //   39: ifeq +29 -> 68
    //   42: aload_3
    //   43: new 251	com/getjar/sdk/data/cache/CacheEntry
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 254	com/getjar/sdk/data/cache/CacheEntry:<init>	(Landroid/database/Cursor;)V
    //   52: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   55: pop
    //   56: aload 4
    //   58: invokeinterface 260 1 0
    //   63: istore_1
    //   64: iload_1
    //   65: ifne -23 -> 42
    //   68: aload 4
    //   70: invokeinterface 190 1 0
    //   75: aload_2
    //   76: monitorexit
    //   77: aload_3
    //   78: areturn
    //   79: astore_3
    //   80: aload 4
    //   82: invokeinterface 190 1 0
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    //   94: astore 4
    //   96: goto -21 -> 75
    //   99: astore 4
    //   101: goto -14 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	DBCache
    //   63	2	1	bool	boolean
    //   4	87	2	localObject1	Object
    //   14	64	3	localArrayList	ArrayList
    //   79	9	3	localObject2	Object
    //   89	4	3	localObject3	Object
    //   30	51	4	localCursor	Cursor
    //   94	1	4	localException1	Exception
    //   99	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   32	42	79	finally
    //   42	64	79	finally
    //   7	32	89	finally
    //   68	75	89	finally
    //   75	77	89	finally
    //   80	87	89	finally
    //   87	89	89	finally
    //   90	92	89	finally
    //   68	75	94	java/lang/Exception
    //   80	87	99	java/lang/Exception
  }
  
  /* Error */
  public CacheEntry loadCacheEntry(String paramString)
    throws URISyntaxException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 82	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   4: ifeq +13 -> 17
    //   7: new 71	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc -63
    //   13: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 45	com/getjar/sdk/data/cache/DBCache:_databaseAccessLock	Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: invokevirtual 162	com/getjar/sdk/data/cache/DBCache:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: ldc 8
    //   30: aconst_null
    //   31: ldc -28
    //   33: iconst_1
    //   34: anewarray 140	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 172	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: invokeinterface 260 1 0
    //   54: ifeq +22 -> 76
    //   57: new 251	com/getjar/sdk/data/cache/CacheEntry
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 254	com/getjar/sdk/data/cache/CacheEntry:<init>	(Landroid/database/Cursor;)V
    //   65: astore_3
    //   66: aload_1
    //   67: invokeinterface 190 1 0
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_3
    //   75: areturn
    //   76: aload_1
    //   77: invokeinterface 190 1 0
    //   82: aload_2
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: astore_3
    //   87: aload_1
    //   88: invokeinterface 190 1 0
    //   93: aload_3
    //   94: athrow
    //   95: astore_1
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: goto -29 -> 72
    //   104: astore_1
    //   105: goto -23 -> 82
    //   108: astore_1
    //   109: goto -16 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	DBCache
    //   0	112	1	paramString	String
    //   21	76	2	localObject1	Object
    //   65	10	3	localCacheEntry	CacheEntry
    //   86	8	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   48	66	86	finally
    //   24	48	95	finally
    //   66	72	95	finally
    //   72	74	95	finally
    //   76	82	95	finally
    //   82	84	95	finally
    //   87	93	95	finally
    //   93	95	95	finally
    //   96	98	95	finally
    //   66	72	100	java/lang/Exception
    //   76	82	104	java/lang/Exception
    //   87	93	108	java/lang/Exception
  }
  
  public HashMap<String, CacheEntry> loadCacheEntryMap(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("name array can not be empty");
    }
    Object localObject2 = this._databaseAccessLock;
    int j = 0;
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("name in (");
        int k = paramVarArgs.length;
        i = 0;
        if (i < k)
        {
          localObject3 = paramVarArgs[i];
          j += 1;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label379;
          }
          ((StringBuilder)localObject1).append("'");
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("'");
          if (j == paramVarArgs.length) {
            break label379;
          }
          ((StringBuilder)localObject1).append(",");
        }
      }
      finally {}
      ((StringBuilder)localObject1).append(")");
      Object localObject3 = new HashMap();
      ArrayList localArrayList = new ArrayList();
      Cursor localCursor = getReadableDatabase().query("cacheValues", null, ((StringBuilder)localObject1).toString(), null, null, null, null);
      paramVarArgs = "";
      try
      {
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          try
          {
            localObject1 = localCursor.getString(1);
            paramVarArgs = (String[])localObject1;
            ((HashMap)localObject3).put(localObject1, new CacheEntry(localCursor));
            paramVarArgs = (String[])localObject1;
            Logger.v(Area.STORAGE.value(), "DBCache: loadCacheEntryMap() Found a cache entry for %1$s.%2$s", new Object[] { this._databaseName, localObject1 });
            paramVarArgs = (String[])localObject1;
          }
          catch (URISyntaxException localURISyntaxException)
          {
            localArrayList.add("'" + paramVarArgs + "'");
          }
        }
        try
        {
          localCursor.close();
          if (localArrayList.size() > 0) {
            paramVarArgs = TextUtils.join(",", localArrayList);
          }
        }
        catch (Exception paramVarArgs)
        {
          try
          {
            getWritableDatabase().delete("cacheValues", "name in (" + paramVarArgs + ")", null);
            return (HashMap<String, CacheEntry>)localObject3;
            paramVarArgs = paramVarArgs;
          }
          catch (Exception paramVarArgs)
          {
            for (;;) {}
          }
        }
      }
      finally {}
      label379:
      i += 1;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this._databaseAccessLock)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cacheValues (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL UNIQUE, value TEXT, createdTimestamp INTEGER NOT NULL, lastUpdated INTEGER NOT NULL, ttl INTEGER NOT NULL, uri TEXT, etag TEXT);");
      return;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    synchronized (this._databaseAccessLock)
    {
      Logger.i(Area.STORAGE.value(), "DBCache: Upgrading database from version %1$d to %2$d, which will destroy all old data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this._isDataCleared = true;
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS cacheValues");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cacheValues (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL UNIQUE, value TEXT, createdTimestamp INTEGER NOT NULL, lastUpdated INTEGER NOT NULL, ttl INTEGER NOT NULL, uri TEXT, etag TEXT);");
      return;
    }
  }
  
  public void trimLruEntries(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'maxRecordsCap' can not be negative");
    }
    if (getRecordCount() < paramInt) {
      return;
    }
    synchronized (this._databaseAccessLock)
    {
      Long localLong = getLruRangeStartId(paramInt);
      paramInt = getWritableDatabase().delete("cacheValues", String.format(Locale.US, "id <= %1$d", new Object[] { localLong }), null);
      Logger.v(Area.STORAGE.value(), "DBCache: %1$d LRU rows deleted form the cache DB", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public boolean upsertCacheEntry(CacheEntry paramCacheEntry)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramCacheEntry == null) {
      throw new IllegalArgumentException("'cacheEntry' can not be null");
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramCacheEntry.getName());
    if (paramCacheEntry.getValue() == null) {
      localContentValues.putNull("value");
    }
    for (;;)
    {
      localContentValues.put("ttl", paramCacheEntry.getTtl());
      if (paramCacheEntry.getUri() == null)
      {
        localContentValues.putNull("uri");
        label82:
        if (paramCacheEntry.getEtag() != null) {
          break label219;
        }
        localContentValues.putNull("etag");
        label97:
        localContentValues.put("lastUpdated", Long.valueOf(System.currentTimeMillis()));
      }
      try
      {
        if (checkForCacheEntry(paramCacheEntry.getName())) {
          synchronized (this._databaseAccessLock)
          {
            Logger.v(Area.STORAGE.value(), "DBCache: Updating cache entry %1$s", new Object[] { paramCacheEntry.toString() });
            if (getWritableDatabase().update("cacheValues", localContentValues, "name = ?", new String[] { paramCacheEntry.getName() }) > 0)
            {
              return bool1;
              localContentValues.put("value", paramCacheEntry.getValue());
              continue;
              localContentValues.put("uri", paramCacheEntry.getUri().toString());
              break label82;
              label219:
              localContentValues.put("etag", paramCacheEntry.getEtag());
              break label97;
            }
            bool1 = false;
          }
        }
        synchronized (this._databaseAccessLock)
        {
          localContentValues.put("createdTimestamp", Long.valueOf(System.currentTimeMillis()));
          Logger.v(Area.STORAGE.value(), "DBCache: Inserting cache entry %1$s", new Object[] { paramCacheEntry.toString() });
          if (getWritableDatabase().insert("cacheValues", null, localContentValues) != -1L)
          {
            bool1 = bool2;
            return bool1;
          }
        }
      }
      catch (SQLiteException paramCacheEntry)
      {
        Logger.e(Area.STORAGE.value(), paramCacheEntry, "DBCache: upsertCacheEntry() failed", new Object[0]);
        return false;
      }
    }
    for (;;)
    {
      bool1 = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/DBCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */