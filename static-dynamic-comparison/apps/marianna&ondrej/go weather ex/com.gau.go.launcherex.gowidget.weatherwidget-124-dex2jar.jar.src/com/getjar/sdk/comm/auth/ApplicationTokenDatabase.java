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
import java.util.UUID;

public class ApplicationTokenDatabase
  extends SQLiteOpenHelper
{
  private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS applicationKey (applicationKey TEXT NOT NULL UNIQUE);";
  private static final String DATABASE_NAME = "GetJarDBApplicationKey";
  private static final String DATABASE_TABLE = "applicationKey";
  private static final int DATABASE_VERSION = 1;
  private static volatile ApplicationTokenDatabase _Instance = null;
  private volatile Object _databaseAccessLock = new Object();
  
  private ApplicationTokenDatabase(Context paramContext)
  {
    super(paramContext, "GetJarDBApplicationKey", null, 1);
  }
  
  public static ApplicationTokenDatabase getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new ApplicationTokenDatabase(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
  }
  
  private long getRecordCount()
  {
    localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s", new Object[] { "applicationKey" }));
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
  
  /* Error */
  public String getApplicationToken()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:_databaseAccessLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: invokevirtual 49	com/getjar/sdk/comm/auth/ApplicationTokenDatabase:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: ldc 14
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 100	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 106 1 0
    //   31: ifeq +11 -> 42
    //   34: aload_3
    //   35: iconst_0
    //   36: invokeinterface 110 2 0
    //   41: astore_1
    //   42: aload_3
    //   43: invokeinterface 111 1 0
    //   48: getstatic 83	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   51: invokevirtual 86	com/getjar/sdk/logging/Area:value	()J
    //   54: ldc 113
    //   56: iconst_1
    //   57: anewarray 33	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: invokestatic 117	com/getjar/sdk/logging/Logger:v	(JLjava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: astore_3
    //   72: getstatic 83	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   75: invokevirtual 86	com/getjar/sdk/logging/Area:value	()J
    //   78: aload_3
    //   79: ldc 119
    //   81: iconst_0
    //   82: anewarray 33	java/lang/Object
    //   85: invokestatic 94	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: goto -40 -> 48
    //   91: astore_1
    //   92: aload_2
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_3
    //   98: invokeinterface 111 1 0
    //   103: aload_1
    //   104: athrow
    //   105: astore_3
    //   106: getstatic 83	com/getjar/sdk/logging/Area:STORAGE	Lcom/getjar/sdk/logging/Area;
    //   109: invokevirtual 86	com/getjar/sdk/logging/Area:value	()J
    //   112: aload_3
    //   113: ldc 119
    //   115: iconst_0
    //   116: anewarray 33	java/lang/Object
    //   119: invokestatic 94	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: goto -19 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ApplicationTokenDatabase
    //   8	62	1	str	String
    //   91	4	1	localObject1	Object
    //   96	8	1	localObject2	Object
    //   4	89	2	localObject3	Object
    //   24	19	3	localCursor	android.database.Cursor
    //   71	27	3	localException1	Exception
    //   105	8	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   42	48	71	java/lang/Exception
    //   9	25	91	finally
    //   42	48	91	finally
    //   48	69	91	finally
    //   72	88	91	finally
    //   92	94	91	finally
    //   97	103	91	finally
    //   103	105	91	finally
    //   106	122	91	finally
    //   25	42	96	finally
    //   97	103	105	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    synchronized (this._databaseAccessLock)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS applicationKey (applicationKey TEXT NOT NULL UNIQUE);");
      return;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    synchronized (this._databaseAccessLock)
    {
      Logger.d(Area.STORAGE.value(), "Upgrading database '%1$s' from version %2$d to %3$d, which will destroy all old data", new Object[] { "GetJarDBApplicationKey", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS applicationKey");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS applicationKey (applicationKey TEXT NOT NULL UNIQUE);");
      return;
    }
  }
  
  public void setApplicationToken(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'applicationToken' cannot be NULL or empty");
    }
    if (paramString.length() != 36) {
      throw new IllegalArgumentException("'applicationToken' must be 36 characters long");
    }
    UUID.fromString(paramString);
    synchronized (this._databaseAccessLock)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("applicationKey", paramString);
      if (getRecordCount() > 0L)
      {
        getWritableDatabase().update("applicationKey", localContentValues, null, null);
        Logger.v(Area.STORAGE.value(), "ApplicationTokenDatabase: setApplicationToken() Update [%1$s]", new Object[] { paramString });
        return;
      }
      getWritableDatabase().insert("applicationKey", null, localContentValues);
      Logger.v(Area.STORAGE.value(), "ApplicationTokenDatabase: setApplicationToken() Insert [%1$s]", new Object[] { paramString });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/ApplicationTokenDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */