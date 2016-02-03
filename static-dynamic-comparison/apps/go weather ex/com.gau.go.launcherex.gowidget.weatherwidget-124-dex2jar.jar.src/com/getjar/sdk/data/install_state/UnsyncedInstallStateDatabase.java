package com.getjar.sdk.data.install_state;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.AlarmsUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;

class UnsyncedInstallStateDatabase
  extends InstallStateDatabase<InstallStateRecord>
{
  private static final String DATABASE_NAME_PREFIX = "GetJarDBUnsyncedInstallState";
  private static final String DATABASE_TABLE = "installState";
  private static final int DATABASE_VERSION = 2;
  private static int LRU_CAP = 1000;
  private static volatile UnsyncedInstallStateDatabase _Instance = null;
  
  private UnsyncedInstallStateDatabase(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
    Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: Opened user specific database '%1$s%2$d'", new Object[] { "GetJarDBUnsyncedInstallState", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) });
  }
  
  public static UnsyncedInstallStateDatabase getInstance()
  {
    try
    {
      if (_Instance == null) {
        throw new IllegalStateException("initialize() must be called first");
      }
    }
    finally {}
    UnsyncedInstallStateDatabase localUnsyncedInstallStateDatabase = _Instance;
    return localUnsyncedInstallStateDatabase;
  }
  
  public static void initialize(Context paramContext)
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
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: waitForUserAccess() START [%1$s]", new Object[] { Logger.getShortStack() });
      AuthManager.initialize(paramContext);
      AuthManager.getInstance().waitOnAuth();
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: waitForUserAccess() DONE", new Object[0]);
      if (StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserAccessId())) {
        throw new IllegalStateException("Must have a user access ID");
      }
      _Instance = new UnsyncedInstallStateDatabase(paramContext, String.format(Locale.US, "%1$s%2$d", new Object[] { "GetJarDBUnsyncedInstallState", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) }));
    }
  }
  
  protected long addRecord(String paramString, long paramLong, InstallStateManager.InstallState paramInstallState)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramInstallState != null)
    {
      synchronized (this._databaseAccessLock)
      {
        if (StringUtility.isNullOrEmpty(paramString)) {
          throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
        }
      }
      if (!checkForRecord(paramString)) {
        break label107;
      }
      Logger.v(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: Preexisting record found for '%1$s'", new Object[] { paramString });
      paramLong = l2;
    }
    for (;;)
    {
      l1 = paramLong;
      if (paramLong != -1L)
      {
        trimLruEntries();
        l1 = paramLong;
      }
      return l1;
      label107:
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("packageName", paramString);
      localContentValues.put("timestamp", Long.valueOf(paramLong));
      localContentValues.put("status", paramInstallState.name());
      paramLong = getWritableDatabase().insert("installState", null, localContentValues);
      Logger.v(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: Added a %1$s record for '%2$s'", new Object[] { paramInstallState.name(), paramString });
    }
  }
  
  public boolean checkForRecord(String paramString)
  {
    boolean bool = true;
    localObject = null;
    try
    {
      SQLiteStatement localSQLiteStatement = getReadableDatabase().compileStatement(String.format(Locale.US, "SELECT count(*) FROM %1$s WHERE packageName = ?", new Object[] { "installState" }));
      localObject = localSQLiteStatement;
      localSQLiteStatement.bindString(1, paramString);
      localObject = localSQLiteStatement;
      long l = localSQLiteStatement.simpleQueryForLong();
      if (l > 0L) {}
      for (;;)
      {
        if (localSQLiteStatement != null) {}
        try
        {
          localSQLiteStatement.close();
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
        ((SQLiteStatement)localObject).close();
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
      if (localObject == null) {}
    }
  }
  
  public InstallStateRecord getInstallRecord(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'id' cannot be less than 0");
    }
    Cursor localCursor = getReadableDatabase().query("installState", null, "id = ?", new String[] { Long.toString(paramLong) }, null, null, null);
    InstallStateRecord localInstallStateRecord = null;
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      localInstallStateRecord = loadFromDB(localCursor);
      localCursor.close();
    }
    return localInstallStateRecord;
  }
  
  protected int getLRUCap()
  {
    return LRU_CAP;
  }
  
  protected String getTableCreateSQL()
  {
    return "CREATE TABLE IF NOT EXISTS installState (id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT NOT NULL UNIQUE, timestamp INTEGER NOT NULL, status TEXT NOT NULL );";
  }
  
  protected String getTableName()
  {
    return "installState";
  }
  
  public InstallStateRecord loadFromDB(Cursor paramCursor)
  {
    return InstallStateRecord.loadFromDB(paramCursor);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    super.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    AlarmsUtility.clearLastRunTimestampUsageReporting(this._context);
  }
  
  public void updateState(long paramLong, InstallStateManager.InstallState paramInstallState)
  {
    if (paramInstallState == null) {
      throw new IllegalArgumentException("'installState' cannot be NULL");
    }
    synchronized (this._databaseAccessLock)
    {
      if (checkForRecord(paramLong))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("status", paramInstallState.name());
        getWritableDatabase().update("installState", localContentValues, String.format(Locale.US, "id = %1$d", new Object[] { Long.valueOf(paramLong) }), null);
        return;
      }
      Logger.w(Area.USAGE.value() | Area.STORAGE.value(), "UnsyncedInstallStateDatabase: updateState() failed to find record %1$d", new Object[] { Long.valueOf(paramLong) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/UnsyncedInstallStateDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */