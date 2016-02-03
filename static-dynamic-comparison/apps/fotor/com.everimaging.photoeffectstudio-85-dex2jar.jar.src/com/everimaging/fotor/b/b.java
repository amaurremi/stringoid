package com.everimaging.fotor.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

public class b
        extends SQLiteOpenHelper {
    private static final String a = b.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);

    public b(Context paramContext) {
        super(paramContext, "fotor_pes", null, 4);
    }

    public void a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
        Class[] arrayOfClass = c.d();
        int i = 0;
        for (; ; ) {
            if (i < arrayOfClass.length) {
                try {
                    c localc = (c) arrayOfClass[i].newInstance();
                    if (TextUtils.isEmpty(paramString)) {
                        paramSQLiteDatabase.execSQL(localc.c());
                    } else {
                        paramSQLiteDatabase.execSQL(paramString + localc.a());
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
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
        b.c(new Object[]{a, "onUpgrade oldVersion:" + paramInt1 + ",newVersion:" + paramInt2});
        switch (paramInt1) {
            case 1:
            default:
                return;
        }
        a(paramSQLiteDatabase, "");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */