package com.quoord.tapatalkpro.sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ForumSearchSqlHelper
        extends SQLiteOpenHelper {
    private static final String CREATETABLE = "CREATE TABLE IF NOT EXISTS searchqurey (query VARCHAR);";
    private static final String QUERY = "query";
    private static final String TABLE_NAME = "searchqurey";
    private static final int countLimit = 20;

    public ForumSearchSqlHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
        super(paramContext, paramString, paramCursorFactory, paramInt);
    }

    public ForumSearchSqlHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler) {
        super(paramContext, paramString, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
    }

    private int getHistoryCount() {
        SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
        Cursor localCursor = localSQLiteDatabase.rawQuery("select count(*) from searchqurey", null);
        int i = localCursor.getColumnIndex(localCursor.getColumnNames()[0]);
        localCursor.moveToNext();
        i = localCursor.getInt(i);
        localCursor.close();
        localSQLiteDatabase.close();
        return i;
    }

    public void add() {
        int i = 0;
        for (; ; ) {
            if (i >= 20) {
                return;
            }
            saveQuery(i);
            i += 1;
        }
    }

    public Cursor getHistory() {
        return getReadableDatabase().query("searchqurey", new String[]{"query"}, null, null, null, null, null);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS searchqurey (query VARCHAR);");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    }

    public void saveQuery(String paramString) {
        SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("query", paramString);
        localSQLiteDatabase.insert("searchqurey", null, localContentValues);
        localSQLiteDatabase.close();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/sqlhelper/ForumSearchSqlHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */