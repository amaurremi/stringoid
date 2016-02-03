package com.getjar.sdk.comm.auth;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;

public class AccountHistoryDatabase
  extends SQLiteOpenHelper
{
  private static final int ACCOUNTS_LRU_CAP = 50;
  private static final String DATABASE_CREATE_TABLE_ACCOUNT_EVENT = "CREATE TABLE IF NOT EXISTS accountEvent (id INTEGER PRIMARY KEY AUTOINCREMENT, userAccessId TEXT NOT NULL, eventType TEXT NOT NULL, timestamp INTEGER NOT NULL, FOREIGN KEY(userAccessId) REFERENCES account(userAccessId) );";
  private static final String DATABASE_CREATE_TABLE_ACCOUNT_INFO = "CREATE TABLE IF NOT EXISTS account (id INTEGER PRIMARY KEY AUTOINCREMENT, userAccessId TEXT NOT NULL UNIQUE, userDeviceId TEXT NOT NULL, providerFilter TEXT NOT NULL, accountName TEXT NOT NULL, timestampLastAuth INTEGER NOT NULL, timestampCreated INTEGER NOT NULL);";
  private static final String DATABASE_NAME = "GetJarDBAccountHistory";
  private static final String DATABASE_TABLE_ACCOUNT_EVENT = "accountEvent";
  private static final String DATABASE_TABLE_ACCOUNT_INFO = "account";
  private static final int DATABASE_VERSION = 1;
  private static final String[] DB_CREATE_TABLE_COMMANDS = { "CREATE TABLE IF NOT EXISTS account (id INTEGER PRIMARY KEY AUTOINCREMENT, userAccessId TEXT NOT NULL UNIQUE, userDeviceId TEXT NOT NULL, providerFilter TEXT NOT NULL, accountName TEXT NOT NULL, timestampLastAuth INTEGER NOT NULL, timestampCreated INTEGER NOT NULL);", "CREATE TABLE IF NOT EXISTS accountEvent (id INTEGER PRIMARY KEY AUTOINCREMENT, userAccessId TEXT NOT NULL, eventType TEXT NOT NULL, timestamp INTEGER NOT NULL, FOREIGN KEY(userAccessId) REFERENCES account(userAccessId) );" };
  private static final String[] DB_TABLE_NAMES;
  private static final int EVENTS_LRU_CAP = 100;
  private static volatile AccountHistoryDatabase _Instance = null;
  private volatile Object _databaseAccessLock = new Object();
  
  static
  {
    DB_TABLE_NAMES = new String[] { "account", "accountEvent" };
  }
  
  private AccountHistoryDatabase(Context paramContext)
  {
    super(paramContext, "GetJarDBAccountHistory", null, 1);
  }
  
  private boolean checkForAccountEntry(String paramString)
  {
    boolean bool = true;
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
    }
    localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE userAccessId = ?", new Object[] { "account" }));
    try
    {
      localSQLiteStatement.bindString(1, paramString);
      long l = localSQLiteStatement.simpleQueryForLong();
      if (l > 0L) {}
      for (;;)
      {
        try
        {
          localSQLiteStatement.close();
          return bool;
        }
        catch (Exception paramString)
        {
          Logger.e(Area.STORAGE.value(), paramString, "SQLiteStatement.close() failed", new Object[0]);
          return bool;
        }
        bool = false;
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
          Logger.e(Area.STORAGE.value(), localException, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  public static AccountHistoryDatabase getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new AccountHistoryDatabase(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
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
        Logger.e(Area.STORAGE.value(), paramString, "SQLiteStatement.close() failed", new Object[0]);
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
          Logger.e(Area.STORAGE.value(), localException, "SQLiteStatement.close() failed", new Object[0]);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private void trimLruEntries(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 136	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getRecordCount	(Ljava/lang/String;)J
    //   5: iload_3
    //   6: i2l
    //   7: lcmp
    //   8: ifge +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 139	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: aload_1
    //   20: iconst_1
    //   21: anewarray 40	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc -115
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aload_2
    //   34: invokevirtual 145	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 7
    //   39: aload 6
    //   41: astore_2
    //   42: aload 7
    //   44: iload_3
    //   45: invokeinterface 151 2 0
    //   50: ifeq +19 -> 69
    //   53: aload 7
    //   55: iconst_0
    //   56: invokeinterface 155 2 0
    //   61: lstore 4
    //   63: lload 4
    //   65: invokestatic 161	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: astore_2
    //   69: aload 7
    //   71: invokeinterface 162 1 0
    //   76: aload_0
    //   77: invokevirtual 139	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   80: aload_1
    //   81: getstatic 82	java/util/Locale:US	Ljava/util/Locale;
    //   84: ldc -92
    //   86: iconst_1
    //   87: anewarray 52	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_2
    //   93: aastore
    //   94: invokestatic 88	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: aconst_null
    //   98: invokevirtual 168	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   101: istore_3
    //   102: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   105: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   108: ldc -86
    //   110: iconst_2
    //   111: anewarray 52	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: iload_3
    //   117: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_1
    //   124: aastore
    //   125: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   128: return
    //   129: astore_1
    //   130: aload 7
    //   132: invokeinterface 162 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore 6
    //   141: goto -65 -> 76
    //   144: astore_2
    //   145: goto -8 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	AccountHistoryDatabase
    //   0	148	1	paramString1	String
    //   0	148	2	paramString2	String
    //   0	148	3	paramInt	int
    //   61	3	4	l	long
    //   13	27	6	localObject	Object
    //   139	1	6	localException	Exception
    //   37	94	7	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   42	63	129	finally
    //   69	76	139	java/lang/Exception
    //   130	137	144	java/lang/Exception
  }
  
  private void trimLruEntriesAccountEvent()
  {
    trimLruEntries("accountEvent", "timestamp DESC", 100);
  }
  
  private void trimLruEntriesAccountInfo()
  {
    trimLruEntries("account", "timestampLastAuth DESC", 50);
  }
  
  private void updateAccountLastAuth(String paramString, long paramLong)
  {
    Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.updateAccountLastAuth() START", new Object[0]);
    try
    {
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
      }
    }
    finally
    {
      Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.updateAccountLastAuth() FINISHED", new Object[0]);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestampLastAuth", Long.valueOf(paramLong));
    if (getWritableDatabase().update("account", localContentValues, "userAccessId = ?", new String[] { paramString }) > 0) {
      Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.updateAccountLastAuth() updated [userAccessId:%1$s timestampLastAuth:%2$d]", new Object[] { paramString, Long.valueOf(paramLong) });
    }
    for (;;)
    {
      Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.updateAccountLastAuth() FINISHED", new Object[0]);
      return;
      Logger.e(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.updateAccountLastAuth() failed to update [userAccessId:%1$s timestampLastAuth:%2$d]", new Object[] { paramString, Long.valueOf(paramLong) });
    }
  }
  
  protected void ensureAccountEntry(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.ensureAccountEntry() START", new Object[0]);
    try
    {
      if (StringUtility.isNullOrEmpty(paramString1)) {
        throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
      }
    }
    finally
    {
      Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.ensureAccountEntry() FINISHED", new Object[0]);
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'userDeviceId' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString3)) {
      throw new IllegalArgumentException("'accountName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString4)) {
      throw new IllegalArgumentException("'providerFilter' cannot be NULL or empty");
    }
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'timestamp' must be greater than zero");
    }
    synchronized (this._databaseAccessLock)
    {
      if (!checkForAccountEntry(paramString1))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("userAccessId", paramString1);
        localContentValues.put("userDeviceId", paramString2);
        localContentValues.put("accountName", paramString3);
        localContentValues.put("providerFilter", paramString4);
        localContentValues.put("timestampLastAuth", Long.valueOf(paramLong));
        localContentValues.put("timestampCreated", Long.valueOf(paramLong));
        if (getWritableDatabase().insert("account", null, localContentValues) >= 0L)
        {
          Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.ensureAccountEntry() inserted [userAccessId:%1$s userDeviceId:%2$s accountName:'%3$s' providerFilter:%4$s timestampLastAuth:%5$d timestampCreated:%6$d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), Long.valueOf(paramLong) });
          trimLruEntriesAccountInfo();
        }
      }
      else
      {
        Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.ensureAccountEntry() FINISHED", new Object[0]);
        return;
      }
      Logger.e(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.ensureAccountEntry() failed to insert [userAccessId:%1$s userDeviceId:%2$s accountName:'%3$s' providerFilter:%4$s timestampLastAuth:%5$d timestampCreated:%6$d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), Long.valueOf(paramLong) });
    }
  }
  
  /* Error */
  protected AccountHistoryInfo getAccount(String paramString)
  {
    // Byte code:
    //   0: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 260
    //   16: iconst_0
    //   17: anewarray 52	java/lang/Object
    //   20: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: invokestatic 65	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   27: ifeq +40 -> 67
    //   30: new 67	java/lang/IllegalArgumentException
    //   33: dup
    //   34: ldc_w 262
    //   37: invokespecial 72	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: astore_1
    //   42: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   45: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   48: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   51: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   54: lor
    //   55: ldc_w 264
    //   58: iconst_0
    //   59: anewarray 52	java/lang/Object
    //   62: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: invokevirtual 76	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   71: ldc 23
    //   73: aconst_null
    //   74: ldc -49
    //   76: iconst_1
    //   77: anewarray 40	java/lang/String
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokevirtual 145	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 268 1 0
    //   97: ifeq +43 -> 140
    //   100: new 270	com/getjar/sdk/comm/auth/AccountHistoryInfo
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 273	com/getjar/sdk/comm/auth/AccountHistoryInfo:<init>	(Landroid/database/Cursor;)V
    //   108: astore_2
    //   109: aload_1
    //   110: invokeinterface 162 1 0
    //   115: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   118: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   121: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   124: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   127: lor
    //   128: ldc_w 264
    //   131: iconst_0
    //   132: anewarray 52	java/lang/Object
    //   135: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   138: aload_2
    //   139: areturn
    //   140: aload_1
    //   141: invokeinterface 162 1 0
    //   146: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   149: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   152: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   155: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   158: lor
    //   159: ldc_w 264
    //   162: iconst_0
    //   163: anewarray 52	java/lang/Object
    //   166: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_2
    //   172: aload_1
    //   173: invokeinterface 162 1 0
    //   178: aload_2
    //   179: athrow
    //   180: astore_1
    //   181: goto -66 -> 115
    //   184: astore_1
    //   185: goto -39 -> 146
    //   188: astore_1
    //   189: goto -11 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	AccountHistoryDatabase
    //   0	192	1	paramString	String
    //   108	31	2	localAccountHistoryInfo	AccountHistoryInfo
    //   171	8	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	41	41	finally
    //   67	91	41	finally
    //   109	115	41	finally
    //   140	146	41	finally
    //   172	178	41	finally
    //   178	180	41	finally
    //   91	109	171	finally
    //   109	115	180	java/lang/Exception
    //   140	146	184	java/lang/Exception
    //   172	178	188	java/lang/Exception
  }
  
  /* Error */
  protected java.util.List<AccountHistoryInfo> getAccounts()
  {
    // Byte code:
    //   0: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 277
    //   16: iconst_0
    //   17: anewarray 52	java/lang/Object
    //   20: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: new 279	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 280	java/util/ArrayList:<init>	()V
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 76	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: ldc 23
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: ldc -14
    //   44: invokevirtual 145	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 268 1 0
    //   54: ifeq +56 -> 110
    //   57: aload_1
    //   58: new 270	com/getjar/sdk/comm/auth/AccountHistoryInfo
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 273	com/getjar/sdk/comm/auth/AccountHistoryInfo:<init>	(Landroid/database/Cursor;)V
    //   66: invokeinterface 286 2 0
    //   71: pop
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: aload_2
    //   77: invokeinterface 162 1 0
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   88: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   91: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   94: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   97: lor
    //   98: ldc_w 288
    //   101: iconst_0
    //   102: anewarray 52	java/lang/Object
    //   105: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: athrow
    //   110: aload_2
    //   111: invokeinterface 162 1 0
    //   116: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   119: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   122: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   125: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   128: lor
    //   129: ldc_w 288
    //   132: iconst_0
    //   133: anewarray 52	java/lang/Object
    //   136: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_1
    //   140: areturn
    //   141: astore_2
    //   142: goto -26 -> 116
    //   145: astore_2
    //   146: goto -64 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	AccountHistoryDatabase
    //   30	28	1	localArrayList	java.util.ArrayList
    //   75	8	1	localObject	Object
    //   84	56	1	localList	java.util.List<AccountHistoryInfo>
    //   47	64	2	localCursor	android.database.Cursor
    //   141	1	2	localException1	Exception
    //   145	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	72	75	finally
    //   23	48	84	finally
    //   76	82	84	finally
    //   82	84	84	finally
    //   110	116	84	finally
    //   110	116	141	java/lang/Exception
    //   76	82	145	java/lang/Exception
  }
  
  /* Error */
  public String getCurrentAccountName()
  {
    // Byte code:
    //   0: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 296
    //   16: iconst_0
    //   17: anewarray 52	java/lang/Object
    //   20: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_0
    //   24: invokevirtual 76	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: ldc_w 298
    //   30: invokevirtual 94	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   33: astore_3
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual 301	android/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   47: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   50: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   53: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   56: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   59: lor
    //   60: ldc_w 303
    //   63: iconst_0
    //   64: anewarray 52	java/lang/Object
    //   67: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_1
    //   71: areturn
    //   72: astore_2
    //   73: aload_3
    //   74: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   77: goto -30 -> 47
    //   80: astore_1
    //   81: aload_3
    //   82: invokevirtual 107	android/database/sqlite/SQLiteStatement:close	()V
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   91: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   94: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   97: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   100: lor
    //   101: ldc_w 303
    //   104: iconst_0
    //   105: anewarray 52	java/lang/Object
    //   108: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: athrow
    //   113: astore_2
    //   114: goto -67 -> 47
    //   117: astore_2
    //   118: goto -71 -> 47
    //   121: astore_2
    //   122: goto -37 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	AccountHistoryDatabase
    //   35	36	1	localObject1	Object
    //   80	6	1	localObject2	Object
    //   87	25	1	localObject3	Object
    //   40	2	2	str	String
    //   72	1	2	localSQLiteDoneException	android.database.sqlite.SQLiteDoneException
    //   113	1	2	localException1	Exception
    //   117	1	2	localException2	Exception
    //   121	1	2	localException3	Exception
    //   33	49	3	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   36	41	72	android/database/sqlite/SQLiteDoneException
    //   36	41	80	finally
    //   23	34	87	finally
    //   43	47	87	finally
    //   73	77	87	finally
    //   81	85	87	finally
    //   85	87	87	finally
    //   43	47	113	java/lang/Exception
    //   73	77	117	java/lang/Exception
    //   81	85	121	java/lang/Exception
  }
  
  /* Error */
  protected java.util.List<AccountHistoryEvent> getEvents()
  {
    // Byte code:
    //   0: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 306
    //   16: iconst_0
    //   17: anewarray 52	java/lang/Object
    //   20: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: new 279	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 280	java/util/ArrayList:<init>	()V
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 76	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: ldc 20
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: ldc -74
    //   44: invokevirtual 145	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 268 1 0
    //   54: ifeq +56 -> 110
    //   57: aload_1
    //   58: new 308	com/getjar/sdk/comm/auth/AccountHistoryEvent
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 309	com/getjar/sdk/comm/auth/AccountHistoryEvent:<init>	(Landroid/database/Cursor;)V
    //   66: invokeinterface 286 2 0
    //   71: pop
    //   72: goto -24 -> 48
    //   75: astore_1
    //   76: aload_2
    //   77: invokeinterface 162 1 0
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   88: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   91: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   94: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   97: lor
    //   98: ldc_w 311
    //   101: iconst_0
    //   102: anewarray 52	java/lang/Object
    //   105: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: athrow
    //   110: aload_2
    //   111: invokeinterface 162 1 0
    //   116: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   119: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   122: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   125: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   128: lor
    //   129: ldc_w 311
    //   132: iconst_0
    //   133: anewarray 52	java/lang/Object
    //   136: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_1
    //   140: areturn
    //   141: astore_2
    //   142: goto -26 -> 116
    //   145: astore_2
    //   146: goto -64 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	AccountHistoryDatabase
    //   30	28	1	localArrayList	java.util.ArrayList
    //   75	8	1	localObject	Object
    //   84	56	1	localList	java.util.List<AccountHistoryEvent>
    //   47	64	2	localCursor	android.database.Cursor
    //   141	1	2	localException1	Exception
    //   145	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	72	75	finally
    //   23	48	84	finally
    //   76	82	84	finally
    //   82	84	84	finally
    //   110	116	84	finally
    //   110	116	141	java/lang/Exception
    //   76	82	145	java/lang/Exception
  }
  
  /* Error */
  protected java.util.List<AccountHistoryEvent> getEvents(String paramString)
  {
    // Byte code:
    //   0: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   3: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   6: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   9: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   12: lor
    //   13: ldc_w 315
    //   16: iconst_0
    //   17: anewarray 52	java/lang/Object
    //   20: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_1
    //   24: invokestatic 65	com/getjar/sdk/utilities/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   27: ifeq +40 -> 67
    //   30: new 67	java/lang/IllegalArgumentException
    //   33: dup
    //   34: ldc_w 262
    //   37: invokespecial 72	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: astore_1
    //   42: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   45: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   48: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   51: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   54: lor
    //   55: ldc_w 317
    //   58: iconst_0
    //   59: anewarray 52	java/lang/Object
    //   62: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_1
    //   66: athrow
    //   67: new 279	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 280	java/util/ArrayList:<init>	()V
    //   74: astore_2
    //   75: aload_0
    //   76: invokevirtual 76	com/getjar/sdk/comm/auth/AccountHistoryDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   79: ldc 20
    //   81: aconst_null
    //   82: ldc -49
    //   84: iconst_1
    //   85: anewarray 40	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: aload_1
    //   91: aastore
    //   92: aconst_null
    //   93: aconst_null
    //   94: ldc -74
    //   96: invokevirtual 145	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore_1
    //   100: aload_1
    //   101: invokeinterface 268 1 0
    //   106: ifeq +30 -> 136
    //   109: aload_2
    //   110: new 308	com/getjar/sdk/comm/auth/AccountHistoryEvent
    //   113: dup
    //   114: aload_1
    //   115: invokespecial 309	com/getjar/sdk/comm/auth/AccountHistoryEvent:<init>	(Landroid/database/Cursor;)V
    //   118: invokeinterface 286 2 0
    //   123: pop
    //   124: goto -24 -> 100
    //   127: astore_2
    //   128: aload_1
    //   129: invokeinterface 162 1 0
    //   134: aload_2
    //   135: athrow
    //   136: aload_1
    //   137: invokeinterface 162 1 0
    //   142: getstatic 113	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   145: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   148: getstatic 192	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   151: invokevirtual 116	com/getjar/sdk/logging/Area:value	()J
    //   154: lor
    //   155: ldc_w 317
    //   158: iconst_0
    //   159: anewarray 52	java/lang/Object
    //   162: invokestatic 179	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_2
    //   166: areturn
    //   167: astore_1
    //   168: goto -26 -> 142
    //   171: astore_1
    //   172: goto -38 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	AccountHistoryDatabase
    //   0	175	1	paramString	String
    //   74	36	2	localArrayList	java.util.ArrayList
    //   127	39	2	localList	java.util.List<AccountHistoryEvent>
    // Exception table:
    //   from	to	target	type
    //   23	41	41	finally
    //   67	100	41	finally
    //   128	134	41	finally
    //   134	136	41	finally
    //   136	142	41	finally
    //   100	124	127	finally
    //   136	142	167	java/lang/Exception
    //   128	134	171	java/lang/Exception
  }
  
  protected void insertEvent(String paramString, AccountEventType paramAccountEventType, long paramLong)
  {
    Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.insertEvent() START", new Object[0]);
    try
    {
      if (StringUtility.isNullOrEmpty(paramString)) {
        throw new IllegalArgumentException("'userAccessId' cannot be NULL or empty");
      }
    }
    finally
    {
      Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.insertEvent() FINISHED", new Object[0]);
    }
    if (paramAccountEventType == null) {
      throw new IllegalArgumentException("'eventType' cannot be NULL");
    }
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'timestamp' must be greater than zero");
    }
    synchronized (this._databaseAccessLock)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("userAccessId", paramString);
      localContentValues.put("eventType", paramAccountEventType.name());
      localContentValues.put("timestamp", Long.valueOf(paramLong));
      if (getWritableDatabase().insert("accountEvent", null, localContentValues) >= 0L)
      {
        Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.insertEvent() inserted [userAccessId:%1$s eventType:%2$s timestamp:%3$d]", new Object[] { paramString, paramAccountEventType.name(), Long.valueOf(paramLong) });
        if (paramAccountEventType.isAuthEvent()) {
          updateAccountLastAuth(paramString, paramLong);
        }
        trimLruEntriesAccountEvent();
        Logger.v(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.insertEvent() FINISHED", new Object[0]);
        return;
      }
      Logger.e(Area.STORAGE.value() | Area.AUTH.value(), "AccountHistoryDatabase.insertEvent() failed to insert [userAccessId:%1$s eventType:%2$s timestamp:%3$d]", new Object[] { paramString, paramAccountEventType.name(), Long.valueOf(paramLong) });
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this._databaseAccessLock)
    {
      String[] arrayOfString = DB_CREATE_TABLE_COMMANDS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.execSQL(arrayOfString[i]);
        i += 1;
      }
      return;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    synchronized (this._databaseAccessLock)
    {
      Logger.d(Area.USAGE.value() | Area.STORAGE.value(), "Upgrading database '%1$s' from version %2$d to %3$d, which will destroy all old data", new Object[] { "GetJarDBAccountHistory", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      String[] arrayOfString = DB_TABLE_NAMES;
      paramInt2 = arrayOfString.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        String str = arrayOfString[paramInt1];
        paramSQLiteDatabase.execSQL(String.format(Locale.US, "DROP TABLE IF EXISTS %1$s", new Object[] { str }));
        paramInt1 += 1;
      }
      arrayOfString = DB_CREATE_TABLE_COMMANDS;
      paramInt2 = arrayOfString.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramSQLiteDatabase.execSQL(arrayOfString[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AccountHistoryDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */