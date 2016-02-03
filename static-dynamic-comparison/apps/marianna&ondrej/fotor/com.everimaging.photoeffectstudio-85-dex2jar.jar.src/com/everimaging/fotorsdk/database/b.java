package com.everimaging.fotorsdk.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class b
        extends SQLiteOpenHelper {
    private static final String a = b.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);

    public b(Context paramContext) {
        super(paramContext, "com.everimaing.fotorsdk.sqlite", null, 1);
    }

    public void a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
        Class[] arrayOfClass = c.getSubClasses();
        int i = 0;
        for (; ; ) {
            if (i < arrayOfClass.length) {
                try {
                    c localc = (c) arrayOfClass[i].newInstance();
                    if (TextUtils.isEmpty(paramString)) {
                        paramSQLiteDatabase.execSQL(localc.getTableCreateor());
                    } else {
                        paramSQLiteDatabase.execSQL(paramString + localc.getTableName());
                    }
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }
            return;
            i += 1;
        }
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
        a(paramSQLiteDatabase, "");
        paramSQLiteDatabase.execSQL(String.format("CREATE TRIGGER delete_actions BEFORE DELETE ON %s BEGIN DELETE FROM %s WHERE %s.%s = old.%s; END", new Object[]{"sessions", "actions", "actions", "session_id", "session_id"}));
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        b.c(new Object[]{"onUpgrade oldVersion:" + paramInt1 + ",newVersion:" + paramInt2});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/database/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */