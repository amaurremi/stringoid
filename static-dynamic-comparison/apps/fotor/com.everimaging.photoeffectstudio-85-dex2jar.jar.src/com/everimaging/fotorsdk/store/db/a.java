package com.everimaging.fotorsdk.store.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class a
        extends SQLiteOpenHelper {
    private static final String a = a.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);

    public a(Context paramContext) {
        super(paramContext, "com.everimaing.fotorsdk.store.sqlite", null, 1);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        b.a(paramSQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        b.c(new Object[]{"onUpgrade oldVersion:" + paramInt1 + ",newVersion:" + paramInt2});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/db/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */