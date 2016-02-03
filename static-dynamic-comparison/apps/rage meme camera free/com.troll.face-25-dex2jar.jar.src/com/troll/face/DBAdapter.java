package com.troll.face;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter
{
  private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS displaymessages (ID integer primary key autoincrement,state text not null, flag text not null);";
  private static final String DATABASE_NAME = "ragememecamera";
  private static final String DATABASE_TABLE = "displaymessages";
  private static final int DATABASE_VERSION = 17;
  private static final String FLAG = "flag";
  public static final String STATE = "state";
  private DatabaseHelper DBHelper;
  private final Context context;
  private SQLiteDatabase db;
  
  public DBAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.DBHelper = new DatabaseHelper(this.context);
    this.db = this.DBHelper.getWritableDatabase();
  }
  
  public void close()
  {
    this.DBHelper.close();
  }
  
  public boolean deleteMessage(String paramString)
  {
    return this.db.delete("displaymessages", "state=" + paramString, null) > 0;
  }
  
  public Cursor getAllMessage()
  {
    return this.db.query("displaymessages", new String[] { "state", "flag" }, null, null, null, null, null);
  }
  
  public Cursor getMessage(String paramString)
    throws SQLException
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    paramString = "state='" + paramString + "'";
    paramString = localSQLiteDatabase.query("displaymessages", new String[] { "state", "flag" }, paramString, null, null, null, null);
    if (paramString != null) {
      paramString.moveToFirst();
    }
    return paramString;
  }
  
  public long insertMessage(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("state", paramString2);
    localContentValues.put("flag", paramString1);
    return this.db.insert("displaymessages", null, localContentValues);
  }
  
  public boolean updateMessage(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("flag", paramString2);
    return this.db.update("displaymessages", localContentValues, "state=" + paramString1, null) > 0;
  }
  
  private static class DatabaseHelper
    extends SQLiteOpenHelper
  {
    DatabaseHelper(Context paramContext)
    {
      super("ragememecamera", null, 17);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS displaymessages (ID integer primary key autoincrement,state text not null, flag text not null);");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.w("", "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS displaymessages");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/DBAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */