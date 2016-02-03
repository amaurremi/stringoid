package android.database;

import android.database.sqlite.SQLiteDatabase;

public abstract interface DatabaseErrorHandler {
    public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/DatabaseErrorHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */