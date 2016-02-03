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

class SyncedInstallStateDatabase
  extends InstallStateDatabase<InstallStateRecord>
{
  private static final String DATABASE_NAME_PREFIX = "GetJarDBSyncedInstallState";
  private static final String DATABASE_TABLE = "installState";
  private static final int DATABASE_VERSION = 2;
  private static int LRU_CAP = 1000;
  private static volatile SyncedInstallStateDatabase _Instance = null;
  
  private SyncedInstallStateDatabase(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 2);
    Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "SyncedInstallStateDatabase: Opened user specific database '%1$s%2$d'", new Object[] { "GetJarDBSyncedInstallState", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) });
  }
  
  private boolean checkForRecord(String paramString)
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
  
  public static SyncedInstallStateDatabase getInstance()
  {
    try
    {
      if (_Instance == null) {
        throw new IllegalStateException("initialize() must be called first");
      }
    }
    finally {}
    SyncedInstallStateDatabase localSyncedInstallStateDatabase = _Instance;
    return localSyncedInstallStateDatabase;
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
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "SyncedInstallStateDatabase: waitForUserAccess() START [%1$s]", new Object[] { Logger.getShortStack() });
      AuthManager.initialize(paramContext);
      AuthManager.getInstance().waitOnAuth();
      Logger.i(Area.USAGE.value() | Area.STORAGE.value(), "SyncedInstallStateDatabase: waitForUserAccess() DONE", new Object[0]);
      if (StringUtility.isNullOrEmpty(AuthManager.getInstance().getUserAccessId())) {
        throw new IllegalStateException("Must have a user access ID");
      }
      _Instance = new SyncedInstallStateDatabase(paramContext, String.format(Locale.US, "%1$s%2$d", new Object[] { "GetJarDBSyncedInstallState", Integer.valueOf(AuthManager.getInstance().getUserAccessId().hashCode()) }));
    }
  }
  
  public void addRecord(InstallStateRecord paramInstallStateRecord)
  {
    if (paramInstallStateRecord == null) {
      throw new IllegalArgumentException("'record' cannot be null");
    }
    synchronized (this._databaseAccessLock)
    {
      String str = paramInstallStateRecord.getPackageName();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("packageName", str);
      localContentValues.put("timestamp", Long.valueOf(paramInstallStateRecord.getTimestamp()));
      localContentValues.put("status", paramInstallStateRecord.getStatus().name());
      if (checkForRecord(str))
      {
        getWritableDatabase().update(getTableName(), localContentValues, "packageName = ?", new String[] { str });
        trimLruEntries();
        Logger.v(Area.USAGE.value() | Area.STORAGE.value(), "SyncedInstallStateDatabase: Added a FOUND_INSTALLED record for '%1$s'", new Object[] { paramInstallStateRecord.getPackageName() });
        return;
      }
      getWritableDatabase().insert("installState", null, localContentValues);
    }
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
  
  protected InstallStateRecord loadFromDB(Cursor paramCursor)
  {
    return InstallStateRecord.loadFromDB(paramCursor);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    super.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    AlarmsUtility.clearLastRunTimestampUsageReporting(this._context);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/install_state/SyncedInstallStateDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */