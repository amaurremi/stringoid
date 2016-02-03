package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class go
        extends SQLiteOpenHelper {
    public go(gn paramgn, Context paramContext, String paramString) {
        super(paramContext, paramString, null, 4);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        paramSQLiteDatabase.execSQL(gn.d());
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        mx.c("Database updated from version " + paramInt1 + " to version " + paramInt2);
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        onCreate(paramSQLiteDatabase);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */