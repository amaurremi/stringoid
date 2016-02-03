/*    */
package android.database.sqlite;
/*    */

import android.content.Context;

/*    */
/*  4 */ public abstract class SQLiteOpenHelper {
    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, android.database.DatabaseErrorHandler errorHandler) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public String getDatabaseName() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public SQLiteDatabase getWritableDatabase() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public SQLiteDatabase getReadableDatabase() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public synchronized void close() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onConfigure(SQLiteDatabase db) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);

    /*    */
    public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);

    /* 14 */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onOpen(SQLiteDatabase db) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteOpenHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */